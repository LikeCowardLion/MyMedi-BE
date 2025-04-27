package likecowardlion.mymedi.user.repository;

import likecowardlion.mymedi.user.domain.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepositoryJPA extends JpaRepository<UserDAO, UUID> {

    UserDAO findByEmailIdAndIsDeleted(String emailId, Boolean isDeleted);

}
