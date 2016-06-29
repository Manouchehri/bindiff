package org.jfree.data.time.ohlc;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.ohlc.OHLC;

public class OHLCItem extends ComparableObjectItem {
   public OHLCItem(RegularTimePeriod var1, double var2, double var4, double var6, double var8) {
      super(var1, new OHLC(var2, var4, var6, var8));
   }

   public RegularTimePeriod getPeriod() {
      return (RegularTimePeriod)this.getComparable();
   }

   public double getYValue() {
      return this.getCloseValue();
   }

   public double getOpenValue() {
      OHLC var1 = (OHLC)this.getObject();
      return var1 != null?var1.getOpen():Double.NaN;
   }

   public double getHighValue() {
      OHLC var1 = (OHLC)this.getObject();
      return var1 != null?var1.getHigh():Double.NaN;
   }

   public double getLowValue() {
      OHLC var1 = (OHLC)this.getObject();
      return var1 != null?var1.getLow():Double.NaN;
   }

   public double getCloseValue() {
      OHLC var1 = (OHLC)this.getObject();
      return var1 != null?var1.getClose():Double.NaN;
   }
}
