package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class XYBubbleRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   public static final long serialVersionUID = -5221991598674249125L;
   public static final int SCALE_ON_BOTH_AXES = 0;
   public static final int SCALE_ON_DOMAIN_AXIS = 1;
   public static final int SCALE_ON_RANGE_AXIS = 2;
   private int scaleType;

   public XYBubbleRenderer() {
      this(0);
   }

   public XYBubbleRenderer(int var1) {
      if(var1 >= 0 && var1 <= 2) {
         this.scaleType = var1;
      } else {
         throw new IllegalArgumentException("Invalid \'scaleType\'.");
      }
   }

   public int getScaleType() {
      return this.scaleType;
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      PlotOrientation var13 = var5.getOrientation();
      double var14 = var8.getXValue(var9, var10);
      double var16 = var8.getYValue(var9, var10);
      double var18 = Double.NaN;
      if(var8 instanceof XYZDataset) {
         XYZDataset var20 = (XYZDataset)var8;
         var18 = var20.getZValue(var9, var10);
      }

      if(!Double.isNaN(var18)) {
         RectangleEdge var42 = var5.getDomainAxisEdge();
         RectangleEdge var21 = var5.getRangeAxisEdge();
         double var22 = var6.valueToJava2D(var14, var3, var42);
         double var24 = var7.valueToJava2D(var16, var3, var21);
         double var26 = 0.0D;
         double var28 = 0.0D;
         double var30;
         switch(this.getScaleType()) {
         case 1:
            var30 = var6.valueToJava2D(0.0D, var3, var42);
            var26 = var6.valueToJava2D(var18, var3, var42) - var30;
            var28 = var26;
            break;
         case 2:
            var30 = var7.valueToJava2D(0.0D, var3, var21);
            var28 = var30 - var7.valueToJava2D(var18, var3, var21);
            var26 = var28;
            break;
         default:
            double var32 = var6.valueToJava2D(0.0D, var3, var42);
            double var34 = var7.valueToJava2D(0.0D, var3, var21);
            var26 = var6.valueToJava2D(var18, var3, var42) - var32;
            var28 = var34 - var7.valueToJava2D(var18, var3, var21);
         }

         var26 = Math.abs(var26);
         var28 = Math.abs(var28);
         java.awt.geom.Ellipse2D.Double var38 = null;
         if(var13 == PlotOrientation.VERTICAL) {
            var38 = new java.awt.geom.Ellipse2D.Double(var22 - var26 / 2.0D, var24 - var28 / 2.0D, var26, var28);
         } else if(var13 == PlotOrientation.HORIZONTAL) {
            var38 = new java.awt.geom.Ellipse2D.Double(var24 - var28 / 2.0D, var22 - var26 / 2.0D, var28, var26);
         }

         var1.setPaint(this.getItemPaint(var9, var10));
         var1.fill(var38);
         var1.setStroke(this.getItemOutlineStroke(var9, var10));
         var1.setPaint(this.getItemOutlinePaint(var9, var10));
         var1.draw(var38);
         if(this.isItemLabelVisible(var9, var10)) {
            if(var13 == PlotOrientation.VERTICAL) {
               this.drawItemLabel(var1, var13, var8, var9, var10, var22, var24, false);
            } else if(var13 == PlotOrientation.HORIZONTAL) {
               this.drawItemLabel(var1, var13, var8, var9, var10, var24, var22, false);
            }
         }

         EntityCollection var33 = null;
         if(var4 != null) {
            var33 = var4.getOwner().getEntityCollection();
         }

         if(var33 != null) {
            String var39 = null;
            XYToolTipGenerator var35 = this.getToolTipGenerator(var9, var10);
            if(var35 != null) {
               var39 = var35.generateToolTip(var8, var9, var10);
            }

            String var36 = null;
            if(this.getURLGenerator() != null) {
               var36 = this.getURLGenerator().generateURL(var8, var9, var10);
            }

            XYItemEntity var37 = new XYItemEntity(var38, var8, var9, var10, var39, var36);
            var33.add(var37);
         }

         int var40 = var5.getDomainAxisIndex(var6);
         int var41 = var5.getRangeAxisIndex(var7);
         this.updateCrosshairValues(var11, var14, var16, var40, var41, var22, var24, var13);
      }

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

            java.awt.geom.Ellipse2D.Double var10 = new java.awt.geom.Ellipse2D.Double(-4.0D, -4.0D, 8.0D, 8.0D);
            Paint var11 = this.getSeriesPaint(var2);
            Paint var12 = this.getSeriesOutlinePaint(var2);
            Stroke var13 = this.getSeriesOutlineStroke(var2);
            var3 = new LegendItem(var6, var6, var8, var9, var10, var11, var13, var12);
         }
      }

      return var3;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYBubbleRenderer)) {
         return false;
      } else {
         XYBubbleRenderer var2 = (XYBubbleRenderer)var1;
         return this.scaleType != var2.scaleType?false:super.equals(var1);
      }
   }

   public Object clone() {
      return super.clone();
   }
}
