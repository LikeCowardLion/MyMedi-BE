package likecowardlion.mymedi.game.bean;

import likecowardlion.mymedi.game.bean.small.CreateGameDAOBean;
import likecowardlion.mymedi.game.bean.small.SaveGameDAOBean;
import likecowardlion.mymedi.game.domain.DTO.RequestGameSaveDTO;
import likecowardlion.mymedi.game.domain.GameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveGameBean {

    CreateGameDAOBean createGameDAOBean;
    SaveGameDAOBean saveGameDAOBean;

    @Autowired
    public SaveGameBean(CreateGameDAOBean createGameDAOBean, SaveGameDAOBean saveGameDAOBean){
        this.createGameDAOBean = createGameDAOBean;
        this.saveGameDAOBean = saveGameDAOBean;
    }



    // 게임 저장 메서드
    public UUID exec(RequestGameSaveDTO requestGameSaveDTO){
        
        // DTO를 DAO로 변환
        GameDAO dao = createGameDAOBean.exec(requestGameSaveDTO);
        if (dao == null) return null;

        // DAO 저장
        saveGameDAOBean.exec(dao);

        // DAO의 PK 반환
        return dao.getGameId();

    }

}
