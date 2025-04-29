package likecowardlion.mymedi.result.bean.small;

import likecowardlion.mymedi.result.domain.ResultDAO;
import likecowardlion.mymedi.result.repository.ResultRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetResultScoreBean {

    ResultRepositoryJPA resultRepositoryJPA;

    @Autowired
    public GetResultScoreBean(ResultRepositoryJPA resultRepositoryJPA){
        this.resultRepositoryJPA = resultRepositoryJPA;
    }



    // userId와 gameId로 최고 점수 검색해 반환
    public Integer exec(UUID userId, UUID gameId){

        ResultDAO dao = resultRepositoryJPA.findTop1ByUserIdAndGameIdOrderByScoreDesc(userId, gameId);
        if (dao == null) return 0;

        return dao.getScore();

    }

}
