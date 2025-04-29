package likecowardlion.mymedi.result.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseResultStatisticAllGetDTO {

    UUID gameId;
    Float userAvgScore;
    Float ageGroupAvgScore;

}
