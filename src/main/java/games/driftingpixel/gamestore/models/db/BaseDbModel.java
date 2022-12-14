package games.driftingpixel.gamestore.models.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Data
@NoArgsConstructor
public class BaseDbModel {

  public BaseDbModel(Long id, String name, String summary, String slug, Date created, Date lastUpdate){
    this.id = id;
    this.name = name;
    this.summary = summary;
    this.slug = slug;
    this.created = created;
    this.lastUpdate = lastUpdate;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Long id;

  protected String name;

  @Column(length = 4096)
  protected String summary;

  /**
   * Url slug for selected object
   */
  protected String slug;

  protected Date created;
  protected Date lastUpdate;
}
