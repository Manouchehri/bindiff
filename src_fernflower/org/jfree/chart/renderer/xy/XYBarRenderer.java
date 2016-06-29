package org.jfree.chart.renderer.xy;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer$XYBarRendererState;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class XYBarRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   private static final long serialVersionUID = 770559577251370036L;
   private double base;
   private boolean useYInterval;
   private double margin;
   private boolean drawBarOutline;
   private GradientPaintTransformer gradientPaintTransformer;
   private transient Shape legendBar;
   private ItemLabelPosition positiveItemLabelPositionFallback;
   private ItemLabelPosition negativeItemLabelPositionFallback;

   public XYBarRenderer() {
      this(0.0D);
   }

   public XYBarRenderer(double var1) {
      this.margin = var1;
      this.base = 0.0D;
      this.useYInterval = false;
      this.gradientPaintTransformer = new StandardGradientPaintTransformer();
      this.drawBarOutline = true;
      this.legendBar = new Double(-3.0D, -5.0D, 6.0D, 10.0D);
   }

   public double getBase() {
      return this.base;
   }

   public void setBase(double var1) {
      this.base = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getUseYInterval() {
      return this.useYInterval;
   }

   public void setUseYInterval(boolean var1) {
      if(this.useYInterval != var1) {
         this.useYInterval = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public double getMargin() {
      return this.margin;
   }

   public void setMargin(double var1) {
      this.margin = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean isDrawBarOutline() {
      return this.drawBarOutline;
   }

   public void setDrawBarOutline(boolean var1) {
      this.drawBarOutline = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public GradientPaintTransformer getGradientPaintTransformer() {
      return this.gradientPaintTransformer;
   }

   public void setGradientPaintTransformer(GradientPaintTransformer var1) {
      this.gradientPaintTransformer = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public Shape getLegendBar() {
      return this.legendBar;
   }

   public void setLegendBar(Shape var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'bar\' argument.");
      } else {
         this.legendBar = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public ItemLabelPosition getPositiveItemLabelPositionFallback() {
      return this.positiveItemLabelPositionFallback;
   }

   public void setPositiveItemLabelPositionFallback(ItemLabelPosition var1) {
      this.positiveItemLabelPositionFallback = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public ItemLabelPosition getNegativeItemLabelPositionFallback() {
      return this.negativeItemLabelPositionFallback;
   }

   public void setNegativeItemLabelPositionFallback(ItemLabelPosition var1) {
      this.negativeItemLabelPositionFallback = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public XYItemRendererState initialise(Graphics2D var1, Rectangle2D var2, XYPlot var3, XYDataset var4, PlotRenderingInfo var5) {
      XYBarRenderer$XYBarRendererState var6 = new XYBarRenderer$XYBarRendererState(this, var5);
      ValueAxis var7 = var3.getRangeAxisForDataset(var3.indexOf(var4));
      var6.setG2Base(var7.valueToJava2D(this.base, var2, var3.getRangeAxisEdge()));
      return var6;
   }

   public LegendItem getLegendItem(int var1, int var2) {
      LegendItem var3 = null;
      XYPlot var4 = this.getPlot();
      if(var4 != null) {
         XYDataset var5 = var4.getDataset(var1);
         if(var5 != null) {
            XYSeriesLabelGenerator var6 = this.getLegendItemLabelGenerator();
            String var7 = var6.generateLabel(var5, var2);
            String var9 = null;
            if(this.getLegendItemToolTipGenerator() != null) {
               var9 = this.getLegendItemToolTipGenerator().generateLabel(var5, var2);
            }

            String var10 = null;
            if(this.getLegendItemURLGenerator() != null) {
               var10 = this.getLegendItemURLGenerator().generateLabel(var5, var2);
            }

            Shape var11 = this.legendBar;
            Paint var12 = this.getSeriesPaint(var2);
            Paint var13 = this.getSeriesOutlinePaint(var2);
            Stroke var14 = this.getSeriesOutlineStroke(var2);
            if(this.drawBarOutline) {
               var3 = new LegendItem(var7, var7, var9, var10, var11, var12, var14, var13);
            } else {
               var3 = new LegendItem(var7, var7, var9, var10, var11, var12);
            }

            if(this.getGradientPaintTransformer() != null) {
               var3.setFillPaintTransformer(this.getGradientPaintTransformer());
            }
         }
      }

      return var3;
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      if(this.getItemVisible(var9, var10)) {
         IntervalXYDataset var13 = (IntervalXYDataset)var8;
         double var14;
         double var16;
         if(this.useYInterval) {
            var14 = var13.getStartYValue(var9, var10);
            var16 = var13.getEndYValue(var9, var10);
         } else {
            var14 = this.base;
            var16 = var13.getYValue(var9, var10);
         }

         if(!java.lang.Double.isNaN(var14) && !java.lang.Double.isNaN(var16)) {
            if(var14 <= var16) {
               if(!var7.getRange().intersects(var14, var16)) {
                  return;
               }
            } else if(!var7.getRange().intersects(var16, var14)) {
               return;
            }

            double var18 = var7.valueToJava2D(var14, var3, var5.getRangeAxisEdge());
            double var20 = var7.valueToJava2D(var16, var3, var5.getRangeAxisEdge());
            double var22 = Math.min(var18, var20);
            double var24 = Math.max(var18, var20);
            double var26 = var13.getStartXValue(var9, var10);
            if(!java.lang.Double.isNaN(var26)) {
               double var28 = var13.getEndXValue(var9, var10);
               if(!java.lang.Double.isNaN(var28)) {
                  if(var26 <= var28) {
                     if(!var6.getRange().intersects(var26, var28)) {
                        return;
                     }
                  } else if(!var6.getRange().intersects(var28, var26)) {
                     return;
                  }

                  RectangleEdge var30 = var5.getDomainAxisEdge();
                  double var31 = var6.valueToJava2D(var26, var3, var30);
                  double var33 = var6.valueToJava2D(var28, var3, var30);
                  double var35 = Math.max(1.0D, Math.abs(var33 - var31));
                  if(this.getMargin() > 0.0D) {
                     double var37 = var35 * this.getMargin();
                     var35 -= var37;
                     var31 += var37 / 2.0D;
                  }

                  Double var55 = null;
                  PlotOrientation var38 = var5.getOrientation();
                  if(var38 == PlotOrientation.HORIZONTAL) {
                     var22 = Math.max(var22, var3.getMinX());
                     var24 = Math.min(var24, var3.getMaxX());
                     var55 = new Double(var22, Math.min(var31, var33), var24 - var22, var35);
                  } else if(var38 == PlotOrientation.VERTICAL) {
                     var22 = Math.max(var22, var3.getMinY());
                     var24 = Math.min(var24, var3.getMaxY());
                     var55 = new Double(Math.min(var31, var33), var22, var35, var24 - var22);
                  }

                  Object var39 = this.getItemPaint(var9, var10);
                  if(this.getGradientPaintTransformer() != null && var39 instanceof GradientPaint) {
                     GradientPaint var40 = (GradientPaint)var39;
                     var39 = this.getGradientPaintTransformer().transform(var40, var55);
                  }

                  var1.setPaint((Paint)var39);
                  var1.fill(var55);
                  if(this.isDrawBarOutline() && Math.abs(var33 - var31) > 3.0D) {
                     Stroke var56 = this.getItemOutlineStroke(var9, var10);
                     Paint var41 = this.getItemOutlinePaint(var9, var10);
                     if(var56 != null && var41 != null) {
                        var1.setStroke(var56);
                        var1.setPaint(var41);
                        var1.draw(var55);
                     }
                  }

                  if(this.isItemLabelVisible(var9, var10)) {
                     XYItemLabelGenerator var57 = this.getItemLabelGenerator(var9, var10);
                     this.drawItemLabel(var1, var8, var9, var10, var5, var57, var55, var16 < 0.0D);
                  }

                  double var58 = (var26 + var28) / 2.0D;
                  double var42 = var8.getYValue(var9, var10);
                  double var44 = var6.valueToJava2D(var58, var3, var30);
                  double var46 = var7.valueToJava2D(var42, var3, var5.getRangeAxisEdge());
                  int var48 = var5.getDomainAxisIndex(var6);
                  int var49 = var5.getRangeAxisIndex(var7);
                  this.updateCrosshairValues(var11, var58, var42, var48, var49, var44, var46, var5.getOrientation());
                  if(var4 != null) {
                     EntityCollection var50 = var4.getOwner().getEntityCollection();
                     if(var50 != null) {
                        String var51 = null;
                        XYToolTipGenerator var52 = this.getToolTipGenerator(var9, var10);
                        if(var52 != null) {
                           var51 = var52.generateToolTip(var8, var9, var10);
                        }

                        String var53 = null;
                        if(this.getURLGenerator() != null) {
                           var53 = this.getURLGenerator().generateURL(var8, var9, var10);
                        }

                        XYItemEntity var54 = new XYItemEntity(var55, var8, var9, var10, var51, var53);
                        var50.add(var54);
                     }
                  }

               }
            }
         }
      }
   }

   protected void drawItemLabel(Graphics2D var1, XYDataset var2, int var3, int var4, XYPlot var5, XYItemLabelGenerator var6, Rectangle2D var7, boolean var8) {
      String var9 = var6.generateLabel(var2, var3, var4);
      if(var9 != null) {
         Font var10 = this.getItemLabelFont(var3, var4);
         var1.setFont(var10);
         Paint var11 = this.getItemLabelPaint(var3, var4);
         var1.setPaint(var11);
         ItemLabelPosition var12 = null;
         if(!var8) {
            var12 = this.getPositiveItemLabelPosition(var3, var4);
         } else {
            var12 = this.getNegativeItemLabelPosition(var3, var4);
         }

         Point2D var13 = this.calculateLabelAnchorPoint(var12.getItemLabelAnchor(), var7, var5.getOrientation());
         if(this.isInternalAnchor(var12.getItemLabelAnchor())) {
            Shape var14 = TextUtilities.calculateRotatedStringBounds(var9, var1, (float)var13.getX(), (float)var13.getY(), var12.getTextAnchor(), var12.getAngle(), var12.getRotationAnchor());
            if(var14 != null && !var7.contains(var14.getBounds2D())) {
               if(!var8) {
                  var12 = this.getPositiveItemLabelPositionFallback();
               } else {
                  var12 = this.getNegativeItemLabelPositionFallback();
               }

               if(var12 != null) {
                  var13 = this.calculateLabelAnchorPoint(var12.getItemLabelAnchor(), var7, var5.getOrientation());
               }
            }
         }

         if(var12 != null) {
            TextUtilities.drawRotatedString(var9, var1, (float)var13.getX(), (float)var13.getY(), var12.getTextAnchor(), var12.getAngle(), var12.getRotationAnchor());
         }

      }
   }

   private Point2D calculateLabelAnchorPoint(ItemLabelAnchor var1, Rectangle2D var2, PlotOrientation var3) {
      java.awt.geom.Point2D.Double var4 = null;
      double var5 = this.getItemLabelAnchorOffset();
      double var7 = var2.getX() - var5;
      double var9 = var2.getX();
      double var11 = var2.getX() + var5;
      double var13 = var2.getCenterX();
      double var15 = var2.getMaxX() - var5;
      double var17 = var2.getMaxX();
      double var19 = var2.getMaxX() + var5;
      double var21 = var2.getMaxY() + var5;
      double var23 = var2.getMaxY();
      double var25 = var2.getMaxY() - var5;
      double var27 = var2.getCenterY();
      double var29 = var2.getMinY() + var5;
      double var31 = var2.getMinY();
      double var33 = var2.getMinY() - var5;
      if(var1 == ItemLabelAnchor.CENTER) {
         var4 = new java.awt.geom.Point2D.Double(var13, var27);
      } else if(var1 == ItemLabelAnchor.INSIDE1) {
         var4 = new java.awt.geom.Point2D.Double(var15, var29);
      } else if(var1 == ItemLabelAnchor.INSIDE2) {
         var4 = new java.awt.geom.Point2D.Double(var15, var29);
      } else if(var1 == ItemLabelAnchor.INSIDE3) {
         var4 = new java.awt.geom.Point2D.Double(var15, var27);
      } else if(var1 == ItemLabelAnchor.INSIDE4) {
         var4 = new java.awt.geom.Point2D.Double(var15, var25);
      } else if(var1 == ItemLabelAnchor.INSIDE5) {
         var4 = new java.awt.geom.Point2D.Double(var15, var25);
      } else if(var1 == ItemLabelAnchor.INSIDE6) {
         var4 = new java.awt.geom.Point2D.Double(var13, var25);
      } else if(var1 == ItemLabelAnchor.INSIDE7) {
         var4 = new java.awt.geom.Point2D.Double(var11, var25);
      } else if(var1 == ItemLabelAnchor.INSIDE8) {
         var4 = new java.awt.geom.Point2D.Double(var11, var25);
      } else if(var1 == ItemLabelAnchor.INSIDE9) {
         var4 = new java.awt.geom.Point2D.Double(var11, var27);
      } else if(var1 == ItemLabelAnchor.INSIDE10) {
         var4 = new java.awt.geom.Point2D.Double(var11, var29);
      } else if(var1 == ItemLabelAnchor.INSIDE11) {
         var4 = new java.awt.geom.Point2D.Double(var11, var29);
      } else if(var1 == ItemLabelAnchor.INSIDE12) {
         var4 = new java.awt.geom.Point2D.Double(var13, var29);
      } else if(var1 == ItemLabelAnchor.OUTSIDE1) {
         var4 = new java.awt.geom.Point2D.Double(var17, var33);
      } else if(var1 == ItemLabelAnchor.OUTSIDE2) {
         var4 = new java.awt.geom.Point2D.Double(var19, var31);
      } else if(var1 == ItemLabelAnchor.OUTSIDE3) {
         var4 = new java.awt.geom.Point2D.Double(var19, var27);
      } else if(var1 == ItemLabelAnchor.OUTSIDE4) {
         var4 = new java.awt.geom.Point2D.Double(var19, var23);
      } else if(var1 == ItemLabelAnchor.OUTSIDE5) {
         var4 = new java.awt.geom.Point2D.Double(var17, var21);
      } else if(var1 == ItemLabelAnchor.OUTSIDE6) {
         var4 = new java.awt.geom.Point2D.Double(var13, var21);
      } else if(var1 == ItemLabelAnchor.OUTSIDE7) {
         var4 = new java.awt.geom.Point2D.Double(var9, var21);
      } else if(var1 == ItemLabelAnchor.OUTSIDE8) {
         var4 = new java.awt.geom.Point2D.Double(var7, var23);
      } else if(var1 == ItemLabelAnchor.OUTSIDE9) {
         var4 = new java.awt.geom.Point2D.Double(var7, var27);
      } else if(var1 == ItemLabelAnchor.OUTSIDE10) {
         var4 = new java.awt.geom.Point2D.Double(var7, var31);
      } else if(var1 == ItemLabelAnchor.OUTSIDE11) {
         var4 = new java.awt.geom.Point2D.Double(var9, var33);
      } else if(var1 == ItemLabelAnchor.OUTSIDE12) {
         var4 = new java.awt.geom.Point2D.Double(var13, var33);
      }

      return var4;
   }

   private boolean isInternalAnchor(ItemLabelAnchor var1) {
      return var1 == ItemLabelAnchor.CENTER || var1 == ItemLabelAnchor.INSIDE1 || var1 == ItemLabelAnchor.INSIDE2 || var1 == ItemLabelAnchor.INSIDE3 || var1 == ItemLabelAnchor.INSIDE4 || var1 == ItemLabelAnchor.INSIDE5 || var1 == ItemLabelAnchor.INSIDE6 || var1 == ItemLabelAnchor.INSIDE7 || var1 == ItemLabelAnchor.INSIDE8 || var1 == ItemLabelAnchor.INSIDE9 || var1 == ItemLabelAnchor.INSIDE10 || var1 == ItemLabelAnchor.INSIDE11 || var1 == ItemLabelAnchor.INSIDE12;
   }

   public Range findDomainBounds(XYDataset var1) {
      return var1 != null?DatasetUtilities.findDomainBounds(var1, true):null;
   }

   public Object clone() {
      XYBarRenderer var1 = (XYBarRenderer)super.clone();
      if(this.gradientPaintTransformer != null) {
         var1.gradientPaintTransformer = (GradientPaintTransformer)ObjectUtilities.clone(this.gradientPaintTransformer);
      }

      var1.legendBar = ShapeUtilities.clone(this.legendBar);
      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYBarRenderer)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         XYBarRenderer var2 = (XYBarRenderer)var1;
         return this.base != var2.base?false:(this.drawBarOutline != var2.drawBarOutline?false:(this.margin != var2.margin?false:(this.useYInterval != var2.useYInterval?false:(!ObjectUtilities.equal(this.gradientPaintTransformer, var2.gradientPaintTransformer)?false:(!ShapeUtilities.equal(this.legendBar, var2.legendBar)?false:(!ObjectUtilities.equal(this.positiveItemLabelPositionFallback, var2.positiveItemLabelPositionFallback)?false:ObjectUtilities.equal(this.negativeItemLabelPositionFallback, var2.negativeItemLabelPositionFallback)))))));
      }
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.legendBar = SerialUtilities.readShape(var1);
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeShape(this.legendBar, var1);
   }
}
