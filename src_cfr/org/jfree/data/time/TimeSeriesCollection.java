/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesDataItem;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.ObjectUtilities;

public class TimeSeriesCollection
extends AbstractIntervalXYDataset
implements Serializable,
DomainInfo,
IntervalXYDataset,
XYDataset {
    private static final long serialVersionUID = 834149929022371137L;
    private List data;
    private Calendar workingCalendar;
    private TimePeriodAnchor xPosition;
    private boolean domainIsPointsInTime;

    public TimeSeriesCollection() {
        this(null, TimeZone.getDefault());
    }

    public TimeSeriesCollection(TimeZone timeZone) {
        this(null, timeZone);
    }

    public TimeSeriesCollection(TimeSeries timeSeries) {
        this(timeSeries, TimeZone.getDefault());
    }

    public TimeSeriesCollection(TimeSeries timeSeries, TimeZone timeZone) {
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        this.workingCalendar = Calendar.getInstance(timeZone);
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

    public void setDomainIsPointsInTime(boolean bl2) {
        this.domainIsPointsInTime = bl2;
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }

    public TimePeriodAnchor getXPosition() {
        return this.xPosition;
    }

    public void setXPosition(TimePeriodAnchor timePeriodAnchor) {
        if (timePeriodAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.xPosition = timePeriodAnchor;
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }

    public List getSeries() {
        return Collections.unmodifiableList(this.data);
    }

    @Override
    public int getSeriesCount() {
        return this.data.size();
    }

    public TimeSeries getSeries(int n2) {
        if (n2 < 0) throw new IllegalArgumentException(new StringBuffer().append("The 'series' argument is out of bounds (").append(n2).append(").").toString());
        if (n2 < this.getSeriesCount()) return (TimeSeries)this.data.get(n2);
        throw new IllegalArgumentException(new StringBuffer().append("The 'series' argument is out of bounds (").append(n2).append(").").toString());
    }

    public TimeSeries getSeries(String string) {
        TimeSeries timeSeries = null;
        Iterator iterator = this.data.iterator();
        while (iterator.hasNext()) {
            TimeSeries timeSeries2 = (TimeSeries)iterator.next();
            Comparable comparable = timeSeries2.getKey();
            if (comparable == null || !comparable.equals(string)) continue;
            timeSeries = timeSeries2;
        }
        return timeSeries;
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.getSeries(n2).getKey();
    }

    public void addSeries(TimeSeries timeSeries) {
        if (timeSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(timeSeries);
        timeSeries.addChangeListener(this);
        this.fireDatasetChanged();
    }

    public void removeSeries(TimeSeries timeSeries) {
        if (timeSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.remove(timeSeries);
        timeSeries.removeChangeListener(this);
        this.fireDatasetChanged();
    }

    public void removeSeries(int n2) {
        TimeSeries timeSeries = this.getSeries(n2);
        if (timeSeries == null) return;
        this.removeSeries(timeSeries);
    }

    public void removeAllSeries() {
        int n2 = 0;
        do {
            if (n2 >= this.data.size()) {
                this.data.clear();
                this.fireDatasetChanged();
                return;
            }
            TimeSeries timeSeries = (TimeSeries)this.data.get(n2);
            timeSeries.removeChangeListener(this);
            ++n2;
        } while (true);
    }

    @Override
    public int getItemCount(int n2) {
        return this.getSeries(n2).getItemCount();
    }

    @Override
    public double getXValue(int n2, int n3) {
        TimeSeries timeSeries = (TimeSeries)this.data.get(n2);
        TimeSeriesDataItem timeSeriesDataItem = timeSeries.getDataItem(n3);
        RegularTimePeriod regularTimePeriod = timeSeriesDataItem.getPeriod();
        return this.getX(regularTimePeriod);
    }

    @Override
    public Number getX(int n2, int n3) {
        TimeSeries timeSeries = (TimeSeries)this.data.get(n2);
        TimeSeriesDataItem timeSeriesDataItem = timeSeries.getDataItem(n3);
        RegularTimePeriod regularTimePeriod = timeSeriesDataItem.getPeriod();
        return new Long(this.getX(regularTimePeriod));
    }

    protected synchronized long getX(RegularTimePeriod regularTimePeriod) {
        long l2 = 0;
        if (this.xPosition == TimePeriodAnchor.START) {
            return regularTimePeriod.getFirstMillisecond(this.workingCalendar);
        }
        if (this.xPosition == TimePeriodAnchor.MIDDLE) {
            return regularTimePeriod.getMiddleMillisecond(this.workingCalendar);
        }
        if (this.xPosition != TimePeriodAnchor.END) return l2;
        return regularTimePeriod.getLastMillisecond(this.workingCalendar);
    }

    @Override
    public synchronized Number getStartX(int n2, int n3) {
        TimeSeries timeSeries = (TimeSeries)this.data.get(n2);
        TimeSeriesDataItem timeSeriesDataItem = timeSeries.getDataItem(n3);
        return new Long(timeSeriesDataItem.getPeriod().getFirstMillisecond(this.workingCalendar));
    }

    @Override
    public synchronized Number getEndX(int n2, int n3) {
        TimeSeries timeSeries = (TimeSeries)this.data.get(n2);
        TimeSeriesDataItem timeSeriesDataItem = timeSeries.getDataItem(n3);
        return new Long(timeSeriesDataItem.getPeriod().getLastMillisecond(this.workingCalendar));
    }

    @Override
    public Number getY(int n2, int n3) {
        TimeSeries timeSeries = (TimeSeries)this.data.get(n2);
        TimeSeriesDataItem timeSeriesDataItem = timeSeries.getDataItem(n3);
        return timeSeriesDataItem.getValue();
    }

    @Override
    public Number getStartY(int n2, int n3) {
        return this.getY(n2, n3);
    }

    @Override
    public Number getEndY(int n2, int n3) {
        return this.getY(n2, n3);
    }

    public int[] getSurroundingItems(int n2, long l2) {
        int[] arrn = new int[]{-1, -1};
        TimeSeries timeSeries = this.getSeries(n2);
        int n3 = 0;
        while (n3 < timeSeries.getItemCount()) {
            Number number = this.getX(n2, n3);
            long l3 = number.longValue();
            if (l3 <= l2) {
                arrn[0] = n3;
            }
            if (l3 >= l2) {
                arrn[1] = n3;
                return arrn;
            }
            ++n3;
        }
        return arrn;
    }

    @Override
    public double getDomainLowerBound(boolean bl2) {
        double d2 = Double.NaN;
        Range range = this.getDomainBounds(bl2);
        if (range == null) return d2;
        return range.getLowerBound();
    }

    @Override
    public double getDomainUpperBound(boolean bl2) {
        double d2 = Double.NaN;
        Range range = this.getDomainBounds(bl2);
        if (range == null) return d2;
        return range.getUpperBound();
    }

    @Override
    public Range getDomainBounds(boolean bl2) {
        Range range = null;
        Iterator iterator = this.data.iterator();
        while (iterator.hasNext()) {
            TimeSeries timeSeries = (TimeSeries)iterator.next();
            int n2 = timeSeries.getItemCount();
            if (n2 <= 0) continue;
            RegularTimePeriod regularTimePeriod = timeSeries.getTimePeriod(0);
            RegularTimePeriod regularTimePeriod2 = timeSeries.getTimePeriod(n2 - 1);
            Range range2 = !bl2 ? new Range(this.getX(regularTimePeriod), this.getX(regularTimePeriod2)) : new Range(regularTimePeriod.getFirstMillisecond(this.workingCalendar), regularTimePeriod2.getLastMillisecond(this.workingCalendar));
            range = Range.combine(range, range2);
        }
        return range;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TimeSeriesCollection)) {
            return false;
        }
        TimeSeriesCollection timeSeriesCollection = (TimeSeriesCollection)object;
        if (this.xPosition != timeSeriesCollection.xPosition) {
            return false;
        }
        if (this.domainIsPointsInTime != timeSeriesCollection.domainIsPointsInTime) {
            return false;
        }
        if (ObjectUtilities.equal(this.data, timeSeriesCollection.data)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.data.hashCode();
        n2 = 29 * n2 + (this.workingCalendar != null ? this.workingCalendar.hashCode() : 0);
        n2 = 29 * n2 + (this.xPosition != null ? this.xPosition.hashCode() : 0);
        return 29 * n2 + (this.domainIsPointsInTime ? 1 : 0);
    }
}

