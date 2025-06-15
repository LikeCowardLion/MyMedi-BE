package likecowardlion.mymedi.result.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ResponseResultAllGetDTO {

    UUID resultId;

    UUID gameId;
    UUID userId;
    String nickname;
    Integer age;
    Integer score;
    LocalDateTime startedAt;
    LocalDateTime finishedAt;

}
