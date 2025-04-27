package likecowardlion.mymedi.user.domain;

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
public class UserDAO {

    @Id
    UUID userId;

    String emailId;
    String password;
    String image;
    String nickname;
    GenderType gender;
    Integer age;
    Integer tall;
    Integer weight;

}
