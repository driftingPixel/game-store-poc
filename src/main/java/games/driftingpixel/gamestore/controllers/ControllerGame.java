package games.driftingpixel.gamestore.controllers;

import java.util.List;

import games.driftingpixel.gamestore.models.db.Game;
import games.driftingpixel.gamestore.models.exceptions.WrongIdException;
import games.driftingpixel.gamestore.repositories.RepositoryGame;
import games.driftingpixel.gamestore.utility.comparators.ComparatorSortByIdDesc;
import lombok.AllArgsConstructor;
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
public class ControllerGame {

  private static final String ENDPOINT_PREFIX = "/games";

  private final RepositoryGame repositoryGame;

  //Par for all users

  @GetMapping(ControllerGame.ENDPOINT_PREFIX + "/{id}")
  Game one(@PathVariable Long id) {
    return repositoryGame.findById(id).orElseThrow(() -> new WrongIdException());
  }

  // Part for registered users / admins

  /**
   * Get all games sorted by id desc
   * @return
   */
  @GetMapping(ControllerGame.ENDPOINT_PREFIX)
  List<Game> all() {
    List<Game> result = repositoryGame.findAll();
    result.sort(new ComparatorSortByIdDesc());
    return result;
  }

  /**
   * Get all games with pagination
   * eg request: /games?page=3&size=10
   * @param pageable
   * @return
   */
  @GetMapping(params = { "page", "size" }, path=ControllerGame.ENDPOINT_PREFIX )
  ResponseEntity<Page<Game>> getPageable(@SortDefault(sort = "id") @PageableDefault(size = 20) final Pageable pageable) {

    Page<Game> result = repositoryGame.findAll(pageable);
   
    return ResponseEntity.ok(result);
  }


  @PostMapping(ControllerGame.ENDPOINT_PREFIX)
  Game newElement(@RequestBody Game newGame) {
    return repositoryGame.save(newGame);
  }

  @PutMapping(ControllerGame.ENDPOINT_PREFIX + "/{id}")
  Game replaceElement(@RequestBody Game newGame, @PathVariable Long id) {
    
    // return repositoryGame.findById(id)
    //   .map(employee -> {
    //     employee.setName(newEmployee.getName());
    //     employee.setRole(newEmployee.getRole());
    //     return repository.save(employee);
    //   })
    //   .orElseGet(() -> {
    //     newEmployee.setId(id);
    //     return repository.save(newEmployee);
    //   });
    return newGame;
  }

  @DeleteMapping(ControllerGame.ENDPOINT_PREFIX + "/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repositoryGame.deleteById(id);
  }
  
}
