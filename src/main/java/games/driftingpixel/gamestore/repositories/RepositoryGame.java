package games.driftingpixel.gamestore.repositories;

import java.util.List;
import java.util.Optional;

import games.driftingpixel.gamestore.models.db.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryGame extends JpaRepository<Game, Long>
{
    Optional<Game> findById(Long id);
    
    Page<Game> findAll(Pageable pageable);

    // @Modifying
    // @Query(value = "DELETE FROM CasinoToken ct WHERE ct.creationDate < :creationDate")
    // void deleteAllByCreationDateBefore(@Param("creationDate")LocalDateTime creationDate);
}

