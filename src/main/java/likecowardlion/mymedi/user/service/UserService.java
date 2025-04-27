package likecowardlion.mymedi.user.service;

import likecowardlion.mymedi.user.bean.DeleteUserBean;
import likecowardlion.mymedi.user.bean.LoginUserBean;
import likecowardlion.mymedi.user.bean.SaveUserBean;
import likecowardlion.mymedi.user.bean.UpdateUserBean;
import likecowardlion.mymedi.user.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    SaveUserBean saveUserBean;
    UpdateUserBean updateUserBean;
    LoginUserBean loginUserBean;
    DeleteUserBean deleteUserBean;

    @Autowired
    public UserService(SaveUserBean saveUserBean, UpdateUserBean updateUserBean, LoginUserBean loginUserBean, DeleteUserBean deleteUserBean){
        this.saveUserBean = saveUserBean;
        this.updateUserBean = updateUserBean;
        this.loginUserBean = loginUserBean;
        this.deleteUserBean = deleteUserBean;
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

    // 유저 삭제
    public boolean deleteUser(RequestUserDeleteDTO requestUserDeleteDTO){

        return deleteUserBean.exec(requestUserDeleteDTO);

    }

}
