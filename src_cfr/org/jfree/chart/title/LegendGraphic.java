/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.title;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
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

public class LegendGraphic
extends AbstractBlock
implements Block,
PublicCloneable {
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

    public LegendGraphic(Shape shape, Paint paint) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'fillPaint' argument.");
        }
        this.shapeVisible = true;
        this.shape = shape;
        this.shapeAnchor = RectangleAnchor.CENTER;
        this.shapeLocation = RectangleAnchor.CENTER;
        this.shapeFilled = true;
        this.fillPaint = paint;
        this.fillPaintTransformer = new StandardGradientPaintTransformer();
        this.setPadding(2.0, 2.0, 2.0, 2.0);
    }

    public boolean isShapeVisible() {
        return this.shapeVisible;
    }

    public void setShapeVisible(boolean bl2) {
        this.shapeVisible = bl2;
    }

    public Shape getShape() {
        return this.shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public boolean isShapeFilled() {
        return this.shapeFilled;
    }

    public void setShapeFilled(boolean bl2) {
        this.shapeFilled = bl2;
    }

    public Paint getFillPaint() {
        return this.fillPaint;
    }

    public void setFillPaint(Paint paint) {
        this.fillPaint = paint;
    }

    public GradientPaintTransformer getFillPaintTransformer() {
        return this.fillPaintTransformer;
    }

    public void setFillPaintTransformer(GradientPaintTransformer gradientPaintTransformer) {
        if (gradientPaintTransformer == null) {
            throw new IllegalArgumentException("Null 'transformer' argument.");
        }
        this.fillPaintTransformer = gradientPaintTransformer;
    }

    public boolean isShapeOutlineVisible() {
        return this.shapeOutlineVisible;
    }

    public void setShapeOutlineVisible(boolean bl2) {
        this.shapeOutlineVisible = bl2;
    }

    public Paint getOutlinePaint() {
        return this.outlinePaint;
    }

    public void setOutlinePaint(Paint paint) {
        this.outlinePaint = paint;
    }

    public Stroke getOutlineStroke() {
        return this.outlineStroke;
    }

    public void setOutlineStroke(Stroke stroke) {
        this.outlineStroke = stroke;
    }

    public RectangleAnchor getShapeAnchor() {
        return this.shapeAnchor;
    }

    public void setShapeAnchor(RectangleAnchor rectangleAnchor) {
        if (rectangleAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.shapeAnchor = rectangleAnchor;
    }

    public RectangleAnchor getShapeLocation() {
        return this.shapeLocation;
    }

    public void setShapeLocation(RectangleAnchor rectangleAnchor) {
        if (rectangleAnchor == null) {
            throw new IllegalArgumentException("Null 'location' argument.");
        }
        this.shapeLocation = rectangleAnchor;
    }

    public boolean isLineVisible() {
        return this.lineVisible;
    }

    public void setLineVisible(boolean bl2) {
        this.lineVisible = bl2;
    }

    public Shape getLine() {
        return this.line;
    }

    public void setLine(Shape shape) {
        this.line = shape;
    }

    public Paint getLinePaint() {
        return this.linePaint;
    }

    public void setLinePaint(Paint paint) {
        this.linePaint = paint;
    }

    public Stroke getLineStroke() {
        return this.lineStroke;
    }

    public void setLineStroke(Stroke stroke) {
        this.lineStroke = stroke;
    }

    @Override
    public Size2D arrange(Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        RectangleConstraint rectangleConstraint2 = this.toContentConstraint(rectangleConstraint);
        LengthConstraintType lengthConstraintType = rectangleConstraint2.getWidthConstraintType();
        LengthConstraintType lengthConstraintType2 = rectangleConstraint2.getHeightConstraintType();
        Size2D size2D = null;
        if (lengthConstraintType == LengthConstraintType.NONE) {
            if (lengthConstraintType2 == LengthConstraintType.NONE) {
                size2D = this.arrangeNN(graphics2D);
                return new Size2D(this.calculateTotalWidth(size2D.getWidth()), this.calculateTotalHeight(size2D.getHeight()));
            }
            if (lengthConstraintType2 == LengthConstraintType.RANGE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (lengthConstraintType2 != LengthConstraintType.FIXED) return new Size2D(this.calculateTotalWidth(size2D.getWidth()), this.calculateTotalHeight(size2D.getHeight()));
            throw new RuntimeException("Not yet implemented.");
        }
        if (lengthConstraintType == LengthConstraintType.RANGE) {
            if (lengthConstraintType2 == LengthConstraintType.NONE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (lengthConstraintType2 == LengthConstraintType.RANGE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (lengthConstraintType2 != LengthConstraintType.FIXED) return new Size2D(this.calculateTotalWidth(size2D.getWidth()), this.calculateTotalHeight(size2D.getHeight()));
            throw new RuntimeException("Not yet implemented.");
        }
        if (lengthConstraintType != LengthConstraintType.FIXED) return new Size2D(this.calculateTotalWidth(size2D.getWidth()), this.calculateTotalHeight(size2D.getHeight()));
        if (lengthConstraintType2 == LengthConstraintType.NONE) {
            throw new RuntimeException("Not yet implemented.");
        }
        if (lengthConstraintType2 == LengthConstraintType.RANGE) {
            throw new RuntimeException("Not yet implemented.");
        }
        if (lengthConstraintType2 != LengthConstraintType.FIXED) return new Size2D(this.calculateTotalWidth(size2D.getWidth()), this.calculateTotalHeight(size2D.getHeight()));
        size2D = new Size2D(rectangleConstraint2.getWidth(), rectangleConstraint2.getHeight());
        return new Size2D(this.calculateTotalWidth(size2D.getWidth()), this.calculateTotalHeight(size2D.getHeight()));
    }

    protected Size2D arrangeNN(Graphics2D graphics2D) {
        Rectangle2D rectangle2D = new Rectangle2D.Double();
        if (this.line != null) {
            rectangle2D.setRect(this.line.getBounds2D());
        }
        if (this.shape == null) return new Size2D(rectangle2D.getWidth(), rectangle2D.getHeight());
        rectangle2D = rectangle2D.createUnion(this.shape.getBounds2D());
        return new Size2D(rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        Point2D point2D;
        Shape shape;
        rectangle2D = this.trimMargin(rectangle2D);
        this.drawBorder(graphics2D, rectangle2D);
        rectangle2D = this.trimBorder(rectangle2D);
        rectangle2D = this.trimPadding(rectangle2D);
        if (this.lineVisible) {
            point2D = RectangleAnchor.coordinates(rectangle2D, this.shapeLocation);
            shape = ShapeUtilities.createTranslatedShape(this.getLine(), this.shapeAnchor, point2D.getX(), point2D.getY());
            graphics2D.setPaint(this.linePaint);
            graphics2D.setStroke(this.lineStroke);
            graphics2D.draw(shape);
        }
        if (!this.shapeVisible) return;
        point2D = RectangleAnchor.coordinates(rectangle2D, this.shapeLocation);
        shape = ShapeUtilities.createTranslatedShape(this.shape, this.shapeAnchor, point2D.getX(), point2D.getY());
        if (this.shapeFilled) {
            Paint paint = this.fillPaint;
            if (paint instanceof GradientPaint) {
                GradientPaint gradientPaint = (GradientPaint)this.fillPaint;
                paint = this.fillPaintTransformer.transform(gradientPaint, shape);
            }
            graphics2D.setPaint(paint);
            graphics2D.fill(shape);
        }
        if (!this.shapeOutlineVisible) return;
        graphics2D.setPaint(this.outlinePaint);
        graphics2D.setStroke(this.outlineStroke);
        graphics2D.draw(shape);
    }

    @Override
    public Object draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Object object) {
        this.draw(graphics2D, rectangle2D);
        return null;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof LegendGraphic)) {
            return false;
        }
        LegendGraphic legendGraphic = (LegendGraphic)object;
        if (this.shapeVisible != legendGraphic.shapeVisible) {
            return false;
        }
        if (!ShapeUtilities.equal(this.shape, legendGraphic.shape)) {
            return false;
        }
        if (this.shapeFilled != legendGraphic.shapeFilled) {
            return false;
        }
        if (!PaintUtilities.equal(this.fillPaint, legendGraphic.fillPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.fillPaintTransformer, legendGraphic.fillPaintTransformer)) {
            return false;
        }
        if (this.shapeOutlineVisible != legendGraphic.shapeOutlineVisible) {
            return false;
        }
        if (!PaintUtilities.equal(this.outlinePaint, legendGraphic.outlinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.outlineStroke, legendGraphic.outlineStroke)) {
            return false;
        }
        if (this.shapeAnchor != legendGraphic.shapeAnchor) {
            return false;
        }
        if (this.shapeLocation != legendGraphic.shapeLocation) {
            return false;
        }
        if (this.lineVisible != legendGraphic.lineVisible) {
            return false;
        }
        if (!ShapeUtilities.equal(this.line, legendGraphic.line)) {
            return false;
        }
        if (!PaintUtilities.equal(this.linePaint, legendGraphic.linePaint)) {
            return false;
        }
        if (ObjectUtilities.equal(this.lineStroke, legendGraphic.lineStroke)) return super.equals(object);
        return false;
    }

    public int hashCode() {
        int n2 = 193;
        return 37 * n2 + ObjectUtilities.hashCode(this.fillPaint);
    }

    @Override
    public Object clone() {
        LegendGraphic legendGraphic = (LegendGraphic)super.clone();
        legendGraphic.shape = ShapeUtilities.clone(this.shape);
        legendGraphic.line = ShapeUtilities.clone(this.line);
        return legendGraphic;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.shape, objectOutputStream);
        SerialUtilities.writePaint(this.fillPaint, objectOutputStream);
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.outlineStroke, objectOutputStream);
        SerialUtilities.writeShape(this.line, objectOutputStream);
        SerialUtilities.writePaint(this.linePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.lineStroke, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.shape = SerialUtilities.readShape(objectInputStream);
        this.fillPaint = SerialUtilities.readPaint(objectInputStream);
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.outlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.line = SerialUtilities.readShape(objectInputStream);
        this.linePaint = SerialUtilities.readPaint(objectInputStream);
        this.lineStroke = SerialUtilities.readStroke(objectInputStream);
    }
}

