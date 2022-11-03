package games.driftingpixel.gamestore.models.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Companies")
public class Company extends BaseDbModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Long id;

  private String url;
  
}
