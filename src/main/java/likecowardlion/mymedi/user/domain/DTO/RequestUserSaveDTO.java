package likecowardlion.mymedi.user.domain.DTO;

import likecowardlion.mymedi.user.domain.GenderType;
import lombok.Data;

@Data
public class RequestUserSaveDTO {

    String emailId;
    String password;
    String nickname;
    String gender;
    Integer age;
    Integer tall;
    Integer weight;

}
