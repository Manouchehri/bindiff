package org.jfree.data.xy;

import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class XYBarDataset extends AbstractIntervalXYDataset implements DatasetChangeListener, IntervalXYDataset {
   private XYDataset underlying;
   private double barWidth;

   public XYBarDataset(XYDataset var1, double var2) {
      this.underlying = var1;
      this.underlying.addChangeListener(this);
      this.barWidth = var2;
   }

   public XYDataset getUnderlyingDataset() {
      return this.underlying;
   }

   public double getBarWidth() {
      return this.barWidth;
   }

   public void setBarWidth(double var1) {
      this.barWidth = var1;
      this.notifyListeners(new DatasetChangeEvent(this, this));
   }

   public int getSeriesCount() {
      return this.underlying.getSeriesCount();
   }

   public Comparable getSeriesKey(int var1) {
      return this.underlying.getSeriesKey(var1);
   }

   public int getItemCount(int var1) {
      return this.underlying.getItemCount(var1);
   }

   public Number getX(int var1, int var2) {
      return this.underlying.getX(var1, var2);
   }

   public double getXValue(int var1, int var2) {
      return this.underlying.getXValue(var1, var2);
   }

   public Number getY(int var1, int var2) {
      return this.underlying.getY(var1, var2);
   }

   public double getYValue(int var1, int var2) {
      return this.underlying.getYValue(var1, var2);
   }

   public Number getStartX(int var1, int var2) {
      Double var3 = null;
      Number var4 = this.underlying.getX(var1, var2);
      if(var4 != null) {
         var3 = new Double(var4.doubleValue() - this.barWidth / 2.0D);
      }

      return var3;
   }

   public double getStartXValue(int var1, int var2) {
      return this.getXValue(var1, var2) - this.barWidth / 2.0D;
   }

   public Number getEndX(int var1, int var2) {
      Double var3 = null;
      Number var4 = this.underlying.getX(var1, var2);
      if(var4 != null) {
         var3 = new Double(var4.doubleValue() + this.barWidth / 2.0D);
      }

      return var3;
   }

   public double getEndXValue(int var1, int var2) {
      return this.getXValue(var1, var2) + this.barWidth / 2.0D;
   }

   public Number getStartY(int var1, int var2) {
      return this.underlying.getY(var1, var2);
   }

   public double getStartYValue(int var1, int var2) {
      return this.getYValue(var1, var2);
   }

   public Number getEndY(int var1, int var2) {
      return this.underlying.getY(var1, var2);
   }

   public double getEndYValue(int var1, int var2) {
      return this.getYValue(var1, var2);
   }

   public void datasetChanged(DatasetChangeEvent var1) {
      this.notifyListeners(var1);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYBarDataset)) {
         return false;
      } else {
         XYBarDataset var2 = (XYBarDataset)var1;
         return !this.underlying.equals(var2.underlying)?false:this.barWidth == var2.barWidth;
      }
   }

   public Object clone() {
      XYBarDataset var1 = (XYBarDataset)super.clone();
      if(this.underlying instanceof PublicCloneable) {
         var1.underlying = (XYDataset)((PublicCloneable)this.underlying).clone();
      }

      return var1;
   }
}
