package likecowardlion.mymedi.user.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestUserUpdateDTO {

    UUID userId;

    String nickname;
    String gender;
    Integer age;
    Integer tall;
    Integer weight;

}
