package likecowardlion.mymedi.result.service;

import likecowardlion.mymedi.result.bean.GetResultCountBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ResultService {

    GetResultCountBean getResultCountBean;

    @Autowired
    public ResultService(GetResultCountBean getResultCountBean){
        this.getResultCountBean = getResultCountBean;
    }



    // 결과 횟수 조회
    public Integer getResultCount(UUID userId){

        return getResultCountBean.exec(userId);

    }

}