package games.driftingpixel.gamestore.utility.comparators;

import java.util.Comparator;

import games.driftingpixel.gamestore.models.interfaces.ICreatedAndLastUpdateDates;
import lombok.Data;

@Data
public class ComparatorSortByDate implements Comparator<ICreatedAndLastUpdateDates>
{
    /**
     * Should be compare for sorting ascending
     * false = desc
     */
    private boolean asc;

    public ComparatorSortByDate(boolean asc){
      this.asc = asc;
    }
    public int compare(ICreatedAndLastUpdateDates el1, ICreatedAndLastUpdateDates el2)
    {
        return el2.getLastUpdate().compareTo(el1.getLastUpdate()) * (asc ? 1 : -1);
    }
}
