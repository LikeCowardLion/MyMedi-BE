package likecowardlion.mymedi.user.bean.small;

import likecowardlion.mymedi.user.domain.UserDAO;
import likecowardlion.mymedi.user.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetUserDAOBean {

    UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public GetUserDAOBean(UserRepositoryJPA userRepositoryJPA){
        this.userRepositoryJPA = userRepositoryJPA;
    }



    // userId로 검색해 DAO 반환
    public UserDAO exec(UUID userId){

        return userRepositoryJPA.findById(userId).get();

    }

    // emailId로 검색해 DAO 반환
    public UserDAO exec(String emailId){

        return userRepositoryJPA.findByEmailIdAndIsDeleted(emailId, false);

    }

}
