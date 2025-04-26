package likecowardlion.mymedi.result.bean.small;

import likecowardlion.mymedi.result.domain.DTO.RequestResultSaveDTO;
import likecowardlion.mymedi.result.domain.ResultDAO;
import likecowardlion.mymedi.user.bean.small.GetUserDAOBean;
import likecowardlion.mymedi.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class CreateResultDAOBean {

    GetUserDAOBean getUserDAOBean;

    @Autowired
    public CreateResultDAOBean(GetUserDAOBean getUserDAOBean){
        this.getUserDAOBean = getUserDAOBean;
    }



    // 결과 DAO 생성 메서드
    public ResultDAO exec(RequestResultSaveDTO requestResultSaveDTO){

        // 입력 받은 userId로 유저 검색
        UserDAO userDAO = getUserDAOBean.exec(requestResultSaveDTO.getUserId());

        // 입력 받은 시간을 LocalDateTime으로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startedAt = LocalDateTime.parse(requestResultSaveDTO.getStartedAt(), formatter);
        LocalDateTime finishedAt = LocalDateTime.parse(requestResultSaveDTO.getFinishedAt(), formatter);

        // 결과 DAO 생성해 리턴
        return ResultDAO.builder()
                .resultId(UUID.randomUUID())
                .gameId(requestResultSaveDTO.getGameId())
                .userId(requestResultSaveDTO.getUserId())
                .nickname(userDAO.getNickname())
                .age(userDAO.getAge())
                .score(requestResultSaveDTO.getScore())
                .startedAt(startedAt)
                .finishedAt(finishedAt)
                .build();

    }
}
