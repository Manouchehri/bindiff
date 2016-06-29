package org.jfree.chart.title;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.event.TitleChangeEvent;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.chart.title.Title;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.Size2D;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class PaintScaleLegend extends Title implements PublicCloneable {
   private PaintScale scale;
   private ValueAxis axis;
   private AxisLocation axisLocation;
   private double axisOffset;
   private double stripWidth;
   private boolean stripOutlineVisible;
   private transient Paint stripOutlinePaint;
   private transient Stroke stripOutlineStroke;
   private transient Paint backgroundPaint;
   private static final int SUBDIVISIONS = 200;

   public PaintScaleLegend(PaintScale var1, ValueAxis var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'axis\' argument.");
      } else {
         this.scale = var1;
         this.axis = var2;
         this.axisLocation = AxisLocation.BOTTOM_OR_LEFT;
         this.axisOffset = 0.0D;
         this.stripWidth = 15.0D;
         this.stripOutlineVisible = false;
         this.stripOutlinePaint = Color.gray;
         this.stripOutlineStroke = new BasicStroke(0.5F);
         this.backgroundPaint = Color.white;
      }
   }

   public PaintScale getScale() {
      return this.scale;
   }

   public void setScale(PaintScale var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'scale\' argument.");
      } else {
         this.scale = var1;
         this.notifyListeners(new TitleChangeEvent(this));
      }
   }

   public ValueAxis getAxis() {
      return this.axis;
   }

   public void setAxis(ValueAxis var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'axis\' argument.");
      } else {
         this.axis = var1;
         this.notifyListeners(new TitleChangeEvent(this));
      }
   }

   public AxisLocation getAxisLocation() {
      return this.axisLocation;
   }

   public void setAxisLocation(AxisLocation var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'location\' argument.");
      } else {
         this.axisLocation = var1;
         this.notifyListeners(new TitleChangeEvent(this));
      }
   }

   public double getAxisOffset() {
      return this.axisOffset;
   }

   public void setAxisOffset(double var1) {
      this.axisOffset = var1;
      this.notifyListeners(new TitleChangeEvent(this));
   }

   public double getStripWidth() {
      return this.stripWidth;
   }

   public void setStripWidth(double var1) {
      this.stripWidth = var1;
      this.notifyListeners(new TitleChangeEvent(this));
   }

   public boolean isStripOutlineVisible() {
      return this.stripOutlineVisible;
   }

   public void setStripOutlineVisible(boolean var1) {
      this.stripOutlineVisible = var1;
      this.notifyListeners(new TitleChangeEvent(this));
   }

   public Paint getStripOutlinePaint() {
      return this.stripOutlinePaint;
   }

   public void setStripOutlinePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.stripOutlinePaint = var1;
         this.notifyListeners(new TitleChangeEvent(this));
      }
   }

   public Stroke getStripOutlineStroke() {
      return this.stripOutlineStroke;
   }

   public void setStripOutlineStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.stripOutlineStroke = var1;
         this.notifyListeners(new TitleChangeEvent(this));
      }
   }

   public Paint getBackgroundPaint() {
      return this.backgroundPaint;
   }

   public void setBackgroundPaint(Paint var1) {
      this.backgroundPaint = var1;
      this.notifyListeners(new TitleChangeEvent(this));
   }

   public Size2D arrange(Graphics2D var1, RectangleConstraint var2) {
      RectangleConstraint var3 = this.toContentConstraint(var2);
      LengthConstraintType var4 = var3.getWidthConstraintType();
      LengthConstraintType var5 = var3.getHeightConstraintType();
      Size2D var6 = null;
      if(var4 == LengthConstraintType.NONE) {
         if(var5 == LengthConstraintType.NONE) {
            var6 = new Size2D(this.getWidth(), this.getHeight());
         } else {
            if(var5 == LengthConstraintType.RANGE) {
               throw new RuntimeException("Not yet implemented.");
            }

            if(var5 == LengthConstraintType.FIXED) {
               throw new RuntimeException("Not yet implemented.");
            }
         }
      } else if(var4 == LengthConstraintType.RANGE) {
         if(var5 == LengthConstraintType.NONE) {
            throw new RuntimeException("Not yet implemented.");
         }

         if(var5 == LengthConstraintType.RANGE) {
            var6 = this.arrangeRR(var1, var3.getWidthRange(), var3.getHeightRange());
         } else if(var5 == LengthConstraintType.FIXED) {
            throw new RuntimeException("Not yet implemented.");
         }
      } else if(var4 == LengthConstraintType.FIXED) {
         if(var5 == LengthConstraintType.NONE) {
            throw new RuntimeException("Not yet implemented.");
         }

         if(var5 == LengthConstraintType.RANGE) {
            throw new RuntimeException("Not yet implemented.");
         }

         if(var5 == LengthConstraintType.FIXED) {
            throw new RuntimeException("Not yet implemented.");
         }
      }

      return new Size2D(this.calculateTotalWidth(var6.getWidth()), this.calculateTotalHeight(var6.getHeight()));
   }

   protected Size2D arrangeRR(Graphics2D var1, Range var2, Range var3) {
      RectangleEdge var4 = this.getPosition();
      float var5;
      AxisSpace var6;
      if(var4 != RectangleEdge.TOP && var4 != RectangleEdge.BOTTOM) {
         if(var4 != RectangleEdge.LEFT && var4 != RectangleEdge.RIGHT) {
            throw new RuntimeException("Unrecognised position.");
         } else {
            var5 = (float)var3.getUpperBound();
            var6 = this.axis.reserveSpace(var1, (Plot)null, new Double(0.0D, 0.0D, 100.0D, (double)var5), RectangleEdge.RIGHT, (AxisSpace)null);
            return new Size2D(this.stripWidth + this.axisOffset + var6.getLeft() + var6.getRight(), (double)var5);
         }
      } else {
         var5 = (float)var2.getUpperBound();
         var6 = this.axis.reserveSpace(var1, (Plot)null, new Double(0.0D, 0.0D, (double)var5, 100.0D), RectangleEdge.BOTTOM, (AxisSpace)null);
         return new Size2D((double)var5, this.stripWidth + this.axisOffset + var6.getTop() + var6.getBottom());
      }
   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
      this.draw(var1, var2, (Object)null);
   }

   public Object draw(Graphics2D var1, Rectangle2D var2, Object var3) {
      Rectangle2D var4 = (Rectangle2D)var2.clone();
      var4 = this.trimMargin(var4);
      if(this.backgroundPaint != null) {
         var1.setPaint(this.backgroundPaint);
         var1.fill(var4);
      }

      this.getBorder().draw(var1, var4);
      this.getBorder().getInsets().trim(var4);
      var4 = this.trimPadding(var4);
      double var5 = this.axis.getLowerBound();
      double var7 = this.axis.getRange().getLength() / 200.0D;
      Double var9 = new Double();
      RectangleEdge var10;
      double var11;
      int var13;
      double var14;
      Paint var16;
      double var17;
      if(RectangleEdge.isTopOrBottom(this.getPosition())) {
         var10 = Plot.resolveRangeAxisLocation(this.axisLocation, PlotOrientation.HORIZONTAL);
         var11 = Math.ceil(var4.getWidth() / 200.0D);
         if(var10 == RectangleEdge.TOP) {
            for(var13 = 0; var13 < 200; ++var13) {
               var14 = var5 + (double)var13 * var7;
               var16 = this.scale.getPaint(var14);
               var17 = this.axis.valueToJava2D(var14, var4, RectangleEdge.BOTTOM);
               var9.setRect(var17, var4.getMaxY() - this.stripWidth, var11, this.stripWidth);
               var1.setPaint(var16);
               var1.fill(var9);
            }

            var1.setPaint(this.stripOutlinePaint);
            var1.setStroke(this.stripOutlineStroke);
            var1.draw(new Double(var4.getMinX(), var4.getMaxY() - this.stripWidth, var4.getWidth(), this.stripWidth));
            this.axis.draw(var1, var4.getMaxY() - this.stripWidth - this.axisOffset, var4, var4, RectangleEdge.TOP, (PlotRenderingInfo)null);
         } else if(var10 == RectangleEdge.BOTTOM) {
            for(var13 = 0; var13 < 200; ++var13) {
               var14 = var5 + (double)var13 * var7;
               var16 = this.scale.getPaint(var14);
               var17 = this.axis.valueToJava2D(var14, var4, RectangleEdge.BOTTOM);
               var9.setRect(var17, var4.getMinY(), var11, this.stripWidth);
               var1.setPaint(var16);
               var1.fill(var9);
            }

            var1.setPaint(this.stripOutlinePaint);
            var1.setStroke(this.stripOutlineStroke);
            var1.draw(new Double(var4.getMinX(), var4.getMinY(), var4.getWidth(), this.stripWidth));
            this.axis.draw(var1, var4.getMinY() + this.stripWidth + this.axisOffset, var4, var4, RectangleEdge.BOTTOM, (PlotRenderingInfo)null);
         }
      } else {
         var10 = Plot.resolveRangeAxisLocation(this.axisLocation, PlotOrientation.VERTICAL);
         var11 = Math.ceil(var4.getHeight() / 200.0D);
         if(var10 == RectangleEdge.LEFT) {
            for(var13 = 0; var13 < 200; ++var13) {
               var14 = var5 + (double)var13 * var7;
               var16 = this.scale.getPaint(var14);
               var17 = this.axis.valueToJava2D(var14, var4, RectangleEdge.LEFT);
               var9.setRect(var4.getMaxX() - this.stripWidth, var17 - var11, this.stripWidth, var11);
               var1.setPaint(var16);
               var1.fill(var9);
            }

            var1.setPaint(this.stripOutlinePaint);
            var1.setStroke(this.stripOutlineStroke);
            var1.draw(new Double(var4.getMaxX() - this.stripWidth, var4.getMinY(), this.stripWidth, var4.getHeight()));
            this.axis.draw(var1, var4.getMaxX() - this.stripWidth - this.axisOffset, var4, var4, RectangleEdge.LEFT, (PlotRenderingInfo)null);
         } else if(var10 == RectangleEdge.RIGHT) {
            for(var13 = 0; var13 < 200; ++var13) {
               var14 = var5 + (double)var13 * var7;
               var16 = this.scale.getPaint(var14);
               var17 = this.axis.valueToJava2D(var14, var4, RectangleEdge.LEFT);
               var9.setRect(var4.getMinX(), var17 - var11, this.stripWidth, var11);
               var1.setPaint(var16);
               var1.fill(var9);
            }

            var1.setPaint(this.stripOutlinePaint);
            var1.setStroke(this.stripOutlineStroke);
            var1.draw(new Double(var4.getMinX(), var4.getMinY(), this.stripWidth, var4.getHeight()));
            this.axis.draw(var1, var4.getMinX() + this.stripWidth + this.axisOffset, var4, var4, RectangleEdge.RIGHT, (PlotRenderingInfo)null);
         }
      }

      return null;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof PaintScaleLegend)) {
         return false;
      } else {
         PaintScaleLegend var2 = (PaintScaleLegend)var1;
         return !this.scale.equals(var2.scale)?false:(!this.axis.equals(var2.axis)?false:(!this.axisLocation.equals(var2.axisLocation)?false:(this.axisOffset != var2.axisOffset?false:(this.stripWidth != var2.stripWidth?false:(this.stripOutlineVisible != var2.stripOutlineVisible?false:(!PaintUtilities.equal(this.stripOutlinePaint, var2.stripOutlinePaint)?false:(!this.stripOutlineStroke.equals(var2.stripOutlineStroke)?false:(!PaintUtilities.equal(this.backgroundPaint, var2.backgroundPaint)?false:super.equals(var1)))))))));
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.backgroundPaint, var1);
      SerialUtilities.writePaint(this.stripOutlinePaint, var1);
      SerialUtilities.writeStroke(this.stripOutlineStroke, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.backgroundPaint = SerialUtilities.readPaint(var1);
      this.stripOutlinePaint = SerialUtilities.readPaint(var1);
      this.stripOutlineStroke = SerialUtilities.readStroke(var1);
   }
}
