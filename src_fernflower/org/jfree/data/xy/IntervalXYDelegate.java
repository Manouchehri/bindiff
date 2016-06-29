package org.jfree.data.xy;

import java.io.Serializable;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class IntervalXYDelegate implements Serializable, Cloneable, DomainInfo, DatasetChangeListener, PublicCloneable {
   private static final long serialVersionUID = -685166711639592857L;
   private XYDataset dataset;
   private boolean autoWidth;
   private double intervalPositionFactor;
   private double fixedIntervalWidth;
   private double autoIntervalWidth;

   public IntervalXYDelegate(XYDataset var1) {
      this(var1, true);
   }

   public IntervalXYDelegate(XYDataset var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         this.dataset = var1;
         this.autoWidth = var2;
         this.intervalPositionFactor = 0.5D;
         this.autoIntervalWidth = Double.POSITIVE_INFINITY;
         this.fixedIntervalWidth = 1.0D;
      }
   }

   public boolean isAutoWidth() {
      return this.autoWidth;
   }

   public void setAutoWidth(boolean var1) {
      this.autoWidth = var1;
      if(var1) {
         this.autoIntervalWidth = this.recalculateInterval();
      }

   }

   public double getIntervalPositionFactor() {
      return this.intervalPositionFactor;
   }

   public void setIntervalPositionFactor(double var1) {
      if(var1 >= 0.0D && 1.0D >= var1) {
         this.intervalPositionFactor = var1;
      } else {
         throw new IllegalArgumentException("Argument \'d\' outside valid range.");
      }
   }

   public double getFixedIntervalWidth() {
      return this.fixedIntervalWidth;
   }

   public void setFixedIntervalWidth(double var1) {
      if(var1 < 0.0D) {
         throw new IllegalArgumentException("Negative \'w\' argument.");
      } else {
         this.fixedIntervalWidth = var1;
         this.autoWidth = false;
      }
   }

   public double getIntervalWidth() {
      return this.isAutoWidth() && !Double.isInfinite(this.autoIntervalWidth)?this.autoIntervalWidth:this.fixedIntervalWidth;
   }

   public Number getStartX(int var1, int var2) {
      Double var3 = null;
      Number var4 = this.dataset.getX(var1, var2);
      if(var4 != null) {
         var3 = new Double(var4.doubleValue() - this.getIntervalPositionFactor() * this.getIntervalWidth());
      }

      return var3;
   }

   public double getStartXValue(int var1, int var2) {
      return this.dataset.getXValue(var1, var2) - this.getIntervalPositionFactor() * this.getIntervalWidth();
   }

   public Number getEndX(int var1, int var2) {
      Double var3 = null;
      Number var4 = this.dataset.getX(var1, var2);
      if(var4 != null) {
         var3 = new Double(var4.doubleValue() + (1.0D - this.getIntervalPositionFactor()) * this.getIntervalWidth());
      }

      return var3;
   }

   public double getEndXValue(int var1, int var2) {
      return this.dataset.getXValue(var1, var2) + (1.0D - this.getIntervalPositionFactor()) * this.getIntervalWidth();
   }

   public double getDomainLowerBound(boolean var1) {
      double var2 = Double.NaN;
      Range var4 = this.getDomainBounds(var1);
      if(var4 != null) {
         var2 = var4.getLowerBound();
      }

      return var2;
   }

   public double getDomainUpperBound(boolean var1) {
      double var2 = Double.NaN;
      Range var4 = this.getDomainBounds(var1);
      if(var4 != null) {
         var2 = var4.getUpperBound();
      }

      return var2;
   }

   public Range getDomainBounds(boolean var1) {
      Range var2 = DatasetUtilities.findDomainBounds(this.dataset, false);
      if(var1 && var2 != null) {
         double var3 = this.getIntervalWidth() * this.getIntervalPositionFactor();
         double var5 = this.getIntervalWidth() - var3;
         var2 = new Range(var2.getLowerBound() - var3, var2.getUpperBound() + var5);
      }

      return var2;
   }

   public void datasetChanged(DatasetChangeEvent var1) {
      if(this.autoWidth) {
         this.autoIntervalWidth = this.recalculateInterval();
      }

   }

   private double recalculateInterval() {
      double var1 = Double.POSITIVE_INFINITY;
      int var3 = this.dataset.getSeriesCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 = Math.min(var1, this.calculateIntervalForSeries(var4));
      }

      return var1;
   }

   private double calculateIntervalForSeries(int var1) {
      double var2 = Double.POSITIVE_INFINITY;
      int var4 = this.dataset.getItemCount(var1);
      if(var4 > 1) {
         double var5 = this.dataset.getXValue(var1, 0);

         for(int var7 = 1; var7 < var4; ++var7) {
            double var8 = this.dataset.getXValue(var1, var7);
            var2 = Math.min(var2, var8 - var5);
            var5 = var8;
         }
      }

      return var2;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof IntervalXYDelegate)) {
         return false;
      } else {
         IntervalXYDelegate var2 = (IntervalXYDelegate)var1;
         return this.autoWidth != var2.autoWidth?false:(this.intervalPositionFactor != var2.intervalPositionFactor?false:this.fixedIntervalWidth == var2.fixedIntervalWidth);
      }
   }

   public Object clone() {
      return super.clone();
   }
}
