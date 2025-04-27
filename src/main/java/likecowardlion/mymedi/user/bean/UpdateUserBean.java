package likecowardlion.mymedi.user.bean;

import likecowardlion.mymedi.user.bean.small.GetUserDAOBean;
import likecowardlion.mymedi.user.bean.small.SaveUserDAOBean;
import likecowardlion.mymedi.user.domain.DTO.RequestUserUpdateDTO;
import likecowardlion.mymedi.user.domain.GenderType;
import likecowardlion.mymedi.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateUserBean {

    GetUserDAOBean getUserDAOBean;
    SaveUserDAOBean saveUserDAOBean;

    @Autowired
    public UpdateUserBean(GetUserDAOBean getUserDAOBean, SaveUserDAOBean saveUserDAOBean){
        this.getUserDAOBean = getUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
    }



    // 유저 수정 메서드
    public UUID exec(RequestUserUpdateDTO requestUserUpdateDTO){

        // 유저 DAO 검색
        UserDAO dao = getUserDAOBean.exec(requestUserUpdateDTO.getUserId());
        if (dao == null) return null;

        // GenderType 설정
        GenderType genderType = (requestUserUpdateDTO.getGender() == "MALE") ? GenderType.MALE : GenderType.FEMALE;

        // DAO 수정
        dao.setNickname(requestUserUpdateDTO.getNickname());
        dao.setGender(genderType);
        dao.setAge(requestUserUpdateDTO.getAge());
        dao.setTall(requestUserUpdateDTO.getTall());
        dao.setWeight(requestUserUpdateDTO.getWeight());

        // 수정된 DAO 저장
        saveUserDAOBean.exec(dao);

        // DAO의 PK 반환
        return dao.getUserId();

    }

}
