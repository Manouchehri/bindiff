package org.jfree.chart.renderer.category;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;
import org.jfree.util.PublicCloneable;

public class StackedBarRenderer extends BarRenderer implements Serializable, Cloneable, PublicCloneable {
   static final long serialVersionUID = 6402943811500067531L;
   private boolean renderAsPercentages;

   public StackedBarRenderer() {
      this(false);
   }

   public StackedBarRenderer(boolean var1) {
      this.renderAsPercentages = var1;
      ItemLabelPosition var2 = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
      this.setBasePositiveItemLabelPosition(var2);
      this.setBaseNegativeItemLabelPosition(var2);
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

   public Range findRangeBounds(CategoryDataset var1) {
      return this.renderAsPercentages?new Range(0.0D, 1.0D):DatasetUtilities.findStackedRangeBounds(var1, this.getBase());
   }

   protected void calculateBarWidth(CategoryPlot var1, Rectangle2D var2, int var3, CategoryItemRendererState var4) {
      CategoryAxis var5 = var1.getDomainAxisForDataset(var3);
      CategoryDataset var6 = var1.getDataset(var3);
      if(var6 != null) {
         PlotOrientation var7 = var1.getOrientation();
         double var8 = 0.0D;
         if(var7 == PlotOrientation.HORIZONTAL) {
            var8 = var2.getHeight();
         } else if(var7 == PlotOrientation.VERTICAL) {
            var8 = var2.getWidth();
         }

         double var10 = var8 * this.getMaximumBarWidth();
         int var12 = var6.getColumnCount();
         double var13 = 0.0D;
         if(var12 > 1) {
            var13 = var5.getCategoryMargin();
         }

         double var15 = var8 * (1.0D - var5.getLowerMargin() - var5.getUpperMargin() - var13);
         if(var12 > 0) {
            var4.setBarWidth(Math.min(var15 / (double)var12, var10));
         } else {
            var4.setBarWidth(Math.min(var15, var10));
         }
      }

   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      Number var11 = var7.getValue(var8, var9);
      if(var11 != null) {
         double var12 = var11.doubleValue();
         double var14 = 0.0D;
         if(this.renderAsPercentages) {
            var14 = DataUtilities.calculateColumnTotal(var7, var9);
            var12 /= var14;
         }

         PlotOrientation var16 = var4.getOrientation();
         double var17 = var5.getCategoryMiddle(var9, this.getColumnCount(), var3, var4.getDomainAxisEdge()) - var2.getBarWidth() / 2.0D;
         double var19 = this.getBase();
         double var21 = var19;

         double var25;
         for(int var23 = 0; var23 < var8; ++var23) {
            Number var24 = var7.getValue(var23, var9);
            if(var24 != null) {
               var25 = var24.doubleValue();
               if(this.renderAsPercentages) {
                  var25 /= var14;
               }

               if(var25 > 0.0D) {
                  var19 += var25;
               } else {
                  var21 += var25;
               }
            }
         }

         RectangleEdge var27 = var4.getRangeAxisEdge();
         double var36;
         if(var12 >= 0.0D) {
            var36 = var6.valueToJava2D(var19, var3, var27);
            var25 = var6.valueToJava2D(var19 + var12, var3, var27);
         } else {
            var36 = var6.valueToJava2D(var21, var3, var27);
            var25 = var6.valueToJava2D(var21 + var12, var3, var27);
         }

         double var28 = Math.min(var36, var25);
         double var30 = Math.max(Math.abs(var25 - var36), this.getMinimumBarLength());
         Double var32 = null;
         if(var16 == PlotOrientation.HORIZONTAL) {
            var32 = new Double(var28, var17, var30, var2.getBarWidth());
         } else {
            var32 = new Double(var17, var28, var2.getBarWidth(), var30);
         }

         if(var10 == 0) {
            Object var33 = this.getItemPaint(var8, var9);
            GradientPaintTransformer var34 = this.getGradientPaintTransformer();
            if(var34 != null && var33 instanceof GradientPaint) {
               var33 = var34.transform((GradientPaint)var33, var32);
            }

            var1.setPaint((Paint)var33);
            var1.fill(var32);
            if(this.isDrawBarOutline() && var2.getBarWidth() > 3.0D) {
               var1.setStroke(this.getItemOutlineStroke(var8, var9));
               var1.setPaint(this.getItemOutlinePaint(var8, var9));
               var1.draw(var32);
            }

            EntityCollection var35 = var2.getEntityCollection();
            if(var35 != null) {
               this.addItemEntity(var35, var7, var8, var9, var32);
            }
         } else if(var10 == 1) {
            CategoryItemLabelGenerator var37 = this.getItemLabelGenerator(var8, var9);
            if(var37 != null && this.isItemLabelVisible(var8, var9)) {
               this.drawItemLabel(var1, var7, var8, var9, var4, var37, var32, var12 < 0.0D);
            }
         }

      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StackedBarRenderer)) {
         return false;
      } else {
         StackedBarRenderer var2 = (StackedBarRenderer)var1;
         return this.renderAsPercentages != var2.renderAsPercentages?false:super.equals(var1);
      }
   }
}
