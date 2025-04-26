package likecowardlion.mymedi.result.bean.small;

import likecowardlion.mymedi.result.domain.ResultDAO;
import likecowardlion.mymedi.result.repository.ResultRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveResultDAOBean {

    ResultRepositoryJPA resultRepositoryJPA;

    @Autowired
    public SaveResultDAOBean(ResultRepositoryJPA resultRepositoryJPA){
        this.resultRepositoryJPA = resultRepositoryJPA;
    }



    // 결과 DAO를 DB에 저장
    public void exec(ResultDAO resultDAO){
        resultRepositoryJPA.save(resultDAO);
    }
}
