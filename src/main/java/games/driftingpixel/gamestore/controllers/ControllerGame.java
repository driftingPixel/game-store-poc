package games.driftingpixel.gamestore.controllers;

import java.util.List;

import games.driftingpixel.gamestore.models.db.Game;
import games.driftingpixel.gamestore.models.exceptions.WrongIdException;
import games.driftingpixel.gamestore.repositories.RepositoryGame;
import games.driftingpixel.gamestore.services.ServiceGame;
import games.driftingpixel.gamestore.utility.comparators.ComparatorSortByIdDesc;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class ControllerGame {

  private static final String ENDPOINT_PREFIX = "/games";

  private final ServiceGame serviceGame;

  //Part for all users

  @GetMapping(ControllerGame.ENDPOINT_PREFIX + "/{id}")
  ResponseEntity<Game> one(@PathVariable Long id) {
    log.info("Endpoint -> Game by id: {}", id);
    return  ResponseEntity.ok(serviceGame.getGameById(id));
  }

  /**
   * eg request: /games?page=3&size=10
   * @param pageable
   * @return all games with pagination
   */
  @GetMapping(params = { "page", "size" }, path=ControllerGame.ENDPOINT_PREFIX )
  ResponseEntity<Page<Game>> getPageable(@SortDefault(sort = "id") @PageableDefault(size = 20) final Pageable pageable) {
    log.info("Endpoint -> Games by page: {}", pageable);
    Page<Game> result = serviceGame.getGamesPageable(pageable);
   
    return ResponseEntity.ok(result);
  }

  // Part for registered users / admins

  /**
   * @return all games sorted by id desc
   */
  @GetMapping(ControllerGame.ENDPOINT_PREFIX)
  ResponseEntity<List<Game>> all() {
    log.info("Endpoint -> Get all games");
    List<Game> result = serviceGame.getAllGames();
    result.sort(new ComparatorSortByIdDesc());
    return  ResponseEntity.ok(result);
  }

  


  @PostMapping(ControllerGame.ENDPOINT_PREFIX)
  ResponseEntity<Game> newGame(@RequestBody Game newGame) {
    log.info("Endpoint -> Add new game: {}", newGame);
    return  ResponseEntity.ok(serviceGame.addNewGame(newGame));
  }

  @PutMapping(ControllerGame.ENDPOINT_PREFIX + "/{id}")
  ResponseEntity<Game> replaceElement(@RequestBody Game newGame, @PathVariable Long id) {
    log.info("Endpoint -> Update game: id {}, newGame {}", id, newGame);
    return  ResponseEntity.ok(serviceGame.updateGame(newGame, id));
  }

  @DeleteMapping(ControllerGame.ENDPOINT_PREFIX + "/{id}")
  void delete(@PathVariable Long id) {
    log.info("Endpoint -> Delete game by id: {}", id);
    serviceGame.deleteGame(id);
  }
  
}
