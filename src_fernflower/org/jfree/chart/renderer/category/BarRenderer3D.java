package org.jfree.chart.renderer.category;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.ImageObserver;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.Effect3D;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class BarRenderer3D extends BarRenderer implements Serializable, Cloneable, Effect3D, PublicCloneable {
   private static final long serialVersionUID = 7686976503536003636L;
   public static final double DEFAULT_X_OFFSET = 12.0D;
   public static final double DEFAULT_Y_OFFSET = 8.0D;
   public static final Paint DEFAULT_WALL_PAINT = new Color(221, 221, 221);
   private double xOffset;
   private double yOffset;
   private transient Paint wallPaint;

   public BarRenderer3D() {
      this(12.0D, 8.0D);
   }

   public BarRenderer3D(double var1, double var3) {
      this.xOffset = var1;
      this.yOffset = var3;
      this.wallPaint = DEFAULT_WALL_PAINT;
      ItemLabelPosition var5 = new ItemLabelPosition(ItemLabelAnchor.INSIDE12, TextAnchor.TOP_CENTER);
      this.setPositiveItemLabelPosition(var5);
      ItemLabelPosition var6 = new ItemLabelPosition(ItemLabelAnchor.INSIDE12, TextAnchor.TOP_CENTER);
      this.setNegativeItemLabelPosition(var6);
   }

   public double getXOffset() {
      return this.xOffset;
   }

   public double getYOffset() {
      return this.yOffset;
   }

   public Paint getWallPaint() {
      return this.wallPaint;
   }

   public void setWallPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.wallPaint = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public CategoryItemRendererState initialise(Graphics2D var1, Rectangle2D var2, CategoryPlot var3, int var4, PlotRenderingInfo var5) {
      Double var6 = new Double(var2.getX(), var2.getY() + this.getYOffset(), var2.getWidth() - this.getXOffset(), var2.getHeight() - this.getYOffset());
      CategoryItemRendererState var7 = super.initialise(var1, var6, var3, var4, var5);
      return var7;
   }

   public void drawBackground(Graphics2D var1, CategoryPlot var2, Rectangle2D var3) {
      float var4 = (float)var3.getX();
      float var5 = var4 + (float)Math.abs(this.xOffset);
      float var6 = (float)var3.getMaxX();
      float var7 = var6 - (float)Math.abs(this.xOffset);
      float var8 = (float)var3.getMaxY();
      float var9 = var8 - (float)Math.abs(this.yOffset);
      float var10 = (float)var3.getMinY();
      float var11 = var10 + (float)Math.abs(this.yOffset);
      GeneralPath var12 = new GeneralPath();
      var12.moveTo(var4, var8);
      var12.lineTo(var4, var11);
      var12.lineTo(var5, var10);
      var12.lineTo(var6, var10);
      var12.lineTo(var6, var9);
      var12.lineTo(var7, var8);
      var12.closePath();
      Paint var13 = var2.getBackgroundPaint();
      if(var13 != null) {
         var1.setPaint(var13);
         var1.fill(var12);
      }

      GeneralPath var14 = new GeneralPath();
      var14.moveTo(var4, var8);
      var14.lineTo(var4, var11);
      var14.lineTo(var5, var10);
      var14.lineTo(var5, var9);
      var14.closePath();
      var1.setPaint(this.getWallPaint());
      var1.fill(var14);
      GeneralPath var15 = new GeneralPath();
      var15.moveTo(var4, var8);
      var15.lineTo(var5, var9);
      var15.lineTo(var6, var9);
      var15.lineTo(var7, var8);
      var15.closePath();
      var1.setPaint(this.getWallPaint());
      var1.fill(var15);
      var1.setPaint(Color.lightGray);
      java.awt.geom.Line2D.Double var16 = new java.awt.geom.Line2D.Double((double)var4, (double)var8, (double)var5, (double)var9);
      var1.draw(var16);
      var16.setLine((double)var5, (double)var9, (double)var5, (double)var10);
      var1.draw(var16);
      var16.setLine((double)var5, (double)var9, (double)var6, (double)var9);
      var1.draw(var16);
      Image var17 = var2.getBackgroundImage();
      if(var17 != null) {
         Composite var18 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(2, var2.getBackgroundAlpha()));
         var1.drawImage(var17, (int)var5, (int)var10, (int)(var6 - var5 + 1.0F), (int)(var9 - var10 + 1.0F), (ImageObserver)null);
         var1.setComposite(var18);
      }

   }

   public void drawOutline(Graphics2D var1, CategoryPlot var2, Rectangle2D var3) {
      float var4 = (float)var3.getX();
      float var5 = var4 + (float)Math.abs(this.xOffset);
      float var6 = (float)var3.getMaxX();
      float var7 = var6 - (float)Math.abs(this.xOffset);
      float var8 = (float)var3.getMaxY();
      float var9 = var8 - (float)Math.abs(this.yOffset);
      float var10 = (float)var3.getMinY();
      float var11 = var10 + (float)Math.abs(this.yOffset);
      GeneralPath var12 = new GeneralPath();
      var12.moveTo(var4, var8);
      var12.lineTo(var4, var11);
      var12.lineTo(var5, var10);
      var12.lineTo(var6, var10);
      var12.lineTo(var6, var9);
      var12.lineTo(var7, var8);
      var12.closePath();
      Stroke var13 = var2.getOutlineStroke();
      Paint var14 = var2.getOutlinePaint();
      if(var13 != null && var14 != null) {
         var1.setStroke(var13);
         var1.setPaint(var14);
         var1.draw(var12);
      }

   }

   public void drawDomainGridline(Graphics2D var1, CategoryPlot var2, Rectangle2D var3, double var4) {
      java.awt.geom.Line2D.Double var6 = null;
      java.awt.geom.Line2D.Double var7 = null;
      PlotOrientation var8 = var2.getOrientation();
      double var11;
      double var13;
      double var15;
      double var17;
      if(var8 == PlotOrientation.HORIZONTAL) {
         var11 = var4 - this.getYOffset();
         var13 = var3.getMinX();
         var15 = var13 + this.getXOffset();
         var17 = var3.getMaxX();
         var6 = new java.awt.geom.Line2D.Double(var13, var4, var15, var11);
         var7 = new java.awt.geom.Line2D.Double(var15, var11, var17, var11);
      } else if(var8 == PlotOrientation.VERTICAL) {
         var11 = var4 + this.getXOffset();
         var13 = var3.getMaxY();
         var15 = var13 - this.getYOffset();
         var17 = var3.getMinY();
         var6 = new java.awt.geom.Line2D.Double(var4, var13, var11, var15);
         var7 = new java.awt.geom.Line2D.Double(var11, var15, var11, var17);
      }

      Paint var9 = var2.getDomainGridlinePaint();
      Stroke var10 = var2.getDomainGridlineStroke();
      var1.setPaint(var9 != null?var9:Plot.DEFAULT_OUTLINE_PAINT);
      var1.setStroke(var10 != null?var10:Plot.DEFAULT_OUTLINE_STROKE);
      var1.draw(var6);
      var1.draw(var7);
   }

   public void drawRangeGridline(Graphics2D var1, CategoryPlot var2, ValueAxis var3, Rectangle2D var4, double var5) {
      Range var7 = var3.getRange();
      if(var7.contains(var5)) {
         Double var8 = new Double(var4.getX(), var4.getY() + this.getYOffset(), var4.getWidth() - this.getXOffset(), var4.getHeight() - this.getYOffset());
         java.awt.geom.Line2D.Double var9 = null;
         java.awt.geom.Line2D.Double var10 = null;
         PlotOrientation var11 = var2.getOrientation();
         double var12;
         double var14;
         double var16;
         double var18;
         double var20;
         if(var11 == PlotOrientation.HORIZONTAL) {
            var12 = var3.valueToJava2D(var5, var8, var2.getRangeAxisEdge());
            var14 = var12 + this.getXOffset();
            var16 = var4.getMaxY();
            var18 = var16 - this.getYOffset();
            var20 = var4.getMinY();
            var9 = new java.awt.geom.Line2D.Double(var12, var16, var14, var18);
            var10 = new java.awt.geom.Line2D.Double(var14, var18, var14, var20);
         } else if(var11 == PlotOrientation.VERTICAL) {
            var12 = var3.valueToJava2D(var5, var8, var2.getRangeAxisEdge());
            var14 = var12 - this.getYOffset();
            var16 = var4.getMinX();
            var18 = var16 + this.getXOffset();
            var20 = var4.getMaxX();
            var9 = new java.awt.geom.Line2D.Double(var16, var12, var18, var14);
            var10 = new java.awt.geom.Line2D.Double(var18, var14, var20, var14);
         }

         Paint var22 = var2.getRangeGridlinePaint();
         Stroke var13 = var2.getRangeGridlineStroke();
         var1.setPaint(var22 != null?var22:Plot.DEFAULT_OUTLINE_PAINT);
         var1.setStroke(var13 != null?var13:Plot.DEFAULT_OUTLINE_STROKE);
         var1.draw(var9);
         var1.draw(var10);
      }
   }

   public void drawRangeMarker(Graphics2D var1, CategoryPlot var2, ValueAxis var3, Marker var4, Rectangle2D var5) {
      if(var4 instanceof ValueMarker) {
         ValueMarker var6 = (ValueMarker)var4;
         double var7 = var6.getValue();
         Range var9 = var3.getRange();
         if(!var9.contains(var7)) {
            return;
         }

         Double var10 = new Double(var5.getX(), var5.getY() + this.getYOffset(), var5.getWidth() - this.getXOffset(), var5.getHeight() - this.getYOffset());
         GeneralPath var11 = null;
         PlotOrientation var12 = var2.getOrientation();
         float var13;
         float var14;
         if(var12 == PlotOrientation.HORIZONTAL) {
            var13 = (float)var3.valueToJava2D(var7, var10, var2.getRangeAxisEdge());
            var14 = (float)var10.getMaxY();
            var11 = new GeneralPath();
            var11.moveTo(var13, var14);
            var11.lineTo((float)((double)var13 + this.getXOffset()), var14 - (float)this.getYOffset());
            var11.lineTo((float)((double)var13 + this.getXOffset()), (float)(var10.getMinY() - this.getYOffset()));
            var11.lineTo(var13, (float)var10.getMinY());
            var11.closePath();
         } else if(var12 == PlotOrientation.VERTICAL) {
            var13 = (float)var3.valueToJava2D(var7, var10, var2.getRangeAxisEdge());
            var14 = (float)var5.getX();
            var11 = new GeneralPath();
            var11.moveTo(var14, var13);
            var11.lineTo(var14 + (float)this.xOffset, var13 - (float)this.yOffset);
            var11.lineTo((float)(var10.getMaxX() + this.xOffset), var13 - (float)this.yOffset);
            var11.lineTo((float)var10.getMaxX(), var13);
            var11.closePath();
         }

         var1.setPaint(var4.getPaint());
         var1.fill(var11);
         var1.setPaint(var4.getOutlinePaint());
         var1.draw(var11);
         String var17 = var4.getLabel();
         RectangleAnchor var18 = var4.getLabelAnchor();
         if(var17 != null) {
            Font var15 = var4.getLabelFont();
            var1.setFont(var15);
            var1.setPaint(var4.getLabelPaint());
            Point2D var16 = this.calculateRangeMarkerTextAnchorPoint(var1, var12, var5, var11.getBounds2D(), var4.getLabelOffset(), LengthAdjustmentType.EXPAND, var18);
            TextUtilities.drawAlignedString(var17, var1, (float)var16.getX(), (float)var16.getY(), var4.getLabelTextAnchor());
         }
      } else {
         super.drawRangeMarker(var1, var2, var3, var4, var5);
      }

   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      Number var11 = var7.getValue(var8, var9);
      if(var11 != null) {
         double var12 = var11.doubleValue();
         Double var14 = new Double(var3.getX(), var3.getY() + this.getYOffset(), var3.getWidth() - this.getXOffset(), var3.getHeight() - this.getYOffset());
         PlotOrientation var15 = var4.getOrientation();
         double var16 = this.calculateBarW0(var4, var15, var14, var5, var2, var8, var9);
         double[] var18 = this.calculateBarL0L1(var12);
         if(var18 != null) {
            RectangleEdge var19 = var4.getRangeAxisEdge();
            double var20 = var6.valueToJava2D(var18[0], var14, var19);
            double var22 = var6.valueToJava2D(var18[1], var14, var19);
            double var24 = Math.min(var20, var22);
            double var26 = Math.abs(var22 - var20);
            Double var28 = null;
            if(var15 == PlotOrientation.HORIZONTAL) {
               var28 = new Double(var24, var16, var26, var2.getBarWidth());
            } else {
               var28 = new Double(var16, var24, var2.getBarWidth(), var26);
            }

            Paint var29 = this.getItemPaint(var8, var9);
            var1.setPaint(var29);
            var1.fill(var28);
            double var30 = var28.getMinX();
            double var32 = var30 + this.getXOffset();
            double var34 = var28.getMaxX();
            double var36 = var34 + this.getXOffset();
            double var38 = var28.getMinY() - this.getYOffset();
            double var40 = var28.getMinY();
            double var42 = var28.getMaxY() - this.getYOffset();
            double var44 = var28.getMaxY();
            GeneralPath var46 = null;
            GeneralPath var47 = null;
            if(var26 > 0.0D) {
               var46 = new GeneralPath();
               var46.moveTo((float)var34, (float)var44);
               var46.lineTo((float)var34, (float)var40);
               var46.lineTo((float)var36, (float)var38);
               var46.lineTo((float)var36, (float)var42);
               var46.closePath();
               if(var29 instanceof Color) {
                  var1.setPaint(((Color)var29).darker());
               }

               var1.fill(var46);
            }

            var47 = new GeneralPath();
            var47.moveTo((float)var30, (float)var40);
            var47.lineTo((float)var32, (float)var38);
            var47.lineTo((float)var36, (float)var38);
            var47.lineTo((float)var34, (float)var40);
            var47.closePath();
            var1.fill(var47);
            if(this.isDrawBarOutline() && var2.getBarWidth() > 3.0D) {
               var1.setStroke(this.getItemOutlineStroke(var8, var9));
               var1.setPaint(this.getItemOutlinePaint(var8, var9));
               var1.draw(var28);
               if(var46 != null) {
                  var1.draw(var46);
               }

               if(var47 != null) {
                  var1.draw(var47);
               }
            }

            CategoryItemLabelGenerator var48 = this.getItemLabelGenerator(var8, var9);
            if(var48 != null && this.isItemLabelVisible(var8, var9)) {
               this.drawItemLabel(var1, var7, var8, var9, var4, var48, var28, var12 < 0.0D);
            }

            EntityCollection var49 = var2.getEntityCollection();
            if(var49 != null) {
               GeneralPath var50 = new GeneralPath();
               var50.moveTo((float)var30, (float)var44);
               var50.lineTo((float)var30, (float)var40);
               var50.lineTo((float)var32, (float)var38);
               var50.lineTo((float)var36, (float)var38);
               var50.lineTo((float)var36, (float)var42);
               var50.lineTo((float)var34, (float)var44);
               var50.closePath();
               this.addItemEntity(var49, var7, var8, var9, var50);
            }

         }
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof BarRenderer3D)) {
         return false;
      } else {
         BarRenderer3D var2 = (BarRenderer3D)var1;
         return this.xOffset != var2.xOffset?false:(this.yOffset != var2.yOffset?false:(!PaintUtilities.equal(this.wallPaint, var2.wallPaint)?false:super.equals(var1)));
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.wallPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.wallPaint = SerialUtilities.readPaint(var1);
   }
}
