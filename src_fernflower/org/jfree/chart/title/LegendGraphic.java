package org.jfree.chart.title;

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
import org.jfree.chart.block.AbstractBlock;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.Size2D;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class LegendGraphic extends AbstractBlock implements Block, PublicCloneable {
   private boolean shapeVisible;
   private transient Shape shape;
   private RectangleAnchor shapeLocation;
   private RectangleAnchor shapeAnchor;
   private boolean shapeFilled;
   private transient Paint fillPaint;
   private GradientPaintTransformer fillPaintTransformer;
   private boolean shapeOutlineVisible;
   private transient Paint outlinePaint;
   private transient Stroke outlineStroke;
   private boolean lineVisible;
   private transient Shape line;
   private transient Stroke lineStroke;
   private transient Paint linePaint;

   public LegendGraphic(Shape var1, Paint var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'shape\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'fillPaint\' argument.");
      } else {
         this.shapeVisible = true;
         this.shape = var1;
         this.shapeAnchor = RectangleAnchor.CENTER;
         this.shapeLocation = RectangleAnchor.CENTER;
         this.shapeFilled = true;
         this.fillPaint = var2;
         this.fillPaintTransformer = new StandardGradientPaintTransformer();
         this.setPadding(2.0D, 2.0D, 2.0D, 2.0D);
      }
   }

   public boolean isShapeVisible() {
      return this.shapeVisible;
   }

   public void setShapeVisible(boolean var1) {
      this.shapeVisible = var1;
   }

   public Shape getShape() {
      return this.shape;
   }

   public void setShape(Shape var1) {
      this.shape = var1;
   }

   public boolean isShapeFilled() {
      return this.shapeFilled;
   }

   public void setShapeFilled(boolean var1) {
      this.shapeFilled = var1;
   }

   public Paint getFillPaint() {
      return this.fillPaint;
   }

   public void setFillPaint(Paint var1) {
      this.fillPaint = var1;
   }

   public GradientPaintTransformer getFillPaintTransformer() {
      return this.fillPaintTransformer;
   }

   public void setFillPaintTransformer(GradientPaintTransformer var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'transformer\' argument.");
      } else {
         this.fillPaintTransformer = var1;
      }
   }

   public boolean isShapeOutlineVisible() {
      return this.shapeOutlineVisible;
   }

   public void setShapeOutlineVisible(boolean var1) {
      this.shapeOutlineVisible = var1;
   }

   public Paint getOutlinePaint() {
      return this.outlinePaint;
   }

   public void setOutlinePaint(Paint var1) {
      this.outlinePaint = var1;
   }

   public Stroke getOutlineStroke() {
      return this.outlineStroke;
   }

   public void setOutlineStroke(Stroke var1) {
      this.outlineStroke = var1;
   }

   public RectangleAnchor getShapeAnchor() {
      return this.shapeAnchor;
   }

   public void setShapeAnchor(RectangleAnchor var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'anchor\' argument.");
      } else {
         this.shapeAnchor = var1;
      }
   }

   public RectangleAnchor getShapeLocation() {
      return this.shapeLocation;
   }

   public void setShapeLocation(RectangleAnchor var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'location\' argument.");
      } else {
         this.shapeLocation = var1;
      }
   }

   public boolean isLineVisible() {
      return this.lineVisible;
   }

   public void setLineVisible(boolean var1) {
      this.lineVisible = var1;
   }

   public Shape getLine() {
      return this.line;
   }

   public void setLine(Shape var1) {
      this.line = var1;
   }

   public Paint getLinePaint() {
      return this.linePaint;
   }

   public void setLinePaint(Paint var1) {
      this.linePaint = var1;
   }

   public Stroke getLineStroke() {
      return this.lineStroke;
   }

   public void setLineStroke(Stroke var1) {
      this.lineStroke = var1;
   }

   public Size2D arrange(Graphics2D var1, RectangleConstraint var2) {
      RectangleConstraint var3 = this.toContentConstraint(var2);
      LengthConstraintType var4 = var3.getWidthConstraintType();
      LengthConstraintType var5 = var3.getHeightConstraintType();
      Size2D var6 = null;
      if(var4 == LengthConstraintType.NONE) {
         if(var5 == LengthConstraintType.NONE) {
            var6 = this.arrangeNN(var1);
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
            throw new RuntimeException("Not yet implemented.");
         }

         if(var5 == LengthConstraintType.FIXED) {
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
            var6 = new Size2D(var3.getWidth(), var3.getHeight());
         }
      }

      return new Size2D(this.calculateTotalWidth(var6.getWidth()), this.calculateTotalHeight(var6.getHeight()));
   }

   protected Size2D arrangeNN(Graphics2D var1) {
      Object var2 = new Double();
      if(this.line != null) {
         ((Rectangle2D)var2).setRect(this.line.getBounds2D());
      }

      if(this.shape != null) {
         var2 = ((Rectangle2D)var2).createUnion(this.shape.getBounds2D());
      }

      return new Size2D(((Rectangle2D)var2).getWidth(), ((Rectangle2D)var2).getHeight());
   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
      var2 = this.trimMargin(var2);
      this.drawBorder(var1, var2);
      var2 = this.trimBorder(var2);
      var2 = this.trimPadding(var2);
      Point2D var3;
      Shape var4;
      if(this.lineVisible) {
         var3 = RectangleAnchor.coordinates(var2, this.shapeLocation);
         var4 = ShapeUtilities.createTranslatedShape(this.getLine(), this.shapeAnchor, var3.getX(), var3.getY());
         var1.setPaint(this.linePaint);
         var1.setStroke(this.lineStroke);
         var1.draw(var4);
      }

      if(this.shapeVisible) {
         var3 = RectangleAnchor.coordinates(var2, this.shapeLocation);
         var4 = ShapeUtilities.createTranslatedShape(this.shape, this.shapeAnchor, var3.getX(), var3.getY());
         if(this.shapeFilled) {
            Object var5 = this.fillPaint;
            if(var5 instanceof GradientPaint) {
               GradientPaint var6 = (GradientPaint)this.fillPaint;
               var5 = this.fillPaintTransformer.transform(var6, var4);
            }

            var1.setPaint((Paint)var5);
            var1.fill(var4);
         }

         if(this.shapeOutlineVisible) {
            var1.setPaint(this.outlinePaint);
            var1.setStroke(this.outlineStroke);
            var1.draw(var4);
         }
      }

   }

   public Object draw(Graphics2D var1, Rectangle2D var2, Object var3) {
      this.draw(var1, var2);
      return null;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof LegendGraphic)) {
         return false;
      } else {
         LegendGraphic var2 = (LegendGraphic)var1;
         return this.shapeVisible != var2.shapeVisible?false:(!ShapeUtilities.equal(this.shape, var2.shape)?false:(this.shapeFilled != var2.shapeFilled?false:(!PaintUtilities.equal(this.fillPaint, var2.fillPaint)?false:(!ObjectUtilities.equal(this.fillPaintTransformer, var2.fillPaintTransformer)?false:(this.shapeOutlineVisible != var2.shapeOutlineVisible?false:(!PaintUtilities.equal(this.outlinePaint, var2.outlinePaint)?false:(!ObjectUtilities.equal(this.outlineStroke, var2.outlineStroke)?false:(this.shapeAnchor != var2.shapeAnchor?false:(this.shapeLocation != var2.shapeLocation?false:(this.lineVisible != var2.lineVisible?false:(!ShapeUtilities.equal(this.line, var2.line)?false:(!PaintUtilities.equal(this.linePaint, var2.linePaint)?false:(!ObjectUtilities.equal(this.lineStroke, var2.lineStroke)?false:super.equals(var1))))))))))))));
      }
   }

   public int hashCode() {
      short var1 = 193;
      int var2 = 37 * var1 + ObjectUtilities.hashCode(this.fillPaint);
      return var2;
   }

   public Object clone() {
      LegendGraphic var1 = (LegendGraphic)super.clone();
      var1.shape = ShapeUtilities.clone(this.shape);
      var1.line = ShapeUtilities.clone(this.line);
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeShape(this.shape, var1);
      SerialUtilities.writePaint(this.fillPaint, var1);
      SerialUtilities.writePaint(this.outlinePaint, var1);
      SerialUtilities.writeStroke(this.outlineStroke, var1);
      SerialUtilities.writeShape(this.line, var1);
      SerialUtilities.writePaint(this.linePaint, var1);
      SerialUtilities.writeStroke(this.lineStroke, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.shape = SerialUtilities.readShape(var1);
      this.fillPaint = SerialUtilities.readPaint(var1);
      this.outlinePaint = SerialUtilities.readPaint(var1);
      this.outlineStroke = SerialUtilities.readStroke(var1);
      this.line = SerialUtilities.readShape(var1);
      this.linePaint = SerialUtilities.readPaint(var1);
      this.lineStroke = SerialUtilities.readStroke(var1);
   }
}
