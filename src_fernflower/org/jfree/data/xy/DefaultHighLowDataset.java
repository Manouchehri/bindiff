package org.jfree.data.xy;

import java.util.Arrays;
import java.util.Date;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.OHLCDataset;

public class DefaultHighLowDataset extends AbstractXYDataset implements OHLCDataset {
   private Comparable seriesKey;
   private Date[] date;
   private Number[] high;
   private Number[] low;
   private Number[] open;
   private Number[] close;
   private Number[] volume;

   public DefaultHighLowDataset(Comparable var1, Date[] var2, double[] var3, double[] var4, double[] var5, double[] var6, double[] var7) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'series\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'date\' argument.");
      } else {
         this.seriesKey = var1;
         this.date = var2;
         this.high = createNumberArray(var3);
         this.low = createNumberArray(var4);
         this.open = createNumberArray(var5);
         this.close = createNumberArray(var6);
         this.volume = createNumberArray(var7);
      }
   }

   public Comparable getSeriesKey(int var1) {
      return this.seriesKey;
   }

   public Number getX(int var1, int var2) {
      return new Long(this.date[var2].getTime());
   }

   public Date getXDate(int var1, int var2) {
      return this.date[var2];
   }

   public Number getY(int var1, int var2) {
      return this.getClose(var1, var2);
   }

   public Number getHigh(int var1, int var2) {
      return this.high[var2];
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
      return this.low[var2];
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
      return this.open[var2];
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
      return this.close[var2];
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
      return this.volume[var2];
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
      return this.date.length;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof DefaultHighLowDataset)) {
         return false;
      } else {
         DefaultHighLowDataset var2 = (DefaultHighLowDataset)var1;
         return !this.seriesKey.equals(var2.seriesKey)?false:(!Arrays.equals(this.date, var2.date)?false:(!Arrays.equals(this.open, var2.open)?false:(!Arrays.equals(this.high, var2.high)?false:(!Arrays.equals(this.low, var2.low)?false:(!Arrays.equals(this.close, var2.close)?false:Arrays.equals(this.volume, var2.volume))))));
      }
   }

   public static Number[] createNumberArray(double[] var0) {
      Number[] var1 = new Number[var0.length];

      for(int var2 = 0; var2 < var0.length; ++var2) {
         var1[var2] = new Double(var0[var2]);
      }

      return var1;
   }
}
