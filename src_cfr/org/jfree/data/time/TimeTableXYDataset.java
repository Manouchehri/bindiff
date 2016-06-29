/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.util.PublicCloneable;

public class TimeTableXYDataset
extends AbstractIntervalXYDataset
implements Cloneable,
DomainInfo,
IntervalXYDataset,
TableXYDataset,
PublicCloneable {
    private DefaultKeyedValues2D values;
    private boolean domainIsPointsInTime;
    private TimePeriodAnchor xPosition;
    private Calendar workingCalendar;

    public TimeTableXYDataset() {
        this(TimeZone.getDefault(), Locale.getDefault());
    }

    public TimeTableXYDataset(TimeZone timeZone) {
        this(timeZone, Locale.getDefault());
    }

    public TimeTableXYDataset(TimeZone timeZone, Locale locale) {
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

    public void add(TimePeriod timePeriod, double d2, String string) {
        this.add(timePeriod, new Double(d2), string, true);
    }

    public void add(TimePeriod timePeriod, Number number, String string, boolean bl2) {
        this.values.addValue(number, timePeriod, (Comparable)((Object)string));
        if (!bl2) return;
        this.fireDatasetChanged();
    }

    public void remove(TimePeriod timePeriod, String string) {
        this.remove(timePeriod, string, true);
    }

    public void remove(TimePeriod timePeriod, String string, boolean bl2) {
        this.values.removeValue(timePeriod, (Comparable)((Object)string));
        if (!bl2) return;
        this.fireDatasetChanged();
    }

    public TimePeriod getTimePeriod(int n2) {
        return (TimePeriod)this.values.getRowKey(n2);
    }

    @Override
    public int getItemCount() {
        return this.values.getRowCount();
    }

    @Override
    public int getItemCount(int n2) {
        return this.getItemCount();
    }

    @Override
    public int getSeriesCount() {
        return this.values.getColumnCount();
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.values.getColumnKey(n2);
    }

    @Override
    public Number getX(int n2, int n3) {
        return new Double(this.getXValue(n2, n3));
    }

    @Override
    public double getXValue(int n2, int n3) {
        TimePeriod timePeriod = (TimePeriod)this.values.getRowKey(n3);
        return this.getXValue(timePeriod);
    }

    @Override
    public Number getStartX(int n2, int n3) {
        return new Double(this.getStartXValue(n2, n3));
    }

    @Override
    public double getStartXValue(int n2, int n3) {
        TimePeriod timePeriod = (TimePeriod)this.values.getRowKey(n3);
        return timePeriod.getStart().getTime();
    }

    @Override
    public Number getEndX(int n2, int n3) {
        return new Double(this.getEndXValue(n2, n3));
    }

    @Override
    public double getEndXValue(int n2, int n3) {
        TimePeriod timePeriod = (TimePeriod)this.values.getRowKey(n3);
        return timePeriod.getEnd().getTime();
    }

    @Override
    public Number getY(int n2, int n3) {
        return this.values.getValue(n3, n2);
    }

    @Override
    public Number getStartY(int n2, int n3) {
        return this.getY(n2, n3);
    }

    @Override
    public Number getEndY(int n2, int n3) {
        return this.getY(n2, n3);
    }

    private long getXValue(TimePeriod timePeriod) {
        long l2 = 0;
        if (this.xPosition == TimePeriodAnchor.START) {
            return timePeriod.getStart().getTime();
        }
        if (this.xPosition == TimePeriodAnchor.MIDDLE) {
            long l3 = timePeriod.getStart().getTime();
            long l4 = timePeriod.getEnd().getTime();
            return l3 + (l4 - l3) / 2;
        }
        if (this.xPosition != TimePeriodAnchor.END) return l2;
        return timePeriod.getEnd().getTime();
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
        List list = this.values.getRowKeys();
        if (list.isEmpty()) {
            return null;
        }
        TimePeriod timePeriod = (TimePeriod)list.get(0);
        TimePeriod timePeriod2 = (TimePeriod)list.get(list.size() - 1);
        if (!bl2) return new Range(this.getXValue(timePeriod), this.getXValue(timePeriod2));
        if (!this.domainIsPointsInTime) return new Range(timePeriod.getStart().getTime(), timePeriod2.getEnd().getTime());
        return new Range(this.getXValue(timePeriod), this.getXValue(timePeriod2));
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TimeTableXYDataset)) {
            return false;
        }
        TimeTableXYDataset timeTableXYDataset = (TimeTableXYDataset)object;
        if (this.domainIsPointsInTime != timeTableXYDataset.domainIsPointsInTime) {
            return false;
        }
        if (this.xPosition != timeTableXYDataset.xPosition) {
            return false;
        }
        if (!this.workingCalendar.getTimeZone().equals(timeTableXYDataset.workingCalendar.getTimeZone())) {
            return false;
        }
        if (this.values.equals(timeTableXYDataset.values)) return true;
        return false;
    }

    @Override
    public Object clone() {
        TimeTableXYDataset timeTableXYDataset = (TimeTableXYDataset)super.clone();
        timeTableXYDataset.values = (DefaultKeyedValues2D)this.values.clone();
        timeTableXYDataset.workingCalendar = (Calendar)this.workingCalendar.clone();
        return timeTableXYDataset;
    }
}

