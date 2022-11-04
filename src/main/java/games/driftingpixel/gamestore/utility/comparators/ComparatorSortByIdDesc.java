package games.driftingpixel.gamestore.utility.comparators;

import java.util.Comparator;

import games.driftingpixel.gamestore.models.db.BaseDbModel;

public class ComparatorSortByIdDesc implements Comparator<BaseDbModel>
 {
     public int compare(BaseDbModel el1, BaseDbModel el2)
     {
         return el2.getId().compareTo(el1.getId());
     }
 }
