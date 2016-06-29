package org.jfree.chart.renderer.category;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Float;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class BarRenderer extends AbstractCategoryItemRenderer implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = 6000649414965887481L;
   public static final double DEFAULT_ITEM_MARGIN = 0.2D;
   public static final double BAR_OUTLINE_WIDTH_THRESHOLD = 3.0D;
   private double itemMargin = 0.2D;
   private boolean drawBarOutline = true;
   private double maximumBarWidth = 1.0D;
   private double minimumBarLength = 0.0D;
   private GradientPaintTransformer gradientPaintTransformer = new StandardGradientPaintTransformer();
   private ItemLabelPosition positiveItemLabelPositionFallback = null;
   private ItemLabelPosition negativeItemLabelPositionFallback = null;
   private double upperClip;
   private double lowerClip;
   private double base = 0.0D;
   private boolean includeBaseInRange = true;

   public double getBase() {
      return this.base;
   }

   public void setBase(double var1) {
      this.base = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public double getItemMargin() {
      return this.itemMargin;
   }

   public void setItemMargin(double var1) {
      this.itemMargin = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean isDrawBarOutline() {
      return this.drawBarOutline;
   }

   public void setDrawBarOutline(boolean var1) {
      this.drawBarOutline = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public double getMaximumBarWidth() {
      return this.maximumBarWidth;
   }

   public void setMaximumBarWidth(double var1) {
      this.maximumBarWidth = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public double getMinimumBarLength() {
      return this.minimumBarLength;
   }

   public void setMinimumBarLength(double var1) {
      this.minimumBarLength = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public GradientPaintTransformer getGradientPaintTransformer() {
      return this.gradientPaintTransformer;
   }

   public void setGradientPaintTransformer(GradientPaintTransformer var1) {
      this.gradientPaintTransformer = var1;
      this.notifyListeners(new RendererChangeEvent(this));
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

   public boolean getIncludeBaseInRange() {
      return this.includeBaseInRange;
   }

   public void setIncludeBaseInRange(boolean var1) {
      if(this.includeBaseInRange != var1) {
         this.includeBaseInRange = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public double getLowerClip() {
      return this.lowerClip;
   }

   public double getUpperClip() {
      return this.upperClip;
   }

   public CategoryItemRendererState initialise(Graphics2D var1, Rectangle2D var2, CategoryPlot var3, int var4, PlotRenderingInfo var5) {
      CategoryItemRendererState var6 = super.initialise(var1, var2, var3, var4, var5);
      ValueAxis var7 = var3.getRangeAxisForDataset(var4);
      this.lowerClip = var7.getRange().getLowerBound();
      this.upperClip = var7.getRange().getUpperBound();
      this.calculateBarWidth(var3, var2, var4, var6);
      return var6;
   }

   protected void calculateBarWidth(CategoryPlot var1, Rectangle2D var2, int var3, CategoryItemRendererState var4) {
      CategoryAxis var5 = this.getDomainAxis(var1, var3);
      CategoryDataset var6 = var1.getDataset(var3);
      if(var6 != null) {
         int var7 = var6.getColumnCount();
         int var8 = var6.getRowCount();
         double var9 = 0.0D;
         PlotOrientation var11 = var1.getOrientation();
         if(var11 == PlotOrientation.HORIZONTAL) {
            var9 = var2.getHeight();
         } else if(var11 == PlotOrientation.VERTICAL) {
            var9 = var2.getWidth();
         }

         double var12 = var9 * this.getMaximumBarWidth();
         double var14 = 0.0D;
         double var16 = 0.0D;
         if(var7 > 1) {
            var14 = var5.getCategoryMargin();
         }

         if(var8 > 1) {
            var16 = this.getItemMargin();
         }

         double var18 = var9 * (1.0D - var5.getLowerMargin() - var5.getUpperMargin() - var14 - var16);
         if(var8 * var7 > 0) {
            var4.setBarWidth(Math.min(var18 / (double)(var8 * var7), var12));
         } else {
            var4.setBarWidth(Math.min(var18, var12));
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
      int var12 = this.getRowCount();
      int var13 = this.getColumnCount();
      if(var12 > 1) {
         double var14 = var8 * this.getItemMargin() / (double)(var13 * (var12 - 1));
         double var16 = this.calculateSeriesWidth(var8, var4, var13, var12);
         var10 = var10 + (double)var6 * (var16 + var14) + var16 / 2.0D - var5.getBarWidth() / 2.0D;
      } else {
         var10 = var4.getCategoryMiddle(var7, this.getColumnCount(), var3, var1.getDomainAxisEdge()) - var5.getBarWidth() / 2.0D;
      }

      return var10;
   }

   protected double[] calculateBarL0L1(double var1) {
      double var3 = this.getLowerClip();
      double var5 = this.getUpperClip();
      double var7 = Math.min(this.base, var1);
      double var9 = Math.max(this.base, var1);
      if(var9 < var3) {
         return null;
      } else if(var7 > var5) {
         return null;
      } else {
         var7 = Math.max(var7, var3);
         var9 = Math.min(var9, var5);
         return new double[]{var7, var9};
      }
   }

   public Range findRangeBounds(CategoryDataset var1) {
      Range var2 = DatasetUtilities.findRangeBounds(var1);
      if(var2 != null && this.includeBaseInRange) {
         var2 = Range.expandToInclude(var2, this.base);
      }

      return var2;
   }

   public LegendItem getLegendItem(int var1, int var2) {
      CategoryPlot var3 = this.getPlot();
      if(var3 == null) {
         return null;
      } else {
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

         Double var9 = new Double(-4.0D, -4.0D, 8.0D, 8.0D);
         Paint var10 = this.getSeriesPaint(var2);
         Paint var11 = this.getSeriesOutlinePaint(var2);
         Stroke var12 = this.getSeriesOutlineStroke(var2);
         LegendItem var13 = new LegendItem(var5, var5, var7, var8, true, var9, true, var10, this.isDrawBarOutline(), var11, var12, false, new Float(), new BasicStroke(1.0F), Color.black);
         if(this.gradientPaintTransformer != null) {
            var13.setFillPaintTransformer(this.gradientPaintTransformer);
         }

         return var13;
      }
   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      Number var11 = var7.getValue(var8, var9);
      if(var11 != null) {
         double var12 = var11.doubleValue();
         PlotOrientation var14 = var4.getOrientation();
         double var15 = this.calculateBarW0(var4, var14, var3, var5, var2, var8, var9);
         double[] var17 = this.calculateBarL0L1(var12);
         if(var17 != null) {
            RectangleEdge var18 = var4.getRangeAxisEdge();
            double var19 = var6.valueToJava2D(var17[0], var3, var18);
            double var21 = var6.valueToJava2D(var17[1], var3, var18);
            double var23 = Math.min(var19, var21);
            double var25 = Math.max(Math.abs(var21 - var19), this.getMinimumBarLength());
            Double var27 = null;
            if(var14 == PlotOrientation.HORIZONTAL) {
               var27 = new Double(var23, var15, var25, var2.getBarWidth());
            } else {
               var27 = new Double(var15, var23, var2.getBarWidth(), var25);
            }

            Object var28 = this.getItemPaint(var8, var9);
            GradientPaintTransformer var29 = this.getGradientPaintTransformer();
            if(var29 != null && var28 instanceof GradientPaint) {
               var28 = var29.transform((GradientPaint)var28, var27);
            }

            var1.setPaint((Paint)var28);
            var1.fill(var27);
            if(this.isDrawBarOutline() && var2.getBarWidth() > 3.0D) {
               Stroke var30 = this.getItemOutlineStroke(var8, var9);
               Paint var31 = this.getItemOutlinePaint(var8, var9);
               if(var30 != null && var31 != null) {
                  var1.setStroke(var30);
                  var1.setPaint(var31);
                  var1.draw(var27);
               }
            }

            CategoryItemLabelGenerator var32 = this.getItemLabelGenerator(var8, var9);
            if(var32 != null && this.isItemLabelVisible(var8, var9)) {
               this.drawItemLabel(var1, var7, var8, var9, var4, var32, var27, var12 < 0.0D);
            }

            EntityCollection var33 = var2.getEntityCollection();
            if(var33 != null) {
               this.addItemEntity(var33, var7, var8, var9, var27);
            }

         }
      }
   }

   protected double calculateSeriesWidth(double var1, CategoryAxis var3, int var4, int var5) {
      double var6 = 1.0D - this.getItemMargin() - var3.getLowerMargin() - var3.getUpperMargin();
      if(var4 > 1) {
         var6 -= var3.getCategoryMargin();
      }

      return var1 * var6 / (double)(var4 * var5);
   }

   protected void drawItemLabel(Graphics2D var1, CategoryDataset var2, int var3, int var4, CategoryPlot var5, CategoryItemLabelGenerator var6, Rectangle2D var7, boolean var8) {
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

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof BarRenderer)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         BarRenderer var2 = (BarRenderer)var1;
         return this.base != var2.base?false:(this.itemMargin != var2.itemMargin?false:(this.drawBarOutline != var2.drawBarOutline?false:(this.maximumBarWidth != var2.maximumBarWidth?false:(this.minimumBarLength != var2.minimumBarLength?false:(!ObjectUtilities.equal(this.gradientPaintTransformer, var2.gradientPaintTransformer)?false:(!ObjectUtilities.equal(this.positiveItemLabelPositionFallback, var2.positiveItemLabelPositionFallback)?false:ObjectUtilities.equal(this.negativeItemLabelPositionFallback, var2.negativeItemLabelPositionFallback)))))));
      }
   }
}
