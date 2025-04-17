package likecowardlion.mymedi.result.bean.small;

import likecowardlion.mymedi.result.domain.ResultDAO;
import likecowardlion.mymedi.result.repository.ResultRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetResultDAOBean {

    ResultRepositoryJPA resultRepositoryJPA;

    @Autowired
    public GetResultDAOBean(ResultRepositoryJPA resultRepositoryJPA){
        this.resultRepositoryJPA = resultRepositoryJPA;
    }



    // userId로 검색, 전체 DAO 반환
    public List<ResultDAO> exec(UUID userId) { return resultRepositoryJPA.findByUserId(userId); }

}