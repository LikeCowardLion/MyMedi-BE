package likecowardlion.mymedi.result.service;

import likecowardlion.mymedi.result.bean.GetResultCountBean;
import likecowardlion.mymedi.result.bean.GetResultMonthBean;
import likecowardlion.mymedi.result.bean.GetResultWeekBean;
import likecowardlion.mymedi.result.bean.SaveResultBean;
import likecowardlion.mymedi.result.domain.DTO.RequestResultSaveDTO;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultMonthGetDTO;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultWeekGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ResultService {

    GetResultCountBean getResultCountBean;
    GetResultMonthBean getResultMonthBean;
    GetResultWeekBean getResultWeekBean;
    SaveResultBean saveResultBean;

    @Autowired
    public ResultService(GetResultCountBean getResultCountBean, GetResultMonthBean getResultMonthBean, GetResultWeekBean getResultWeekBean, SaveResultBean saveResultBean){
        this.getResultCountBean = getResultCountBean;
        this.getResultMonthBean = getResultMonthBean;
        this.getResultWeekBean = getResultWeekBean;
        this.saveResultBean = saveResultBean;
    }



    // 결과 횟수 조회
    public Integer getResultCount(UUID userId){

        return getResultCountBean.exec(userId);

    }

    // 월간 결과 조회
    public List<ResponseResultMonthGetDTO> getMonthResult(UUID userId, Integer year, Integer month){

        return getResultMonthBean.exec(userId, year, month);

    }

    // 주간 결과 조회
    public List<ResponseResultWeekGetDTO> getWeekResult(UUID userId, UUID gameId){

        return getResultWeekBean.exec(userId, gameId);

    }

    // 결과 저장
    public UUID saveResult(UUID userId, RequestResultSaveDTO requestResultSaveDTO){

        return saveResultBean.exec(userId, requestResultSaveDTO);

    }

}