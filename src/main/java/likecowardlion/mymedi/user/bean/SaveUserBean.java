package likecowardlion.mymedi.user.bean;

import likecowardlion.mymedi.user.bean.small.CreateUserDAOBean;
import likecowardlion.mymedi.user.bean.small.GetUserDAOBean;
import likecowardlion.mymedi.user.bean.small.SaveUserDAOBean;
import likecowardlion.mymedi.user.domain.DTO.RequestUserSaveDTO;
import likecowardlion.mymedi.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveUserBean {

    GetUserDAOBean getUserDAOBean;
    CreateUserDAOBean createUserDAOBean;
    SaveUserDAOBean saveUserDAOBean;

    @Autowired
    public SaveUserBean(GetUserDAOBean getUserDAOBean, CreateUserDAOBean createUserDAOBean, SaveUserDAOBean saveUserDAOBean){
        this.getUserDAOBean = getUserDAOBean;
        this.createUserDAOBean = createUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
    }



    // 유저 생성 메서드
    public UUID exec(RequestUserSaveDTO requestUserSaveDTO){

        // emailId 중복 체크
        if (!getUserDAOBean.exec(requestUserSaveDTO.getEmailId()).isEmpty()) return null;

        // DTO 정보로 DAO 생성
        UserDAO dao = createUserDAOBean.exec(requestUserSaveDTO);
        if (dao == null) return null;

        // 생성한 DAO 저장
        saveUserDAOBean.exec(dao);

        // DAO의 PK 반환
        return dao.getUserId();

    }
}
