package org.jfree.chart.axis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.ValueTick;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;
import org.jfree.util.PaintUtilities;

public class SymbolAxis extends NumberAxis implements Serializable {
   private static final long serialVersionUID = 7216330468770619716L;
   public static final Paint DEFAULT_GRID_BAND_PAINT = new Color(232, 234, 232, 128);
   private List symbols;
   private transient Paint gridBandPaint;
   private boolean gridBandsVisible;

   public SymbolAxis(String var1, String[] var2) {
      super(var1);
      this.symbols = Arrays.asList(var2);
      this.gridBandsVisible = true;
      this.gridBandPaint = DEFAULT_GRID_BAND_PAINT;
      this.setAutoTickUnitSelection(false, false);
      this.setAutoRangeStickyZero(false);
   }

   public String[] getSymbols() {
      String[] var1 = new String[this.symbols.size()];
      var1 = (String[])((String[])this.symbols.toArray(var1));
      return var1;
   }

   public Paint getGridBandPaint() {
      return this.gridBandPaint;
   }

   public void setGridBandPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.gridBandPaint = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public boolean isGridBandsVisible() {
      return this.gridBandsVisible;
   }

   public void setGridBandsVisible(boolean var1) {
      if(this.gridBandsVisible != var1) {
         this.gridBandsVisible = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }

   }

   protected void selectAutoTickUnit(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      throw new UnsupportedOperationException();
   }

   public AxisState draw(Graphics2D var1, double var2, Rectangle2D var4, Rectangle2D var5, RectangleEdge var6, PlotRenderingInfo var7) {
      AxisState var8 = new AxisState(var2);
      if(this.isVisible()) {
         var8 = super.draw(var1, var2, var4, var5, var6, var7);
      }

      if(this.gridBandsVisible) {
         this.drawGridBands(var1, var4, var5, var6, var8.getTicks());
      }

      return var8;
   }

   protected void drawGridBands(Graphics2D var1, Rectangle2D var2, Rectangle2D var3, RectangleEdge var4, List var5) {
      Shape var6 = var1.getClip();
      var1.clip(var3);
      if(RectangleEdge.isTopOrBottom(var4)) {
         this.drawGridBandsHorizontal(var1, var2, var3, true, var5);
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         this.drawGridBandsVertical(var1, var2, var3, true, var5);
      }

      var1.setClip(var6);
   }

   protected void drawGridBandsHorizontal(Graphics2D var1, Rectangle2D var2, Rectangle2D var3, boolean var4, List var5) {
      boolean var6 = var4;
      double var7 = var3.getY();
      double var13;
      if(this.getPlot().getOutlineStroke() != null) {
         var13 = (double)((BasicStroke)this.getPlot().getOutlineStroke()).getLineWidth();
      } else {
         var13 = 1.0D;
      }

      for(Iterator var15 = var5.iterator(); var15.hasNext(); var6 = !var6) {
         ValueTick var16 = (ValueTick)var15.next();
         double var9 = this.valueToJava2D(var16.getValue() - 0.5D, var3, RectangleEdge.BOTTOM);
         double var11 = this.valueToJava2D(var16.getValue() + 0.5D, var3, RectangleEdge.BOTTOM);
         if(var6) {
            var1.setPaint(this.gridBandPaint);
         } else {
            var1.setPaint(Color.white);
         }

         Double var17 = new Double(var9, var7 + var13, var11 - var9, var3.getMaxY() - var7 - var13);
         var1.fill(var17);
      }

      var1.setPaintMode();
   }

   protected void drawGridBandsVertical(Graphics2D var1, Rectangle2D var2, Rectangle2D var3, boolean var4, List var5) {
      boolean var6 = var4;
      double var7 = var3.getX();
      Stroke var15 = this.getPlot().getOutlineStroke();
      double var13;
      if(var15 != null && var15 instanceof BasicStroke) {
         var13 = (double)((BasicStroke)var15).getLineWidth();
      } else {
         var13 = 1.0D;
      }

      for(Iterator var16 = var5.iterator(); var16.hasNext(); var6 = !var6) {
         ValueTick var17 = (ValueTick)var16.next();
         double var9 = this.valueToJava2D(var17.getValue() + 0.5D, var3, RectangleEdge.LEFT);
         double var11 = this.valueToJava2D(var17.getValue() - 0.5D, var3, RectangleEdge.LEFT);
         if(var6) {
            var1.setPaint(this.gridBandPaint);
         } else {
            var1.setPaint(Color.white);
         }

         Double var18 = new Double(var7 + var13, var9, var3.getMaxX() - var7 - var13, var11 - var9);
         var1.fill(var18);
      }

      var1.setPaintMode();
   }

   protected void autoAdjustRange() {
      Plot var1 = this.getPlot();
      if(var1 != null) {
         if(var1 instanceof ValueAxisPlot) {
            double var2 = (double)(this.symbols.size() - 1);
            double var4 = 0.0D;
            double var6 = var2 - var4;
            double var8 = this.getAutoRangeMinimumSize();
            if(var6 < var8) {
               var2 = (var2 + var4 + var8) / 2.0D;
               var4 = (var2 + var4 - var8) / 2.0D;
            }

            double var10 = 0.5D;
            double var12 = 0.5D;
            if(this.getAutoRangeIncludesZero()) {
               if(this.getAutoRangeStickyZero()) {
                  if(var2 <= 0.0D) {
                     var2 = 0.0D;
                  } else {
                     var2 += var10;
                  }

                  if(var4 >= 0.0D) {
                     var4 = 0.0D;
                  } else {
                     var4 -= var12;
                  }
               } else {
                  var2 = Math.max(0.0D, var2 + var10);
                  var4 = Math.min(0.0D, var4 - var12);
               }
            } else if(this.getAutoRangeStickyZero()) {
               if(var2 <= 0.0D) {
                  var2 = Math.min(0.0D, var2 + var10);
               } else {
                  var2 += var10 * var6;
               }

               if(var4 >= 0.0D) {
                  var4 = Math.max(0.0D, var4 - var12);
               } else {
                  var4 -= var12;
               }
            } else {
               var2 += var10;
               var4 -= var12;
            }

            this.setRange(new Range(var4, var2), false, false);
         }

      }
   }

   public List refreshTicks(Graphics2D var1, AxisState var2, Rectangle2D var3, RectangleEdge var4) {
      List var5 = null;
      if(RectangleEdge.isTopOrBottom(var4)) {
         var5 = this.refreshTicksHorizontal(var1, var3, var4);
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var5 = this.refreshTicksVertical(var1, var3, var4);
      }

      return var5;
   }

   protected List refreshTicksHorizontal(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      ArrayList var4 = new ArrayList();
      Font var5 = this.getTickLabelFont();
      var1.setFont(var5);
      double var6 = this.getTickUnit().getSize();
      int var8 = this.calculateVisibleTickCount();
      double var9 = this.calculateLowestVisibleTickValue();
      double var11 = 0.0D;
      double var13 = 0.0D;
      if(var8 <= 500) {
         for(int var15 = 0; var15 < var8; ++var15) {
            double var16 = var9 + (double)var15 * var6;
            double var18 = this.valueToJava2D(var16, var2, var3);
            NumberFormat var21 = this.getNumberFormatOverride();
            String var20;
            if(var21 != null) {
               var20 = var21.format(var16);
            } else {
               var20 = this.valueToString(var16);
            }

            Rectangle2D var22 = TextUtilities.getTextBounds(var20, var1, var1.getFontMetrics());
            double var23 = this.isVerticalTickLabels()?var22.getHeight():var22.getWidth();
            boolean var25 = false;
            if(var15 > 0) {
               double var26 = (var13 + var23) / 2.0D;
               if(Math.abs(var18 - var11) < var26) {
                  var25 = true;
               }
            }

            if(var25) {
               var20 = "";
            } else {
               var11 = var18;
               var13 = var23;
            }

            TextAnchor var31 = null;
            TextAnchor var27 = null;
            double var28 = 0.0D;
            if(this.isVerticalTickLabels()) {
               var31 = TextAnchor.CENTER_RIGHT;
               var27 = TextAnchor.CENTER_RIGHT;
               if(var3 == RectangleEdge.TOP) {
                  var28 = 1.5707963267948966D;
               } else {
                  var28 = -1.5707963267948966D;
               }
            } else if(var3 == RectangleEdge.TOP) {
               var31 = TextAnchor.BOTTOM_CENTER;
               var27 = TextAnchor.BOTTOM_CENTER;
            } else {
               var31 = TextAnchor.TOP_CENTER;
               var27 = TextAnchor.TOP_CENTER;
            }

            NumberTick var30 = new NumberTick(new java.lang.Double(var16), var20, var31, var27, var28);
            var4.add(var30);
         }
      }

      return var4;
   }

   protected List refreshTicksVertical(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      ArrayList var4 = new ArrayList();
      Font var5 = this.getTickLabelFont();
      var1.setFont(var5);
      double var6 = this.getTickUnit().getSize();
      int var8 = this.calculateVisibleTickCount();
      double var9 = this.calculateLowestVisibleTickValue();
      double var11 = 0.0D;
      double var13 = 0.0D;
      if(var8 <= 500) {
         for(int var15 = 0; var15 < var8; ++var15) {
            double var16 = var9 + (double)var15 * var6;
            double var18 = this.valueToJava2D(var16, var2, var3);
            NumberFormat var21 = this.getNumberFormatOverride();
            String var20;
            if(var21 != null) {
               var20 = var21.format(var16);
            } else {
               var20 = this.valueToString(var16);
            }

            Rectangle2D var22 = TextUtilities.getTextBounds(var20, var1, var1.getFontMetrics());
            double var23 = this.isVerticalTickLabels()?var22.getWidth():var22.getHeight();
            boolean var25 = false;
            if(var15 > 0) {
               double var26 = (var13 + var23) / 2.0D;
               if(Math.abs(var18 - var11) < var26) {
                  var25 = true;
               }
            }

            if(var25) {
               var20 = "";
            } else {
               var11 = var18;
               var13 = var23;
            }

            TextAnchor var31 = null;
            TextAnchor var27 = null;
            double var28 = 0.0D;
            if(this.isVerticalTickLabels()) {
               var31 = TextAnchor.BOTTOM_CENTER;
               var27 = TextAnchor.BOTTOM_CENTER;
               if(var3 == RectangleEdge.LEFT) {
                  var28 = -1.5707963267948966D;
               } else {
                  var28 = 1.5707963267948966D;
               }
            } else if(var3 == RectangleEdge.LEFT) {
               var31 = TextAnchor.CENTER_RIGHT;
               var27 = TextAnchor.CENTER_RIGHT;
            } else {
               var31 = TextAnchor.CENTER_LEFT;
               var27 = TextAnchor.CENTER_LEFT;
            }

            NumberTick var30 = new NumberTick(new java.lang.Double(var16), var20, var31, var27, var28);
            var4.add(var30);
         }
      }

      return var4;
   }

   public String valueToString(double var1) {
      String var3;
      try {
         var3 = (String)this.symbols.get((int)var1);
      } catch (IndexOutOfBoundsException var5) {
         var3 = "";
      }

      return var3;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof SymbolAxis)) {
         return false;
      } else {
         SymbolAxis var2 = (SymbolAxis)var1;
         return !this.symbols.equals(var2.symbols)?false:(this.gridBandsVisible != var2.gridBandsVisible?false:(!PaintUtilities.equal(this.gridBandPaint, var2.gridBandPaint)?false:super.equals(var1)));
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.gridBandPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.gridBandPaint = SerialUtilities.readPaint(var1);
   }
}
