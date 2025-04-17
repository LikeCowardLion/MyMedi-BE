package likecowardlion.mymedi.result.bean;

import likecowardlion.mymedi.result.bean.small.GetResultDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetResultCountBean {

    GetResultDAOBean getResultDAOBean;

    @Autowired
    public GetResultCountBean(GetResultDAOBean getResultDAOBean){
        this.getResultDAOBean = getResultDAOBean;
    }

    // 결과 횟수 조회
    public Integer exec(UUID userId){

        // 유저의 Result 전체 조회, 개수 반환
        return getResultDAOBean.exec(userId).size();

    }


}