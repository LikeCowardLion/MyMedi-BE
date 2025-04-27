package likecowardlion.mymedi.game.service;

import likecowardlion.mymedi.game.bean.SaveGameBean;
import likecowardlion.mymedi.game.domain.DTO.RequestGameSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GameService {

    SaveGameBean saveGameBean;

    @Autowired
    public GameService(SaveGameBean saveGameBean){
        this.saveGameBean = saveGameBean;
    }



    // 게임 저장
    public UUID saveGame(RequestGameSaveDTO requestGameSaveDTO){

        return saveGameBean.exec(requestGameSaveDTO);

    }

}
