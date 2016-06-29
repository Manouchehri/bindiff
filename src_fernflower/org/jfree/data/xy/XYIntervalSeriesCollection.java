package org.jfree.data.xy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.util.ObjectUtilities;

public class XYIntervalSeriesCollection extends AbstractIntervalXYDataset implements Serializable, IntervalXYDataset {
   private List data = new ArrayList();

   public void addSeries(XYIntervalSeries var1) {
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

   public XYIntervalSeries getSeries(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         return (XYIntervalSeries)this.data.get(var1);
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
      XYIntervalSeries var3 = (XYIntervalSeries)this.data.get(var1);
      return var3.getX(var2);
   }

   public double getStartXValue(int var1, int var2) {
      XYIntervalSeries var3 = (XYIntervalSeries)this.data.get(var1);
      return var3.getXLowValue(var2);
   }

   public double getEndXValue(int var1, int var2) {
      XYIntervalSeries var3 = (XYIntervalSeries)this.data.get(var1);
      return var3.getXHighValue(var2);
   }

   public double getYValue(int var1, int var2) {
      XYIntervalSeries var3 = (XYIntervalSeries)this.data.get(var1);
      return var3.getYValue(var2);
   }

   public double getStartYValue(int var1, int var2) {
      XYIntervalSeries var3 = (XYIntervalSeries)this.data.get(var1);
      return var3.getYLowValue(var2);
   }

   public double getEndYValue(int var1, int var2) {
      XYIntervalSeries var3 = (XYIntervalSeries)this.data.get(var1);
      return var3.getYHighValue(var2);
   }

   public Number getY(int var1, int var2) {
      return new Double(this.getYValue(var1, var2));
   }

   public Number getStartX(int var1, int var2) {
      return new Double(this.getStartXValue(var1, var2));
   }

   public Number getEndX(int var1, int var2) {
      return new Double(this.getEndXValue(var1, var2));
   }

   public Number getStartY(int var1, int var2) {
      return new Double(this.getStartYValue(var1, var2));
   }

   public Number getEndY(int var1, int var2) {
      return new Double(this.getEndYValue(var1, var2));
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYIntervalSeriesCollection)) {
         return false;
      } else {
         XYIntervalSeriesCollection var2 = (XYIntervalSeriesCollection)var1;
         return ObjectUtilities.equal(this.data, var2.data);
      }
   }

   public Object clone() {
      XYIntervalSeriesCollection var1 = (XYIntervalSeriesCollection)super.clone();
      int var2 = this.getSeriesCount();
      var1.data = new ArrayList(var2);

      for(int var3 = 0; var3 < this.data.size(); ++var3) {
         var1.data.set(var3, this.getSeries(var3).clone());
      }

      return var1;
   }
}
