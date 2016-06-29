package org.jfree.chart.axis;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import org.jfree.chart.Effect3D;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.ui.RectangleEdge;

public class CategoryAxis3D extends CategoryAxis implements Serializable, Cloneable {
   private static final long serialVersionUID = 4114732251353700972L;

   public CategoryAxis3D() {
      this((String)null);
   }

   public CategoryAxis3D(String var1) {
      super(var1);
   }

   public AxisState draw(Graphics2D var1, double var2, Rectangle2D var4, Rectangle2D var5, RectangleEdge var6, PlotRenderingInfo var7) {
      if(!this.isVisible()) {
         return new AxisState(var2);
      } else {
         CategoryPlot var8 = (CategoryPlot)this.getPlot();
         Double var9 = new Double();
         if(var8.getRenderer() instanceof Effect3D) {
            Effect3D var10 = (Effect3D)var8.getRenderer();
            double var11 = var5.getMinX();
            double var13 = var5.getMinY();
            double var15 = var5.getWidth() - var10.getXOffset();
            double var17 = var5.getHeight() - var10.getYOffset();
            if(var6 != RectangleEdge.LEFT && var6 != RectangleEdge.BOTTOM) {
               if(var6 == RectangleEdge.RIGHT || var6 == RectangleEdge.TOP) {
                  var11 += var10.getXOffset();
               }
            } else {
               var13 += var10.getYOffset();
            }

            var9.setRect(var11, var13, var15, var17);
         } else {
            var9.setRect(var5);
         }

         AxisState var19 = new AxisState(var2);
         var19 = this.drawCategoryLabels(var1, var4, var9, var6, var19, var7);
         var19 = this.drawLabel(this.getLabel(), var1, var4, var5, var6, var19);
         return var19;
      }
   }

   public double getCategoryJava2DCoordinate(CategoryAnchor var1, int var2, int var3, Rectangle2D var4, RectangleEdge var5) {
      double var6 = 0.0D;
      Object var8 = var4;
      CategoryPlot var9 = (CategoryPlot)this.getPlot();
      CategoryItemRenderer var10 = var9.getRenderer();
      if(var10 instanceof Effect3D) {
         Effect3D var11 = (Effect3D)var10;
         double var12 = var4.getMinX();
         double var14 = var4.getMinY();
         double var16 = var4.getWidth() - var11.getXOffset();
         double var18 = var4.getHeight() - var11.getYOffset();
         if(var5 != RectangleEdge.LEFT && var5 != RectangleEdge.BOTTOM) {
            if(var5 == RectangleEdge.RIGHT || var5 == RectangleEdge.TOP) {
               var12 += var11.getXOffset();
            }
         } else {
            var14 += var11.getYOffset();
         }

         var8 = new Double(var12, var14, var16, var18);
      }

      if(var1 == CategoryAnchor.START) {
         var6 = this.getCategoryStart(var2, var3, (Rectangle2D)var8, var5);
      } else if(var1 == CategoryAnchor.MIDDLE) {
         var6 = this.getCategoryMiddle(var2, var3, (Rectangle2D)var8, var5);
      } else if(var1 == CategoryAnchor.END) {
         var6 = this.getCategoryEnd(var2, var3, (Rectangle2D)var8, var5);
      }

      return var6;
   }

   public Object clone() {
      return super.clone();
   }
}
