package likecowardlion.mymedi.result.controller;

import likecowardlion.mymedi.result.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user/{userId}/result")
public class ResultController {

    ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService){
        this.resultService = resultService;
    }


    // 결과 횟수 조회
    @GetMapping("/count")
    public ResponseEntity<Map<String, Object>> getResultCount(@PathVariable("userId") UUID userId){

        // 결과 횟수 조회 service 실행
        Integer count = resultService.getResultCount(userId);

        // 결과 횟수 조회 성공 여부 설정
        boolean success = (count == null) ? false : true;

        // 반환할 JSON 데이터 설정
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        responseMap.put("message", success ? "결과 횟수 조회 성공" : "결과 횟수 조회 실패");
        responseMap.put("count", count);

        // status, body 설정 후 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);

    }
}