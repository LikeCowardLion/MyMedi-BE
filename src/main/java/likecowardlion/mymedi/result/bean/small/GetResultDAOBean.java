package likecowardlion.mymedi.result.bean.small;

import likecowardlion.mymedi.result.domain.ResultDAO;
import likecowardlion.mymedi.result.repository.ResultRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Component
public class GetResultDAOBean {

    ResultRepositoryJPA resultRepositoryJPA;

    @Autowired
    public GetResultDAOBean(ResultRepositoryJPA resultRepositoryJPA){
        this.resultRepositoryJPA = resultRepositoryJPA;
    }



    // userId로 검색, 전체 DAO 반환
    public List<ResultDAO> exec(UUID userId) { return resultRepositoryJPA.findByUserId(userId); }

    // userId로 해당 연월의 결과 검색, 전체 DAO 반환
    public List<ResultDAO> exec(UUID userId, Integer year, Integer month) {

        // 검색 기준 설정
        Integer endYearInt = (month < 12) ? year : year+1;
        Integer endMonthInt = (month < 12) ? month+1 : 1;
        String startStr = String.format("%04d-%02d-01 00:00:00", year, month);
        String endStr = String.format("%04d-%02d-31 23:59:59", endYearInt, endMonthInt);

        // 검색 기준 LocalDateTime 값 설정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime monthStart = LocalDateTime.parse(startStr, formatter);
        LocalDateTime monthEnd = LocalDateTime.parse(endStr, formatter);

        // 검색해 전체 DAO 반환
        return resultRepositoryJPA.findByUserIdAndStartedAtBetweenOrderByStartedAtAsc(userId, monthStart, monthEnd);

    }

    // userId와 gameId로 날짜별 최고 점수 전체 검색
    public List<ResultDAO> exec(UUID userId, UUID gameId){

        return resultRepositoryJPA.findDailyMaxScores(userId, gameId);

    }

}