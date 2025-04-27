package likecowardlion.mymedi.game.controller;

import likecowardlion.mymedi.game.domain.DTO.RequestGameSaveDTO;
import likecowardlion.mymedi.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/game")
public class GameController {

    GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }



    // 게임 저장
    @PostMapping("")
    public ResponseEntity<Map<String, Object>> saveGame(@RequestBody RequestGameSaveDTO requestGameSaveDTO){

        // 게임 저장 service 실행
        UUID gameId = gameService.saveGame(requestGameSaveDTO);

        // 게임 저장 성공 여부 설정
        boolean success = (gameId == null) ? false : true;

        // 반환할 JSON 데이터 설정
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        responseMap.put("message", success ? "게임 저장 성공" : "게임 저장 실패");
        responseMap.put("gameId", gameId);

        // status, body 설정 후 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);

    }

}
