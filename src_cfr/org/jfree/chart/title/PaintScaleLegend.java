/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.title;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
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
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class PaintScaleLegend
extends Title
implements PublicCloneable {
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

    public PaintScaleLegend(PaintScale paintScale, ValueAxis valueAxis) {
        if (valueAxis == null) {
            throw new IllegalArgumentException("Null 'axis' argument.");
        }
        this.scale = paintScale;
        this.axis = valueAxis;
        this.axisLocation = AxisLocation.BOTTOM_OR_LEFT;
        this.axisOffset = 0.0;
        this.stripWidth = 15.0;
        this.stripOutlineVisible = false;
        this.stripOutlinePaint = Color.gray;
        this.stripOutlineStroke = new BasicStroke(0.5f);
        this.backgroundPaint = Color.white;
    }

    public PaintScale getScale() {
        return this.scale;
    }

    public void setScale(PaintScale paintScale) {
        if (paintScale == null) {
            throw new IllegalArgumentException("Null 'scale' argument.");
        }
        this.scale = paintScale;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public ValueAxis getAxis() {
        return this.axis;
    }

    public void setAxis(ValueAxis valueAxis) {
        if (valueAxis == null) {
            throw new IllegalArgumentException("Null 'axis' argument.");
        }
        this.axis = valueAxis;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public AxisLocation getAxisLocation() {
        return this.axisLocation;
    }

    public void setAxisLocation(AxisLocation axisLocation) {
        if (axisLocation == null) {
            throw new IllegalArgumentException("Null 'location' argument.");
        }
        this.axisLocation = axisLocation;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public double getAxisOffset() {
        return this.axisOffset;
    }

    public void setAxisOffset(double d2) {
        this.axisOffset = d2;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public double getStripWidth() {
        return this.stripWidth;
    }

    public void setStripWidth(double d2) {
        this.stripWidth = d2;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public boolean isStripOutlineVisible() {
        return this.stripOutlineVisible;
    }

    public void setStripOutlineVisible(boolean bl2) {
        this.stripOutlineVisible = bl2;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public Paint getStripOutlinePaint() {
        return this.stripOutlinePaint;
    }

    public void setStripOutlinePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.stripOutlinePaint = paint;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public Stroke getStripOutlineStroke() {
        return this.stripOutlineStroke;
    }

    public void setStripOutlineStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.stripOutlineStroke = stroke;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }

    public void setBackgroundPaint(Paint paint) {
        this.backgroundPaint = paint;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    @Override
    public Size2D arrange(Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        RectangleConstraint rectangleConstraint2 = this.toContentConstraint(rectangleConstraint);
        LengthConstraintType lengthConstraintType = rectangleConstraint2.getWidthConstraintType();
        LengthConstraintType lengthConstraintType2 = rectangleConstraint2.getHeightConstraintType();
        Size2D size2D = null;
        if (lengthConstraintType == LengthConstraintType.NONE) {
            if (lengthConstraintType2 == LengthConstraintType.NONE) {
                size2D = new Size2D(this.getWidth(), this.getHeight());
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
                size2D = this.arrangeRR(graphics2D, rectangleConstraint2.getWidthRange(), rectangleConstraint2.getHeightRange());
                return new Size2D(this.calculateTotalWidth(size2D.getWidth()), this.calculateTotalHeight(size2D.getHeight()));
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
        throw new RuntimeException("Not yet implemented.");
    }

    protected Size2D arrangeRR(Graphics2D graphics2D, Range range, Range range2) {
        RectangleEdge rectangleEdge = this.getPosition();
        if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
            float f2 = (float)range.getUpperBound();
            AxisSpace axisSpace = this.axis.reserveSpace(graphics2D, null, new Rectangle2D.Double(0.0, 0.0, f2, 100.0), RectangleEdge.BOTTOM, null);
            return new Size2D(f2, this.stripWidth + this.axisOffset + axisSpace.getTop() + axisSpace.getBottom());
        }
        if (rectangleEdge != RectangleEdge.LEFT) {
            if (rectangleEdge != RectangleEdge.RIGHT) throw new RuntimeException("Unrecognised position.");
        }
        float f3 = (float)range2.getUpperBound();
        AxisSpace axisSpace = this.axis.reserveSpace(graphics2D, null, new Rectangle2D.Double(0.0, 0.0, 100.0, f3), RectangleEdge.RIGHT, null);
        return new Size2D(this.stripWidth + this.axisOffset + axisSpace.getLeft() + axisSpace.getRight(), f3);
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        this.draw(graphics2D, rectangle2D, null);
    }

    @Override
    public Object draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Object object) {
        Rectangle2D rectangle2D2 = (Rectangle2D)rectangle2D.clone();
        rectangle2D2 = this.trimMargin(rectangle2D2);
        if (this.backgroundPaint != null) {
            graphics2D.setPaint(this.backgroundPaint);
            graphics2D.fill(rectangle2D2);
        }
        this.getBorder().draw(graphics2D, rectangle2D2);
        this.getBorder().getInsets().trim(rectangle2D2);
        rectangle2D2 = this.trimPadding(rectangle2D2);
        double d2 = this.axis.getLowerBound();
        double d3 = this.axis.getRange().getLength() / 200.0;
        Rectangle2D.Double double_ = new Rectangle2D.Double();
        if (RectangleEdge.isTopOrBottom(this.getPosition())) {
            RectangleEdge rectangleEdge = Plot.resolveRangeAxisLocation(this.axisLocation, PlotOrientation.HORIZONTAL);
            double d4 = Math.ceil(rectangle2D2.getWidth() / 200.0);
            if (rectangleEdge == RectangleEdge.TOP) {
                int n2 = 0;
                do {
                    if (n2 >= 200) {
                        graphics2D.setPaint(this.stripOutlinePaint);
                        graphics2D.setStroke(this.stripOutlineStroke);
                        graphics2D.draw(new Rectangle2D.Double(rectangle2D2.getMinX(), rectangle2D2.getMaxY() - this.stripWidth, rectangle2D2.getWidth(), this.stripWidth));
                        this.axis.draw(graphics2D, rectangle2D2.getMaxY() - this.stripWidth - this.axisOffset, rectangle2D2, rectangle2D2, RectangleEdge.TOP, null);
                        return null;
                    }
                    double d5 = d2 + (double)n2 * d3;
                    Paint paint = this.scale.getPaint(d5);
                    double d6 = this.axis.valueToJava2D(d5, rectangle2D2, RectangleEdge.BOTTOM);
                    double_.setRect(d6, rectangle2D2.getMaxY() - this.stripWidth, d4, this.stripWidth);
                    graphics2D.setPaint(paint);
                    graphics2D.fill(double_);
                    ++n2;
                } while (true);
            }
            if (rectangleEdge != RectangleEdge.BOTTOM) return null;
            int n3 = 0;
            do {
                if (n3 >= 200) {
                    graphics2D.setPaint(this.stripOutlinePaint);
                    graphics2D.setStroke(this.stripOutlineStroke);
                    graphics2D.draw(new Rectangle2D.Double(rectangle2D2.getMinX(), rectangle2D2.getMinY(), rectangle2D2.getWidth(), this.stripWidth));
                    this.axis.draw(graphics2D, rectangle2D2.getMinY() + this.stripWidth + this.axisOffset, rectangle2D2, rectangle2D2, RectangleEdge.BOTTOM, null);
                    return null;
                }
                double d7 = d2 + (double)n3 * d3;
                Paint paint = this.scale.getPaint(d7);
                double d8 = this.axis.valueToJava2D(d7, rectangle2D2, RectangleEdge.BOTTOM);
                double_.setRect(d8, rectangle2D2.getMinY(), d4, this.stripWidth);
                graphics2D.setPaint(paint);
                graphics2D.fill(double_);
                ++n3;
            } while (true);
        }
        RectangleEdge rectangleEdge = Plot.resolveRangeAxisLocation(this.axisLocation, PlotOrientation.VERTICAL);
        double d9 = Math.ceil(rectangle2D2.getHeight() / 200.0);
        if (rectangleEdge == RectangleEdge.LEFT) {
            int n4 = 0;
            do {
                if (n4 >= 200) {
                    graphics2D.setPaint(this.stripOutlinePaint);
                    graphics2D.setStroke(this.stripOutlineStroke);
                    graphics2D.draw(new Rectangle2D.Double(rectangle2D2.getMaxX() - this.stripWidth, rectangle2D2.getMinY(), this.stripWidth, rectangle2D2.getHeight()));
                    this.axis.draw(graphics2D, rectangle2D2.getMaxX() - this.stripWidth - this.axisOffset, rectangle2D2, rectangle2D2, RectangleEdge.LEFT, null);
                    return null;
                }
                double d10 = d2 + (double)n4 * d3;
                Paint paint = this.scale.getPaint(d10);
                double d11 = this.axis.valueToJava2D(d10, rectangle2D2, RectangleEdge.LEFT);
                double_.setRect(rectangle2D2.getMaxX() - this.stripWidth, d11 - d9, this.stripWidth, d9);
                graphics2D.setPaint(paint);
                graphics2D.fill(double_);
                ++n4;
            } while (true);
        }
        if (rectangleEdge != RectangleEdge.RIGHT) return null;
        int n5 = 0;
        do {
            if (n5 >= 200) {
                graphics2D.setPaint(this.stripOutlinePaint);
                graphics2D.setStroke(this.stripOutlineStroke);
                graphics2D.draw(new Rectangle2D.Double(rectangle2D2.getMinX(), rectangle2D2.getMinY(), this.stripWidth, rectangle2D2.getHeight()));
                this.axis.draw(graphics2D, rectangle2D2.getMinX() + this.stripWidth + this.axisOffset, rectangle2D2, rectangle2D2, RectangleEdge.RIGHT, null);
                return null;
            }
            double d12 = d2 + (double)n5 * d3;
            Paint paint = this.scale.getPaint(d12);
            double d13 = this.axis.valueToJava2D(d12, rectangle2D2, RectangleEdge.LEFT);
            double_.setRect(rectangle2D2.getMinX(), d13 - d9, this.stripWidth, d9);
            graphics2D.setPaint(paint);
            graphics2D.fill(double_);
            ++n5;
        } while (true);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PaintScaleLegend)) {
            return false;
        }
        PaintScaleLegend paintScaleLegend = (PaintScaleLegend)object;
        if (!this.scale.equals(paintScaleLegend.scale)) {
            return false;
        }
        if (!this.axis.equals(paintScaleLegend.axis)) {
            return false;
        }
        if (!this.axisLocation.equals(paintScaleLegend.axisLocation)) {
            return false;
        }
        if (this.axisOffset != paintScaleLegend.axisOffset) {
            return false;
        }
        if (this.stripWidth != paintScaleLegend.stripWidth) {
            return false;
        }
        if (this.stripOutlineVisible != paintScaleLegend.stripOutlineVisible) {
            return false;
        }
        if (!PaintUtilities.equal(this.stripOutlinePaint, paintScaleLegend.stripOutlinePaint)) {
            return false;
        }
        if (!this.stripOutlineStroke.equals(paintScaleLegend.stripOutlineStroke)) {
            return false;
        }
        if (PaintUtilities.equal(this.backgroundPaint, paintScaleLegend.backgroundPaint)) return super.equals(object);
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.backgroundPaint, objectOutputStream);
        SerialUtilities.writePaint(this.stripOutlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.stripOutlineStroke, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.backgroundPaint = SerialUtilities.readPaint(objectInputStream);
        this.stripOutlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.stripOutlineStroke = SerialUtilities.readStroke(objectInputStream);
    }
}

