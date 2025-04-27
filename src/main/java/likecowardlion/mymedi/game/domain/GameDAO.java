package likecowardlion.mymedi.game.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GameDAO {

    @Id
    UUID gameId;

    String title;
    GameType category;

}
