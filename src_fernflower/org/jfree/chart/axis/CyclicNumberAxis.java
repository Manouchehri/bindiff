package org.jfree.chart.axis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.CyclicNumberAxis$CycleBoundTick;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.Tick;
import org.jfree.chart.axis.ValueTick;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class CyclicNumberAxis extends NumberAxis {
   public static Stroke DEFAULT_ADVANCE_LINE_STROKE = new BasicStroke(1.0F);
   public static final Paint DEFAULT_ADVANCE_LINE_PAINT;
   protected double offset;
   protected double period;
   protected boolean boundMappedToLastCycle;
   protected boolean advanceLineVisible;
   protected transient Stroke advanceLineStroke;
   protected transient Paint advanceLinePaint;
   private transient boolean internalMarkerWhenTicksOverlap;
   private transient Tick internalMarkerCycleBoundTick;

   public CyclicNumberAxis(double var1) {
      this(var1, 0.0D);
   }

   public CyclicNumberAxis(double var1, double var3) {
      this(var1, var3, (String)null);
   }

   public CyclicNumberAxis(double var1, String var3) {
      this(0.0D, var1, var3);
   }

   public CyclicNumberAxis(double var1, double var3, String var5) {
      super(var5);
      this.advanceLineStroke = DEFAULT_ADVANCE_LINE_STROKE;
      this.period = var1;
      this.offset = var3;
      this.setFixedAutoRange(var1);
      this.advanceLineVisible = true;
      this.advanceLinePaint = DEFAULT_ADVANCE_LINE_PAINT;
   }

   public boolean isAdvanceLineVisible() {
      return this.advanceLineVisible;
   }

   public void setAdvanceLineVisible(boolean var1) {
      this.advanceLineVisible = var1;
   }

   public Paint getAdvanceLinePaint() {
      return this.advanceLinePaint;
   }

   public void setAdvanceLinePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.advanceLinePaint = var1;
      }
   }

   public Stroke getAdvanceLineStroke() {
      return this.advanceLineStroke;
   }

   public void setAdvanceLineStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.advanceLineStroke = var1;
      }
   }

   public boolean isBoundMappedToLastCycle() {
      return this.boundMappedToLastCycle;
   }

   public void setBoundMappedToLastCycle(boolean var1) {
      this.boundMappedToLastCycle = var1;
   }

   protected void selectHorizontalAutoTickUnit(Graphics2D var1, Rectangle2D var2, Rectangle2D var3, RectangleEdge var4) {
      double var5 = this.estimateMaximumTickLabelWidth(var1, this.getTickUnit());
      double var7 = this.getRange().getLength() * var5 / var3.getWidth();
      this.setTickUnit((NumberTickUnit)this.getStandardTickUnits().getCeilingTickUnit(var7), false, false);
   }

   protected void selectVerticalAutoTickUnit(Graphics2D var1, Rectangle2D var2, Rectangle2D var3, RectangleEdge var4) {
      double var5 = this.estimateMaximumTickLabelWidth(var1, this.getTickUnit());
      double var7 = this.getRange().getLength() * var5 / var3.getHeight();
      this.setTickUnit((NumberTickUnit)this.getStandardTickUnits().getCeilingTickUnit(var7), false, false);
   }

   protected float[] calculateAnchorPoint(ValueTick var1, double var2, Rectangle2D var4, RectangleEdge var5) {
      if(var1 instanceof CyclicNumberAxis$CycleBoundTick) {
         boolean var6 = this.boundMappedToLastCycle;
         this.boundMappedToLastCycle = ((CyclicNumberAxis$CycleBoundTick)var1).mapToLastCycle;
         float[] var7 = super.calculateAnchorPoint(var1, var2, var4, var5);
         this.boundMappedToLastCycle = var6;
         return var7;
      } else {
         return super.calculateAnchorPoint(var1, var2, var4, var5);
      }
   }

   protected List refreshTicksHorizontal(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      ArrayList var4 = new ArrayList();
      Font var5 = this.getTickLabelFont();
      var1.setFont(var5);
      if(this.isAutoTickUnitSelection()) {
         this.selectAutoTickUnit(var1, var2, var3);
      }

      double var6 = this.getTickUnit().getSize();
      double var8 = this.getCycleBound();
      double var10 = Math.ceil(var8 / var6) * var6;
      double var12 = this.getRange().getUpperBound();
      boolean var14 = false;
      boolean var15 = this.boundMappedToLastCycle;
      this.boundMappedToLastCycle = false;
      CyclicNumberAxis$CycleBoundTick var16 = null;
      float var17 = 0.0F;
      if(var12 == var8) {
         var10 = this.calculateLowestVisibleTickValue();
         var14 = true;
         this.boundMappedToLastCycle = true;
      }

      while(var10 <= var12) {
         boolean var18 = false;
         if(var10 + var6 > var12 && !var14) {
            var18 = true;
         }

         double var19 = this.valueToJava2D(var10, var2, var3);
         NumberFormat var22 = this.getNumberFormatOverride();
         String var21;
         if(var22 != null) {
            var21 = var22.format(var10);
         } else {
            var21 = this.getTickUnit().valueToString(var10);
         }

         float var23 = (float)var19;
         TextAnchor var24 = null;
         TextAnchor var25 = null;
         double var26 = 0.0D;
         if(this.isVerticalTickLabels()) {
            if(var3 == RectangleEdge.TOP) {
               var26 = 1.5707963267948966D;
            } else {
               var26 = -1.5707963267948966D;
            }

            var24 = TextAnchor.CENTER_RIGHT;
            if(var16 != null && var17 == var23 && var10 != var8) {
               var24 = this.isInverted()?TextAnchor.TOP_RIGHT:TextAnchor.BOTTOM_RIGHT;
               var4.remove(var4.size() - 1);
               var4.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, var16.getNumber(), var16.getText(), var24, var24, var16.getAngle()));
               this.internalMarkerWhenTicksOverlap = true;
               var24 = this.isInverted()?TextAnchor.BOTTOM_RIGHT:TextAnchor.TOP_RIGHT;
            }

            var25 = var24;
         } else if(var3 == RectangleEdge.TOP) {
            var24 = TextAnchor.BOTTOM_CENTER;
            if(var16 != null && var17 == var23 && var10 != var8) {
               var24 = this.isInverted()?TextAnchor.BOTTOM_LEFT:TextAnchor.BOTTOM_RIGHT;
               var4.remove(var4.size() - 1);
               var4.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, var16.getNumber(), var16.getText(), var24, var24, var16.getAngle()));
               this.internalMarkerWhenTicksOverlap = true;
               var24 = this.isInverted()?TextAnchor.BOTTOM_RIGHT:TextAnchor.BOTTOM_LEFT;
            }

            var25 = var24;
         } else {
            var24 = TextAnchor.TOP_CENTER;
            if(var16 != null && var17 == var23 && var10 != var8) {
               var24 = this.isInverted()?TextAnchor.TOP_LEFT:TextAnchor.TOP_RIGHT;
               var4.remove(var4.size() - 1);
               var4.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, var16.getNumber(), var16.getText(), var24, var24, var16.getAngle()));
               this.internalMarkerWhenTicksOverlap = true;
               var24 = this.isInverted()?TextAnchor.TOP_RIGHT:TextAnchor.TOP_LEFT;
            }

            var25 = var24;
         }

         CyclicNumberAxis$CycleBoundTick var28 = new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, new Double(var10), var21, var24, var25, var26);
         if(var10 == var8) {
            this.internalMarkerCycleBoundTick = var28;
         }

         var4.add(var28);
         var16 = var28;
         var17 = var23;
         var10 += var6;
         if(var18) {
            var10 = this.calculateLowestVisibleTickValue();
            var12 = var8;
            var14 = true;
            this.boundMappedToLastCycle = true;
         }
      }

      this.boundMappedToLastCycle = var15;
      return var4;
   }

   protected List refreshVerticalTicks(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      ArrayList var4 = new ArrayList();
      var4.clear();
      Font var5 = this.getTickLabelFont();
      var1.setFont(var5);
      if(this.isAutoTickUnitSelection()) {
         this.selectAutoTickUnit(var1, var2, var3);
      }

      double var6 = this.getTickUnit().getSize();
      double var8 = this.getCycleBound();
      double var10 = Math.ceil(var8 / var6) * var6;
      double var12 = this.getRange().getUpperBound();
      boolean var14 = false;
      boolean var15 = this.boundMappedToLastCycle;
      this.boundMappedToLastCycle = true;
      CyclicNumberAxis$CycleBoundTick var16 = null;
      float var17 = 0.0F;
      if(var12 == var8) {
         var10 = this.calculateLowestVisibleTickValue();
         var14 = true;
         this.boundMappedToLastCycle = true;
      }

      while(var10 <= var12) {
         boolean var18 = false;
         if(var10 + var6 > var12 && !var14) {
            var18 = true;
         }

         double var19 = this.valueToJava2D(var10, var2, var3);
         NumberFormat var22 = this.getNumberFormatOverride();
         String var21;
         if(var22 != null) {
            var21 = var22.format(var10);
         } else {
            var21 = this.getTickUnit().valueToString(var10);
         }

         float var23 = (float)var19;
         TextAnchor var24 = null;
         TextAnchor var25 = null;
         double var26 = 0.0D;
         if(this.isVerticalTickLabels()) {
            if(var3 == RectangleEdge.LEFT) {
               var24 = TextAnchor.BOTTOM_CENTER;
               if(var16 != null && var17 == var23 && var10 != var8) {
                  var24 = this.isInverted()?TextAnchor.BOTTOM_LEFT:TextAnchor.BOTTOM_RIGHT;
                  var4.remove(var4.size() - 1);
                  var4.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, var16.getNumber(), var16.getText(), var24, var24, var16.getAngle()));
                  this.internalMarkerWhenTicksOverlap = true;
                  var24 = this.isInverted()?TextAnchor.BOTTOM_RIGHT:TextAnchor.BOTTOM_LEFT;
               }

               var25 = var24;
               var26 = -1.5707963267948966D;
            } else {
               var24 = TextAnchor.BOTTOM_CENTER;
               if(var16 != null && var17 == var23 && var10 != var8) {
                  var24 = this.isInverted()?TextAnchor.BOTTOM_RIGHT:TextAnchor.BOTTOM_LEFT;
                  var4.remove(var4.size() - 1);
                  var4.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, var16.getNumber(), var16.getText(), var24, var24, var16.getAngle()));
                  this.internalMarkerWhenTicksOverlap = true;
                  var24 = this.isInverted()?TextAnchor.BOTTOM_LEFT:TextAnchor.BOTTOM_RIGHT;
               }

               var25 = var24;
               var26 = 1.5707963267948966D;
            }
         } else if(var3 == RectangleEdge.LEFT) {
            var24 = TextAnchor.CENTER_RIGHT;
            if(var16 != null && var17 == var23 && var10 != var8) {
               var24 = this.isInverted()?TextAnchor.BOTTOM_RIGHT:TextAnchor.TOP_RIGHT;
               var4.remove(var4.size() - 1);
               var4.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, var16.getNumber(), var16.getText(), var24, var24, var16.getAngle()));
               this.internalMarkerWhenTicksOverlap = true;
               var24 = this.isInverted()?TextAnchor.TOP_RIGHT:TextAnchor.BOTTOM_RIGHT;
            }

            var25 = var24;
         } else {
            var24 = TextAnchor.CENTER_LEFT;
            if(var16 != null && var17 == var23 && var10 != var8) {
               var24 = this.isInverted()?TextAnchor.BOTTOM_LEFT:TextAnchor.TOP_LEFT;
               var4.remove(var4.size() - 1);
               var4.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, var16.getNumber(), var16.getText(), var24, var24, var16.getAngle()));
               this.internalMarkerWhenTicksOverlap = true;
               var24 = this.isInverted()?TextAnchor.TOP_LEFT:TextAnchor.BOTTOM_LEFT;
            }

            var25 = var24;
         }

         CyclicNumberAxis$CycleBoundTick var28 = new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, new Double(var10), var21, var24, var25, var26);
         if(var10 == var8) {
            this.internalMarkerCycleBoundTick = var28;
         }

         var4.add(var28);
         var16 = var28;
         var17 = var23;
         if(var10 == var8) {
            this.internalMarkerCycleBoundTick = var28;
         }

         var10 += var6;
         if(var18) {
            var10 = this.calculateLowestVisibleTickValue();
            var12 = var8;
            var14 = true;
            this.boundMappedToLastCycle = false;
         }
      }

      this.boundMappedToLastCycle = var15;
      return var4;
   }

   public double java2DToValue(double var1, Rectangle2D var3, RectangleEdge var4) {
      Range var5 = this.getRange();
      double var6 = var5.getUpperBound();
      double var8 = this.getCycleBound();
      double var10 = 0.0D;
      double var12 = 0.0D;
      if(RectangleEdge.isTopOrBottom(var4)) {
         var10 = var3.getMinX();
         var12 = var3.getMaxX();
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var10 = var3.getMaxY();
         var12 = var3.getMinY();
      }

      double var14;
      if(this.isInverted()) {
         var14 = var12 - (var6 - var8) * (var12 - var10) / this.period;
         return var1 >= var14?var8 + (var12 - var1) * this.period / (var12 - var10):var8 - (var1 - var10) * this.period / (var12 - var10);
      } else {
         var14 = (var6 - var8) * (var12 - var10) / this.period + var10;
         return var1 <= var14?var8 + (var1 - var10) * this.period / (var12 - var10):var8 - (var12 - var1) * this.period / (var12 - var10);
      }
   }

   public double valueToJava2D(double var1, Rectangle2D var3, RectangleEdge var4) {
      Range var5 = this.getRange();
      double var6 = var5.getLowerBound();
      double var8 = var5.getUpperBound();
      double var10 = this.getCycleBound();
      if(var1 >= var6 && var1 <= var8) {
         double var12 = 0.0D;
         double var14 = 0.0D;
         if(RectangleEdge.isTopOrBottom(var4)) {
            var12 = var3.getMinX();
            var14 = var3.getMaxX();
         } else if(RectangleEdge.isLeftOrRight(var4)) {
            var14 = var3.getMinY();
            var12 = var3.getMaxY();
         }

         return this.isInverted()?(var1 == var10?(this.boundMappedToLastCycle?var12:var14):(var1 > var10?var14 - (var1 - var10) * (var14 - var12) / this.period:var12 + (var10 - var1) * (var14 - var12) / this.period)):(var1 == var10?(this.boundMappedToLastCycle?var14:var12):(var1 >= var10?var12 + (var1 - var10) * (var14 - var12) / this.period:var14 - (var10 - var1) * (var14 - var12) / this.period));
      } else {
         return Double.NaN;
      }
   }

   public void centerRange(double var1) {
      this.setRange(var1 - this.period / 2.0D, var1 + this.period / 2.0D);
   }

   public void setAutoRangeMinimumSize(double var1, boolean var3) {
      if(var1 > this.period) {
         this.period = var1;
      }

      super.setAutoRangeMinimumSize(var1, var3);
   }

   public void setFixedAutoRange(double var1) {
      this.period = var1;
      super.setFixedAutoRange(var1);
   }

   public void setRange(Range var1, boolean var2, boolean var3) {
      double var4 = var1.getUpperBound() - var1.getLowerBound();
      if(var4 > this.period) {
         this.period = var4;
      }

      super.setRange(var1, var2, var3);
   }

   public double getCycleBound() {
      return Math.floor((this.getRange().getUpperBound() - this.offset) / this.period) * this.period + this.offset;
   }

   public double getOffset() {
      return this.offset;
   }

   public void setOffset(double var1) {
      this.offset = var1;
   }

   public double getPeriod() {
      return this.period;
   }

   public void setPeriod(double var1) {
      this.period = var1;
   }

   protected AxisState drawTickMarksAndLabels(Graphics2D var1, double var2, Rectangle2D var4, Rectangle2D var5, RectangleEdge var6) {
      this.internalMarkerWhenTicksOverlap = false;
      AxisState var7 = super.drawTickMarksAndLabels(var1, var2, var4, var5, var6);
      if(!this.internalMarkerWhenTicksOverlap) {
         return var7;
      } else {
         double var8 = (double)this.getTickMarkOutsideLength();
         FontMetrics var10 = var1.getFontMetrics(this.getTickLabelFont());
         if(this.isVerticalTickLabels()) {
            var8 = (double)var10.getMaxAdvance();
         } else {
            var8 = (double)var10.getHeight();
         }

         double var11 = 0.0D;
         if(this.isTickMarksVisible()) {
            float var13 = (float)this.valueToJava2D(this.getRange().getUpperBound(), var5, var6);
            java.awt.geom.Line2D.Double var14 = null;
            var1.setStroke(this.getTickMarkStroke());
            var1.setPaint(this.getTickMarkPaint());
            if(var6 == RectangleEdge.LEFT) {
               var14 = new java.awt.geom.Line2D.Double(var2 - var8, (double)var13, var2 + var11, (double)var13);
            } else if(var6 == RectangleEdge.RIGHT) {
               var14 = new java.awt.geom.Line2D.Double(var2 + var8, (double)var13, var2 - var11, (double)var13);
            } else if(var6 == RectangleEdge.TOP) {
               var14 = new java.awt.geom.Line2D.Double((double)var13, var2 - var8, (double)var13, var2 + var11);
            } else if(var6 == RectangleEdge.BOTTOM) {
               var14 = new java.awt.geom.Line2D.Double((double)var13, var2 + var8, (double)var13, var2 - var11);
            }

            var1.draw(var14);
         }

         return var7;
      }
   }

   public AxisState draw(Graphics2D var1, double var2, Rectangle2D var4, Rectangle2D var5, RectangleEdge var6, PlotRenderingInfo var7) {
      AxisState var8 = super.draw(var1, var2, var4, var5, var6, var7);
      if(this.isAdvanceLineVisible()) {
         double var9 = this.valueToJava2D(this.getRange().getUpperBound(), var5, var6);
         java.awt.geom.Line2D.Double var11 = null;
         var1.setStroke(this.getAdvanceLineStroke());
         var1.setPaint(this.getAdvanceLinePaint());
         if(var6 == RectangleEdge.LEFT) {
            var11 = new java.awt.geom.Line2D.Double(var2, var9, var2 + var5.getWidth(), var9);
         } else if(var6 == RectangleEdge.RIGHT) {
            var11 = new java.awt.geom.Line2D.Double(var2 - var5.getWidth(), var9, var2, var9);
         } else if(var6 == RectangleEdge.TOP) {
            var11 = new java.awt.geom.Line2D.Double(var9, var2 + var5.getHeight(), var9, var2);
         } else if(var6 == RectangleEdge.BOTTOM) {
            var11 = new java.awt.geom.Line2D.Double(var9, var2, var9, var2 - var5.getHeight());
         }

         var1.draw(var11);
      }

      return var8;
   }

   public AxisSpace reserveSpace(Graphics2D var1, Plot var2, Rectangle2D var3, RectangleEdge var4, AxisSpace var5) {
      this.internalMarkerCycleBoundTick = null;
      AxisSpace var6 = super.reserveSpace(var1, var2, var3, var4, var5);
      if(this.internalMarkerCycleBoundTick == null) {
         return var6;
      } else {
         FontMetrics var7 = var1.getFontMetrics(this.getTickLabelFont());
         Rectangle2D var8 = TextUtilities.getTextBounds(this.internalMarkerCycleBoundTick.getText(), var1, var7);
         if(RectangleEdge.isTopOrBottom(var4)) {
            if(this.isVerticalTickLabels()) {
               var5.add(var8.getHeight() / 2.0D, RectangleEdge.RIGHT);
            } else {
               var5.add(var8.getWidth() / 2.0D, RectangleEdge.RIGHT);
            }
         } else if(RectangleEdge.isLeftOrRight(var4)) {
            if(this.isVerticalTickLabels()) {
               var5.add(var8.getWidth() / 2.0D, RectangleEdge.TOP);
            } else {
               var5.add(var8.getHeight() / 2.0D, RectangleEdge.TOP);
            }
         }

         return var6;
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.advanceLinePaint, var1);
      SerialUtilities.writeStroke(this.advanceLineStroke, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.advanceLinePaint = SerialUtilities.readPaint(var1);
      this.advanceLineStroke = SerialUtilities.readStroke(var1);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CyclicNumberAxis)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         CyclicNumberAxis var2 = (CyclicNumberAxis)var1;
         return this.period != var2.period?false:(this.offset != var2.offset?false:(!PaintUtilities.equal(this.advanceLinePaint, var2.advanceLinePaint)?false:(!ObjectUtilities.equal(this.advanceLineStroke, var2.advanceLineStroke)?false:(this.advanceLineVisible != var2.advanceLineVisible?false:this.boundMappedToLastCycle == var2.boundMappedToLastCycle))));
      }
   }

   static {
      DEFAULT_ADVANCE_LINE_PAINT = Color.gray;
   }
}
