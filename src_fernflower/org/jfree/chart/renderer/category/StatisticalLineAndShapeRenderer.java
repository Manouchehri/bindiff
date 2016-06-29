package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.StatisticalCategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class StatisticalLineAndShapeRenderer extends LineAndShapeRenderer implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -3557517173697777579L;
   private transient Paint errorIndicatorPaint;

   public StatisticalLineAndShapeRenderer() {
      this(true, true);
   }

   public StatisticalLineAndShapeRenderer(boolean var1, boolean var2) {
      super(var1, var2);
      this.errorIndicatorPaint = null;
   }

   public Paint getErrorIndicatorPaint() {
      return this.errorIndicatorPaint;
   }

   public void setErrorIndicatorPaint(Paint var1) {
      this.errorIndicatorPaint = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      Number var11 = var7.getValue(var8, var9);
      if(var11 != null) {
         StatisticalCategoryDataset var12 = (StatisticalCategoryDataset)var7;
         Number var13 = var12.getMeanValue(var8, var9);
         PlotOrientation var14 = var4.getOrientation();
         double var15 = var5.getCategoryMiddle(var9, this.getColumnCount(), var3, var4.getDomainAxisEdge());
         double var17 = var6.valueToJava2D(var13.doubleValue(), var3, var4.getRangeAxisEdge());
         Shape var19 = this.getItemShape(var8, var9);
         if(var14 == PlotOrientation.HORIZONTAL) {
            var19 = ShapeUtilities.createTranslatedShape(var19, var17, var15);
         } else if(var14 == PlotOrientation.VERTICAL) {
            var19 = ShapeUtilities.createTranslatedShape(var19, var15, var17);
         }

         if(this.getItemShapeVisible(var8, var9)) {
            if(this.getItemShapeFilled(var8, var9)) {
               var1.setPaint(this.getItemPaint(var8, var9));
               var1.fill(var19);
            } else {
               if(this.getUseOutlinePaint()) {
                  var1.setPaint(this.getItemOutlinePaint(var8, var9));
               } else {
                  var1.setPaint(this.getItemPaint(var8, var9));
               }

               var1.setStroke(this.getItemOutlineStroke(var8, var9));
               var1.draw(var19);
            }
         }

         if(this.getItemLineVisible(var8, var9) && var9 != 0) {
            Number var20 = var12.getValue(var8, var9 - 1);
            if(var20 != null) {
               double var21 = var20.doubleValue();
               double var23 = var5.getCategoryMiddle(var9 - 1, this.getColumnCount(), var3, var4.getDomainAxisEdge());
               double var25 = var6.valueToJava2D(var21, var3, var4.getRangeAxisEdge());
               Double var27 = null;
               if(var14 == PlotOrientation.HORIZONTAL) {
                  var27 = new Double(var25, var23, var17, var15);
               } else if(var14 == PlotOrientation.VERTICAL) {
                  var27 = new Double(var23, var25, var15, var17);
               }

               var1.setPaint(this.getItemPaint(var8, var9));
               var1.setStroke(this.getItemStroke(var8, var9));
               var1.draw(var27);
            }
         }

         RectangleEdge var36 = var4.getRangeAxisEdge();
         RectangleEdge var37 = var4.getDomainAxisEdge();
         double var22 = var5.getCategoryStart(var9, this.getColumnCount(), var3, var37);
         double var10000 = var22 + (double)var8 * var2.getBarWidth();
         var1.setPaint(this.getItemPaint(var8, var9));
         double var24 = var12.getStdDevValue(var8, var9).doubleValue();
         double var26;
         if(var13.doubleValue() + var24 > var6.getRange().getUpperBound()) {
            var26 = var6.valueToJava2D(var6.getRange().getUpperBound(), var3, var36);
         } else {
            var26 = var6.valueToJava2D(var13.doubleValue() + var24, var3, var36);
         }

         double var28;
         if(var13.doubleValue() + var24 < var6.getRange().getLowerBound()) {
            var28 = var6.valueToJava2D(var6.getRange().getLowerBound(), var3, var36);
         } else {
            var28 = var6.valueToJava2D(var13.doubleValue() - var24, var3, var36);
         }

         if(this.errorIndicatorPaint != null) {
            var1.setPaint(this.errorIndicatorPaint);
         } else {
            var1.setPaint(this.getItemPaint(var8, var9));
         }

         Double var30 = new Double();
         if(var14 == PlotOrientation.HORIZONTAL) {
            var30.setLine(var28, var15, var26, var15);
            var1.draw(var30);
            var30.setLine(var28, var15 - 5.0D, var28, var15 + 5.0D);
            var1.draw(var30);
            var30.setLine(var26, var15 - 5.0D, var26, var15 + 5.0D);
            var1.draw(var30);
         } else {
            var30.setLine(var15, var28, var15, var26);
            var1.draw(var30);
            var30.setLine(var15 - 5.0D, var26, var15 + 5.0D, var26);
            var1.draw(var30);
            var30.setLine(var15 - 5.0D, var28, var15 + 5.0D, var28);
            var1.draw(var30);
         }

         if(this.isItemLabelVisible(var8, var9)) {
            if(var14 == PlotOrientation.HORIZONTAL) {
               this.drawItemLabel(var1, var14, var7, var8, var9, var17, var15, var13.doubleValue() < 0.0D);
            } else if(var14 == PlotOrientation.VERTICAL) {
               this.drawItemLabel(var1, var14, var7, var8, var9, var15, var17, var13.doubleValue() < 0.0D);
            }
         }

         if(var2.getInfo() != null) {
            EntityCollection var31 = var2.getEntityCollection();
            if(var31 != null && var19 != null) {
               String var32 = null;
               CategoryToolTipGenerator var33 = this.getToolTipGenerator(var8, var9);
               if(var33 != null) {
                  var32 = var33.generateToolTip(var7, var8, var9);
               }

               String var34 = null;
               if(this.getItemURLGenerator(var8, var9) != null) {
                  var34 = this.getItemURLGenerator(var8, var9).generateURL(var7, var8, var9);
               }

               CategoryItemEntity var35 = new CategoryItemEntity(var19, var32, var34, var7, var8, var7.getColumnKey(var9), var9);
               var31.add(var35);
            }
         }

      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StatisticalLineAndShapeRenderer)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         StatisticalLineAndShapeRenderer var2 = (StatisticalLineAndShapeRenderer)var1;
         return PaintUtilities.equal(this.errorIndicatorPaint, var2.errorIndicatorPaint);
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.errorIndicatorPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.errorIndicatorPaint = SerialUtilities.readPaint(var1);
   }
}
