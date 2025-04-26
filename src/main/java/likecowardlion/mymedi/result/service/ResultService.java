package likecowardlion.mymedi.result.service;

import likecowardlion.mymedi.result.bean.GetResultCountBean;
import likecowardlion.mymedi.result.bean.SaveResultBean;
import likecowardlion.mymedi.result.domain.DTO.RequestResultSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ResultService {

    GetResultCountBean getResultCountBean;
    SaveResultBean saveResultBean;

    @Autowired
    public ResultService(GetResultCountBean getResultCountBean, SaveResultBean saveResultBean){
        this.getResultCountBean = getResultCountBean;
        this.saveResultBean = saveResultBean;
    }



    // 결과 횟수 조회
    public Integer getResultCount(UUID userId){

        return getResultCountBean.exec(userId);

    }

    // 결과 저장
    public UUID saveResult(UUID userId, RequestResultSaveDTO requestResultSaveDTO){

        return saveResultBean.exec(userId, requestResultSaveDTO);

    }

}