package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer2;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class StackedXYAreaRenderer2 extends XYAreaRenderer2 implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = 7752676509764539182L;
   private boolean roundXCoordinates;

   public StackedXYAreaRenderer2() {
      this((XYToolTipGenerator)null, (XYURLGenerator)null);
   }

   public StackedXYAreaRenderer2(XYToolTipGenerator var1, XYURLGenerator var2) {
      super(var1, var2);
      this.roundXCoordinates = true;
   }

   public boolean getRoundXCoordinates() {
      return this.roundXCoordinates;
   }

   public void setRoundXCoordinates(boolean var1) {
      this.roundXCoordinates = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public Range findRangeBounds(XYDataset var1) {
      if(var1 == null) {
         return null;
      } else {
         double var2 = Double.POSITIVE_INFINITY;
         double var4 = Double.NEGATIVE_INFINITY;
         TableXYDataset var6 = (TableXYDataset)var1;
         int var7 = var6.getItemCount();

         for(int var8 = 0; var8 < var7; ++var8) {
            double[] var9 = this.getStackValues((TableXYDataset)var1, var6.getSeriesCount(), var8);
            var2 = Math.min(var2, var9[0]);
            var4 = Math.max(var4, var9[1]);
         }

         return var2 == Double.POSITIVE_INFINITY?null:new Range(var2, var4);
      }
   }

   public int getPassCount() {
      return 1;
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      Object var13 = null;
      EntityCollection var14 = null;
      if(var4 != null) {
         var14 = var4.getOwner().getEntityCollection();
      }

      TableXYDataset var15 = (TableXYDataset)var8;
      double var16 = var8.getXValue(var9, var10);
      double var18 = var8.getYValue(var9, var10);
      if(Double.isNaN(var18)) {
         var18 = 0.0D;
      }

      double[] var20 = this.getStackValues(var15, var9, var10);
      double var21 = var8.getXValue(var9, Math.max(var10 - 1, 0));
      double var23 = var8.getYValue(var9, Math.max(var10 - 1, 0));
      if(Double.isNaN(var23)) {
         var23 = 0.0D;
      }

      double[] var25 = this.getStackValues(var15, var9, Math.max(var10 - 1, 0));
      int var26 = var8.getItemCount(var9);
      double var27 = var8.getXValue(var9, Math.min(var10 + 1, var26 - 1));
      double var29 = var8.getYValue(var9, Math.min(var10 + 1, var26 - 1));
      if(Double.isNaN(var29)) {
         var29 = 0.0D;
      }

      double[] var31 = this.getStackValues(var15, var9, Math.min(var10 + 1, var26 - 1));
      double var32 = (var21 + var16) / 2.0D;
      double var34 = (var16 + var27) / 2.0D;
      double[] var36 = this.averageStackValues(var25, var20);
      double[] var37 = this.averageStackValues(var20, var31);
      double[] var38 = this.adjustedStackValues(var25, var20);
      double[] var39 = this.adjustedStackValues(var20, var31);
      RectangleEdge var40 = var5.getDomainAxisEdge();
      float var41 = (float)var6.valueToJava2D(var16, var3, var40);
      float var42 = (float)var6.valueToJava2D(var32, var3, var40);
      float var43 = (float)var6.valueToJava2D(var34, var3, var40);
      if(this.roundXCoordinates) {
         var41 = (float)Math.round(var41);
         var42 = (float)Math.round(var42);
         var43 = (float)Math.round(var43);
      }

      RectangleEdge var45 = var5.getRangeAxisEdge();
      GeneralPath var46 = new GeneralPath();
      GeneralPath var47 = new GeneralPath();
      float var44;
      float var48;
      float var49;
      double var50;
      double var51;
      float var52;
      float var53;
      float var56;
      if(var18 >= 0.0D) {
         var44 = (float)var7.valueToJava2D(var18 + var20[1], var3, var45);
         var48 = (float)var7.valueToJava2D(var20[1], var3, var45);
         var49 = (float)var7.valueToJava2D(var38[1], var3, var45);
         if(var23 >= 0.0D) {
            var50 = (var23 + var18) / 2.0D + var36[1];
            var52 = (float)var7.valueToJava2D(var50, var3, var45);
            var46.moveTo(var41, var44);
            var46.lineTo(var41, var48);
            var46.lineTo(var42, var49);
            var46.lineTo(var42, var52);
            var46.closePath();
         } else {
            var46.moveTo(var41, var48);
            var46.lineTo(var41, var44);
            var46.lineTo(var42, var49);
            var46.closePath();
         }

         var56 = (float)var7.valueToJava2D(var39[1], var3, var45);
         if(var29 >= 0.0D) {
            var51 = (var18 + var29) / 2.0D + var37[1];
            var53 = (float)var7.valueToJava2D(var51, var3, var45);
            var47.moveTo(var41, var48);
            var47.lineTo(var41, var44);
            var47.lineTo(var43, var53);
            var47.lineTo(var43, var56);
            var47.closePath();
         } else {
            var47.moveTo(var41, var48);
            var47.lineTo(var41, var44);
            var47.lineTo(var43, var56);
            var47.closePath();
         }
      } else {
         var44 = (float)var7.valueToJava2D(var18 + var20[0], var3, var45);
         var48 = (float)var7.valueToJava2D(var20[0], var3, var45);
         var49 = (float)var7.valueToJava2D(var38[0], var3, var45);
         if(var23 >= 0.0D) {
            var46.moveTo(var41, var48);
            var46.lineTo(var41, var44);
            var46.lineTo(var42, var49);
            var46.clone();
         } else {
            var50 = (var23 + var18) / 2.0D + var36[0];
            var52 = (float)var7.valueToJava2D(var50, var3, var45);
            var46.moveTo(var41, var44);
            var46.lineTo(var41, var48);
            var46.lineTo(var42, var49);
            var46.lineTo(var42, var52);
            var46.closePath();
         }

         var56 = (float)var7.valueToJava2D(var39[0], var3, var45);
         if(var29 >= 0.0D) {
            var47.moveTo(var41, var48);
            var47.lineTo(var41, var44);
            var47.lineTo(var43, var56);
            var47.closePath();
         } else {
            var51 = (var18 + var29) / 2.0D + var37[0];
            var53 = (float)var7.valueToJava2D(var51, var3, var45);
            var47.moveTo(var41, var48);
            var47.lineTo(var41, var44);
            var47.lineTo(var43, var53);
            var47.lineTo(var43, var56);
            var47.closePath();
         }
      }

      Paint var54 = this.getItemPaint(var9, var10);
      if(var12 == 0) {
         var1.setPaint(var54);
         var1.fill(var46);
         var1.fill(var47);
      }

      if(var14 != null) {
         GeneralPath var55 = new GeneralPath(var46);
         var55.append(var47, false);
         this.addEntity(var14, var55, var8, var9, var10, (double)var41, (double)var44);
      }

   }

   private double[] getStackValues(TableXYDataset var1, int var2, int var3) {
      double[] var4 = new double[2];

      for(int var5 = 0; var5 < var2; ++var5) {
         double var6 = var1.getYValue(var5, var3);
         if(!Double.isNaN(var6)) {
            if(var6 >= 0.0D) {
               var4[1] += var6;
            } else {
               var4[0] += var6;
            }
         }
      }

      return var4;
   }

   private double[] averageStackValues(double[] var1, double[] var2) {
      double[] var3 = new double[]{(var1[0] + var2[0]) / 2.0D, (var1[1] + var2[1]) / 2.0D};
      return var3;
   }

   private double[] adjustedStackValues(double[] var1, double[] var2) {
      double[] var3 = new double[2];
      if(var1[0] != 0.0D && var2[0] != 0.0D) {
         var3[0] = (var1[0] + var2[0]) / 2.0D;
      } else {
         var3[0] = 0.0D;
      }

      if(var1[1] != 0.0D && var2[1] != 0.0D) {
         var3[1] = (var1[1] + var2[1]) / 2.0D;
      } else {
         var3[1] = 0.0D;
      }

      return var3;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StackedXYAreaRenderer2)) {
         return false;
      } else {
         StackedXYAreaRenderer2 var2 = (StackedXYAreaRenderer2)var1;
         return this.roundXCoordinates != var2.roundXCoordinates?false:super.equals(var1);
      }
   }

   public Object clone() {
      return super.clone();
   }
}
