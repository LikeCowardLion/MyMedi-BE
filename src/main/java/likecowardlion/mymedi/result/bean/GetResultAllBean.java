package likecowardlion.mymedi.result.bean;

import likecowardlion.mymedi.result.bean.small.GetResultDAOBean;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultAllGetDTO;
import likecowardlion.mymedi.result.domain.ResultDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetResultAllBean {

    GetResultDAOBean getResultDAOBean;

    @Autowired
    public GetResultAllBean(GetResultDAOBean getResultDAOBean){
        this.getResultDAOBean = getResultDAOBean;
    }

    public List<ResponseResultAllGetDTO> exec(){

        // 결과 DAO 전체 조회
        List<ResultDAO> daoList = getResultDAOBean.exec();

        // DTO 리스트 생성
        List<ResponseResultAllGetDTO> dtoList = new ArrayList<>();
        for (ResultDAO dao : daoList) {
            ResponseResultAllGetDTO dto = ResponseResultAllGetDTO.builder()
                    .resultId(dao.getResultId())
                    .gameId(dao.getGameId())
                    .userId(dao.getUserId())
                    .nickname(dao.getNickname())
                    .age(dao.getAge())
                    .score(dao.getScore())
                    .startedAt(dao.getStartedAt())
                    .finishedAt(dao.getFinishedAt())
                    .build();

            dtoList.add(dto);
        }

        return dtoList;

    }

}
