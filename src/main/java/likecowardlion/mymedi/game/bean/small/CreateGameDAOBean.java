package likecowardlion.mymedi.game.bean.small;

import likecowardlion.mymedi.game.domain.DTO.RequestGameSaveDTO;
import likecowardlion.mymedi.game.domain.GameDAO;
import likecowardlion.mymedi.game.domain.GameType;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateGameDAOBean {

    // 게임 DAO 생성 메서드
    public GameDAO exec(RequestGameSaveDTO requestGameSaveDTO){

        // GameType 설정
        GameType category;
        switch (requestGameSaveDTO.getCategory()){
            case "GROSS_MOTOR":
                category = GameType.GROSS_MOTOR;
                break;
            case "FINE_MOTOR":
                category = GameType.FINE_MOTOR;
                break;
            case "FLEXIBILITY":
                category = GameType.FLEXIBILITY;
                break;
            default:
                return null;
        }

        return GameDAO.builder()
                .gameId(UUID.randomUUID())
                .title(requestGameSaveDTO.getTitle())
                .category(category)
                .build();

    }
}
