package games.driftingpixel.gamestore.repositories;

import games.driftingpixel.gamestore.models.db.store.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOrder extends JpaRepository<Order, Long>{
  
}
