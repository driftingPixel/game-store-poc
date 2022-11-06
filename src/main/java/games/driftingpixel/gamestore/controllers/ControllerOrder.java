package games.driftingpixel.gamestore.controllers;

import java.util.List;

import games.driftingpixel.gamestore.models.db.game.Game;
import games.driftingpixel.gamestore.models.db.store.Order;
import games.driftingpixel.gamestore.services.ServiceOrder;
import games.driftingpixel.gamestore.utility.comparators.ComparatorSortByDate;
import games.driftingpixel.gamestore.utility.comparators.ComparatorSortByIdDesc;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class ControllerOrder {

  private static final String ENDPOINT_PREFIX = "/orders";

  private final ServiceOrder serviceOrder;

  //Part for all users

  @GetMapping(ControllerOrder.ENDPOINT_PREFIX + "/{id}")
  ResponseEntity<Order> one(@PathVariable Long id) {
    log.info("Endpoint -> Order by id: {}", id);
    return  ResponseEntity.ok(serviceOrder.getOrderById(id));
  }

  /**
   * eg request: /games?page=3&size=10
   * @param pageable
   * @return all games with pagination
   */
  @GetMapping(params = { "page", "size" }, path=ControllerOrder.ENDPOINT_PREFIX )
  ResponseEntity<Page<Order>> getPageable(@SortDefault(sort = "id") @PageableDefault(size = 20) final Pageable pageable) {
    log.info("Endpoint -> Games by page: {}", pageable);
    Page<Order> result = serviceOrder.getPageable(pageable);
   
    return ResponseEntity.ok(result);
  }

  // Part for registered users / admins

  /**
   * @return all games sorted by id desc
   */
  @GetMapping(ControllerOrder.ENDPOINT_PREFIX)
  ResponseEntity<List<Order>> all() {
    log.info("Endpoint -> Get all games");
    List<Order> result = serviceOrder.getAll();
    return  ResponseEntity.ok(result);
  }



  @PostMapping(ControllerOrder.ENDPOINT_PREFIX)
  ResponseEntity<Order> addNew(@RequestBody Order newOrder) {
    log.info("Endpoint -> Add new game: {}", newOrder);
    return  ResponseEntity.ok(serviceOrder.addNew(newOrder));
  }

  // @PutMapping(ControllerOrder.ENDPOINT_PREFIX + "/{id}")
  // ResponseEntity<Game> replaceElement(@RequestBody Game newGame, @PathVariable Long id) {
  //   log.info("Endpoint -> Update game: id {}, newGame {}", id, newGame);
  //   return  ResponseEntity.ok(serviceOrder.updateGame(newGame, id));
  // }

  // @DeleteMapping(ControllerOrder.ENDPOINT_PREFIX + "/{id}")
  // void delete(@PathVariable Long id) {
  //   log.info("Endpoint -> Delete game by id: {}", id);
  //   serviceOrder.deleteGame(id);
  // }
  
}
