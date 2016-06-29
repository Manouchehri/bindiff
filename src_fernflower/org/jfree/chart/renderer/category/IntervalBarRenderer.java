package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
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
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class IntervalBarRenderer extends BarRenderer implements Serializable, Cloneable, CategoryItemRenderer, PublicCloneable {
   private static final long serialVersionUID = -5068857361615528725L;

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      if(var7 instanceof IntervalCategoryDataset) {
         IntervalCategoryDataset var11 = (IntervalCategoryDataset)var7;
         this.drawInterval(var1, var2, var3, var4, var5, var6, var11, var8, var9);
      } else {
         super.drawItem(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }

   }

   protected void drawInterval(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, IntervalCategoryDataset var7, int var8, int var9) {
      int var10 = this.getRowCount();
      int var11 = this.getColumnCount();
      PlotOrientation var12 = var4.getOrientation();
      double var13 = 0.0D;
      double var15 = 0.0D;
      RectangleEdge var17 = var4.getDomainAxisEdge();
      RectangleEdge var18 = var4.getRangeAxisEdge();
      Number var19 = var7.getEndValue(var8, var9);
      if(var19 != null) {
         double var20 = var6.valueToJava2D(var19.doubleValue(), var3, var18);
         Number var22 = var7.getStartValue(var8, var9);
         if(var22 != null) {
            double var23 = var6.valueToJava2D(var22.doubleValue(), var3, var18);
            double var25;
            if(var23 < var20) {
               var25 = var23;
               var23 = var20;
               var20 = var25;
            }

            var25 = var2.getBarWidth();
            double var27 = Math.abs(var23 - var20);
            double var29;
            if(var12 == PlotOrientation.HORIZONTAL) {
               var15 = var5.getCategoryStart(var9, this.getColumnCount(), var3, var17);
               if(var10 > 1) {
                  var29 = var3.getHeight() * this.getItemMargin() / (double)(var11 * (var10 - 1));
                  var15 += (double)var8 * (var2.getBarWidth() + var29);
               } else {
                  var15 += (double)var8 * var2.getBarWidth();
               }

               var13 = var20;
               var27 = var2.getBarWidth();
               var25 = Math.abs(var23 - var20);
            } else if(var12 == PlotOrientation.VERTICAL) {
               var13 = var5.getCategoryStart(var9, this.getColumnCount(), var3, var17);
               if(var10 > 1) {
                  var29 = var3.getWidth() * this.getItemMargin() / (double)(var11 * (var10 - 1));
                  var13 += (double)var8 * (var2.getBarWidth() + var29);
               } else {
                  var13 += (double)var8 * var2.getBarWidth();
               }

               var15 = var20;
            }

            Double var37 = new Double(var13, var15, var25, var27);
            Paint var30 = this.getItemPaint(var8, var9);
            var1.setPaint(var30);
            var1.fill(var37);
            if(var2.getBarWidth() > 3.0D) {
               Stroke var31 = this.getItemOutlineStroke(var8, var9);
               Paint var32 = this.getItemOutlinePaint(var8, var9);
               if(var31 != null && var32 != null) {
                  var1.setStroke(var31);
                  var1.setPaint(var32);
                  var1.draw(var37);
               }
            }

            CategoryItemLabelGenerator var38 = this.getItemLabelGenerator(var8, var9);
            if(var38 != null && this.isItemLabelVisible(var8, var9)) {
               this.drawItemLabel(var1, var7, var8, var9, var4, var38, var37, false);
            }

            if(var2.getInfo() != null) {
               EntityCollection var39 = var2.getEntityCollection();
               if(var39 != null) {
                  String var33 = null;
                  CategoryToolTipGenerator var34 = this.getToolTipGenerator(var8, var9);
                  if(var34 != null) {
                     var33 = var34.generateToolTip(var7, var8, var9);
                  }

                  String var35 = null;
                  if(this.getItemURLGenerator(var8, var9) != null) {
                     var35 = this.getItemURLGenerator(var8, var9).generateURL(var7, var8, var9);
                  }

                  CategoryItemEntity var36 = new CategoryItemEntity(var37, var33, var35, var7, var8, var7.getColumnKey(var9), var9);
                  var39.add(var36);
               }
            }

         }
      }
   }
}
