package likecowardlion.mymedi.result.bean.small;

import likecowardlion.mymedi.result.domain.DTO.ResponseResultWeekGetDTO;
import likecowardlion.mymedi.result.domain.ResultDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateResultWeekGetDTOBean {

    // DAO로 DTO 생성해 반환
    public List<ResponseResultWeekGetDTO> exec(List<ResultDAO> daoList){

        // 반환할 DTO 리스트 생성
        List<ResponseResultWeekGetDTO> dtoList = new ArrayList<>();

        // daoList에서 하나씩 꺼내
        for (ResultDAO dao : daoList){

            // DAO의 LocalDateTime을 Integer로 변환
            Integer dateMonth = dao.getStartedAt().getMonthValue();
            Integer dateDay = dao.getStartedAt().getDayOfMonth();

            // DAO로 DTO 생성해 dtoList에 적재
            dtoList.add(ResponseResultWeekGetDTO.builder()
                    .date(String.format("%02d/%02d", dateMonth, dateDay))
                    .bestScore(dao.getScore())
                    .build());
            
            // 7일의 결과가 모두 적재된 경우 반복문 종료
            if (dtoList.size() == 7) break;
            
        }

        // DTO 리스트 반환
        return dtoList;

    }
}
