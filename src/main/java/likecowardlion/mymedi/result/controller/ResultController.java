package likecowardlion.mymedi.result.controller;

import likecowardlion.mymedi.result.domain.DTO.RequestResultSaveDTO;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultMonthGetDTO;
import likecowardlion.mymedi.result.domain.DTO.ResponseResultWeekGetDTO;
import likecowardlion.mymedi.result.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    // 월간 결과 조회
    @GetMapping("/month/{year}/{month}")
    public ResponseEntity<Map<String, Object>> getMonthResult(@PathVariable("userId") UUID userId, @PathVariable("year") Integer year, @PathVariable("month") Integer month){

        // 월간 결과 조회 service 실행
        List<ResponseResultMonthGetDTO> dtoList = resultService.getMonthResult(userId, year, month);

        // 결과 횟수 조회 성공 여부 설정
        boolean success = (dtoList == null) ? false : true;

        // 반환할 JSON 데이터 설정
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        responseMap.put("message", success ? "월간 결과 조회 성공" : "월간 결과 조회 실패");
        responseMap.put("dayResultList", dtoList);

        // status, body 설정 후 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    // 주간 결과 조회
    @GetMapping("/week/{gameId}")
    public ResponseEntity<Map<String, Object>> getWeekResult(@PathVariable("userId") UUID userId, @PathVariable("gameId") UUID gameId){
        
        // 주간 결과 조회 service 실행
        List<ResponseResultWeekGetDTO> dtoList = resultService.getWeekResult(userId, gameId);

        // 주간 결과 조회 성공 여부 설정
        boolean success = (dtoList == null) ? false : true;

        // 반환할 JSON 데이터 설정
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        responseMap.put("message", success ? "주간 결과 조회 성공" : "주간 결과 조회 실패");
        responseMap.put("resultList", dtoList);

        // status, body 설정 후 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    // 결과 저장
    @PostMapping("")
    public ResponseEntity<Map<String, Object>> saveResult(@PathVariable("userId") UUID userId, @RequestBody RequestResultSaveDTO requestResultSaveDTO){

        // 결과 저장 service 실행
        UUID resultId = resultService.saveResult(userId, requestResultSaveDTO);

        // 결과 저장 성공 여부 설정
        boolean success = (resultId == null) ? false : true;

        // 반환할 JSON 데이터 설정
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        responseMap.put("message", success ? "결과 저장 성공" : "결과 저장 실패");
        responseMap.put("resultId", resultId);

        // status, body 설정 후 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);

    }
}