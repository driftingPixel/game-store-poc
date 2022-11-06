package games.driftingpixel.gamestore.models.db.store;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import games.driftingpixel.gamestore.models.exceptions.GameNotAvailableException;
import games.driftingpixel.gamestore.models.interfaces.ICreatedAndLastUpdateDates;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order implements ICreatedAndLastUpdateDates{

  @Id
  private Long id;

  private OrderStatus status;
  @OneToMany
  private List<GameInStoreAvailability> games;
  @ManyToOne
  private User user;
  protected Date created;
  protected Date lastUpdate;


  public Order finish(){
    List<GameInStoreAvailability> unavailableGame = this.games
                                                      .stream()
                                                      .filter(game -> !game.isAvailable())
                                                      .toList();
    
    if(!unavailableGame.isEmpty()){
      throw new GameNotAvailableException(unavailableGame);
    }
    return this;
  }
}


