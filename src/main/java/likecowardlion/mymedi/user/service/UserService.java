package likecowardlion.mymedi.user.service;

import likecowardlion.mymedi.user.bean.LoginUserBean;
import likecowardlion.mymedi.user.bean.SaveUserBean;
import likecowardlion.mymedi.user.bean.UpdateUserBean;
import likecowardlion.mymedi.user.domain.DTO.RequestUserLoginDTO;
import likecowardlion.mymedi.user.domain.DTO.RequestUserSaveDTO;
import likecowardlion.mymedi.user.domain.DTO.RequestUserUpdateDTO;
import likecowardlion.mymedi.user.domain.DTO.ResponseUserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    SaveUserBean saveUserBean;
    UpdateUserBean updateUserBean;
    LoginUserBean loginUserBean;

    @Autowired
    public UserService(SaveUserBean saveUserBean, UpdateUserBean updateUserBean, LoginUserBean loginUserBean){
        this.saveUserBean = saveUserBean;
        this.updateUserBean = updateUserBean;
        this.loginUserBean = loginUserBean;
    }



    // 유저 로그인
    public ResponseUserLoginDTO loginUser(RequestUserLoginDTO requestUserLoginDTO){

        return loginUserBean.exec(requestUserLoginDTO);

    }

    // 유저 생성 (회원가입)
    public UUID saveUser(RequestUserSaveDTO requestUserSaveDTO){

        return saveUserBean.exec(requestUserSaveDTO);

    }

    // 유저 수정
    public UUID updateUser(RequestUserUpdateDTO requestUserUpdateDTO){

        return updateUserBean.exec(requestUserUpdateDTO);

    }
}
