package games.driftingpixel.gamestore.models.db.game;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import games.driftingpixel.gamestore.models.db.BaseDbModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Companies")
@NoArgsConstructor
public class Company extends BaseDbModel {

  private String url;

  @Builder
  public Company(Long id, String name, String summary, String slug, Date created, Date lastUpdate, String url){
    super(id, name, summary, slug, created, lastUpdate);
    this.url = url;
  }
  
}
