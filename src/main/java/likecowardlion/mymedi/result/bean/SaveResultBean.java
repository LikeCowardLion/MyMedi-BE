package likecowardlion.mymedi.result.bean;

import likecowardlion.mymedi.result.bean.small.CreateResultDAOBean;
import likecowardlion.mymedi.result.bean.small.SaveResultDAOBean;
import likecowardlion.mymedi.result.domain.DTO.RequestResultSaveDTO;
import likecowardlion.mymedi.result.domain.ResultDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveResultBean {

    CreateResultDAOBean createResultDAOBean;
    SaveResultDAOBean saveResultDAOBean;

    @Autowired
    public SaveResultBean(CreateResultDAOBean createResultDAOBean, SaveResultDAOBean saveResultDAOBean){
        this.createResultDAOBean = createResultDAOBean;
        this.saveResultDAOBean = saveResultDAOBean;
    }



    // 결과 저장
    public UUID exec(UUID userId, RequestResultSaveDTO requestResultSaveDTO){

        // 결과 DAO 객체 생성
        ResultDAO resultDAO = createResultDAOBean.exec(requestResultSaveDTO);
        if (resultDAO == null) return null;

        // DAO 저장
        saveResultDAOBean.exec(resultDAO);

        // DAO의 PK 리턴
        return resultDAO.getResultId();

    }

}