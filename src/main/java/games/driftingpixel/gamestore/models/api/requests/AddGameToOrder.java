package games.driftingpixel.gamestore.models.api.requests;

import java.util.List;

import games.driftingpixel.gamestore.models.db.store.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddGameToOrder {
  
  private List<Long> games;
  private Long id;
  private User user;
}
