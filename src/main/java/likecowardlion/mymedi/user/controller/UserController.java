package likecowardlion.mymedi.user.controller;

import likecowardlion.mymedi.user.domain.DTO.RequestUserSaveDTO;
import likecowardlion.mymedi.user.domain.DTO.RequestUserUpdateDTO;
import likecowardlion.mymedi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }



    // 유저 생성 (회원가입)
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody RequestUserSaveDTO requestUserSaveDTO){

        // 유저 생성 service 실행
        UUID userId = userService.saveUser(requestUserSaveDTO);

        // 유저 생성 성공 여부 설정
        boolean success = (userId == null) ? false : true;

        // 반환할 JSON 데이터 설정
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        responseMap.put("message", success ? "유저 생성 성공" : "유저 생성 실패");
        responseMap.put("userId", userId);

        // status, body 설정 후 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);

    }

    // 유저 수정
    @PutMapping("")
    public ResponseEntity<Map<String, Object>> updateUser(@RequestBody RequestUserUpdateDTO requestUserUpdateDTO){

        // 유저 수정 service 실행
        UUID userId = userService.updateUser(requestUserUpdateDTO);

        // 유저 수정 성공 여부 설정
        boolean success = (userId == null) ? false : true;

        // 반환할 JSON 데이터 설정
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        responseMap.put("message", success ? "유저 수정 성공" : "유저 수정 실패");
        responseMap.put("userId", userId);

        // status, body 설정 후 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);

    }
}
