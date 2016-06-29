package org.jfree.chart.axis;

import java.io.*;
import org.jfree.chart.event.*;
import org.jfree.data.*;
import java.awt.geom.*;
import org.jfree.chart.plot.*;
import java.text.*;
import java.awt.*;
import java.util.*;
import org.jfree.ui.*;
import org.jfree.util.*;

public class NumberAxis extends ValueAxis implements Serializable, Cloneable
{
    private static final long serialVersionUID = 2805933088476185789L;
    public static final boolean DEFAULT_AUTO_RANGE_INCLUDES_ZERO = true;
    public static final boolean DEFAULT_AUTO_RANGE_STICKY_ZERO = true;
    public static final NumberTickUnit DEFAULT_TICK_UNIT;
    public static final boolean DEFAULT_VERTICAL_TICK_LABELS = false;
    private RangeType rangeType;
    private boolean autoRangeIncludesZero;
    private boolean autoRangeStickyZero;
    private NumberTickUnit tickUnit;
    private NumberFormat numberFormatOverride;
    private MarkerAxisBand markerBand;
    
    public NumberAxis() {
        this(null);
    }
    
    public NumberAxis(final String s) {
        super(s, createStandardTickUnits());
        this.rangeType = RangeType.FULL;
        this.autoRangeIncludesZero = true;
        this.autoRangeStickyZero = true;
        this.tickUnit = NumberAxis.DEFAULT_TICK_UNIT;
        this.numberFormatOverride = null;
        this.markerBand = null;
    }
    
    public RangeType getRangeType() {
        return this.rangeType;
    }
    
    public void setRangeType(final RangeType rangeType) {
        if (rangeType == null) {
            throw new IllegalArgumentException("Null 'rangeType' argument.");
        }
        this.rangeType = rangeType;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public boolean getAutoRangeIncludesZero() {
        return this.autoRangeIncludesZero;
    }
    
    public void setAutoRangeIncludesZero(final boolean autoRangeIncludesZero) {
        if (this.autoRangeIncludesZero != autoRangeIncludesZero) {
            this.autoRangeIncludesZero = autoRangeIncludesZero;
            if (this.isAutoRange()) {
                this.autoAdjustRange();
            }
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public boolean getAutoRangeStickyZero() {
        return this.autoRangeStickyZero;
    }
    
    public void setAutoRangeStickyZero(final boolean autoRangeStickyZero) {
        if (this.autoRangeStickyZero != autoRangeStickyZero) {
            this.autoRangeStickyZero = autoRangeStickyZero;
            if (this.isAutoRange()) {
                this.autoAdjustRange();
            }
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public NumberTickUnit getTickUnit() {
        return this.tickUnit;
    }
    
    public void setTickUnit(final NumberTickUnit numberTickUnit) {
        this.setTickUnit(numberTickUnit, true, true);
    }
    
    public void setTickUnit(final NumberTickUnit tickUnit, final boolean b, final boolean b2) {
        if (tickUnit == null) {
            throw new IllegalArgumentException("Null 'unit' argument.");
        }
        this.tickUnit = tickUnit;
        if (b2) {
            this.setAutoTickUnitSelection(false, false);
        }
        if (b) {
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public NumberFormat getNumberFormatOverride() {
        return this.numberFormatOverride;
    }
    
    public void setNumberFormatOverride(final NumberFormat numberFormatOverride) {
        this.numberFormatOverride = numberFormatOverride;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public MarkerAxisBand getMarkerBand() {
        return this.markerBand;
    }
    
    public void setMarkerBand(final MarkerAxisBand markerBand) {
        this.markerBand = markerBand;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public void configure() {
        if (this.isAutoRange()) {
            this.autoAdjustRange();
        }
    }
    
    protected void autoAdjustRange() {
        final Plot plot = this.getPlot();
        if (plot == null) {
            return;
        }
        if (plot instanceof ValueAxisPlot) {
            Range range = ((ValueAxisPlot)plot).getDataRange(this);
            if (range == null) {
                range = this.getDefaultAutoRange();
            }
            double n = range.getUpperBound();
            double n2 = range.getLowerBound();
            if (this.rangeType == RangeType.POSITIVE) {
                n2 = Math.max(0.0, n2);
                n = Math.max(0.0, n);
            }
            else if (this.rangeType == RangeType.NEGATIVE) {
                n2 = Math.min(0.0, n2);
                n = Math.min(0.0, n);
            }
            if (this.getAutoRangeIncludesZero()) {
                n2 = Math.min(n2, 0.0);
                n = Math.max(n, 0.0);
            }
            final double n3 = n - n2;
            final double fixedAutoRange = this.getFixedAutoRange();
            double max;
            if (fixedAutoRange > 0.0) {
                max = n - fixedAutoRange;
            }
            else {
                final double autoRangeMinimumSize = this.getAutoRangeMinimumSize();
                if (n3 < autoRangeMinimumSize) {
                    final double n4 = (autoRangeMinimumSize - n3) / 2.0;
                    n += n4;
                    n2 -= n4;
                    if (n2 == n) {
                        final double n5 = Math.abs(n2) / 10.0;
                        n2 -= n5;
                        n += n5;
                    }
                    if (this.rangeType == RangeType.POSITIVE) {
                        if (n2 < 0.0) {
                            n -= n2;
                            n2 = 0.0;
                        }
                    }
                    else if (this.rangeType == RangeType.NEGATIVE && n > 0.0) {
                        n2 -= n;
                        n = 0.0;
                    }
                }
                if (this.getAutoRangeStickyZero()) {
                    if (n <= 0.0) {
                        n = Math.min(0.0, n + this.getUpperMargin() * n3);
                    }
                    else {
                        n += this.getUpperMargin() * n3;
                    }
                    if (n2 >= 0.0) {
                        max = Math.max(0.0, n2 - this.getLowerMargin() * n3);
                    }
                    else {
                        max = n2 - this.getLowerMargin() * n3;
                    }
                }
                else {
                    n += this.getUpperMargin() * n3;
                    max = n2 - this.getLowerMargin() * n3;
                }
            }
            this.setRange(new Range(max, n), false, false);
        }
    }
    
    public double valueToJava2D(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final Range range = this.getRange();
        final double lowerBound = range.getLowerBound();
        final double upperBound = range.getUpperBound();
        double n2 = 0.0;
        double n3 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            n2 = rectangle2D.getX();
            n3 = rectangle2D.getMaxX();
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            n3 = rectangle2D.getMinY();
            n2 = rectangle2D.getMaxY();
        }
        if (this.isInverted()) {
            return n3 - (n - lowerBound) / (upperBound - lowerBound) * (n3 - n2);
        }
        return n2 + (n - lowerBound) / (upperBound - lowerBound) * (n3 - n2);
    }
    
    public double java2DToValue(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final Range range = this.getRange();
        final double lowerBound = range.getLowerBound();
        final double upperBound = range.getUpperBound();
        double n2 = 0.0;
        double n3 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            n2 = rectangle2D.getX();
            n3 = rectangle2D.getMaxX();
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            n2 = rectangle2D.getMaxY();
            n3 = rectangle2D.getY();
        }
        if (this.isInverted()) {
            return upperBound - (n - n2) / (n3 - n2) * (upperBound - lowerBound);
        }
        return lowerBound + (n - n2) / (n3 - n2) * (upperBound - lowerBound);
    }
    
    protected double calculateLowestVisibleTickValue() {
        final double size = this.getTickUnit().getSize();
        return Math.ceil(this.getRange().getLowerBound() / size) * size;
    }
    
    protected double calculateHighestVisibleTickValue() {
        final double size = this.getTickUnit().getSize();
        return Math.floor(this.getRange().getUpperBound() / size) * size;
    }
    
    protected int calculateVisibleTickCount() {
        final double size = this.getTickUnit().getSize();
        final Range range = this.getRange();
        return (int)(Math.floor(range.getUpperBound() / size) - Math.ceil(range.getLowerBound() / size) + 1.0);
    }
    
    public AxisState draw(final Graphics2D graphics2D, final double n, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge, final PlotRenderingInfo plotRenderingInfo) {
        if (!this.isVisible()) {
            final AxisState axisState = new AxisState(n);
            axisState.setTicks(this.refreshTicks(graphics2D, axisState, rectangle2D2, rectangleEdge));
            return axisState;
        }
        return this.drawLabel(this.getLabel(), graphics2D, rectangle2D, rectangle2D2, rectangleEdge, this.drawTickMarksAndLabels(graphics2D, n, rectangle2D, rectangle2D2, rectangleEdge));
    }
    
    public static TickUnitSource createStandardTickUnits() {
        final TickUnits tickUnits = new TickUnits();
        final DecimalFormat decimalFormat = new DecimalFormat("0.00000000");
        final DecimalFormat decimalFormat2 = new DecimalFormat("0.0000000");
        final DecimalFormat decimalFormat3 = new DecimalFormat("0.000000");
        final DecimalFormat decimalFormat4 = new DecimalFormat("0.00000");
        final DecimalFormat decimalFormat5 = new DecimalFormat("0.0000");
        final DecimalFormat decimalFormat6 = new DecimalFormat("0.000");
        final DecimalFormat decimalFormat7 = new DecimalFormat("0.00");
        final DecimalFormat decimalFormat8 = new DecimalFormat("0.0");
        final DecimalFormat decimalFormat9 = new DecimalFormat("#,##0");
        final DecimalFormat decimalFormat10 = new DecimalFormat("#,###,##0");
        final DecimalFormat decimalFormat11 = new DecimalFormat("#,###,###,##0");
        tickUnits.add(new NumberTickUnit(1.0E-7, decimalFormat2));
        tickUnits.add(new NumberTickUnit(1.0E-6, decimalFormat3));
        tickUnits.add(new NumberTickUnit(1.0E-5, decimalFormat4));
        tickUnits.add(new NumberTickUnit(1.0E-4, decimalFormat5));
        tickUnits.add(new NumberTickUnit(0.001, decimalFormat6));
        tickUnits.add(new NumberTickUnit(0.01, decimalFormat7));
        tickUnits.add(new NumberTickUnit(0.1, decimalFormat8));
        tickUnits.add(new NumberTickUnit(1.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(10.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(100.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(1000.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(10000.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(100000.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(1000000.0, decimalFormat10));
        tickUnits.add(new NumberTickUnit(1.0E7, decimalFormat10));
        tickUnits.add(new NumberTickUnit(1.0E8, decimalFormat10));
        tickUnits.add(new NumberTickUnit(1.0E9, decimalFormat11));
        tickUnits.add(new NumberTickUnit(1.0E10, decimalFormat11));
        tickUnits.add(new NumberTickUnit(1.0E11, decimalFormat11));
        tickUnits.add(new NumberTickUnit(2.5E-7, decimalFormat));
        tickUnits.add(new NumberTickUnit(2.5E-6, decimalFormat2));
        tickUnits.add(new NumberTickUnit(2.5E-5, decimalFormat3));
        tickUnits.add(new NumberTickUnit(2.5E-4, decimalFormat4));
        tickUnits.add(new NumberTickUnit(0.0025, decimalFormat5));
        tickUnits.add(new NumberTickUnit(0.025, decimalFormat6));
        tickUnits.add(new NumberTickUnit(0.25, decimalFormat7));
        tickUnits.add(new NumberTickUnit(2.5, decimalFormat8));
        tickUnits.add(new NumberTickUnit(25.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(250.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(2500.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(25000.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(250000.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(2500000.0, decimalFormat10));
        tickUnits.add(new NumberTickUnit(2.5E7, decimalFormat10));
        tickUnits.add(new NumberTickUnit(2.5E8, decimalFormat10));
        tickUnits.add(new NumberTickUnit(2.5E9, decimalFormat11));
        tickUnits.add(new NumberTickUnit(2.5E10, decimalFormat11));
        tickUnits.add(new NumberTickUnit(2.5E11, decimalFormat11));
        tickUnits.add(new NumberTickUnit(5.0E-7, decimalFormat2));
        tickUnits.add(new NumberTickUnit(5.0E-6, decimalFormat3));
        tickUnits.add(new NumberTickUnit(5.0E-5, decimalFormat4));
        tickUnits.add(new NumberTickUnit(5.0E-4, decimalFormat5));
        tickUnits.add(new NumberTickUnit(0.005, decimalFormat6));
        tickUnits.add(new NumberTickUnit(0.05, decimalFormat7));
        tickUnits.add(new NumberTickUnit(0.5, decimalFormat8));
        tickUnits.add(new NumberTickUnit(5.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(50.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(500.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(5000.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(50000.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(500000.0, decimalFormat9));
        tickUnits.add(new NumberTickUnit(5000000.0, decimalFormat10));
        tickUnits.add(new NumberTickUnit(5.0E7, decimalFormat10));
        tickUnits.add(new NumberTickUnit(5.0E8, decimalFormat10));
        tickUnits.add(new NumberTickUnit(5.0E9, decimalFormat11));
        tickUnits.add(new NumberTickUnit(5.0E10, decimalFormat11));
        tickUnits.add(new NumberTickUnit(5.0E11, decimalFormat11));
        return tickUnits;
    }
    
    public static TickUnitSource createIntegerTickUnits() {
        final TickUnits tickUnits = new TickUnits();
        final DecimalFormat decimalFormat = new DecimalFormat("0");
        final DecimalFormat decimalFormat2 = new DecimalFormat("#,##0");
        tickUnits.add(new NumberTickUnit(1.0, decimalFormat));
        tickUnits.add(new NumberTickUnit(2.0, decimalFormat));
        tickUnits.add(new NumberTickUnit(5.0, decimalFormat));
        tickUnits.add(new NumberTickUnit(10.0, decimalFormat));
        tickUnits.add(new NumberTickUnit(20.0, decimalFormat));
        tickUnits.add(new NumberTickUnit(50.0, decimalFormat));
        tickUnits.add(new NumberTickUnit(100.0, decimalFormat));
        tickUnits.add(new NumberTickUnit(200.0, decimalFormat));
        tickUnits.add(new NumberTickUnit(500.0, decimalFormat));
        tickUnits.add(new NumberTickUnit(1000.0, decimalFormat2));
        tickUnits.add(new NumberTickUnit(2000.0, decimalFormat2));
        tickUnits.add(new NumberTickUnit(5000.0, decimalFormat2));
        tickUnits.add(new NumberTickUnit(10000.0, decimalFormat2));
        tickUnits.add(new NumberTickUnit(20000.0, decimalFormat2));
        tickUnits.add(new NumberTickUnit(50000.0, decimalFormat2));
        tickUnits.add(new NumberTickUnit(100000.0, decimalFormat2));
        tickUnits.add(new NumberTickUnit(200000.0, decimalFormat2));
        tickUnits.add(new NumberTickUnit(500000.0, decimalFormat2));
        tickUnits.add(new NumberTickUnit(1000000.0, decimalFormat2));
        tickUnits.add(new NumberTickUnit(2000000.0, decimalFormat2));
        tickUnits.add(new NumberTickUnit(5000000.0, decimalFormat2));
        tickUnits.add(new NumberTickUnit(1.0E7, decimalFormat2));
        tickUnits.add(new NumberTickUnit(2.0E7, decimalFormat2));
        tickUnits.add(new NumberTickUnit(5.0E7, decimalFormat2));
        tickUnits.add(new NumberTickUnit(1.0E8, decimalFormat2));
        tickUnits.add(new NumberTickUnit(2.0E8, decimalFormat2));
        tickUnits.add(new NumberTickUnit(5.0E8, decimalFormat2));
        tickUnits.add(new NumberTickUnit(1.0E9, decimalFormat2));
        tickUnits.add(new NumberTickUnit(2.0E9, decimalFormat2));
        tickUnits.add(new NumberTickUnit(5.0E9, decimalFormat2));
        tickUnits.add(new NumberTickUnit(1.0E10, decimalFormat2));
        return tickUnits;
    }
    
    public static TickUnitSource createStandardTickUnits(final Locale locale) {
        final TickUnits tickUnits = new TickUnits();
        final NumberFormat numberInstance = NumberFormat.getNumberInstance(locale);
        tickUnits.add(new NumberTickUnit(1.0E-7, numberInstance));
        tickUnits.add(new NumberTickUnit(1.0E-6, numberInstance));
        tickUnits.add(new NumberTickUnit(1.0E-5, numberInstance));
        tickUnits.add(new NumberTickUnit(1.0E-4, numberInstance));
        tickUnits.add(new NumberTickUnit(0.001, numberInstance));
        tickUnits.add(new NumberTickUnit(0.01, numberInstance));
        tickUnits.add(new NumberTickUnit(0.1, numberInstance));
        tickUnits.add(new NumberTickUnit(1.0, numberInstance));
        tickUnits.add(new NumberTickUnit(10.0, numberInstance));
        tickUnits.add(new NumberTickUnit(100.0, numberInstance));
        tickUnits.add(new NumberTickUnit(1000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(10000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(100000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(1000000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(1.0E7, numberInstance));
        tickUnits.add(new NumberTickUnit(1.0E8, numberInstance));
        tickUnits.add(new NumberTickUnit(1.0E9, numberInstance));
        tickUnits.add(new NumberTickUnit(1.0E10, numberInstance));
        tickUnits.add(new NumberTickUnit(2.5E-7, numberInstance));
        tickUnits.add(new NumberTickUnit(2.5E-6, numberInstance));
        tickUnits.add(new NumberTickUnit(2.5E-5, numberInstance));
        tickUnits.add(new NumberTickUnit(2.5E-4, numberInstance));
        tickUnits.add(new NumberTickUnit(0.0025, numberInstance));
        tickUnits.add(new NumberTickUnit(0.025, numberInstance));
        tickUnits.add(new NumberTickUnit(0.25, numberInstance));
        tickUnits.add(new NumberTickUnit(2.5, numberInstance));
        tickUnits.add(new NumberTickUnit(25.0, numberInstance));
        tickUnits.add(new NumberTickUnit(250.0, numberInstance));
        tickUnits.add(new NumberTickUnit(2500.0, numberInstance));
        tickUnits.add(new NumberTickUnit(25000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(250000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(2500000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(2.5E7, numberInstance));
        tickUnits.add(new NumberTickUnit(2.5E8, numberInstance));
        tickUnits.add(new NumberTickUnit(2.5E9, numberInstance));
        tickUnits.add(new NumberTickUnit(2.5E10, numberInstance));
        tickUnits.add(new NumberTickUnit(5.0E-7, numberInstance));
        tickUnits.add(new NumberTickUnit(5.0E-6, numberInstance));
        tickUnits.add(new NumberTickUnit(5.0E-5, numberInstance));
        tickUnits.add(new NumberTickUnit(5.0E-4, numberInstance));
        tickUnits.add(new NumberTickUnit(0.005, numberInstance));
        tickUnits.add(new NumberTickUnit(0.05, numberInstance));
        tickUnits.add(new NumberTickUnit(0.5, numberInstance));
        tickUnits.add(new NumberTickUnit(5.0, numberInstance));
        tickUnits.add(new NumberTickUnit(50.0, numberInstance));
        tickUnits.add(new NumberTickUnit(500.0, numberInstance));
        tickUnits.add(new NumberTickUnit(5000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(50000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(500000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(5000000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(5.0E7, numberInstance));
        tickUnits.add(new NumberTickUnit(5.0E8, numberInstance));
        tickUnits.add(new NumberTickUnit(5.0E9, numberInstance));
        tickUnits.add(new NumberTickUnit(5.0E10, numberInstance));
        return tickUnits;
    }
    
    public static TickUnitSource createIntegerTickUnits(final Locale locale) {
        final TickUnits tickUnits = new TickUnits();
        final NumberFormat numberInstance = NumberFormat.getNumberInstance(locale);
        tickUnits.add(new NumberTickUnit(1.0, numberInstance));
        tickUnits.add(new NumberTickUnit(2.0, numberInstance));
        tickUnits.add(new NumberTickUnit(5.0, numberInstance));
        tickUnits.add(new NumberTickUnit(10.0, numberInstance));
        tickUnits.add(new NumberTickUnit(20.0, numberInstance));
        tickUnits.add(new NumberTickUnit(50.0, numberInstance));
        tickUnits.add(new NumberTickUnit(100.0, numberInstance));
        tickUnits.add(new NumberTickUnit(200.0, numberInstance));
        tickUnits.add(new NumberTickUnit(500.0, numberInstance));
        tickUnits.add(new NumberTickUnit(1000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(2000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(5000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(10000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(20000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(50000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(100000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(200000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(500000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(1000000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(2000000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(5000000.0, numberInstance));
        tickUnits.add(new NumberTickUnit(1.0E7, numberInstance));
        tickUnits.add(new NumberTickUnit(2.0E7, numberInstance));
        tickUnits.add(new NumberTickUnit(5.0E7, numberInstance));
        tickUnits.add(new NumberTickUnit(1.0E8, numberInstance));
        tickUnits.add(new NumberTickUnit(2.0E8, numberInstance));
        tickUnits.add(new NumberTickUnit(5.0E8, numberInstance));
        tickUnits.add(new NumberTickUnit(1.0E9, numberInstance));
        tickUnits.add(new NumberTickUnit(2.0E9, numberInstance));
        tickUnits.add(new NumberTickUnit(5.0E9, numberInstance));
        tickUnits.add(new NumberTickUnit(1.0E10, numberInstance));
        return tickUnits;
    }
    
    protected double estimateMaximumTickLabelHeight(final Graphics2D graphics2D) {
        final RectangleInsets tickLabelInsets = this.getTickLabelInsets();
        return tickLabelInsets.getTop() + tickLabelInsets.getBottom() + this.getTickLabelFont().getLineMetrics("123", graphics2D.getFontRenderContext()).getHeight();
    }
    
    protected double estimateMaximumTickLabelWidth(final Graphics2D graphics2D, final TickUnit tickUnit) {
        final RectangleInsets tickLabelInsets = this.getTickLabelInsets();
        final double n = tickLabelInsets.getLeft() + tickLabelInsets.getRight();
        double n2;
        if (this.isVerticalTickLabels()) {
            n2 = n + this.getTickLabelFont().getLineMetrics("0", graphics2D.getFontRenderContext()).getHeight();
        }
        else {
            final FontMetrics fontMetrics = graphics2D.getFontMetrics(this.getTickLabelFont());
            final Range range = this.getRange();
            final double lowerBound = range.getLowerBound();
            final double upperBound = range.getUpperBound();
            final NumberFormat numberFormatOverride = this.getNumberFormatOverride();
            String s;
            String s2;
            if (numberFormatOverride != null) {
                s = numberFormatOverride.format(lowerBound);
                s2 = numberFormatOverride.format(upperBound);
            }
            else {
                s = tickUnit.valueToString(lowerBound);
                s2 = tickUnit.valueToString(upperBound);
            }
            n2 = n + Math.max(fontMetrics.stringWidth(s), (double)fontMetrics.stringWidth(s2));
        }
        return n2;
    }
    
    protected void selectAutoTickUnit(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            this.selectHorizontalAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            this.selectVerticalAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
        }
    }
    
    protected void selectHorizontalAutoTickUnit(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final double estimateMaximumTickLabelWidth = this.estimateMaximumTickLabelWidth(graphics2D, this.getTickUnit());
        final TickUnitSource standardTickUnits = this.getStandardTickUnits();
        final TickUnit ceilingTickUnit = standardTickUnits.getCeilingTickUnit(this.getTickUnit());
        NumberTickUnit numberTickUnit = (NumberTickUnit)standardTickUnits.getCeilingTickUnit(estimateMaximumTickLabelWidth / this.lengthToJava2D(ceilingTickUnit.getSize(), rectangle2D, rectangleEdge) * ceilingTickUnit.getSize());
        if (this.estimateMaximumTickLabelWidth(graphics2D, numberTickUnit) > this.lengthToJava2D(numberTickUnit.getSize(), rectangle2D, rectangleEdge)) {
            numberTickUnit = (NumberTickUnit)standardTickUnits.getLargerTickUnit(numberTickUnit);
        }
        this.setTickUnit(numberTickUnit, false, false);
    }
    
    protected void selectVerticalAutoTickUnit(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final double estimateMaximumTickLabelHeight = this.estimateMaximumTickLabelHeight(graphics2D);
        final TickUnitSource standardTickUnits = this.getStandardTickUnits();
        final TickUnit ceilingTickUnit = standardTickUnits.getCeilingTickUnit(this.getTickUnit());
        NumberTickUnit numberTickUnit = (NumberTickUnit)standardTickUnits.getCeilingTickUnit(estimateMaximumTickLabelHeight / this.lengthToJava2D(ceilingTickUnit.getSize(), rectangle2D, rectangleEdge) * ceilingTickUnit.getSize());
        if (this.estimateMaximumTickLabelHeight(graphics2D) > this.lengthToJava2D(numberTickUnit.getSize(), rectangle2D, rectangleEdge)) {
            numberTickUnit = (NumberTickUnit)standardTickUnits.getLargerTickUnit(numberTickUnit);
        }
        this.setTickUnit(numberTickUnit, false, false);
    }
    
    public List refreshTicks(final Graphics2D graphics2D, final AxisState axisState, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        List list = new ArrayList();
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            list = this.refreshTicksHorizontal(graphics2D, rectangle2D, rectangleEdge);
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            list = this.refreshTicksVertical(graphics2D, rectangle2D, rectangleEdge);
        }
        return list;
    }
    
    protected List refreshTicksHorizontal(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final ArrayList<NumberTick> list = new ArrayList<NumberTick>();
        graphics2D.setFont(this.getTickLabelFont());
        if (this.isAutoTickUnitSelection()) {
            this.selectAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
        }
        final double size = this.getTickUnit().getSize();
        final int calculateVisibleTickCount = this.calculateVisibleTickCount();
        final double calculateLowestVisibleTickValue = this.calculateLowestVisibleTickValue();
        if (calculateVisibleTickCount <= 500) {
            for (int i = 0; i < calculateVisibleTickCount; ++i) {
                final double n = calculateLowestVisibleTickValue + i * size;
                final NumberFormat numberFormatOverride = this.getNumberFormatOverride();
                String s;
                if (numberFormatOverride != null) {
                    s = numberFormatOverride.format(n);
                }
                else {
                    s = this.getTickUnit().valueToString(n);
                }
                double n2 = 0.0;
                TextAnchor textAnchor;
                TextAnchor textAnchor2;
                if (this.isVerticalTickLabels()) {
                    textAnchor = TextAnchor.CENTER_RIGHT;
                    textAnchor2 = TextAnchor.CENTER_RIGHT;
                    if (rectangleEdge == RectangleEdge.TOP) {
                        n2 = 1.5707963267948966;
                    }
                    else {
                        n2 = -1.5707963267948966;
                    }
                }
                else if (rectangleEdge == RectangleEdge.TOP) {
                    textAnchor = TextAnchor.BOTTOM_CENTER;
                    textAnchor2 = TextAnchor.BOTTOM_CENTER;
                }
                else {
                    textAnchor = TextAnchor.TOP_CENTER;
                    textAnchor2 = TextAnchor.TOP_CENTER;
                }
                list.add(new NumberTick(new Double(n), s, textAnchor, textAnchor2, n2));
            }
        }
        return list;
    }
    
    protected List refreshTicksVertical(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final ArrayList<NumberTick> list = new ArrayList<NumberTick>();
        list.clear();
        graphics2D.setFont(this.getTickLabelFont());
        if (this.isAutoTickUnitSelection()) {
            this.selectAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
        }
        final double size = this.getTickUnit().getSize();
        final int calculateVisibleTickCount = this.calculateVisibleTickCount();
        final double calculateLowestVisibleTickValue = this.calculateLowestVisibleTickValue();
        if (calculateVisibleTickCount <= 500) {
            for (int i = 0; i < calculateVisibleTickCount; ++i) {
                final double n = calculateLowestVisibleTickValue + i * size;
                final NumberFormat numberFormatOverride = this.getNumberFormatOverride();
                String s;
                if (numberFormatOverride != null) {
                    s = numberFormatOverride.format(n);
                }
                else {
                    s = this.getTickUnit().valueToString(n);
                }
                double n2 = 0.0;
                TextAnchor textAnchor;
                TextAnchor textAnchor2;
                if (this.isVerticalTickLabels()) {
                    if (rectangleEdge == RectangleEdge.LEFT) {
                        textAnchor = TextAnchor.BOTTOM_CENTER;
                        textAnchor2 = TextAnchor.BOTTOM_CENTER;
                        n2 = -1.5707963267948966;
                    }
                    else {
                        textAnchor = TextAnchor.BOTTOM_CENTER;
                        textAnchor2 = TextAnchor.BOTTOM_CENTER;
                        n2 = 1.5707963267948966;
                    }
                }
                else if (rectangleEdge == RectangleEdge.LEFT) {
                    textAnchor = TextAnchor.CENTER_RIGHT;
                    textAnchor2 = TextAnchor.CENTER_RIGHT;
                }
                else {
                    textAnchor = TextAnchor.CENTER_LEFT;
                    textAnchor2 = TextAnchor.CENTER_LEFT;
                }
                list.add(new NumberTick(new Double(n), s, textAnchor, textAnchor2, n2));
            }
        }
        return list;
    }
    
    public Object clone() {
        final NumberAxis numberAxis = (NumberAxis)super.clone();
        if (this.numberFormatOverride != null) {
            numberAxis.numberFormatOverride = (NumberFormat)this.numberFormatOverride.clone();
        }
        return numberAxis;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof NumberAxis)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final NumberAxis numberAxis = (NumberAxis)o;
        return this.autoRangeIncludesZero == numberAxis.autoRangeIncludesZero && this.autoRangeStickyZero == numberAxis.autoRangeStickyZero && ObjectUtilities.equal(this.tickUnit, numberAxis.tickUnit) && ObjectUtilities.equal(this.numberFormatOverride, numberAxis.numberFormatOverride) && this.rangeType.equals(numberAxis.rangeType);
    }
    
    public int hashCode() {
        if (this.getLabel() != null) {
            return this.getLabel().hashCode();
        }
        return 0;
    }
    
    static {
        DEFAULT_TICK_UNIT = new NumberTickUnit(1.0, new DecimalFormat("0"));
    }
}
