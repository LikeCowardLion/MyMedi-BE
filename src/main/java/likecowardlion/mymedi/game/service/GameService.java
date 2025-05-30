package likecowardlion.mymedi.game.service;

import likecowardlion.mymedi.game.bean.GetAllGameBean;
import likecowardlion.mymedi.game.bean.SaveGameBean;
import likecowardlion.mymedi.game.domain.DTO.RequestGameSaveDTO;
import likecowardlion.mymedi.game.domain.DTO.ResponseGameAllGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    GetAllGameBean getAllGameBean;
    SaveGameBean saveGameBean;

    @Autowired
    public GameService(GetAllGameBean getAllGameBean, SaveGameBean saveGameBean){
        this.getAllGameBean = getAllGameBean;
        this.saveGameBean = saveGameBean;
    }


    // 게임 전체 조회
    public List<ResponseGameAllGetDTO> getAllGame(){

        return getAllGameBean.exec();

    }

    // 게임 저장
    public UUID saveGame(RequestGameSaveDTO requestGameSaveDTO){

        return saveGameBean.exec(requestGameSaveDTO);

    }

}
