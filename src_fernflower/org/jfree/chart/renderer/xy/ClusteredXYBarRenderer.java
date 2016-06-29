package org.jfree.chart.renderer.xy;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class ClusteredXYBarRenderer extends XYBarRenderer implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = 5864462149177133147L;
   private boolean centerBarAtStartValue;

   public ClusteredXYBarRenderer() {
      this(0.0D, false);
   }

   public ClusteredXYBarRenderer(double var1, boolean var3) {
      super(var1);
      this.centerBarAtStartValue = var3;
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      IntervalXYDataset var13 = (IntervalXYDataset)var8;
      double var14;
      double var16;
      if(this.getUseYInterval()) {
         var14 = var13.getStartYValue(var9, var10);
         var16 = var13.getEndYValue(var9, var10);
      } else {
         var14 = this.getBase();
         var16 = var13.getYValue(var9, var10);
      }

      if(!Double.isNaN(var14) && !Double.isNaN(var16)) {
         double var18 = var7.valueToJava2D(var14, var3, var5.getRangeAxisEdge());
         double var20 = var7.valueToJava2D(var16, var3, var5.getRangeAxisEdge());
         RectangleEdge var22 = var5.getDomainAxisEdge();
         double var23 = var13.getStartXValue(var9, var10);
         double var25 = var6.valueToJava2D(var23, var3, var22);
         double var27 = var13.getEndXValue(var9, var10);
         double var29 = var6.valueToJava2D(var27, var3, var22);
         double var31 = Math.max(1.0D, Math.abs(var29 - var25));
         double var33 = Math.abs(var18 - var20);
         if(this.centerBarAtStartValue) {
            var25 -= var31 / 2.0D;
         }

         PlotOrientation var35 = var5.getOrientation();
         double var36 = this.getMargin();
         if(var36 > 0.0D) {
            double var38 = var31 * this.getMargin();
            var31 -= var38;
            if(var35 == PlotOrientation.HORIZONTAL) {
               var25 -= var38 / 2.0D;
            } else {
               var25 += var38 / 2.0D;
            }
         }

         int var50 = var8.getSeriesCount();
         double var39 = var31 / (double)var50;
         java.awt.geom.Rectangle2D.Double var41 = null;
         if(var35 == PlotOrientation.HORIZONTAL) {
            var41 = new java.awt.geom.Rectangle2D.Double(Math.min(var18, var20), var25 - var39 * (double)(var50 - var9), var33, var39);
         } else if(var35 == PlotOrientation.VERTICAL) {
            var41 = new java.awt.geom.Rectangle2D.Double(var25 + var39 * (double)var9, Math.min(var18, var20), var39, var33);
         }

         Object var42 = this.getItemPaint(var9, var10);
         if(this.getGradientPaintTransformer() != null && var42 instanceof GradientPaint) {
            GradientPaint var43 = (GradientPaint)var42;
            var42 = this.getGradientPaintTransformer().transform(var43, var41);
         }

         var1.setPaint((Paint)var42);
         var1.fill(var41);
         if(this.isDrawBarOutline() && Math.abs(var29 - var25) > 3.0D) {
            var1.setStroke(this.getItemOutlineStroke(var9, var10));
            var1.setPaint(this.getItemOutlinePaint(var9, var10));
            var1.draw(var41);
         }

         if(this.isItemLabelVisible(var9, var10)) {
            XYItemLabelGenerator var48 = this.getItemLabelGenerator(var9, var10);
            this.drawItemLabel(var1, var8, var9, var10, var5, var48, var41, var16 < 0.0D);
         }

         if(var4 != null) {
            EntityCollection var49 = var4.getOwner().getEntityCollection();
            if(var49 != null) {
               String var44 = null;
               XYToolTipGenerator var45 = this.getToolTipGenerator(var9, var10);
               if(var45 != null) {
                  var44 = var45.generateToolTip(var8, var9, var10);
               }

               String var46 = null;
               if(this.getURLGenerator() != null) {
                  var46 = this.getURLGenerator().generateURL(var8, var9, var10);
               }

               XYItemEntity var47 = new XYItemEntity(var41, var8, var9, var10, var44, var46);
               var49.add(var47);
            }
         }

      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ClusteredXYBarRenderer)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         ClusteredXYBarRenderer var2 = (ClusteredXYBarRenderer)var1;
         return this.centerBarAtStartValue == var2.centerBarAtStartValue;
      }
   }

   public Object clone() {
      return super.clone();
   }
}
