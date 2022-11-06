package games.driftingpixel.gamestore.utility.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import games.driftingpixel.gamestore.models.db.store.Order;
import org.junit.jupiter.api.Test;

public class ComparatorSortByDateTest {

  @Test
  void testCompare() {
    Order order1 = Order.builder().lastUpdate(new Date()).build();
    Order order2 = Order.builder().lastUpdate(new Date(order1.getLastUpdate().getTime() + 1000)).build();

    ComparatorSortByDate comparator = new ComparatorSortByDate(true);

    assertTrue(comparator.isAsc());
    assertEquals(1, comparator.compare(order1, order2));
    assertEquals(-1, comparator.compare(order2, order1));

    comparator.setAsc(false);
    assertFalse(comparator.isAsc());
    assertEquals(-1, comparator.compare(order1, order2));
    assertEquals(1, comparator.compare(order2, order1));
  }
}
