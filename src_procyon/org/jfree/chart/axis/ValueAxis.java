package org.jfree.chart.axis;

import org.jfree.data.*;
import org.jfree.chart.event.*;
import java.awt.geom.*;
import org.jfree.ui.*;
import org.jfree.text.*;
import java.util.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public abstract class ValueAxis extends Axis implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = 3698345477322391456L;
    public static final Range DEFAULT_RANGE;
    public static final boolean DEFAULT_AUTO_RANGE = true;
    public static final boolean DEFAULT_INVERTED = false;
    public static final double DEFAULT_AUTO_RANGE_MINIMUM_SIZE = 1.0E-8;
    public static final double DEFAULT_LOWER_MARGIN = 0.05;
    public static final double DEFAULT_UPPER_MARGIN = 0.05;
    public static final double DEFAULT_LOWER_BOUND = 0.0;
    public static final double DEFAULT_UPPER_BOUND = 1.0;
    public static final boolean DEFAULT_AUTO_TICK_UNIT_SELECTION = true;
    public static final int MAXIMUM_TICK_COUNT = 500;
    private boolean positiveArrowVisible;
    private boolean negativeArrowVisible;
    private transient Shape upArrow;
    private transient Shape downArrow;
    private transient Shape leftArrow;
    private transient Shape rightArrow;
    private boolean inverted;
    private Range range;
    private boolean autoRange;
    private double autoRangeMinimumSize;
    private Range defaultAutoRange;
    private double upperMargin;
    private double lowerMargin;
    private double fixedAutoRange;
    private boolean autoTickUnitSelection;
    private TickUnitSource standardTickUnits;
    private int autoTickIndex;
    private boolean verticalTickLabels;
    
    protected ValueAxis(final String s, final TickUnitSource standardTickUnits) {
        super(s);
        this.positiveArrowVisible = false;
        this.negativeArrowVisible = false;
        this.range = ValueAxis.DEFAULT_RANGE;
        this.autoRange = true;
        this.defaultAutoRange = ValueAxis.DEFAULT_RANGE;
        this.inverted = false;
        this.autoRangeMinimumSize = 1.0E-8;
        this.lowerMargin = 0.05;
        this.upperMargin = 0.05;
        this.fixedAutoRange = 0.0;
        this.autoTickUnitSelection = true;
        this.standardTickUnits = standardTickUnits;
        final Polygon upArrow = new Polygon();
        upArrow.addPoint(0, 0);
        upArrow.addPoint(-2, 2);
        upArrow.addPoint(2, 2);
        this.upArrow = upArrow;
        final Polygon downArrow = new Polygon();
        downArrow.addPoint(0, 0);
        downArrow.addPoint(-2, -2);
        downArrow.addPoint(2, -2);
        this.downArrow = downArrow;
        final Polygon rightArrow = new Polygon();
        rightArrow.addPoint(0, 0);
        rightArrow.addPoint(-2, -2);
        rightArrow.addPoint(-2, 2);
        this.rightArrow = rightArrow;
        final Polygon leftArrow = new Polygon();
        leftArrow.addPoint(0, 0);
        leftArrow.addPoint(2, -2);
        leftArrow.addPoint(2, 2);
        this.leftArrow = leftArrow;
        this.verticalTickLabels = false;
    }
    
    public boolean isVerticalTickLabels() {
        return this.verticalTickLabels;
    }
    
    public void setVerticalTickLabels(final boolean verticalTickLabels) {
        if (this.verticalTickLabels != verticalTickLabels) {
            this.verticalTickLabels = verticalTickLabels;
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public boolean isPositiveArrowVisible() {
        return this.positiveArrowVisible;
    }
    
    public void setPositiveArrowVisible(final boolean positiveArrowVisible) {
        this.positiveArrowVisible = positiveArrowVisible;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public boolean isNegativeArrowVisible() {
        return this.negativeArrowVisible;
    }
    
    public void setNegativeArrowVisible(final boolean negativeArrowVisible) {
        this.negativeArrowVisible = negativeArrowVisible;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Shape getUpArrow() {
        return this.upArrow;
    }
    
    public void setUpArrow(final Shape upArrow) {
        if (upArrow == null) {
            throw new IllegalArgumentException("Null 'arrow' argument.");
        }
        this.upArrow = upArrow;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Shape getDownArrow() {
        return this.downArrow;
    }
    
    public void setDownArrow(final Shape downArrow) {
        if (downArrow == null) {
            throw new IllegalArgumentException("Null 'arrow' argument.");
        }
        this.downArrow = downArrow;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Shape getLeftArrow() {
        return this.leftArrow;
    }
    
    public void setLeftArrow(final Shape leftArrow) {
        if (leftArrow == null) {
            throw new IllegalArgumentException("Null 'arrow' argument.");
        }
        this.leftArrow = leftArrow;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Shape getRightArrow() {
        return this.rightArrow;
    }
    
    public void setRightArrow(final Shape rightArrow) {
        if (rightArrow == null) {
            throw new IllegalArgumentException("Null 'arrow' argument.");
        }
        this.rightArrow = rightArrow;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    protected void drawAxisLine(final Graphics2D graphics2D, final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        Shape shape = null;
        if (rectangleEdge == RectangleEdge.TOP) {
            shape = new Line2D.Double(rectangle2D.getX(), n, rectangle2D.getMaxX(), n);
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            shape = new Line2D.Double(rectangle2D.getX(), n, rectangle2D.getMaxX(), n);
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            shape = new Line2D.Double(n, rectangle2D.getY(), n, rectangle2D.getMaxY());
        }
        else if (rectangleEdge == RectangleEdge.RIGHT) {
            shape = new Line2D.Double(n, rectangle2D.getY(), n, rectangle2D.getMaxY());
        }
        graphics2D.setPaint(this.getAxisLinePaint());
        graphics2D.setStroke(this.getAxisLineStroke());
        graphics2D.draw(shape);
        boolean b = false;
        boolean b2 = false;
        if (this.positiveArrowVisible) {
            if (this.inverted) {
                b2 = true;
            }
            else {
                b = true;
            }
        }
        if (this.negativeArrowVisible) {
            if (this.inverted) {
                b = true;
            }
            else {
                b2 = true;
            }
        }
        if (b) {
            double maxX = 0.0;
            double minY = 0.0;
            Shape shape2 = null;
            if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
                maxX = rectangle2D.getMaxX();
                minY = n;
                shape2 = this.rightArrow;
            }
            else if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
                maxX = n;
                minY = rectangle2D.getMinY();
                shape2 = this.upArrow;
            }
            final AffineTransform affineTransform = new AffineTransform();
            affineTransform.setToTranslation(maxX, minY);
            final Shape transformedShape = affineTransform.createTransformedShape(shape2);
            graphics2D.fill(transformedShape);
            graphics2D.draw(transformedShape);
        }
        if (b2) {
            double minX = 0.0;
            double maxY = 0.0;
            Shape shape3 = null;
            if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
                minX = rectangle2D.getMinX();
                maxY = n;
                shape3 = this.leftArrow;
            }
            else if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
                minX = n;
                maxY = rectangle2D.getMaxY();
                shape3 = this.downArrow;
            }
            final AffineTransform affineTransform2 = new AffineTransform();
            affineTransform2.setToTranslation(minX, maxY);
            final Shape transformedShape2 = affineTransform2.createTransformedShape(shape3);
            graphics2D.fill(transformedShape2);
            graphics2D.draw(transformedShape2);
        }
    }
    
    protected float[] calculateAnchorPoint(final ValueTick valueTick, final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final RectangleInsets tickLabelInsets = this.getTickLabelInsets();
        final float[] array = new float[2];
        if (rectangleEdge == RectangleEdge.TOP) {
            array[0] = (float)this.valueToJava2D(valueTick.getValue(), rectangle2D, rectangleEdge);
            array[1] = (float)(n - tickLabelInsets.getBottom() - 2.0);
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            array[0] = (float)this.valueToJava2D(valueTick.getValue(), rectangle2D, rectangleEdge);
            array[1] = (float)(n + tickLabelInsets.getTop() + 2.0);
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            array[0] = (float)(n - tickLabelInsets.getLeft() - 2.0);
            array[1] = (float)this.valueToJava2D(valueTick.getValue(), rectangle2D, rectangleEdge);
        }
        else if (rectangleEdge == RectangleEdge.RIGHT) {
            array[0] = (float)(n + tickLabelInsets.getRight() + 2.0);
            array[1] = (float)this.valueToJava2D(valueTick.getValue(), rectangle2D, rectangleEdge);
        }
        return array;
    }
    
    protected AxisState drawTickMarksAndLabels(final Graphics2D graphics2D, final double n, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge) {
        final AxisState axisState = new AxisState(n);
        if (this.isAxisLineVisible()) {
            this.drawAxisLine(graphics2D, n, rectangle2D2, rectangleEdge);
        }
        final double n2 = this.getTickMarkOutsideLength();
        final double n3 = this.getTickMarkInsideLength();
        final List refreshTicks = this.refreshTicks(graphics2D, axisState, rectangle2D2, rectangleEdge);
        axisState.setTicks(refreshTicks);
        graphics2D.setFont(this.getTickLabelFont());
        for (final ValueTick valueTick : refreshTicks) {
            if (this.isTickLabelsVisible()) {
                graphics2D.setPaint(this.getTickLabelPaint());
                final float[] calculateAnchorPoint = this.calculateAnchorPoint(valueTick, n, rectangle2D2, rectangleEdge);
                TextUtilities.drawRotatedString(valueTick.getText(), graphics2D, calculateAnchorPoint[0], calculateAnchorPoint[1], valueTick.getTextAnchor(), valueTick.getAngle(), valueTick.getRotationAnchor());
            }
            if (this.isTickMarksVisible()) {
                final float n4 = (float)this.valueToJava2D(valueTick.getValue(), rectangle2D2, rectangleEdge);
                Shape shape = null;
                graphics2D.setStroke(this.getTickMarkStroke());
                graphics2D.setPaint(this.getTickMarkPaint());
                if (rectangleEdge == RectangleEdge.LEFT) {
                    shape = new Line2D.Double(n - n2, n4, n + n3, n4);
                }
                else if (rectangleEdge == RectangleEdge.RIGHT) {
                    shape = new Line2D.Double(n + n2, n4, n - n3, n4);
                }
                else if (rectangleEdge == RectangleEdge.TOP) {
                    shape = new Line2D.Double(n4, n - n2, n4, n + n3);
                }
                else if (rectangleEdge == RectangleEdge.BOTTOM) {
                    shape = new Line2D.Double(n4, n + n2, n4, n - n3);
                }
                graphics2D.draw(shape);
            }
        }
        final double n5 = 0.0;
        if (this.isTickLabelsVisible()) {
            if (rectangleEdge == RectangleEdge.LEFT) {
                axisState.cursorLeft(n5 + this.findMaximumTickLabelWidth(refreshTicks, graphics2D, rectangle2D, this.isVerticalTickLabels()));
            }
            else if (rectangleEdge == RectangleEdge.RIGHT) {
                axisState.cursorRight(this.findMaximumTickLabelWidth(refreshTicks, graphics2D, rectangle2D, this.isVerticalTickLabels()));
            }
            else if (rectangleEdge == RectangleEdge.TOP) {
                axisState.cursorUp(this.findMaximumTickLabelHeight(refreshTicks, graphics2D, rectangle2D, this.isVerticalTickLabels()));
            }
            else if (rectangleEdge == RectangleEdge.BOTTOM) {
                axisState.cursorDown(this.findMaximumTickLabelHeight(refreshTicks, graphics2D, rectangle2D, this.isVerticalTickLabels()));
            }
        }
        return axisState;
    }
    
    public AxisSpace reserveSpace(final Graphics2D graphics2D, final Plot plot, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge, AxisSpace axisSpace) {
        if (axisSpace == null) {
            axisSpace = new AxisSpace();
        }
        if (!this.isVisible()) {
            return axisSpace;
        }
        final double fixedDimension = this.getFixedDimension();
        if (fixedDimension > 0.0) {
            axisSpace.ensureAtLeast(fixedDimension, rectangleEdge);
        }
        double maximumTickLabelHeight = 0.0;
        double maximumTickLabelWidth = 0.0;
        if (this.isTickLabelsVisible()) {
            graphics2D.setFont(this.getTickLabelFont());
            final List refreshTicks = this.refreshTicks(graphics2D, new AxisState(), rectangle2D, rectangleEdge);
            if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
                maximumTickLabelHeight = this.findMaximumTickLabelHeight(refreshTicks, graphics2D, rectangle2D, this.isVerticalTickLabels());
            }
            else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
                maximumTickLabelWidth = this.findMaximumTickLabelWidth(refreshTicks, graphics2D, rectangle2D, this.isVerticalTickLabels());
            }
        }
        final Rectangle2D labelEnclosure = this.getLabelEnclosure(graphics2D, rectangleEdge);
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            axisSpace.add(labelEnclosure.getHeight() + maximumTickLabelHeight, rectangleEdge);
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            axisSpace.add(labelEnclosure.getWidth() + maximumTickLabelWidth, rectangleEdge);
        }
        return axisSpace;
    }
    
    protected double findMaximumTickLabelHeight(final List list, final Graphics2D graphics2D, final Rectangle2D rectangle2D, final boolean b) {
        final RectangleInsets tickLabelInsets = this.getTickLabelInsets();
        final Font tickLabelFont = this.getTickLabelFont();
        double n = 0.0;
        if (b) {
            final FontMetrics fontMetrics = graphics2D.getFontMetrics(tickLabelFont);
            final Iterator<Tick> iterator = list.iterator();
            while (iterator.hasNext()) {
                final Rectangle2D textBounds = TextUtilities.getTextBounds(iterator.next().getText(), graphics2D, fontMetrics);
                if (textBounds.getWidth() + tickLabelInsets.getTop() + tickLabelInsets.getBottom() > n) {
                    n = textBounds.getWidth() + tickLabelInsets.getTop() + tickLabelInsets.getBottom();
                }
            }
        }
        else {
            n = tickLabelFont.getLineMetrics("ABCxyz", graphics2D.getFontRenderContext()).getHeight() + tickLabelInsets.getTop() + tickLabelInsets.getBottom();
        }
        return n;
    }
    
    protected double findMaximumTickLabelWidth(final List list, final Graphics2D graphics2D, final Rectangle2D rectangle2D, final boolean b) {
        final RectangleInsets tickLabelInsets = this.getTickLabelInsets();
        final Font tickLabelFont = this.getTickLabelFont();
        double n = 0.0;
        if (!b) {
            final FontMetrics fontMetrics = graphics2D.getFontMetrics(tickLabelFont);
            final Iterator<Tick> iterator = list.iterator();
            while (iterator.hasNext()) {
                final Rectangle2D textBounds = TextUtilities.getTextBounds(iterator.next().getText(), graphics2D, fontMetrics);
                if (textBounds.getWidth() + tickLabelInsets.getLeft() + tickLabelInsets.getRight() > n) {
                    n = textBounds.getWidth() + tickLabelInsets.getLeft() + tickLabelInsets.getRight();
                }
            }
        }
        else {
            n = tickLabelFont.getLineMetrics("ABCxyz", graphics2D.getFontRenderContext()).getHeight() + tickLabelInsets.getTop() + tickLabelInsets.getBottom();
        }
        return n;
    }
    
    public boolean isInverted() {
        return this.inverted;
    }
    
    public void setInverted(final boolean inverted) {
        if (this.inverted != inverted) {
            this.inverted = inverted;
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public boolean isAutoRange() {
        return this.autoRange;
    }
    
    public void setAutoRange(final boolean b) {
        this.setAutoRange(b, true);
    }
    
    protected void setAutoRange(final boolean autoRange, final boolean b) {
        if (this.autoRange != autoRange) {
            this.autoRange = autoRange;
            if (this.autoRange) {
                this.autoAdjustRange();
            }
            if (b) {
                this.notifyListeners(new AxisChangeEvent(this));
            }
        }
    }
    
    public double getAutoRangeMinimumSize() {
        return this.autoRangeMinimumSize;
    }
    
    public void setAutoRangeMinimumSize(final double n) {
        this.setAutoRangeMinimumSize(n, true);
    }
    
    public void setAutoRangeMinimumSize(final double autoRangeMinimumSize, final boolean b) {
        if (autoRangeMinimumSize <= 0.0) {
            throw new IllegalArgumentException("NumberAxis.setAutoRangeMinimumSize(double): must be > 0.0.");
        }
        if (this.autoRangeMinimumSize != autoRangeMinimumSize) {
            this.autoRangeMinimumSize = autoRangeMinimumSize;
            if (this.autoRange) {
                this.autoAdjustRange();
            }
            if (b) {
                this.notifyListeners(new AxisChangeEvent(this));
            }
        }
    }
    
    public Range getDefaultAutoRange() {
        return this.defaultAutoRange;
    }
    
    public void setDefaultAutoRange(final Range defaultAutoRange) {
        if (defaultAutoRange == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        this.defaultAutoRange = defaultAutoRange;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public double getLowerMargin() {
        return this.lowerMargin;
    }
    
    public void setLowerMargin(final double lowerMargin) {
        this.lowerMargin = lowerMargin;
        if (this.isAutoRange()) {
            this.autoAdjustRange();
        }
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public double getUpperMargin() {
        return this.upperMargin;
    }
    
    public void setUpperMargin(final double upperMargin) {
        this.upperMargin = upperMargin;
        if (this.isAutoRange()) {
            this.autoAdjustRange();
        }
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public double getFixedAutoRange() {
        return this.fixedAutoRange;
    }
    
    public void setFixedAutoRange(final double fixedAutoRange) {
        this.fixedAutoRange = fixedAutoRange;
        if (this.isAutoRange()) {
            this.autoAdjustRange();
        }
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public double getLowerBound() {
        return this.range.getLowerBound();
    }
    
    public void setLowerBound(final double n) {
        if (this.range.getUpperBound() > n) {
            this.setRange(new Range(n, this.range.getUpperBound()));
        }
        else {
            this.setRange(new Range(n, n + 1.0));
        }
    }
    
    public double getUpperBound() {
        return this.range.getUpperBound();
    }
    
    public void setUpperBound(final double n) {
        if (this.range.getLowerBound() < n) {
            this.setRange(new Range(this.range.getLowerBound(), n));
        }
        else {
            this.setRange(n - 1.0, n);
        }
    }
    
    public Range getRange() {
        return this.range;
    }
    
    public void setRange(final Range range) {
        this.setRange(range, true, true);
    }
    
    public void setRange(final Range range, final boolean b, final boolean b2) {
        if (range == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        if (b) {
            this.autoRange = false;
        }
        this.range = range;
        if (b2) {
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public void setRange(final double n, final double n2) {
        this.setRange(new Range(n, n2));
    }
    
    public void setRangeWithMargins(final Range range) {
        this.setRangeWithMargins(range, true, true);
    }
    
    public void setRangeWithMargins(final Range range, final boolean b, final boolean b2) {
        if (range == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        this.setRange(Range.expand(range, this.getLowerMargin(), this.getUpperMargin()), b, b2);
    }
    
    public void setRangeWithMargins(final double n, final double n2) {
        this.setRangeWithMargins(new Range(n, n2));
    }
    
    public void setRangeAboutValue(final double n, final double n2) {
        this.setRange(new Range(n - n2 / 2.0, n + n2 / 2.0));
    }
    
    public boolean isAutoTickUnitSelection() {
        return this.autoTickUnitSelection;
    }
    
    public void setAutoTickUnitSelection(final boolean b) {
        this.setAutoTickUnitSelection(b, true);
    }
    
    public void setAutoTickUnitSelection(final boolean autoTickUnitSelection, final boolean b) {
        if (this.autoTickUnitSelection != autoTickUnitSelection) {
            this.autoTickUnitSelection = autoTickUnitSelection;
            if (b) {
                this.notifyListeners(new AxisChangeEvent(this));
            }
        }
    }
    
    public TickUnitSource getStandardTickUnits() {
        return this.standardTickUnits;
    }
    
    public void setStandardTickUnits(final TickUnitSource standardTickUnits) {
        this.standardTickUnits = standardTickUnits;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public abstract double valueToJava2D(final double p0, final Rectangle2D p1, final RectangleEdge p2);
    
    public double lengthToJava2D(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        return Math.abs(this.valueToJava2D(n, rectangle2D, rectangleEdge) - this.valueToJava2D(0.0, rectangle2D, rectangleEdge));
    }
    
    public abstract double java2DToValue(final double p0, final Rectangle2D p1, final RectangleEdge p2);
    
    protected abstract void autoAdjustRange();
    
    public void centerRange(final double n) {
        final double centralValue = this.range.getCentralValue();
        this.setRange(new Range(this.range.getLowerBound() + n - centralValue, this.range.getUpperBound() + n - centralValue));
    }
    
    public void resizeRange(final double n) {
        this.resizeRange(n, this.range.getCentralValue());
    }
    
    public void resizeRange(final double n, final double n2) {
        if (n > 0.0) {
            final double n3 = this.range.getLength() * n / 2.0;
            this.setRange(new Range(n2 - n3, n2 + n3));
        }
        else {
            this.setAutoRange(true);
        }
    }
    
    public void zoomRange(final double n, final double n2) {
        final double lowerBound = this.range.getLowerBound();
        final double length = this.range.getLength();
        Range range;
        if (this.isInverted()) {
            range = new Range(lowerBound + length * (1.0 - n2), lowerBound + length * (1.0 - n));
        }
        else {
            range = new Range(lowerBound + length * n, lowerBound + length * n2);
        }
        this.setRange(range);
    }
    
    protected int getAutoTickIndex() {
        return this.autoTickIndex;
    }
    
    protected void setAutoTickIndex(final int autoTickIndex) {
        this.autoTickIndex = autoTickIndex;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ValueAxis)) {
            return false;
        }
        final ValueAxis valueAxis = (ValueAxis)o;
        return this.positiveArrowVisible == valueAxis.positiveArrowVisible && this.negativeArrowVisible == valueAxis.negativeArrowVisible && this.inverted == valueAxis.inverted && ObjectUtilities.equal(this.range, valueAxis.range) && this.autoRange == valueAxis.autoRange && this.autoRangeMinimumSize == valueAxis.autoRangeMinimumSize && this.defaultAutoRange.equals(valueAxis.defaultAutoRange) && this.upperMargin == valueAxis.upperMargin && this.lowerMargin == valueAxis.lowerMargin && this.fixedAutoRange == valueAxis.fixedAutoRange && this.autoTickUnitSelection == valueAxis.autoTickUnitSelection && ObjectUtilities.equal(this.standardTickUnits, valueAxis.standardTickUnits) && this.verticalTickLabels == valueAxis.verticalTickLabels && super.equals(o);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.upArrow, objectOutputStream);
        SerialUtilities.writeShape(this.downArrow, objectOutputStream);
        SerialUtilities.writeShape(this.leftArrow, objectOutputStream);
        SerialUtilities.writeShape(this.rightArrow, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.upArrow = SerialUtilities.readShape(objectInputStream);
        this.downArrow = SerialUtilities.readShape(objectInputStream);
        this.leftArrow = SerialUtilities.readShape(objectInputStream);
        this.rightArrow = SerialUtilities.readShape(objectInputStream);
    }
    
    static {
        DEFAULT_RANGE = new Range(0.0, 1.0);
    }
}
