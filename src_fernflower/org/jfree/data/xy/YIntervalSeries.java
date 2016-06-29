package org.jfree.data.xy;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.ComparableObjectSeries;
import org.jfree.data.xy.YIntervalDataItem;

public class YIntervalSeries extends ComparableObjectSeries {
   public YIntervalSeries(Comparable var1) {
      this(var1, true, true);
   }

   public YIntervalSeries(Comparable var1, boolean var2, boolean var3) {
      super(var1, var2, var3);
   }

   public void add(double var1, double var3, double var5, double var7) {
      super.add(new YIntervalDataItem(var1, var3, var5, var7), true);
   }

   public Number getX(int var1) {
      YIntervalDataItem var2 = (YIntervalDataItem)this.getDataItem(var1);
      return var2.getX();
   }

   public double getYValue(int var1) {
      YIntervalDataItem var2 = (YIntervalDataItem)this.getDataItem(var1);
      return var2.getYValue();
   }

   public double getYLowValue(int var1) {
      YIntervalDataItem var2 = (YIntervalDataItem)this.getDataItem(var1);
      return var2.getYLowValue();
   }

   public double getYHighValue(int var1) {
      YIntervalDataItem var2 = (YIntervalDataItem)this.getDataItem(var1);
      return var2.getYHighValue();
   }

   public ComparableObjectItem getDataItem(int var1) {
      return super.getDataItem(var1);
   }
}
