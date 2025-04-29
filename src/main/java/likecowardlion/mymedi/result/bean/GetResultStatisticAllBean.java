package likecowardlion.mymedi.result.bean;

import likecowardlion.mymedi.game.bean.small.GetGameDAOBean;
import likecowardlion.mymedi.game.domain.GameDAO;
import likecowardlion.mymedi.result.bean.other.GetScoreAverageBean;
import likecowardlion.mymedi.result.bean.small.GetResultDAOBean;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultStatisticAllGetDTO;
import likecowardlion.mymedi.result.domain.ResultDAO;
import likecowardlion.mymedi.user.bean.small.GetUserDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class GetResultStatisticAllBean {

    static Integer MONTH_RANGE = 1;
    static Integer AGE_RANGE = 5;



    GetGameDAOBean getGameDAOBean;
    GetResultDAOBean getResultDAOBean;
    GetUserDAOBean getUserDAOBean;
    GetScoreAverageBean getScoreAverageBean;



    @Autowired
    public GetResultStatisticAllBean(GetGameDAOBean getGameDAOBean, GetResultDAOBean getResultDAOBean, GetUserDAOBean getUserDAOBean, GetScoreAverageBean getScoreAverageBean){
        this.getGameDAOBean = getGameDAOBean;
        this.getResultDAOBean = getResultDAOBean;
        this.getUserDAOBean = getUserDAOBean;
        this.getScoreAverageBean = getScoreAverageBean;
    }



    // 결과 통계 전체 조회
    public List<ResponseResultStatisticAllGetDTO> exec(UUID userId){

        // 반환할 dtoList 생성
        List<ResponseResultStatisticAllGetDTO> dtoList = new ArrayList<>();

        // 전체 게임 조회
        List<GameDAO> gameDAOList = getGameDAOBean.exec();

        // 게임 리스트에서 하나씩 꺼내서
        for (GameDAO gameDAO : gameDAOList){

            UUID gameId = gameDAO.getGameId();
            Float userAvgScore = 0f;
            Float ageGroupAvgScore = 0f;

            // 유저의 최근 1개월 결과 검색해 평균 점수 계산
            List<ResultDAO> userDaoList = getResultDAOBean.exec(userId, gameId, LocalDateTime.now().minusMonths(MONTH_RANGE), LocalDateTime.now());
            if (!userDaoList.isEmpty()) userAvgScore = getScoreAverageBean.exec(userDaoList);

            // 동일 연령 그룹의 1개월 결과 검색해 평균 점수 계산
            Integer userAge = getUserDAOBean.exec(userId).getAge();
            List<ResultDAO> ageGroupDaoList = getResultDAOBean.exec(gameId, userAge - AGE_RANGE, userAge + AGE_RANGE,
                    LocalDateTime.now().minusMonths(MONTH_RANGE), LocalDateTime.now());
            if (!ageGroupDaoList.isEmpty()) ageGroupAvgScore = getScoreAverageBean.exec(ageGroupDaoList);

            // DTO 생성해 dtoList에 저장
            dtoList.add(ResponseResultStatisticAllGetDTO.builder()
                    .gameId(gameId)
                    .userAvgScore(userAvgScore)
                    .ageGroupAvgScore(ageGroupAvgScore)
                    .build());

        }

        // dtoList 반환
        return dtoList;

    }

}
