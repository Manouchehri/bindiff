package org.jfree.data.time;

import java.io.*;
import org.jfree.data.xy.*;
import org.jfree.data.general.*;
import java.util.*;
import org.jfree.data.*;
import org.jfree.util.*;

public class TimeSeriesCollection extends AbstractIntervalXYDataset implements Serializable, DomainInfo, IntervalXYDataset, XYDataset
{
    private static final long serialVersionUID = 834149929022371137L;
    private List data;
    private Calendar workingCalendar;
    private TimePeriodAnchor xPosition;
    private boolean domainIsPointsInTime;
    
    public TimeSeriesCollection() {
        this(null, TimeZone.getDefault());
    }
    
    public TimeSeriesCollection(final TimeZone timeZone) {
        this(null, timeZone);
    }
    
    public TimeSeriesCollection(final TimeSeries timeSeries) {
        this(timeSeries, TimeZone.getDefault());
    }
    
    public TimeSeriesCollection(final TimeSeries timeSeries, TimeZone default1) {
        if (default1 == null) {
            default1 = TimeZone.getDefault();
        }
        this.workingCalendar = Calendar.getInstance(default1);
        this.data = new ArrayList();
        if (timeSeries != null) {
            this.data.add(timeSeries);
            timeSeries.addChangeListener(this);
        }
        this.xPosition = TimePeriodAnchor.START;
        this.domainIsPointsInTime = true;
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
    
    public List getSeries() {
        return Collections.unmodifiableList((List<?>)this.data);
    }
    
    public int getSeriesCount() {
        return this.data.size();
    }
    
    public TimeSeries getSeries(final int n) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("The 'series' argument is out of bounds (" + n + ").");
        }
        return this.data.get(n);
    }
    
    public TimeSeries getSeries(final String s) {
        TimeSeries timeSeries = null;
        for (final TimeSeries timeSeries2 : this.data) {
            final Comparable key = timeSeries2.getKey();
            if (key != null && key.equals(s)) {
                timeSeries = timeSeries2;
            }
        }
        return timeSeries;
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.getSeries(n).getKey();
    }
    
    public void addSeries(final TimeSeries timeSeries) {
        if (timeSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(timeSeries);
        timeSeries.addChangeListener(this);
        this.fireDatasetChanged();
    }
    
    public void removeSeries(final TimeSeries timeSeries) {
        if (timeSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.remove(timeSeries);
        timeSeries.removeChangeListener(this);
        this.fireDatasetChanged();
    }
    
    public void removeSeries(final int n) {
        final TimeSeries series = this.getSeries(n);
        if (series != null) {
            this.removeSeries(series);
        }
    }
    
    public void removeAllSeries() {
        for (int i = 0; i < this.data.size(); ++i) {
            ((TimeSeries)this.data.get(i)).removeChangeListener(this);
        }
        this.data.clear();
        this.fireDatasetChanged();
    }
    
    public int getItemCount(final int n) {
        return this.getSeries(n).getItemCount();
    }
    
    public double getXValue(final int n, final int n2) {
        return this.getX(this.data.get(n).getDataItem(n2).getPeriod());
    }
    
    public Number getX(final int n, final int n2) {
        return new Long(this.getX(this.data.get(n).getDataItem(n2).getPeriod()));
    }
    
    protected synchronized long getX(final RegularTimePeriod regularTimePeriod) {
        long n = 0L;
        if (this.xPosition == TimePeriodAnchor.START) {
            n = regularTimePeriod.getFirstMillisecond(this.workingCalendar);
        }
        else if (this.xPosition == TimePeriodAnchor.MIDDLE) {
            n = regularTimePeriod.getMiddleMillisecond(this.workingCalendar);
        }
        else if (this.xPosition == TimePeriodAnchor.END) {
            n = regularTimePeriod.getLastMillisecond(this.workingCalendar);
        }
        return n;
    }
    
    public synchronized Number getStartX(final int n, final int n2) {
        return new Long(this.data.get(n).getDataItem(n2).getPeriod().getFirstMillisecond(this.workingCalendar));
    }
    
    public synchronized Number getEndX(final int n, final int n2) {
        return new Long(this.data.get(n).getDataItem(n2).getPeriod().getLastMillisecond(this.workingCalendar));
    }
    
    public Number getY(final int n, final int n2) {
        return this.data.get(n).getDataItem(n2).getValue();
    }
    
    public Number getStartY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public Number getEndY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public int[] getSurroundingItems(final int n, final long n2) {
        final int[] array = { -1, -1 };
        final TimeSeries series = this.getSeries(n);
        for (int i = 0; i < series.getItemCount(); ++i) {
            final long longValue = this.getX(n, i).longValue();
            if (longValue <= n2) {
                array[0] = i;
            }
            if (longValue >= n2) {
                array[1] = i;
                break;
            }
        }
        return array;
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
        Range combine = null;
        for (final TimeSeries timeSeries : this.data) {
            final int itemCount = timeSeries.getItemCount();
            if (itemCount > 0) {
                final RegularTimePeriod timePeriod = timeSeries.getTimePeriod(0);
                final RegularTimePeriod timePeriod2 = timeSeries.getTimePeriod(itemCount - 1);
                Range range;
                if (!b) {
                    range = new Range(this.getX(timePeriod), this.getX(timePeriod2));
                }
                else {
                    range = new Range(timePeriod.getFirstMillisecond(this.workingCalendar), timePeriod2.getLastMillisecond(this.workingCalendar));
                }
                combine = Range.combine(combine, range);
            }
        }
        return combine;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TimeSeriesCollection)) {
            return false;
        }
        final TimeSeriesCollection collection = (TimeSeriesCollection)o;
        return this.xPosition == collection.xPosition && this.domainIsPointsInTime == collection.domainIsPointsInTime && ObjectUtilities.equal(this.data, collection.data);
    }
    
    public int hashCode() {
        return 29 * (29 * (29 * this.data.hashCode() + ((this.workingCalendar != null) ? this.workingCalendar.hashCode() : 0)) + ((this.xPosition != null) ? this.xPosition.hashCode() : 0)) + (this.domainIsPointsInTime ? 1 : 0);
    }
}
