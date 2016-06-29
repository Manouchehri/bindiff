package org.jfree.data.xy;

import java.util.Arrays;
import java.util.Date;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.OHLCDataset;

public class DefaultOHLCDataset extends AbstractXYDataset implements OHLCDataset {
   private Comparable key;
   private OHLCDataItem[] data;

   public DefaultOHLCDataset(Comparable var1, OHLCDataItem[] var2) {
      this.key = var1;
      this.data = var2;
   }

   public Comparable getSeriesKey(int var1) {
      return this.key;
   }

   public Number getX(int var1, int var2) {
      return new Long(this.data[var2].getDate().getTime());
   }

   public Date getXDate(int var1, int var2) {
      return this.data[var2].getDate();
   }

   public Number getY(int var1, int var2) {
      return this.getClose(var1, var2);
   }

   public Number getHigh(int var1, int var2) {
      return this.data[var2].getHigh();
   }

   public double getHighValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getHigh(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public Number getLow(int var1, int var2) {
      return this.data[var2].getLow();
   }

   public double getLowValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getLow(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public Number getOpen(int var1, int var2) {
      return this.data[var2].getOpen();
   }

   public double getOpenValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getOpen(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public Number getClose(int var1, int var2) {
      return this.data[var2].getClose();
   }

   public double getCloseValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getClose(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public Number getVolume(int var1, int var2) {
      return this.data[var2].getVolume();
   }

   public double getVolumeValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getVolume(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public int getSeriesCount() {
      return 1;
   }

   public int getItemCount(int var1) {
      return this.data.length;
   }

   public void sortDataByDate() {
      Arrays.sort(this.data);
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof DefaultOHLCDataset)) {
         return false;
      } else {
         DefaultOHLCDataset var2 = (DefaultOHLCDataset)var1;
         return !this.key.equals(var2.key)?false:Arrays.equals(this.data, var2.data);
      }
   }
}
