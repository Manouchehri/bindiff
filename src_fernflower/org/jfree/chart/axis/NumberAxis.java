package org.jfree.chart.axis;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.MarkerAxisBand;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.data.Range;
import org.jfree.data.RangeType;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;

public class NumberAxis extends ValueAxis implements Serializable, Cloneable {
   private static final long serialVersionUID = 2805933088476185789L;
   public static final boolean DEFAULT_AUTO_RANGE_INCLUDES_ZERO = true;
   public static final boolean DEFAULT_AUTO_RANGE_STICKY_ZERO = true;
   public static final NumberTickUnit DEFAULT_TICK_UNIT = new NumberTickUnit(1.0D, new DecimalFormat("0"));
   public static final boolean DEFAULT_VERTICAL_TICK_LABELS = false;
   private RangeType rangeType;
   private boolean autoRangeIncludesZero;
   private boolean autoRangeStickyZero;
   private NumberTickUnit tickUnit;
   private NumberFormat numberFormatOverride;
   private MarkerAxisBand markerBand;

   public NumberAxis() {
      this((String)null);
   }

   public NumberAxis(String var1) {
      super(var1, createStandardTickUnits());
      this.rangeType = RangeType.FULL;
      this.autoRangeIncludesZero = true;
      this.autoRangeStickyZero = true;
      this.tickUnit = DEFAULT_TICK_UNIT;
      this.numberFormatOverride = null;
      this.markerBand = null;
   }

   public RangeType getRangeType() {
      return this.rangeType;
   }

   public void setRangeType(RangeType var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'rangeType\' argument.");
      } else {
         this.rangeType = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public boolean getAutoRangeIncludesZero() {
      return this.autoRangeIncludesZero;
   }

   public void setAutoRangeIncludesZero(boolean var1) {
      if(this.autoRangeIncludesZero != var1) {
         this.autoRangeIncludesZero = var1;
         if(this.isAutoRange()) {
            this.autoAdjustRange();
         }

         this.notifyListeners(new AxisChangeEvent(this));
      }

   }

   public boolean getAutoRangeStickyZero() {
      return this.autoRangeStickyZero;
   }

   public void setAutoRangeStickyZero(boolean var1) {
      if(this.autoRangeStickyZero != var1) {
         this.autoRangeStickyZero = var1;
         if(this.isAutoRange()) {
            this.autoAdjustRange();
         }

         this.notifyListeners(new AxisChangeEvent(this));
      }

   }

   public NumberTickUnit getTickUnit() {
      return this.tickUnit;
   }

   public void setTickUnit(NumberTickUnit var1) {
      this.setTickUnit(var1, true, true);
   }

   public void setTickUnit(NumberTickUnit var1, boolean var2, boolean var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'unit\' argument.");
      } else {
         this.tickUnit = var1;
         if(var3) {
            this.setAutoTickUnitSelection(false, false);
         }

         if(var2) {
            this.notifyListeners(new AxisChangeEvent(this));
         }

      }
   }

   public NumberFormat getNumberFormatOverride() {
      return this.numberFormatOverride;
   }

   public void setNumberFormatOverride(NumberFormat var1) {
      this.numberFormatOverride = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public MarkerAxisBand getMarkerBand() {
      return this.markerBand;
   }

   public void setMarkerBand(MarkerAxisBand var1) {
      this.markerBand = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public void configure() {
      if(this.isAutoRange()) {
         this.autoAdjustRange();
      }

   }

   protected void autoAdjustRange() {
      Plot var1 = this.getPlot();
      if(var1 != null) {
         if(var1 instanceof ValueAxisPlot) {
            ValueAxisPlot var2 = (ValueAxisPlot)var1;
            Range var3 = var2.getDataRange(this);
            if(var3 == null) {
               var3 = this.getDefaultAutoRange();
            }

            double var4 = var3.getUpperBound();
            double var6 = var3.getLowerBound();
            if(this.rangeType == RangeType.POSITIVE) {
               var6 = Math.max(0.0D, var6);
               var4 = Math.max(0.0D, var4);
            } else if(this.rangeType == RangeType.NEGATIVE) {
               var6 = Math.min(0.0D, var6);
               var4 = Math.min(0.0D, var4);
            }

            if(this.getAutoRangeIncludesZero()) {
               var6 = Math.min(var6, 0.0D);
               var4 = Math.max(var4, 0.0D);
            }

            double var8 = var4 - var6;
            double var10 = this.getFixedAutoRange();
            if(var10 > 0.0D) {
               var6 = var4 - var10;
            } else {
               double var12 = this.getAutoRangeMinimumSize();
               if(var8 < var12) {
                  double var14 = (var12 - var8) / 2.0D;
                  var4 += var14;
                  var6 -= var14;
                  if(var6 == var4) {
                     double var16 = Math.abs(var6) / 10.0D;
                     var6 -= var16;
                     var4 += var16;
                  }

                  if(this.rangeType == RangeType.POSITIVE) {
                     if(var6 < 0.0D) {
                        var4 -= var6;
                        var6 = 0.0D;
                     }
                  } else if(this.rangeType == RangeType.NEGATIVE && var4 > 0.0D) {
                     var6 -= var4;
                     var4 = 0.0D;
                  }
               }

               if(this.getAutoRangeStickyZero()) {
                  if(var4 <= 0.0D) {
                     var4 = Math.min(0.0D, var4 + this.getUpperMargin() * var8);
                  } else {
                     var4 += this.getUpperMargin() * var8;
                  }

                  if(var6 >= 0.0D) {
                     var6 = Math.max(0.0D, var6 - this.getLowerMargin() * var8);
                  } else {
                     var6 -= this.getLowerMargin() * var8;
                  }
               } else {
                  var4 += this.getUpperMargin() * var8;
                  var6 -= this.getLowerMargin() * var8;
               }
            }

            this.setRange(new Range(var6, var4), false, false);
         }

      }
   }

   public double valueToJava2D(double var1, Rectangle2D var3, RectangleEdge var4) {
      Range var5 = this.getRange();
      double var6 = var5.getLowerBound();
      double var8 = var5.getUpperBound();
      double var10 = 0.0D;
      double var12 = 0.0D;
      if(RectangleEdge.isTopOrBottom(var4)) {
         var10 = var3.getX();
         var12 = var3.getMaxX();
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var12 = var3.getMinY();
         var10 = var3.getMaxY();
      }

      return this.isInverted()?var12 - (var1 - var6) / (var8 - var6) * (var12 - var10):var10 + (var1 - var6) / (var8 - var6) * (var12 - var10);
   }

   public double java2DToValue(double var1, Rectangle2D var3, RectangleEdge var4) {
      Range var5 = this.getRange();
      double var6 = var5.getLowerBound();
      double var8 = var5.getUpperBound();
      double var10 = 0.0D;
      double var12 = 0.0D;
      if(RectangleEdge.isTopOrBottom(var4)) {
         var10 = var3.getX();
         var12 = var3.getMaxX();
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var10 = var3.getMaxY();
         var12 = var3.getY();
      }

      return this.isInverted()?var8 - (var1 - var10) / (var12 - var10) * (var8 - var6):var6 + (var1 - var10) / (var12 - var10) * (var8 - var6);
   }

   protected double calculateLowestVisibleTickValue() {
      double var1 = this.getTickUnit().getSize();
      double var3 = Math.ceil(this.getRange().getLowerBound() / var1);
      return var3 * var1;
   }

   protected double calculateHighestVisibleTickValue() {
      double var1 = this.getTickUnit().getSize();
      double var3 = Math.floor(this.getRange().getUpperBound() / var1);
      return var3 * var1;
   }

   protected int calculateVisibleTickCount() {
      double var1 = this.getTickUnit().getSize();
      Range var3 = this.getRange();
      return (int)(Math.floor(var3.getUpperBound() / var1) - Math.ceil(var3.getLowerBound() / var1) + 1.0D);
   }

   public AxisState draw(Graphics2D var1, double var2, Rectangle2D var4, Rectangle2D var5, RectangleEdge var6, PlotRenderingInfo var7) {
      AxisState var8 = null;
      if(!this.isVisible()) {
         var8 = new AxisState(var2);
         List var9 = this.refreshTicks(var1, var8, var5, var6);
         var8.setTicks(var9);
         return var8;
      } else {
         var8 = this.drawTickMarksAndLabels(var1, var2, var4, var5, var6);
         var8 = this.drawLabel(this.getLabel(), var1, var4, var5, var6, var8);
         return var8;
      }
   }

   public static TickUnitSource createStandardTickUnits() {
      TickUnits var0 = new TickUnits();
      DecimalFormat var1 = new DecimalFormat("0.00000000");
      DecimalFormat var2 = new DecimalFormat("0.0000000");
      DecimalFormat var3 = new DecimalFormat("0.000000");
      DecimalFormat var4 = new DecimalFormat("0.00000");
      DecimalFormat var5 = new DecimalFormat("0.0000");
      DecimalFormat var6 = new DecimalFormat("0.000");
      DecimalFormat var7 = new DecimalFormat("0.00");
      DecimalFormat var8 = new DecimalFormat("0.0");
      DecimalFormat var9 = new DecimalFormat("#,##0");
      DecimalFormat var10 = new DecimalFormat("#,###,##0");
      DecimalFormat var11 = new DecimalFormat("#,###,###,##0");
      var0.add(new NumberTickUnit(1.0E-7D, var2));
      var0.add(new NumberTickUnit(1.0E-6D, var3));
      var0.add(new NumberTickUnit(1.0E-5D, var4));
      var0.add(new NumberTickUnit(1.0E-4D, var5));
      var0.add(new NumberTickUnit(0.001D, var6));
      var0.add(new NumberTickUnit(0.01D, var7));
      var0.add(new NumberTickUnit(0.1D, var8));
      var0.add(new NumberTickUnit(1.0D, var9));
      var0.add(new NumberTickUnit(10.0D, var9));
      var0.add(new NumberTickUnit(100.0D, var9));
      var0.add(new NumberTickUnit(1000.0D, var9));
      var0.add(new NumberTickUnit(10000.0D, var9));
      var0.add(new NumberTickUnit(100000.0D, var9));
      var0.add(new NumberTickUnit(1000000.0D, var10));
      var0.add(new NumberTickUnit(1.0E7D, var10));
      var0.add(new NumberTickUnit(1.0E8D, var10));
      var0.add(new NumberTickUnit(1.0E9D, var11));
      var0.add(new NumberTickUnit(1.0E10D, var11));
      var0.add(new NumberTickUnit(1.0E11D, var11));
      var0.add(new NumberTickUnit(2.5E-7D, var1));
      var0.add(new NumberTickUnit(2.5E-6D, var2));
      var0.add(new NumberTickUnit(2.5E-5D, var3));
      var0.add(new NumberTickUnit(2.5E-4D, var4));
      var0.add(new NumberTickUnit(0.0025D, var5));
      var0.add(new NumberTickUnit(0.025D, var6));
      var0.add(new NumberTickUnit(0.25D, var7));
      var0.add(new NumberTickUnit(2.5D, var8));
      var0.add(new NumberTickUnit(25.0D, var9));
      var0.add(new NumberTickUnit(250.0D, var9));
      var0.add(new NumberTickUnit(2500.0D, var9));
      var0.add(new NumberTickUnit(25000.0D, var9));
      var0.add(new NumberTickUnit(250000.0D, var9));
      var0.add(new NumberTickUnit(2500000.0D, var10));
      var0.add(new NumberTickUnit(2.5E7D, var10));
      var0.add(new NumberTickUnit(2.5E8D, var10));
      var0.add(new NumberTickUnit(2.5E9D, var11));
      var0.add(new NumberTickUnit(2.5E10D, var11));
      var0.add(new NumberTickUnit(2.5E11D, var11));
      var0.add(new NumberTickUnit(5.0E-7D, var2));
      var0.add(new NumberTickUnit(5.0E-6D, var3));
      var0.add(new NumberTickUnit(5.0E-5D, var4));
      var0.add(new NumberTickUnit(5.0E-4D, var5));
      var0.add(new NumberTickUnit(0.005D, var6));
      var0.add(new NumberTickUnit(0.05D, var7));
      var0.add(new NumberTickUnit(0.5D, var8));
      var0.add(new NumberTickUnit(5.0D, var9));
      var0.add(new NumberTickUnit(50.0D, var9));
      var0.add(new NumberTickUnit(500.0D, var9));
      var0.add(new NumberTickUnit(5000.0D, var9));
      var0.add(new NumberTickUnit(50000.0D, var9));
      var0.add(new NumberTickUnit(500000.0D, var9));
      var0.add(new NumberTickUnit(5000000.0D, var10));
      var0.add(new NumberTickUnit(5.0E7D, var10));
      var0.add(new NumberTickUnit(5.0E8D, var10));
      var0.add(new NumberTickUnit(5.0E9D, var11));
      var0.add(new NumberTickUnit(5.0E10D, var11));
      var0.add(new NumberTickUnit(5.0E11D, var11));
      return var0;
   }

   public static TickUnitSource createIntegerTickUnits() {
      TickUnits var0 = new TickUnits();
      DecimalFormat var1 = new DecimalFormat("0");
      DecimalFormat var2 = new DecimalFormat("#,##0");
      var0.add(new NumberTickUnit(1.0D, var1));
      var0.add(new NumberTickUnit(2.0D, var1));
      var0.add(new NumberTickUnit(5.0D, var1));
      var0.add(new NumberTickUnit(10.0D, var1));
      var0.add(new NumberTickUnit(20.0D, var1));
      var0.add(new NumberTickUnit(50.0D, var1));
      var0.add(new NumberTickUnit(100.0D, var1));
      var0.add(new NumberTickUnit(200.0D, var1));
      var0.add(new NumberTickUnit(500.0D, var1));
      var0.add(new NumberTickUnit(1000.0D, var2));
      var0.add(new NumberTickUnit(2000.0D, var2));
      var0.add(new NumberTickUnit(5000.0D, var2));
      var0.add(new NumberTickUnit(10000.0D, var2));
      var0.add(new NumberTickUnit(20000.0D, var2));
      var0.add(new NumberTickUnit(50000.0D, var2));
      var0.add(new NumberTickUnit(100000.0D, var2));
      var0.add(new NumberTickUnit(200000.0D, var2));
      var0.add(new NumberTickUnit(500000.0D, var2));
      var0.add(new NumberTickUnit(1000000.0D, var2));
      var0.add(new NumberTickUnit(2000000.0D, var2));
      var0.add(new NumberTickUnit(5000000.0D, var2));
      var0.add(new NumberTickUnit(1.0E7D, var2));
      var0.add(new NumberTickUnit(2.0E7D, var2));
      var0.add(new NumberTickUnit(5.0E7D, var2));
      var0.add(new NumberTickUnit(1.0E8D, var2));
      var0.add(new NumberTickUnit(2.0E8D, var2));
      var0.add(new NumberTickUnit(5.0E8D, var2));
      var0.add(new NumberTickUnit(1.0E9D, var2));
      var0.add(new NumberTickUnit(2.0E9D, var2));
      var0.add(new NumberTickUnit(5.0E9D, var2));
      var0.add(new NumberTickUnit(1.0E10D, var2));
      return var0;
   }

   public static TickUnitSource createStandardTickUnits(Locale var0) {
      TickUnits var1 = new TickUnits();
      NumberFormat var2 = NumberFormat.getNumberInstance(var0);
      var1.add(new NumberTickUnit(1.0E-7D, var2));
      var1.add(new NumberTickUnit(1.0E-6D, var2));
      var1.add(new NumberTickUnit(1.0E-5D, var2));
      var1.add(new NumberTickUnit(1.0E-4D, var2));
      var1.add(new NumberTickUnit(0.001D, var2));
      var1.add(new NumberTickUnit(0.01D, var2));
      var1.add(new NumberTickUnit(0.1D, var2));
      var1.add(new NumberTickUnit(1.0D, var2));
      var1.add(new NumberTickUnit(10.0D, var2));
      var1.add(new NumberTickUnit(100.0D, var2));
      var1.add(new NumberTickUnit(1000.0D, var2));
      var1.add(new NumberTickUnit(10000.0D, var2));
      var1.add(new NumberTickUnit(100000.0D, var2));
      var1.add(new NumberTickUnit(1000000.0D, var2));
      var1.add(new NumberTickUnit(1.0E7D, var2));
      var1.add(new NumberTickUnit(1.0E8D, var2));
      var1.add(new NumberTickUnit(1.0E9D, var2));
      var1.add(new NumberTickUnit(1.0E10D, var2));
      var1.add(new NumberTickUnit(2.5E-7D, var2));
      var1.add(new NumberTickUnit(2.5E-6D, var2));
      var1.add(new NumberTickUnit(2.5E-5D, var2));
      var1.add(new NumberTickUnit(2.5E-4D, var2));
      var1.add(new NumberTickUnit(0.0025D, var2));
      var1.add(new NumberTickUnit(0.025D, var2));
      var1.add(new NumberTickUnit(0.25D, var2));
      var1.add(new NumberTickUnit(2.5D, var2));
      var1.add(new NumberTickUnit(25.0D, var2));
      var1.add(new NumberTickUnit(250.0D, var2));
      var1.add(new NumberTickUnit(2500.0D, var2));
      var1.add(new NumberTickUnit(25000.0D, var2));
      var1.add(new NumberTickUnit(250000.0D, var2));
      var1.add(new NumberTickUnit(2500000.0D, var2));
      var1.add(new NumberTickUnit(2.5E7D, var2));
      var1.add(new NumberTickUnit(2.5E8D, var2));
      var1.add(new NumberTickUnit(2.5E9D, var2));
      var1.add(new NumberTickUnit(2.5E10D, var2));
      var1.add(new NumberTickUnit(5.0E-7D, var2));
      var1.add(new NumberTickUnit(5.0E-6D, var2));
      var1.add(new NumberTickUnit(5.0E-5D, var2));
      var1.add(new NumberTickUnit(5.0E-4D, var2));
      var1.add(new NumberTickUnit(0.005D, var2));
      var1.add(new NumberTickUnit(0.05D, var2));
      var1.add(new NumberTickUnit(0.5D, var2));
      var1.add(new NumberTickUnit(5.0D, var2));
      var1.add(new NumberTickUnit(50.0D, var2));
      var1.add(new NumberTickUnit(500.0D, var2));
      var1.add(new NumberTickUnit(5000.0D, var2));
      var1.add(new NumberTickUnit(50000.0D, var2));
      var1.add(new NumberTickUnit(500000.0D, var2));
      var1.add(new NumberTickUnit(5000000.0D, var2));
      var1.add(new NumberTickUnit(5.0E7D, var2));
      var1.add(new NumberTickUnit(5.0E8D, var2));
      var1.add(new NumberTickUnit(5.0E9D, var2));
      var1.add(new NumberTickUnit(5.0E10D, var2));
      return var1;
   }

   public static TickUnitSource createIntegerTickUnits(Locale var0) {
      TickUnits var1 = new TickUnits();
      NumberFormat var2 = NumberFormat.getNumberInstance(var0);
      var1.add(new NumberTickUnit(1.0D, var2));
      var1.add(new NumberTickUnit(2.0D, var2));
      var1.add(new NumberTickUnit(5.0D, var2));
      var1.add(new NumberTickUnit(10.0D, var2));
      var1.add(new NumberTickUnit(20.0D, var2));
      var1.add(new NumberTickUnit(50.0D, var2));
      var1.add(new NumberTickUnit(100.0D, var2));
      var1.add(new NumberTickUnit(200.0D, var2));
      var1.add(new NumberTickUnit(500.0D, var2));
      var1.add(new NumberTickUnit(1000.0D, var2));
      var1.add(new NumberTickUnit(2000.0D, var2));
      var1.add(new NumberTickUnit(5000.0D, var2));
      var1.add(new NumberTickUnit(10000.0D, var2));
      var1.add(new NumberTickUnit(20000.0D, var2));
      var1.add(new NumberTickUnit(50000.0D, var2));
      var1.add(new NumberTickUnit(100000.0D, var2));
      var1.add(new NumberTickUnit(200000.0D, var2));
      var1.add(new NumberTickUnit(500000.0D, var2));
      var1.add(new NumberTickUnit(1000000.0D, var2));
      var1.add(new NumberTickUnit(2000000.0D, var2));
      var1.add(new NumberTickUnit(5000000.0D, var2));
      var1.add(new NumberTickUnit(1.0E7D, var2));
      var1.add(new NumberTickUnit(2.0E7D, var2));
      var1.add(new NumberTickUnit(5.0E7D, var2));
      var1.add(new NumberTickUnit(1.0E8D, var2));
      var1.add(new NumberTickUnit(2.0E8D, var2));
      var1.add(new NumberTickUnit(5.0E8D, var2));
      var1.add(new NumberTickUnit(1.0E9D, var2));
      var1.add(new NumberTickUnit(2.0E9D, var2));
      var1.add(new NumberTickUnit(5.0E9D, var2));
      var1.add(new NumberTickUnit(1.0E10D, var2));
      return var1;
   }

   protected double estimateMaximumTickLabelHeight(Graphics2D var1) {
      RectangleInsets var2 = this.getTickLabelInsets();
      double var3 = var2.getTop() + var2.getBottom();
      Font var5 = this.getTickLabelFont();
      FontRenderContext var6 = var1.getFontRenderContext();
      var3 += (double)var5.getLineMetrics("123", var6).getHeight();
      return var3;
   }

   protected double estimateMaximumTickLabelWidth(Graphics2D var1, TickUnit var2) {
      RectangleInsets var3 = this.getTickLabelInsets();
      double var4 = var3.getLeft() + var3.getRight();
      if(this.isVerticalTickLabels()) {
         FontRenderContext var6 = var1.getFontRenderContext();
         LineMetrics var7 = this.getTickLabelFont().getLineMetrics("0", var6);
         var4 += (double)var7.getHeight();
      } else {
         FontMetrics var19 = var1.getFontMetrics(this.getTickLabelFont());
         Range var20 = this.getRange();
         double var8 = var20.getLowerBound();
         double var10 = var20.getUpperBound();
         String var12 = "";
         String var13 = "";
         NumberFormat var14 = this.getNumberFormatOverride();
         if(var14 != null) {
            var12 = var14.format(var8);
            var13 = var14.format(var10);
         } else {
            var12 = var2.valueToString(var8);
            var13 = var2.valueToString(var10);
         }

         double var15 = (double)var19.stringWidth(var12);
         double var17 = (double)var19.stringWidth(var13);
         var4 += Math.max(var15, var17);
      }

      return var4;
   }

   protected void selectAutoTickUnit(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      if(RectangleEdge.isTopOrBottom(var3)) {
         this.selectHorizontalAutoTickUnit(var1, var2, var3);
      } else if(RectangleEdge.isLeftOrRight(var3)) {
         this.selectVerticalAutoTickUnit(var1, var2, var3);
      }

   }

   protected void selectHorizontalAutoTickUnit(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      double var4 = this.estimateMaximumTickLabelWidth(var1, this.getTickUnit());
      TickUnitSource var6 = this.getStandardTickUnits();
      TickUnit var7 = var6.getCeilingTickUnit(this.getTickUnit());
      double var8 = this.lengthToJava2D(var7.getSize(), var2, var3);
      double var10 = var4 / var8 * var7.getSize();
      NumberTickUnit var12 = (NumberTickUnit)var6.getCeilingTickUnit(var10);
      double var13 = this.lengthToJava2D(var12.getSize(), var2, var3);
      var4 = this.estimateMaximumTickLabelWidth(var1, var12);
      if(var4 > var13) {
         var12 = (NumberTickUnit)var6.getLargerTickUnit(var12);
      }

      this.setTickUnit(var12, false, false);
   }

   protected void selectVerticalAutoTickUnit(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      double var4 = this.estimateMaximumTickLabelHeight(var1);
      TickUnitSource var6 = this.getStandardTickUnits();
      TickUnit var7 = var6.getCeilingTickUnit(this.getTickUnit());
      double var8 = this.lengthToJava2D(var7.getSize(), var2, var3);
      double var10 = var4 / var8 * var7.getSize();
      NumberTickUnit var12 = (NumberTickUnit)var6.getCeilingTickUnit(var10);
      double var13 = this.lengthToJava2D(var12.getSize(), var2, var3);
      var4 = this.estimateMaximumTickLabelHeight(var1);
      if(var4 > var13) {
         var12 = (NumberTickUnit)var6.getLargerTickUnit(var12);
      }

      this.setTickUnit(var12, false, false);
   }

   public List refreshTicks(Graphics2D var1, AxisState var2, Rectangle2D var3, RectangleEdge var4) {
      Object var5 = new ArrayList();
      if(RectangleEdge.isTopOrBottom(var4)) {
         var5 = this.refreshTicksHorizontal(var1, var3, var4);
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var5 = this.refreshTicksVertical(var1, var3, var4);
      }

      return (List)var5;
   }

   protected List refreshTicksHorizontal(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      ArrayList var4 = new ArrayList();
      Font var5 = this.getTickLabelFont();
      var1.setFont(var5);
      if(this.isAutoTickUnitSelection()) {
         this.selectAutoTickUnit(var1, var2, var3);
      }

      double var6 = this.getTickUnit().getSize();
      int var8 = this.calculateVisibleTickCount();
      double var9 = this.calculateLowestVisibleTickValue();
      if(var8 <= 500) {
         for(int var11 = 0; var11 < var8; ++var11) {
            double var12 = var9 + (double)var11 * var6;
            NumberFormat var15 = this.getNumberFormatOverride();
            String var14;
            if(var15 != null) {
               var14 = var15.format(var12);
            } else {
               var14 = this.getTickUnit().valueToString(var12);
            }

            TextAnchor var16 = null;
            TextAnchor var17 = null;
            double var18 = 0.0D;
            if(this.isVerticalTickLabels()) {
               var16 = TextAnchor.CENTER_RIGHT;
               var17 = TextAnchor.CENTER_RIGHT;
               if(var3 == RectangleEdge.TOP) {
                  var18 = 1.5707963267948966D;
               } else {
                  var18 = -1.5707963267948966D;
               }
            } else if(var3 == RectangleEdge.TOP) {
               var16 = TextAnchor.BOTTOM_CENTER;
               var17 = TextAnchor.BOTTOM_CENTER;
            } else {
               var16 = TextAnchor.TOP_CENTER;
               var17 = TextAnchor.TOP_CENTER;
            }

            NumberTick var20 = new NumberTick(new Double(var12), var14, var16, var17, var18);
            var4.add(var20);
         }
      }

      return var4;
   }

   protected List refreshTicksVertical(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      ArrayList var4 = new ArrayList();
      var4.clear();
      Font var5 = this.getTickLabelFont();
      var1.setFont(var5);
      if(this.isAutoTickUnitSelection()) {
         this.selectAutoTickUnit(var1, var2, var3);
      }

      double var6 = this.getTickUnit().getSize();
      int var8 = this.calculateVisibleTickCount();
      double var9 = this.calculateLowestVisibleTickValue();
      if(var8 <= 500) {
         for(int var11 = 0; var11 < var8; ++var11) {
            double var12 = var9 + (double)var11 * var6;
            NumberFormat var15 = this.getNumberFormatOverride();
            String var14;
            if(var15 != null) {
               var14 = var15.format(var12);
            } else {
               var14 = this.getTickUnit().valueToString(var12);
            }

            TextAnchor var16 = null;
            TextAnchor var17 = null;
            double var18 = 0.0D;
            if(this.isVerticalTickLabels()) {
               if(var3 == RectangleEdge.LEFT) {
                  var16 = TextAnchor.BOTTOM_CENTER;
                  var17 = TextAnchor.BOTTOM_CENTER;
                  var18 = -1.5707963267948966D;
               } else {
                  var16 = TextAnchor.BOTTOM_CENTER;
                  var17 = TextAnchor.BOTTOM_CENTER;
                  var18 = 1.5707963267948966D;
               }
            } else if(var3 == RectangleEdge.LEFT) {
               var16 = TextAnchor.CENTER_RIGHT;
               var17 = TextAnchor.CENTER_RIGHT;
            } else {
               var16 = TextAnchor.CENTER_LEFT;
               var17 = TextAnchor.CENTER_LEFT;
            }

            NumberTick var20 = new NumberTick(new Double(var12), var14, var16, var17, var18);
            var4.add(var20);
         }
      }

      return var4;
   }

   public Object clone() {
      NumberAxis var1 = (NumberAxis)super.clone();
      if(this.numberFormatOverride != null) {
         var1.numberFormatOverride = (NumberFormat)this.numberFormatOverride.clone();
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof NumberAxis)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         NumberAxis var2 = (NumberAxis)var1;
         return this.autoRangeIncludesZero != var2.autoRangeIncludesZero?false:(this.autoRangeStickyZero != var2.autoRangeStickyZero?false:(!ObjectUtilities.equal(this.tickUnit, var2.tickUnit)?false:(!ObjectUtilities.equal(this.numberFormatOverride, var2.numberFormatOverride)?false:this.rangeType.equals(var2.rangeType))));
      }
   }

   public int hashCode() {
      return this.getLabel() != null?this.getLabel().hashCode():0;
   }
}
