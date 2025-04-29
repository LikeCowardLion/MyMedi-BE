package likecowardlion.mymedi.result.bean.small;

import likecowardlion.mymedi.result.domain.ResultDAO;
import likecowardlion.mymedi.result.repository.ResultRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetResultRankDAOBean {

    ResultRepositoryJPA resultRepositoryJPA;

    @Autowired
    public GetResultRankDAOBean(ResultRepositoryJPA resultRepositoryJPA){
        this.resultRepositoryJPA = resultRepositoryJPA;
    }


    // gameId로 해당 점수까지의 DAO 검색해 반환
    public List<ResultDAO> exec(UUID gameId, Integer score){

        return resultRepositoryJPA.findByGameIdAndScoreGreaterThanEqualOrderByScoreDescStartedAtDesc(gameId, score);

    }

    // gameId로 상위 100개의 DAO 검색해 반환
    public List<ResultDAO> exec(UUID gameId){

        return resultRepositoryJPA.findTop100ByGameIdOrderByScoreDescStartedAtDesc(gameId);

    }

}
