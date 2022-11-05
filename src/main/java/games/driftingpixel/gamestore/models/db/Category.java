package games.driftingpixel.gamestore.models.db;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Categories")
@NoArgsConstructor
public class Category extends BaseDbModel {

  @Builder
  public Category(Long id, String name, String summary, String slug, Date created, Date lastUpdate){
    super(id, name, summary, slug, created, lastUpdate);
  }
}
