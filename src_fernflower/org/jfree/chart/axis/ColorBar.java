package org.jfree.chart.axis;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.ColorPalette;
import org.jfree.chart.plot.ContourPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.RainbowPalette;
import org.jfree.ui.RectangleEdge;

public class ColorBar implements Serializable, Cloneable {
   private static final long serialVersionUID = -2101776212647268103L;
   public static final int DEFAULT_COLORBAR_THICKNESS = 0;
   public static final double DEFAULT_COLORBAR_THICKNESS_PERCENT = 0.1D;
   public static final int DEFAULT_OUTERGAP = 2;
   private ValueAxis axis;
   private int colorBarThickness = 0;
   private double colorBarThicknessPercent = 0.1D;
   private ColorPalette colorPalette = null;
   private int colorBarLength = 0;
   private int outerGap;

   public ColorBar(String var1) {
      NumberAxis var2 = new NumberAxis(var1);
      var2.setAutoRangeIncludesZero(false);
      this.axis = var2;
      this.axis.setLowerMargin(0.0D);
      this.axis.setUpperMargin(0.0D);
      this.colorPalette = new RainbowPalette();
      this.colorBarThickness = 0;
      this.colorBarThicknessPercent = 0.1D;
      this.outerGap = 2;
      this.colorPalette.setMinZ(this.axis.getRange().getLowerBound());
      this.colorPalette.setMaxZ(this.axis.getRange().getUpperBound());
   }

   public void configure(ContourPlot var1) {
      double var2 = var1.getDataset().getMinZValue();
      double var4 = var1.getDataset().getMaxZValue();
      this.setMinimumValue(var2);
      this.setMaximumValue(var4);
   }

   public ValueAxis getAxis() {
      return this.axis;
   }

   public void setAxis(ValueAxis var1) {
      this.axis = var1;
   }

   public void autoAdjustRange() {
      this.axis.autoAdjustRange();
      this.colorPalette.setMinZ(this.axis.getLowerBound());
      this.colorPalette.setMaxZ(this.axis.getUpperBound());
   }

   public double draw(Graphics2D var1, double var2, Rectangle2D var4, Rectangle2D var5, Rectangle2D var6, RectangleEdge var7) {
      Double var8 = null;
      double var9 = this.calculateBarThickness(var5, var7);
      if(this.colorBarThickness > 0) {
         var9 = (double)this.colorBarThickness;
      }

      double var11 = 0.0D;
      if(RectangleEdge.isLeftOrRight(var7)) {
         var11 = var5.getHeight();
      } else {
         var11 = var5.getWidth();
      }

      if(this.colorBarLength > 0) {
         var11 = (double)this.colorBarLength;
      }

      if(var7 == RectangleEdge.BOTTOM) {
         var8 = new Double(var5.getX(), var4.getMaxY() + (double)this.outerGap, var11, var9);
      } else if(var7 == RectangleEdge.TOP) {
         var8 = new Double(var5.getX(), var6.getMinY() + (double)this.outerGap, var11, var9);
      } else if(var7 == RectangleEdge.LEFT) {
         var8 = new Double(var4.getX() - var9 - (double)this.outerGap, var5.getMinY(), var9, var11);
      } else if(var7 == RectangleEdge.RIGHT) {
         var8 = new Double(var4.getMaxX() + (double)this.outerGap, var5.getMinY(), var9, var11);
      }

      this.axis.refreshTicks(var1, new AxisState(), var8, var7);
      this.drawColorBar(var1, var8, var7);
      AxisState var13 = null;
      if(var7 == RectangleEdge.TOP) {
         var2 = var8.getMinY();
         var13 = this.axis.draw(var1, var2, var6, var8, RectangleEdge.TOP, (PlotRenderingInfo)null);
      } else if(var7 == RectangleEdge.BOTTOM) {
         var2 = var8.getMaxY();
         var13 = this.axis.draw(var1, var2, var6, var8, RectangleEdge.BOTTOM, (PlotRenderingInfo)null);
      } else if(var7 == RectangleEdge.LEFT) {
         var2 = var8.getMinX();
         var13 = this.axis.draw(var1, var2, var6, var8, RectangleEdge.LEFT, (PlotRenderingInfo)null);
      } else if(var7 == RectangleEdge.RIGHT) {
         var2 = var8.getMaxX();
         var13 = this.axis.draw(var1, var2, var6, var8, RectangleEdge.RIGHT, (PlotRenderingInfo)null);
      }

      return var13.getCursor();
   }

   public void drawColorBar(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      Object var4 = var1.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
      var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
      Stroke var5 = var1.getStroke();
      var1.setStroke(new BasicStroke(1.0F));
      double var6;
      double var8;
      double var10;
      java.awt.geom.Line2D.Double var12;
      double var13;
      if(RectangleEdge.isTopOrBottom(var3)) {
         var6 = var2.getY();
         var8 = var2.getMaxY();
         var10 = var2.getX();

         for(var12 = new java.awt.geom.Line2D.Double(); var10 <= var2.getMaxX(); ++var10) {
            var13 = this.axis.java2DToValue(var10, var2, var3);
            var12.setLine(var10, var6, var10, var8);
            var1.setPaint(this.getPaint(var13));
            var1.draw(var12);
         }
      } else {
         var6 = var2.getX();
         var8 = var2.getMaxX();
         var10 = var2.getY();

         for(var12 = new java.awt.geom.Line2D.Double(); var10 <= var2.getMaxY(); ++var10) {
            var13 = this.axis.java2DToValue(var10, var2, var3);
            var12.setLine(var6, var10, var8, var10);
            var1.setPaint(this.getPaint(var13));
            var1.draw(var12);
         }
      }

      var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, var4);
      var1.setStroke(var5);
   }

   public ColorPalette getColorPalette() {
      return this.colorPalette;
   }

   public Paint getPaint(double var1) {
      return this.colorPalette.getPaint(var1);
   }

   public void setColorPalette(ColorPalette var1) {
      this.colorPalette = var1;
   }

   public void setMaximumValue(double var1) {
      this.colorPalette.setMaxZ(var1);
      this.axis.setUpperBound(var1);
   }

   public void setMinimumValue(double var1) {
      this.colorPalette.setMinZ(var1);
      this.axis.setLowerBound(var1);
   }

   public AxisSpace reserveSpace(Graphics2D var1, Plot var2, Rectangle2D var3, Rectangle2D var4, RectangleEdge var5, AxisSpace var6) {
      AxisSpace var7 = this.axis.reserveSpace(var1, var2, var3, var5, var6);
      double var8 = this.calculateBarThickness(var4, var5);
      var7.add(var8 + (double)(2 * this.outerGap), var5);
      return var7;
   }

   private double calculateBarThickness(Rectangle2D var1, RectangleEdge var2) {
      double var3 = 0.0D;
      if(RectangleEdge.isLeftOrRight(var2)) {
         var3 = var1.getWidth() * this.colorBarThicknessPercent;
      } else {
         var3 = var1.getHeight() * this.colorBarThicknessPercent;
      }

      return var3;
   }

   public Object clone() {
      ColorBar var1 = (ColorBar)super.clone();
      var1.axis = (ValueAxis)this.axis.clone();
      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ColorBar)) {
         return false;
      } else {
         ColorBar var2 = (ColorBar)var1;
         return !this.axis.equals(var2.axis)?false:(this.colorBarThickness != var2.colorBarThickness?false:(this.colorBarThicknessPercent != var2.colorBarThicknessPercent?false:(!this.colorPalette.equals(var2.colorPalette)?false:(this.colorBarLength != var2.colorBarLength?false:this.outerGap == var2.outerGap))));
      }
   }

   public int hashCode() {
      return this.axis.hashCode();
   }
}
