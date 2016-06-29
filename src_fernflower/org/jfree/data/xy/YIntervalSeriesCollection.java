package org.jfree.data.xy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.util.ObjectUtilities;

public class YIntervalSeriesCollection extends AbstractIntervalXYDataset implements Serializable, IntervalXYDataset {
   private List data = new ArrayList();

   public void addSeries(YIntervalSeries var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'series\' argument.");
      } else {
         this.data.add(var1);
         var1.addChangeListener(this);
         this.fireDatasetChanged();
      }
   }

   public int getSeriesCount() {
      return this.data.size();
   }

   public YIntervalSeries getSeries(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         return (YIntervalSeries)this.data.get(var1);
      } else {
         throw new IllegalArgumentException("Series index out of bounds");
      }
   }

   public Comparable getSeriesKey(int var1) {
      return this.getSeries(var1).getKey();
   }

   public int getItemCount(int var1) {
      return this.getSeries(var1).getItemCount();
   }

   public Number getX(int var1, int var2) {
      YIntervalSeries var3 = (YIntervalSeries)this.data.get(var1);
      return var3.getX(var2);
   }

   public double getYValue(int var1, int var2) {
      YIntervalSeries var3 = (YIntervalSeries)this.data.get(var1);
      return var3.getYValue(var2);
   }

   public double getStartYValue(int var1, int var2) {
      YIntervalSeries var3 = (YIntervalSeries)this.data.get(var1);
      return var3.getYLowValue(var2);
   }

   public double getEndYValue(int var1, int var2) {
      YIntervalSeries var3 = (YIntervalSeries)this.data.get(var1);
      return var3.getYHighValue(var2);
   }

   public Number getY(int var1, int var2) {
      YIntervalSeries var3 = (YIntervalSeries)this.data.get(var1);
      return new Double(var3.getYValue(var2));
   }

   public Number getStartX(int var1, int var2) {
      return this.getX(var1, var2);
   }

   public Number getEndX(int var1, int var2) {
      return this.getX(var1, var2);
   }

   public Number getStartY(int var1, int var2) {
      YIntervalSeries var3 = (YIntervalSeries)this.data.get(var1);
      return new Double(var3.getYLowValue(var2));
   }

   public Number getEndY(int var1, int var2) {
      YIntervalSeries var3 = (YIntervalSeries)this.data.get(var1);
      return new Double(var3.getYHighValue(var2));
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof YIntervalSeriesCollection)) {
         return false;
      } else {
         YIntervalSeriesCollection var2 = (YIntervalSeriesCollection)var1;
         return ObjectUtilities.equal(this.data, var2.data);
      }
   }

   public Object clone() {
      YIntervalSeriesCollection var1 = (YIntervalSeriesCollection)super.clone();
      var1.data = (List)ObjectUtilities.deepClone(this.data);
      return var1;
   }
}
