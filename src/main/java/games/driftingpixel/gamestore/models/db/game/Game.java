package games.driftingpixel.gamestore.models.db.game;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import games.driftingpixel.gamestore.models.db.BaseDbModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "games")
@AllArgsConstructor
@NoArgsConstructor
public class Game extends BaseDbModel {

  @Builder
  public Game(Long id, String name, String summary, String slug, 
              Date created, Date lastUpdate, Category category, Platform platform, 
              Date firstReleaseDate, Company company, Gallery gallery, String igbUrl){
    super(id ,name, summary, slug, created, lastUpdate);
    this.category = category;
    this.platform = platform;
    this.firstReleaseDate = firstReleaseDate;
    this.company = company;
    this.gallery = gallery;
    this.igbUrl = igbUrl;
  }


  @ManyToOne
  private Category category;

  /**
   * Platform, where game is available
   */
  @ManyToOne
  private Platform platform;

  private Date firstReleaseDate;

  /**
   * Company involved to game release
   */
  @ManyToOne
  private Company company;

  @OneToOne
  private Gallery gallery;
  private String igbUrl;

  public void copyFromGame(Game game, boolean shouldCopyId){
    if(shouldCopyId){
      this.id = game.id;
    }

    this.name = game.name;
    this.summary = game.summary;
    this.slug = game.slug;
    this.created = game.created;
    this.lastUpdate = game.lastUpdate;
    this.category = game.category;
    this.platform = game.platform;
    this.firstReleaseDate = game.firstReleaseDate;
    this.company = game.company;
    this.gallery = game.gallery;
    this.igbUrl = game.igbUrl;
  }
}
