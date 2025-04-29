package likecowardlion.mymedi.result.bean.other;

import likecowardlion.mymedi.result.domain.ResultDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetScoreAverageBean {

    // 평균 점수 계산해 반환
    public Float exec(List<ResultDAO> daoList){

        Integer scoreSum = 0;
        Integer count = 0;

        for (ResultDAO dao : daoList) {

            scoreSum += dao.getScore();
            count++;

        }

        return (float) (scoreSum / count);

    }
}
