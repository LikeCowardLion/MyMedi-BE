package likecowardlion.mymedi.result.repository;

import likecowardlion.mymedi.result.domain.ResultDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ResultRepositoryJPA extends JpaRepository<ResultDAO, UUID> {

    List<ResultDAO> findByUserId(UUID userId);

}