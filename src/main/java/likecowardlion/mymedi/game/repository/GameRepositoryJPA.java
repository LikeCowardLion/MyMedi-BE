package likecowardlion.mymedi.game.repository;

import likecowardlion.mymedi.game.domain.GameDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameRepositoryJPA extends JpaRepository<GameDAO, UUID> {
}
