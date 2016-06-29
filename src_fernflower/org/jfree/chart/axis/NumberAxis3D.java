package org.jfree.chart.axis;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import java.util.List;
import org.jfree.chart.Effect3D;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.ui.RectangleEdge;

public class NumberAxis3D extends NumberAxis implements Serializable {
   private static final long serialVersionUID = -1790205852569123512L;

   public NumberAxis3D() {
      this((String)null);
   }

   public NumberAxis3D(String var1) {
      super(var1);
      this.setAxisLineVisible(false);
   }

   public AxisState draw(Graphics2D var1, double var2, Rectangle2D var4, Rectangle2D var5, RectangleEdge var6, PlotRenderingInfo var7) {
      if(!this.isVisible()) {
         AxisState var23 = new AxisState(var2);
         List var9 = this.refreshTicks(var1, var23, var5, var6);
         var23.setTicks(var9);
         return var23;
      } else {
         double var8 = 0.0D;
         double var10 = 0.0D;
         Plot var12 = this.getPlot();
         if(var12 instanceof CategoryPlot) {
            CategoryPlot var13 = (CategoryPlot)var12;
            CategoryItemRenderer var14 = var13.getRenderer();
            if(var14 instanceof Effect3D) {
               Effect3D var15 = (Effect3D)var14;
               var8 = var15.getXOffset();
               var10 = var15.getYOffset();
            }
         }

         double var24 = var5.getMinX();
         double var25 = var5.getMinY();
         double var17 = var5.getWidth() - var8;
         double var19 = var5.getHeight() - var10;
         if(var6 != RectangleEdge.LEFT && var6 != RectangleEdge.BOTTOM) {
            if(var6 == RectangleEdge.RIGHT || var6 == RectangleEdge.TOP) {
               var24 += var8;
            }
         } else {
            var25 += var10;
         }

         Double var21 = new Double(var24, var25, var17, var19);
         AxisState var22 = this.drawTickMarksAndLabels(var1, var2, var4, var21, var6);
         var22 = this.drawLabel(this.getLabel(), var1, var4, var5, var6, var22);
         return var22;
      }
   }
}
