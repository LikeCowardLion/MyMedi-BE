package likecowardlion.mymedi.user.bean;

import likecowardlion.mymedi.user.bean.small.CreateUserLoginDTOBean;
import likecowardlion.mymedi.user.bean.small.GetUserDAOBean;
import likecowardlion.mymedi.user.domain.DTO.RequestUserLoginDTO;
import likecowardlion.mymedi.user.domain.DTO.ResponseUserLoginDTO;
import likecowardlion.mymedi.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginUserBean {
    
    GetUserDAOBean getUserDAOBean;
    CreateUserLoginDTOBean createUserLoginDTOBean;

    @Autowired
    public LoginUserBean(GetUserDAOBean getUserDAOBean, CreateUserLoginDTOBean createUserLoginDTOBean){
        this.getUserDAOBean = getUserDAOBean;
        this.createUserLoginDTOBean = createUserLoginDTOBean;
    }



    // 유저 로그인 메서드
    public ResponseUserLoginDTO exec(RequestUserLoginDTO requestUserLoginDTO){
        
        // emailId로 DAO 검색
        UserDAO dao = getUserDAOBean.exec(requestUserLoginDTO.getEmailId());
        if (dao == null) return null;

        // 비밀번호 일치 확인
        if (! dao.getPassword().equals(requestUserLoginDTO.getPassword())) return null;

        // DTO 생성해 반환
        return createUserLoginDTOBean.exec(dao);

    }

}
