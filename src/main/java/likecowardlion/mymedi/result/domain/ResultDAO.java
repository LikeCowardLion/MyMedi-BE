package likecowardlion.mymedi.result.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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