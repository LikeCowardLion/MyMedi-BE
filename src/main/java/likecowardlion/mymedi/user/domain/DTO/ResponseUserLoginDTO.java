package likecowardlion.mymedi.user.domain.DTO;

import likecowardlion.mymedi.user.domain.GenderType;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseUserLoginDTO {

    UUID userId;

    String image;
    String nickname;
    String gender;
    Integer age;
    Integer tall;
    Integer weight;

}
