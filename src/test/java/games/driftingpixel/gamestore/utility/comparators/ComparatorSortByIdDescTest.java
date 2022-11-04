package games.driftingpixel.gamestore.utility.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Comparator;

import games.driftingpixel.gamestore.models.db.BaseDbModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ComparatorSortByIdDescTest {

  @Mock
  BaseDbModel model1;

  @Mock
  BaseDbModel model2;

  Comparator<BaseDbModel> comparator;

  @BeforeEach
  public void init() {
    comparator = new ComparatorSortByIdDesc();

    when(model1.getId()).thenReturn(145l);
    when(model1.getId()).thenReturn(2l);
  }


  @Test
  void testCompare() {
    
    assertEquals(-1, comparator.compare(model1, model2));
    assertEquals(1, comparator.compare(model2, model1));
    assertEquals(0, comparator.compare(model1, model1));
    assertEquals(0, comparator.compare(model2, model2));
  }
}
