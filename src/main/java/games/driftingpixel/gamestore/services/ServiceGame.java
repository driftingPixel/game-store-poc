package games.driftingpixel.gamestore.services;

import java.util.List;

import games.driftingpixel.gamestore.models.db.game.Game;
import games.driftingpixel.gamestore.models.exceptions.WrongIdException;
import games.driftingpixel.gamestore.repositories.RepositoryGame;
import games.driftingpixel.gamestore.utility.comparators.ComparatorSortByIdDesc;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ServiceGame {

  private RepositoryGame repositoryGame;

  /***
   * 
   * @param id
   * @return Game from repository with selected id 
   */
  public Game getGameById( Long id) throws WrongIdException {
    return repositoryGame.findById(id).orElseThrow(() -> new WrongIdException());
  }


  /***
   * 
   * @return all games sorted by id desc
   */
  public List<Game> getAllGames() {
    List<Game> result = repositoryGame.findAll();
    log.debug("All Game list from repository has {} games", result.size());
    log.trace("All Game list from repository: {}", result);
    result.sort(new ComparatorSortByIdDesc());
    return result;
  }

  /**
   * @param pageable
   * @return all games with pagination
   */
  public Page<Game> getGamesPageable(Pageable pageable) {
    Page<Game> result = repositoryGame.findAll(pageable);
    log.debug("Page of games as {} games", result.getNumberOfElements());
    log.trace("Game page from repository: {} for pageable {}", result, pageable);
    return result;
  }

  /***
   * Add new game to db
   * @param newGame
   * @return
   */
  public Game addNewGame(Game newGame) {
    log.debug("Add new game: {}", newGame);
    return repositoryGame.save(newGame);
  }

  /***
   * Update select game by new game data
   * @param newGame
   * @param id
   * @return
   */
  public Game updateGame(Game newGame, Long id) {
    log.debug("update game: id {}, newGame {}", id, newGame);
    return repositoryGame.findById(id)
        .map((game) -> { 
          log.debug("Game before update {}", game);
          game.copyFromGame(newGame, false);
          return repositoryGame.save(game);
        })
        .orElseGet(() -> {
          newGame.setId(id);
          return repositoryGame.save(newGame);
        });
  }

  /***
   * Delete game from db
   * @param id
   */
  public void deleteGame(Long id) {
    log.debug("Remove game by id: {}", id);
    repositoryGame.deleteById(id);
  }
  

  public List<Game> getManyGamesByIds(List<Long> gameIds){
    return repositoryGame.findAllById(gameIds);
  }
}
