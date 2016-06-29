package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class LevelRenderer extends AbstractCategoryItemRenderer implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -8204856624355025117L;
   public static final double DEFAULT_ITEM_MARGIN = 0.2D;
   private double itemMargin = 0.2D;
   private double maxItemWidth = 1.0D;

   public double getItemMargin() {
      return this.itemMargin;
   }

   public void setItemMargin(double var1) {
      this.itemMargin = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public double getMaxItemWidth() {
      return this.maxItemWidth;
   }

   public void setMaxItemWidth(double var1) {
      this.maxItemWidth = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public double getMaximumItemWidth() {
      return this.getMaxItemWidth();
   }

   public void setMaximumItemWidth(double var1) {
      this.setMaxItemWidth(var1);
   }

   public CategoryItemRendererState initialise(Graphics2D var1, Rectangle2D var2, CategoryPlot var3, int var4, PlotRenderingInfo var5) {
      CategoryItemRendererState var6 = super.initialise(var1, var2, var3, var4, var5);
      this.calculateItemWidth(var3, var2, var4, var6);
      return var6;
   }

   protected void calculateItemWidth(CategoryPlot var1, Rectangle2D var2, int var3, CategoryItemRendererState var4) {
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

         double var12 = var9 * this.getMaxItemWidth();
         double var14 = 0.0D;
         double var16 = 0.0D;
         if(var7 > 1) {
            var14 = var5.getCategoryMargin();
         }

         if(var8 > 1) {
            var16 = this.getItemMargin();
         }

         double var18 = var9 * (1.0D - var5.getLowerMargin() - var5.getUpperMargin() - var14 - var16);
         if(var8 * var7 > 0) {
            var4.setBarWidth(Math.min(var18 / (double)(var8 * var7), var12));
         } else {
            var4.setBarWidth(Math.min(var18, var12));
         }
      }

   }

   protected double calculateBarW0(CategoryPlot var1, PlotOrientation var2, Rectangle2D var3, CategoryAxis var4, CategoryItemRendererState var5, int var6, int var7) {
      double var8 = 0.0D;
      if(var2 == PlotOrientation.HORIZONTAL) {
         var8 = var3.getHeight();
      } else {
         var8 = var3.getWidth();
      }

      double var10 = var4.getCategoryStart(var7, this.getColumnCount(), var3, var1.getDomainAxisEdge());
      int var12 = this.getRowCount();
      int var13 = this.getColumnCount();
      if(var12 > 1) {
         double var14 = var8 * this.getItemMargin() / (double)(var13 * (var12 - 1));
         double var16 = this.calculateSeriesWidth(var8, var4, var13, var12);
         var10 = var10 + (double)var6 * (var16 + var14) + var16 / 2.0D - var5.getBarWidth() / 2.0D;
      } else {
         var10 = var4.getCategoryMiddle(var7, this.getColumnCount(), var3, var1.getDomainAxisEdge()) - var5.getBarWidth() / 2.0D;
      }

      return var10;
   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      Number var11 = var7.getValue(var8, var9);
      if(var11 != null) {
         double var12 = var11.doubleValue();
         PlotOrientation var14 = var4.getOrientation();
         double var15 = this.calculateBarW0(var4, var14, var3, var5, var2, var8, var9);
         RectangleEdge var17 = var4.getRangeAxisEdge();
         double var18 = var6.valueToJava2D(var12, var3, var17);
         Double var20 = null;
         double var21 = 0.0D;
         double var23 = 0.0D;
         if(var14 == PlotOrientation.HORIZONTAL) {
            var21 = var18;
            var23 = var15 + var2.getBarWidth() / 2.0D;
            var20 = new Double(var18, var15, var18, var15 + var2.getBarWidth());
         } else {
            var21 = var15 + var2.getBarWidth() / 2.0D;
            var23 = var18;
            var20 = new Double(var15, var18, var15 + var2.getBarWidth(), var18);
         }

         Stroke var25 = this.getItemStroke(var8, var9);
         Paint var26 = this.getItemPaint(var8, var9);
         var1.setStroke(var25);
         var1.setPaint(var26);
         var1.draw(var20);
         CategoryItemLabelGenerator var27 = this.getItemLabelGenerator(var8, var9);
         if(var27 != null && this.isItemLabelVisible(var8, var9)) {
            this.drawItemLabel(var1, var14, var7, var8, var9, var21, var23, var12 < 0.0D);
         }

         if(var2.getInfo() != null) {
            EntityCollection var28 = var2.getEntityCollection();
            if(var28 != null) {
               String var29 = null;
               CategoryToolTipGenerator var30 = this.getToolTipGenerator(var8, var9);
               if(var30 != null) {
                  var29 = var30.generateToolTip(var7, var8, var9);
               }

               String var31 = null;
               if(this.getItemURLGenerator(var8, var9) != null) {
                  var31 = this.getItemURLGenerator(var8, var9).generateURL(var7, var8, var9);
               }

               CategoryItemEntity var32 = new CategoryItemEntity(var20.getBounds(), var29, var31, var7, var8, var7.getColumnKey(var9), var9);
               var28.add(var32);
            }
         }

      }
   }

   protected double calculateSeriesWidth(double var1, CategoryAxis var3, int var4, int var5) {
      double var6 = 1.0D - this.getItemMargin() - var3.getLowerMargin() - var3.getUpperMargin();
      if(var4 > 1) {
         var6 -= var3.getCategoryMargin();
      }

      return var1 * var6 / (double)(var4 * var5);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof LevelRenderer)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         LevelRenderer var2 = (LevelRenderer)var1;
         return this.itemMargin != var2.itemMargin?false:this.maxItemWidth == var2.maxItemWidth;
      }
   }
}
