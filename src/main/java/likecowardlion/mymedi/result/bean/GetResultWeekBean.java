package likecowardlion.mymedi.result.bean;

import likecowardlion.mymedi.result.bean.small.CreateResultWeekGetDTOBean;
import likecowardlion.mymedi.result.bean.small.GetResultDAOBean;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultWeekGetDTO;
import likecowardlion.mymedi.result.domain.ResultDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetResultWeekBean {

    GetResultDAOBean getResultDAOBean;
    CreateResultWeekGetDTOBean createResultWeekGetDTOBean;

    @Autowired
    public GetResultWeekBean(GetResultDAOBean getResultDAOBean, CreateResultWeekGetDTOBean createResultWeekGetDTOBean){
        this.getResultDAOBean = getResultDAOBean;
        this.createResultWeekGetDTOBean = createResultWeekGetDTOBean;
    }



    // 주간 결과 조회
    public List<ResponseResultWeekGetDTO> exec(UUID userId, UUID gameId){
        
        // 유저의 날짜별 최고 점수 최신순 전체 조회
        List<ResultDAO> daoList = getResultDAOBean.exec(userId, gameId);
        
        // DTO 생성해 반환
        return createResultWeekGetDTOBean.exec(daoList);

    }

}
