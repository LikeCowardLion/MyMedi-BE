package likecowardlion.mymedi.result.bean.small;

import likecowardlion.mymedi.result.domain.DTO.ResponseResultRankGetDTO;
import likecowardlion.mymedi.result.domain.ResultDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateResultRankGetDTOBean {

    // DTO 생성해 반환
    public ResponseResultRankGetDTO exec(ResultDAO dao, Integer rank){

        Integer ageInt = dao.getAge() - (dao.getAge() % 10);
        String ageStr = ageInt.toString() + "대";

        LocalDateTime startedAt = dao.getStartedAt();
        String dateStr = String.format("%04d.%02d.%02d", startedAt.getYear(), startedAt.getMonthValue(), startedAt.getDayOfMonth());

        return ResponseResultRankGetDTO.builder()
                .rank(rank)
                .nickname(dao.getNickname())
                .age(ageStr)
                .date(dateStr)
                .score(dao.getScore())
                .build();

    }

}
