package org.jfree.chart.renderer.category;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectList;

public class LayeredBarRenderer extends BarRenderer implements Serializable {
   private static final long serialVersionUID = -8716572894780469487L;
   protected ObjectList seriesBarWidthList = new ObjectList();

   public double getSeriesBarWidth(int var1) {
      double var2 = Double.NaN;
      Number var4 = (Number)this.seriesBarWidthList.get(var1);
      if(var4 != null) {
         var2 = var4.doubleValue();
      }

      return var2;
   }

   public void setSeriesBarWidth(int var1, double var2) {
      this.seriesBarWidthList.set(var1, new Double(var2));
   }

   protected void calculateBarWidth(CategoryPlot var1, Rectangle2D var2, int var3, CategoryItemRendererState var4) {
      CategoryAxis var5 = this.getDomainAxis(var1, var3);
      CategoryDataset var6 = var1.getDataset(var3);
      if(var6 != null) {
         int var7 = var6.getColumnCount();
         int var8 = var6.getRowCount();
         double var9 = 0.0D;
         PlotOrientation var11 = var1.getOrientation();
         if(var11 == PlotOrientation.HORIZONTAL) {
            var9 = var2.getHeight();
         } else if(var11 == PlotOrientation.VERTICAL) {
            var9 = var2.getWidth();
         }

         double var12 = var9 * this.getMaximumBarWidth();
         double var14 = 0.0D;
         if(var7 > 1) {
            var14 = var5.getCategoryMargin();
         }

         double var16 = var9 * (1.0D - var5.getLowerMargin() - var5.getUpperMargin() - var14);
         if(var8 * var7 > 0) {
            var4.setBarWidth(Math.min(var16 / (double)var6.getColumnCount(), var12));
         } else {
            var4.setBarWidth(Math.min(var16, var12));
         }
      }

   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      PlotOrientation var11 = var4.getOrientation();
      if(var11 == PlotOrientation.HORIZONTAL) {
         this.drawHorizontalItem(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      } else if(var11 == PlotOrientation.VERTICAL) {
         this.drawVerticalItem(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   protected void drawHorizontalItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9) {
      Number var10 = var7.getValue(var8, var9);
      if(var10 != null) {
         double var11 = var10.doubleValue();
         double var13 = 0.0D;
         double var15 = this.getLowerClip();
         double var17 = this.getUpperClip();
         if(var17 <= 0.0D) {
            if(var11 >= var17) {
               return;
            }

            var13 = var17;
            if(var11 <= var15) {
               var11 = var15;
            }
         } else if(var15 <= 0.0D) {
            if(var11 >= var17) {
               var11 = var17;
            } else if(var11 <= var15) {
               var11 = var15;
            }
         } else {
            if(var11 <= var15) {
               return;
            }

            var13 = var15;
            if(var11 >= var17) {
               var11 = var17;
            }
         }

         RectangleEdge var19 = var4.getRangeAxisEdge();
         double var20 = var6.valueToJava2D(var13, var3, var19);
         double var22 = var6.valueToJava2D(var11, var3, var19);
         double var24 = Math.min(var20, var22);
         double var26 = Math.abs(var22 - var20);
         double var28 = var5.getCategoryMiddle(var9, this.getColumnCount(), var3, var4.getDomainAxisEdge()) - var2.getBarWidth() / 2.0D;
         int var30 = this.getRowCount();
         double var31 = 0.0D;
         double var33 = 0.0D;
         double var35 = 1.0D;
         double var37 = this.getSeriesBarWidth(var8);
         if(!Double.isNaN(var37)) {
            var35 = var37;
         }

         var33 = var35 * var2.getBarWidth();
         var28 += (1.0D - var35) * var2.getBarWidth() / 2.0D;
         if(var30 > 1) {
            var31 = var33 * 0.2D / (double)(var30 - 1);
         }

         java.awt.geom.Rectangle2D.Double var39 = new java.awt.geom.Rectangle2D.Double(var24, var28 + (double)(var30 - 1 - var8) * var31, var26, var33 - (double)(var30 - 1 - var8) * var31 * 2.0D);
         Object var40 = this.getItemPaint(var8, var9);
         GradientPaintTransformer var41 = this.getGradientPaintTransformer();
         if(var41 != null && var40 instanceof GradientPaint) {
            var40 = var41.transform((GradientPaint)var40, var39);
         }

         var1.setPaint((Paint)var40);
         var1.fill(var39);
         if(this.isDrawBarOutline() && var2.getBarWidth() > 3.0D) {
            Stroke var42 = this.getItemOutlineStroke(var8, var9);
            Paint var43 = this.getItemOutlinePaint(var8, var9);
            if(var42 != null && var43 != null) {
               var1.setStroke(var42);
               var1.setPaint(var43);
               var1.draw(var39);
            }
         }

         CategoryItemLabelGenerator var48 = this.getItemLabelGenerator(var8, var9);
         if(var48 != null && this.isItemLabelVisible(var8, var9)) {
            this.drawItemLabel(var1, var7, var8, var9, var4, var48, var39, var20 > var22);
         }

         if(var2.getInfo() != null) {
            EntityCollection var49 = var2.getEntityCollection();
            if(var49 != null) {
               String var44 = null;
               CategoryToolTipGenerator var45 = this.getToolTipGenerator(var8, var9);
               if(var45 != null) {
                  var44 = var45.generateToolTip(var7, var8, var9);
               }

               String var46 = null;
               if(this.getItemURLGenerator(var8, var9) != null) {
                  var46 = this.getItemURLGenerator(var8, var9).generateURL(var7, var8, var9);
               }

               CategoryItemEntity var47 = new CategoryItemEntity(var39, var44, var46, var7, var8, var7.getColumnKey(var9), var9);
               var49.add(var47);
            }
         }

      }
   }

   protected void drawVerticalItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9) {
      Number var10 = var7.getValue(var8, var9);
      if(var10 != null) {
         double var11 = var5.getCategoryMiddle(var9, this.getColumnCount(), var3, var4.getDomainAxisEdge()) - var2.getBarWidth() / 2.0D;
         int var13 = this.getRowCount();
         double var14 = var10.doubleValue();
         double var16 = 0.0D;
         double var18 = this.getLowerClip();
         double var20 = this.getUpperClip();
         if(var20 <= 0.0D) {
            if(var14 >= var20) {
               return;
            }

            var16 = var20;
            if(var14 <= var18) {
               var14 = var18;
            }
         } else if(var18 <= 0.0D) {
            if(var14 >= var20) {
               var14 = var20;
            } else if(var14 <= var18) {
               var14 = var18;
            }
         } else {
            if(var14 <= var18) {
               return;
            }

            var16 = this.getLowerClip();
            if(var14 >= var20) {
               var14 = var20;
            }
         }

         RectangleEdge var22 = var4.getRangeAxisEdge();
         double var23 = var6.valueToJava2D(var16, var3, var22);
         double var25 = var6.valueToJava2D(var14, var3, var22);
         double var27 = Math.min(var25, var23);
         double var29 = var2.getBarWidth();
         double var31 = Math.abs(var25 - var23);
         double var33 = 0.0D;
         var29 = 0.0D;
         double var35 = 1.0D;
         double var37 = this.getSeriesBarWidth(var8);
         if(!Double.isNaN(var37)) {
            var35 = var37;
         }

         var29 = var35 * var2.getBarWidth();
         var11 += (1.0D - var35) * var2.getBarWidth() / 2.0D;
         if(var13 > 1) {
            var33 = var29 * 0.2D / (double)(var13 - 1);
         }

         java.awt.geom.Rectangle2D.Double var39 = new java.awt.geom.Rectangle2D.Double(var11 + (double)(var13 - 1 - var8) * var33, var27, var29 - (double)(var13 - 1 - var8) * var33 * 2.0D, var31);
         Object var40 = this.getItemPaint(var8, var9);
         GradientPaintTransformer var41 = this.getGradientPaintTransformer();
         if(var41 != null && var40 instanceof GradientPaint) {
            var40 = var41.transform((GradientPaint)var40, var39);
         }

         var1.setPaint((Paint)var40);
         var1.fill(var39);
         if(this.isDrawBarOutline() && var2.getBarWidth() > 3.0D) {
            Stroke var42 = this.getItemOutlineStroke(var8, var9);
            Paint var43 = this.getItemOutlinePaint(var8, var9);
            if(var42 != null && var43 != null) {
               var1.setStroke(var42);
               var1.setPaint(var43);
               var1.draw(var39);
            }
         }

         double var52 = var6.valueToJava2D(var16, var3, var22);
         double var44 = var6.valueToJava2D(var14, var3, var22);
         CategoryItemLabelGenerator var46 = this.getItemLabelGenerator(var8, var9);
         if(var46 != null && this.isItemLabelVisible(var8, var9)) {
            this.drawItemLabel(var1, var7, var8, var9, var4, var46, var39, var52 > var44);
         }

         if(var2.getInfo() != null) {
            EntityCollection var47 = var2.getEntityCollection();
            if(var47 != null) {
               String var48 = null;
               CategoryToolTipGenerator var49 = this.getToolTipGenerator(var8, var9);
               if(var49 != null) {
                  var48 = var49.generateToolTip(var7, var8, var9);
               }

               String var50 = null;
               if(this.getItemURLGenerator(var8, var9) != null) {
                  var50 = this.getItemURLGenerator(var8, var9).generateURL(var7, var8, var9);
               }

               CategoryItemEntity var51 = new CategoryItemEntity(var39, var48, var50, var7, var8, var7.getColumnKey(var9), var9);
               var47.add(var51);
            }
         }

      }
   }
}
