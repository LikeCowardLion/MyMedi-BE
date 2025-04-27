package likecowardlion.mymedi.user.bean.small;

import likecowardlion.mymedi.user.domain.DTO.RequestUserSaveDTO;
import likecowardlion.mymedi.user.domain.GenderType;
import likecowardlion.mymedi.user.domain.UserDAO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserDAOBean {

    // DAO 생성해 반환
    public UserDAO exec(RequestUserSaveDTO requestUserSaveDTO){

        GenderType genderType = (requestUserSaveDTO.getGender() == "MALE") ? GenderType.MALE : GenderType.FEMALE;

        return UserDAO.builder()
                .userId(UUID.randomUUID())
                .emailId(requestUserSaveDTO.getEmailId())
                .password(requestUserSaveDTO.getPassword())
                .image("")
                .nickname(requestUserSaveDTO.getNickname())
                .gender(genderType)
                .age(requestUserSaveDTO.getAge())
                .tall(requestUserSaveDTO.getTall())
                .weight(requestUserSaveDTO.getWeight())
                .isDeleted(false)
                .build();

    }

}
