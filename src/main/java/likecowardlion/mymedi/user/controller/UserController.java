package likecowardlion.mymedi.user.controller;

import likecowardlion.mymedi.user.domain.DTO.*;
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



    // 로그인
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody RequestUserLoginDTO requestUserLoginDTO){

        // 유저 로그인 service 실행
        ResponseUserLoginDTO dto = userService.loginUser(requestUserLoginDTO);

        // 유저 로그인 성공 여부 설정
        boolean success = (dto == null) ? false : true;

        // 반환할 JSON 데이터 설정
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        responseMap.put("message", success ? "유저 로그인 성공" : "유저 로그인 실패");
        responseMap.put("userInfo", dto);

        // status, body 설정 후 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
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

    // 유저 삭제
    @DeleteMapping("")
    public ResponseEntity<Map<String, Object>> deleteUser(@RequestBody RequestUserDeleteDTO requestUserDeleteDTO){

        // 유저 삭제 service 실행 & 삭제 성공 여부 설정
        boolean success = userService.deleteUser(requestUserDeleteDTO);

        // 반환할 JSON 데이터 설정
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        responseMap.put("message", success ? "유저 삭제 성공" : "유저 삭제 실패");

        // status, body 설정 후 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);

    }

}
