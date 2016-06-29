package org.jfree.data.xy;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.xy.YWithXInterval;

public class XIntervalDataItem extends ComparableObjectItem {
   public XIntervalDataItem(double var1, double var3, double var5, double var7) {
      super(new Double(var1), new YWithXInterval(var7, var3, var5));
   }

   public Number getX() {
      return (Number)this.getComparable();
   }

   public double getYValue() {
      YWithXInterval var1 = (YWithXInterval)this.getObject();
      return var1 != null?var1.getY():Double.NaN;
   }

   public double getXLowValue() {
      YWithXInterval var1 = (YWithXInterval)this.getObject();
      return var1 != null?var1.getXLow():Double.NaN;
   }

   public double getXHighValue() {
      YWithXInterval var1 = (YWithXInterval)this.getObject();
      return var1 != null?var1.getXHigh():Double.NaN;
   }
}
