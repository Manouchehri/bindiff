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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.DateAxis$1;
import org.jfree.chart.axis.DateAxis$DefaultTimeline;
import org.jfree.chart.axis.DateTick;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.SegmentedTimeline;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.Timeline;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.data.Range;
import org.jfree.data.time.DateRange;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;

public class DateAxis
extends ValueAxis
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -1013460999649007604L;
    public static final DateRange DEFAULT_DATE_RANGE = new DateRange();
    public static final double DEFAULT_AUTO_RANGE_MINIMUM_SIZE_IN_MILLISECONDS = 2.0;
    public static final DateTickUnit DEFAULT_DATE_TICK_UNIT = new DateTickUnit(2, 1, new SimpleDateFormat());
    public static final Date DEFAULT_ANCHOR_DATE = new Date();
    private DateTickUnit tickUnit;
    private DateFormat dateFormatOverride;
    private DateTickMarkPosition tickMarkPosition = DateTickMarkPosition.START;
    private static final Timeline DEFAULT_TIMELINE = new DateAxis$DefaultTimeline(null);
    private TimeZone timeZone;
    private Timeline timeline;

    public DateAxis() {
        this(null);
    }

    public DateAxis(String string) {
        this(string, TimeZone.getDefault());
    }

    public DateAxis(String string, TimeZone timeZone) {
        super(string, DateAxis.createStandardDateTickUnits(timeZone));
        this.setTickUnit(DEFAULT_DATE_TICK_UNIT, false, false);
        this.setAutoRangeMinimumSize(2.0);
        this.setRange(DEFAULT_DATE_RANGE, false, false);
        this.dateFormatOverride = null;
        this.timeZone = timeZone;
        this.timeline = DEFAULT_TIMELINE;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        if (this.timeZone.equals(timeZone)) return;
        this.timeZone = timeZone;
        this.setStandardTickUnits(DateAxis.createStandardDateTickUnits(timeZone));
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    public void setTimeline(Timeline timeline) {
        if (this.timeline == timeline) return;
        this.timeline = timeline;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public DateTickUnit getTickUnit() {
        return this.tickUnit;
    }

    public void setTickUnit(DateTickUnit dateTickUnit) {
        this.setTickUnit(dateTickUnit, true, true);
    }

    public void setTickUnit(DateTickUnit dateTickUnit, boolean bl2, boolean bl3) {
        this.tickUnit = dateTickUnit;
        if (bl3) {
            this.setAutoTickUnitSelection(false, false);
        }
        if (!bl2) return;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public DateFormat getDateFormatOverride() {
        return this.dateFormatOverride;
    }

    public void setDateFormatOverride(DateFormat dateFormat) {
        this.dateFormatOverride = dateFormat;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    @Override
    public void setRange(Range range) {
        this.setRange(range, true, true);
    }

    @Override
    public void setRange(Range range, boolean bl2, boolean bl3) {
        if (range == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        if (!(range instanceof DateRange)) {
            range = new DateRange(range);
        }
        super.setRange(range, bl2, bl3);
    }

    public void setRange(Date date, Date date2) {
        if (date.getTime() >= date2.getTime()) {
            throw new IllegalArgumentException("Requires 'lower' < 'upper'.");
        }
        this.setRange(new DateRange(date, date2));
    }

    @Override
    public void setRange(double d2, double d3) {
        if (d2 >= d3) {
            throw new IllegalArgumentException("Requires 'lower' < 'upper'.");
        }
        this.setRange(new DateRange(d2, d3));
    }

    public Date getMinimumDate() {
        Date date = null;
        Range range = this.getRange();
        if (!(range instanceof DateRange)) return new Date((long)range.getLowerBound());
        DateRange dateRange = (DateRange)range;
        return dateRange.getLowerDate();
    }

    public void setMinimumDate(Date date) {
        this.setRange(new DateRange(date, this.getMaximumDate()), true, false);
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Date getMaximumDate() {
        Date date = null;
        Range range = this.getRange();
        if (!(range instanceof DateRange)) return new Date((long)range.getUpperBound());
        DateRange dateRange = (DateRange)range;
        return dateRange.getUpperDate();
    }

    public void setMaximumDate(Date date) {
        this.setRange(new DateRange(this.getMinimumDate(), date), true, false);
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public DateTickMarkPosition getTickMarkPosition() {
        return this.tickMarkPosition;
    }

    public void setTickMarkPosition(DateTickMarkPosition dateTickMarkPosition) {
        if (dateTickMarkPosition == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        this.tickMarkPosition = dateTickMarkPosition;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    @Override
    public void configure() {
        if (!this.isAutoRange()) return;
        this.autoAdjustRange();
    }

    public boolean isHiddenValue(long l2) {
        if (this.timeline.containsDomainValue(new Date(l2))) return false;
        return true;
    }

    @Override
    public double valueToJava2D(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        d2 = this.timeline.toTimelineValue((long)d2);
        DateRange dateRange = (DateRange)this.getRange();
        double d3 = this.timeline.toTimelineValue(dateRange.getLowerDate());
        double d4 = this.timeline.toTimelineValue(dateRange.getUpperDate());
        double d5 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            double d6 = rectangle2D.getX();
            double d7 = rectangle2D.getMaxX();
            if (!this.isInverted()) return d6 + (d2 - d3) / (d4 - d3) * (d7 - d6);
            return d7 + (d2 - d3) / (d4 - d3) * (d6 - d7);
        }
        if (!RectangleEdge.isLeftOrRight(rectangleEdge)) return d5;
        double d8 = rectangle2D.getMinY();
        double d9 = rectangle2D.getMaxY();
        if (!this.isInverted()) return d9 - (d2 - d3) / (d4 - d3) * (d9 - d8);
        return d8 + (d2 - d3) / (d4 - d3) * (d9 - d8);
    }

    public double dateToJava2D(Date date, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d2 = date.getTime();
        return this.valueToJava2D(d2, rectangle2D, rectangleEdge);
    }

    @Override
    public double java2DToValue(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d3;
        DateRange dateRange = (DateRange)this.getRange();
        double d4 = this.timeline.toTimelineValue(dateRange.getLowerDate());
        double d5 = this.timeline.toTimelineValue(dateRange.getUpperDate());
        double d6 = 0.0;
        double d7 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            d6 = rectangle2D.getX();
            d7 = rectangle2D.getMaxX();
        } else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            d6 = rectangle2D.getMaxY();
            d7 = rectangle2D.getY();
        }
        if (this.isInverted()) {
            d3 = d5 - (d2 - d6) / (d7 - d6) * (d5 - d4);
            return this.timeline.toMillisecond((long)d3);
        }
        d3 = d4 + (d2 - d6) / (d7 - d6) * (d5 - d4);
        return this.timeline.toMillisecond((long)d3);
    }

    public Date calculateLowestVisibleTickValue(DateTickUnit dateTickUnit) {
        return this.nextStandardDate(this.getMinimumDate(), dateTickUnit);
    }

    public Date calculateHighestVisibleTickValue(DateTickUnit dateTickUnit) {
        return this.previousStandardDate(this.getMaximumDate(), dateTickUnit);
    }

    protected Date previousStandardDate(Date date, DateTickUnit dateTickUnit) {
        Calendar calendar = Calendar.getInstance(this.timeZone);
        calendar.setTime(date);
        int n2 = dateTickUnit.getCount();
        int n3 = calendar.get(dateTickUnit.getCalendarField());
        int n4 = n2 * (n3 / n2);
        switch (dateTickUnit.getUnit()) {
            case 6: {
                int n5 = calendar.get(1);
                int n6 = calendar.get(2);
                int n7 = calendar.get(5);
                int n8 = calendar.get(11);
                int n9 = calendar.get(12);
                int n10 = calendar.get(13);
                calendar.set(n5, n6, n7, n8, n9, n10);
                calendar.set(14, n4);
                return calendar.getTime();
            }
            case 5: {
                int n11 = calendar.get(1);
                int n12 = calendar.get(2);
                int n13 = calendar.get(5);
                int n14 = calendar.get(11);
                int n15 = calendar.get(12);
                int n16 = this.tickMarkPosition == DateTickMarkPosition.START ? 0 : (this.tickMarkPosition == DateTickMarkPosition.MIDDLE ? 500 : 999);
                calendar.set(14, n16);
                calendar.set(n11, n12, n13, n14, n15, n4);
                return calendar.getTime();
            }
            case 4: {
                int n17 = calendar.get(1);
                int n18 = calendar.get(2);
                int n19 = calendar.get(5);
                int n20 = calendar.get(11);
                int n21 = this.tickMarkPosition == DateTickMarkPosition.START ? 0 : (this.tickMarkPosition == DateTickMarkPosition.MIDDLE ? 30 : 59);
                calendar.clear(14);
                calendar.set(n17, n18, n19, n20, n4, n21);
                Date date2 = calendar.getTime();
                if (date2.getTime() < date.getTime()) return date2;
                calendar.set(12, n4 - 1);
                return calendar.getTime();
            }
            case 3: {
                int n22;
                int n23;
                int n24 = calendar.get(1);
                int n25 = calendar.get(2);
                int n26 = calendar.get(5);
                if (this.tickMarkPosition == DateTickMarkPosition.START) {
                    n23 = 0;
                    n22 = 0;
                } else if (this.tickMarkPosition == DateTickMarkPosition.MIDDLE) {
                    n23 = 30;
                    n22 = 0;
                } else {
                    n23 = 59;
                    n22 = 59;
                }
                calendar.clear(14);
                calendar.set(n24, n25, n26, n4, n23, n22);
                Date date3 = calendar.getTime();
                if (date3.getTime() < date.getTime()) return date3;
                calendar.set(11, n4 - 1);
                return calendar.getTime();
            }
            case 2: {
                int n27;
                int n28 = calendar.get(1);
                int n29 = calendar.get(2);
                if (this.tickMarkPosition == DateTickMarkPosition.START) {
                    n27 = 0;
                    boolean bl2 = false;
                    boolean bl3 = false;
                } else if (this.tickMarkPosition == DateTickMarkPosition.MIDDLE) {
                    n27 = 12;
                    boolean bl4 = false;
                    boolean bl5 = false;
                } else {
                    n27 = 23;
                    int n30 = 59;
                    int n31 = 59;
                }
                calendar.clear(14);
                calendar.set(n28, n29, n4, n27, 0, 0);
                Date date4 = calendar.getTime();
                if (date4.getTime() < date.getTime()) return date4;
                calendar.set(5, n4 - 1);
                return calendar.getTime();
            }
            case 1: {
                int n32 = calendar.get(1);
                calendar.clear(14);
                calendar.set(n32, n4, 1, 0, 0, 0);
                Month month = new Month(calendar.getTime());
                Date date5 = this.calculateDateForPosition(month, this.tickMarkPosition);
                long l2 = date5.getTime();
                if (l2 <= date.getTime()) return date5;
                month = (Month)month.previous();
                return this.calculateDateForPosition(month, this.tickMarkPosition);
            }
            case 0: {
                int n33;
                int n34;
                if (this.tickMarkPosition == DateTickMarkPosition.START) {
                    n33 = 0;
                    n34 = 1;
                } else if (this.tickMarkPosition == DateTickMarkPosition.MIDDLE) {
                    n33 = 6;
                    n34 = 1;
                } else {
                    n33 = 11;
                    n34 = 31;
                }
                calendar.clear(14);
                calendar.set(n4, n33, n34, 0, 0, 0);
                Date date6 = calendar.getTime();
                if (date6.getTime() < date.getTime()) return date6;
                calendar.set(1, n4 - 1);
                return calendar.getTime();
            }
        }
        return null;
    }

    private Date calculateDateForPosition(RegularTimePeriod regularTimePeriod, DateTickMarkPosition dateTickMarkPosition) {
        if (dateTickMarkPosition == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        Date date = null;
        if (dateTickMarkPosition == DateTickMarkPosition.START) {
            return new Date(regularTimePeriod.getFirstMillisecond());
        }
        if (dateTickMarkPosition == DateTickMarkPosition.MIDDLE) {
            return new Date(regularTimePeriod.getMiddleMillisecond());
        }
        if (dateTickMarkPosition != DateTickMarkPosition.END) return date;
        return new Date(regularTimePeriod.getLastMillisecond());
    }

    protected Date nextStandardDate(Date date, DateTickUnit dateTickUnit) {
        Date date2 = this.previousStandardDate(date, dateTickUnit);
        Calendar calendar = Calendar.getInstance(this.timeZone);
        calendar.setTime(date2);
        calendar.add(dateTickUnit.getCalendarField(), dateTickUnit.getCount());
        return calendar.getTime();
    }

    public static TickUnitSource createStandardDateTickUnits() {
        return DateAxis.createStandardDateTickUnits(TimeZone.getDefault());
    }

    public static TickUnitSource createStandardDateTickUnits(TimeZone timeZone) {
        if (timeZone == null) {
            throw new IllegalArgumentException("Null 'zone' argument.");
        }
        TickUnits tickUnits = new TickUnits();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("HH:mm");
        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("d-MMM, HH:mm");
        SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("d-MMM");
        SimpleDateFormat simpleDateFormat6 = new SimpleDateFormat("MMM-yyyy");
        SimpleDateFormat simpleDateFormat7 = new SimpleDateFormat("yyyy");
        simpleDateFormat.setTimeZone(timeZone);
        simpleDateFormat2.setTimeZone(timeZone);
        simpleDateFormat3.setTimeZone(timeZone);
        simpleDateFormat4.setTimeZone(timeZone);
        simpleDateFormat5.setTimeZone(timeZone);
        simpleDateFormat6.setTimeZone(timeZone);
        simpleDateFormat7.setTimeZone(timeZone);
        tickUnits.add(new DateTickUnit(6, 1, simpleDateFormat));
        tickUnits.add(new DateTickUnit(6, 5, 6, 1, simpleDateFormat));
        tickUnits.add(new DateTickUnit(6, 10, 6, 1, simpleDateFormat));
        tickUnits.add(new DateTickUnit(6, 25, 6, 5, simpleDateFormat));
        tickUnits.add(new DateTickUnit(6, 50, 6, 10, simpleDateFormat));
        tickUnits.add(new DateTickUnit(6, 100, 6, 10, simpleDateFormat));
        tickUnits.add(new DateTickUnit(6, 250, 6, 10, simpleDateFormat));
        tickUnits.add(new DateTickUnit(6, 500, 6, 50, simpleDateFormat));
        tickUnits.add(new DateTickUnit(5, 1, 6, 50, simpleDateFormat2));
        tickUnits.add(new DateTickUnit(5, 5, 5, 1, simpleDateFormat2));
        tickUnits.add(new DateTickUnit(5, 10, 5, 1, simpleDateFormat2));
        tickUnits.add(new DateTickUnit(5, 30, 5, 5, simpleDateFormat2));
        tickUnits.add(new DateTickUnit(4, 1, 5, 5, simpleDateFormat3));
        tickUnits.add(new DateTickUnit(4, 2, 5, 10, simpleDateFormat3));
        tickUnits.add(new DateTickUnit(4, 5, 4, 1, simpleDateFormat3));
        tickUnits.add(new DateTickUnit(4, 10, 4, 1, simpleDateFormat3));
        tickUnits.add(new DateTickUnit(4, 15, 4, 5, simpleDateFormat3));
        tickUnits.add(new DateTickUnit(4, 20, 4, 5, simpleDateFormat3));
        tickUnits.add(new DateTickUnit(4, 30, 4, 5, simpleDateFormat3));
        tickUnits.add(new DateTickUnit(3, 1, 4, 5, simpleDateFormat3));
        tickUnits.add(new DateTickUnit(3, 2, 4, 10, simpleDateFormat3));
        tickUnits.add(new DateTickUnit(3, 4, 4, 30, simpleDateFormat3));
        tickUnits.add(new DateTickUnit(3, 6, 3, 1, simpleDateFormat3));
        tickUnits.add(new DateTickUnit(3, 12, 3, 1, simpleDateFormat4));
        tickUnits.add(new DateTickUnit(2, 1, 3, 1, simpleDateFormat5));
        tickUnits.add(new DateTickUnit(2, 2, 3, 1, simpleDateFormat5));
        tickUnits.add(new DateTickUnit(2, 7, 2, 1, simpleDateFormat5));
        tickUnits.add(new DateTickUnit(2, 15, 2, 1, simpleDateFormat5));
        tickUnits.add(new DateTickUnit(1, 1, 2, 1, simpleDateFormat6));
        tickUnits.add(new DateTickUnit(1, 2, 2, 1, simpleDateFormat6));
        tickUnits.add(new DateTickUnit(1, 3, 1, 1, simpleDateFormat6));
        tickUnits.add(new DateTickUnit(1, 4, 1, 1, simpleDateFormat6));
        tickUnits.add(new DateTickUnit(1, 6, 1, 1, simpleDateFormat6));
        tickUnits.add(new DateTickUnit(0, 1, 1, 1, simpleDateFormat7));
        tickUnits.add(new DateTickUnit(0, 2, 1, 3, simpleDateFormat7));
        tickUnits.add(new DateTickUnit(0, 5, 0, 1, simpleDateFormat7));
        tickUnits.add(new DateTickUnit(0, 10, 0, 1, simpleDateFormat7));
        tickUnits.add(new DateTickUnit(0, 25, 0, 5, simpleDateFormat7));
        tickUnits.add(new DateTickUnit(0, 50, 0, 10, simpleDateFormat7));
        tickUnits.add(new DateTickUnit(0, 100, 0, 20, simpleDateFormat7));
        return tickUnits;
    }

    @Override
    protected void autoAdjustRange() {
        long l2;
        Plot plot = this.getPlot();
        if (plot == null) {
            return;
        }
        if (!(plot instanceof ValueAxisPlot)) return;
        ValueAxisPlot valueAxisPlot = (ValueAxisPlot)((Object)plot);
        Range range = valueAxisPlot.getDataRange(this);
        if (range == null) {
            range = this.timeline instanceof SegmentedTimeline ? new DateRange(((SegmentedTimeline)this.timeline).getStartTime(), ((SegmentedTimeline)this.timeline).getStartTime() + 1) : new DateRange();
        }
        long l3 = this.timeline.toTimelineValue((long)range.getUpperBound());
        long l4 = (long)this.getFixedAutoRange();
        if ((double)l4 > 0.0) {
            l2 = l3 - l4;
        } else {
            long l5;
            l2 = this.timeline.toTimelineValue((long)range.getLowerBound());
            double d2 = l3 - l2;
            if (d2 < (double)(l5 = (long)this.getAutoRangeMinimumSize())) {
                long l6 = (long)((double)l5 - d2) / 2;
                l3 += l6;
                l2 -= l6;
            }
            l3 += (long)(d2 * this.getUpperMargin());
            l2 -= (long)(d2 * this.getLowerMargin());
        }
        l3 = this.timeline.toMillisecond(l3);
        l2 = this.timeline.toMillisecond(l2);
        DateRange dateRange = new DateRange(new Date(l2), new Date(l3));
        this.setRange(dateRange, false, false);
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
        long l2 = 0;
        if (this.timeline instanceof SegmentedTimeline) {
            l2 = ((SegmentedTimeline)this.timeline).getStartTime();
        }
        double d2 = this.valueToJava2D((double)l2 + 0.0, rectangle2D, rectangleEdge);
        double d3 = this.estimateMaximumTickLabelWidth(graphics2D, this.getTickUnit());
        TickUnitSource tickUnitSource = this.getStandardTickUnits();
        TickUnit tickUnit = tickUnitSource.getCeilingTickUnit(this.getTickUnit());
        double d4 = this.valueToJava2D((double)l2 + tickUnit.getSize(), rectangle2D, rectangleEdge);
        double d5 = Math.abs(d4 - d2);
        double d6 = d3 / d5 * tickUnit.getSize();
        DateTickUnit dateTickUnit = (DateTickUnit)tickUnitSource.getCeilingTickUnit(d6);
        double d7 = this.valueToJava2D((double)l2 + dateTickUnit.getSize(), rectangle2D, rectangleEdge);
        double d8 = Math.abs(d7 - d2);
        d3 = this.estimateMaximumTickLabelWidth(graphics2D, dateTickUnit);
        if (d3 > d8) {
            dateTickUnit = (DateTickUnit)tickUnitSource.getLargerTickUnit(dateTickUnit);
        }
        this.setTickUnit(dateTickUnit, false, false);
    }

    protected void selectVerticalAutoTickUnit(Graphics2D graphics2D, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d2;
        double d3;
        double d4;
        double d5;
        TickUnitSource tickUnitSource = this.getStandardTickUnits();
        double d6 = this.valueToJava2D(0.0, rectangle2D, rectangleEdge);
        double d7 = this.getRange().getLength() / 10.0;
        DateTickUnit dateTickUnit = (DateTickUnit)tickUnitSource.getCeilingTickUnit(d7);
        double d8 = this.estimateMaximumTickLabelHeight(graphics2D, dateTickUnit);
        double d9 = d8 / (d2 = Math.abs((d3 = this.valueToJava2D(dateTickUnit.getSize(), rectangle2D, rectangleEdge)) - d6)) * dateTickUnit.getSize();
        DateTickUnit dateTickUnit2 = (DateTickUnit)tickUnitSource.getCeilingTickUnit(d9);
        double d10 = this.estimateMaximumTickLabelHeight(graphics2D, dateTickUnit2);
        DateTickUnit dateTickUnit3 = d10 < (d4 = Math.abs((d5 = this.valueToJava2D(dateTickUnit2.getSize(), rectangle2D, rectangleEdge)) - d6)) ? dateTickUnit2 : (DateTickUnit)tickUnitSource.getLargerTickUnit(dateTickUnit2);
        this.setTickUnit(dateTickUnit3, false, false);
    }

    private double estimateMaximumTickLabelWidth(Graphics2D graphics2D, DateTickUnit dateTickUnit) {
        RectangleInsets rectangleInsets = this.getTickLabelInsets();
        double d2 = rectangleInsets.getLeft() + rectangleInsets.getRight();
        Font font = this.getTickLabelFont();
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        LineMetrics lineMetrics = font.getLineMetrics("ABCxyz", fontRenderContext);
        if (this.isVerticalTickLabels()) {
            return d2 += (double)lineMetrics.getHeight();
        }
        DateRange dateRange = (DateRange)this.getRange();
        Date date = dateRange.getLowerDate();
        Date date2 = dateRange.getUpperDate();
        String string = null;
        String string2 = null;
        DateFormat dateFormat = this.getDateFormatOverride();
        if (dateFormat != null) {
            string = dateFormat.format(date);
            string2 = dateFormat.format(date2);
        } else {
            string = dateTickUnit.dateToString(date);
            string2 = dateTickUnit.dateToString(date2);
        }
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        double d3 = fontMetrics.stringWidth(string);
        double d4 = fontMetrics.stringWidth(string2);
        d2 += Math.max(d3, d4);
        return d2;
    }

    private double estimateMaximumTickLabelHeight(Graphics2D graphics2D, DateTickUnit dateTickUnit) {
        RectangleInsets rectangleInsets = this.getTickLabelInsets();
        double d2 = rectangleInsets.getTop() + rectangleInsets.getBottom();
        Font font = this.getTickLabelFont();
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        LineMetrics lineMetrics = font.getLineMetrics("ABCxyz", fontRenderContext);
        if (!this.isVerticalTickLabels()) {
            return d2 += (double)lineMetrics.getHeight();
        }
        DateRange dateRange = (DateRange)this.getRange();
        Date date = dateRange.getLowerDate();
        Date date2 = dateRange.getUpperDate();
        String string = null;
        String string2 = null;
        DateFormat dateFormat = this.getDateFormatOverride();
        if (dateFormat != null) {
            string = dateFormat.format(date);
            string2 = dateFormat.format(date2);
        } else {
            string = dateTickUnit.dateToString(date);
            string2 = dateTickUnit.dateToString(date2);
        }
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        double d3 = fontMetrics.stringWidth(string);
        double d4 = fontMetrics.stringWidth(string2);
        d2 += Math.max(d3, d4);
        return d2;
    }

    @Override
    public List refreshTicks(Graphics2D graphics2D, AxisState axisState, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        List list = null;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            return this.refreshTicksHorizontal(graphics2D, rectangle2D, rectangleEdge);
        }
        if (!RectangleEdge.isLeftOrRight(rectangleEdge)) return list;
        return this.refreshTicksVertical(graphics2D, rectangle2D, rectangleEdge);
    }

    /*
     * Exception decompiling
     */
    protected List refreshTicksHorizontal(Graphics2D var1_1, Rectangle2D var2_2, RectangleEdge var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: First case is not immediately after switch.
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:366)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.rebuildSwitches(SwitchReplacer.java:334)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:539)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    protected List refreshTicksVertical(Graphics2D graphics2D, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        ArrayList<DateTick> arrayList = new ArrayList<DateTick>();
        Font font = this.getTickLabelFont();
        graphics2D.setFont(font);
        if (this.isAutoTickUnitSelection()) {
            this.selectAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
        }
        DateTickUnit dateTickUnit = this.getTickUnit();
        Date date = this.calculateLowestVisibleTickValue(dateTickUnit);
        Date date2 = this.getMaximumDate();
        while (date.before(date2)) {
            if (!this.isHiddenValue(date.getTime())) {
                DateFormat dateFormat = this.getDateFormatOverride();
                String string = dateFormat != null ? dateFormat.format(date) : this.tickUnit.dateToString(date);
                TextAnchor textAnchor = null;
                TextAnchor textAnchor2 = null;
                double d2 = 0.0;
                if (this.isVerticalTickLabels()) {
                    textAnchor = TextAnchor.BOTTOM_CENTER;
                    textAnchor2 = TextAnchor.BOTTOM_CENTER;
                    d2 = rectangleEdge == RectangleEdge.LEFT ? -1.5707963267948966 : 1.5707963267948966;
                } else if (rectangleEdge == RectangleEdge.LEFT) {
                    textAnchor = TextAnchor.CENTER_RIGHT;
                    textAnchor2 = TextAnchor.CENTER_RIGHT;
                } else {
                    textAnchor = TextAnchor.CENTER_LEFT;
                    textAnchor2 = TextAnchor.CENTER_LEFT;
                }
                DateTick dateTick = new DateTick(date, string, textAnchor, textAnchor2, d2);
                arrayList.add(dateTick);
                date = dateTickUnit.addToDate(date);
                continue;
            }
            date = dateTickUnit.rollDate(date);
        }
        return arrayList;
    }

    @Override
    public AxisState draw(Graphics2D graphics2D, double d2, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge, PlotRenderingInfo plotRenderingInfo) {
        if (!this.isVisible()) {
            AxisState axisState = new AxisState(d2);
            List list = this.refreshTicks(graphics2D, axisState, rectangle2D2, rectangleEdge);
            axisState.setTicks(list);
            return axisState;
        }
        AxisState axisState = this.drawTickMarksAndLabels(graphics2D, d2, rectangle2D, rectangle2D2, rectangleEdge);
        return this.drawLabel(this.getLabel(), graphics2D, rectangle2D, rectangle2D2, rectangleEdge, axisState);
    }

    @Override
    public void zoomRange(double d2, double d3) {
        double d4 = this.timeline.toTimelineValue((long)this.getRange().getLowerBound());
        double d5 = this.timeline.toTimelineValue((long)this.getRange().getUpperBound()) - this.timeline.toTimelineValue((long)this.getRange().getLowerBound());
        DateRange dateRange = null;
        dateRange = this.isInverted() ? new DateRange(this.timeline.toMillisecond((long)(d4 + d5 * (1.0 - d3))), this.timeline.toMillisecond((long)(d4 + d5 * (1.0 - d2)))) : new DateRange(this.timeline.toMillisecond((long)(d4 + d5 * d2)), this.timeline.toMillisecond((long)(d4 + d5 * d3)));
        this.setRange(dateRange);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof DateAxis)) {
            return false;
        }
        DateAxis dateAxis = (DateAxis)object;
        if (!ObjectUtilities.equal(this.tickUnit, dateAxis.tickUnit)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.dateFormatOverride, dateAxis.dateFormatOverride)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.tickMarkPosition, dateAxis.tickMarkPosition)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.timeline, dateAxis.timeline)) {
            return false;
        }
        if (super.equals(object)) return true;
        return false;
    }

    public int hashCode() {
        if (this.getLabel() == null) return 0;
        return this.getLabel().hashCode();
    }

    @Override
    public Object clone() {
        DateAxis dateAxis = (DateAxis)super.clone();
        if (this.dateFormatOverride == null) return dateAxis;
        dateAxis.dateFormatOverride = (DateFormat)this.dateFormatOverride.clone();
        return dateAxis;
    }
}

