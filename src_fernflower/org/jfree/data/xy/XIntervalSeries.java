package org.jfree.data.xy;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.ComparableObjectSeries;
import org.jfree.data.xy.XIntervalDataItem;

public class XIntervalSeries extends ComparableObjectSeries {
   public XIntervalSeries(Comparable var1) {
      this(var1, true, true);
   }

   public XIntervalSeries(Comparable var1, boolean var2, boolean var3) {
      super(var1, var2, var3);
   }

   public void add(double var1, double var3, double var5, double var7) {
      super.add(new XIntervalDataItem(var1, var3, var5, var7), true);
   }

   public Number getX(int var1) {
      XIntervalDataItem var2 = (XIntervalDataItem)this.getDataItem(var1);
      return var2.getX();
   }

   public double getYValue(int var1) {
      XIntervalDataItem var2 = (XIntervalDataItem)this.getDataItem(var1);
      return var2.getYValue();
   }

   public ComparableObjectItem getDataItem(int var1) {
      return super.getDataItem(var1);
   }
}
