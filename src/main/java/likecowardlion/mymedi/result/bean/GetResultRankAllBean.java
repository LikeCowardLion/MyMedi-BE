package likecowardlion.mymedi.result.bean;

import likecowardlion.mymedi.result.bean.small.CreateResultRankAllGetDTOBean;
import likecowardlion.mymedi.result.bean.small.GetResultRankDAOBean;
import likecowardlion.mymedi.result.bean.small.GetResultScoreBean;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultRankAllGetDTO;
import likecowardlion.mymedi.result.domain.ResultDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetResultRankAllBean {

    GetResultRankDAOBean getResultRankDAOBean;
    GetResultScoreBean getResultScoreBean;
    CreateResultRankAllGetDTOBean createResultRankAllGetDTOBean;

    @Autowired
    public GetResultRankAllBean(GetResultRankDAOBean getResultRankDAOBean, GetResultScoreBean getResultScoreBean, CreateResultRankAllGetDTOBean createResultRankAllGetDTOBean){
        this.getResultRankDAOBean = getResultRankDAOBean;
        this.getResultScoreBean = getResultScoreBean;
        this.createResultRankAllGetDTOBean = createResultRankAllGetDTOBean;
    }



    // 결과 랭킹 전체 조회
    public ResponseResultRankAllGetDTO exec(UUID userId, UUID gameId){

        // 유저의 최고 점수 조회
        Integer userBestScore = getResultScoreBean.exec(userId, gameId);
        if (userBestScore == null) return null;

        // 최고 점수까지 DAO 전체 조회
        List<ResultDAO> topToUserDaoList = getResultRankDAOBean.exec(gameId, userBestScore);
        System.out.println(topToUserDaoList.toString());
        if (topToUserDaoList.isEmpty()) return null;

        // 유저의 최고 등수 체크
        ResultDAO userBestResult = null;
        Integer userBestRank = null;
        Integer count = 1;
        for (ResultDAO dao : topToUserDaoList){
            if (dao.getUserId().equals(userId)) {
                userBestResult = dao;
                userBestRank = count;
            }
            count++;
        }
        if (userBestResult == null || userBestRank == null) return null;

        // Top100 랭킹 조회
        List<ResultDAO> top100DaoList = getResultRankDAOBean.exec(gameId);
        if (top100DaoList.isEmpty()) return null;

        // DTO 생성해 반환
        return createResultRankAllGetDTOBean.exec(userBestResult, userBestRank, top100DaoList);

    }

}
