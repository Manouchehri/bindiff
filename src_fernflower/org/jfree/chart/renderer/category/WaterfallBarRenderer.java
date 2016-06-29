package org.jfree.chart.renderer.category;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
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
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class WaterfallBarRenderer extends BarRenderer implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -2482910643727230911L;
   private transient Paint firstBarPaint;
   private transient Paint lastBarPaint;
   private transient Paint positiveBarPaint;
   private transient Paint negativeBarPaint;

   public WaterfallBarRenderer() {
      this(new GradientPaint(0.0F, 0.0F, new Color(34, 34, 255), 0.0F, 0.0F, new Color(102, 102, 255)), new GradientPaint(0.0F, 0.0F, new Color(34, 255, 34), 0.0F, 0.0F, new Color(102, 255, 102)), new GradientPaint(0.0F, 0.0F, new Color(255, 34, 34), 0.0F, 0.0F, new Color(255, 102, 102)), new GradientPaint(0.0F, 0.0F, new Color(255, 255, 34), 0.0F, 0.0F, new Color(255, 255, 102)));
   }

   public WaterfallBarRenderer(Paint var1, Paint var2, Paint var3, Paint var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'firstBarPaint\' argument");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'positiveBarPaint\' argument");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'negativeBarPaint\' argument");
      } else if(var4 == null) {
         throw new IllegalArgumentException("Null \'lastBarPaint\' argument");
      } else {
         this.firstBarPaint = var1;
         this.lastBarPaint = var4;
         this.positiveBarPaint = var2;
         this.negativeBarPaint = var3;
         this.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
         this.setMinimumBarLength(1.0D);
      }
   }

   public Range findRangeBounds(CategoryDataset var1) {
      return DatasetUtilities.findCumulativeRangeBounds(var1);
   }

   public Paint getFirstBarPaint() {
      return this.firstBarPaint;
   }

   public void setFirstBarPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument");
      } else {
         this.firstBarPaint = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public Paint getLastBarPaint() {
      return this.lastBarPaint;
   }

   public void setLastBarPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument");
      } else {
         this.lastBarPaint = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public Paint getPositiveBarPaint() {
      return this.positiveBarPaint;
   }

   public void setPositiveBarPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument");
      } else {
         this.positiveBarPaint = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public Paint getNegativeBarPaint() {
      return this.negativeBarPaint;
   }

   public void setNegativeBarPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument");
      } else {
         this.negativeBarPaint = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      double var11 = var2.getSeriesRunningTotal();
      if(var9 == var7.getColumnCount() - 1) {
         var11 = 0.0D;
      }

      double var13 = 0.0D;
      Number var15 = var7.getValue(var8, var9);
      if(var15 != null) {
         var13 = var11 + var15.doubleValue();
      }

      var2.setSeriesRunningTotal(var13);
      int var16 = this.getRowCount();
      int var17 = this.getColumnCount();
      PlotOrientation var18 = var4.getOrientation();
      double var19 = 0.0D;
      double var21 = 0.0D;
      RectangleEdge var23 = var4.getDomainAxisEdge();
      RectangleEdge var24 = var4.getRangeAxisEdge();
      double var25 = var6.valueToJava2D(var11, var3, var24);
      double var27 = var6.valueToJava2D(var13, var3, var24);
      double var29 = var13 - var11;
      double var31;
      if(var27 < var25) {
         var31 = var27;
         var27 = var25;
         var25 = var31;
      }

      var31 = var2.getBarWidth();
      double var33 = Math.max(this.getMinimumBarLength(), Math.abs(var27 - var25));
      double var35;
      if(var18 == PlotOrientation.HORIZONTAL) {
         var21 = var5.getCategoryStart(var9, this.getColumnCount(), var3, var23);
         if(var16 > 1) {
            var35 = var3.getHeight() * this.getItemMargin() / (double)(var17 * (var16 - 1));
            var21 += (double)var8 * (var2.getBarWidth() + var35);
         } else {
            var21 += (double)var8 * var2.getBarWidth();
         }

         var19 = var25;
         var33 = var2.getBarWidth();
         var31 = Math.max(this.getMinimumBarLength(), Math.abs(var27 - var25));
      } else if(var18 == PlotOrientation.VERTICAL) {
         var19 = var5.getCategoryStart(var9, this.getColumnCount(), var3, var23);
         if(var16 > 1) {
            var35 = var3.getWidth() * this.getItemMargin() / (double)(var17 * (var16 - 1));
            var19 += (double)var8 * (var2.getBarWidth() + var35);
         } else {
            var19 += (double)var8 * var2.getBarWidth();
         }

         var21 = var25;
      }

      Double var39 = new Double(var19, var21, var31, var33);
      Paint var36 = this.getFirstBarPaint();
      Object var40;
      if(var9 == 0) {
         var40 = this.getFirstBarPaint();
      } else if(var9 == var17 - 1) {
         var40 = this.getLastBarPaint();
      } else if(var29 < 0.0D) {
         var40 = this.getNegativeBarPaint();
      } else if(var29 > 0.0D) {
         var40 = this.getPositiveBarPaint();
      } else {
         var40 = this.getLastBarPaint();
      }

      if(this.getGradientPaintTransformer() != null && var40 instanceof GradientPaint) {
         GradientPaint var37 = (GradientPaint)var40;
         var40 = this.getGradientPaintTransformer().transform(var37, var39);
      }

      var1.setPaint((Paint)var40);
      var1.fill(var39);
      if(this.isDrawBarOutline() && var2.getBarWidth() > 3.0D) {
         Stroke var41 = this.getItemOutlineStroke(var8, var9);
         Paint var38 = this.getItemOutlinePaint(var8, var9);
         if(var41 != null && var38 != null) {
            var1.setStroke(var41);
            var1.setPaint(var38);
            var1.draw(var39);
         }
      }

      CategoryItemLabelGenerator var42 = this.getItemLabelGenerator(var8, var9);
      if(var42 != null && this.isItemLabelVisible(var8, var9)) {
         this.drawItemLabel(var1, var7, var8, var9, var4, var42, var39, var29 < 0.0D);
      }

      EntityCollection var43 = var2.getEntityCollection();
      if(var43 != null) {
         this.addItemEntity(var43, var7, var8, var9, var39);
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!super.equals(var1)) {
         return false;
      } else if(!(var1 instanceof WaterfallBarRenderer)) {
         return false;
      } else {
         WaterfallBarRenderer var2 = (WaterfallBarRenderer)var1;
         return !PaintUtilities.equal(this.firstBarPaint, var2.firstBarPaint)?false:(!PaintUtilities.equal(this.lastBarPaint, var2.lastBarPaint)?false:(!PaintUtilities.equal(this.positiveBarPaint, var2.positiveBarPaint)?false:PaintUtilities.equal(this.negativeBarPaint, var2.negativeBarPaint)));
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.firstBarPaint, var1);
      SerialUtilities.writePaint(this.lastBarPaint, var1);
      SerialUtilities.writePaint(this.positiveBarPaint, var1);
      SerialUtilities.writePaint(this.negativeBarPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.firstBarPaint = SerialUtilities.readPaint(var1);
      this.lastBarPaint = SerialUtilities.readPaint(var1);
      this.positiveBarPaint = SerialUtilities.readPaint(var1);
      this.negativeBarPaint = SerialUtilities.readPaint(var1);
   }
}
