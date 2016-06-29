package org.jfree.chart.renderer.xy;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer$XYBarRendererState;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;

public class StackedXYBarRenderer extends XYBarRenderer {
   private static final long serialVersionUID = -7049101055533436444L;
   private boolean renderAsPercentages;
   static Class class$org$jfree$data$xy$IntervalXYDataset;
   static Class class$org$jfree$data$xy$TableXYDataset;

   public StackedXYBarRenderer() {
      this(0.0D);
   }

   public StackedXYBarRenderer(double var1) {
      super(var1);
      this.renderAsPercentages = false;
      ItemLabelPosition var3 = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
      this.setBasePositiveItemLabelPosition(var3);
      this.setBaseNegativeItemLabelPosition(var3);
      this.setPositiveItemLabelPositionFallback((ItemLabelPosition)null);
      this.setNegativeItemLabelPositionFallback((ItemLabelPosition)null);
   }

   public boolean getRenderAsPercentages() {
      return this.renderAsPercentages;
   }

   public void setRenderAsPercentages(boolean var1) {
      this.renderAsPercentages = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public int getPassCount() {
      return 2;
   }

   public XYItemRendererState initialise(Graphics2D var1, Rectangle2D var2, XYPlot var3, XYDataset var4, PlotRenderingInfo var5) {
      return new XYBarRenderer$XYBarRendererState(this, var5);
   }

   public Range findRangeBounds(XYDataset var1) {
      return var1 != null?(this.renderAsPercentages?new Range(0.0D, 1.0D):DatasetUtilities.findStackedRangeBounds((TableXYDataset)var1)):null;
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      if(var8 instanceof IntervalXYDataset && var8 instanceof TableXYDataset) {
         IntervalXYDataset var47 = (IntervalXYDataset)var8;
         double var46 = var47.getYValue(var9, var10);
         if(!Double.isNaN(var46)) {
            double var16 = 0.0D;
            if(this.renderAsPercentages) {
               var16 = DatasetUtilities.calculateStackTotal((TableXYDataset)var8, var10);
               var46 /= var16;
            }

            double var18 = 0.0D;
            double var20 = 0.0D;

            for(int var22 = 0; var22 < var9; ++var22) {
               double var23 = var8.getYValue(var22, var10);
               if(!Double.isNaN(var23)) {
                  if(this.renderAsPercentages) {
                     var23 /= var16;
                  }

                  if(var23 > 0.0D) {
                     var18 += var23;
                  } else {
                     var20 += var23;
                  }
               }
            }

            RectangleEdge var26 = var5.getRangeAxisEdge();
            double var24;
            double var48;
            if(var46 > 0.0D) {
               var48 = var7.valueToJava2D(var18, var3, var26);
               var24 = var7.valueToJava2D(var18 + var46, var3, var26);
            } else {
               var48 = var7.valueToJava2D(var20, var3, var26);
               var24 = var7.valueToJava2D(var20 + var46, var3, var26);
            }

            RectangleEdge var27 = var5.getDomainAxisEdge();
            double var28 = var47.getStartXValue(var9, var10);
            if(!Double.isNaN(var28)) {
               double var30 = var6.valueToJava2D(var28, var3, var27);
               double var32 = var47.getEndXValue(var9, var10);
               if(!Double.isNaN(var32)) {
                  double var34 = var6.valueToJava2D(var32, var3, var27);
                  double var36 = Math.max(1.0D, Math.abs(var34 - var30));
                  double var38 = Math.abs(var24 - var48);
                  if(this.getMargin() > 0.0D) {
                     double var40 = var36 * this.getMargin();
                     var36 -= var40;
                     var30 += var40 / 2.0D;
                  }

                  java.awt.geom.Rectangle2D.Double var49 = null;
                  PlotOrientation var41 = var5.getOrientation();
                  if(var41 == PlotOrientation.HORIZONTAL) {
                     var49 = new java.awt.geom.Rectangle2D.Double(Math.min(var48, var24), var34, var38, var36);
                  } else if(var41 == PlotOrientation.VERTICAL) {
                     var49 = new java.awt.geom.Rectangle2D.Double(var30, Math.min(var48, var24), var36, var38);
                  }

                  if(var12 == 0) {
                     Object var42 = this.getItemPaint(var9, var10);
                     if(this.getGradientPaintTransformer() != null && var42 instanceof GradientPaint) {
                        GradientPaint var43 = (GradientPaint)var42;
                        var42 = this.getGradientPaintTransformer().transform(var43, var49);
                     }

                     var1.setPaint((Paint)var42);
                     var1.fill(var49);
                     if(this.isDrawBarOutline() && Math.abs(var34 - var30) > 3.0D) {
                        var1.setStroke(this.getItemStroke(var9, var10));
                        var1.setPaint(this.getItemOutlinePaint(var9, var10));
                        var1.draw(var49);
                     }

                     if(var4 != null) {
                        EntityCollection var45 = var4.getOwner().getEntityCollection();
                        if(var45 != null) {
                           this.addEntity(var45, var49, var8, var9, var10, var49.getCenterX(), var49.getCenterY());
                        }
                     }
                  } else if(var12 == 1 && this.isItemLabelVisible(var9, var10)) {
                     XYItemLabelGenerator var44 = this.getItemLabelGenerator(var9, var10);
                     this.drawItemLabel(var1, var8, var9, var10, var5, var44, var49, var46 < 0.0D);
                  }

               }
            }
         }
      } else {
         String var13 = "dataset (type " + var8.getClass().getName() + ") has wrong type:";
         boolean var14 = false;
         if(!(class$org$jfree$data$xy$IntervalXYDataset == null?(class$org$jfree$data$xy$IntervalXYDataset = class$("org.jfree.data.xy.IntervalXYDataset")):class$org$jfree$data$xy$IntervalXYDataset).isAssignableFrom(var8.getClass())) {
            var13 = var13 + " it is no IntervalXYDataset";
            var14 = true;
         }

         if(!(class$org$jfree$data$xy$TableXYDataset == null?(class$org$jfree$data$xy$TableXYDataset = class$("org.jfree.data.xy.TableXYDataset")):class$org$jfree$data$xy$TableXYDataset).isAssignableFrom(var8.getClass())) {
            if(var14) {
               var13 = var13 + " and";
            }

            var13 = var13 + " it is no TableXYDataset";
         }

         throw new IllegalArgumentException(var13);
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StackedXYBarRenderer)) {
         return false;
      } else {
         StackedXYBarRenderer var2 = (StackedXYBarRenderer)var1;
         return this.renderAsPercentages != var2.renderAsPercentages?false:super.equals(var1);
      }
   }

   public int hashCode() {
      int var1 = super.hashCode();
      var1 = var1 * 37 + (this.renderAsPercentages?1:0);
      return var1;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
