package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.CategoryStepRenderer$State;
import org.jfree.data.category.CategoryDataset;
import org.jfree.util.PublicCloneable;

public class CategoryStepRenderer extends AbstractCategoryItemRenderer implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -5121079703118261470L;
   public static final int STAGGER_WIDTH = 5;
   private boolean stagger;

   public CategoryStepRenderer() {
      this(false);
   }

   public CategoryStepRenderer(boolean var1) {
      this.stagger = false;
      this.stagger = var1;
   }

   public boolean getStagger() {
      return this.stagger;
   }

   public void setStagger(boolean var1) {
      this.stagger = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public LegendItem getLegendItem(int var1, int var2) {
      CategoryPlot var3 = this.getPlot();
      if(var3 == null) {
         return null;
      } else if(this.isSeriesVisible(var2) && this.isSeriesVisibleInLegend(var2)) {
         CategoryDataset var4 = var3.getDataset(var1);
         String var5 = this.getLegendItemLabelGenerator().generateLabel(var4, var2);
         String var7 = null;
         if(this.getLegendItemToolTipGenerator() != null) {
            var7 = this.getLegendItemToolTipGenerator().generateLabel(var4, var2);
         }

         String var8 = null;
         if(this.getLegendItemURLGenerator() != null) {
            var8 = this.getLegendItemURLGenerator().generateLabel(var4, var2);
         }

         Double var9 = new Double(-4.0D, -3.0D, 8.0D, 6.0D);
         Paint var10 = this.getSeriesPaint(var2);
         LegendItem var11 = new LegendItem(var5, var5, var7, var8, var9, var10);
         var11.setSeriesIndex(var2);
         var11.setDatasetIndex(var1);
         return var11;
      } else {
         return null;
      }
   }

   protected CategoryItemRendererState createState(PlotRenderingInfo var1) {
      return new CategoryStepRenderer$State(var1);
   }

   protected void drawLine(Graphics2D var1, CategoryStepRenderer$State var2, PlotOrientation var3, double var4, double var6, double var8, double var10) {
      if(var3 == PlotOrientation.VERTICAL) {
         var2.line.setLine(var4, var6, var8, var10);
         var1.draw(var2.line);
      } else if(var3 == PlotOrientation.HORIZONTAL) {
         var2.line.setLine(var6, var4, var10, var8);
         var1.draw(var2.line);
      }

   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      if(this.getItemVisible(var8, var9)) {
         Number var11 = var7.getValue(var8, var9);
         if(var11 != null) {
            PlotOrientation var12 = var4.getOrientation();
            double var13 = var5.getCategoryStart(var9, this.getColumnCount(), var3, var4.getDomainAxisEdge());
            double var15 = var5.getCategoryMiddle(var9, this.getColumnCount(), var3, var4.getDomainAxisEdge());
            double var17 = 2.0D * var15 - var13;
            double var19 = var6.valueToJava2D(var11.doubleValue(), var3, var4.getRangeAxisEdge());
            var1.setPaint(this.getItemPaint(var8, var9));
            var1.setStroke(this.getItemStroke(var8, var9));
            if(var9 != 0) {
               Number var21 = var7.getValue(var8, var9 - 1);
               if(var21 != null) {
                  double var22 = var21.doubleValue();
                  double var24 = var5.getCategoryStart(var9 - 1, this.getColumnCount(), var3, var4.getDomainAxisEdge());
                  double var26 = var5.getCategoryMiddle(var9 - 1, this.getColumnCount(), var3, var4.getDomainAxisEdge());
                  double var28 = 2.0D * var26 - var24;
                  double var30 = var6.valueToJava2D(var22, var3, var4.getRangeAxisEdge());
                  if(this.getStagger()) {
                     int var32 = var8 * 5;
                     if((double)var32 > var13 - var28) {
                        var32 = (int)(var13 - var28);
                     }

                     var13 = var28 + (double)var32;
                  }

                  this.drawLine(var1, (CategoryStepRenderer$State)var2, var12, var28, var30, var13, var30);
                  this.drawLine(var1, (CategoryStepRenderer$State)var2, var12, var13, var30, var13, var19);
               }
            }

            this.drawLine(var1, (CategoryStepRenderer$State)var2, var12, var13, var19, var17, var19);
            if(this.isItemLabelVisible(var8, var9)) {
               this.drawItemLabel(var1, var12, var7, var8, var9, var15, var19, var11.doubleValue() < 0.0D);
            }

            EntityCollection var33 = var2.getEntityCollection();
            if(var33 != null) {
               Double var34 = new Double();
               if(var12 == PlotOrientation.VERTICAL) {
                  var34.setRect(var13, var19, var17 - var13, 4.0D);
               } else {
                  var34.setRect(var19 - 2.0D, var13, 4.0D, var17 - var13);
               }

               this.addItemEntity(var33, var7, var8, var9, var34);
            }

         }
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CategoryStepRenderer)) {
         return false;
      } else {
         CategoryStepRenderer var2 = (CategoryStepRenderer)var1;
         return this.stagger != var2.stagger?false:super.equals(var1);
      }
   }
}
