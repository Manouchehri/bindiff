package org.jfree.data.time;

import org.jfree.data.xy.*;
import org.jfree.util.*;
import org.jfree.data.general.*;
import org.jfree.data.*;
import java.util.*;

public class TimeTableXYDataset extends AbstractIntervalXYDataset implements Cloneable, DomainInfo, IntervalXYDataset, TableXYDataset, PublicCloneable
{
    private DefaultKeyedValues2D values;
    private boolean domainIsPointsInTime;
    private TimePeriodAnchor xPosition;
    private Calendar workingCalendar;
    
    public TimeTableXYDataset() {
        this(TimeZone.getDefault(), Locale.getDefault());
    }
    
    public TimeTableXYDataset(final TimeZone timeZone) {
        this(timeZone, Locale.getDefault());
    }
    
    public TimeTableXYDataset(final TimeZone timeZone, final Locale locale) {
        if (timeZone == null) {
            throw new IllegalArgumentException("Null 'zone' argument.");
        }
        if (locale == null) {
            throw new IllegalArgumentException("Null 'locale' argument.");
        }
        this.values = new DefaultKeyedValues2D(true);
        this.workingCalendar = Calendar.getInstance(timeZone, locale);
        this.xPosition = TimePeriodAnchor.START;
    }
    
    public boolean getDomainIsPointsInTime() {
        return this.domainIsPointsInTime;
    }
    
    public void setDomainIsPointsInTime(final boolean domainIsPointsInTime) {
        this.domainIsPointsInTime = domainIsPointsInTime;
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }
    
    public TimePeriodAnchor getXPosition() {
        return this.xPosition;
    }
    
    public void setXPosition(final TimePeriodAnchor xPosition) {
        if (xPosition == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.xPosition = xPosition;
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }
    
    public void add(final TimePeriod timePeriod, final double n, final String s) {
        this.add(timePeriod, new Double(n), s, true);
    }
    
    public void add(final TimePeriod timePeriod, final Number n, final String s, final boolean b) {
        this.values.addValue(n, timePeriod, s);
        if (b) {
            this.fireDatasetChanged();
        }
    }
    
    public void remove(final TimePeriod timePeriod, final String s) {
        this.remove(timePeriod, s, true);
    }
    
    public void remove(final TimePeriod timePeriod, final String s, final boolean b) {
        this.values.removeValue(timePeriod, s);
        if (b) {
            this.fireDatasetChanged();
        }
    }
    
    public TimePeriod getTimePeriod(final int n) {
        return (TimePeriod)this.values.getRowKey(n);
    }
    
    public int getItemCount() {
        return this.values.getRowCount();
    }
    
    public int getItemCount(final int n) {
        return this.getItemCount();
    }
    
    public int getSeriesCount() {
        return this.values.getColumnCount();
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.values.getColumnKey(n);
    }
    
    public Number getX(final int n, final int n2) {
        return new Double(this.getXValue(n, n2));
    }
    
    public double getXValue(final int n, final int n2) {
        return this.getXValue((TimePeriod)this.values.getRowKey(n2));
    }
    
    public Number getStartX(final int n, final int n2) {
        return new Double(this.getStartXValue(n, n2));
    }
    
    public double getStartXValue(final int n, final int n2) {
        return ((TimePeriod)this.values.getRowKey(n2)).getStart().getTime();
    }
    
    public Number getEndX(final int n, final int n2) {
        return new Double(this.getEndXValue(n, n2));
    }
    
    public double getEndXValue(final int n, final int n2) {
        return ((TimePeriod)this.values.getRowKey(n2)).getEnd().getTime();
    }
    
    public Number getY(final int n, final int n2) {
        return this.values.getValue(n2, n);
    }
    
    public Number getStartY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public Number getEndY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    private long getXValue(final TimePeriod timePeriod) {
        long n = 0L;
        if (this.xPosition == TimePeriodAnchor.START) {
            n = timePeriod.getStart().getTime();
        }
        else if (this.xPosition == TimePeriodAnchor.MIDDLE) {
            final long time = timePeriod.getStart().getTime();
            n = time + (timePeriod.getEnd().getTime() - time) / 2L;
        }
        else if (this.xPosition == TimePeriodAnchor.END) {
            n = timePeriod.getEnd().getTime();
        }
        return n;
    }
    
    public double getDomainLowerBound(final boolean b) {
        double lowerBound = Double.NaN;
        final Range domainBounds = this.getDomainBounds(b);
        if (domainBounds != null) {
            lowerBound = domainBounds.getLowerBound();
        }
        return lowerBound;
    }
    
    public double getDomainUpperBound(final boolean b) {
        double upperBound = Double.NaN;
        final Range domainBounds = this.getDomainBounds(b);
        if (domainBounds != null) {
            upperBound = domainBounds.getUpperBound();
        }
        return upperBound;
    }
    
    public Range getDomainBounds(final boolean b) {
        final List rowKeys = this.values.getRowKeys();
        if (rowKeys.isEmpty()) {
            return null;
        }
        final TimePeriod timePeriod = rowKeys.get(0);
        final TimePeriod timePeriod2 = rowKeys.get(rowKeys.size() - 1);
        if (!b || this.domainIsPointsInTime) {
            return new Range(this.getXValue(timePeriod), this.getXValue(timePeriod2));
        }
        return new Range(timePeriod.getStart().getTime(), timePeriod2.getEnd().getTime());
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TimeTableXYDataset)) {
            return false;
        }
        final TimeTableXYDataset timeTableXYDataset = (TimeTableXYDataset)o;
        return this.domainIsPointsInTime == timeTableXYDataset.domainIsPointsInTime && this.xPosition == timeTableXYDataset.xPosition && this.workingCalendar.getTimeZone().equals(timeTableXYDataset.workingCalendar.getTimeZone()) && this.values.equals(timeTableXYDataset.values);
    }
    
    public Object clone() {
        final TimeTableXYDataset timeTableXYDataset = (TimeTableXYDataset)super.clone();
        timeTableXYDataset.values = (DefaultKeyedValues2D)this.values.clone();
        timeTableXYDataset.workingCalendar = (Calendar)this.workingCalendar.clone();
        return timeTableXYDataset;
    }
}
