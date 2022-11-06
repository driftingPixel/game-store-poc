package games.driftingpixel.gamestore.services;

import java.util.List;

import games.driftingpixel.gamestore.models.db.store.Order;
import games.driftingpixel.gamestore.models.exceptions.WrongIdException;
import games.driftingpixel.gamestore.repositories.RepositoryOrder;
import games.driftingpixel.gamestore.utility.comparators.ComparatorSortByDate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ServiceOrder {

  private RepositoryOrder repositoryOrder;

  /***
   * 
   * @param id
   * @return Order from repository with selected id 
   */
  public Order getOrderById( Long id) throws WrongIdException {
    return repositoryOrder.findById(id).orElseThrow(() -> new WrongIdException());
  }


  /***
   * 
   * @return all orders sorted by id desc
   */
  public List<Order> getAll() {
    List<Order> result = repositoryOrder.findAll();
    log.debug("All Order list from repository has {} orders", result.size());
    log.trace("All Order list from repository: {}", result);
    result.sort(new ComparatorSortByDate(false));
    return result;
  }

  /**
   * @param pageable
   * @return all order with pagination
   */
  public Page<Order> getPageable(Pageable pageable) {
    Page<Order> result = repositoryOrder.findAll(pageable);
    log.debug("Page of orders has {} orders", result.getNumberOfElements());
    log.trace("Order page from repository: {} for pageable {}", result, pageable);
    return result;
  }

  /***
   * Add new order to db
   * @param newGame
   * @return
   */
  public Order addNew(Order newOrder) {
    // log.debug("Add new order: {}", newOrder);
    // return repositoryOrder.save(newOrder);
    
    //Save to redis
    return null;
  }

  // /***
  //  * Update select game by new game data
  //  * @param newGame
  //  * @param id
  //  * @return
  //  */
  // public Game updateGame(Game newGame, Long id) {
  //   log.debug("update game: id {}, newGame {}", id, newGame);
  //   return repositoryOrder.findById(id)
  //       .map((game) -> { 
  //         log.debug("Game before update {}", game);
  //         game.copyFromGame(newGame, false);
  //         return repositoryOrder.save(game);
  //       })
  //       .orElseGet(() -> {
  //         newGame.setId(id);
  //         return repositoryOrder.save(newGame);
  //       });
  // }

  // /***
  //  * Delete game from db
  //  * @param id
  //  */
  // public void deleteGame(Long id) {
  //   log.debug("Remove game by id: {}", id);
  //   repositoryOrder.deleteById(id);
  // }
  
}
