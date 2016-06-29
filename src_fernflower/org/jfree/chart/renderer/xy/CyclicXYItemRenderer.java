package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.CyclicNumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CyclicXYItemRenderer$OverwriteDataSet;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;

public class CyclicXYItemRenderer extends StandardXYItemRenderer implements Serializable {
   private static final long serialVersionUID = 4035912243303764892L;

   public CyclicXYItemRenderer() {
   }

   public CyclicXYItemRenderer(int var1) {
      super(var1);
   }

   public CyclicXYItemRenderer(int var1, XYToolTipGenerator var2) {
      super(var1, var2);
   }

   public CyclicXYItemRenderer(int var1, XYToolTipGenerator var2, XYURLGenerator var3) {
      super(var1, var2, var3);
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      if(this.getPlotLines() && (var6 instanceof CyclicNumberAxis || var7 instanceof CyclicNumberAxis) && var10 > 0) {
         double var13 = var8.getXValue(var9, var10 - 1);
         double var15 = var8.getYValue(var9, var10 - 1);
         if(Double.isNaN(var15)) {
            super.drawItem(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
         } else {
            double[] var17 = new double[2];
            double[] var18 = new double[2];
            var17[0] = var13;
            var18[0] = var15;
            var13 = var8.getXValue(var9, var10);
            var15 = var8.getYValue(var9, var10);
            if(!Double.isNaN(var15)) {
               var17[1] = var13;
               var18[1] = var15;
               double var19 = Double.NaN;
               double var21 = Double.NaN;
               boolean var23 = false;
               boolean var24 = false;
               CyclicNumberAxis var25 = null;
               CyclicNumberAxis var26 = null;
               double[] var27;
               double[] var28;
               if(var6 instanceof CyclicNumberAxis) {
                  var25 = (CyclicNumberAxis)var6;
                  var19 = var25.getCycleBound();
                  var23 = var25.isBoundMappedToLastCycle();
                  if(var17[0] != var17[1] && (var19 >= var17[0] && var19 <= var17[1] || var19 >= var17[1] && var19 <= var17[0])) {
                     var27 = new double[3];
                     var28 = new double[3];
                     var27[0] = var17[0];
                     var27[2] = var17[1];
                     var28[0] = var18[0];
                     var28[2] = var18[1];
                     var27[1] = var19;
                     var28[1] = (var18[1] - var18[0]) * (var19 - var17[0]) / (var17[1] - var17[0]) + var18[0];
                     var17 = var27;
                     var18 = var28;
                  }
               }

               if(var7 instanceof CyclicNumberAxis) {
                  var26 = (CyclicNumberAxis)var7;
                  var21 = var26.getCycleBound();
                  var24 = var26.isBoundMappedToLastCycle();
                  if(var18[0] != var18[1] && (var21 >= var18[0] && var21 <= var18[1] || var21 >= var18[1] && var21 <= var18[0])) {
                     var27 = new double[var17.length + 1];
                     var28 = new double[var18.length + 1];
                     var27[0] = var17[0];
                     var27[2] = var17[1];
                     var28[0] = var18[0];
                     var28[2] = var18[1];
                     var28[1] = var21;
                     var27[1] = (var17[1] - var17[0]) * (var21 - var18[0]) / (var18[1] - var18[0]) + var17[0];
                     if(var17.length == 3) {
                        var27[3] = var17[2];
                        var28[3] = var18[2];
                     }

                     var17 = var27;
                     var18 = var28;
                  } else if(var17.length == 3 && var18[1] != var18[2] && (var21 >= var18[1] && var21 <= var18[2] || var21 >= var18[2] && var21 <= var18[1])) {
                     var27 = new double[4];
                     var28 = new double[4];
                     var27[0] = var17[0];
                     var27[1] = var17[1];
                     var27[3] = var17[2];
                     var28[0] = var18[0];
                     var28[1] = var18[1];
                     var28[3] = var18[2];
                     var28[2] = var21;
                     var27[2] = (var17[2] - var17[1]) * (var21 - var18[1]) / (var18[2] - var18[1]) + var17[1];
                     var17 = var27;
                     var18 = var28;
                  }
               }

               if(var17.length == 2) {
                  super.drawItem(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
               } else {
                  CyclicXYItemRenderer$OverwriteDataSet var29 = new CyclicXYItemRenderer$OverwriteDataSet(var17, var18, var8);
                  if(var25 != null) {
                     if(var19 == var17[0]) {
                        var25.setBoundMappedToLastCycle(var17[1] <= var19);
                     }

                     if(var19 == var17[1]) {
                        var25.setBoundMappedToLastCycle(var17[0] <= var19);
                     }
                  }

                  if(var26 != null) {
                     if(var21 == var18[0]) {
                        var26.setBoundMappedToLastCycle(var18[1] <= var21);
                     }

                     if(var21 == var18[1]) {
                        var26.setBoundMappedToLastCycle(var18[0] <= var21);
                     }
                  }

                  super.drawItem(var1, var2, var3, var4, var5, var6, var7, var29, var9, 1, var11, var12);
                  if(var25 != null) {
                     if(var19 == var17[1]) {
                        var25.setBoundMappedToLastCycle(var17[2] <= var19);
                     }

                     if(var19 == var17[2]) {
                        var25.setBoundMappedToLastCycle(var17[1] <= var19);
                     }
                  }

                  if(var26 != null) {
                     if(var21 == var18[1]) {
                        var26.setBoundMappedToLastCycle(var18[2] <= var21);
                     }

                     if(var21 == var18[2]) {
                        var26.setBoundMappedToLastCycle(var18[1] <= var21);
                     }
                  }

                  super.drawItem(var1, var2, var3, var4, var5, var6, var7, var29, var9, 2, var11, var12);
                  if(var17.length == 4) {
                     if(var25 != null) {
                        if(var19 == var17[2]) {
                           var25.setBoundMappedToLastCycle(var17[3] <= var19);
                        }

                        if(var19 == var17[3]) {
                           var25.setBoundMappedToLastCycle(var17[2] <= var19);
                        }
                     }

                     if(var26 != null) {
                        if(var21 == var18[2]) {
                           var26.setBoundMappedToLastCycle(var18[3] <= var21);
                        }

                        if(var21 == var18[3]) {
                           var26.setBoundMappedToLastCycle(var18[2] <= var21);
                        }
                     }

                     super.drawItem(var1, var2, var3, var4, var5, var6, var7, var29, var9, 3, var11, var12);
                  }

                  if(var25 != null) {
                     var25.setBoundMappedToLastCycle(var23);
                  }

                  if(var26 != null) {
                     var26.setBoundMappedToLastCycle(var24);
                  }

               }
            }
         }
      } else {
         super.drawItem(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
      }
   }
}
