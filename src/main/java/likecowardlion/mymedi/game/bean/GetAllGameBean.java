package likecowardlion.mymedi.game.bean;

import likecowardlion.mymedi.game.domain.DTO.ResponseGameAllGetDTO;
import likecowardlion.mymedi.game.domain.GameDAO;
import likecowardlion.mymedi.game.repository.GameRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAllGameBean {

    GameRepositoryJPA gameRepositoryJPA;

    public GetAllGameBean(GameRepositoryJPA gameRepositoryJPA){
        this.gameRepositoryJPA = gameRepositoryJPA;
    }



    public List<ResponseGameAllGetDTO> exec(){

        // 게임 전체 조회
        List<GameDAO> daoList = gameRepositoryJPA.findAll();

        // DAO 리스트를 DTO 리스트로 변환
        List<ResponseGameAllGetDTO> dtoList = new ArrayList<>();
        for (GameDAO dao : daoList){
            ResponseGameAllGetDTO dto = ResponseGameAllGetDTO.builder()
                    .gameId(dao.getGameId())
                    .title(dao.getTitle())
                    .category(dao.getCategory().name())
                    .build();
            dtoList.add(dto);
        }

        // 변환한 DTO 리스트 반환
        return dtoList;

    }

}
