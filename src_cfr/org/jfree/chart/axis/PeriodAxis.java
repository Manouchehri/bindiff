/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.data.Range;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.PublicCloneable;

public class PeriodAxis
extends ValueAxis
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = 8353295532075872069L;
    private RegularTimePeriod first;
    private RegularTimePeriod last;
    private TimeZone timeZone;
    private Calendar calendar;
    private Class autoRangeTimePeriodClass;
    private Class majorTickTimePeriodClass;
    private boolean minorTickMarksVisible;
    private Class minorTickTimePeriodClass;
    private float minorTickMarkInsideLength = 0.0f;
    private float minorTickMarkOutsideLength = 2.0f;
    private transient Stroke minorTickMarkStroke = new BasicStroke(0.5f);
    private transient Paint minorTickMarkPaint = Color.black;
    private PeriodAxisLabelInfo[] labelInfo;
    static Class class$org$jfree$data$time$Month;
    static Class class$org$jfree$data$time$Year;
    static Class class$java$util$Date;
    static Class class$java$util$TimeZone;

    public PeriodAxis(String string) {
        this(string, new Day(), new Day());
    }

    public PeriodAxis(String string, RegularTimePeriod regularTimePeriod, RegularTimePeriod regularTimePeriod2) {
        this(string, regularTimePeriod, regularTimePeriod2, TimeZone.getDefault());
    }

    public PeriodAxis(String string, RegularTimePeriod regularTimePeriod, RegularTimePeriod regularTimePeriod2, TimeZone timeZone) {
        super(string, null);
        this.first = regularTimePeriod;
        this.last = regularTimePeriod2;
        this.timeZone = timeZone;
        this.calendar = Calendar.getInstance(timeZone);
        this.autoRangeTimePeriodClass = regularTimePeriod.getClass();
        this.majorTickTimePeriodClass = regularTimePeriod.getClass();
        this.minorTickMarksVisible = false;
        this.minorTickTimePeriodClass = RegularTimePeriod.downsize(this.majorTickTimePeriodClass);
        this.setAutoRange(true);
        this.labelInfo = new PeriodAxisLabelInfo[2];
        Class class_ = class$org$jfree$data$time$Month == null ? (PeriodAxis.class$org$jfree$data$time$Month = PeriodAxis.class$("org.jfree.data.time.Month")) : class$org$jfree$data$time$Month;
        this.labelInfo[0] = new PeriodAxisLabelInfo(class_, new SimpleDateFormat("MMM"));
        Class class_2 = class$org$jfree$data$time$Year == null ? (PeriodAxis.class$org$jfree$data$time$Year = PeriodAxis.class$("org.jfree.data.time.Year")) : class$org$jfree$data$time$Year;
        this.labelInfo[1] = new PeriodAxisLabelInfo(class_2, new SimpleDateFormat("yyyy"));
    }

    public RegularTimePeriod getFirst() {
        return this.first;
    }

    public void setFirst(RegularTimePeriod regularTimePeriod) {
        if (regularTimePeriod == null) {
            throw new IllegalArgumentException("Null 'first' argument.");
        }
        this.first = regularTimePeriod;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public RegularTimePeriod getLast() {
        return this.last;
    }

    public void setLast(RegularTimePeriod regularTimePeriod) {
        if (regularTimePeriod == null) {
            throw new IllegalArgumentException("Null 'last' argument.");
        }
        this.last = regularTimePeriod;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        if (timeZone == null) {
            throw new IllegalArgumentException("Null 'zone' argument.");
        }
        this.timeZone = timeZone;
        this.calendar = Calendar.getInstance(timeZone);
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Class getAutoRangeTimePeriodClass() {
        return this.autoRangeTimePeriodClass;
    }

    public void setAutoRangeTimePeriodClass(Class class_) {
        if (class_ == null) {
            throw new IllegalArgumentException("Null 'c' argument.");
        }
        this.autoRangeTimePeriodClass = class_;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Class getMajorTickTimePeriodClass() {
        return this.majorTickTimePeriodClass;
    }

    public void setMajorTickTimePeriodClass(Class class_) {
        if (class_ == null) {
            throw new IllegalArgumentException("Null 'c' argument.");
        }
        this.majorTickTimePeriodClass = class_;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public boolean isMinorTickMarksVisible() {
        return this.minorTickMarksVisible;
    }

    public void setMinorTickMarksVisible(boolean bl2) {
        this.minorTickMarksVisible = bl2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Class getMinorTickTimePeriodClass() {
        return this.minorTickTimePeriodClass;
    }

    public void setMinorTickTimePeriodClass(Class class_) {
        if (class_ == null) {
            throw new IllegalArgumentException("Null 'c' argument.");
        }
        this.minorTickTimePeriodClass = class_;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Stroke getMinorTickMarkStroke() {
        return this.minorTickMarkStroke;
    }

    public void setMinorTickMarkStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.minorTickMarkStroke = stroke;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Paint getMinorTickMarkPaint() {
        return this.minorTickMarkPaint;
    }

    public void setMinorTickMarkPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.minorTickMarkPaint = paint;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public float getMinorTickMarkInsideLength() {
        return this.minorTickMarkInsideLength;
    }

    public void setMinorTickMarkInsideLength(float f2) {
        this.minorTickMarkInsideLength = f2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public float getMinorTickMarkOutsideLength() {
        return this.minorTickMarkOutsideLength;
    }

    public void setMinorTickMarkOutsideLength(float f2) {
        this.minorTickMarkOutsideLength = f2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public PeriodAxisLabelInfo[] getLabelInfo() {
        return this.labelInfo;
    }

    public void setLabelInfo(PeriodAxisLabelInfo[] arrperiodAxisLabelInfo) {
        this.labelInfo = arrperiodAxisLabelInfo;
    }

    @Override
    public Range getRange() {
        return new Range(this.first.getFirstMillisecond(this.calendar), this.last.getLastMillisecond(this.calendar));
    }

    @Override
    public void setRange(Range range, boolean bl2, boolean bl3) {
        super.setRange(range, bl2, false);
        long l2 = Math.round(range.getUpperBound());
        long l3 = Math.round(range.getLowerBound());
        this.first = this.createInstance(this.autoRangeTimePeriodClass, new Date(l3), this.timeZone);
        this.last = this.createInstance(this.autoRangeTimePeriodClass, new Date(l2), this.timeZone);
    }

    @Override
    public void configure() {
        if (!this.isAutoRange()) return;
        this.autoAdjustRange();
    }

    @Override
    public AxisSpace reserveSpace(Graphics2D graphics2D, Plot plot, Rectangle2D rectangle2D, RectangleEdge rectangleEdge, AxisSpace axisSpace) {
        FontMetrics fontMetrics;
        PeriodAxisLabelInfo periodAxisLabelInfo;
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
        Rectangle2D rectangle2D2 = this.getLabelEnclosure(graphics2D, rectangleEdge);
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        for (int i2 = 0; i2 < this.labelInfo.length; d5 += periodAxisLabelInfo.getPadding().extendHeight((double)((double)fontMetrics.getHeight())), ++i2) {
            periodAxisLabelInfo = this.labelInfo[i2];
            fontMetrics = graphics2D.getFontMetrics(periodAxisLabelInfo.getLabelFont());
        }
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            d3 = rectangle2D2.getHeight();
            axisSpace.add(d3 + d5, rectangleEdge);
        } else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            d4 = rectangle2D2.getWidth();
            axisSpace.add(d4 + d5, rectangleEdge);
        }
        double d6 = 0.0;
        if (this.isTickMarksVisible()) {
            d6 = this.getTickMarkOutsideLength();
        }
        if (this.minorTickMarksVisible) {
            d6 = Math.max(d6, (double)this.minorTickMarkOutsideLength);
        }
        axisSpace.add(d6, rectangleEdge);
        return axisSpace;
    }

    @Override
    public AxisState draw(Graphics2D graphics2D, double d2, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge, PlotRenderingInfo plotRenderingInfo) {
        AxisState axisState = new AxisState(d2);
        if (this.isAxisLineVisible()) {
            this.drawAxisLine(graphics2D, d2, rectangle2D2, rectangleEdge);
        }
        this.drawTickMarks(graphics2D, axisState, rectangle2D2, rectangleEdge);
        int n2 = 0;
        while (n2 < this.labelInfo.length) {
            axisState = this.drawTickLabels(n2, graphics2D, axisState, rectangle2D2, rectangleEdge);
            ++n2;
        }
        return this.drawLabel(this.getLabel(), graphics2D, rectangle2D, rectangle2D2, rectangleEdge, axisState);
    }

    protected void drawTickMarks(Graphics2D graphics2D, AxisState axisState, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            this.drawTickMarksHorizontal(graphics2D, axisState, rectangle2D, rectangleEdge);
            return;
        }
        if (!RectangleEdge.isLeftOrRight(rectangleEdge)) return;
        this.drawTickMarksVertical(graphics2D, axisState, rectangle2D, rectangleEdge);
    }

    /*
     * Unable to fully structure code
     */
    protected void drawTickMarksHorizontal(Graphics2D var1_1, AxisState var2_2, Rectangle2D var3_3, RectangleEdge var4_4) {
        var5_5 = new ArrayList<NumberTick>();
        var6_6 = var3_3.getX();
        var8_7 = var2_2.getCursor();
        var10_8 = this.getTickMarkInsideLength();
        var12_9 = this.getTickMarkOutsideLength();
        var14_10 = RegularTimePeriod.createInstance(this.majorTickTimePeriodClass, this.first.getStart(), this.getTimeZone());
        var15_11 = var14_10.getFirstMillisecond(this.calendar);
        var17_12 = null;
        var18_13 = null;
        var19_14 = this.getFirst().getFirstMillisecond(this.calendar);
        var21_15 = this.getLast().getLastMillisecond(this.calendar);
        do {
            if (var15_11 > var21_15) ** GOTO lbl32
            var5_5.add(new NumberTick(new Double(var15_11), "", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
            var6_6 = this.valueToJava2D(var15_11, var3_3, var4_4);
            if (var4_4 == RectangleEdge.TOP) {
                var17_12 = new Line2D.Double(var6_6, var8_7, var6_6, var8_7 + var10_8);
                var18_13 = new Line2D.Double(var6_6, var8_7, var6_6, var8_7 - var12_9);
            } else if (var4_4 == RectangleEdge.BOTTOM) {
                var17_12 = new Line2D.Double(var6_6, var8_7, var6_6, var8_7 - var10_8);
                var18_13 = new Line2D.Double(var6_6, var8_7, var6_6, var8_7 + var12_9);
            }
            if (var15_11 > var19_14) {
                var1_1.setPaint(this.getTickMarkPaint());
                var1_1.setStroke(this.getTickMarkStroke());
                var1_1.draw(var17_12);
                var1_1.draw(var18_13);
            }
            if (!this.minorTickMarksVisible) ** GOTO lbl56
            var23_16 = RegularTimePeriod.createInstance(this.minorTickTimePeriodClass, new Date(var15_11), this.getTimeZone());
            var24_17 = var23_16.getFirstMillisecond(this.calendar);
            ** GOTO lbl39
lbl32: // 1 sources:
            if (var4_4 == RectangleEdge.TOP) {
                var2_2.cursorUp(Math.max(var12_9, (double)this.minorTickMarkOutsideLength));
            } else if (var4_4 == RectangleEdge.BOTTOM) {
                var2_2.cursorDown(Math.max(var12_9, (double)this.minorTickMarkOutsideLength));
            }
            var2_2.setTicks(var5_5);
            return;
lbl39: // 2 sources:
            while (var24_17 < var14_10.getLastMillisecond(this.calendar) && var24_17 < var21_15) {
                var26_18 = this.valueToJava2D(var24_17, var3_3, var4_4);
                if (var4_4 == RectangleEdge.TOP) {
                    var17_12 = new Line2D.Double(var26_18, var8_7, var26_18, var8_7 + (double)this.minorTickMarkInsideLength);
                    var18_13 = new Line2D.Double(var26_18, var8_7, var26_18, var8_7 - (double)this.minorTickMarkOutsideLength);
                } else if (var4_4 == RectangleEdge.BOTTOM) {
                    var17_12 = new Line2D.Double(var26_18, var8_7, var26_18, var8_7 - (double)this.minorTickMarkInsideLength);
                    var18_13 = new Line2D.Double(var26_18, var8_7, var26_18, var8_7 + (double)this.minorTickMarkOutsideLength);
                }
                if (var24_17 >= var19_14) {
                    var1_1.setPaint(this.minorTickMarkPaint);
                    var1_1.setStroke(this.minorTickMarkStroke);
                    var1_1.draw(var17_12);
                    var1_1.draw(var18_13);
                }
                var23_16 = var23_16.next();
                var24_17 = var23_16.getFirstMillisecond(this.calendar);
            }
lbl56: // 2 sources:
            var14_10 = var14_10.next();
            var15_11 = var14_10.getFirstMillisecond(this.calendar);
        } while (true);
    }

    protected void drawTickMarksVertical(Graphics2D graphics2D, AxisState axisState, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
    }

    protected AxisState drawTickLabels(int n2, Graphics2D graphics2D, AxisState axisState, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d2 = 0.0;
        FontMetrics fontMetrics = graphics2D.getFontMetrics(this.labelInfo[n2].getLabelFont());
        if (rectangleEdge == RectangleEdge.BOTTOM) {
            d2 = this.labelInfo[n2].getPadding().calculateTopOutset(fontMetrics.getHeight());
        } else if (rectangleEdge == RectangleEdge.TOP) {
            d2 = this.labelInfo[n2].getPadding().calculateBottomOutset(fontMetrics.getHeight());
        }
        axisState.moveCursor(d2, rectangleEdge);
        long l2 = this.first.getFirstMillisecond(this.calendar);
        long l3 = this.last.getLastMillisecond(this.calendar);
        graphics2D.setFont(this.labelInfo[n2].getLabelFont());
        graphics2D.setPaint(this.labelInfo[n2].getLabelPaint());
        RegularTimePeriod regularTimePeriod = this.labelInfo[n2].createInstance(new Date(l2), this.timeZone);
        RegularTimePeriod regularTimePeriod2 = this.labelInfo[n2].createInstance(new Date(l3), this.timeZone);
        String string = this.labelInfo[n2].getDateFormat().format(new Date(regularTimePeriod.getMiddleMillisecond(this.calendar)));
        String string2 = this.labelInfo[n2].getDateFormat().format(new Date(regularTimePeriod2.getMiddleMillisecond(this.calendar)));
        Rectangle2D rectangle2D2 = TextUtilities.getTextBounds(string, graphics2D, graphics2D.getFontMetrics());
        Rectangle2D rectangle2D3 = TextUtilities.getTextBounds(string2, graphics2D, graphics2D.getFontMetrics());
        double d3 = Math.max(rectangle2D2.getWidth(), rectangle2D3.getWidth());
        long l4 = Math.round(this.java2DToValue(rectangle2D.getX() + d3 + 5.0, rectangle2D, rectangleEdge)) - l2;
        long l5 = regularTimePeriod.getLastMillisecond(this.calendar) - regularTimePeriod.getFirstMillisecond(this.calendar);
        int n3 = (int)(l4 / l5) + 1;
        RegularTimePeriod regularTimePeriod3 = this.labelInfo[n2].createInstance(new Date(l2), this.timeZone);
        RectangularShape rectangularShape = null;
        long l6 = 0;
        float f2 = (float)axisState.getCursor();
        TextAnchor textAnchor = TextAnchor.TOP_CENTER;
        float f3 = (float)rectangle2D2.getHeight();
        if (rectangleEdge == RectangleEdge.TOP) {
            textAnchor = TextAnchor.BOTTOM_CENTER;
            f3 = - f3;
        }
        while (regularTimePeriod3.getFirstMillisecond(this.calendar) <= l3) {
            float f4;
            Rectangle2D rectangle2D4;
            float f5 = (float)this.valueToJava2D(regularTimePeriod3.getMiddleMillisecond(this.calendar), rectangle2D, rectangleEdge);
            DateFormat dateFormat = this.labelInfo[n2].getDateFormat();
            String string3 = dateFormat.format(new Date(regularTimePeriod3.getMiddleMillisecond(this.calendar)));
            long l7 = regularTimePeriod3.getFirstMillisecond(this.calendar);
            long l8 = regularTimePeriod3.getLastMillisecond(this.calendar);
            if (l8 > l3 && (double)f5 + (rectangle2D4 = TextUtilities.getTextBounds(string3, graphics2D, graphics2D.getFontMetrics())).getWidth() / 2.0 > rectangle2D.getMaxX()) {
                f4 = (float)this.valueToJava2D(Math.max(l7, l2), rectangle2D, rectangleEdge);
                if (rectangle2D4.getWidth() < rectangle2D.getMaxX() - (double)f4) {
                    f5 = ((float)rectangle2D.getMaxX() + f4) / 2.0f;
                } else {
                    string3 = null;
                }
            }
            if (l7 < l2) {
                rectangle2D4 = TextUtilities.getTextBounds(string3, graphics2D, graphics2D.getFontMetrics());
                if ((double)f5 - rectangle2D4.getWidth() / 2.0 < rectangle2D.getX()) {
                    f4 = (float)this.valueToJava2D(Math.min(l8, l3), rectangle2D, rectangleEdge);
                    if (rectangle2D4.getWidth() < (double)f4 - rectangle2D.getX()) {
                        f5 = (f4 + (float)rectangle2D.getX()) / 2.0f;
                    } else {
                        string3 = null;
                    }
                }
                if (string3 != null) {
                    graphics2D.setPaint(this.labelInfo[n2].getLabelPaint());
                    rectangularShape = TextUtilities.drawAlignedString(string3, graphics2D, f5, f2, textAnchor);
                }
            }
            if (l6 > 0 && this.labelInfo[n2].getDrawDividers()) {
                long l9 = regularTimePeriod3.getFirstMillisecond(this.calendar);
                long l10 = (l6 + l9) / 2;
                float f6 = (float)this.valueToJava2D(l10, rectangle2D, rectangleEdge);
                graphics2D.setStroke(this.labelInfo[n2].getDividerStroke());
                graphics2D.setPaint(this.labelInfo[n2].getDividerPaint());
                graphics2D.draw(new Line2D.Float(f6, f2, f6, f2 + f3));
            }
            l6 = l8;
            for (int n4 = 0; n4 < n3; regularTimePeriod3 = regularTimePeriod3.next(), ++n4) {
            }
        }
        double d4 = 0.0;
        if (rectangularShape != null) {
            d4 = rectangularShape.getHeight();
            if (rectangleEdge == RectangleEdge.BOTTOM) {
                d4 += this.labelInfo[n2].getPadding().calculateBottomOutset(fontMetrics.getHeight());
            } else if (rectangleEdge == RectangleEdge.TOP) {
                d4 += this.labelInfo[n2].getPadding().calculateTopOutset(fontMetrics.getHeight());
            }
        }
        axisState.moveCursor(d4, rectangleEdge);
        return axisState;
    }

    @Override
    public List refreshTicks(Graphics2D graphics2D, AxisState axisState, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public double valueToJava2D(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d3 = Double.NaN;
        double d4 = this.first.getFirstMillisecond(this.calendar);
        double d5 = this.last.getLastMillisecond(this.calendar);
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            double d6 = rectangle2D.getX();
            double d7 = rectangle2D.getMaxX();
            if (!this.isInverted()) return d6 + (d2 - d4) / (d5 - d4) * (d7 - d6);
            return d7 + (d2 - d4) / (d5 - d4) * (d6 - d7);
        }
        if (!RectangleEdge.isLeftOrRight(rectangleEdge)) return d3;
        double d8 = rectangle2D.getMinY();
        double d9 = rectangle2D.getMaxY();
        if (!this.isInverted()) return d9 - (d2 - d4) / (d5 - d4) * (d9 - d8);
        return d8 + (d2 - d4) / (d5 - d4) * (d9 - d8);
    }

    @Override
    public double java2DToValue(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d3 = Double.NaN;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = this.first.getFirstMillisecond(this.calendar);
        double d7 = this.last.getLastMillisecond(this.calendar);
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            d4 = rectangle2D.getX();
            d5 = rectangle2D.getMaxX();
        } else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            d4 = rectangle2D.getMaxY();
            d5 = rectangle2D.getY();
        }
        if (!this.isInverted()) return d6 + (d2 - d4) / (d5 - d4) * (d7 - d6);
        return d7 - (d2 - d4) / (d5 - d4) * (d7 - d6);
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
        long l2 = Math.round(range.getUpperBound());
        long l3 = Math.round(range.getLowerBound());
        this.first = this.createInstance(this.autoRangeTimePeriodClass, new Date(l3), this.timeZone);
        this.last = this.createInstance(this.autoRangeTimePeriodClass, new Date(l2), this.timeZone);
        this.setRange(range, false, false);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof PeriodAxis)) return false;
        if (!super.equals(object)) return false;
        PeriodAxis periodAxis = (PeriodAxis)object;
        if (!this.first.equals(periodAxis.first)) {
            return false;
        }
        if (!this.last.equals(periodAxis.last)) {
            return false;
        }
        if (!this.timeZone.equals(periodAxis.timeZone)) {
            return false;
        }
        if (!this.autoRangeTimePeriodClass.equals(periodAxis.autoRangeTimePeriodClass)) {
            return false;
        }
        if (this.isMinorTickMarksVisible() != periodAxis.isMinorTickMarksVisible()) {
            return false;
        }
        if (!this.majorTickTimePeriodClass.equals(periodAxis.majorTickTimePeriodClass)) {
            return false;
        }
        if (!this.minorTickTimePeriodClass.equals(periodAxis.minorTickTimePeriodClass)) {
            return false;
        }
        if (!this.minorTickMarkPaint.equals(periodAxis.minorTickMarkPaint)) {
            return false;
        }
        if (!this.minorTickMarkStroke.equals(periodAxis.minorTickMarkStroke)) {
            return false;
        }
        if (Arrays.equals(this.labelInfo, periodAxis.labelInfo)) return true;
        return false;
    }

    public int hashCode() {
        if (this.getLabel() == null) return 0;
        return this.getLabel().hashCode();
    }

    @Override
    public Object clone() {
        PeriodAxis periodAxis = (PeriodAxis)super.clone();
        periodAxis.timeZone = (TimeZone)this.timeZone.clone();
        periodAxis.labelInfo = new PeriodAxisLabelInfo[this.labelInfo.length];
        int n2 = 0;
        while (n2 < this.labelInfo.length) {
            periodAxis.labelInfo[n2] = this.labelInfo[n2];
            ++n2;
        }
        return periodAxis;
    }

    private RegularTimePeriod createInstance(Class class_, Date date, TimeZone timeZone) {
        RegularTimePeriod regularTimePeriod = null;
        try {
            Class[] arrclass = new Class[2];
            Class class_2 = class$java$util$Date == null ? (PeriodAxis.class$java$util$Date = PeriodAxis.class$("java.util.Date")) : class$java$util$Date;
            arrclass[0] = class_2;
            Class class_3 = class$java$util$TimeZone == null ? (PeriodAxis.class$java$util$TimeZone = PeriodAxis.class$("java.util.TimeZone")) : class$java$util$TimeZone;
            arrclass[1] = class_3;
            Constructor constructor = class_.getDeclaredConstructor(arrclass);
            return (RegularTimePeriod)constructor.newInstance(date, timeZone);
        }
        catch (Exception var5_6) {
            // empty catch block
        }
        return regularTimePeriod;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.minorTickMarkStroke, objectOutputStream);
        SerialUtilities.writePaint(this.minorTickMarkPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.minorTickMarkStroke = SerialUtilities.readStroke(objectInputStream);
        this.minorTickMarkPaint = SerialUtilities.readPaint(objectInputStream);
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

