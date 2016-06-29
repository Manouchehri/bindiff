package org.jfree.chart.renderer.category;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.StatisticalCategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class StatisticalBarRenderer extends BarRenderer implements Serializable, Cloneable, CategoryItemRenderer, PublicCloneable {
   private static final long serialVersionUID = -4986038395414039117L;
   private transient Paint errorIndicatorPaint;

   public StatisticalBarRenderer() {
      this.errorIndicatorPaint = Color.gray;
   }

   public Paint getErrorIndicatorPaint() {
      return this.errorIndicatorPaint;
   }

   public void setErrorIndicatorPaint(Paint var1) {
      this.errorIndicatorPaint = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      if(!(var7 instanceof StatisticalCategoryDataset)) {
         throw new IllegalArgumentException("Requires StatisticalCategoryDataset.");
      } else {
         StatisticalCategoryDataset var11 = (StatisticalCategoryDataset)var7;
         PlotOrientation var12 = var4.getOrientation();
         if(var12 == PlotOrientation.HORIZONTAL) {
            this.drawHorizontalItem(var1, var2, var3, var4, var5, var6, var11, var8, var9);
         } else if(var12 == PlotOrientation.VERTICAL) {
            this.drawVerticalItem(var1, var2, var3, var4, var5, var6, var11, var8, var9);
         }

      }
   }

   protected void drawHorizontalItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, StatisticalCategoryDataset var7, int var8, int var9) {
      RectangleEdge var10 = var4.getDomainAxisEdge();
      double var11 = var5.getCategoryStart(var9, this.getColumnCount(), var3, var10);
      int var13 = this.getRowCount();
      int var14 = this.getColumnCount();
      if(var13 > 1) {
         double var15 = var3.getHeight() * this.getItemMargin() / (double)(var14 * (var13 - 1));
         var11 += (double)var8 * (var2.getBarWidth() + var15);
      } else {
         var11 += (double)var8 * var2.getBarWidth();
      }

      Number var46 = var7.getMeanValue(var8, var9);
      double var16 = var46.doubleValue();
      double var18 = 0.0D;
      double var20 = this.getLowerClip();
      double var22 = this.getUpperClip();
      if(var22 <= 0.0D) {
         if(var16 >= var22) {
            return;
         }

         var18 = var22;
         if(var16 <= var20) {
            var16 = var20;
         }
      } else if(var20 <= 0.0D) {
         if(var16 >= var22) {
            var16 = var22;
         } else if(var16 <= var20) {
            var16 = var20;
         }
      } else {
         if(var16 <= var20) {
            return;
         }

         var18 = this.getLowerClip();
         if(var16 >= var22) {
            var16 = var22;
         }
      }

      RectangleEdge var24 = var4.getRangeAxisEdge();
      double var25 = var6.valueToJava2D(var18, var3, var24);
      double var27 = var6.valueToJava2D(var16, var3, var24);
      double var29 = Math.min(var27, var25);
      double var31 = var2.getBarWidth();
      double var33 = Math.abs(var27 - var25);
      Double var35 = new Double(var29, var11, var33, var31);
      Paint var36 = this.getItemPaint(var8, var9);
      var1.setPaint(var36);
      var1.fill(var35);
      if(var2.getBarWidth() > 3.0D) {
         var1.setStroke(this.getItemStroke(var8, var9));
         var1.setPaint(this.getItemOutlinePaint(var8, var9));
         var1.draw(var35);
      }

      double var37 = var7.getStdDevValue(var8, var9).doubleValue();
      double var39 = var6.valueToJava2D(var46.doubleValue() + var37, var3, var24);
      double var41 = var6.valueToJava2D(var46.doubleValue() - var37, var3, var24);
      if(this.errorIndicatorPaint != null) {
         var1.setPaint(this.errorIndicatorPaint);
      } else {
         var1.setPaint(this.getItemOutlinePaint(var8, var9));
      }

      java.awt.geom.Line2D.Double var43 = null;
      var43 = new java.awt.geom.Line2D.Double(var41, var11 + var31 / 2.0D, var39, var11 + var31 / 2.0D);
      var1.draw(var43);
      var43 = new java.awt.geom.Line2D.Double(var39, var11 + var31 * 0.25D, var39, var11 + var31 * 0.75D);
      var1.draw(var43);
      var43 = new java.awt.geom.Line2D.Double(var41, var11 + var31 * 0.25D, var41, var11 + var31 * 0.75D);
      var1.draw(var43);
      CategoryItemLabelGenerator var44 = this.getItemLabelGenerator(var8, var9);
      if(var44 != null && this.isItemLabelVisible(var8, var9)) {
         this.drawItemLabel(var1, var7, var8, var9, var4, var44, var35, var16 < 0.0D);
      }

      EntityCollection var45 = var2.getEntityCollection();
      if(var45 != null) {
         this.addItemEntity(var45, var7, var8, var9, var35);
      }

   }

   protected void drawVerticalItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, StatisticalCategoryDataset var7, int var8, int var9) {
      RectangleEdge var10 = var4.getDomainAxisEdge();
      double var11 = var5.getCategoryStart(var9, this.getColumnCount(), var3, var10);
      int var13 = this.getRowCount();
      int var14 = this.getColumnCount();
      if(var13 > 1) {
         double var15 = var3.getWidth() * this.getItemMargin() / (double)(var14 * (var13 - 1));
         var11 += (double)var8 * (var2.getBarWidth() + var15);
      } else {
         var11 += (double)var8 * var2.getBarWidth();
      }

      Number var46 = var7.getMeanValue(var8, var9);
      double var16 = var46.doubleValue();
      double var18 = 0.0D;
      double var20 = this.getLowerClip();
      double var22 = this.getUpperClip();
      if(var22 <= 0.0D) {
         if(var16 >= var22) {
            return;
         }

         var18 = var22;
         if(var16 <= var20) {
            var16 = var20;
         }
      } else if(var20 <= 0.0D) {
         if(var16 >= var22) {
            var16 = var22;
         } else if(var16 <= var20) {
            var16 = var20;
         }
      } else {
         if(var16 <= var20) {
            return;
         }

         var18 = this.getLowerClip();
         if(var16 >= var22) {
            var16 = var22;
         }
      }

      RectangleEdge var24 = var4.getRangeAxisEdge();
      double var25 = var6.valueToJava2D(var18, var3, var24);
      double var27 = var6.valueToJava2D(var16, var3, var24);
      double var29 = Math.min(var27, var25);
      double var31 = var2.getBarWidth();
      double var33 = Math.abs(var27 - var25);
      Double var35 = new Double(var11, var29, var31, var33);
      Paint var36 = this.getItemPaint(var8, var9);
      var1.setPaint(var36);
      var1.fill(var35);
      if(var2.getBarWidth() > 3.0D) {
         var1.setStroke(this.getItemStroke(var8, var9));
         var1.setPaint(this.getItemOutlinePaint(var8, var9));
         var1.draw(var35);
      }

      double var37 = var7.getStdDevValue(var8, var9).doubleValue();
      double var39 = var6.valueToJava2D(var46.doubleValue() + var37, var3, var24);
      double var41 = var6.valueToJava2D(var46.doubleValue() - var37, var3, var24);
      if(this.errorIndicatorPaint != null) {
         var1.setPaint(this.errorIndicatorPaint);
      } else {
         var1.setPaint(this.getItemOutlinePaint(var8, var9));
      }

      java.awt.geom.Line2D.Double var43 = null;
      var43 = new java.awt.geom.Line2D.Double(var11 + var31 / 2.0D, var41, var11 + var31 / 2.0D, var39);
      var1.draw(var43);
      var43 = new java.awt.geom.Line2D.Double(var11 + var31 / 2.0D - 5.0D, var39, var11 + var31 / 2.0D + 5.0D, var39);
      var1.draw(var43);
      var43 = new java.awt.geom.Line2D.Double(var11 + var31 / 2.0D - 5.0D, var41, var11 + var31 / 2.0D + 5.0D, var41);
      var1.draw(var43);
      CategoryItemLabelGenerator var44 = this.getItemLabelGenerator(var8, var9);
      if(var44 != null && this.isItemLabelVisible(var8, var9)) {
         this.drawItemLabel(var1, var7, var8, var9, var4, var44, var35, var16 < 0.0D);
      }

      EntityCollection var45 = var2.getEntityCollection();
      if(var45 != null) {
         this.addItemEntity(var45, var7, var8, var9, var35);
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StatisticalBarRenderer)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         StatisticalBarRenderer var2 = (StatisticalBarRenderer)var1;
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
