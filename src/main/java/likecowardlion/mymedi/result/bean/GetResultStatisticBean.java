package likecowardlion.mymedi.result.bean;

import likecowardlion.mymedi.result.bean.other.GetScoreAverageBean;
import likecowardlion.mymedi.result.bean.small.GetResultDAOBean;
import likecowardlion.mymedi.result.bean.small.GetResultScoreBean;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultStatisticGetDTO;
import likecowardlion.mymedi.result.domain.ResultDAO;
import likecowardlion.mymedi.user.bean.small.GetUserDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class GetResultStatisticBean {

    static Integer MONTH_RANGE = 1;
    static Integer AGE_RANGE = 5;



    GetResultScoreBean getResultScoreBean;
    GetResultDAOBean getResultDAOBean;
    GetUserDAOBean getUserDAOBean;
    GetScoreAverageBean getScoreAverageBean;

    @Autowired
    public GetResultStatisticBean(GetResultScoreBean getResultScoreBean, GetResultDAOBean getResultDAOBean, GetUserDAOBean getUserDAOBean, GetScoreAverageBean getScoreAverageBean){
        this.getResultScoreBean = getResultScoreBean;
        this.getResultDAOBean = getResultDAOBean;
        this.getUserDAOBean = getUserDAOBean;
        this.getScoreAverageBean = getScoreAverageBean;
    }



    // 결과 통계 조회
    public ResponseResultStatisticGetDTO exec(UUID userId, UUID gameId){

        Integer userBestScore = 0;
        Float userAvgScore = 0f;
        Float ageGroupAvgScore = 0f;

        // 유저의 최고 점수 조회
        userBestScore = getResultScoreBean.exec(userId, gameId);
        
        // 유저의 최근 1개월 결과 검색해 평균 점수 계산
        List<ResultDAO> userDaoList = getResultDAOBean.exec(userId, gameId, LocalDateTime.now().minusMonths(MONTH_RANGE), LocalDateTime.now());
        if (!userDaoList.isEmpty()) userAvgScore = getScoreAverageBean.exec(userDaoList);

        // 동일 연령 그룹의 1개월 결과 검색해 평균 점수 계산
        Integer userAge = getUserDAOBean.exec(userId).getAge();
        List<ResultDAO> ageGroupDaoList = getResultDAOBean.exec(gameId, userAge - AGE_RANGE, userAge + AGE_RANGE,
                LocalDateTime.now().minusMonths(MONTH_RANGE), LocalDateTime.now());
        if (!ageGroupDaoList.isEmpty()) ageGroupAvgScore = getScoreAverageBean.exec(ageGroupDaoList);
        
        // DTO 생성해 반환
        return ResponseResultStatisticGetDTO.builder()
                .userBestScore(userBestScore)
                .userAvgScore(userAvgScore)
                .ageGroupAvgScore(ageGroupAvgScore)
                .build();

    }

}
