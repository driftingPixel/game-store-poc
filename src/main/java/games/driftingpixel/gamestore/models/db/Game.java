package games.driftingpixel.gamestore.models.db;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "games")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Game extends BaseDbModel {

  @Builder
  public Game(Long id, String name, String summary, String slug, Date created, Date lastUpdate, Category categories, Platform platforms, Date firstReleaseDate, Company companies, Gallery gallery, String igbUrl){
    super(id ,name, summary, slug, created, lastUpdate);
    this.categories = categories;
    this.platforms = platforms;
    this.firstReleaseDate = firstReleaseDate;
    this.companies = companies;
    this.gallery = gallery;
    this.igbUrl = igbUrl;
  }


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

  public void copyFromGame(Game game, boolean copyId){
    if(copyId){
      this.id = game.id;
    }

    this.name = game.name;
    this.summary = game.summary;
    this.slug = game.slug;
    this.created = game.created;
    this.lastUpdate = game.lastUpdate;
    this.categories = game.categories;
    this.platforms = game.platforms;
    this.firstReleaseDate = game.firstReleaseDate;
    this.companies = game.companies;
    this.gallery = game.gallery;
    this.igbUrl = game.igbUrl;
  }
}
