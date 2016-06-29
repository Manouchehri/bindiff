package org.jfree.data.statistics;

import java.util.List;
import org.jfree.data.KeyedObjects2D;
import org.jfree.data.Range;
import org.jfree.data.RangeInfo;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.statistics.BoxAndWhiskerCalculator;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.util.ObjectUtilities;

public class DefaultBoxAndWhiskerCategoryDataset extends AbstractDataset implements RangeInfo, BoxAndWhiskerCategoryDataset {
   protected KeyedObjects2D data = new KeyedObjects2D();
   private Number minimumRangeValue = null;
   private Number maximumRangeValue = null;
   private Range rangeBounds = new Range(0.0D, 0.0D);

   public void add(List var1, Comparable var2, Comparable var3) {
      BoxAndWhiskerItem var4 = BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(var1);
      this.add(var4, var2, var3);
   }

   public void add(BoxAndWhiskerItem var1, Comparable var2, Comparable var3) {
      this.data.addObject(var1, var2, var3);
      double var4 = var1.getMinOutlier().doubleValue();
      double var6 = var1.getMaxOutlier().doubleValue();
      if(this.maximumRangeValue == null) {
         this.maximumRangeValue = new Double(var6);
      } else if(var6 > this.maximumRangeValue.doubleValue()) {
         this.maximumRangeValue = new Double(var6);
      }

      if(this.minimumRangeValue == null) {
         this.minimumRangeValue = new Double(var4);
      } else if(var4 < this.minimumRangeValue.doubleValue()) {
         this.minimumRangeValue = new Double(var4);
      }

      this.rangeBounds = new Range(this.minimumRangeValue.doubleValue(), this.maximumRangeValue.doubleValue());
      this.fireDatasetChanged();
   }

   public BoxAndWhiskerItem getItem(int var1, int var2) {
      return (BoxAndWhiskerItem)this.data.getObject(var1, var2);
   }

   public Number getValue(int var1, int var2) {
      return this.getMedianValue(var1, var2);
   }

   public Number getValue(Comparable var1, Comparable var2) {
      return this.getMedianValue(var1, var2);
   }

   public Number getMeanValue(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getMean();
      }

      return var3;
   }

   public Number getMeanValue(Comparable var1, Comparable var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getMean();
      }

      return var3;
   }

   public Number getMedianValue(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getMedian();
      }

      return var3;
   }

   public Number getMedianValue(Comparable var1, Comparable var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getMedian();
      }

      return var3;
   }

   public Number getQ1Value(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getQ1();
      }

      return var3;
   }

   public Number getQ1Value(Comparable var1, Comparable var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getQ1();
      }

      return var3;
   }

   public Number getQ3Value(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getQ3();
      }

      return var3;
   }

   public Number getQ3Value(Comparable var1, Comparable var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getQ3();
      }

      return var3;
   }

   public int getColumnIndex(Comparable var1) {
      return this.data.getColumnIndex(var1);
   }

   public Comparable getColumnKey(int var1) {
      return this.data.getColumnKey(var1);
   }

   public List getColumnKeys() {
      return this.data.getColumnKeys();
   }

   public int getRowIndex(Comparable var1) {
      return this.data.getRowIndex(var1);
   }

   public Comparable getRowKey(int var1) {
      return this.data.getRowKey(var1);
   }

   public List getRowKeys() {
      return this.data.getRowKeys();
   }

   public int getRowCount() {
      return this.data.getRowCount();
   }

   public int getColumnCount() {
      return this.data.getColumnCount();
   }

   public double getRangeLowerBound(boolean var1) {
      double var2 = Double.NaN;
      if(this.minimumRangeValue != null) {
         var2 = this.minimumRangeValue.doubleValue();
      }

      return var2;
   }

   public double getRangeUpperBound(boolean var1) {
      double var2 = Double.NaN;
      if(this.maximumRangeValue != null) {
         var2 = this.maximumRangeValue.doubleValue();
      }

      return var2;
   }

   public Range getRangeBounds(boolean var1) {
      return this.rangeBounds;
   }

   public Number getMinRegularValue(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getMinRegularValue();
      }

      return var3;
   }

   public Number getMinRegularValue(Comparable var1, Comparable var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getMinRegularValue();
      }

      return var3;
   }

   public Number getMaxRegularValue(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getMaxRegularValue();
      }

      return var3;
   }

   public Number getMaxRegularValue(Comparable var1, Comparable var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getMaxRegularValue();
      }

      return var3;
   }

   public Number getMinOutlier(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getMinOutlier();
      }

      return var3;
   }

   public Number getMinOutlier(Comparable var1, Comparable var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getMinOutlier();
      }

      return var3;
   }

   public Number getMaxOutlier(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getMaxOutlier();
      }

      return var3;
   }

   public Number getMaxOutlier(Comparable var1, Comparable var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getMaxOutlier();
      }

      return var3;
   }

   public List getOutliers(int var1, int var2) {
      List var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getOutliers();
      }

      return var3;
   }

   public List getOutliers(Comparable var1, Comparable var2) {
      List var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getOutliers();
      }

      return var3;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof DefaultBoxAndWhiskerCategoryDataset) {
         DefaultBoxAndWhiskerCategoryDataset var2 = (DefaultBoxAndWhiskerCategoryDataset)var1;
         return ObjectUtilities.equal(this.data, var2.data);
      } else {
         return false;
      }
   }
}
