package likecowardlion.mymedi.result.domain.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseResultMonthDetailGetDTO {

    String title;
    String category;
    String startedAt;
    String finishedAt;

}
