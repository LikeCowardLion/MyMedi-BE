package likecowardlion.mymedi.user.bean.small;

import likecowardlion.mymedi.user.domain.UserDAO;
import likecowardlion.mymedi.user.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveUserDAOBean {
    
    UserRepositoryJPA userRepositoryJPA;
    
    @Autowired
    public SaveUserDAOBean(UserRepositoryJPA userRepositoryJPA){
        this.userRepositoryJPA = userRepositoryJPA;
    }
    
    
    
    // DAO를 DB에 저장
    public void exec(UserDAO userDAO){
        
        userRepositoryJPA.save(userDAO);
        
    }
}
