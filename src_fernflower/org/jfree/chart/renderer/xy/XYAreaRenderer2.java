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
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class XYAreaRenderer2 extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   private static final long serialVersionUID = -7378069681579984133L;
   private boolean showOutline;
   private transient Shape legendArea;

   public XYAreaRenderer2() {
      this((XYToolTipGenerator)null, (XYURLGenerator)null);
   }

   public XYAreaRenderer2(XYToolTipGenerator var1, XYURLGenerator var2) {
      this.showOutline = false;
      this.setBaseToolTipGenerator(var1);
      this.setURLGenerator(var2);
      GeneralPath var3 = new GeneralPath();
      var3.moveTo(0.0F, -4.0F);
      var3.lineTo(3.0F, -2.0F);
      var3.lineTo(4.0F, 4.0F);
      var3.lineTo(-4.0F, 4.0F);
      var3.lineTo(-3.0F, -2.0F);
      var3.closePath();
      this.legendArea = var3;
   }

   public boolean isOutline() {
      return this.showOutline;
   }

   public void setOutline(boolean var1) {
      this.showOutline = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getPlotLines() {
      return false;
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
         double var13 = var8.getXValue(var9, var10);
         double var15 = var8.getYValue(var9, var10);
         if(Double.isNaN(var15)) {
            var15 = 0.0D;
         }

         double var17 = var6.valueToJava2D(var13, var3, var5.getDomainAxisEdge());
         double var19 = var7.valueToJava2D(var15, var3, var5.getRangeAxisEdge());
         double var21 = var8.getXValue(var9, Math.max(var10 - 1, 0));
         double var23 = var8.getYValue(var9, Math.max(var10 - 1, 0));
         if(Double.isNaN(var23)) {
            var23 = 0.0D;
         }

         double var25 = var6.valueToJava2D(var21, var3, var5.getDomainAxisEdge());
         double var27 = var7.valueToJava2D(var23, var3, var5.getRangeAxisEdge());
         int var29 = var8.getItemCount(var9);
         double var30 = var8.getXValue(var9, Math.min(var10 + 1, var29 - 1));
         double var32 = var8.getYValue(var9, Math.min(var10 + 1, var29 - 1));
         if(Double.isNaN(var32)) {
            var32 = 0.0D;
         }

         double var34 = var6.valueToJava2D(var30, var3, var5.getDomainAxisEdge());
         double var36 = var7.valueToJava2D(var32, var3, var5.getRangeAxisEdge());
         double var38 = var7.valueToJava2D(0.0D, var3, var5.getRangeAxisEdge());
         Polygon var40 = null;
         if(var5.getOrientation() == PlotOrientation.HORIZONTAL) {
            var40 = new Polygon();
            var40.addPoint((int)var38, (int)((var25 + var17) / 2.0D));
            var40.addPoint((int)((var27 + var19) / 2.0D), (int)((var25 + var17) / 2.0D));
            var40.addPoint((int)var19, (int)var17);
            var40.addPoint((int)((var19 + var36) / 2.0D), (int)((var17 + var34) / 2.0D));
            var40.addPoint((int)var38, (int)((var17 + var34) / 2.0D));
         } else {
            var40 = new Polygon();
            var40.addPoint((int)((var25 + var17) / 2.0D), (int)var38);
            var40.addPoint((int)((var25 + var17) / 2.0D), (int)((var27 + var19) / 2.0D));
            var40.addPoint((int)var17, (int)var19);
            var40.addPoint((int)((var17 + var34) / 2.0D), (int)((var19 + var36) / 2.0D));
            var40.addPoint((int)((var17 + var34) / 2.0D), (int)var38);
         }

         PlotOrientation var41 = var5.getOrientation();
         Paint var42 = this.getItemPaint(var9, var10);
         Stroke var43 = this.getItemStroke(var9, var10);
         var1.setPaint(var42);
         var1.setStroke(var43);
         if(this.getPlotLines() && var10 > 0) {
            if(var5.getOrientation() == PlotOrientation.VERTICAL) {
               var2.workingLine.setLine(var25, var27, var17, var19);
            } else if(var5.getOrientation() == PlotOrientation.HORIZONTAL) {
               var2.workingLine.setLine(var27, var25, var19, var17);
            }

            var1.draw(var2.workingLine);
         }

         var1.fill(var40);
         if(this.isOutline()) {
            var1.setStroke(this.getSeriesOutlineStroke(var9));
            var1.setPaint(this.getSeriesOutlinePaint(var9));
            var1.draw(var40);
         }

         int var44 = var5.getDomainAxisIndex(var6);
         int var45 = var5.getRangeAxisIndex(var7);
         this.updateCrosshairValues(var11, var13, var15, var44, var45, var17, var19, var41);
         if(var2.getInfo() != null) {
            EntityCollection var46 = var2.getEntityCollection();
            if(var46 != null && var40 != null) {
               String var47 = null;
               XYToolTipGenerator var48 = this.getToolTipGenerator(var9, var10);
               if(var48 != null) {
                  var47 = var48.generateToolTip(var8, var9, var10);
               }

               String var49 = null;
               if(this.getURLGenerator() != null) {
                  var49 = this.getURLGenerator().generateURL(var8, var9, var10);
               }

               XYItemEntity var50 = new XYItemEntity(var40, var8, var9, var10, var47, var49);
               var46.add(var50);
            }
         }

      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYAreaRenderer2)) {
         return false;
      } else {
         XYAreaRenderer2 var2 = (XYAreaRenderer2)var1;
         return this.showOutline != var2.showOutline?false:(!ShapeUtilities.equal(this.legendArea, var2.legendArea)?false:super.equals(var1));
      }
   }

   public Object clone() {
      XYAreaRenderer2 var1 = (XYAreaRenderer2)super.clone();
      var1.legendArea = ShapeUtilities.clone(this.legendArea);
      return var1;
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
