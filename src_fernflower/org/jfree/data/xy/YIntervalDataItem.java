package org.jfree.data.xy;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.xy.YInterval;

public class YIntervalDataItem extends ComparableObjectItem {
   public YIntervalDataItem(double var1, double var3, double var5, double var7) {
      super(new Double(var1), new YInterval(var3, var5, var7));
   }

   public Double getX() {
      return (Double)this.getComparable();
   }

   public double getYValue() {
      YInterval var1 = (YInterval)this.getObject();
      return var1 != null?var1.getY():Double.NaN;
   }

   public double getYLowValue() {
      YInterval var1 = (YInterval)this.getObject();
      return var1 != null?var1.getYLow():Double.NaN;
   }

   public double getYHighValue() {
      YInterval var1 = (YInterval)this.getObject();
      return var1 != null?var1.getYHigh():Double.NaN;
   }
}
