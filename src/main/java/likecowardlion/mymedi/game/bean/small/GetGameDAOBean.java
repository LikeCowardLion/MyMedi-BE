package likecowardlion.mymedi.game.bean.small;

import likecowardlion.mymedi.game.domain.GameDAO;
import likecowardlion.mymedi.game.repository.GameRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetGameDAOBean {

    GameRepositoryJPA gameRepositoryJPA;

    @Autowired
    public GetGameDAOBean(GameRepositoryJPA gameRepositoryJPA){
        this.gameRepositoryJPA = gameRepositoryJPA;
    }



    // gameId로 검색, DAO 반환
    public GameDAO exec(UUID gameId){

        return gameRepositoryJPA.findById(gameId).get();

    }
}
