package org.jfree.chart.renderer.category;

import java.awt.Color;
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
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.IntervalBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.gantt.GanttCategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;

public class GanttRenderer extends IntervalBarRenderer implements Serializable {
   private static final long serialVersionUID = -4010349116350119512L;
   private transient Paint completePaint;
   private transient Paint incompletePaint;
   private double startPercent;
   private double endPercent;

   public GanttRenderer() {
      this.setIncludeBaseInRange(false);
      this.completePaint = Color.green;
      this.incompletePaint = Color.red;
      this.startPercent = 0.35D;
      this.endPercent = 0.65D;
   }

   public Paint getCompletePaint() {
      return this.completePaint;
   }

   public void setCompletePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.completePaint = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public Paint getIncompletePaint() {
      return this.incompletePaint;
   }

   public void setIncompletePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.incompletePaint = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public double getStartPercent() {
      return this.startPercent;
   }

   public void setStartPercent(double var1) {
      this.startPercent = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public double getEndPercent() {
      return this.endPercent;
   }

   public void setEndPercent(double var1) {
      this.endPercent = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      if(var7 instanceof GanttCategoryDataset) {
         GanttCategoryDataset var11 = (GanttCategoryDataset)var7;
         this.drawTasks(var1, var2, var3, var4, var5, var6, var11, var8, var9);
      } else {
         super.drawItem(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }

   }

   protected void drawTasks(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, GanttCategoryDataset var7, int var8, int var9) {
      int var10 = var7.getSubIntervalCount(var8, var9);
      if(var10 == 0) {
         this.drawTask(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

      for(int var11 = 0; var11 < var10; ++var11) {
         RectangleEdge var12 = var4.getRangeAxisEdge();
         Number var13 = var7.getStartValue(var8, var9, var11);
         if(var13 == null) {
            return;
         }

         double var14 = var6.valueToJava2D(var13.doubleValue(), var3, var12);
         Number var16 = var7.getEndValue(var8, var9, var11);
         if(var16 == null) {
            return;
         }

         double var17 = var6.valueToJava2D(var16.doubleValue(), var3, var12);
         double var19;
         if(var17 < var14) {
            var19 = var17;
            var17 = var14;
            var14 = var19;
         }

         var19 = this.calculateBarW0(var4, var4.getOrientation(), var3, var5, var2, var8, var9);
         double var21 = Math.abs(var17 - var14);
         double var23 = var2.getBarWidth();
         Double var25 = null;
         if(var4.getOrientation() == PlotOrientation.HORIZONTAL) {
            var25 = new Double(var14, var19, var21, var23);
         } else if(var4.getOrientation() == PlotOrientation.VERTICAL) {
            var25 = new Double(var19, var14, var23, var21);
         }

         Double var26 = null;
         Double var27 = null;
         Number var28 = var7.getPercentComplete(var8, var9, var11);
         double var29 = this.getStartPercent();
         double var31 = this.getEndPercent();
         if(var28 != null) {
            double var33 = var28.doubleValue();
            if(var4.getOrientation() == PlotOrientation.HORIZONTAL) {
               var26 = new Double(var14, var19 + var29 * var23, var21 * var33, var23 * (var31 - var29));
               var27 = new Double(var14 + var21 * var33, var19 + var29 * var23, var21 * (1.0D - var33), var23 * (var31 - var29));
            } else if(var4.getOrientation() == PlotOrientation.VERTICAL) {
               var26 = new Double(var19 + var29 * var23, var14 + var21 * (1.0D - var33), var23 * (var31 - var29), var21 * var33);
               var27 = new Double(var19 + var29 * var23, var14, var23 * (var31 - var29), var21 * (1.0D - var33));
            }
         }

         Paint var38 = this.getItemPaint(var8, var9);
         var1.setPaint(var38);
         var1.fill(var25);
         if(var26 != null) {
            var1.setPaint(this.getCompletePaint());
            var1.fill(var26);
         }

         if(var27 != null) {
            var1.setPaint(this.getIncompletePaint());
            var1.fill(var27);
         }

         if(this.isDrawBarOutline() && var2.getBarWidth() > 3.0D) {
            var1.setStroke(this.getItemStroke(var8, var9));
            var1.setPaint(this.getItemOutlinePaint(var8, var9));
            var1.draw(var25);
         }

         if(var2.getInfo() != null) {
            EntityCollection var34 = var2.getEntityCollection();
            if(var34 != null) {
               String var35 = null;
               if(this.getToolTipGenerator(var8, var9) != null) {
                  var35 = this.getToolTipGenerator(var8, var9).generateToolTip(var7, var8, var9);
               }

               String var36 = null;
               if(this.getItemURLGenerator(var8, var9) != null) {
                  var36 = this.getItemURLGenerator(var8, var9).generateURL(var7, var8, var9);
               }

               CategoryItemEntity var37 = new CategoryItemEntity(var25, var35, var36, var7, var8, var7.getColumnKey(var9), var9);
               var34.add(var37);
            }
         }
      }

   }

   protected void drawTask(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, GanttCategoryDataset var7, int var8, int var9) {
      PlotOrientation var10 = var4.getOrientation();
      RectangleEdge var11 = var4.getRangeAxisEdge();
      Number var12 = var7.getEndValue(var8, var9);
      if(var12 != null) {
         double var13 = var6.valueToJava2D(var12.doubleValue(), var3, var11);
         Number var15 = var7.getStartValue(var8, var9);
         if(var15 != null) {
            double var16 = var6.valueToJava2D(var15.doubleValue(), var3, var11);
            double var18;
            if(var16 < var13) {
               var18 = var16;
               var16 = var13;
               var13 = var18;
            }

            var18 = this.calculateBarW0(var4, var10, var3, var5, var2, var8, var9);
            double var20 = var2.getBarWidth();
            double var22 = Math.abs(var16 - var13);
            Double var24 = null;
            if(var10 == PlotOrientation.HORIZONTAL) {
               var24 = new Double(var13, var18, var22, var20);
            } else if(var10 == PlotOrientation.VERTICAL) {
               var24 = new Double(var18, var16, var20, var22);
            }

            Double var25 = null;
            Double var26 = null;
            Number var27 = var7.getPercentComplete(var8, var9);
            double var28 = this.getStartPercent();
            double var30 = this.getEndPercent();
            if(var27 != null) {
               double var32 = var27.doubleValue();
               if(var4.getOrientation() == PlotOrientation.HORIZONTAL) {
                  var25 = new Double(var13, var18 + var28 * var20, var22 * var32, var20 * (var30 - var28));
                  var26 = new Double(var13 + var22 * var32, var18 + var28 * var20, var22 * (1.0D - var32), var20 * (var30 - var28));
               } else if(var4.getOrientation() == PlotOrientation.VERTICAL) {
                  var25 = new Double(var18 + var28 * var20, var16 + var22 * (1.0D - var32), var20 * (var30 - var28), var22 * var32);
                  var26 = new Double(var18 + var28 * var20, var16, var20 * (var30 - var28), var22 * (1.0D - var32));
               }
            }

            Paint var39 = this.getItemPaint(var8, var9);
            var1.setPaint(var39);
            var1.fill(var24);
            if(var25 != null) {
               var1.setPaint(this.getCompletePaint());
               var1.fill(var25);
            }

            if(var26 != null) {
               var1.setPaint(this.getIncompletePaint());
               var1.fill(var26);
            }

            if(this.isDrawBarOutline() && var2.getBarWidth() > 3.0D) {
               Stroke var33 = this.getItemOutlineStroke(var8, var9);
               Paint var34 = this.getItemOutlinePaint(var8, var9);
               if(var33 != null && var34 != null) {
                  var1.setStroke(var33);
                  var1.setPaint(var34);
                  var1.draw(var24);
               }
            }

            CategoryItemLabelGenerator var40 = this.getItemLabelGenerator(var8, var9);
            if(var40 != null && this.isItemLabelVisible(var8, var9)) {
               this.drawItemLabel(var1, var7, var8, var9, var4, var40, var24, false);
            }

            if(var2.getInfo() != null) {
               EntityCollection var41 = var2.getEntityCollection();
               if(var41 != null) {
                  String var35 = null;
                  CategoryToolTipGenerator var36 = this.getToolTipGenerator(var8, var9);
                  if(var36 != null) {
                     var35 = var36.generateToolTip(var7, var8, var9);
                  }

                  String var37 = null;
                  if(this.getItemURLGenerator(var8, var9) != null) {
                     var37 = this.getItemURLGenerator(var8, var9).generateURL(var7, var8, var9);
                  }

                  CategoryItemEntity var38 = new CategoryItemEntity(var24, var35, var37, var7, var8, var7.getColumnKey(var9), var9);
                  var41.add(var38);
               }
            }

         }
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof GanttRenderer)) {
         return false;
      } else {
         GanttRenderer var2 = (GanttRenderer)var1;
         return !PaintUtilities.equal(this.completePaint, var2.completePaint)?false:(!PaintUtilities.equal(this.incompletePaint, var2.incompletePaint)?false:(this.startPercent != var2.startPercent?false:(this.endPercent != var2.endPercent?false:super.equals(var1))));
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.completePaint, var1);
      SerialUtilities.writePaint(this.incompletePaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.completePaint = SerialUtilities.readPaint(var1);
      this.incompletePaint = SerialUtilities.readPaint(var1);
   }
}
