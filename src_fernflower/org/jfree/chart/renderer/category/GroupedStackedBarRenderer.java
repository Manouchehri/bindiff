package org.jfree.chart.renderer.category;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
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
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class GroupedStackedBarRenderer extends StackedBarRenderer implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -2725921399005922939L;
   private KeyToGroupMap seriesToGroupMap = new KeyToGroupMap();

   public void setSeriesToGroupMap(KeyToGroupMap var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'map\' argument.");
      } else {
         this.seriesToGroupMap = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public Range findRangeBounds(CategoryDataset var1) {
      Range var2 = DatasetUtilities.findStackedRangeBounds(var1, this.seriesToGroupMap);
      return var2;
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
         int var12 = this.seriesToGroupMap.getGroupCount();
         int var13 = var6.getColumnCount();
         int var14 = var12 * var13;
         double var15 = 0.0D;
         double var17 = 0.0D;
         if(var13 > 1) {
            var15 = var5.getCategoryMargin();
         }

         if(var12 > 1) {
            var17 = this.getItemMargin();
         }

         double var19 = var8 * (1.0D - var5.getLowerMargin() - var5.getUpperMargin() - var15 - var17);
         if(var14 > 0) {
            var4.setBarWidth(Math.min(var19 / (double)var14, var10));
         } else {
            var4.setBarWidth(Math.min(var19, var10));
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
      int var12 = this.seriesToGroupMap.getGroupCount();
      int var13 = this.seriesToGroupMap.getGroupIndex(this.seriesToGroupMap.getGroup(var1.getDataset().getRowKey(var6)));
      int var14 = this.getColumnCount();
      if(var12 > 1) {
         double var15 = var8 * this.getItemMargin() / (double)(var14 * (var12 - 1));
         double var17 = this.calculateSeriesWidth(var8, var4, var14, var12);
         var10 = var10 + (double)var13 * (var17 + var15) + var17 / 2.0D - var5.getBarWidth() / 2.0D;
      } else {
         var10 = var4.getCategoryMiddle(var7, this.getColumnCount(), var3, var1.getDomainAxisEdge()) - var5.getBarWidth() / 2.0D;
      }

      return var10;
   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      Number var11 = var7.getValue(var8, var9);
      if(var11 != null) {
         double var12 = var11.doubleValue();
         Comparable var14 = this.seriesToGroupMap.getGroup(var7.getRowKey(var8));
         PlotOrientation var15 = var4.getOrientation();
         double var16 = this.calculateBarW0(var4, var15, var3, var5, var2, var8, var9);
         double var18 = 0.0D;
         double var20 = 0.0D;

         double var24;
         for(int var22 = 0; var22 < var8; ++var22) {
            if(var14.equals(this.seriesToGroupMap.getGroup(var7.getRowKey(var22)))) {
               Number var23 = var7.getValue(var22, var9);
               if(var23 != null) {
                  var24 = var23.doubleValue();
                  if(var24 > 0.0D) {
                     var18 += var24;
                  } else {
                     var20 += var24;
                  }
               }
            }
         }

         RectangleEdge var26 = var4.getRangeAxisEdge();
         double var39;
         if(var12 > 0.0D) {
            var39 = var6.valueToJava2D(var18, var3, var26);
            var24 = var6.valueToJava2D(var18 + var12, var3, var26);
         } else {
            var39 = var6.valueToJava2D(var20, var3, var26);
            var24 = var6.valueToJava2D(var20 + var12, var3, var26);
         }

         double var27 = Math.min(var39, var24);
         double var29 = Math.max(Math.abs(var24 - var39), this.getMinimumBarLength());
         Double var31 = null;
         if(var15 == PlotOrientation.HORIZONTAL) {
            var31 = new Double(var27, var16, var29, var2.getBarWidth());
         } else {
            var31 = new Double(var16, var27, var2.getBarWidth(), var29);
         }

         Object var32 = this.getItemPaint(var8, var9);
         if(this.getGradientPaintTransformer() != null && var32 instanceof GradientPaint) {
            GradientPaint var33 = (GradientPaint)var32;
            var32 = this.getGradientPaintTransformer().transform(var33, var31);
         }

         var1.setPaint((Paint)var32);
         var1.fill(var31);
         if(this.isDrawBarOutline() && var2.getBarWidth() > 3.0D) {
            var1.setStroke(this.getItemStroke(var8, var9));
            var1.setPaint(this.getItemOutlinePaint(var8, var9));
            var1.draw(var31);
         }

         CategoryItemLabelGenerator var40 = this.getItemLabelGenerator(var8, var9);
         if(var40 != null && this.isItemLabelVisible(var8, var9)) {
            this.drawItemLabel(var1, var7, var8, var9, var4, var40, var31, var12 < 0.0D);
         }

         if(var2.getInfo() != null) {
            EntityCollection var34 = var2.getEntityCollection();
            if(var34 != null) {
               String var35 = null;
               CategoryToolTipGenerator var36 = this.getToolTipGenerator(var8, var9);
               if(var36 != null) {
                  var35 = var36.generateToolTip(var7, var8, var9);
               }

               String var37 = null;
               if(this.getItemURLGenerator(var8, var9) != null) {
                  var37 = this.getItemURLGenerator(var8, var9).generateURL(var7, var8, var9);
               }

               CategoryItemEntity var38 = new CategoryItemEntity(var31, var35, var37, var7, var8, var7.getColumnKey(var9), var9);
               var34.add(var38);
            }
         }

      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof GroupedStackedBarRenderer && super.equals(var1)) {
         GroupedStackedBarRenderer var2 = (GroupedStackedBarRenderer)var1;
         return var2.seriesToGroupMap.equals(this.seriesToGroupMap);
      } else {
         return false;
      }
   }
}
