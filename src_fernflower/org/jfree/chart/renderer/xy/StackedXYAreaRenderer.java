package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Stack;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer$StackedXYAreaRendererState;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class StackedXYAreaRenderer extends XYAreaRenderer implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = 5217394318178570889L;
   private transient Paint shapePaint;
   private transient Stroke shapeStroke;

   public StackedXYAreaRenderer() {
      this(4);
   }

   public StackedXYAreaRenderer(int var1) {
      this(var1, (XYToolTipGenerator)null, (XYURLGenerator)null);
   }

   public StackedXYAreaRenderer(int var1, XYToolTipGenerator var2, XYURLGenerator var3) {
      super(var1, var2, var3);
      this.shapePaint = null;
      this.shapeStroke = null;
   }

   public Paint getShapePaint() {
      return this.shapePaint;
   }

   public void setShapePaint(Paint var1) {
      this.shapePaint = var1;
      this.fireChangeEvent();
   }

   public Stroke getShapeStroke() {
      return this.shapeStroke;
   }

   public void setShapeStroke(Stroke var1) {
      this.shapeStroke = var1;
      this.fireChangeEvent();
   }

   public XYItemRendererState initialise(Graphics2D var1, Rectangle2D var2, XYPlot var3, XYDataset var4, PlotRenderingInfo var5) {
      return new StackedXYAreaRenderer$StackedXYAreaRendererState(var5);
   }

   public int getPassCount() {
      return 2;
   }

   public Range findRangeBounds(XYDataset var1) {
      return var1 != null?DatasetUtilities.findStackedRangeBounds((TableXYDataset)var1):null;
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      PlotOrientation var13 = var5.getOrientation();
      StackedXYAreaRenderer$StackedXYAreaRendererState var14 = (StackedXYAreaRenderer$StackedXYAreaRendererState)var2;
      TableXYDataset var15 = (TableXYDataset)var8;
      int var16 = var15.getItemCount();
      double var17 = var8.getXValue(var9, var10);
      double var19 = var8.getYValue(var9, var10);
      boolean var21 = false;
      if(Double.isNaN(var19)) {
         var19 = 0.0D;
         var21 = true;
      }

      double var22 = this.getPreviousHeight(var15, var9, var10);
      double var24 = var6.valueToJava2D(var17, var3, var5.getDomainAxisEdge());
      double var26 = var7.valueToJava2D(var19 + var22, var3, var5.getRangeAxisEdge());
      Paint var28 = this.getItemPaint(var9, var10);
      Stroke var29 = this.getItemStroke(var9, var10);
      if(var12 == 0) {
         double var30;
         if(var10 == 0) {
            var14.setSeriesArea(new Polygon());
            var14.setLastSeriesPoints(var14.getCurrentSeriesPoints());
            var14.setCurrentSeriesPoints(new Stack());
            var30 = var7.valueToJava2D(var22, var3, var5.getRangeAxisEdge());
            if(var13 == PlotOrientation.VERTICAL) {
               var14.getSeriesArea().addPoint((int)var24, (int)var30);
            } else if(var13 == PlotOrientation.HORIZONTAL) {
               var14.getSeriesArea().addPoint((int)var30, (int)var24);
            }
         }

         if(var13 == PlotOrientation.VERTICAL) {
            Point var40 = new Point((int)var24, (int)var26);
            var14.getSeriesArea().addPoint((int)var40.getX(), (int)var40.getY());
            var14.getCurrentSeriesPoints().push(var40);
         } else if(var13 == PlotOrientation.HORIZONTAL) {
            var14.getSeriesArea().addPoint((int)var26, (int)var24);
         }

         if(this.getPlotLines() && var10 > 0) {
            var30 = var8.getXValue(var9, var10 - 1);
            double var32 = var8.getYValue(var9, var10 - 1);
            double var34 = this.getPreviousHeight(var15, var9, var10 - 1);
            double var36 = var6.valueToJava2D(var30, var3, var5.getDomainAxisEdge());
            double var38 = var7.valueToJava2D(var32 + var34, var3, var5.getRangeAxisEdge());
            if(var13 == PlotOrientation.VERTICAL) {
               var14.getLine().setLine(var36, var38, var24, var26);
            } else if(var13 == PlotOrientation.HORIZONTAL) {
               var14.getLine().setLine(var38, var36, var26, var24);
            }

            var1.draw(var14.getLine());
         }

         if(this.getPlotArea() && var10 > 0 && var10 == var16 - 1) {
            var30 = var7.valueToJava2D(var22, var3, var5.getRangeAxisEdge());
            if(var13 == PlotOrientation.VERTICAL) {
               var14.getSeriesArea().addPoint((int)var24, (int)var30);
            } else if(var13 == PlotOrientation.HORIZONTAL) {
               var14.getSeriesArea().addPoint((int)var30, (int)var24);
            }

            if(var9 != 0) {
               Stack var44 = var14.getLastSeriesPoints();

               while(!var44.empty()) {
                  Point var33 = (Point)var44.pop();
                  var14.getSeriesArea().addPoint((int)var33.getX(), (int)var33.getY());
               }
            }

            var1.setPaint(var28);
            var1.setStroke(var29);
            var1.fill(var14.getSeriesArea());
            if(this.isOutline()) {
               var1.setStroke(this.getSeriesOutlineStroke(var9));
               var1.setPaint(this.getSeriesOutlinePaint(var9));
               var1.draw(var14.getSeriesArea());
            }
         }

         int var42 = var5.getDomainAxisIndex(var6);
         int var31 = var5.getRangeAxisIndex(var7);
         this.updateCrosshairValues(var11, var17, var22 + var19, var42, var31, var24, var26, var13);
      } else if(var12 == 1) {
         Object var43 = null;
         if(this.getPlotShapes()) {
            var43 = this.getItemShape(var9, var10);
            if(var5.getOrientation() == PlotOrientation.VERTICAL) {
               var43 = ShapeUtilities.createTranslatedShape((Shape)var43, var24, var26);
            } else if(var5.getOrientation() == PlotOrientation.HORIZONTAL) {
               var43 = ShapeUtilities.createTranslatedShape((Shape)var43, var26, var24);
            }

            if(!var21) {
               if(this.getShapePaint() != null) {
                  var1.setPaint(this.getShapePaint());
               } else {
                  var1.setPaint(var28);
               }

               if(this.getShapeStroke() != null) {
                  var1.setStroke(this.getShapeStroke());
               } else {
                  var1.setStroke(var29);
               }

               var1.draw((Shape)var43);
            }
         } else if(var5.getOrientation() == PlotOrientation.VERTICAL) {
            var43 = new java.awt.geom.Rectangle2D.Double(var24 - 3.0D, var26 - 3.0D, 6.0D, 6.0D);
         } else if(var5.getOrientation() == PlotOrientation.HORIZONTAL) {
            var43 = new java.awt.geom.Rectangle2D.Double(var26 - 3.0D, var24 - 3.0D, 6.0D, 6.0D);
         }

         if(var2.getInfo() != null) {
            EntityCollection var41 = var2.getEntityCollection();
            if(var41 != null && var43 != null && !var21) {
               String var45 = null;
               XYToolTipGenerator var46 = this.getToolTipGenerator(var9, var10);
               if(var46 != null) {
                  var45 = var46.generateToolTip(var8, var9, var10);
               }

               String var47 = null;
               if(this.getURLGenerator() != null) {
                  var47 = this.getURLGenerator().generateURL(var8, var9, var10);
               }

               XYItemEntity var35 = new XYItemEntity((Shape)var43, var8, var9, var10, var45, var47);
               var41.add(var35);
            }
         }
      }

   }

   protected double getPreviousHeight(TableXYDataset var1, int var2, int var3) {
      double var4 = 0.0D;

      for(int var6 = 0; var6 < var2; ++var6) {
         double var7 = var1.getYValue(var6, var3);
         if(!Double.isNaN(var7)) {
            var4 += var7;
         }
      }

      return var4;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof StackedXYAreaRenderer && super.equals(var1)) {
         StackedXYAreaRenderer var2 = (StackedXYAreaRenderer)var1;
         return !PaintUtilities.equal(this.shapePaint, var2.shapePaint)?false:ObjectUtilities.equal(this.shapeStroke, var2.shapeStroke);
      } else {
         return false;
      }
   }

   public Object clone() {
      return super.clone();
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.shapePaint = SerialUtilities.readPaint(var1);
      this.shapeStroke = SerialUtilities.readStroke(var1);
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.shapePaint, var1);
      SerialUtilities.writeStroke(this.shapeStroke, var1);
   }
}
