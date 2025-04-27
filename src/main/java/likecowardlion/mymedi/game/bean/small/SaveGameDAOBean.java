package likecowardlion.mymedi.game.bean.small;

import likecowardlion.mymedi.game.domain.GameDAO;
import likecowardlion.mymedi.game.repository.GameRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveGameDAOBean {

    GameRepositoryJPA gameRepositoryJPA;

    @Autowired
    public SaveGameDAOBean(GameRepositoryJPA gameRepositoryJPA){
        this.gameRepositoryJPA = gameRepositoryJPA;
    }
    
    
    
    // DAO를 DB에 저장
    public void exec(GameDAO gameDAO){

        gameRepositoryJPA.save(gameDAO);

    }
}
