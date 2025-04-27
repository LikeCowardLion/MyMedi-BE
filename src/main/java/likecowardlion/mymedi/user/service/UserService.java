package likecowardlion.mymedi.user.service;

import likecowardlion.mymedi.user.bean.SaveUserBean;
import likecowardlion.mymedi.user.domain.DTO.RequestUserSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    SaveUserBean saveUserBean;

    @Autowired
    public UserService(SaveUserBean saveUserBean){
        this.saveUserBean = saveUserBean;
    }



    // 유저 생성 (회원가입)
    public UUID saveUser(RequestUserSaveDTO requestUserSaveDTO){

        return saveUserBean.exec(requestUserSaveDTO);

    }
}
