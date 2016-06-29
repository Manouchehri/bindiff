package org.jfree.chart.axis;

import java.io.*;
import org.jfree.data.*;
import org.jfree.chart.event.*;
import java.awt.geom.*;
import java.text.*;
import java.awt.font.*;
import java.awt.*;
import java.util.*;
import org.jfree.ui.*;
import org.jfree.data.time.*;
import org.jfree.chart.plot.*;
import org.jfree.util.*;

public class DateAxis extends ValueAxis implements Serializable, Cloneable
{
    private static final long serialVersionUID = -1013460999649007604L;
    public static final DateRange DEFAULT_DATE_RANGE;
    public static final double DEFAULT_AUTO_RANGE_MINIMUM_SIZE_IN_MILLISECONDS = 2.0;
    public static final DateTickUnit DEFAULT_DATE_TICK_UNIT;
    public static final Date DEFAULT_ANCHOR_DATE;
    private DateTickUnit tickUnit;
    private DateFormat dateFormatOverride;
    private DateTickMarkPosition tickMarkPosition;
    private static final Timeline DEFAULT_TIMELINE;
    private TimeZone timeZone;
    private Timeline timeline;
    
    public DateAxis() {
        this(null);
    }
    
    public DateAxis(final String s) {
        this(s, TimeZone.getDefault());
    }
    
    public DateAxis(final String s, final TimeZone timeZone) {
        super(s, createStandardDateTickUnits(timeZone));
        this.tickMarkPosition = DateTickMarkPosition.START;
        this.setTickUnit(DateAxis.DEFAULT_DATE_TICK_UNIT, false, false);
        this.setAutoRangeMinimumSize(2.0);
        this.setRange(DateAxis.DEFAULT_DATE_RANGE, false, false);
        this.dateFormatOverride = null;
        this.timeZone = timeZone;
        this.timeline = DateAxis.DEFAULT_TIMELINE;
    }
    
    public TimeZone getTimeZone() {
        return this.timeZone;
    }
    
    public void setTimeZone(final TimeZone timeZone) {
        if (!this.timeZone.equals(timeZone)) {
            this.timeZone = timeZone;
            this.setStandardTickUnits(createStandardDateTickUnits(timeZone));
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public Timeline getTimeline() {
        return this.timeline;
    }
    
    public void setTimeline(final Timeline timeline) {
        if (this.timeline != timeline) {
            this.timeline = timeline;
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public DateTickUnit getTickUnit() {
        return this.tickUnit;
    }
    
    public void setTickUnit(final DateTickUnit dateTickUnit) {
        this.setTickUnit(dateTickUnit, true, true);
    }
    
    public void setTickUnit(final DateTickUnit tickUnit, final boolean b, final boolean b2) {
        this.tickUnit = tickUnit;
        if (b2) {
            this.setAutoTickUnitSelection(false, false);
        }
        if (b) {
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public DateFormat getDateFormatOverride() {
        return this.dateFormatOverride;
    }
    
    public void setDateFormatOverride(final DateFormat dateFormatOverride) {
        this.dateFormatOverride = dateFormatOverride;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public void setRange(final Range range) {
        this.setRange(range, true, true);
    }
    
    public void setRange(Range range, final boolean b, final boolean b2) {
        if (range == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        if (!(range instanceof DateRange)) {
            range = new DateRange(range);
        }
        super.setRange(range, b, b2);
    }
    
    public void setRange(final Date date, final Date date2) {
        if (date.getTime() >= date2.getTime()) {
            throw new IllegalArgumentException("Requires 'lower' < 'upper'.");
        }
        this.setRange(new DateRange(date, date2));
    }
    
    public void setRange(final double n, final double n2) {
        if (n >= n2) {
            throw new IllegalArgumentException("Requires 'lower' < 'upper'.");
        }
        this.setRange(new DateRange(n, n2));
    }
    
    public Date getMinimumDate() {
        final Range range = this.getRange();
        Date lowerDate;
        if (range instanceof DateRange) {
            lowerDate = ((DateRange)range).getLowerDate();
        }
        else {
            lowerDate = new Date((long)range.getLowerBound());
        }
        return lowerDate;
    }
    
    public void setMinimumDate(final Date date) {
        this.setRange(new DateRange(date, this.getMaximumDate()), true, false);
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Date getMaximumDate() {
        final Range range = this.getRange();
        Date upperDate;
        if (range instanceof DateRange) {
            upperDate = ((DateRange)range).getUpperDate();
        }
        else {
            upperDate = new Date((long)range.getUpperBound());
        }
        return upperDate;
    }
    
    public void setMaximumDate(final Date date) {
        this.setRange(new DateRange(this.getMinimumDate(), date), true, false);
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public DateTickMarkPosition getTickMarkPosition() {
        return this.tickMarkPosition;
    }
    
    public void setTickMarkPosition(final DateTickMarkPosition tickMarkPosition) {
        if (tickMarkPosition == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        this.tickMarkPosition = tickMarkPosition;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public void configure() {
        if (this.isAutoRange()) {
            this.autoAdjustRange();
        }
    }
    
    public boolean isHiddenValue(final long n) {
        return !this.timeline.containsDomainValue(new Date(n));
    }
    
    public double valueToJava2D(double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        n = this.timeline.toTimelineValue((long)n);
        final DateRange dateRange = (DateRange)this.getRange();
        final double n2 = this.timeline.toTimelineValue(dateRange.getLowerDate());
        final double n3 = this.timeline.toTimelineValue(dateRange.getUpperDate());
        double n4 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            final double x = rectangle2D.getX();
            final double maxX = rectangle2D.getMaxX();
            if (this.isInverted()) {
                n4 = maxX + (n - n2) / (n3 - n2) * (x - maxX);
            }
            else {
                n4 = x + (n - n2) / (n3 - n2) * (maxX - x);
            }
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            final double minY = rectangle2D.getMinY();
            final double maxY = rectangle2D.getMaxY();
            if (this.isInverted()) {
                n4 = minY + (n - n2) / (n3 - n2) * (maxY - minY);
            }
            else {
                n4 = maxY - (n - n2) / (n3 - n2) * (maxY - minY);
            }
        }
        return n4;
    }
    
    public double dateToJava2D(final Date date, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        return this.valueToJava2D(date.getTime(), rectangle2D, rectangleEdge);
    }
    
    public double java2DToValue(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final DateRange dateRange = (DateRange)this.getRange();
        final double n2 = this.timeline.toTimelineValue(dateRange.getLowerDate());
        final double n3 = this.timeline.toTimelineValue(dateRange.getUpperDate());
        double n4 = 0.0;
        double n5 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            n4 = rectangle2D.getX();
            n5 = rectangle2D.getMaxX();
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            n4 = rectangle2D.getMaxY();
            n5 = rectangle2D.getY();
        }
        double n6;
        if (this.isInverted()) {
            n6 = n3 - (n - n4) / (n5 - n4) * (n3 - n2);
        }
        else {
            n6 = n2 + (n - n4) / (n5 - n4) * (n3 - n2);
        }
        return this.timeline.toMillisecond((long)n6);
    }
    
    public Date calculateLowestVisibleTickValue(final DateTickUnit dateTickUnit) {
        return this.nextStandardDate(this.getMinimumDate(), dateTickUnit);
    }
    
    public Date calculateHighestVisibleTickValue(final DateTickUnit dateTickUnit) {
        return this.previousStandardDate(this.getMaximumDate(), dateTickUnit);
    }
    
    protected Date previousStandardDate(final Date time, final DateTickUnit dateTickUnit) {
        final Calendar instance = Calendar.getInstance(this.timeZone);
        instance.setTime(time);
        final int count = dateTickUnit.getCount();
        final int n = count * (instance.get(dateTickUnit.getCalendarField()) / count);
        switch (dateTickUnit.getUnit()) {
            case 6: {
                instance.set(instance.get(1), instance.get(2), instance.get(5), instance.get(11), instance.get(12), instance.get(13));
                instance.set(14, n);
                return instance.getTime();
            }
            case 5: {
                final int value = instance.get(1);
                final int value2 = instance.get(2);
                final int value3 = instance.get(5);
                final int value4 = instance.get(11);
                final int value5 = instance.get(12);
                int n2;
                if (this.tickMarkPosition == DateTickMarkPosition.START) {
                    n2 = 0;
                }
                else if (this.tickMarkPosition == DateTickMarkPosition.MIDDLE) {
                    n2 = 500;
                }
                else {
                    n2 = 999;
                }
                instance.set(14, n2);
                instance.set(value, value2, value3, value4, value5, n);
                return instance.getTime();
            }
            case 4: {
                final int value6 = instance.get(1);
                final int value7 = instance.get(2);
                final int value8 = instance.get(5);
                final int value9 = instance.get(11);
                int n3;
                if (this.tickMarkPosition == DateTickMarkPosition.START) {
                    n3 = 0;
                }
                else if (this.tickMarkPosition == DateTickMarkPosition.MIDDLE) {
                    n3 = 30;
                }
                else {
                    n3 = 59;
                }
                instance.clear(14);
                instance.set(value6, value7, value8, value9, n, n3);
                Date date = instance.getTime();
                if (date.getTime() >= time.getTime()) {
                    instance.set(12, n - 1);
                    date = instance.getTime();
                }
                return date;
            }
            case 3: {
                final int value10 = instance.get(1);
                final int value11 = instance.get(2);
                final int value12 = instance.get(5);
                int n4;
                int n5;
                if (this.tickMarkPosition == DateTickMarkPosition.START) {
                    n4 = 0;
                    n5 = 0;
                }
                else if (this.tickMarkPosition == DateTickMarkPosition.MIDDLE) {
                    n4 = 30;
                    n5 = 0;
                }
                else {
                    n4 = 59;
                    n5 = 59;
                }
                instance.clear(14);
                instance.set(value10, value11, value12, n, n4, n5);
                Date date2 = instance.getTime();
                if (date2.getTime() >= time.getTime()) {
                    instance.set(11, n - 1);
                    date2 = instance.getTime();
                }
                return date2;
            }
            case 2: {
                final int value13 = instance.get(1);
                final int value14 = instance.get(2);
                int n6;
                if (this.tickMarkPosition == DateTickMarkPosition.START) {
                    n6 = 0;
                }
                else if (this.tickMarkPosition == DateTickMarkPosition.MIDDLE) {
                    n6 = 12;
                }
                else {
                    n6 = 23;
                }
                instance.clear(14);
                instance.set(value13, value14, n, n6, 0, 0);
                Date date3 = instance.getTime();
                if (date3.getTime() >= time.getTime()) {
                    instance.set(5, n - 1);
                    date3 = instance.getTime();
                }
                return date3;
            }
            case 1: {
                final int value15 = instance.get(1);
                instance.clear(14);
                instance.set(value15, n, 1, 0, 0, 0);
                final Month month = new Month(instance.getTime());
                Date date4 = this.calculateDateForPosition(month, this.tickMarkPosition);
                if (date4.getTime() > time.getTime()) {
                    date4 = this.calculateDateForPosition(month.previous(), this.tickMarkPosition);
                }
                return date4;
            }
            case 0: {
                int n7;
                int n8;
                if (this.tickMarkPosition == DateTickMarkPosition.START) {
                    n7 = 0;
                    n8 = 1;
                }
                else if (this.tickMarkPosition == DateTickMarkPosition.MIDDLE) {
                    n7 = 6;
                    n8 = 1;
                }
                else {
                    n7 = 11;
                    n8 = 31;
                }
                instance.clear(14);
                instance.set(n, n7, n8, 0, 0, 0);
                Date date5 = instance.getTime();
                if (date5.getTime() >= time.getTime()) {
                    instance.set(1, n - 1);
                    date5 = instance.getTime();
                }
                return date5;
            }
            default: {
                return null;
            }
        }
    }
    
    private Date calculateDateForPosition(final RegularTimePeriod regularTimePeriod, final DateTickMarkPosition dateTickMarkPosition) {
        if (dateTickMarkPosition == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        Date date = null;
        if (dateTickMarkPosition == DateTickMarkPosition.START) {
            date = new Date(regularTimePeriod.getFirstMillisecond());
        }
        else if (dateTickMarkPosition == DateTickMarkPosition.MIDDLE) {
            date = new Date(regularTimePeriod.getMiddleMillisecond());
        }
        else if (dateTickMarkPosition == DateTickMarkPosition.END) {
            date = new Date(regularTimePeriod.getLastMillisecond());
        }
        return date;
    }
    
    protected Date nextStandardDate(final Date date, final DateTickUnit dateTickUnit) {
        final Date previousStandardDate = this.previousStandardDate(date, dateTickUnit);
        final Calendar instance = Calendar.getInstance(this.timeZone);
        instance.setTime(previousStandardDate);
        instance.add(dateTickUnit.getCalendarField(), dateTickUnit.getCount());
        return instance.getTime();
    }
    
    public static TickUnitSource createStandardDateTickUnits() {
        return createStandardDateTickUnits(TimeZone.getDefault());
    }
    
    public static TickUnitSource createStandardDateTickUnits(final TimeZone timeZone) {
        if (timeZone == null) {
            throw new IllegalArgumentException("Null 'zone' argument.");
        }
        final TickUnits tickUnits = new TickUnits();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        final SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss");
        final SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("HH:mm");
        final SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("d-MMM, HH:mm");
        final SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("d-MMM");
        final SimpleDateFormat simpleDateFormat6 = new SimpleDateFormat("MMM-yyyy");
        final SimpleDateFormat simpleDateFormat7 = new SimpleDateFormat("yyyy");
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
    
    protected void autoAdjustRange() {
        final Plot plot = this.getPlot();
        if (plot == null) {
            return;
        }
        if (plot instanceof ValueAxisPlot) {
            Range dataRange = ((ValueAxisPlot)plot).getDataRange(this);
            if (dataRange == null) {
                if (this.timeline instanceof SegmentedTimeline) {
                    dataRange = new DateRange(((SegmentedTimeline)this.timeline).getStartTime(), ((SegmentedTimeline)this.timeline).getStartTime() + 1L);
                }
                else {
                    dataRange = new DateRange();
                }
            }
            long timelineValue = this.timeline.toTimelineValue((long)dataRange.getUpperBound());
            final long n = (long)this.getFixedAutoRange();
            long n2;
            if (n > 0.0) {
                n2 = timelineValue - n;
            }
            else {
                long timelineValue2 = this.timeline.toTimelineValue((long)dataRange.getLowerBound());
                final double n3 = timelineValue - timelineValue2;
                final long n4 = (long)this.getAutoRangeMinimumSize();
                if (n3 < n4) {
                    final long n5 = (long)(n4 - n3) / 2L;
                    timelineValue += n5;
                    timelineValue2 -= n5;
                }
                timelineValue += (long)(n3 * this.getUpperMargin());
                n2 = timelineValue2 - (long)(n3 * this.getLowerMargin());
            }
            this.setRange(new DateRange(new Date(this.timeline.toMillisecond(n2)), new Date(this.timeline.toMillisecond(timelineValue))), false, false);
        }
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
        long startTime = 0L;
        if (this.timeline instanceof SegmentedTimeline) {
            startTime = ((SegmentedTimeline)this.timeline).getStartTime();
        }
        final double valueToJava2D = this.valueToJava2D(startTime + 0.0, rectangle2D, rectangleEdge);
        final double estimateMaximumTickLabelWidth = this.estimateMaximumTickLabelWidth(graphics2D, this.getTickUnit());
        final TickUnitSource standardTickUnits = this.getStandardTickUnits();
        final TickUnit ceilingTickUnit = standardTickUnits.getCeilingTickUnit(this.getTickUnit());
        DateTickUnit dateTickUnit = (DateTickUnit)standardTickUnits.getCeilingTickUnit(estimateMaximumTickLabelWidth / Math.abs(this.valueToJava2D(startTime + ceilingTickUnit.getSize(), rectangle2D, rectangleEdge) - valueToJava2D) * ceilingTickUnit.getSize());
        if (this.estimateMaximumTickLabelWidth(graphics2D, dateTickUnit) > Math.abs(this.valueToJava2D(startTime + dateTickUnit.getSize(), rectangle2D, rectangleEdge) - valueToJava2D)) {
            dateTickUnit = (DateTickUnit)standardTickUnits.getLargerTickUnit(dateTickUnit);
        }
        this.setTickUnit(dateTickUnit, false, false);
    }
    
    protected void selectVerticalAutoTickUnit(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final TickUnitSource standardTickUnits = this.getStandardTickUnits();
        final double valueToJava2D = this.valueToJava2D(0.0, rectangle2D, rectangleEdge);
        final DateTickUnit dateTickUnit = (DateTickUnit)standardTickUnits.getCeilingTickUnit(this.getRange().getLength() / 10.0);
        final DateTickUnit dateTickUnit2 = (DateTickUnit)standardTickUnits.getCeilingTickUnit(this.estimateMaximumTickLabelHeight(graphics2D, dateTickUnit) / Math.abs(this.valueToJava2D(dateTickUnit.getSize(), rectangle2D, rectangleEdge) - valueToJava2D) * dateTickUnit.getSize());
        DateTickUnit dateTickUnit3;
        if (this.estimateMaximumTickLabelHeight(graphics2D, dateTickUnit2) < Math.abs(this.valueToJava2D(dateTickUnit2.getSize(), rectangle2D, rectangleEdge) - valueToJava2D)) {
            dateTickUnit3 = dateTickUnit2;
        }
        else {
            dateTickUnit3 = (DateTickUnit)standardTickUnits.getLargerTickUnit(dateTickUnit2);
        }
        this.setTickUnit(dateTickUnit3, false, false);
    }
    
    private double estimateMaximumTickLabelWidth(final Graphics2D graphics2D, final DateTickUnit dateTickUnit) {
        final RectangleInsets tickLabelInsets = this.getTickLabelInsets();
        final double n = tickLabelInsets.getLeft() + tickLabelInsets.getRight();
        final Font tickLabelFont = this.getTickLabelFont();
        final LineMetrics lineMetrics = tickLabelFont.getLineMetrics("ABCxyz", graphics2D.getFontRenderContext());
        double n2;
        if (this.isVerticalTickLabels()) {
            n2 = n + lineMetrics.getHeight();
        }
        else {
            final DateRange dateRange = (DateRange)this.getRange();
            final Date lowerDate = dateRange.getLowerDate();
            final Date upperDate = dateRange.getUpperDate();
            final DateFormat dateFormatOverride = this.getDateFormatOverride();
            String s;
            String s2;
            if (dateFormatOverride != null) {
                s = dateFormatOverride.format(lowerDate);
                s2 = dateFormatOverride.format(upperDate);
            }
            else {
                s = dateTickUnit.dateToString(lowerDate);
                s2 = dateTickUnit.dateToString(upperDate);
            }
            final FontMetrics fontMetrics = graphics2D.getFontMetrics(tickLabelFont);
            n2 = n + Math.max(fontMetrics.stringWidth(s), (double)fontMetrics.stringWidth(s2));
        }
        return n2;
    }
    
    private double estimateMaximumTickLabelHeight(final Graphics2D graphics2D, final DateTickUnit dateTickUnit) {
        final RectangleInsets tickLabelInsets = this.getTickLabelInsets();
        final double n = tickLabelInsets.getTop() + tickLabelInsets.getBottom();
        final Font tickLabelFont = this.getTickLabelFont();
        final LineMetrics lineMetrics = tickLabelFont.getLineMetrics("ABCxyz", graphics2D.getFontRenderContext());
        double n2;
        if (!this.isVerticalTickLabels()) {
            n2 = n + lineMetrics.getHeight();
        }
        else {
            final DateRange dateRange = (DateRange)this.getRange();
            final Date lowerDate = dateRange.getLowerDate();
            final Date upperDate = dateRange.getUpperDate();
            final DateFormat dateFormatOverride = this.getDateFormatOverride();
            String s;
            String s2;
            if (dateFormatOverride != null) {
                s = dateFormatOverride.format(lowerDate);
                s2 = dateFormatOverride.format(upperDate);
            }
            else {
                s = dateTickUnit.dateToString(lowerDate);
                s2 = dateTickUnit.dateToString(upperDate);
            }
            final FontMetrics fontMetrics = graphics2D.getFontMetrics(tickLabelFont);
            n2 = n + Math.max(fontMetrics.stringWidth(s), (double)fontMetrics.stringWidth(s2));
        }
        return n2;
    }
    
    public List refreshTicks(final Graphics2D graphics2D, final AxisState axisState, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        List list = null;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            list = this.refreshTicksHorizontal(graphics2D, rectangle2D, rectangleEdge);
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            list = this.refreshTicksVertical(graphics2D, rectangle2D, rectangleEdge);
        }
        return list;
    }
    
    protected List refreshTicksHorizontal(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final ArrayList<DateTick> list = new ArrayList<DateTick>();
        graphics2D.setFont(this.getTickLabelFont());
        if (this.isAutoTickUnitSelection()) {
            this.selectAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
        }
        final DateTickUnit tickUnit = this.getTickUnit();
        Date date = this.calculateLowestVisibleTickValue(tickUnit);
        while (date.before(this.getMaximumDate())) {
            if (!this.isHiddenValue(date.getTime())) {
                final DateFormat dateFormatOverride = this.getDateFormatOverride();
                String s;
                if (dateFormatOverride != null) {
                    s = dateFormatOverride.format(date);
                }
                else {
                    s = this.tickUnit.dateToString(date);
                }
                double n = 0.0;
                TextAnchor textAnchor;
                TextAnchor textAnchor2;
                if (this.isVerticalTickLabels()) {
                    textAnchor = TextAnchor.CENTER_RIGHT;
                    textAnchor2 = TextAnchor.CENTER_RIGHT;
                    if (rectangleEdge == RectangleEdge.TOP) {
                        n = 1.5707963267948966;
                    }
                    else {
                        n = -1.5707963267948966;
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
                list.add(new DateTick(date, s, textAnchor, textAnchor2, n));
                date = tickUnit.addToDate(date);
                switch (tickUnit.getUnit()) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6: {
                        continue;
                    }
                    case 1: {
                        date = this.calculateDateForPosition(new Month(date), this.tickMarkPosition);
                        continue;
                    }
                    case 0: {
                        date = this.calculateDateForPosition(new Year(date), this.tickMarkPosition);
                        continue;
                    }
                    default: {
                        continue;
                    }
                }
            }
            else {
                date = tickUnit.rollDate(date);
            }
        }
        return list;
    }
    
    protected List refreshTicksVertical(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final ArrayList<DateTick> list = new ArrayList<DateTick>();
        graphics2D.setFont(this.getTickLabelFont());
        if (this.isAutoTickUnitSelection()) {
            this.selectAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
        }
        final DateTickUnit tickUnit = this.getTickUnit();
        Date date = this.calculateLowestVisibleTickValue(tickUnit);
        while (date.before(this.getMaximumDate())) {
            if (!this.isHiddenValue(date.getTime())) {
                final DateFormat dateFormatOverride = this.getDateFormatOverride();
                String s;
                if (dateFormatOverride != null) {
                    s = dateFormatOverride.format(date);
                }
                else {
                    s = this.tickUnit.dateToString(date);
                }
                double n = 0.0;
                TextAnchor textAnchor;
                TextAnchor textAnchor2;
                if (this.isVerticalTickLabels()) {
                    textAnchor = TextAnchor.BOTTOM_CENTER;
                    textAnchor2 = TextAnchor.BOTTOM_CENTER;
                    if (rectangleEdge == RectangleEdge.LEFT) {
                        n = -1.5707963267948966;
                    }
                    else {
                        n = 1.5707963267948966;
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
                list.add(new DateTick(date, s, textAnchor, textAnchor2, n));
                date = tickUnit.addToDate(date);
            }
            else {
                date = tickUnit.rollDate(date);
            }
        }
        return list;
    }
    
    public AxisState draw(final Graphics2D graphics2D, final double n, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge, final PlotRenderingInfo plotRenderingInfo) {
        if (!this.isVisible()) {
            final AxisState axisState = new AxisState(n);
            axisState.setTicks(this.refreshTicks(graphics2D, axisState, rectangle2D2, rectangleEdge));
            return axisState;
        }
        return this.drawLabel(this.getLabel(), graphics2D, rectangle2D, rectangle2D2, rectangleEdge, this.drawTickMarksAndLabels(graphics2D, n, rectangle2D, rectangle2D2, rectangleEdge));
    }
    
    public void zoomRange(final double n, final double n2) {
        final double n3 = this.timeline.toTimelineValue((long)this.getRange().getLowerBound());
        final double n4 = this.timeline.toTimelineValue((long)this.getRange().getUpperBound()) - this.timeline.toTimelineValue((long)this.getRange().getLowerBound());
        DateRange range;
        if (this.isInverted()) {
            range = new DateRange(this.timeline.toMillisecond((long)(n3 + n4 * (1.0 - n2))), this.timeline.toMillisecond((long)(n3 + n4 * (1.0 - n))));
        }
        else {
            range = new DateRange(this.timeline.toMillisecond((long)(n3 + n4 * n)), this.timeline.toMillisecond((long)(n3 + n4 * n2)));
        }
        this.setRange(range);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DateAxis)) {
            return false;
        }
        final DateAxis dateAxis = (DateAxis)o;
        return ObjectUtilities.equal(this.tickUnit, dateAxis.tickUnit) && ObjectUtilities.equal(this.dateFormatOverride, dateAxis.dateFormatOverride) && ObjectUtilities.equal(this.tickMarkPosition, dateAxis.tickMarkPosition) && ObjectUtilities.equal(this.timeline, dateAxis.timeline) && super.equals(o);
    }
    
    public int hashCode() {
        if (this.getLabel() != null) {
            return this.getLabel().hashCode();
        }
        return 0;
    }
    
    public Object clone() {
        final DateAxis dateAxis = (DateAxis)super.clone();
        if (this.dateFormatOverride != null) {
            dateAxis.dateFormatOverride = (DateFormat)this.dateFormatOverride.clone();
        }
        return dateAxis;
    }
    
    static {
        DEFAULT_DATE_RANGE = new DateRange();
        DEFAULT_DATE_TICK_UNIT = new DateTickUnit(2, 1, new SimpleDateFormat());
        DEFAULT_ANCHOR_DATE = new Date();
        DEFAULT_TIMELINE = new DateAxis$DefaultTimeline(null);
    }
}
