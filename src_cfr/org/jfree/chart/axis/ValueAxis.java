/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.Tick;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueTick;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.plot.Plot;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public abstract class ValueAxis
extends Axis
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = 3698345477322391456L;
    public static final Range DEFAULT_RANGE = new Range(0.0, 1.0);
    public static final boolean DEFAULT_AUTO_RANGE = true;
    public static final boolean DEFAULT_INVERTED = false;
    public static final double DEFAULT_AUTO_RANGE_MINIMUM_SIZE = 1.0E-8;
    public static final double DEFAULT_LOWER_MARGIN = 0.05;
    public static final double DEFAULT_UPPER_MARGIN = 0.05;
    public static final double DEFAULT_LOWER_BOUND = 0.0;
    public static final double DEFAULT_UPPER_BOUND = 1.0;
    public static final boolean DEFAULT_AUTO_TICK_UNIT_SELECTION = true;
    public static final int MAXIMUM_TICK_COUNT = 500;
    private boolean positiveArrowVisible = false;
    private boolean negativeArrowVisible = false;
    private transient Shape upArrow;
    private transient Shape downArrow;
    private transient Shape leftArrow;
    private transient Shape rightArrow;
    private boolean inverted = false;
    private Range range = DEFAULT_RANGE;
    private boolean autoRange = true;
    private double autoRangeMinimumSize = 1.0E-8;
    private Range defaultAutoRange = DEFAULT_RANGE;
    private double upperMargin = 0.05;
    private double lowerMargin = 0.05;
    private double fixedAutoRange = 0.0;
    private boolean autoTickUnitSelection = true;
    private TickUnitSource standardTickUnits;
    private int autoTickIndex;
    private boolean verticalTickLabels;

    protected ValueAxis(String string, TickUnitSource tickUnitSource) {
        super(string);
        this.standardTickUnits = tickUnitSource;
        Polygon polygon = new Polygon();
        polygon.addPoint(0, 0);
        polygon.addPoint(-2, 2);
        polygon.addPoint(2, 2);
        this.upArrow = polygon;
        Polygon polygon2 = new Polygon();
        polygon2.addPoint(0, 0);
        polygon2.addPoint(-2, -2);
        polygon2.addPoint(2, -2);
        this.downArrow = polygon2;
        Polygon polygon3 = new Polygon();
        polygon3.addPoint(0, 0);
        polygon3.addPoint(-2, -2);
        polygon3.addPoint(-2, 2);
        this.rightArrow = polygon3;
        Polygon polygon4 = new Polygon();
        polygon4.addPoint(0, 0);
        polygon4.addPoint(2, -2);
        polygon4.addPoint(2, 2);
        this.leftArrow = polygon4;
        this.verticalTickLabels = false;
    }

    public boolean isVerticalTickLabels() {
        return this.verticalTickLabels;
    }

    public void setVerticalTickLabels(boolean bl2) {
        if (this.verticalTickLabels == bl2) return;
        this.verticalTickLabels = bl2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public boolean isPositiveArrowVisible() {
        return this.positiveArrowVisible;
    }

    public void setPositiveArrowVisible(boolean bl2) {
        this.positiveArrowVisible = bl2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public boolean isNegativeArrowVisible() {
        return this.negativeArrowVisible;
    }

    public void setNegativeArrowVisible(boolean bl2) {
        this.negativeArrowVisible = bl2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Shape getUpArrow() {
        return this.upArrow;
    }

    public void setUpArrow(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'arrow' argument.");
        }
        this.upArrow = shape;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Shape getDownArrow() {
        return this.downArrow;
    }

    public void setDownArrow(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'arrow' argument.");
        }
        this.downArrow = shape;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Shape getLeftArrow() {
        return this.leftArrow;
    }

    public void setLeftArrow(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'arrow' argument.");
        }
        this.leftArrow = shape;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Shape getRightArrow() {
        return this.rightArrow;
    }

    public void setRightArrow(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'arrow' argument.");
        }
        this.rightArrow = shape;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    @Override
    protected void drawAxisLine(Graphics2D graphics2D, double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d3;
        Shape shape;
        Shape shape2;
        AffineTransform affineTransform;
        double d4;
        Line2D.Double double_ = null;
        if (rectangleEdge == RectangleEdge.TOP) {
            double_ = new Line2D.Double(rectangle2D.getX(), d2, rectangle2D.getMaxX(), d2);
        } else if (rectangleEdge == RectangleEdge.BOTTOM) {
            double_ = new Line2D.Double(rectangle2D.getX(), d2, rectangle2D.getMaxX(), d2);
        } else if (rectangleEdge == RectangleEdge.LEFT) {
            double_ = new Line2D.Double(d2, rectangle2D.getY(), d2, rectangle2D.getMaxY());
        } else if (rectangleEdge == RectangleEdge.RIGHT) {
            double_ = new Line2D.Double(d2, rectangle2D.getY(), d2, rectangle2D.getMaxY());
        }
        graphics2D.setPaint(this.getAxisLinePaint());
        graphics2D.setStroke(this.getAxisLineStroke());
        graphics2D.draw(double_);
        boolean bl2 = false;
        boolean bl3 = false;
        if (this.positiveArrowVisible) {
            if (this.inverted) {
                bl3 = true;
            } else {
                bl2 = true;
            }
        }
        if (this.negativeArrowVisible) {
            if (this.inverted) {
                bl2 = true;
            } else {
                bl3 = true;
            }
        }
        if (bl2) {
            d4 = 0.0;
            d3 = 0.0;
            shape2 = null;
            if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
                d4 = rectangle2D.getMaxX();
                d3 = d2;
                shape2 = this.rightArrow;
            } else if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
                d4 = d2;
                d3 = rectangle2D.getMinY();
                shape2 = this.upArrow;
            }
            affineTransform = new AffineTransform();
            affineTransform.setToTranslation(d4, d3);
            shape = affineTransform.createTransformedShape(shape2);
            graphics2D.fill(shape);
            graphics2D.draw(shape);
        }
        if (!bl3) return;
        d4 = 0.0;
        d3 = 0.0;
        shape2 = null;
        if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
            d4 = rectangle2D.getMinX();
            d3 = d2;
            shape2 = this.leftArrow;
        } else if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
            d4 = d2;
            d3 = rectangle2D.getMaxY();
            shape2 = this.downArrow;
        }
        affineTransform = new AffineTransform();
        affineTransform.setToTranslation(d4, d3);
        shape = affineTransform.createTransformedShape(shape2);
        graphics2D.fill(shape);
        graphics2D.draw(shape);
    }

    protected float[] calculateAnchorPoint(ValueTick valueTick, double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        RectangleInsets rectangleInsets = this.getTickLabelInsets();
        float[] arrf = new float[2];
        if (rectangleEdge == RectangleEdge.TOP) {
            arrf[0] = (float)this.valueToJava2D(valueTick.getValue(), rectangle2D, rectangleEdge);
            arrf[1] = (float)(d2 - rectangleInsets.getBottom() - 2.0);
            return arrf;
        }
        if (rectangleEdge == RectangleEdge.BOTTOM) {
            arrf[0] = (float)this.valueToJava2D(valueTick.getValue(), rectangle2D, rectangleEdge);
            arrf[1] = (float)(d2 + rectangleInsets.getTop() + 2.0);
            return arrf;
        }
        if (rectangleEdge == RectangleEdge.LEFT) {
            arrf[0] = (float)(d2 - rectangleInsets.getLeft() - 2.0);
            arrf[1] = (float)this.valueToJava2D(valueTick.getValue(), rectangle2D, rectangleEdge);
            return arrf;
        }
        if (rectangleEdge != RectangleEdge.RIGHT) return arrf;
        arrf[0] = (float)(d2 + rectangleInsets.getRight() + 2.0);
        arrf[1] = (float)this.valueToJava2D(valueTick.getValue(), rectangle2D, rectangleEdge);
        return arrf;
    }

    protected AxisState drawTickMarksAndLabels(Graphics2D graphics2D, double d2, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge) {
        AxisState axisState = new AxisState(d2);
        if (this.isAxisLineVisible()) {
            this.drawAxisLine(graphics2D, d2, rectangle2D2, rectangleEdge);
        }
        double d3 = this.getTickMarkOutsideLength();
        double d4 = this.getTickMarkInsideLength();
        List list = this.refreshTicks(graphics2D, axisState, rectangle2D2, rectangleEdge);
        axisState.setTicks(list);
        graphics2D.setFont(this.getTickLabelFont());
        for (ValueTick valueTick : list) {
            if (this.isTickLabelsVisible()) {
                graphics2D.setPaint(this.getTickLabelPaint());
                float[] arrf = this.calculateAnchorPoint(valueTick, d2, rectangle2D2, rectangleEdge);
                TextUtilities.drawRotatedString(valueTick.getText(), graphics2D, arrf[0], arrf[1], valueTick.getTextAnchor(), valueTick.getAngle(), valueTick.getRotationAnchor());
            }
            if (!this.isTickMarksVisible()) continue;
            float f2 = (float)this.valueToJava2D(valueTick.getValue(), rectangle2D2, rectangleEdge);
            Line2D.Double double_ = null;
            graphics2D.setStroke(this.getTickMarkStroke());
            graphics2D.setPaint(this.getTickMarkPaint());
            if (rectangleEdge == RectangleEdge.LEFT) {
                double_ = new Line2D.Double(d2 - d3, f2, d2 + d4, f2);
            } else if (rectangleEdge == RectangleEdge.RIGHT) {
                double_ = new Line2D.Double(d2 + d3, f2, d2 - d4, f2);
            } else if (rectangleEdge == RectangleEdge.TOP) {
                double_ = new Line2D.Double(f2, d2 - d3, f2, d2 + d4);
            } else if (rectangleEdge == RectangleEdge.BOTTOM) {
                double_ = new Line2D.Double(f2, d2 + d3, f2, d2 - d4);
            }
            graphics2D.draw(double_);
        }
        double d5 = 0.0;
        if (!this.isTickLabelsVisible()) return axisState;
        if (rectangleEdge == RectangleEdge.LEFT) {
            axisState.cursorLeft(d5 += this.findMaximumTickLabelWidth(list, graphics2D, rectangle2D, this.isVerticalTickLabels()));
            return axisState;
        }
        if (rectangleEdge == RectangleEdge.RIGHT) {
            d5 = this.findMaximumTickLabelWidth(list, graphics2D, rectangle2D, this.isVerticalTickLabels());
            axisState.cursorRight(d5);
            return axisState;
        }
        if (rectangleEdge == RectangleEdge.TOP) {
            d5 = this.findMaximumTickLabelHeight(list, graphics2D, rectangle2D, this.isVerticalTickLabels());
            axisState.cursorUp(d5);
            return axisState;
        }
        if (rectangleEdge != RectangleEdge.BOTTOM) return axisState;
        d5 = this.findMaximumTickLabelHeight(list, graphics2D, rectangle2D, this.isVerticalTickLabels());
        axisState.cursorDown(d5);
        return axisState;
    }

    @Override
    public AxisSpace reserveSpace(Graphics2D graphics2D, Plot plot, Rectangle2D rectangle2D, RectangleEdge rectangleEdge, AxisSpace axisSpace) {
        Object object;
        if (axisSpace == null) {
            axisSpace = new AxisSpace();
        }
        if (!this.isVisible()) {
            return axisSpace;
        }
        double d2 = this.getFixedDimension();
        if (d2 > 0.0) {
            axisSpace.ensureAtLeast(d2, rectangleEdge);
        }
        double d3 = 0.0;
        double d4 = 0.0;
        if (this.isTickLabelsVisible()) {
            graphics2D.setFont(this.getTickLabelFont());
            object = this.refreshTicks(graphics2D, new AxisState(), rectangle2D, rectangleEdge);
            if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
                d3 = this.findMaximumTickLabelHeight((List)object, graphics2D, rectangle2D, this.isVerticalTickLabels());
            } else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
                d4 = this.findMaximumTickLabelWidth((List)object, graphics2D, rectangle2D, this.isVerticalTickLabels());
            }
        }
        object = this.getLabelEnclosure(graphics2D, rectangleEdge);
        double d5 = 0.0;
        double d6 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            d5 = object.getHeight();
            axisSpace.add(d5 + d3, rectangleEdge);
            return axisSpace;
        }
        if (!RectangleEdge.isLeftOrRight(rectangleEdge)) return axisSpace;
        d6 = object.getWidth();
        axisSpace.add(d6 + d4, rectangleEdge);
        return axisSpace;
    }

    protected double findMaximumTickLabelHeight(List list, Graphics2D graphics2D, Rectangle2D rectangle2D, boolean bl2) {
        RectangleInsets rectangleInsets = this.getTickLabelInsets();
        Font font = this.getTickLabelFont();
        double d2 = 0.0;
        if (!bl2) {
            LineMetrics lineMetrics = font.getLineMetrics("ABCxyz", graphics2D.getFontRenderContext());
            return (double)lineMetrics.getHeight() + rectangleInsets.getTop() + rectangleInsets.getBottom();
        }
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Tick tick = (Tick)iterator.next();
            Rectangle2D rectangle2D2 = TextUtilities.getTextBounds(tick.getText(), graphics2D, fontMetrics);
            if (rectangle2D2.getWidth() + rectangleInsets.getTop() + rectangleInsets.getBottom() <= d2) continue;
            d2 = rectangle2D2.getWidth() + rectangleInsets.getTop() + rectangleInsets.getBottom();
        }
        return d2;
    }

    protected double findMaximumTickLabelWidth(List list, Graphics2D graphics2D, Rectangle2D rectangle2D, boolean bl2) {
        RectangleInsets rectangleInsets = this.getTickLabelInsets();
        Font font = this.getTickLabelFont();
        double d2 = 0.0;
        if (bl2) {
            LineMetrics lineMetrics = font.getLineMetrics("ABCxyz", graphics2D.getFontRenderContext());
            return (double)lineMetrics.getHeight() + rectangleInsets.getTop() + rectangleInsets.getBottom();
        }
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Tick tick = (Tick)iterator.next();
            Rectangle2D rectangle2D2 = TextUtilities.getTextBounds(tick.getText(), graphics2D, fontMetrics);
            if (rectangle2D2.getWidth() + rectangleInsets.getLeft() + rectangleInsets.getRight() <= d2) continue;
            d2 = rectangle2D2.getWidth() + rectangleInsets.getLeft() + rectangleInsets.getRight();
        }
        return d2;
    }

    public boolean isInverted() {
        return this.inverted;
    }

    public void setInverted(boolean bl2) {
        if (this.inverted == bl2) return;
        this.inverted = bl2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public boolean isAutoRange() {
        return this.autoRange;
    }

    public void setAutoRange(boolean bl2) {
        this.setAutoRange(bl2, true);
    }

    protected void setAutoRange(boolean bl2, boolean bl3) {
        if (this.autoRange == bl2) return;
        this.autoRange = bl2;
        if (this.autoRange) {
            this.autoAdjustRange();
        }
        if (!bl3) return;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public double getAutoRangeMinimumSize() {
        return this.autoRangeMinimumSize;
    }

    public void setAutoRangeMinimumSize(double d2) {
        this.setAutoRangeMinimumSize(d2, true);
    }

    public void setAutoRangeMinimumSize(double d2, boolean bl2) {
        if (d2 <= 0.0) {
            throw new IllegalArgumentException("NumberAxis.setAutoRangeMinimumSize(double): must be > 0.0.");
        }
        if (this.autoRangeMinimumSize == d2) return;
        this.autoRangeMinimumSize = d2;
        if (this.autoRange) {
            this.autoAdjustRange();
        }
        if (!bl2) return;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Range getDefaultAutoRange() {
        return this.defaultAutoRange;
    }

    public void setDefaultAutoRange(Range range) {
        if (range == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        this.defaultAutoRange = range;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public double getLowerMargin() {
        return this.lowerMargin;
    }

    public void setLowerMargin(double d2) {
        this.lowerMargin = d2;
        if (this.isAutoRange()) {
            this.autoAdjustRange();
        }
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public double getUpperMargin() {
        return this.upperMargin;
    }

    public void setUpperMargin(double d2) {
        this.upperMargin = d2;
        if (this.isAutoRange()) {
            this.autoAdjustRange();
        }
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public double getFixedAutoRange() {
        return this.fixedAutoRange;
    }

    public void setFixedAutoRange(double d2) {
        this.fixedAutoRange = d2;
        if (this.isAutoRange()) {
            this.autoAdjustRange();
        }
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public double getLowerBound() {
        return this.range.getLowerBound();
    }

    public void setLowerBound(double d2) {
        if (this.range.getUpperBound() > d2) {
            this.setRange(new Range(d2, this.range.getUpperBound()));
            return;
        }
        this.setRange(new Range(d2, d2 + 1.0));
    }

    public double getUpperBound() {
        return this.range.getUpperBound();
    }

    public void setUpperBound(double d2) {
        if (this.range.getLowerBound() < d2) {
            this.setRange(new Range(this.range.getLowerBound(), d2));
            return;
        }
        this.setRange(d2 - 1.0, d2);
    }

    public Range getRange() {
        return this.range;
    }

    public void setRange(Range range) {
        this.setRange(range, true, true);
    }

    public void setRange(Range range, boolean bl2, boolean bl3) {
        if (range == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        if (bl2) {
            this.autoRange = false;
        }
        this.range = range;
        if (!bl3) return;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public void setRange(double d2, double d3) {
        this.setRange(new Range(d2, d3));
    }

    public void setRangeWithMargins(Range range) {
        this.setRangeWithMargins(range, true, true);
    }

    public void setRangeWithMargins(Range range, boolean bl2, boolean bl3) {
        if (range == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        this.setRange(Range.expand(range, this.getLowerMargin(), this.getUpperMargin()), bl2, bl3);
    }

    public void setRangeWithMargins(double d2, double d3) {
        this.setRangeWithMargins(new Range(d2, d3));
    }

    public void setRangeAboutValue(double d2, double d3) {
        this.setRange(new Range(d2 - d3 / 2.0, d2 + d3 / 2.0));
    }

    public boolean isAutoTickUnitSelection() {
        return this.autoTickUnitSelection;
    }

    public void setAutoTickUnitSelection(boolean bl2) {
        this.setAutoTickUnitSelection(bl2, true);
    }

    public void setAutoTickUnitSelection(boolean bl2, boolean bl3) {
        if (this.autoTickUnitSelection == bl2) return;
        this.autoTickUnitSelection = bl2;
        if (!bl3) return;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public TickUnitSource getStandardTickUnits() {
        return this.standardTickUnits;
    }

    public void setStandardTickUnits(TickUnitSource tickUnitSource) {
        this.standardTickUnits = tickUnitSource;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public abstract double valueToJava2D(double var1, Rectangle2D var3, RectangleEdge var4);

    public double lengthToJava2D(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d3 = this.valueToJava2D(0.0, rectangle2D, rectangleEdge);
        double d4 = this.valueToJava2D(d2, rectangle2D, rectangleEdge);
        return Math.abs(d4 - d3);
    }

    public abstract double java2DToValue(double var1, Rectangle2D var3, RectangleEdge var4);

    protected abstract void autoAdjustRange();

    public void centerRange(double d2) {
        double d3 = this.range.getCentralValue();
        Range range = new Range(this.range.getLowerBound() + d2 - d3, this.range.getUpperBound() + d2 - d3);
        this.setRange(range);
    }

    public void resizeRange(double d2) {
        this.resizeRange(d2, this.range.getCentralValue());
    }

    public void resizeRange(double d2, double d3) {
        if (d2 > 0.0) {
            double d4 = this.range.getLength() * d2 / 2.0;
            Range range = new Range(d3 - d4, d3 + d4);
            this.setRange(range);
            return;
        }
        this.setAutoRange(true);
    }

    public void zoomRange(double d2, double d3) {
        double d4 = this.range.getLowerBound();
        double d5 = this.range.getLength();
        Range range = null;
        range = this.isInverted() ? new Range(d4 + d5 * (1.0 - d3), d4 + d5 * (1.0 - d2)) : new Range(d4 + d5 * d2, d4 + d5 * d3);
        this.setRange(range);
    }

    protected int getAutoTickIndex() {
        return this.autoTickIndex;
    }

    protected void setAutoTickIndex(int n2) {
        this.autoTickIndex = n2;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ValueAxis)) {
            return false;
        }
        ValueAxis valueAxis = (ValueAxis)object;
        if (this.positiveArrowVisible != valueAxis.positiveArrowVisible) {
            return false;
        }
        if (this.negativeArrowVisible != valueAxis.negativeArrowVisible) {
            return false;
        }
        if (this.inverted != valueAxis.inverted) {
            return false;
        }
        if (!ObjectUtilities.equal(this.range, valueAxis.range)) {
            return false;
        }
        if (this.autoRange != valueAxis.autoRange) {
            return false;
        }
        if (this.autoRangeMinimumSize != valueAxis.autoRangeMinimumSize) {
            return false;
        }
        if (!this.defaultAutoRange.equals(valueAxis.defaultAutoRange)) {
            return false;
        }
        if (this.upperMargin != valueAxis.upperMargin) {
            return false;
        }
        if (this.lowerMargin != valueAxis.lowerMargin) {
            return false;
        }
        if (this.fixedAutoRange != valueAxis.fixedAutoRange) {
            return false;
        }
        if (this.autoTickUnitSelection != valueAxis.autoTickUnitSelection) {
            return false;
        }
        if (!ObjectUtilities.equal(this.standardTickUnits, valueAxis.standardTickUnits)) {
            return false;
        }
        if (this.verticalTickLabels == valueAxis.verticalTickLabels) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        return (ValueAxis)super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.upArrow, objectOutputStream);
        SerialUtilities.writeShape(this.downArrow, objectOutputStream);
        SerialUtilities.writeShape(this.leftArrow, objectOutputStream);
        SerialUtilities.writeShape(this.rightArrow, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.upArrow = SerialUtilities.readShape(objectInputStream);
        this.downArrow = SerialUtilities.readShape(objectInputStream);
        this.leftArrow = SerialUtilities.readShape(objectInputStream);
        this.rightArrow = SerialUtilities.readShape(objectInputStream);
    }
}

