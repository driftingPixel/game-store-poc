package games.driftingpixel.gamestore.models.db;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Games")
public class Game extends BaseDbModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Long id;

  @OneToMany
  private List<Category> categories;

  /**
   * List of platforms, where game is available
   */
  @OneToMany
  private List<Platform> platforms;

  private Date firstReleaseTime;

  /**
   * List of companies involved to game release
   */
  @OneToMany
  private List<Company> companies;

  @OneToOne
  private Gallery gallery;
  private String igbUrl;
  
  private Date created;
  private Date lastUpdate;
}
