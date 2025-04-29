package likecowardlion.mymedi.result.domain.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseResultWeekGetDTO {

    String date;
    Integer bestScore;

}
