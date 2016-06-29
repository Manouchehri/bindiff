package org.jfree.chart.renderer.category;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.awt.image.ImageObserver;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.Effect3D;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.ShapeUtilities;

public class LineRenderer3D extends LineAndShapeRenderer implements Serializable, Effect3D {
   private static final long serialVersionUID = 5467931468380928736L;
   public static final double DEFAULT_X_OFFSET = 12.0D;
   public static final double DEFAULT_Y_OFFSET = 8.0D;
   public static final Paint DEFAULT_WALL_PAINT = new Color(221, 221, 221);
   private double xOffset = 12.0D;
   private double yOffset = 8.0D;
   private transient Paint wallPaint;

   public LineRenderer3D() {
      super(true, false);
      this.wallPaint = DEFAULT_WALL_PAINT;
   }

   public double getXOffset() {
      return this.xOffset;
   }

   public double getYOffset() {
      return this.yOffset;
   }

   public void setXOffset(double var1) {
      this.xOffset = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public void setYOffset(double var1) {
      this.yOffset = var1;
      this.notifyListeners(new RendererChangeEvent(this));
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
      Double var16 = new Double((double)var4, (double)var8, (double)var5, (double)var9);
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
      Double var6 = null;
      Double var7 = null;
      PlotOrientation var8 = var2.getOrientation();
      double var17;
      double var11;
      double var13;
      double var15;
      if(var8 == PlotOrientation.HORIZONTAL) {
         var11 = var4 - this.getYOffset();
         var13 = var3.getMinX();
         var15 = var13 + this.getXOffset();
         var17 = var3.getMaxX();
         var6 = new Double(var13, var4, var15, var11);
         var7 = new Double(var15, var11, var17, var11);
      } else if(var8 == PlotOrientation.VERTICAL) {
         var11 = var4 + this.getXOffset();
         var13 = var3.getMaxY();
         var15 = var13 - this.getYOffset();
         var17 = var3.getMinY();
         var6 = new Double(var4, var13, var11, var15);
         var7 = new Double(var11, var15, var11, var17);
      }

      var1.setPaint(var2.getDomainGridlinePaint());
      var1.setStroke(var2.getDomainGridlineStroke());
      var1.draw(var6);
      var1.draw(var7);
   }

   public void drawRangeGridline(Graphics2D var1, CategoryPlot var2, ValueAxis var3, Rectangle2D var4, double var5) {
      Range var7 = var3.getRange();
      if(var7.contains(var5)) {
         java.awt.geom.Rectangle2D.Double var8 = new java.awt.geom.Rectangle2D.Double(var4.getX(), var4.getY() + this.getYOffset(), var4.getWidth() - this.getXOffset(), var4.getHeight() - this.getYOffset());
         Double var9 = null;
         Double var10 = null;
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
            var9 = new Double(var12, var16, var14, var18);
            var10 = new Double(var14, var18, var14, var20);
         } else if(var11 == PlotOrientation.VERTICAL) {
            var12 = var3.valueToJava2D(var5, var8, var2.getRangeAxisEdge());
            var14 = var12 - this.getYOffset();
            var16 = var4.getMinX();
            var18 = var16 + this.getXOffset();
            var20 = var4.getMaxX();
            var9 = new Double(var16, var12, var18, var14);
            var10 = new Double(var18, var14, var20, var14);
         }

         var1.setPaint(var2.getRangeGridlinePaint());
         var1.setStroke(var2.getRangeGridlineStroke());
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

         java.awt.geom.Rectangle2D.Double var10 = new java.awt.geom.Rectangle2D.Double(var5.getX(), var5.getY() + this.getYOffset(), var5.getWidth() - this.getXOffset(), var5.getHeight() - this.getYOffset());
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
      }

   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      if(this.getItemVisible(var8, var9)) {
         Number var11 = var7.getValue(var8, var9);
         if(var11 != null) {
            java.awt.geom.Rectangle2D.Double var12 = new java.awt.geom.Rectangle2D.Double(var3.getX(), var3.getY() + this.getYOffset(), var3.getWidth() - this.getXOffset(), var3.getHeight() - this.getYOffset());
            PlotOrientation var13 = var4.getOrientation();
            double var14 = var5.getCategoryMiddle(var9, this.getColumnCount(), var12, var4.getDomainAxisEdge());
            double var16 = var11.doubleValue();
            double var18 = var6.valueToJava2D(var16, var12, var4.getRangeAxisEdge());
            Shape var20 = this.getItemShape(var8, var9);
            if(var13 == PlotOrientation.HORIZONTAL) {
               var20 = ShapeUtilities.createTranslatedShape(var20, var18, var14);
            } else if(var13 == PlotOrientation.VERTICAL) {
               var20 = ShapeUtilities.createTranslatedShape(var20, var14, var18);
            }

            if(this.getItemLineVisible(var8, var9) && var9 != 0) {
               Number var21 = var7.getValue(var8, var9 - 1);
               if(var21 != null) {
                  double var22 = var21.doubleValue();
                  double var24 = var5.getCategoryMiddle(var9 - 1, this.getColumnCount(), var12, var4.getDomainAxisEdge());
                  double var26 = var6.valueToJava2D(var22, var12, var4.getRangeAxisEdge());
                  double var28 = var24 + this.getXOffset();
                  double var30 = var26 - this.getYOffset();
                  double var32 = var14 + this.getXOffset();
                  double var34 = var18 - this.getYOffset();
                  GeneralPath var36 = new GeneralPath();
                  if(var13 == PlotOrientation.HORIZONTAL) {
                     var36.moveTo((float)var26, (float)var24);
                     var36.lineTo((float)var18, (float)var14);
                     var36.lineTo((float)var34, (float)var32);
                     var36.lineTo((float)var30, (float)var28);
                     var36.lineTo((float)var26, (float)var24);
                     var36.closePath();
                  } else if(var13 == PlotOrientation.VERTICAL) {
                     var36.moveTo((float)var24, (float)var26);
                     var36.lineTo((float)var14, (float)var18);
                     var36.lineTo((float)var32, (float)var34);
                     var36.lineTo((float)var28, (float)var30);
                     var36.lineTo((float)var24, (float)var26);
                     var36.closePath();
                  }

                  var1.setPaint(this.getItemPaint(var8, var9));
                  var1.fill(var36);
                  var1.setStroke(this.getItemOutlineStroke(var8, var9));
                  var1.setPaint(this.getItemOutlinePaint(var8, var9));
                  var1.draw(var36);
               }
            }

            if(this.isItemLabelVisible(var8, var9)) {
               this.drawItemLabel(var1, var13, var7, var8, var9, var14, var18, var16 < 0.0D);
            }

            EntityCollection var37 = var2.getEntityCollection();
            if(var37 != null) {
               this.addItemEntity(var37, var7, var8, var9, var20);
            }

         }
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof LineRenderer3D)) {
         return false;
      } else {
         LineRenderer3D var2 = (LineRenderer3D)var1;
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
