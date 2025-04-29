package likecowardlion.mymedi.result.domain.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseResultRankGetDTO {

    Integer rank;
    String nickname;
    String age;
    String date;
    Integer score;

}
