package org.jfree.chart.title;

import org.jfree.ui.*;
import org.jfree.chart.block.*;
import java.awt.*;
import java.awt.geom.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class LegendGraphic extends AbstractBlock implements Block, PublicCloneable
{
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
    
    public LegendGraphic(final Shape shape, final Paint fillPaint) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        if (fillPaint == null) {
            throw new IllegalArgumentException("Null 'fillPaint' argument.");
        }
        this.shapeVisible = true;
        this.shape = shape;
        this.shapeAnchor = RectangleAnchor.CENTER;
        this.shapeLocation = RectangleAnchor.CENTER;
        this.shapeFilled = true;
        this.fillPaint = fillPaint;
        this.fillPaintTransformer = new StandardGradientPaintTransformer();
        this.setPadding(2.0, 2.0, 2.0, 2.0);
    }
    
    public boolean isShapeVisible() {
        return this.shapeVisible;
    }
    
    public void setShapeVisible(final boolean shapeVisible) {
        this.shapeVisible = shapeVisible;
    }
    
    public Shape getShape() {
        return this.shape;
    }
    
    public void setShape(final Shape shape) {
        this.shape = shape;
    }
    
    public boolean isShapeFilled() {
        return this.shapeFilled;
    }
    
    public void setShapeFilled(final boolean shapeFilled) {
        this.shapeFilled = shapeFilled;
    }
    
    public Paint getFillPaint() {
        return this.fillPaint;
    }
    
    public void setFillPaint(final Paint fillPaint) {
        this.fillPaint = fillPaint;
    }
    
    public GradientPaintTransformer getFillPaintTransformer() {
        return this.fillPaintTransformer;
    }
    
    public void setFillPaintTransformer(final GradientPaintTransformer fillPaintTransformer) {
        if (fillPaintTransformer == null) {
            throw new IllegalArgumentException("Null 'transformer' argument.");
        }
        this.fillPaintTransformer = fillPaintTransformer;
    }
    
    public boolean isShapeOutlineVisible() {
        return this.shapeOutlineVisible;
    }
    
    public void setShapeOutlineVisible(final boolean shapeOutlineVisible) {
        this.shapeOutlineVisible = shapeOutlineVisible;
    }
    
    public Paint getOutlinePaint() {
        return this.outlinePaint;
    }
    
    public void setOutlinePaint(final Paint outlinePaint) {
        this.outlinePaint = outlinePaint;
    }
    
    public Stroke getOutlineStroke() {
        return this.outlineStroke;
    }
    
    public void setOutlineStroke(final Stroke outlineStroke) {
        this.outlineStroke = outlineStroke;
    }
    
    public RectangleAnchor getShapeAnchor() {
        return this.shapeAnchor;
    }
    
    public void setShapeAnchor(final RectangleAnchor shapeAnchor) {
        if (shapeAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.shapeAnchor = shapeAnchor;
    }
    
    public RectangleAnchor getShapeLocation() {
        return this.shapeLocation;
    }
    
    public void setShapeLocation(final RectangleAnchor shapeLocation) {
        if (shapeLocation == null) {
            throw new IllegalArgumentException("Null 'location' argument.");
        }
        this.shapeLocation = shapeLocation;
    }
    
    public boolean isLineVisible() {
        return this.lineVisible;
    }
    
    public void setLineVisible(final boolean lineVisible) {
        this.lineVisible = lineVisible;
    }
    
    public Shape getLine() {
        return this.line;
    }
    
    public void setLine(final Shape line) {
        this.line = line;
    }
    
    public Paint getLinePaint() {
        return this.linePaint;
    }
    
    public void setLinePaint(final Paint linePaint) {
        this.linePaint = linePaint;
    }
    
    public Stroke getLineStroke() {
        return this.lineStroke;
    }
    
    public void setLineStroke(final Stroke lineStroke) {
        this.lineStroke = lineStroke;
    }
    
    public Size2D arrange(final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final RectangleConstraint contentConstraint = this.toContentConstraint(rectangleConstraint);
        final LengthConstraintType widthConstraintType = contentConstraint.getWidthConstraintType();
        final LengthConstraintType heightConstraintType = contentConstraint.getHeightConstraintType();
        Size2D arrangeNN = null;
        if (widthConstraintType == LengthConstraintType.NONE) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                arrangeNN = this.arrangeNN(graphics2D);
            }
            else {
                if (heightConstraintType == LengthConstraintType.RANGE) {
                    throw new RuntimeException("Not yet implemented.");
                }
                if (heightConstraintType == LengthConstraintType.FIXED) {
                    throw new RuntimeException("Not yet implemented.");
                }
            }
        }
        else if (widthConstraintType == LengthConstraintType.RANGE) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (heightConstraintType == LengthConstraintType.FIXED) {
                throw new RuntimeException("Not yet implemented.");
            }
        }
        else if (widthConstraintType == LengthConstraintType.FIXED) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (heightConstraintType == LengthConstraintType.FIXED) {
                arrangeNN = new Size2D(contentConstraint.getWidth(), contentConstraint.getHeight());
            }
        }
        return new Size2D(this.calculateTotalWidth(arrangeNN.getWidth()), this.calculateTotalHeight(arrangeNN.getHeight()));
    }
    
    protected Size2D arrangeNN(final Graphics2D graphics2D) {
        Rectangle2D union = new Rectangle2D.Double();
        if (this.line != null) {
            union.setRect(this.line.getBounds2D());
        }
        if (this.shape != null) {
            union = union.createUnion(this.shape.getBounds2D());
        }
        return new Size2D(union.getWidth(), union.getHeight());
    }
    
    public void draw(final Graphics2D graphics2D, Rectangle2D rectangle2D) {
        rectangle2D = this.trimMargin(rectangle2D);
        this.drawBorder(graphics2D, rectangle2D);
        rectangle2D = this.trimBorder(rectangle2D);
        rectangle2D = this.trimPadding(rectangle2D);
        if (this.lineVisible) {
            final Point2D coordinates = RectangleAnchor.coordinates(rectangle2D, this.shapeLocation);
            final Shape translatedShape = ShapeUtilities.createTranslatedShape(this.getLine(), this.shapeAnchor, coordinates.getX(), coordinates.getY());
            graphics2D.setPaint(this.linePaint);
            graphics2D.setStroke(this.lineStroke);
            graphics2D.draw(translatedShape);
        }
        if (this.shapeVisible) {
            final Point2D coordinates2 = RectangleAnchor.coordinates(rectangle2D, this.shapeLocation);
            final Shape translatedShape2 = ShapeUtilities.createTranslatedShape(this.shape, this.shapeAnchor, coordinates2.getX(), coordinates2.getY());
            if (this.shapeFilled) {
                Paint paint = this.fillPaint;
                if (paint instanceof GradientPaint) {
                    paint = this.fillPaintTransformer.transform((GradientPaint)this.fillPaint, translatedShape2);
                }
                graphics2D.setPaint(paint);
                graphics2D.fill(translatedShape2);
            }
            if (this.shapeOutlineVisible) {
                graphics2D.setPaint(this.outlinePaint);
                graphics2D.setStroke(this.outlineStroke);
                graphics2D.draw(translatedShape2);
            }
        }
    }
    
    public Object draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Object o) {
        this.draw(graphics2D, rectangle2D);
        return null;
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof LegendGraphic)) {
            return false;
        }
        final LegendGraphic legendGraphic = (LegendGraphic)o;
        return this.shapeVisible == legendGraphic.shapeVisible && ShapeUtilities.equal(this.shape, legendGraphic.shape) && this.shapeFilled == legendGraphic.shapeFilled && PaintUtilities.equal(this.fillPaint, legendGraphic.fillPaint) && ObjectUtilities.equal(this.fillPaintTransformer, legendGraphic.fillPaintTransformer) && this.shapeOutlineVisible == legendGraphic.shapeOutlineVisible && PaintUtilities.equal(this.outlinePaint, legendGraphic.outlinePaint) && ObjectUtilities.equal(this.outlineStroke, legendGraphic.outlineStroke) && this.shapeAnchor == legendGraphic.shapeAnchor && this.shapeLocation == legendGraphic.shapeLocation && this.lineVisible == legendGraphic.lineVisible && ShapeUtilities.equal(this.line, legendGraphic.line) && PaintUtilities.equal(this.linePaint, legendGraphic.linePaint) && ObjectUtilities.equal(this.lineStroke, legendGraphic.lineStroke) && super.equals(o);
    }
    
    public int hashCode() {
        return 37 * 193 + ObjectUtilities.hashCode(this.fillPaint);
    }
    
    public Object clone() {
        final LegendGraphic legendGraphic = (LegendGraphic)super.clone();
        legendGraphic.shape = ShapeUtilities.clone(this.shape);
        legendGraphic.line = ShapeUtilities.clone(this.line);
        return legendGraphic;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.shape, objectOutputStream);
        SerialUtilities.writePaint(this.fillPaint, objectOutputStream);
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.outlineStroke, objectOutputStream);
        SerialUtilities.writeShape(this.line, objectOutputStream);
        SerialUtilities.writePaint(this.linePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.lineStroke, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
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
