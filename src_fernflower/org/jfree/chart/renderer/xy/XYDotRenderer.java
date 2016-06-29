package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class XYDotRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   private static final long serialVersionUID = -2764344339073566425L;
   private int dotWidth = 1;
   private int dotHeight = 1;

   public int getDotWidth() {
      return this.dotWidth;
   }

   public void setDotWidth(int var1) {
      if(var1 < 1) {
         throw new IllegalArgumentException("Requires w > 0.");
      } else {
         this.dotWidth = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public int getDotHeight() {
      return this.dotHeight;
   }

   public void setDotHeight(int var1) {
      if(var1 < 1) {
         throw new IllegalArgumentException("Requires h > 0.");
      } else {
         this.dotHeight = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      double var13 = var8.getXValue(var9, var10);
      double var15 = var8.getYValue(var9, var10);
      double var17 = (double)(this.dotWidth - 1) / 2.0D;
      double var19 = (double)(this.dotHeight - 1) / 2.0D;
      if(!Double.isNaN(var15)) {
         RectangleEdge var21 = var5.getDomainAxisEdge();
         RectangleEdge var22 = var5.getRangeAxisEdge();
         double var23 = var6.valueToJava2D(var13, var3, var21) - var17;
         double var25 = var7.valueToJava2D(var15, var3, var22) - var19;
         var1.setPaint(this.getItemPaint(var9, var10));
         PlotOrientation var27 = var5.getOrientation();
         if(var27 == PlotOrientation.HORIZONTAL) {
            var1.fillRect((int)var25, (int)var23, this.dotHeight, this.dotWidth);
         } else if(var27 == PlotOrientation.VERTICAL) {
            var1.fillRect((int)var23, (int)var25, this.dotWidth, this.dotHeight);
         }

         int var28 = var5.getDomainAxisIndex(var6);
         int var29 = var5.getRangeAxisIndex(var7);
         this.updateCrosshairValues(var11, var13, var15, var28, var29, var23, var25, var27);
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYDotRenderer)) {
         return false;
      } else {
         XYDotRenderer var2 = (XYDotRenderer)var1;
         return this.dotWidth != var2.dotWidth?false:(this.dotHeight != var2.dotHeight?false:super.equals(var1));
      }
   }

   public Object clone() {
      return super.clone();
   }
}
