package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class XYStepRenderer extends XYLineAndShapeRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   private static final long serialVersionUID = -8918141928884796108L;

   public XYStepRenderer() {
      this((XYToolTipGenerator)null, (XYURLGenerator)null);
   }

   public XYStepRenderer(XYToolTipGenerator var1, XYURLGenerator var2) {
      this.setBaseToolTipGenerator(var1);
      this.setURLGenerator(var2);
      this.setShapesVisible(false);
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      if(this.getItemVisible(var9, var10)) {
         PlotOrientation var13 = var5.getOrientation();
         Paint var14 = this.getItemPaint(var9, var10);
         Stroke var15 = this.getItemStroke(var9, var10);
         var1.setPaint(var14);
         var1.setStroke(var15);
         double var16 = var8.getXValue(var9, var10);
         double var18 = var8.getYValue(var9, var10);
         if(!Double.isNaN(var18)) {
            RectangleEdge var20 = var5.getDomainAxisEdge();
            RectangleEdge var21 = var5.getRangeAxisEdge();
            double var22 = var6.valueToJava2D(var16, var3, var20);
            double var24 = var7.valueToJava2D(var18, var3, var21);
            double var26;
            double var28;
            if(var10 > 0) {
               var26 = var8.getXValue(var9, var10 - 1);
               var28 = var8.getYValue(var9, var10 - 1);
               if(!Double.isNaN(var28)) {
                  double var30 = var6.valueToJava2D(var26, var3, var20);
                  double var32 = var7.valueToJava2D(var28, var3, var21);
                  Line2D var34 = var2.workingLine;
                  if(var13 == PlotOrientation.HORIZONTAL) {
                     if(var32 == var24) {
                        var34.setLine(var32, var30, var24, var22);
                        var1.draw(var34);
                     } else {
                        var34.setLine(var32, var30, var32, var22);
                        var1.draw(var34);
                        var34.setLine(var32, var22, var24, var22);
                        var1.draw(var34);
                     }
                  } else if(var13 == PlotOrientation.VERTICAL) {
                     if(var32 == var24) {
                        var34.setLine(var30, var32, var22, var24);
                        var1.draw(var34);
                     } else {
                        var34.setLine(var30, var32, var22, var32);
                        var1.draw(var34);
                        var34.setLine(var22, var32, var22, var24);
                        var1.draw(var34);
                     }
                  }
               }
            }

            if(this.isItemLabelVisible(var9, var10)) {
               var26 = var22;
               var28 = var24;
               if(var13 == PlotOrientation.HORIZONTAL) {
                  var26 = var24;
                  var28 = var22;
               }

               this.drawItemLabel(var1, var13, var8, var9, var10, var26, var28, var18 < 0.0D);
            }

            int var35 = var5.getDomainAxisIndex(var6);
            int var27 = var5.getRangeAxisIndex(var7);
            this.updateCrosshairValues(var11, var16, var18, var35, var27, var22, var24, var13);
            if(var2.getInfo() != null) {
               EntityCollection var36 = var2.getEntityCollection();
               if(var36 != null) {
                  int var29 = this.getDefaultEntityRadius();
                  java.awt.geom.Rectangle2D.Double var37 = var13 == PlotOrientation.VERTICAL?new java.awt.geom.Rectangle2D.Double(var22 - (double)var29, var24 - (double)var29, (double)(2 * var29), (double)(2 * var29)):new java.awt.geom.Rectangle2D.Double(var24 - (double)var29, var22 - (double)var29, (double)(2 * var29), (double)(2 * var29));
                  if(var37 != null) {
                     String var31 = null;
                     XYToolTipGenerator var38 = this.getToolTipGenerator(var9, var10);
                     if(var38 != null) {
                        var31 = var38.generateToolTip(var8, var9, var10);
                     }

                     String var33 = null;
                     if(this.getURLGenerator() != null) {
                        var33 = this.getURLGenerator().generateURL(var8, var9, var10);
                     }

                     XYItemEntity var39 = new XYItemEntity(var37, var8, var9, var10, var31, var33);
                     var36.add(var39);
                  }
               }
            }

         }
      }
   }

   public Object clone() {
      return super.clone();
   }
}
