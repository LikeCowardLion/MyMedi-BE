package likecowardlion.mymedi.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
