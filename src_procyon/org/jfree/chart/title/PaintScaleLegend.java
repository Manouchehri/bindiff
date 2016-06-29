package org.jfree.chart.title;

import org.jfree.chart.renderer.*;
import org.jfree.chart.event.*;
import org.jfree.chart.block.*;
import org.jfree.data.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import java.awt.*;
import org.jfree.chart.plot.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class PaintScaleLegend extends Title implements PublicCloneable
{
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
    
    public PaintScaleLegend(final PaintScale scale, final ValueAxis axis) {
        if (axis == null) {
            throw new IllegalArgumentException("Null 'axis' argument.");
        }
        this.scale = scale;
        this.axis = axis;
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
    
    public void setScale(final PaintScale scale) {
        if (scale == null) {
            throw new IllegalArgumentException("Null 'scale' argument.");
        }
        this.scale = scale;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public ValueAxis getAxis() {
        return this.axis;
    }
    
    public void setAxis(final ValueAxis axis) {
        if (axis == null) {
            throw new IllegalArgumentException("Null 'axis' argument.");
        }
        this.axis = axis;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public AxisLocation getAxisLocation() {
        return this.axisLocation;
    }
    
    public void setAxisLocation(final AxisLocation axisLocation) {
        if (axisLocation == null) {
            throw new IllegalArgumentException("Null 'location' argument.");
        }
        this.axisLocation = axisLocation;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public double getAxisOffset() {
        return this.axisOffset;
    }
    
    public void setAxisOffset(final double axisOffset) {
        this.axisOffset = axisOffset;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public double getStripWidth() {
        return this.stripWidth;
    }
    
    public void setStripWidth(final double stripWidth) {
        this.stripWidth = stripWidth;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public boolean isStripOutlineVisible() {
        return this.stripOutlineVisible;
    }
    
    public void setStripOutlineVisible(final boolean stripOutlineVisible) {
        this.stripOutlineVisible = stripOutlineVisible;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public Paint getStripOutlinePaint() {
        return this.stripOutlinePaint;
    }
    
    public void setStripOutlinePaint(final Paint stripOutlinePaint) {
        if (stripOutlinePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.stripOutlinePaint = stripOutlinePaint;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public Stroke getStripOutlineStroke() {
        return this.stripOutlineStroke;
    }
    
    public void setStripOutlineStroke(final Stroke stripOutlineStroke) {
        if (stripOutlineStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.stripOutlineStroke = stripOutlineStroke;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }
    
    public void setBackgroundPaint(final Paint backgroundPaint) {
        this.backgroundPaint = backgroundPaint;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public Size2D arrange(final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final RectangleConstraint contentConstraint = this.toContentConstraint(rectangleConstraint);
        final LengthConstraintType widthConstraintType = contentConstraint.getWidthConstraintType();
        final LengthConstraintType heightConstraintType = contentConstraint.getHeightConstraintType();
        Size2D arrangeRR = null;
        if (widthConstraintType == LengthConstraintType.NONE) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                arrangeRR = new Size2D(this.getWidth(), this.getHeight());
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
                arrangeRR = this.arrangeRR(graphics2D, contentConstraint.getWidthRange(), contentConstraint.getHeightRange());
            }
            else if (heightConstraintType == LengthConstraintType.FIXED) {
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
                throw new RuntimeException("Not yet implemented.");
            }
        }
        return new Size2D(this.calculateTotalWidth(arrangeRR.getWidth()), this.calculateTotalHeight(arrangeRR.getHeight()));
    }
    
    protected Size2D arrangeRR(final Graphics2D graphics2D, final Range range, final Range range2) {
        final RectangleEdge position = this.getPosition();
        if (position == RectangleEdge.TOP || position == RectangleEdge.BOTTOM) {
            final float n = (float)range.getUpperBound();
            final AxisSpace reserveSpace = this.axis.reserveSpace(graphics2D, null, new Rectangle2D.Double(0.0, 0.0, n, 100.0), RectangleEdge.BOTTOM, null);
            return new Size2D(n, this.stripWidth + this.axisOffset + reserveSpace.getTop() + reserveSpace.getBottom());
        }
        if (position == RectangleEdge.LEFT || position == RectangleEdge.RIGHT) {
            final float n2 = (float)range2.getUpperBound();
            final AxisSpace reserveSpace2 = this.axis.reserveSpace(graphics2D, null, new Rectangle2D.Double(0.0, 0.0, 100.0, n2), RectangleEdge.RIGHT, null);
            return new Size2D(this.stripWidth + this.axisOffset + reserveSpace2.getLeft() + reserveSpace2.getRight(), n2);
        }
        throw new RuntimeException("Unrecognised position.");
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        this.draw(graphics2D, rectangle2D, null);
    }
    
    public Object draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Object o) {
        final Rectangle2D trimMargin = this.trimMargin((Rectangle2D)rectangle2D.clone());
        if (this.backgroundPaint != null) {
            graphics2D.setPaint(this.backgroundPaint);
            graphics2D.fill(trimMargin);
        }
        this.getBorder().draw(graphics2D, trimMargin);
        this.getBorder().getInsets().trim(trimMargin);
        final Rectangle2D trimPadding = this.trimPadding(trimMargin);
        final double lowerBound = this.axis.getLowerBound();
        final double n = this.axis.getRange().getLength() / 200.0;
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        if (RectangleEdge.isTopOrBottom(this.getPosition())) {
            final RectangleEdge resolveRangeAxisLocation = Plot.resolveRangeAxisLocation(this.axisLocation, PlotOrientation.HORIZONTAL);
            final double ceil = Math.ceil(trimPadding.getWidth() / 200.0);
            if (resolveRangeAxisLocation == RectangleEdge.TOP) {
                for (int i = 0; i < 200; ++i) {
                    final double n2 = lowerBound + i * n;
                    final Paint paint = this.scale.getPaint(n2);
                    double1.setRect(this.axis.valueToJava2D(n2, trimPadding, RectangleEdge.BOTTOM), trimPadding.getMaxY() - this.stripWidth, ceil, this.stripWidth);
                    graphics2D.setPaint(paint);
                    graphics2D.fill(double1);
                }
                graphics2D.setPaint(this.stripOutlinePaint);
                graphics2D.setStroke(this.stripOutlineStroke);
                graphics2D.draw(new Rectangle2D.Double(trimPadding.getMinX(), trimPadding.getMaxY() - this.stripWidth, trimPadding.getWidth(), this.stripWidth));
                this.axis.draw(graphics2D, trimPadding.getMaxY() - this.stripWidth - this.axisOffset, trimPadding, trimPadding, RectangleEdge.TOP, null);
            }
            else if (resolveRangeAxisLocation == RectangleEdge.BOTTOM) {
                for (int j = 0; j < 200; ++j) {
                    final double n3 = lowerBound + j * n;
                    final Paint paint2 = this.scale.getPaint(n3);
                    double1.setRect(this.axis.valueToJava2D(n3, trimPadding, RectangleEdge.BOTTOM), trimPadding.getMinY(), ceil, this.stripWidth);
                    graphics2D.setPaint(paint2);
                    graphics2D.fill(double1);
                }
                graphics2D.setPaint(this.stripOutlinePaint);
                graphics2D.setStroke(this.stripOutlineStroke);
                graphics2D.draw(new Rectangle2D.Double(trimPadding.getMinX(), trimPadding.getMinY(), trimPadding.getWidth(), this.stripWidth));
                this.axis.draw(graphics2D, trimPadding.getMinY() + this.stripWidth + this.axisOffset, trimPadding, trimPadding, RectangleEdge.BOTTOM, null);
            }
        }
        else {
            final RectangleEdge resolveRangeAxisLocation2 = Plot.resolveRangeAxisLocation(this.axisLocation, PlotOrientation.VERTICAL);
            final double ceil2 = Math.ceil(trimPadding.getHeight() / 200.0);
            if (resolveRangeAxisLocation2 == RectangleEdge.LEFT) {
                for (int k = 0; k < 200; ++k) {
                    final double n4 = lowerBound + k * n;
                    final Paint paint3 = this.scale.getPaint(n4);
                    double1.setRect(trimPadding.getMaxX() - this.stripWidth, this.axis.valueToJava2D(n4, trimPadding, RectangleEdge.LEFT) - ceil2, this.stripWidth, ceil2);
                    graphics2D.setPaint(paint3);
                    graphics2D.fill(double1);
                }
                graphics2D.setPaint(this.stripOutlinePaint);
                graphics2D.setStroke(this.stripOutlineStroke);
                graphics2D.draw(new Rectangle2D.Double(trimPadding.getMaxX() - this.stripWidth, trimPadding.getMinY(), this.stripWidth, trimPadding.getHeight()));
                this.axis.draw(graphics2D, trimPadding.getMaxX() - this.stripWidth - this.axisOffset, trimPadding, trimPadding, RectangleEdge.LEFT, null);
            }
            else if (resolveRangeAxisLocation2 == RectangleEdge.RIGHT) {
                for (int l = 0; l < 200; ++l) {
                    final double n5 = lowerBound + l * n;
                    final Paint paint4 = this.scale.getPaint(n5);
                    double1.setRect(trimPadding.getMinX(), this.axis.valueToJava2D(n5, trimPadding, RectangleEdge.LEFT) - ceil2, this.stripWidth, ceil2);
                    graphics2D.setPaint(paint4);
                    graphics2D.fill(double1);
                }
                graphics2D.setPaint(this.stripOutlinePaint);
                graphics2D.setStroke(this.stripOutlineStroke);
                graphics2D.draw(new Rectangle2D.Double(trimPadding.getMinX(), trimPadding.getMinY(), this.stripWidth, trimPadding.getHeight()));
                this.axis.draw(graphics2D, trimPadding.getMinX() + this.stripWidth + this.axisOffset, trimPadding, trimPadding, RectangleEdge.RIGHT, null);
            }
        }
        return null;
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof PaintScaleLegend)) {
            return false;
        }
        final PaintScaleLegend paintScaleLegend = (PaintScaleLegend)o;
        return this.scale.equals(paintScaleLegend.scale) && this.axis.equals(paintScaleLegend.axis) && this.axisLocation.equals(paintScaleLegend.axisLocation) && this.axisOffset == paintScaleLegend.axisOffset && this.stripWidth == paintScaleLegend.stripWidth && this.stripOutlineVisible == paintScaleLegend.stripOutlineVisible && PaintUtilities.equal(this.stripOutlinePaint, paintScaleLegend.stripOutlinePaint) && this.stripOutlineStroke.equals(paintScaleLegend.stripOutlineStroke) && PaintUtilities.equal(this.backgroundPaint, paintScaleLegend.backgroundPaint) && super.equals(o);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.backgroundPaint, objectOutputStream);
        SerialUtilities.writePaint(this.stripOutlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.stripOutlineStroke, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.backgroundPaint = SerialUtilities.readPaint(objectInputStream);
        this.stripOutlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.stripOutlineStroke = SerialUtilities.readStroke(objectInputStream);
    }
}
