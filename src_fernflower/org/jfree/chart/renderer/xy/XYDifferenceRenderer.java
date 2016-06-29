package org.jfree.chart.renderer.xy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class XYDifferenceRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   private static final long serialVersionUID = -8447915602375584857L;
   private transient Paint positivePaint;
   private transient Paint negativePaint;
   private boolean shapesVisible;
   private transient Shape legendLine;
   private boolean roundXCoordinates;

   public XYDifferenceRenderer() {
      this(Color.green, Color.red, false);
   }

   public XYDifferenceRenderer(Paint var1, Paint var2, boolean var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'positivePaint\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'negativePaint\' argument.");
      } else {
         this.positivePaint = var1;
         this.negativePaint = var2;
         this.shapesVisible = var3;
         this.legendLine = new Double(-7.0D, 0.0D, 7.0D, 0.0D);
         this.roundXCoordinates = false;
      }
   }

   public Paint getPositivePaint() {
      return this.positivePaint;
   }

   public void setPositivePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.positivePaint = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public Paint getNegativePaint() {
      return this.negativePaint;
   }

   public void setNegativePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.negativePaint = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public boolean getShapesVisible() {
      return this.shapesVisible;
   }

   public void setShapesVisible(boolean var1) {
      this.shapesVisible = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public Shape getLegendLine() {
      return this.legendLine;
   }

   public void setLegendLine(Shape var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'line\' argument.");
      } else {
         this.legendLine = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public boolean getRoundXCoordinates() {
      return this.roundXCoordinates;
   }

   public void setRoundXCoordinates(boolean var1) {
      this.roundXCoordinates = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public XYItemRendererState initialise(Graphics2D var1, Rectangle2D var2, XYPlot var3, XYDataset var4, PlotRenderingInfo var5) {
      return super.initialise(var1, var2, var3, var4, var5);
   }

   public int getPassCount() {
      return 2;
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      if(var12 == 0) {
         this.drawItemPass0(var1, var3, var4, var5, var6, var7, var8, var9, var10, var11);
      } else if(var12 == 1) {
         this.drawItemPass1(var1, var3, var4, var5, var6, var7, var8, var9, var10, var11);
      }

   }

   protected void drawItemPass0(Graphics2D var1, Rectangle2D var2, PlotRenderingInfo var3, XYPlot var4, ValueAxis var5, ValueAxis var6, XYDataset var7, int var8, int var9, CrosshairState var10) {
      if(var8 == 0) {
         PlotOrientation var11 = var4.getOrientation();
         RectangleEdge var12 = var4.getDomainAxisEdge();
         RectangleEdge var13 = var4.getRangeAxisEdge();
         double var14 = var7.getYValue(0, var9);
         double var16 = var7.getXValue(1, var9);
         double var18 = var7.getYValue(1, var9);
         double var20 = var6.valueToJava2D(var14, var2, var13);
         double var22 = var5.valueToJava2D(var16, var2, var12);
         if(this.roundXCoordinates) {
            var22 = Math.rint(var22);
         }

         double var24 = var6.valueToJava2D(var18, var2, var13);
         if(var9 > 0) {
            double var26 = var7.getXValue(0, var9 - 1);
            double var28 = var7.getYValue(0, var9 - 1);
            double var30 = var7.getYValue(1, var9 - 1);
            double var32 = var5.valueToJava2D(var26, var2, var12);
            if(this.roundXCoordinates) {
               var32 = Math.rint(var32);
            }

            double var34 = var6.valueToJava2D(var28, var2, var13);
            double var36 = var6.valueToJava2D(var30, var2, var13);
            Shape var38 = this.getPositiveArea((float)var32, (float)var34, (float)var36, (float)var22, (float)var20, (float)var24, var11);
            if(var38 != null) {
               var1.setPaint(this.getPositivePaint());
               var1.fill(var38);
            }

            Shape var39 = this.getNegativeArea((float)var32, (float)var34, (float)var36, (float)var22, (float)var20, (float)var24, var11);
            if(var39 != null) {
               var1.setPaint(this.getNegativePaint());
               var1.fill(var39);
            }
         }
      }

   }

   protected void drawItemPass1(Graphics2D var1, Rectangle2D var2, PlotRenderingInfo var3, XYPlot var4, ValueAxis var5, ValueAxis var6, XYDataset var7, int var8, int var9, CrosshairState var10) {
      Object var11 = null;
      Object var12 = null;
      EntityCollection var13 = null;
      if(var3 != null) {
         var13 = var3.getOwner().getEntityCollection();
      }

      Paint var14 = this.getItemPaint(var8, var9);
      Stroke var15 = this.getItemStroke(var8, var9);
      var1.setPaint(var14);
      var1.setStroke(var15);
      if(var8 == 0) {
         PlotOrientation var16 = var4.getOrientation();
         RectangleEdge var17 = var4.getDomainAxisEdge();
         RectangleEdge var18 = var4.getRangeAxisEdge();
         double var19 = var7.getXValue(0, var9);
         double var21 = var7.getYValue(0, var9);
         double var23 = var7.getXValue(1, var9);
         double var25 = var7.getYValue(1, var9);
         double var27 = var5.valueToJava2D(var19, var2, var17);
         double var29 = var6.valueToJava2D(var21, var2, var18);
         double var31 = var5.valueToJava2D(var23, var2, var17);
         double var33 = var6.valueToJava2D(var25, var2, var18);
         if(var9 > 0) {
            double var35 = var7.getXValue(0, var9 - 1);
            double var37 = var7.getYValue(0, var9 - 1);
            double var39 = var7.getXValue(1, var9 - 1);
            double var41 = var7.getYValue(1, var9 - 1);
            double var43 = var5.valueToJava2D(var35, var2, var17);
            double var45 = var6.valueToJava2D(var37, var2, var18);
            double var47 = var5.valueToJava2D(var39, var2, var17);
            double var49 = var6.valueToJava2D(var41, var2, var18);
            Double var51 = null;
            Double var52 = null;
            if(var16 == PlotOrientation.HORIZONTAL) {
               var51 = new Double(var29, var27, var45, var43);
               var52 = new Double(var33, var31, var49, var47);
            } else if(var16 == PlotOrientation.VERTICAL) {
               var51 = new Double(var27, var29, var43, var45);
               var52 = new Double(var31, var33, var47, var49);
            }

            if(var51 != null && var51.intersects(var2)) {
               var1.setPaint(this.getItemPaint(var8, var9));
               var1.setStroke(this.getItemStroke(var8, var9));
               var1.draw(var51);
            }

            if(var52 != null && var52.intersects(var2)) {
               var1.setPaint(this.getItemPaint(1, var9));
               var1.setStroke(this.getItemStroke(1, var9));
               var1.draw(var52);
            }
         }

         if(this.getShapesVisible()) {
            Shape var53 = this.getItemShape(var8, var9);
            if(var16 == PlotOrientation.HORIZONTAL) {
               var53 = ShapeUtilities.createTranslatedShape(var53, var29, var27);
            } else {
               var53 = ShapeUtilities.createTranslatedShape(var53, var27, var29);
            }

            if(var53.intersects(var2)) {
               var1.setPaint(this.getItemPaint(var8, var9));
               var1.fill(var53);
            }

            var11 = var53;
            Shape var36 = this.getItemShape(var8 + 1, var9);
            if(var16 == PlotOrientation.HORIZONTAL) {
               var36 = ShapeUtilities.createTranslatedShape(var36, var33, var31);
            } else {
               var36 = ShapeUtilities.createTranslatedShape(var36, var31, var33);
            }

            if(var36.intersects(var2)) {
               var1.setPaint(this.getItemPaint(var8 + 1, var9));
               var1.fill(var36);
            }

            var12 = var36;
         }

         if(var13 != null) {
            if(var11 == null) {
               var11 = new java.awt.geom.Rectangle2D.Double(var27 - 2.0D, var29 - 2.0D, 4.0D, 4.0D);
            }

            String var54 = null;
            XYToolTipGenerator var55 = this.getToolTipGenerator(var8, var9);
            if(var55 != null) {
               var54 = var55.generateToolTip(var7, var8, var9);
            }

            String var56 = null;
            if(this.getURLGenerator() != null) {
               var56 = this.getURLGenerator().generateURL(var7, var8, var9);
            }

            XYItemEntity var38 = new XYItemEntity((Shape)var11, var7, var8, var9, var54, var56);
            var13.add(var38);
            if(var12 == null) {
               var12 = new java.awt.geom.Rectangle2D.Double(var31 - 2.0D, var33 - 2.0D, 4.0D, 4.0D);
            }

            var54 = null;
            var55 = this.getToolTipGenerator(var8, var9);
            if(var55 != null) {
               var54 = var55.generateToolTip(var7, var8 + 1, var9);
            }

            var56 = null;
            if(this.getURLGenerator() != null) {
               var56 = this.getURLGenerator().generateURL(var7, var8 + 1, var9);
            }

            var38 = new XYItemEntity((Shape)var12, var7, var8 + 1, var9, var54, var56);
            var13.add(var38);
         }

         int var58 = var4.getDomainAxisIndex(var5);
         int var57 = var4.getRangeAxisIndex(var6);
         this.updateCrosshairValues(var10, var23, var25, var58, var57, var31, var33, var16);
         this.updateCrosshairValues(var10, var19, var21, var58, var57, var27, var29, var16);
      }

   }

   protected Shape getPositiveArea(float var1, float var2, float var3, float var4, float var5, float var6, PlotOrientation var7) {
      GeneralPath var8 = null;
      boolean var9 = var2 >= var3;
      boolean var10 = var5 >= var6;
      if(var7 == PlotOrientation.HORIZONTAL) {
         var9 = var3 >= var2;
         var10 = var6 >= var5;
      }

      float[] var11;
      GeneralPath var12;
      if(var9) {
         if(var10) {
            var8 = null;
         } else {
            var11 = this.getIntersection(var1, var2, var4, var5, var1, var3, var4, var6);
            var12 = new GeneralPath();
            if(var7 == PlotOrientation.HORIZONTAL) {
               var12.moveTo(var5, var4);
               var12.lineTo(var11[1], var11[0]);
               var12.lineTo(var6, var4);
               var12.closePath();
            } else if(var7 == PlotOrientation.VERTICAL) {
               var12.moveTo(var4, var5);
               var12.lineTo(var11[0], var11[1]);
               var12.lineTo(var4, var6);
               var12.closePath();
            }

            var8 = var12;
         }
      } else if(var10) {
         var11 = this.getIntersection(var1, var2, var4, var5, var1, var3, var4, var6);
         var12 = new GeneralPath();
         if(var7 == PlotOrientation.HORIZONTAL) {
            var12.moveTo(var2, var1);
            var12.lineTo(var11[1], var11[0]);
            var12.lineTo(var3, var1);
            var12.closePath();
         } else if(var7 == PlotOrientation.VERTICAL) {
            var12.moveTo(var1, var2);
            var12.lineTo(var11[0], var11[1]);
            var12.lineTo(var1, var3);
            var12.closePath();
         }

         var8 = var12;
      } else {
         GeneralPath var13 = new GeneralPath();
         if(var7 == PlotOrientation.HORIZONTAL) {
            var13.moveTo(var2, var1);
            var13.lineTo(var5, var4);
            var13.lineTo(var6, var4);
            var13.lineTo(var3, var1);
            var13.closePath();
         } else if(var7 == PlotOrientation.VERTICAL) {
            var13.moveTo(var1, var2);
            var13.lineTo(var4, var5);
            var13.lineTo(var4, var6);
            var13.lineTo(var1, var3);
            var13.closePath();
         }

         var8 = var13;
      }

      return var8;
   }

   protected Shape getNegativeArea(float var1, float var2, float var3, float var4, float var5, float var6, PlotOrientation var7) {
      GeneralPath var8 = null;
      boolean var9 = var2 >= var3;
      boolean var10 = var5 >= var6;
      if(var7 == PlotOrientation.HORIZONTAL) {
         var9 = var3 >= var2;
         var10 = var6 >= var5;
      }

      GeneralPath var12;
      float[] var13;
      if(var9) {
         if(var10) {
            GeneralPath var11 = new GeneralPath();
            if(var7 == PlotOrientation.HORIZONTAL) {
               var11.moveTo(var2, var1);
               var11.lineTo(var5, var4);
               var11.lineTo(var6, var4);
               var11.lineTo(var3, var1);
               var11.closePath();
            } else if(var7 == PlotOrientation.VERTICAL) {
               var11.moveTo(var1, var2);
               var11.lineTo(var4, var5);
               var11.lineTo(var4, var6);
               var11.lineTo(var1, var3);
               var11.closePath();
            }

            var8 = var11;
         } else {
            var13 = this.getIntersection(var1, var2, var4, var5, var1, var3, var4, var6);
            var12 = new GeneralPath();
            if(var7 == PlotOrientation.HORIZONTAL) {
               var12.moveTo(var2, var1);
               var12.lineTo(var13[1], var13[0]);
               var12.lineTo(var3, var1);
               var12.closePath();
            } else if(var7 == PlotOrientation.VERTICAL) {
               var12.moveTo(var1, var2);
               var12.lineTo(var13[0], var13[1]);
               var12.lineTo(var1, var3);
               var12.closePath();
            }

            var8 = var12;
         }
      } else if(var10) {
         var13 = this.getIntersection(var1, var2, var4, var5, var1, var3, var4, var6);
         var12 = new GeneralPath();
         if(var7 == PlotOrientation.HORIZONTAL) {
            var12.moveTo(var5, var4);
            var12.lineTo(var13[1], var13[0]);
            var12.lineTo(var6, var4);
            var12.closePath();
         } else if(var7 == PlotOrientation.VERTICAL) {
            var12.moveTo(var4, var5);
            var12.lineTo(var13[0], var13[1]);
            var12.lineTo(var4, var6);
            var12.closePath();
         }

         var8 = var12;
      }

      return var8;
   }

   private float[] getIntersection(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = (var7 - var5) * (var2 - var6) - (var8 - var6) * (var1 - var5);
      float var10 = (var8 - var6) * (var3 - var1) - (var7 - var5) * (var4 - var2);
      float var11 = var9 / var10;
      float[] var12 = new float[]{var1 + var11 * (var3 - var1), var2 + var11 * (var4 - var2)};
      return var12;
   }

   public LegendItem getLegendItem(int var1, int var2) {
      LegendItem var3 = null;
      XYPlot var4 = this.getPlot();
      if(var4 != null) {
         XYDataset var5 = var4.getDataset(var1);
         if(var5 != null && this.getItemVisible(var2, 0)) {
            String var6 = this.getLegendItemLabelGenerator().generateLabel(var5, var2);
            String var8 = null;
            if(this.getLegendItemToolTipGenerator() != null) {
               var8 = this.getLegendItemToolTipGenerator().generateLabel(var5, var2);
            }

            String var9 = null;
            if(this.getLegendItemURLGenerator() != null) {
               var9 = this.getLegendItemURLGenerator().generateLabel(var5, var2);
            }

            Paint var10 = this.getSeriesPaint(var2);
            Stroke var11 = this.getSeriesStroke(var2);
            Double var12 = new Double(-7.0D, 0.0D, 7.0D, 0.0D);
            var3 = new LegendItem(var6, var6, var8, var9, var12, var11, var10);
         }
      }

      return var3;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYDifferenceRenderer)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         XYDifferenceRenderer var2 = (XYDifferenceRenderer)var1;
         return !PaintUtilities.equal(this.positivePaint, var2.positivePaint)?false:(!PaintUtilities.equal(this.negativePaint, var2.negativePaint)?false:(this.shapesVisible != var2.shapesVisible?false:(!ShapeUtilities.equal(this.legendLine, var2.legendLine)?false:this.roundXCoordinates == var2.roundXCoordinates)));
      }
   }

   public Object clone() {
      XYDifferenceRenderer var1 = (XYDifferenceRenderer)super.clone();
      var1.legendLine = ShapeUtilities.clone(this.legendLine);
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.positivePaint, var1);
      SerialUtilities.writePaint(this.negativePaint, var1);
      SerialUtilities.writeShape(this.legendLine, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.positivePaint = SerialUtilities.readPaint(var1);
      this.negativePaint = SerialUtilities.readPaint(var1);
      this.legendLine = SerialUtilities.readShape(var1);
   }
}
