package likecowardlion.mymedi.user.bean.small;

import likecowardlion.mymedi.user.domain.DTO.ResponseUserLoginDTO;
import likecowardlion.mymedi.user.domain.UserDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateUserLoginDTOBean {

    public ResponseUserLoginDTO exec(UserDAO userDAO){

        return ResponseUserLoginDTO.builder()
                .userId(userDAO.getUserId())
                .image(userDAO.getImage())
                .nickname(userDAO.getNickname())
                .gender(userDAO.getGender().name())
                .age(userDAO.getAge())
                .tall(userDAO.getTall())
                .weight(userDAO.getWeight())
                .build();

    }
}
