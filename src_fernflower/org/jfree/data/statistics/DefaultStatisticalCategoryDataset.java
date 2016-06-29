package org.jfree.data.statistics;

import java.util.List;
import org.jfree.data.KeyedObjects2D;
import org.jfree.data.Range;
import org.jfree.data.RangeInfo;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.statistics.MeanAndStandardDeviation;
import org.jfree.data.statistics.StatisticalCategoryDataset;

public class DefaultStatisticalCategoryDataset extends AbstractDataset implements RangeInfo, StatisticalCategoryDataset {
   private KeyedObjects2D data = new KeyedObjects2D();
   private double minimumRangeValue = Double.NaN;
   private double minimumRangeValueIncStdDev = Double.NaN;
   private double maximumRangeValue = Double.NaN;
   private double maximumRangeValueIncStdDev = Double.NaN;

   public Number getMeanValue(int var1, int var2) {
      Number var3 = null;
      MeanAndStandardDeviation var4 = (MeanAndStandardDeviation)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getMean();
      }

      return var3;
   }

   public Number getValue(int var1, int var2) {
      return this.getMeanValue(var1, var2);
   }

   public Number getValue(Comparable var1, Comparable var2) {
      return this.getMeanValue(var1, var2);
   }

   public Number getMeanValue(Comparable var1, Comparable var2) {
      Number var3 = null;
      MeanAndStandardDeviation var4 = (MeanAndStandardDeviation)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getMean();
      }

      return var3;
   }

   public Number getStdDevValue(int var1, int var2) {
      Number var3 = null;
      MeanAndStandardDeviation var4 = (MeanAndStandardDeviation)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getStandardDeviation();
      }

      return var3;
   }

   public Number getStdDevValue(Comparable var1, Comparable var2) {
      Number var3 = null;
      MeanAndStandardDeviation var4 = (MeanAndStandardDeviation)this.data.getObject(var1, var2);
      if(var4 != null) {
         var3 = var4.getStandardDeviation();
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

   public void add(double var1, double var3, Comparable var5, Comparable var6) {
      this.add(new Double(var1), new Double(var3), var5, var6);
   }

   public void add(Number var1, Number var2, Comparable var3, Comparable var4) {
      MeanAndStandardDeviation var5 = new MeanAndStandardDeviation(var1, var2);
      this.data.addObject(var5, var3, var4);
      double var6 = 0.0D;
      double var8 = 0.0D;
      if(var1 != null) {
         var6 = var1.doubleValue();
      }

      if(var2 != null) {
         var8 = var2.doubleValue();
      }

      if(!Double.isNaN(var6) && (Double.isNaN(this.maximumRangeValue) || var6 > this.maximumRangeValue)) {
         this.maximumRangeValue = var6;
      }

      if(!Double.isNaN(var6 + var8) && (Double.isNaN(this.maximumRangeValueIncStdDev) || var6 + var8 > this.maximumRangeValueIncStdDev)) {
         this.maximumRangeValueIncStdDev = var6 + var8;
      }

      if(!Double.isNaN(var6) && (Double.isNaN(this.minimumRangeValue) || var6 < this.minimumRangeValue)) {
         this.minimumRangeValue = var6;
      }

      if(!Double.isNaN(var6 - var8) && (Double.isNaN(this.minimumRangeValueIncStdDev) || var6 - var8 < this.minimumRangeValueIncStdDev)) {
         this.minimumRangeValueIncStdDev = var6 - var8;
      }

      this.fireDatasetChanged();
   }

   public double getRangeLowerBound(boolean var1) {
      return this.minimumRangeValue;
   }

   public double getRangeUpperBound(boolean var1) {
      return this.maximumRangeValue;
   }

   public Range getRangeBounds(boolean var1) {
      Range var2 = null;
      if(var1) {
         if(!Double.isNaN(this.minimumRangeValueIncStdDev) && !Double.isNaN(this.maximumRangeValueIncStdDev)) {
            var2 = new Range(this.minimumRangeValueIncStdDev, this.maximumRangeValueIncStdDev);
         }
      } else if(!Double.isNaN(this.minimumRangeValue) && !Double.isNaN(this.maximumRangeValue)) {
         var2 = new Range(this.minimumRangeValue, this.maximumRangeValue);
      }

      return var2;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof DefaultStatisticalCategoryDataset)) {
         return false;
      } else {
         DefaultStatisticalCategoryDataset var2 = (DefaultStatisticalCategoryDataset)var1;
         return this.data.equals(var2.data);
      }
   }
}
