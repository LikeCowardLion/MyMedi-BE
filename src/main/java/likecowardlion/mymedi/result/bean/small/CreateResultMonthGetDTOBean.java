package likecowardlion.mymedi.result.bean.small;

import likecowardlion.mymedi.game.bean.small.GetGameDAOBean;
import likecowardlion.mymedi.game.domain.GameDAO;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultMonthDetailGetDTO;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultMonthGetDTO;
import likecowardlion.mymedi.result.domain.ResultDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateResultMonthGetDTOBean {

    GetGameDAOBean getGameDAOBean;

    @Autowired
    public CreateResultMonthGetDTOBean(GetGameDAOBean getGameDAOBean){
        this.getGameDAOBean = getGameDAOBean;
    }



    // DTO 생성해 반환
    public List<ResponseResultMonthGetDTO> exec(List<ResultDAO> daoList){

        // DTO 리스트 생성해 초기 값 설정
        List<ResponseResultMonthGetDTO> dtoList = new ArrayList<>();
        for (int i=1; i<=31; i++){
            dtoList.add(ResponseResultMonthGetDTO.builder().date(i).dayResultCount(0).detailResultList(new ArrayList<>()).build());
        }

        // 입력 받은 daoList에서 하나씩 꺼내서 처리 후 DTO 리스트에 반영
        for (ResultDAO dao : daoList){

            // 결과 DAO의 날짜 확인
            int date = dao.getStartedAt().getDayOfMonth();
            
            // 결과 DAO의 gameId로 GameDAO 검색
            GameDAO gameDao = getGameDAOBean.exec(dao.getGameId());

            // 결과 DAO의 LocalDateTime을 Integer로 변환
            Integer startHour = dao.getStartedAt().getHour();
            Integer startMinute = dao.getStartedAt().getMinute();
            Integer finishHour = dao.getFinishedAt().getHour();
            Integer finishMinute = dao.getFinishedAt().getMinute();

            // DetailDTO 생성
            ResponseResultMonthDetailGetDTO detailDto = ResponseResultMonthDetailGetDTO.builder()
                    .title(gameDao.getTitle())
                    .category(gameDao.getCategory().name())
                    .startedAt(String.format("%02d:%02d", startHour, startMinute))
                    .finishedAt(String.format("%02d:%02d", finishHour, finishMinute))
                    .build();


            // 생성한 DetailDTO를 DTO 리스트[해당 날짜]의 detailResultList에 추가
            List<ResponseResultMonthDetailGetDTO> newDetailList = dtoList.get(date-1).getDetailResultList();
            newDetailList.add(detailDto);
            dtoList.get(date-1).setDetailResultList(newDetailList);
            
            // DTO 리스트[해당날짜]의 결과 수 증가
            dtoList.get(date-1).setDayResultCount(dtoList.get(date-1).getDayResultCount()+1);

        }

        // DTO 리스트 반환
        return dtoList;

    }

}
