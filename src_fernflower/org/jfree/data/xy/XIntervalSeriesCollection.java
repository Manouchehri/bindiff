package org.jfree.data.xy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XIntervalDataItem;
import org.jfree.data.xy.XIntervalSeries;
import org.jfree.util.ObjectUtilities;

public class XIntervalSeriesCollection extends AbstractIntervalXYDataset implements Serializable, IntervalXYDataset {
   private List data = new ArrayList();

   public void addSeries(XIntervalSeries var1) {
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

   public XIntervalSeries getSeries(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         return (XIntervalSeries)this.data.get(var1);
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
      XIntervalSeries var3 = (XIntervalSeries)this.data.get(var1);
      XIntervalDataItem var4 = (XIntervalDataItem)var3.getDataItem(var2);
      return var4.getX();
   }

   public Number getY(int var1, int var2) {
      XIntervalSeries var3 = (XIntervalSeries)this.data.get(var1);
      XIntervalDataItem var4 = (XIntervalDataItem)var3.getDataItem(var2);
      return new Double(var4.getYValue());
   }

   public Number getStartX(int var1, int var2) {
      XIntervalSeries var3 = (XIntervalSeries)this.data.get(var1);
      XIntervalDataItem var4 = (XIntervalDataItem)var3.getDataItem(var2);
      return new Double(var4.getXLowValue());
   }

   public Number getEndX(int var1, int var2) {
      XIntervalSeries var3 = (XIntervalSeries)this.data.get(var1);
      XIntervalDataItem var4 = (XIntervalDataItem)var3.getDataItem(var2);
      return new Double(var4.getXHighValue());
   }

   public Number getStartY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public Number getEndY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XIntervalSeriesCollection)) {
         return false;
      } else {
         XIntervalSeriesCollection var2 = (XIntervalSeriesCollection)var1;
         return ObjectUtilities.equal(this.data, var2.data);
      }
   }

   public Object clone() {
      XIntervalSeriesCollection var1 = (XIntervalSeriesCollection)super.clone();
      var1.data = (List)ObjectUtilities.deepClone(this.data);
      return var1;
   }
}
