package org.jfree.data.xy;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.xy.XYInterval;

public class XYIntervalDataItem extends ComparableObjectItem {
   public XYIntervalDataItem(double var1, double var3, double var5, double var7, double var9, double var11) {
      super(new Double(var1), new XYInterval(var3, var5, var7, var9, var11));
   }

   public Double getX() {
      return (Double)this.getComparable();
   }

   public double getYValue() {
      XYInterval var1 = (XYInterval)this.getObject();
      return var1 != null?var1.getY():Double.NaN;
   }

   public double getXLowValue() {
      XYInterval var1 = (XYInterval)this.getObject();
      return var1 != null?var1.getXLow():Double.NaN;
   }

   public double getXHighValue() {
      XYInterval var1 = (XYInterval)this.getObject();
      return var1 != null?var1.getXHigh():Double.NaN;
   }

   public double getYLowValue() {
      XYInterval var1 = (XYInterval)this.getObject();
      return var1 != null?var1.getYLow():Double.NaN;
   }

   public double getYHighValue() {
      XYInterval var1 = (XYInterval)this.getObject();
      return var1 != null?var1.getYHigh():Double.NaN;
   }
}
