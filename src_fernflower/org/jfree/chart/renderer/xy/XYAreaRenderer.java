package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYAreaRenderer$XYAreaRendererState;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class XYAreaRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   private static final long serialVersionUID = -4481971353973876747L;
   public static final int SHAPES = 1;
   public static final int LINES = 2;
   public static final int SHAPES_AND_LINES = 3;
   public static final int AREA = 4;
   public static final int AREA_AND_SHAPES = 5;
   private boolean plotShapes;
   private boolean plotLines;
   private boolean plotArea;
   private boolean showOutline;
   private transient Shape legendArea;

   public XYAreaRenderer() {
      this(4);
   }

   public XYAreaRenderer(int var1) {
      this(var1, (XYToolTipGenerator)null, (XYURLGenerator)null);
   }

   public XYAreaRenderer(int var1, XYToolTipGenerator var2, XYURLGenerator var3) {
      this.setBaseToolTipGenerator(var2);
      this.setURLGenerator(var3);
      if(var1 == 1) {
         this.plotShapes = true;
      }

      if(var1 == 2) {
         this.plotLines = true;
      }

      if(var1 == 3) {
         this.plotShapes = true;
         this.plotLines = true;
      }

      if(var1 == 4) {
         this.plotArea = true;
      }

      if(var1 == 5) {
         this.plotArea = true;
         this.plotShapes = true;
      }

      this.showOutline = false;
      GeneralPath var4 = new GeneralPath();
      var4.moveTo(0.0F, -4.0F);
      var4.lineTo(3.0F, -2.0F);
      var4.lineTo(4.0F, 4.0F);
      var4.lineTo(-4.0F, 4.0F);
      var4.lineTo(-3.0F, -2.0F);
      var4.closePath();
      this.legendArea = var4;
   }

   public boolean getPlotShapes() {
      return this.plotShapes;
   }

   public boolean getPlotLines() {
      return this.plotLines;
   }

   public boolean getPlotArea() {
      return this.plotArea;
   }

   public boolean isOutline() {
      return this.showOutline;
   }

   public void setOutline(boolean var1) {
      this.showOutline = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public Shape getLegendArea() {
      return this.legendArea;
   }

   public void setLegendArea(Shape var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'area\' argument.");
      } else {
         this.legendArea = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public XYItemRendererState initialise(Graphics2D var1, Rectangle2D var2, XYPlot var3, XYDataset var4, PlotRenderingInfo var5) {
      XYAreaRenderer$XYAreaRendererState var6 = new XYAreaRenderer$XYAreaRendererState(var5);
      return var6;
   }

   public LegendItem getLegendItem(int var1, int var2) {
      LegendItem var3 = null;
      XYPlot var4 = this.getPlot();
      if(var4 != null) {
         XYDataset var5 = var4.getDataset(var1);
         if(var5 != null) {
            XYSeriesLabelGenerator var6 = this.getLegendItemLabelGenerator();
            String var7 = var6.generateLabel(var5, var2);
            String var9 = null;
            if(this.getLegendItemToolTipGenerator() != null) {
               var9 = this.getLegendItemToolTipGenerator().generateLabel(var5, var2);
            }

            String var10 = null;
            if(this.getLegendItemURLGenerator() != null) {
               var10 = this.getLegendItemURLGenerator().generateLabel(var5, var2);
            }

            Paint var11 = this.getSeriesPaint(var2);
            var3 = new LegendItem(var7, var7, var9, var10, this.legendArea, var11);
         }
      }

      return var3;
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      if(this.getItemVisible(var9, var10)) {
         XYAreaRenderer$XYAreaRendererState var13 = (XYAreaRenderer$XYAreaRendererState)var2;
         double var14 = var8.getXValue(var9, var10);
         double var16 = var8.getYValue(var9, var10);
         if(Double.isNaN(var16)) {
            var16 = 0.0D;
         }

         double var18 = var6.valueToJava2D(var14, var3, var5.getDomainAxisEdge());
         double var20 = var7.valueToJava2D(var16, var3, var5.getRangeAxisEdge());
         int var22 = var8.getItemCount(var9);
         double var23 = var8.getXValue(var9, Math.max(var10 - 1, 0));
         double var25 = var8.getYValue(var9, Math.max(var10 - 1, 0));
         if(Double.isNaN(var25)) {
            var25 = 0.0D;
         }

         double var27 = var6.valueToJava2D(var23, var3, var5.getDomainAxisEdge());
         double var29 = var7.valueToJava2D(var25, var3, var5.getRangeAxisEdge());
         double var31 = var8.getXValue(var9, Math.min(var10 + 1, var22 - 1));
         double var33 = var8.getYValue(var9, Math.min(var10 + 1, var22 - 1));
         if(Double.isNaN(var33)) {
            var33 = 0.0D;
         }

         double var35 = var6.valueToJava2D(var31, var3, var5.getDomainAxisEdge());
         double var37 = var7.valueToJava2D(var33, var3, var5.getRangeAxisEdge());
         double var39 = var7.valueToJava2D(0.0D, var3, var5.getRangeAxisEdge());
         Polygon var41 = null;
         if(var5.getOrientation() == PlotOrientation.HORIZONTAL) {
            var41 = new Polygon();
            var41.addPoint((int)var39, (int)((var27 + var18) / 2.0D));
            var41.addPoint((int)((var29 + var20) / 2.0D), (int)((var27 + var18) / 2.0D));
            var41.addPoint((int)var20, (int)var18);
            var41.addPoint((int)((var20 + var37) / 2.0D), (int)((var18 + var35) / 2.0D));
            var41.addPoint((int)var39, (int)((var18 + var35) / 2.0D));
         } else {
            var41 = new Polygon();
            var41.addPoint((int)((var27 + var18) / 2.0D), (int)var39);
            var41.addPoint((int)((var27 + var18) / 2.0D), (int)((var29 + var20) / 2.0D));
            var41.addPoint((int)var18, (int)var20);
            var41.addPoint((int)((var18 + var35) / 2.0D), (int)((var20 + var37) / 2.0D));
            var41.addPoint((int)((var18 + var35) / 2.0D), (int)var39);
         }

         if(var10 == 0) {
            var13.area = new Polygon();
            double var42 = var7.valueToJava2D(0.0D, var3, var5.getRangeAxisEdge());
            if(var5.getOrientation() == PlotOrientation.VERTICAL) {
               var13.area.addPoint((int)var18, (int)var42);
            } else if(var5.getOrientation() == PlotOrientation.HORIZONTAL) {
               var13.area.addPoint((int)var42, (int)var18);
            }
         }

         if(var5.getOrientation() == PlotOrientation.VERTICAL) {
            var13.area.addPoint((int)var18, (int)var20);
         } else if(var5.getOrientation() == PlotOrientation.HORIZONTAL) {
            var13.area.addPoint((int)var20, (int)var18);
         }

         PlotOrientation var53 = var5.getOrientation();
         Paint var43 = this.getItemPaint(var9, var10);
         Stroke var44 = this.getItemStroke(var9, var10);
         var1.setPaint(var43);
         var1.setStroke(var44);
         Shape var45 = null;
         if(this.getPlotShapes()) {
            var45 = this.getItemShape(var9, var10);
            if(var53 == PlotOrientation.VERTICAL) {
               var45 = ShapeUtilities.createTranslatedShape(var45, var18, var20);
            } else if(var53 == PlotOrientation.HORIZONTAL) {
               var45 = ShapeUtilities.createTranslatedShape(var45, var20, var18);
            }

            var1.draw(var45);
         }

         if(this.getPlotLines() && var10 > 0) {
            if(var5.getOrientation() == PlotOrientation.VERTICAL) {
               var13.line.setLine(var27, var29, var18, var20);
            } else if(var5.getOrientation() == PlotOrientation.HORIZONTAL) {
               var13.line.setLine(var29, var27, var20, var18);
            }

            var1.draw(var13.line);
         }

         if(this.getPlotArea() && var10 > 0 && var10 == var22 - 1) {
            if(var53 == PlotOrientation.VERTICAL) {
               var13.area.addPoint((int)var18, (int)var39);
            } else if(var53 == PlotOrientation.HORIZONTAL) {
               var13.area.addPoint((int)var39, (int)var18);
            }

            var1.fill(var13.area);
            if(this.isOutline()) {
               var1.setStroke(this.getItemOutlineStroke(var9, var10));
               var1.setPaint(this.getItemOutlinePaint(var9, var10));
               var1.draw(var13.area);
            }
         }

         int var46 = var5.getDomainAxisIndex(var6);
         int var47 = var5.getRangeAxisIndex(var7);
         this.updateCrosshairValues(var11, var14, var16, var46, var47, var18, var20, var53);
         if(var2.getInfo() != null) {
            EntityCollection var48 = var2.getEntityCollection();
            if(var48 != null && var41 != null) {
               String var49 = null;
               XYToolTipGenerator var50 = this.getToolTipGenerator(var9, var10);
               if(var50 != null) {
                  var49 = var50.generateToolTip(var8, var9, var10);
               }

               String var51 = null;
               if(this.getURLGenerator() != null) {
                  var51 = this.getURLGenerator().generateURL(var8, var9, var10);
               }

               XYItemEntity var52 = new XYItemEntity(var41, var8, var9, var10, var49, var51);
               var48.add(var52);
            }
         }

      }
   }

   public Object clone() {
      XYAreaRenderer var1 = (XYAreaRenderer)super.clone();
      var1.legendArea = ShapeUtilities.clone(this.legendArea);
      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYAreaRenderer)) {
         return false;
      } else {
         XYAreaRenderer var2 = (XYAreaRenderer)var1;
         return this.plotArea != var2.plotArea?false:(this.plotLines != var2.plotLines?false:(this.plotShapes != var2.plotShapes?false:(this.showOutline != var2.showOutline?false:ShapeUtilities.equal(this.legendArea, var2.legendArea))));
      }
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.legendArea = SerialUtilities.readShape(var1);
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeShape(this.legendArea, var1);
   }
}
