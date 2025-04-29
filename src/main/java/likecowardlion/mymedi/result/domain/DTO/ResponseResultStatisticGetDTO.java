package likecowardlion.mymedi.result.domain.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseResultStatisticGetDTO {

    Integer userBestScore;
    Float userAvgScore;
    Float ageGroupAvgScore;

}
