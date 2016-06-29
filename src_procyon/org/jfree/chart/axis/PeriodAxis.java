package org.jfree.chart.axis;

import org.jfree.util.*;
import org.jfree.data.time.*;
import java.text.*;
import org.jfree.chart.event.*;
import org.jfree.data.*;
import org.jfree.ui.*;
import org.jfree.text.*;
import java.awt.*;
import java.awt.geom.*;
import org.jfree.chart.plot.*;
import java.util.*;
import org.jfree.io.*;
import java.io.*;

public class PeriodAxis extends ValueAxis implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = 8353295532075872069L;
    private RegularTimePeriod first;
    private RegularTimePeriod last;
    private TimeZone timeZone;
    private Calendar calendar;
    private Class autoRangeTimePeriodClass;
    private Class majorTickTimePeriodClass;
    private boolean minorTickMarksVisible;
    private Class minorTickTimePeriodClass;
    private float minorTickMarkInsideLength;
    private float minorTickMarkOutsideLength;
    private transient Stroke minorTickMarkStroke;
    private transient Paint minorTickMarkPaint;
    private PeriodAxisLabelInfo[] labelInfo;
    static Class class$org$jfree$data$time$Month;
    static Class class$org$jfree$data$time$Year;
    static Class class$java$util$Date;
    static Class class$java$util$TimeZone;
    
    public PeriodAxis(final String s) {
        this(s, new Day(), new Day());
    }
    
    public PeriodAxis(final String s, final RegularTimePeriod regularTimePeriod, final RegularTimePeriod regularTimePeriod2) {
        this(s, regularTimePeriod, regularTimePeriod2, TimeZone.getDefault());
    }
    
    public PeriodAxis(final String s, final RegularTimePeriod first, final RegularTimePeriod last, final TimeZone timeZone) {
        super(s, null);
        this.minorTickMarkInsideLength = 0.0f;
        this.minorTickMarkOutsideLength = 2.0f;
        this.minorTickMarkStroke = new BasicStroke(0.5f);
        this.minorTickMarkPaint = Color.black;
        this.first = first;
        this.last = last;
        this.timeZone = timeZone;
        this.calendar = Calendar.getInstance(timeZone);
        this.autoRangeTimePeriodClass = first.getClass();
        this.majorTickTimePeriodClass = first.getClass();
        this.minorTickMarksVisible = false;
        this.minorTickTimePeriodClass = RegularTimePeriod.downsize(this.majorTickTimePeriodClass);
        this.setAutoRange(true);
        (this.labelInfo = new PeriodAxisLabelInfo[2])[0] = new PeriodAxisLabelInfo((PeriodAxis.class$org$jfree$data$time$Month == null) ? (PeriodAxis.class$org$jfree$data$time$Month = class$("org.jfree.data.time.Month")) : PeriodAxis.class$org$jfree$data$time$Month, new SimpleDateFormat("MMM"));
        this.labelInfo[1] = new PeriodAxisLabelInfo((PeriodAxis.class$org$jfree$data$time$Year == null) ? (PeriodAxis.class$org$jfree$data$time$Year = class$("org.jfree.data.time.Year")) : PeriodAxis.class$org$jfree$data$time$Year, new SimpleDateFormat("yyyy"));
    }
    
    public RegularTimePeriod getFirst() {
        return this.first;
    }
    
    public void setFirst(final RegularTimePeriod first) {
        if (first == null) {
            throw new IllegalArgumentException("Null 'first' argument.");
        }
        this.first = first;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public RegularTimePeriod getLast() {
        return this.last;
    }
    
    public void setLast(final RegularTimePeriod last) {
        if (last == null) {
            throw new IllegalArgumentException("Null 'last' argument.");
        }
        this.last = last;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public TimeZone getTimeZone() {
        return this.timeZone;
    }
    
    public void setTimeZone(final TimeZone timeZone) {
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
    
    public void setAutoRangeTimePeriodClass(final Class autoRangeTimePeriodClass) {
        if (autoRangeTimePeriodClass == null) {
            throw new IllegalArgumentException("Null 'c' argument.");
        }
        this.autoRangeTimePeriodClass = autoRangeTimePeriodClass;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Class getMajorTickTimePeriodClass() {
        return this.majorTickTimePeriodClass;
    }
    
    public void setMajorTickTimePeriodClass(final Class majorTickTimePeriodClass) {
        if (majorTickTimePeriodClass == null) {
            throw new IllegalArgumentException("Null 'c' argument.");
        }
        this.majorTickTimePeriodClass = majorTickTimePeriodClass;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public boolean isMinorTickMarksVisible() {
        return this.minorTickMarksVisible;
    }
    
    public void setMinorTickMarksVisible(final boolean minorTickMarksVisible) {
        this.minorTickMarksVisible = minorTickMarksVisible;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Class getMinorTickTimePeriodClass() {
        return this.minorTickTimePeriodClass;
    }
    
    public void setMinorTickTimePeriodClass(final Class minorTickTimePeriodClass) {
        if (minorTickTimePeriodClass == null) {
            throw new IllegalArgumentException("Null 'c' argument.");
        }
        this.minorTickTimePeriodClass = minorTickTimePeriodClass;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Stroke getMinorTickMarkStroke() {
        return this.minorTickMarkStroke;
    }
    
    public void setMinorTickMarkStroke(final Stroke minorTickMarkStroke) {
        if (minorTickMarkStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.minorTickMarkStroke = minorTickMarkStroke;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Paint getMinorTickMarkPaint() {
        return this.minorTickMarkPaint;
    }
    
    public void setMinorTickMarkPaint(final Paint minorTickMarkPaint) {
        if (minorTickMarkPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.minorTickMarkPaint = minorTickMarkPaint;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public float getMinorTickMarkInsideLength() {
        return this.minorTickMarkInsideLength;
    }
    
    public void setMinorTickMarkInsideLength(final float minorTickMarkInsideLength) {
        this.minorTickMarkInsideLength = minorTickMarkInsideLength;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public float getMinorTickMarkOutsideLength() {
        return this.minorTickMarkOutsideLength;
    }
    
    public void setMinorTickMarkOutsideLength(final float minorTickMarkOutsideLength) {
        this.minorTickMarkOutsideLength = minorTickMarkOutsideLength;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public PeriodAxisLabelInfo[] getLabelInfo() {
        return this.labelInfo;
    }
    
    public void setLabelInfo(final PeriodAxisLabelInfo[] labelInfo) {
        this.labelInfo = labelInfo;
    }
    
    public Range getRange() {
        return new Range(this.first.getFirstMillisecond(this.calendar), this.last.getLastMillisecond(this.calendar));
    }
    
    public void setRange(final Range range, final boolean b, final boolean b2) {
        super.setRange(range, b, false);
        final long round = Math.round(range.getUpperBound());
        this.first = this.createInstance(this.autoRangeTimePeriodClass, new Date(Math.round(range.getLowerBound())), this.timeZone);
        this.last = this.createInstance(this.autoRangeTimePeriodClass, new Date(round), this.timeZone);
    }
    
    public void configure() {
        if (this.isAutoRange()) {
            this.autoAdjustRange();
        }
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
        final Rectangle2D labelEnclosure = this.getLabelEnclosure(graphics2D, rectangleEdge);
        double n = 0.0;
        for (int i = 0; i < this.labelInfo.length; ++i) {
            final PeriodAxisLabelInfo periodAxisLabelInfo = this.labelInfo[i];
            n += periodAxisLabelInfo.getPadding().extendHeight(graphics2D.getFontMetrics(periodAxisLabelInfo.getLabelFont()).getHeight());
        }
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            axisSpace.add(labelEnclosure.getHeight() + n, rectangleEdge);
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            axisSpace.add(labelEnclosure.getWidth() + n, rectangleEdge);
        }
        double max = 0.0;
        if (this.isTickMarksVisible()) {
            max = this.getTickMarkOutsideLength();
        }
        if (this.minorTickMarksVisible) {
            max = Math.max(max, this.minorTickMarkOutsideLength);
        }
        axisSpace.add(max, rectangleEdge);
        return axisSpace;
    }
    
    public AxisState draw(final Graphics2D graphics2D, final double n, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge, final PlotRenderingInfo plotRenderingInfo) {
        AxisState drawTickLabels = new AxisState(n);
        if (this.isAxisLineVisible()) {
            this.drawAxisLine(graphics2D, n, rectangle2D2, rectangleEdge);
        }
        this.drawTickMarks(graphics2D, drawTickLabels, rectangle2D2, rectangleEdge);
        for (int i = 0; i < this.labelInfo.length; ++i) {
            drawTickLabels = this.drawTickLabels(i, graphics2D, drawTickLabels, rectangle2D2, rectangleEdge);
        }
        return this.drawLabel(this.getLabel(), graphics2D, rectangle2D, rectangle2D2, rectangleEdge, drawTickLabels);
    }
    
    protected void drawTickMarks(final Graphics2D graphics2D, final AxisState axisState, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            this.drawTickMarksHorizontal(graphics2D, axisState, rectangle2D, rectangleEdge);
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            this.drawTickMarksVertical(graphics2D, axisState, rectangle2D, rectangleEdge);
        }
    }
    
    protected void drawTickMarksHorizontal(final Graphics2D graphics2D, final AxisState axisState, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final ArrayList<NumberTick> ticks = new ArrayList<NumberTick>();
        rectangle2D.getX();
        final double cursor = axisState.getCursor();
        final double n = this.getTickMarkInsideLength();
        final double n2 = this.getTickMarkOutsideLength();
        RegularTimePeriod regularTimePeriod = RegularTimePeriod.createInstance(this.majorTickTimePeriodClass, this.first.getStart(), this.getTimeZone());
        long n3 = regularTimePeriod.getFirstMillisecond(this.calendar);
        Shape shape = null;
        Shape shape2 = null;
        final long firstMillisecond = this.getFirst().getFirstMillisecond(this.calendar);
        for (long lastMillisecond = this.getLast().getLastMillisecond(this.calendar); n3 <= lastMillisecond; n3 = regularTimePeriod.getFirstMillisecond(this.calendar)) {
            ticks.add(new NumberTick(new Double(n3), "", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
            final double valueToJava2D = this.valueToJava2D(n3, rectangle2D, rectangleEdge);
            if (rectangleEdge == RectangleEdge.TOP) {
                shape = new Line2D.Double(valueToJava2D, cursor, valueToJava2D, cursor + n);
                shape2 = new Line2D.Double(valueToJava2D, cursor, valueToJava2D, cursor - n2);
            }
            else if (rectangleEdge == RectangleEdge.BOTTOM) {
                shape = new Line2D.Double(valueToJava2D, cursor, valueToJava2D, cursor - n);
                shape2 = new Line2D.Double(valueToJava2D, cursor, valueToJava2D, cursor + n2);
            }
            if (n3 > firstMillisecond) {
                graphics2D.setPaint(this.getTickMarkPaint());
                graphics2D.setStroke(this.getTickMarkStroke());
                graphics2D.draw(shape);
                graphics2D.draw(shape2);
            }
            if (this.minorTickMarksVisible) {
                RegularTimePeriod regularTimePeriod2 = RegularTimePeriod.createInstance(this.minorTickTimePeriodClass, new Date(n3), this.getTimeZone());
                for (long n4 = regularTimePeriod2.getFirstMillisecond(this.calendar); n4 < regularTimePeriod.getLastMillisecond(this.calendar) && n4 < lastMillisecond; n4 = regularTimePeriod2.getFirstMillisecond(this.calendar)) {
                    final double valueToJava2D2 = this.valueToJava2D(n4, rectangle2D, rectangleEdge);
                    if (rectangleEdge == RectangleEdge.TOP) {
                        shape = new Line2D.Double(valueToJava2D2, cursor, valueToJava2D2, cursor + this.minorTickMarkInsideLength);
                        shape2 = new Line2D.Double(valueToJava2D2, cursor, valueToJava2D2, cursor - this.minorTickMarkOutsideLength);
                    }
                    else if (rectangleEdge == RectangleEdge.BOTTOM) {
                        shape = new Line2D.Double(valueToJava2D2, cursor, valueToJava2D2, cursor - this.minorTickMarkInsideLength);
                        shape2 = new Line2D.Double(valueToJava2D2, cursor, valueToJava2D2, cursor + this.minorTickMarkOutsideLength);
                    }
                    if (n4 >= firstMillisecond) {
                        graphics2D.setPaint(this.minorTickMarkPaint);
                        graphics2D.setStroke(this.minorTickMarkStroke);
                        graphics2D.draw(shape);
                        graphics2D.draw(shape2);
                    }
                    regularTimePeriod2 = regularTimePeriod2.next();
                }
            }
            regularTimePeriod = regularTimePeriod.next();
        }
        if (rectangleEdge == RectangleEdge.TOP) {
            axisState.cursorUp(Math.max(n2, this.minorTickMarkOutsideLength));
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            axisState.cursorDown(Math.max(n2, this.minorTickMarkOutsideLength));
        }
        axisState.setTicks(ticks);
    }
    
    protected void drawTickMarksVertical(final Graphics2D graphics2D, final AxisState axisState, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
    }
    
    protected AxisState drawTickLabels(final int n, final Graphics2D graphics2D, final AxisState axisState, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        double n2 = 0.0;
        final FontMetrics fontMetrics = graphics2D.getFontMetrics(this.labelInfo[n].getLabelFont());
        if (rectangleEdge == RectangleEdge.BOTTOM) {
            n2 = this.labelInfo[n].getPadding().calculateTopOutset(fontMetrics.getHeight());
        }
        else if (rectangleEdge == RectangleEdge.TOP) {
            n2 = this.labelInfo[n].getPadding().calculateBottomOutset(fontMetrics.getHeight());
        }
        axisState.moveCursor(n2, rectangleEdge);
        final long firstMillisecond = this.first.getFirstMillisecond(this.calendar);
        final long lastMillisecond = this.last.getLastMillisecond(this.calendar);
        graphics2D.setFont(this.labelInfo[n].getLabelFont());
        graphics2D.setPaint(this.labelInfo[n].getLabelPaint());
        final RegularTimePeriod instance = this.labelInfo[n].createInstance(new Date(firstMillisecond), this.timeZone);
        final RegularTimePeriod instance2 = this.labelInfo[n].createInstance(new Date(lastMillisecond), this.timeZone);
        final String format = this.labelInfo[n].getDateFormat().format(new Date(instance.getMiddleMillisecond(this.calendar)));
        final String format2 = this.labelInfo[n].getDateFormat().format(new Date(instance2.getMiddleMillisecond(this.calendar)));
        final Rectangle2D textBounds = TextUtilities.getTextBounds(format, graphics2D, graphics2D.getFontMetrics());
        final int n3 = (int)((Math.round(this.java2DToValue(rectangle2D.getX() + Math.max(textBounds.getWidth(), TextUtilities.getTextBounds(format2, graphics2D, graphics2D.getFontMetrics()).getWidth()) + 5.0, rectangle2D, rectangleEdge)) - firstMillisecond) / (instance.getLastMillisecond(this.calendar) - instance.getFirstMillisecond(this.calendar))) + 1;
        RegularTimePeriod regularTimePeriod = this.labelInfo[n].createInstance(new Date(firstMillisecond), this.timeZone);
        RectangularShape drawAlignedString = null;
        long n4 = 0L;
        final float n5 = (float)axisState.getCursor();
        TextAnchor textAnchor = TextAnchor.TOP_CENTER;
        float n6 = (float)textBounds.getHeight();
        if (rectangleEdge == RectangleEdge.TOP) {
            textAnchor = TextAnchor.BOTTOM_CENTER;
            n6 = -n6;
        }
        while (regularTimePeriod.getFirstMillisecond(this.calendar) <= lastMillisecond) {
            float n7 = (float)this.valueToJava2D(regularTimePeriod.getMiddleMillisecond(this.calendar), rectangle2D, rectangleEdge);
            String format3 = this.labelInfo[n].getDateFormat().format(new Date(regularTimePeriod.getMiddleMillisecond(this.calendar)));
            final long firstMillisecond2 = regularTimePeriod.getFirstMillisecond(this.calendar);
            final long lastMillisecond2 = regularTimePeriod.getLastMillisecond(this.calendar);
            if (lastMillisecond2 > lastMillisecond) {
                final Rectangle2D textBounds2 = TextUtilities.getTextBounds(format3, graphics2D, graphics2D.getFontMetrics());
                if (n7 + textBounds2.getWidth() / 2.0 > rectangle2D.getMaxX()) {
                    final float n8 = (float)this.valueToJava2D(Math.max(firstMillisecond2, firstMillisecond), rectangle2D, rectangleEdge);
                    if (textBounds2.getWidth() < rectangle2D.getMaxX() - n8) {
                        n7 = ((float)rectangle2D.getMaxX() + n8) / 2.0f;
                    }
                    else {
                        format3 = null;
                    }
                }
            }
            if (firstMillisecond2 < firstMillisecond) {
                final Rectangle2D textBounds3 = TextUtilities.getTextBounds(format3, graphics2D, graphics2D.getFontMetrics());
                if (n7 - textBounds3.getWidth() / 2.0 < rectangle2D.getX()) {
                    final float n9 = (float)this.valueToJava2D(Math.min(lastMillisecond2, lastMillisecond), rectangle2D, rectangleEdge);
                    if (textBounds3.getWidth() < n9 - rectangle2D.getX()) {
                        n7 = (n9 + (float)rectangle2D.getX()) / 2.0f;
                    }
                    else {
                        format3 = null;
                    }
                }
            }
            if (format3 != null) {
                graphics2D.setPaint(this.labelInfo[n].getLabelPaint());
                drawAlignedString = TextUtilities.drawAlignedString(format3, graphics2D, n7, n5, textAnchor);
            }
            if (n4 > 0L && this.labelInfo[n].getDrawDividers()) {
                final float n10 = (float)this.valueToJava2D((n4 + regularTimePeriod.getFirstMillisecond(this.calendar)) / 2L, rectangle2D, rectangleEdge);
                graphics2D.setStroke(this.labelInfo[n].getDividerStroke());
                graphics2D.setPaint(this.labelInfo[n].getDividerPaint());
                graphics2D.draw(new Line2D.Float(n10, n5, n10, n5 + n6));
            }
            n4 = lastMillisecond2;
            for (int i = 0; i < n3; ++i) {
                regularTimePeriod = regularTimePeriod.next();
            }
        }
        double height = 0.0;
        if (drawAlignedString != null) {
            height = drawAlignedString.getHeight();
            if (rectangleEdge == RectangleEdge.BOTTOM) {
                height += this.labelInfo[n].getPadding().calculateBottomOutset(fontMetrics.getHeight());
            }
            else if (rectangleEdge == RectangleEdge.TOP) {
                height += this.labelInfo[n].getPadding().calculateTopOutset(fontMetrics.getHeight());
            }
        }
        axisState.moveCursor(height, rectangleEdge);
        return axisState;
    }
    
    public List refreshTicks(final Graphics2D graphics2D, final AxisState axisState, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        return Collections.EMPTY_LIST;
    }
    
    public double valueToJava2D(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        double n2 = Double.NaN;
        final double n3 = this.first.getFirstMillisecond(this.calendar);
        final double n4 = this.last.getLastMillisecond(this.calendar);
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            final double x = rectangle2D.getX();
            final double maxX = rectangle2D.getMaxX();
            if (this.isInverted()) {
                n2 = maxX + (n - n3) / (n4 - n3) * (x - maxX);
            }
            else {
                n2 = x + (n - n3) / (n4 - n3) * (maxX - x);
            }
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            final double minY = rectangle2D.getMinY();
            final double maxY = rectangle2D.getMaxY();
            if (this.isInverted()) {
                n2 = minY + (n - n3) / (n4 - n3) * (maxY - minY);
            }
            else {
                n2 = maxY - (n - n3) / (n4 - n3) * (maxY - minY);
            }
        }
        return n2;
    }
    
    public double java2DToValue(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        double n2 = 0.0;
        double n3 = 0.0;
        final double n4 = this.first.getFirstMillisecond(this.calendar);
        final double n5 = this.last.getLastMillisecond(this.calendar);
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            n2 = rectangle2D.getX();
            n3 = rectangle2D.getMaxX();
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            n2 = rectangle2D.getMaxY();
            n3 = rectangle2D.getY();
        }
        double n6;
        if (this.isInverted()) {
            n6 = n5 - (n - n2) / (n3 - n2) * (n5 - n4);
        }
        else {
            n6 = n4 + (n - n2) / (n3 - n2) * (n5 - n4);
        }
        return n6;
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
            final long round = Math.round(range.getUpperBound());
            this.first = this.createInstance(this.autoRangeTimePeriodClass, new Date(Math.round(range.getLowerBound())), this.timeZone);
            this.last = this.createInstance(this.autoRangeTimePeriodClass, new Date(round), this.timeZone);
            this.setRange(range, false, false);
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof PeriodAxis && super.equals(o)) {
            final PeriodAxis periodAxis = (PeriodAxis)o;
            return this.first.equals(periodAxis.first) && this.last.equals(periodAxis.last) && this.timeZone.equals(periodAxis.timeZone) && this.autoRangeTimePeriodClass.equals(periodAxis.autoRangeTimePeriodClass) && this.isMinorTickMarksVisible() == periodAxis.isMinorTickMarksVisible() && this.majorTickTimePeriodClass.equals(periodAxis.majorTickTimePeriodClass) && this.minorTickTimePeriodClass.equals(periodAxis.minorTickTimePeriodClass) && this.minorTickMarkPaint.equals(periodAxis.minorTickMarkPaint) && this.minorTickMarkStroke.equals(periodAxis.minorTickMarkStroke) && Arrays.equals(this.labelInfo, periodAxis.labelInfo);
        }
        return false;
    }
    
    public int hashCode() {
        if (this.getLabel() != null) {
            return this.getLabel().hashCode();
        }
        return 0;
    }
    
    public Object clone() {
        final PeriodAxis periodAxis = (PeriodAxis)super.clone();
        periodAxis.timeZone = (TimeZone)this.timeZone.clone();
        periodAxis.labelInfo = new PeriodAxisLabelInfo[this.labelInfo.length];
        for (int i = 0; i < this.labelInfo.length; ++i) {
            periodAxis.labelInfo[i] = this.labelInfo[i];
        }
        return periodAxis;
    }
    
    private RegularTimePeriod createInstance(final Class clazz, final Date date, final TimeZone timeZone) {
        RegularTimePeriod regularTimePeriod = null;
        try {
            regularTimePeriod = clazz.getDeclaredConstructor((PeriodAxis.class$java$util$Date == null) ? (PeriodAxis.class$java$util$Date = class$("java.util.Date")) : PeriodAxis.class$java$util$Date, (PeriodAxis.class$java$util$TimeZone == null) ? (PeriodAxis.class$java$util$TimeZone = class$("java.util.TimeZone")) : PeriodAxis.class$java$util$TimeZone).newInstance(date, timeZone);
        }
        catch (Exception ex) {}
        return regularTimePeriod;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.minorTickMarkStroke, objectOutputStream);
        SerialUtilities.writePaint(this.minorTickMarkPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.minorTickMarkStroke = SerialUtilities.readStroke(objectInputStream);
        this.minorTickMarkPaint = SerialUtilities.readPaint(objectInputStream);
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
