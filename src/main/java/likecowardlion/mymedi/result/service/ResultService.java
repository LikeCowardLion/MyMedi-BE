package likecowardlion.mymedi.result.service;

import likecowardlion.mymedi.result.bean.*;
import likecowardlion.mymedi.result.domain.DTO.RequestResultSaveDTO;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultMonthGetDTO;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultStatisticGetDTO;
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
    GetResultStatisticBean getResultStatisticBean;
    SaveResultBean saveResultBean;

    @Autowired
    public ResultService(GetResultCountBean getResultCountBean, GetResultMonthBean getResultMonthBean, GetResultWeekBean getResultWeekBean, GetResultStatisticBean getResultStatisticBean, SaveResultBean saveResultBean){
        this.getResultCountBean = getResultCountBean;
        this.getResultMonthBean = getResultMonthBean;
        this.getResultWeekBean = getResultWeekBean;
        this.getResultStatisticBean = getResultStatisticBean;
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

    // 결과 통계 조회
    public ResponseResultStatisticGetDTO getStatisticResult(UUID userId, UUID gameId){

        return getResultStatisticBean.exec(userId, gameId);

    }

    // 결과 저장
    public UUID saveResult(UUID userId, RequestResultSaveDTO requestResultSaveDTO){

        return saveResultBean.exec(userId, requestResultSaveDTO);

    }

}