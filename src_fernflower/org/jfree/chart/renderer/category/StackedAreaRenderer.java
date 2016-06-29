package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class StackedAreaRenderer extends AreaRenderer implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -3595635038460823663L;
   private boolean renderAsPercentages;

   public StackedAreaRenderer() {
      this(false);
   }

   public StackedAreaRenderer(boolean var1) {
      this.renderAsPercentages = var1;
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
      return this.renderAsPercentages?new Range(0.0D, 1.0D):DatasetUtilities.findStackedRangeBounds(var1);
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

         double var16 = var5.getCategoryMiddle(var9, this.getColumnCount(), var3, var4.getDomainAxisEdge());
         double var18 = this.getPreviousHeight(var7, var8, var9);
         double var20 = var12 + var18;
         RectangleEdge var22 = var4.getRangeAxisEdge();
         double var23 = var6.valueToJava2D(var20, var3, var22);
         var1.setPaint(this.getItemPaint(var8, var9));
         var1.setStroke(this.getItemStroke(var8, var9));
         if(var9 == 0) {
            if(var10 == 1 && this.isItemLabelVisible(var8, var9)) {
               this.drawItemLabel(var1, var4.getOrientation(), var7, var8, var9, var16, var23, var20 < 0.0D);
            }
         } else {
            Number var25 = var7.getValue(var8, var9 - 1);
            if(var25 != null) {
               double var26 = var5.getCategoryMiddle(var9 - 1, this.getColumnCount(), var3, var4.getDomainAxisEdge());
               double var28 = var25.doubleValue();
               if(this.renderAsPercentages) {
                  var14 = DataUtilities.calculateColumnTotal(var7, var9 - 1);
                  var28 /= var14;
               }

               double var30 = this.getPreviousHeight(var7, var8, var9 - 1);
               var28 += var30;
               double var32 = var6.valueToJava2D(var30, var3, var22);
               double var34 = var6.valueToJava2D(var18, var3, var22);
               double var36 = var6.valueToJava2D(var28, var3, var22);
               if(var10 == 0) {
                  Polygon var38 = null;
                  PlotOrientation var39 = var4.getOrientation();
                  if(var39 == PlotOrientation.HORIZONTAL) {
                     var38 = new Polygon();
                     var38.addPoint((int)var36, (int)var26);
                     var38.addPoint((int)var23, (int)var16);
                     var38.addPoint((int)var34, (int)var16);
                     var38.addPoint((int)var32, (int)var26);
                  } else if(var39 == PlotOrientation.VERTICAL) {
                     var38 = new Polygon();
                     var38.addPoint((int)var26, (int)var36);
                     var38.addPoint((int)var16, (int)var23);
                     var38.addPoint((int)var16, (int)var34);
                     var38.addPoint((int)var26, (int)var32);
                  }

                  var1.setPaint(this.getItemPaint(var8, var9));
                  var1.setStroke(this.getItemStroke(var8, var9));
                  var1.fill(var38);
               } else if(this.isItemLabelVisible(var8, var9)) {
                  this.drawItemLabel(var1, var4.getOrientation(), var7, var8, var9, var16, var23, var20 < 0.0D);
               }
            }
         }

         EntityCollection var40 = var2.getEntityCollection();
         if(var40 != null) {
            Double var41 = new Double(var16 - 3.0D, var23 - 3.0D, 6.0D, 6.0D);
            this.addItemEntity(var40, var7, var8, var9, var41);
         }

      }
   }

   protected double getPreviousHeight(CategoryDataset var1, int var2, int var3) {
      double var4 = 0.0D;
      double var7 = 0.0D;
      if(this.renderAsPercentages) {
         var7 = DataUtilities.calculateColumnTotal(var1, var3);
      }

      for(int var9 = 0; var9 < var2; ++var9) {
         Number var6 = var1.getValue(var9, var3);
         if(var6 != null) {
            double var10 = var6.doubleValue();
            if(this.renderAsPercentages) {
               var10 /= var7;
            }

            var4 += var10;
         }
      }

      return var4;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StackedAreaRenderer)) {
         return false;
      } else {
         StackedAreaRenderer var2 = (StackedAreaRenderer)var1;
         return this.renderAsPercentages != var2.renderAsPercentages?false:super.equals(var1);
      }
   }
}
