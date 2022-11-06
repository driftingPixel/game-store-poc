package games.driftingpixel.gamestore.models.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class GameTest {

  Category category;

  @Test
  void testCopyFromGame() {

    Game game1 = Game.builder()
                  .id(1l)
                  .name("name")
                  .summary("summary")
                  .build();

    Game game2 = Game.builder()
                  .id(3l)
                  .name("name2")
                  .summary("summary2")
                  .slug("Slug")
                  .created(new Date())
                  .lastUpdate(new Date())
                  .firstReleaseDate(new Date())
                  .igbUrl("igbUrl")
                  .gallery(new Gallery())
                  .categories(new Category())
                  .platforms(new Platform())
                  .companies(new Company())
                  .build();
    
    assertNull(game1.getGallery());
    assertNull(game1.getIgbUrl());
    assertNull(game1.getSlug());

    assertNotEquals(game1, game2);

    game1.copyFromGame(game2, false);

    assertNotNull(game1.getGallery());
    assertNotNull(game1.getIgbUrl());
    assertNotNull(game1.getSlug());
    assertNotNull(game1.getPlatforms());
    assertNotNull(game1.getCompanies());
    assertNotNull(game1.getGallery());
    assertNotNull(game1.getCreated());

    assertNotEquals(game1, game2);

    game1.copyFromGame(game2, true);

    assertNotNull(game1.getGallery());
    assertNotNull(game1.getIgbUrl());
    assertNotNull(game1.getSlug());
    
    assertEquals(game1, game2);
  }
}
