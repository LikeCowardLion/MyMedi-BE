package likecowardlion.mymedi.result.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestResultSaveDTO {

    UUID gameId;
    UUID userId;
    Integer score;
    String startedAt;
    String finishedAt;

}
