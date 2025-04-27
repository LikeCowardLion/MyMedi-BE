package likecowardlion.mymedi.user.bean;

import likecowardlion.mymedi.user.bean.small.GetUserDAOBean;
import likecowardlion.mymedi.user.bean.small.SaveUserDAOBean;
import likecowardlion.mymedi.user.domain.DTO.RequestUserDeleteDTO;
import likecowardlion.mymedi.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserBean {

    GetUserDAOBean getUserDAOBean;
    SaveUserDAOBean saveUserDAOBean;

    @Autowired
    public DeleteUserBean(GetUserDAOBean getUserDAOBean, SaveUserDAOBean saveUserDAOBean){
        this.getUserDAOBean = getUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
    }



    // 유저 삭제 메서드
    public boolean exec(RequestUserDeleteDTO requestUserDeleteDTO){
        
        // userId로 DAO 검색
        UserDAO dao = getUserDAOBean.exec(requestUserDeleteDTO.getUserId());
        if (dao == null) return false;

        // DAO 삭제 처리
        dao.setIsDeleted(true);

        // DAO 저장
        saveUserDAOBean.exec(dao);
        return true;
        
    }

}
