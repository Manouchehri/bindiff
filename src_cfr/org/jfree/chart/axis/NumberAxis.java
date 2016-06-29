/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.MarkerAxisBand;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.data.Range;
import org.jfree.data.RangeType;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;

public class NumberAxis
extends ValueAxis
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 2805933088476185789L;
    public static final boolean DEFAULT_AUTO_RANGE_INCLUDES_ZERO = true;
    public static final boolean DEFAULT_AUTO_RANGE_STICKY_ZERO = true;
    public static final NumberTickUnit DEFAULT_TICK_UNIT = new NumberTickUnit(1.0, new DecimalFormat("0"));
    public static final boolean DEFAULT_VERTICAL_TICK_LABELS = false;
    private RangeType rangeType = RangeType.FULL;
    private boolean autoRangeIncludesZero = true;
    private boolean autoRangeStickyZero = true;
    private NumberTickUnit tickUnit = DEFAULT_TICK_UNIT;
    private NumberFormat numberFormatOverride = null;
    private MarkerAxisBand markerBand = null;

    public NumberAxis() {
        this(null);
    }

    public NumberAxis(String string) {
        super(string, NumberAxis.createStandardTickUnits());
    }

    public RangeType getRangeType() {
        return this.rangeType;
    }

    public void setRangeType(RangeType rangeType) {
        if (rangeType == null) {
            throw new IllegalArgumentException("Null 'rangeType' argument.");
        }
        this.rangeType = rangeType;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public boolean getAutoRangeIncludesZero() {
        return this.autoRangeIncludesZero;
    }

    public void setAutoRangeIncludesZero(boolean bl2) {
        if (this.autoRangeIncludesZero == bl2) return;
        this.autoRangeIncludesZero = bl2;
        if (this.isAutoRange()) {
            this.autoAdjustRange();
        }
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public boolean getAutoRangeStickyZero() {
        return this.autoRangeStickyZero;
    }

    public void setAutoRangeStickyZero(boolean bl2) {
        if (this.autoRangeStickyZero == bl2) return;
        this.autoRangeStickyZero = bl2;
        if (this.isAutoRange()) {
            this.autoAdjustRange();
        }
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public NumberTickUnit getTickUnit() {
        return this.tickUnit;
    }

    public void setTickUnit(NumberTickUnit numberTickUnit) {
        this.setTickUnit(numberTickUnit, true, true);
    }

    public void setTickUnit(NumberTickUnit numberTickUnit, boolean bl2, boolean bl3) {
        if (numberTickUnit == null) {
            throw new IllegalArgumentException("Null 'unit' argument.");
        }
        this.tickUnit = numberTickUnit;
        if (bl3) {
            this.setAutoTickUnitSelection(false, false);
        }
        if (!bl2) return;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public NumberFormat getNumberFormatOverride() {
        return this.numberFormatOverride;
    }

    public void setNumberFormatOverride(NumberFormat numberFormat) {
        this.numberFormatOverride = numberFormat;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public MarkerAxisBand getMarkerBand() {
        return this.markerBand;
    }

    public void setMarkerBand(MarkerAxisBand markerAxisBand) {
        this.markerBand = markerAxisBand;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    @Override
    public void configure() {
        if (!this.isAutoRange()) return;
        this.autoAdjustRange();
    }

    @Override
    protected void autoAdjustRange() {
        Plot plot = this.getPlot();
        if (plot == null) {
            return;
        }
        if (!(plot instanceof ValueAxisPlot)) return;
        ValueAxisPlot valueAxisPlot = (ValueAxisPlot)((Object)plot);
        Range range = valueAxisPlot.getDataRange(this);
        if (range == null) {
            range = this.getDefaultAutoRange();
        }
        double d2 = range.getUpperBound();
        double d3 = range.getLowerBound();
        if (this.rangeType == RangeType.POSITIVE) {
            d3 = Math.max(0.0, d3);
            d2 = Math.max(0.0, d2);
        } else if (this.rangeType == RangeType.NEGATIVE) {
            d3 = Math.min(0.0, d3);
            d2 = Math.min(0.0, d2);
        }
        if (this.getAutoRangeIncludesZero()) {
            d3 = Math.min(d3, 0.0);
            d2 = Math.max(d2, 0.0);
        }
        double d4 = d2 - d3;
        double d5 = this.getFixedAutoRange();
        if (d5 > 0.0) {
            d3 = d2 - d5;
        } else {
            double d6 = this.getAutoRangeMinimumSize();
            if (d4 < d6) {
                double d7 = (d6 - d4) / 2.0;
                if ((d3 -= d7) == (d2 += d7)) {
                    double d8 = Math.abs(d3) / 10.0;
                    d3 -= d8;
                    d2 += d8;
                }
                if (this.rangeType == RangeType.POSITIVE) {
                    if (d3 < 0.0) {
                        d2 -= d3;
                        d3 = 0.0;
                    }
                } else if (this.rangeType == RangeType.NEGATIVE && d2 > 0.0) {
                    d3 -= d2;
                    d2 = 0.0;
                }
            }
            if (this.getAutoRangeStickyZero()) {
                d2 = d2 <= 0.0 ? Math.min(0.0, d2 + this.getUpperMargin() * d4) : (d2 += this.getUpperMargin() * d4);
                d3 = d3 >= 0.0 ? Math.max(0.0, d3 - this.getLowerMargin() * d4) : (d3 -= this.getLowerMargin() * d4);
            } else {
                d2 += this.getUpperMargin() * d4;
                d3 -= this.getLowerMargin() * d4;
            }
        }
        this.setRange(new Range(d3, d2), false, false);
    }

    @Override
    public double valueToJava2D(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        Range range = this.getRange();
        double d3 = range.getLowerBound();
        double d4 = range.getUpperBound();
        double d5 = 0.0;
        double d6 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            d5 = rectangle2D.getX();
            d6 = rectangle2D.getMaxX();
        } else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            d6 = rectangle2D.getMinY();
            d5 = rectangle2D.getMaxY();
        }
        if (!this.isInverted()) return d5 + (d2 - d3) / (d4 - d3) * (d6 - d5);
        return d6 - (d2 - d3) / (d4 - d3) * (d6 - d5);
    }

    @Override
    public double java2DToValue(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        Range range = this.getRange();
        double d3 = range.getLowerBound();
        double d4 = range.getUpperBound();
        double d5 = 0.0;
        double d6 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            d5 = rectangle2D.getX();
            d6 = rectangle2D.getMaxX();
        } else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            d5 = rectangle2D.getMaxY();
            d6 = rectangle2D.getY();
        }
        if (!this.isInverted()) return d3 + (d2 - d5) / (d6 - d5) * (d4 - d3);
        return d4 - (d2 - d5) / (d6 - d5) * (d4 - d3);
    }

    protected double calculateLowestVisibleTickValue() {
        double d2 = this.getTickUnit().getSize();
        double d3 = Math.ceil(this.getRange().getLowerBound() / d2);
        return d3 * d2;
    }

    protected double calculateHighestVisibleTickValue() {
        double d2 = this.getTickUnit().getSize();
        double d3 = Math.floor(this.getRange().getUpperBound() / d2);
        return d3 * d2;
    }

    protected int calculateVisibleTickCount() {
        double d2 = this.getTickUnit().getSize();
        Range range = this.getRange();
        return (int)(Math.floor(range.getUpperBound() / d2) - Math.ceil(range.getLowerBound() / d2) + 1.0);
    }

    @Override
    public AxisState draw(Graphics2D graphics2D, double d2, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge, PlotRenderingInfo plotRenderingInfo) {
        AxisState axisState = null;
        if (!this.isVisible()) {
            axisState = new AxisState(d2);
            List list = this.refreshTicks(graphics2D, axisState, rectangle2D2, rectangleEdge);
            axisState.setTicks(list);
            return axisState;
        }
        axisState = this.drawTickMarksAndLabels(graphics2D, d2, rectangle2D, rectangle2D2, rectangleEdge);
        return this.drawLabel(this.getLabel(), graphics2D, rectangle2D, rectangle2D2, rectangleEdge, axisState);
    }

    public static TickUnitSource createStandardTickUnits() {
        TickUnits tickUnits = new TickUnits();
        DecimalFormat decimalFormat = new DecimalFormat("0.00000000");
        DecimalFormat decimalFormat2 = new DecimalFormat("0.0000000");
        DecimalFormat decimalFormat3 = new DecimalFormat("0.000000");
        DecimalFormat decimalFormat4 = new DecimalFormat("0.00000");
        DecimalFormat decimalFormat5 = new DecimalFormat("0.0000");
        DecimalFormat decimalFormat6 = new DecimalFormat("0.000");
        DecimalFormat decimalFormat7 = new DecimalFormat("0.00");
        DecimalFormat decimalFormat8 = new DecimalFormat("0.0");
        DecimalFormat decimalFormat9 = new DecimalFormat("#,##0");
        DecimalFormat decimalFormat10 = new DecimalFormat("#,###,##0");
        DecimalFormat decimalFormat11 = new DecimalFormat("#,###,###,##0");
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
        TickUnits tickUnits = new TickUnits();
        DecimalFormat decimalFormat = new DecimalFormat("0");
        DecimalFormat decimalFormat2 = new DecimalFormat("#,##0");
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

    public static TickUnitSource createStandardTickUnits(Locale locale) {
        TickUnits tickUnits = new TickUnits();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        tickUnits.add(new NumberTickUnit(1.0E-7, numberFormat));
        tickUnits.add(new NumberTickUnit(1.0E-6, numberFormat));
        tickUnits.add(new NumberTickUnit(1.0E-5, numberFormat));
        tickUnits.add(new NumberTickUnit(1.0E-4, numberFormat));
        tickUnits.add(new NumberTickUnit(0.001, numberFormat));
        tickUnits.add(new NumberTickUnit(0.01, numberFormat));
        tickUnits.add(new NumberTickUnit(0.1, numberFormat));
        tickUnits.add(new NumberTickUnit(1.0, numberFormat));
        tickUnits.add(new NumberTickUnit(10.0, numberFormat));
        tickUnits.add(new NumberTickUnit(100.0, numberFormat));
        tickUnits.add(new NumberTickUnit(1000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(10000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(100000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(1000000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(1.0E7, numberFormat));
        tickUnits.add(new NumberTickUnit(1.0E8, numberFormat));
        tickUnits.add(new NumberTickUnit(1.0E9, numberFormat));
        tickUnits.add(new NumberTickUnit(1.0E10, numberFormat));
        tickUnits.add(new NumberTickUnit(2.5E-7, numberFormat));
        tickUnits.add(new NumberTickUnit(2.5E-6, numberFormat));
        tickUnits.add(new NumberTickUnit(2.5E-5, numberFormat));
        tickUnits.add(new NumberTickUnit(2.5E-4, numberFormat));
        tickUnits.add(new NumberTickUnit(0.0025, numberFormat));
        tickUnits.add(new NumberTickUnit(0.025, numberFormat));
        tickUnits.add(new NumberTickUnit(0.25, numberFormat));
        tickUnits.add(new NumberTickUnit(2.5, numberFormat));
        tickUnits.add(new NumberTickUnit(25.0, numberFormat));
        tickUnits.add(new NumberTickUnit(250.0, numberFormat));
        tickUnits.add(new NumberTickUnit(2500.0, numberFormat));
        tickUnits.add(new NumberTickUnit(25000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(250000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(2500000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(2.5E7, numberFormat));
        tickUnits.add(new NumberTickUnit(2.5E8, numberFormat));
        tickUnits.add(new NumberTickUnit(2.5E9, numberFormat));
        tickUnits.add(new NumberTickUnit(2.5E10, numberFormat));
        tickUnits.add(new NumberTickUnit(5.0E-7, numberFormat));
        tickUnits.add(new NumberTickUnit(5.0E-6, numberFormat));
        tickUnits.add(new NumberTickUnit(5.0E-5, numberFormat));
        tickUnits.add(new NumberTickUnit(5.0E-4, numberFormat));
        tickUnits.add(new NumberTickUnit(0.005, numberFormat));
        tickUnits.add(new NumberTickUnit(0.05, numberFormat));
        tickUnits.add(new NumberTickUnit(0.5, numberFormat));
        tickUnits.add(new NumberTickUnit(5.0, numberFormat));
        tickUnits.add(new NumberTickUnit(50.0, numberFormat));
        tickUnits.add(new NumberTickUnit(500.0, numberFormat));
        tickUnits.add(new NumberTickUnit(5000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(50000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(500000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(5000000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(5.0E7, numberFormat));
        tickUnits.add(new NumberTickUnit(5.0E8, numberFormat));
        tickUnits.add(new NumberTickUnit(5.0E9, numberFormat));
        tickUnits.add(new NumberTickUnit(5.0E10, numberFormat));
        return tickUnits;
    }

    public static TickUnitSource createIntegerTickUnits(Locale locale) {
        TickUnits tickUnits = new TickUnits();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        tickUnits.add(new NumberTickUnit(1.0, numberFormat));
        tickUnits.add(new NumberTickUnit(2.0, numberFormat));
        tickUnits.add(new NumberTickUnit(5.0, numberFormat));
        tickUnits.add(new NumberTickUnit(10.0, numberFormat));
        tickUnits.add(new NumberTickUnit(20.0, numberFormat));
        tickUnits.add(new NumberTickUnit(50.0, numberFormat));
        tickUnits.add(new NumberTickUnit(100.0, numberFormat));
        tickUnits.add(new NumberTickUnit(200.0, numberFormat));
        tickUnits.add(new NumberTickUnit(500.0, numberFormat));
        tickUnits.add(new NumberTickUnit(1000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(2000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(5000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(10000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(20000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(50000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(100000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(200000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(500000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(1000000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(2000000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(5000000.0, numberFormat));
        tickUnits.add(new NumberTickUnit(1.0E7, numberFormat));
        tickUnits.add(new NumberTickUnit(2.0E7, numberFormat));
        tickUnits.add(new NumberTickUnit(5.0E7, numberFormat));
        tickUnits.add(new NumberTickUnit(1.0E8, numberFormat));
        tickUnits.add(new NumberTickUnit(2.0E8, numberFormat));
        tickUnits.add(new NumberTickUnit(5.0E8, numberFormat));
        tickUnits.add(new NumberTickUnit(1.0E9, numberFormat));
        tickUnits.add(new NumberTickUnit(2.0E9, numberFormat));
        tickUnits.add(new NumberTickUnit(5.0E9, numberFormat));
        tickUnits.add(new NumberTickUnit(1.0E10, numberFormat));
        return tickUnits;
    }

    protected double estimateMaximumTickLabelHeight(Graphics2D graphics2D) {
        RectangleInsets rectangleInsets = this.getTickLabelInsets();
        double d2 = rectangleInsets.getTop() + rectangleInsets.getBottom();
        Font font = this.getTickLabelFont();
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        return d2 += (double)font.getLineMetrics("123", fontRenderContext).getHeight();
    }

    protected double estimateMaximumTickLabelWidth(Graphics2D graphics2D, TickUnit tickUnit) {
        RectangleInsets rectangleInsets = this.getTickLabelInsets();
        double d2 = rectangleInsets.getLeft() + rectangleInsets.getRight();
        if (this.isVerticalTickLabels()) {
            FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
            LineMetrics lineMetrics = this.getTickLabelFont().getLineMetrics("0", fontRenderContext);
            return d2 += (double)lineMetrics.getHeight();
        }
        FontMetrics fontMetrics = graphics2D.getFontMetrics(this.getTickLabelFont());
        Range range = this.getRange();
        double d3 = range.getLowerBound();
        double d4 = range.getUpperBound();
        String string = "";
        String string2 = "";
        NumberFormat numberFormat = this.getNumberFormatOverride();
        if (numberFormat != null) {
            string = numberFormat.format(d3);
            string2 = numberFormat.format(d4);
        } else {
            string = tickUnit.valueToString(d3);
            string2 = tickUnit.valueToString(d4);
        }
        double d5 = fontMetrics.stringWidth(string);
        double d6 = fontMetrics.stringWidth(string2);
        d2 += Math.max(d5, d6);
        return d2;
    }

    protected void selectAutoTickUnit(Graphics2D graphics2D, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            this.selectHorizontalAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
            return;
        }
        if (!RectangleEdge.isLeftOrRight(rectangleEdge)) return;
        this.selectVerticalAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
    }

    protected void selectHorizontalAutoTickUnit(Graphics2D graphics2D, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d2 = this.estimateMaximumTickLabelWidth(graphics2D, this.getTickUnit());
        TickUnitSource tickUnitSource = this.getStandardTickUnits();
        TickUnit tickUnit = tickUnitSource.getCeilingTickUnit(this.getTickUnit());
        double d3 = this.lengthToJava2D(tickUnit.getSize(), rectangle2D, rectangleEdge);
        double d4 = d2 / d3 * tickUnit.getSize();
        NumberTickUnit numberTickUnit = (NumberTickUnit)tickUnitSource.getCeilingTickUnit(d4);
        double d5 = this.lengthToJava2D(numberTickUnit.getSize(), rectangle2D, rectangleEdge);
        d2 = this.estimateMaximumTickLabelWidth(graphics2D, numberTickUnit);
        if (d2 > d5) {
            numberTickUnit = (NumberTickUnit)tickUnitSource.getLargerTickUnit(numberTickUnit);
        }
        this.setTickUnit(numberTickUnit, false, false);
    }

    protected void selectVerticalAutoTickUnit(Graphics2D graphics2D, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d2 = this.estimateMaximumTickLabelHeight(graphics2D);
        TickUnitSource tickUnitSource = this.getStandardTickUnits();
        TickUnit tickUnit = tickUnitSource.getCeilingTickUnit(this.getTickUnit());
        double d3 = this.lengthToJava2D(tickUnit.getSize(), rectangle2D, rectangleEdge);
        double d4 = d2 / d3 * tickUnit.getSize();
        NumberTickUnit numberTickUnit = (NumberTickUnit)tickUnitSource.getCeilingTickUnit(d4);
        double d5 = this.lengthToJava2D(numberTickUnit.getSize(), rectangle2D, rectangleEdge);
        d2 = this.estimateMaximumTickLabelHeight(graphics2D);
        if (d2 > d5) {
            numberTickUnit = (NumberTickUnit)tickUnitSource.getLargerTickUnit(numberTickUnit);
        }
        this.setTickUnit(numberTickUnit, false, false);
    }

    @Override
    public List refreshTicks(Graphics2D graphics2D, AxisState axisState, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        List list = new ArrayList();
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            return this.refreshTicksHorizontal(graphics2D, rectangle2D, rectangleEdge);
        }
        if (!RectangleEdge.isLeftOrRight(rectangleEdge)) return list;
        return this.refreshTicksVertical(graphics2D, rectangle2D, rectangleEdge);
    }

    protected List refreshTicksHorizontal(Graphics2D graphics2D, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        ArrayList<NumberTick> arrayList = new ArrayList<NumberTick>();
        Font font = this.getTickLabelFont();
        graphics2D.setFont(font);
        if (this.isAutoTickUnitSelection()) {
            this.selectAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
        }
        double d2 = this.getTickUnit().getSize();
        int n2 = this.calculateVisibleTickCount();
        double d3 = this.calculateLowestVisibleTickValue();
        if (n2 > 500) return arrayList;
        int n3 = 0;
        while (n3 < n2) {
            double d4 = d3 + (double)n3 * d2;
            NumberFormat numberFormat = this.getNumberFormatOverride();
            String string = numberFormat != null ? numberFormat.format(d4) : this.getTickUnit().valueToString(d4);
            TextAnchor textAnchor = null;
            TextAnchor textAnchor2 = null;
            double d5 = 0.0;
            if (this.isVerticalTickLabels()) {
                textAnchor = TextAnchor.CENTER_RIGHT;
                textAnchor2 = TextAnchor.CENTER_RIGHT;
                d5 = rectangleEdge == RectangleEdge.TOP ? 1.5707963267948966 : -1.5707963267948966;
            } else if (rectangleEdge == RectangleEdge.TOP) {
                textAnchor = TextAnchor.BOTTOM_CENTER;
                textAnchor2 = TextAnchor.BOTTOM_CENTER;
            } else {
                textAnchor = TextAnchor.TOP_CENTER;
                textAnchor2 = TextAnchor.TOP_CENTER;
            }
            NumberTick numberTick = new NumberTick(new Double(d4), string, textAnchor, textAnchor2, d5);
            arrayList.add(numberTick);
            ++n3;
        }
        return arrayList;
    }

    protected List refreshTicksVertical(Graphics2D graphics2D, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        ArrayList<NumberTick> arrayList = new ArrayList<NumberTick>();
        arrayList.clear();
        Font font = this.getTickLabelFont();
        graphics2D.setFont(font);
        if (this.isAutoTickUnitSelection()) {
            this.selectAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
        }
        double d2 = this.getTickUnit().getSize();
        int n2 = this.calculateVisibleTickCount();
        double d3 = this.calculateLowestVisibleTickValue();
        if (n2 > 500) return arrayList;
        int n3 = 0;
        while (n3 < n2) {
            double d4 = d3 + (double)n3 * d2;
            NumberFormat numberFormat = this.getNumberFormatOverride();
            String string = numberFormat != null ? numberFormat.format(d4) : this.getTickUnit().valueToString(d4);
            TextAnchor textAnchor = null;
            TextAnchor textAnchor2 = null;
            double d5 = 0.0;
            if (this.isVerticalTickLabels()) {
                if (rectangleEdge == RectangleEdge.LEFT) {
                    textAnchor = TextAnchor.BOTTOM_CENTER;
                    textAnchor2 = TextAnchor.BOTTOM_CENTER;
                    d5 = -1.5707963267948966;
                } else {
                    textAnchor = TextAnchor.BOTTOM_CENTER;
                    textAnchor2 = TextAnchor.BOTTOM_CENTER;
                    d5 = 1.5707963267948966;
                }
            } else if (rectangleEdge == RectangleEdge.LEFT) {
                textAnchor = TextAnchor.CENTER_RIGHT;
                textAnchor2 = TextAnchor.CENTER_RIGHT;
            } else {
                textAnchor = TextAnchor.CENTER_LEFT;
                textAnchor2 = TextAnchor.CENTER_LEFT;
            }
            NumberTick numberTick = new NumberTick(new Double(d4), string, textAnchor, textAnchor2, d5);
            arrayList.add(numberTick);
            ++n3;
        }
        return arrayList;
    }

    @Override
    public Object clone() {
        NumberAxis numberAxis = (NumberAxis)super.clone();
        if (this.numberFormatOverride == null) return numberAxis;
        numberAxis.numberFormatOverride = (NumberFormat)this.numberFormatOverride.clone();
        return numberAxis;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof NumberAxis)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        NumberAxis numberAxis = (NumberAxis)object;
        if (this.autoRangeIncludesZero != numberAxis.autoRangeIncludesZero) {
            return false;
        }
        if (this.autoRangeStickyZero != numberAxis.autoRangeStickyZero) {
            return false;
        }
        if (!ObjectUtilities.equal(this.tickUnit, numberAxis.tickUnit)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.numberFormatOverride, numberAxis.numberFormatOverride)) {
            return false;
        }
        if (this.rangeType.equals(numberAxis.rangeType)) return true;
        return false;
    }

    public int hashCode() {
        if (this.getLabel() == null) return 0;
        return this.getLabel().hashCode();
    }
}

