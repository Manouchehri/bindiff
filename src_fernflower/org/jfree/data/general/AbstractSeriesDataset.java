package org.jfree.data.general;

import java.io.Serializable;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.general.SeriesDataset;

public abstract class AbstractSeriesDataset extends AbstractDataset implements Serializable, SeriesChangeListener, SeriesDataset {
   private static final long serialVersionUID = -6074996219705033171L;

   public abstract int getSeriesCount();

   public abstract Comparable getSeriesKey(int var1);

   public int indexOf(Comparable var1) {
      int var2 = this.getSeriesCount();

      for(int var3 = 0; var3 < var2; ++var3) {
         if(this.getSeriesKey(var3).equals(var1)) {
            return var3;
         }
      }

      return -1;
   }

   public void seriesChanged(SeriesChangeEvent var1) {
      this.fireDatasetChanged();
   }
}
