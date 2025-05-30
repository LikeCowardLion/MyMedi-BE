package likecowardlion.mymedi.game.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseGameAllGetDTO {

    UUID gameId;
    String title;
    String category;

}
