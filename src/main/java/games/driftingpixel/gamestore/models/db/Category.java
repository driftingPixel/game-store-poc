package games.driftingpixel.gamestore.models.db;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Categories")
public class Category extends BaseDbModel {
}
