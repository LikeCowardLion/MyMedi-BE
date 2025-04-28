package likecowardlion.mymedi.result.repository;

import likecowardlion.mymedi.result.domain.ResultDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ResultRepositoryJPA extends JpaRepository<ResultDAO, UUID> {

    List<ResultDAO> findByUserId(UUID userId);
    List<ResultDAO> findByUserIdAndStartedAtBetweenOrderByStartedAtAsc(UUID userId, LocalDateTime start, LocalDateTime end);

    @Query("""
    SELECT r
    FROM ResultDAO r
    WHERE r.userId = :userId
      AND r.gameId = :gameId
      AND r.score = (
            SELECT MAX(r2.score)
            FROM ResultDAO r2
            WHERE r2.userId = :userId
              AND r2.gameId = :gameId
              AND DATE(r2.startedAt) = DATE(r.startedAt)
      )
    ORDER BY r.startedAt DESC
    """)
    List<ResultDAO> findDailyMaxScores(UUID userId, UUID gameId);

}