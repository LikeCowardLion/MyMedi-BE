package likecowardlion.mymedi.result.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResultDAO {

    @Id
    UUID resultId;

    UUID gameId;
    UUID userId;
    String nickname;
    Integer age;
    Integer score;
    LocalDateTime startedAt;
    LocalDateTime finishedAt;

}