package likecowardlion.mymedi.result.bean.small;

import likecowardlion.mymedi.result.domain.DTO.ResponseResultRankAllGetDTO;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultRankGetDTO;
import likecowardlion.mymedi.result.domain.ResultDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateResultRankAllGetDTOBean {

    CreateResultRankGetDTOBean createResultRankGetDTOBean;

    @Autowired
    public CreateResultRankAllGetDTOBean(CreateResultRankGetDTOBean createResultRankGetDTOBean){
        this.createResultRankGetDTOBean = createResultRankGetDTOBean;
    }

    // DTO 생성해 반환
    public ResponseResultRankAllGetDTO exec(ResultDAO userResultDao, Integer userRank, List<ResultDAO> resultDaoList){

        // 유저 랭킹 정보 설정
        ResponseResultRankGetDTO userResultInfo = createResultRankGetDTOBean.exec(userResultDao, userRank);

        // top100 랭킹 정보 설정
        List<ResponseResultRankGetDTO> resultList = new ArrayList<>();
        Integer rank = 1;
        for (ResultDAO dao : resultDaoList){

            resultList.add(createResultRankGetDTOBean.exec(dao, rank));
            rank++;

        }
        
        // DTO 생성해 반환
        return ResponseResultRankAllGetDTO.builder()
                .userResultInfo(userResultInfo)
                .resultList(resultList)
                .build();

    }
}
