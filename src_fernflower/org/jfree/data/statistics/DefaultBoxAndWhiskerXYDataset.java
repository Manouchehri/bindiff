package org.jfree.data.statistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jfree.data.Range;
import org.jfree.data.RangeInfo;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.xy.AbstractXYDataset;

public class DefaultBoxAndWhiskerXYDataset extends AbstractXYDataset implements RangeInfo, BoxAndWhiskerXYDataset {
   private Comparable seriesKey;
   private List dates;
   private List items;
   private Number minimumRangeValue;
   private Number maximumRangeValue;
   private Range rangeBounds;
   private double outlierCoefficient = 1.5D;
   private double faroutCoefficient = 2.0D;

   public DefaultBoxAndWhiskerXYDataset(Comparable var1) {
      this.seriesKey = var1;
      this.dates = new ArrayList();
      this.items = new ArrayList();
      this.minimumRangeValue = null;
      this.maximumRangeValue = null;
      this.rangeBounds = null;
   }

   public void add(Date var1, BoxAndWhiskerItem var2) {
      this.dates.add(var1);
      this.items.add(var2);
      if(this.minimumRangeValue == null) {
         this.minimumRangeValue = var2.getMinRegularValue();
      } else if(var2.getMinRegularValue().doubleValue() < this.minimumRangeValue.doubleValue()) {
         this.minimumRangeValue = var2.getMinRegularValue();
      }

      if(this.maximumRangeValue == null) {
         this.maximumRangeValue = var2.getMaxRegularValue();
      } else if(var2.getMaxRegularValue().doubleValue() > this.maximumRangeValue.doubleValue()) {
         this.maximumRangeValue = var2.getMaxRegularValue();
      }

      this.rangeBounds = new Range(this.minimumRangeValue.doubleValue(), this.maximumRangeValue.doubleValue());
   }

   public Comparable getSeriesKey(int var1) {
      return this.seriesKey;
   }

   public BoxAndWhiskerItem getItem(int var1, int var2) {
      return (BoxAndWhiskerItem)this.items.get(var2);
   }

   public Number getX(int var1, int var2) {
      return new Long(((Date)this.dates.get(var2)).getTime());
   }

   public Date getXDate(int var1, int var2) {
      return (Date)this.dates.get(var2);
   }

   public Number getY(int var1, int var2) {
      return new Double(this.getMeanValue(var1, var2).doubleValue());
   }

   public Number getMeanValue(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.items.get(var2);
      if(var4 != null) {
         var3 = var4.getMean();
      }

      return var3;
   }

   public Number getMedianValue(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.items.get(var2);
      if(var4 != null) {
         var3 = var4.getMedian();
      }

      return var3;
   }

   public Number getQ1Value(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.items.get(var2);
      if(var4 != null) {
         var3 = var4.getQ1();
      }

      return var3;
   }

   public Number getQ3Value(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.items.get(var2);
      if(var4 != null) {
         var3 = var4.getQ3();
      }

      return var3;
   }

   public Number getMinRegularValue(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.items.get(var2);
      if(var4 != null) {
         var3 = var4.getMinRegularValue();
      }

      return var3;
   }

   public Number getMaxRegularValue(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.items.get(var2);
      if(var4 != null) {
         var3 = var4.getMaxRegularValue();
      }

      return var3;
   }

   public Number getMinOutlier(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.items.get(var2);
      if(var4 != null) {
         var3 = var4.getMinOutlier();
      }

      return var3;
   }

   public Number getMaxOutlier(int var1, int var2) {
      Number var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.items.get(var2);
      if(var4 != null) {
         var3 = var4.getMaxOutlier();
      }

      return var3;
   }

   public List getOutliers(int var1, int var2) {
      List var3 = null;
      BoxAndWhiskerItem var4 = (BoxAndWhiskerItem)this.items.get(var2);
      if(var4 != null) {
         var3 = var4.getOutliers();
      }

      return var3;
   }

   public double getOutlierCoefficient() {
      return this.outlierCoefficient;
   }

   public double getFaroutCoefficient() {
      return this.faroutCoefficient;
   }

   public int getSeriesCount() {
      return 1;
   }

   public int getItemCount(int var1) {
      return this.dates.size();
   }

   public void setOutlierCoefficient(double var1) {
      this.outlierCoefficient = var1;
   }

   public void setFaroutCoefficient(double var1) {
      if(var1 > this.getOutlierCoefficient()) {
         this.faroutCoefficient = var1;
      } else {
         throw new IllegalArgumentException("Farout value must be greater than the outlier value, which is currently set at: (" + this.getOutlierCoefficient() + ")");
      }
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
}
