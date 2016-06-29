package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
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
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class XYStepAreaRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   private static final long serialVersionUID = -7311560779702649635L;
   public static final int SHAPES = 1;
   public static final int AREA = 2;
   public static final int AREA_AND_SHAPES = 3;
   private boolean shapesVisible;
   private boolean shapesFilled;
   private boolean plotArea;
   private boolean showOutline;
   protected transient Polygon pArea;
   private double rangeBase;

   public XYStepAreaRenderer() {
      this(2);
   }

   public XYStepAreaRenderer(int var1) {
      this(var1, (XYToolTipGenerator)null, (XYURLGenerator)null);
   }

   public XYStepAreaRenderer(int var1, XYToolTipGenerator var2, XYURLGenerator var3) {
      this.pArea = null;
      this.setBaseToolTipGenerator(var2);
      this.setURLGenerator(var3);
      if(var1 == 2) {
         this.plotArea = true;
      } else if(var1 == 1) {
         this.shapesVisible = true;
      } else if(var1 == 3) {
         this.plotArea = true;
         this.shapesVisible = true;
      }

      this.showOutline = false;
   }

   public boolean isOutline() {
      return this.showOutline;
   }

   public void setOutline(boolean var1) {
      this.showOutline = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getShapesVisible() {
      return this.shapesVisible;
   }

   public void setShapesVisible(boolean var1) {
      this.shapesVisible = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean isShapesFilled() {
      return this.shapesFilled;
   }

   public void setShapesFilled(boolean var1) {
      this.shapesFilled = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getPlotArea() {
      return this.plotArea;
   }

   public void setPlotArea(boolean var1) {
      this.plotArea = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public double getRangeBase() {
      return this.rangeBase;
   }

   public void setRangeBase(double var1) {
      this.rangeBase = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public XYItemRendererState initialise(Graphics2D var1, Rectangle2D var2, XYPlot var3, XYDataset var4, PlotRenderingInfo var5) {
      return super.initialise(var1, var2, var3, var4, var5);
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      PlotOrientation var13 = var5.getOrientation();
      int var14 = var8.getItemCount(var9);
      Paint var15 = this.getItemPaint(var9, var10);
      Stroke var16 = this.getItemStroke(var9, var10);
      var1.setPaint(var15);
      var1.setStroke(var16);
      double var17 = var8.getXValue(var9, var10);
      double var19 = var8.getYValue(var9, var10);
      double var23 = Double.isNaN(var19)?this.getRangeBase():var19;
      double var25 = var6.valueToJava2D(var17, var3, var5.getDomainAxisEdge());
      double var27 = var7.valueToJava2D(var23, var3, var5.getRangeAxisEdge());
      var27 = restrictValueToDataArea(var27, var5, var3);
      double var29;
      if(this.pArea == null && !Double.isNaN(var19)) {
         this.pArea = new Polygon();
         var29 = var7.valueToJava2D(this.getRangeBase(), var3, var5.getRangeAxisEdge());
         var29 = restrictValueToDataArea(var29, var5, var3);
         if(var13 == PlotOrientation.VERTICAL) {
            this.pArea.addPoint((int)var25, (int)var29);
         } else if(var13 == PlotOrientation.HORIZONTAL) {
            this.pArea.addPoint((int)var29, (int)var25);
         }
      }

      var29 = 0.0D;
      restrictValueToDataArea(this.getRangeBase(), var5, var3);
      if(var10 > 0) {
         double var33 = var8.getXValue(var9, var10 - 1);
         double var35 = Double.isNaN(var19)?var19:var8.getYValue(var9, var10 - 1);
         var23 = Double.isNaN(var35)?this.getRangeBase():var35;
         var29 = var6.valueToJava2D(var33, var3, var5.getDomainAxisEdge());
         double var31 = var7.valueToJava2D(var23, var3, var5.getRangeAxisEdge());
         var31 = restrictValueToDataArea(var31, var5, var3);
         if(Double.isNaN(var19)) {
            var25 = var29;
            var31 = var27;
         }

         if(var31 != var27) {
            if(var13 == PlotOrientation.VERTICAL) {
               this.pArea.addPoint((int)var25, (int)var31);
            } else if(var13 == PlotOrientation.HORIZONTAL) {
               this.pArea.addPoint((int)var31, (int)var25);
            }
         }
      }

      Object var37 = null;
      if(!Double.isNaN(var19)) {
         if(var13 == PlotOrientation.VERTICAL) {
            this.pArea.addPoint((int)var25, (int)var27);
         } else if(var13 == PlotOrientation.HORIZONTAL) {
            this.pArea.addPoint((int)var27, (int)var25);
         }

         if(this.getShapesVisible()) {
            var37 = this.getItemShape(var9, var10);
            if(var13 == PlotOrientation.VERTICAL) {
               var37 = ShapeUtilities.createTranslatedShape((Shape)var37, var25, var27);
            } else if(var13 == PlotOrientation.HORIZONTAL) {
               var37 = ShapeUtilities.createTranslatedShape((Shape)var37, var27, var25);
            }

            if(this.isShapesFilled()) {
               var1.fill((Shape)var37);
            } else {
               var1.draw((Shape)var37);
            }
         } else if(var13 == PlotOrientation.VERTICAL) {
            var37 = new java.awt.geom.Rectangle2D.Double(var25 - 2.0D, var27 - 2.0D, 4.0D, 4.0D);
         } else if(var13 == PlotOrientation.HORIZONTAL) {
            var37 = new java.awt.geom.Rectangle2D.Double(var27 - 2.0D, var25 - 2.0D, 4.0D, 4.0D);
         }
      }

      if(this.getPlotArea() && var10 > 0 && this.pArea != null && (var10 == var14 - 1 || Double.isNaN(var19))) {
         double var38 = var7.valueToJava2D(this.getRangeBase(), var3, var5.getRangeAxisEdge());
         var38 = restrictValueToDataArea(var38, var5, var3);
         if(var13 == PlotOrientation.VERTICAL) {
            this.pArea.addPoint((int)var25, (int)var38);
         } else if(var13 == PlotOrientation.HORIZONTAL) {
            this.pArea.addPoint((int)var38, (int)var25);
         }

         var1.fill(this.pArea);
         if(this.isOutline()) {
            var1.setStroke(var5.getOutlineStroke());
            var1.setPaint(var5.getOutlinePaint());
            var1.draw(this.pArea);
         }

         this.pArea = null;
      }

      if(!Double.isNaN(var19)) {
         int var43 = var5.getDomainAxisIndex(var6);
         int var39 = var5.getRangeAxisIndex(var7);
         this.updateCrosshairValues(var11, var17, var19, var43, var39, var25, var27, var13);
      }

      if(var2.getInfo() != null) {
         EntityCollection var44 = var2.getEntityCollection();
         if(var44 != null && var37 != null) {
            String var45 = null;
            XYToolTipGenerator var40 = this.getToolTipGenerator(var9, var10);
            if(var40 != null) {
               var45 = var40.generateToolTip(var8, var9, var10);
            }

            String var41 = null;
            if(this.getURLGenerator() != null) {
               var41 = this.getURLGenerator().generateURL(var8, var9, var10);
            }

            XYItemEntity var42 = new XYItemEntity((Shape)var37, var8, var9, var10, var45, var41);
            var44.add(var42);
         }
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYStepAreaRenderer)) {
         return false;
      } else {
         XYStepAreaRenderer var2 = (XYStepAreaRenderer)var1;
         return this.showOutline != var2.showOutline?false:(this.shapesVisible != var2.shapesVisible?false:(this.shapesFilled != var2.shapesFilled?false:(this.plotArea != var2.plotArea?false:(this.rangeBase != var2.rangeBase?false:super.equals(var1)))));
      }
   }

   public Object clone() {
      return super.clone();
   }

   protected static double restrictValueToDataArea(double var0, XYPlot var2, Rectangle2D var3) {
      double var4 = 0.0D;
      double var6 = 0.0D;
      if(var2.getOrientation() == PlotOrientation.VERTICAL) {
         var4 = var3.getMinY();
         var6 = var3.getMaxY();
      } else if(var2.getOrientation() == PlotOrientation.HORIZONTAL) {
         var4 = var3.getMinX();
         var6 = var3.getMaxX();
      }

      if(var0 < var4) {
         var0 = var4;
      } else if(var0 > var6) {
         var0 = var6;
      }

      return var0;
   }
}
