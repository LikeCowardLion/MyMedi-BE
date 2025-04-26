package likecowardlion.mymedi.result.bean;

import likecowardlion.mymedi.result.bean.small.CreateResultMonthGetDTOBean;
import likecowardlion.mymedi.result.bean.small.GetResultDAOBean;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultMonthGetDTO;
import likecowardlion.mymedi.result.domain.ResultDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetResultMonthBean {

    GetResultDAOBean getResultDAOBean;
    CreateResultMonthGetDTOBean createResultMonthGetDTOBean;

    @Autowired
    public GetResultMonthBean(GetResultDAOBean getResultDAOBean, CreateResultMonthGetDTOBean createResultMonthGetDTOBean){
        this.getResultDAOBean = getResultDAOBean;
        this.createResultMonthGetDTOBean = createResultMonthGetDTOBean;
    }



    // 월간 결과 조회
    public List<ResponseResultMonthGetDTO> exec(UUID userId, Integer year, Integer month){

        // 유저의 해당 연월의 결과를 오래된 순으로 조회
        List<ResultDAO> daoList = getResultDAOBean.exec(userId, year, month);

        // DTO 리스트 생성해 반환
        return createResultMonthGetDTOBean.exec(daoList);

    }

}
