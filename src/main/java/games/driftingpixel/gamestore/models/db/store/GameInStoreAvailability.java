package games.driftingpixel.gamestore.models.db.store;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import games.driftingpixel.gamestore.models.db.game.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "game_availabilities")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameInStoreAvailability {
  
  @Id
  private Long id;
  @OneToOne
  private Game game;
  private int availability;
  private Date lastUpdate;

  public boolean isAvailable(){
    return availability > 0;
  }
}
