package games.driftingpixel.gamestore.models.db;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "games")
public class Game extends BaseDbModel {

  @ManyToOne
  private Category categories;

  /**
   * List of platforms, where game is available
   */
  @ManyToOne
  private Platform platforms;

  private Date firstReleaseDate;

  /**
   * List of companies involved to game release
   */
  @ManyToOne
  private Company companies;

  @OneToOne
  private Gallery gallery;
  private String igbUrl;
}
