package org.jfree.chart.renderer.xy;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DeviationRenderer$State;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;

public class DeviationRenderer extends XYLineAndShapeRenderer {
   private float alpha;

   public DeviationRenderer() {
      this(true, true);
   }

   public DeviationRenderer(boolean var1, boolean var2) {
      super(var1, var2);
      super.setDrawSeriesLineAsPath(true);
      this.alpha = 0.5F;
   }

   public float getAlpha() {
      return this.alpha;
   }

   public void setAlpha(float var1) {
      if(var1 >= 0.0F && var1 <= 1.0F) {
         this.alpha = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      } else {
         throw new IllegalArgumentException("Requires \'alpha\' in the range 0.0 to 1.0.");
      }
   }

   public void setDrawSeriesLineAsPath(boolean var1) {
   }

   public XYItemRendererState initialise(Graphics2D var1, Rectangle2D var2, XYPlot var3, XYDataset var4, PlotRenderingInfo var5) {
      DeviationRenderer$State var6 = new DeviationRenderer$State(var5);
      var6.seriesPath = new GeneralPath();
      return var6;
   }

   public int getPassCount() {
      return 3;
   }

   protected boolean isItemPass(int var1) {
      return var1 == 2;
   }

   protected boolean isLinePass(int var1) {
      return var1 == 1;
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      if(this.getItemVisible(var9, var10)) {
         if(var12 == 0) {
            IntervalXYDataset var13 = (IntervalXYDataset)var8;
            DeviationRenderer$State var14 = (DeviationRenderer$State)var2;
            double var15 = var13.getXValue(var9, var10);
            double var17 = var13.getStartYValue(var9, var10);
            double var19 = var13.getEndYValue(var9, var10);
            RectangleEdge var21 = var5.getDomainAxisEdge();
            RectangleEdge var22 = var5.getRangeAxisEdge();
            double var23 = var6.valueToJava2D(var15, var3, var21);
            double var25 = var7.valueToJava2D(var17, var3, var22);
            double var27 = var7.valueToJava2D(var19, var3, var22);
            PlotOrientation var29 = var5.getOrientation();
            if(var29 == PlotOrientation.HORIZONTAL) {
               var14.lowerCoordinates.add(new double[]{var25, var23});
               var14.upperCoordinates.add(new double[]{var27, var23});
            } else if(var29 == PlotOrientation.VERTICAL) {
               var14.lowerCoordinates.add(new double[]{var23, var25});
               var14.upperCoordinates.add(new double[]{var23, var27});
            }

            if(var10 == var8.getItemCount(var9) - 1) {
               Composite var30 = var1.getComposite();
               var1.setComposite(AlphaComposite.getInstance(3, this.alpha));
               var1.setPaint(this.getItemFillPaint(var9, var10));
               GeneralPath var31 = new GeneralPath();
               double[] var32 = (double[])((double[])var14.lowerCoordinates.get(0));
               var31.moveTo((float)var32[0], (float)var32[1]);

               int var33;
               for(var33 = 1; var33 < var14.lowerCoordinates.size(); ++var33) {
                  var32 = (double[])((double[])var14.lowerCoordinates.get(var33));
                  var31.lineTo((float)var32[0], (float)var32[1]);
               }

               var33 = var14.upperCoordinates.size();
               var32 = (double[])((double[])var14.upperCoordinates.get(var33 - 1));
               var31.lineTo((float)var32[0], (float)var32[1]);

               for(int var34 = var33 - 2; var34 >= 0; --var34) {
                  var32 = (double[])((double[])var14.upperCoordinates.get(var34));
                  var31.lineTo((float)var32[0], (float)var32[1]);
               }

               var31.closePath();
               var1.fill(var31);
               var1.setComposite(var30);
               var14.lowerCoordinates.clear();
               var14.upperCoordinates.clear();
            }
         }

         if(this.isLinePass(var12)) {
            if(var10 == 0) {
               DeviationRenderer$State var35 = (DeviationRenderer$State)var2;
               var35.seriesPath.reset();
               var35.setLastPointGood(false);
            }

            if(this.getItemLineVisible(var9, var10)) {
               this.drawPrimaryLineAsPath(var2, var1, var5, var8, var12, var9, var10, var6, var7, var3);
            }
         } else if(this.isItemPass(var12)) {
            EntityCollection var36 = null;
            if(var4 != null) {
               var36 = var4.getOwner().getEntityCollection();
            }

            this.drawSecondaryPass(var1, var5, var8, var12, var9, var10, var6, var3, var7, var11, var36);
         }

      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof DeviationRenderer)) {
         return false;
      } else {
         DeviationRenderer var2 = (DeviationRenderer)var1;
         return this.alpha != var2.alpha?false:super.equals(var1);
      }
   }
}
