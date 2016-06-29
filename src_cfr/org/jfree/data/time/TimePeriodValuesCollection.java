/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.TimePeriodValue;
import org.jfree.data.time.TimePeriodValues;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.util.ObjectUtilities;

public class TimePeriodValuesCollection
extends AbstractIntervalXYDataset
implements Serializable,
DomainInfo,
IntervalXYDataset {
    private static final long serialVersionUID = -3077934065236454199L;
    private List data = new ArrayList();
    private TimePeriodAnchor xPosition = TimePeriodAnchor.MIDDLE;
    private boolean domainIsPointsInTime = true;

    public TimePeriodValuesCollection() {
        this(null);
    }

    public TimePeriodValuesCollection(TimePeriodValues timePeriodValues) {
        if (timePeriodValues == null) return;
        this.data.add(timePeriodValues);
        timePeriodValues.addChangeListener(this);
    }

    public TimePeriodAnchor getXPosition() {
        return this.xPosition;
    }

    public void setXPosition(TimePeriodAnchor timePeriodAnchor) {
        if (timePeriodAnchor == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        this.xPosition = timePeriodAnchor;
    }

    public boolean getDomainIsPointsInTime() {
        return this.domainIsPointsInTime;
    }

    public void setDomainIsPointsInTime(boolean bl2) {
        this.domainIsPointsInTime = bl2;
    }

    @Override
    public int getSeriesCount() {
        return this.data.size();
    }

    public TimePeriodValues getSeries(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Index 'series' out of range.");
        if (n2 < this.getSeriesCount()) return (TimePeriodValues)this.data.get(n2);
        throw new IllegalArgumentException("Index 'series' out of range.");
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.getSeries(n2).getKey();
    }

    public void addSeries(TimePeriodValues timePeriodValues) {
        if (timePeriodValues == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(timePeriodValues);
        timePeriodValues.addChangeListener(this);
        this.fireDatasetChanged();
    }

    public void removeSeries(TimePeriodValues timePeriodValues) {
        if (timePeriodValues == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.remove(timePeriodValues);
        timePeriodValues.removeChangeListener(this);
        this.fireDatasetChanged();
    }

    public void removeSeries(int n2) {
        TimePeriodValues timePeriodValues = this.getSeries(n2);
        if (timePeriodValues == null) return;
        this.removeSeries(timePeriodValues);
    }

    @Override
    public int getItemCount(int n2) {
        return this.getSeries(n2).getItemCount();
    }

    @Override
    public Number getX(int n2, int n3) {
        TimePeriodValues timePeriodValues = (TimePeriodValues)this.data.get(n2);
        TimePeriodValue timePeriodValue = timePeriodValues.getDataItem(n3);
        TimePeriod timePeriod = timePeriodValue.getPeriod();
        return new Long(this.getX(timePeriod));
    }

    private long getX(TimePeriod timePeriod) {
        if (this.xPosition == TimePeriodAnchor.START) {
            return timePeriod.getStart().getTime();
        }
        if (this.xPosition == TimePeriodAnchor.MIDDLE) {
            return timePeriod.getStart().getTime() / 2 + timePeriod.getEnd().getTime() / 2;
        }
        if (this.xPosition != TimePeriodAnchor.END) throw new IllegalStateException("TimePeriodAnchor unknown.");
        return timePeriod.getEnd().getTime();
    }

    @Override
    public Number getStartX(int n2, int n3) {
        TimePeriodValues timePeriodValues = (TimePeriodValues)this.data.get(n2);
        TimePeriodValue timePeriodValue = timePeriodValues.getDataItem(n3);
        return new Long(timePeriodValue.getPeriod().getStart().getTime());
    }

    @Override
    public Number getEndX(int n2, int n3) {
        TimePeriodValues timePeriodValues = (TimePeriodValues)this.data.get(n2);
        TimePeriodValue timePeriodValue = timePeriodValues.getDataItem(n3);
        return new Long(timePeriodValue.getPeriod().getEnd().getTime());
    }

    @Override
    public Number getY(int n2, int n3) {
        TimePeriodValues timePeriodValues = (TimePeriodValues)this.data.get(n2);
        TimePeriodValue timePeriodValue = timePeriodValues.getDataItem(n3);
        return timePeriodValue.getValue();
    }

    @Override
    public Number getStartY(int n2, int n3) {
        return this.getY(n2, n3);
    }

    @Override
    public Number getEndY(int n2, int n3) {
        return this.getY(n2, n3);
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
        Range range2 = null;
        Iterator iterator = this.data.iterator();
        while (iterator.hasNext()) {
            TimePeriodValues timePeriodValues = (TimePeriodValues)iterator.next();
            int n2 = timePeriodValues.getItemCount();
            if (n2 <= 0) continue;
            TimePeriod timePeriod = timePeriodValues.getTimePeriod(timePeriodValues.getMinStartIndex());
            TimePeriod timePeriod2 = timePeriodValues.getTimePeriod(timePeriodValues.getMaxEndIndex());
            if (this.domainIsPointsInTime) {
                TimePeriod timePeriod3;
                if (this.xPosition == TimePeriodAnchor.START) {
                    timePeriod3 = timePeriodValues.getTimePeriod(timePeriodValues.getMaxStartIndex());
                    range2 = new Range(timePeriod.getStart().getTime(), timePeriod3.getStart().getTime());
                } else if (this.xPosition == TimePeriodAnchor.MIDDLE) {
                    timePeriod3 = timePeriodValues.getTimePeriod(timePeriodValues.getMinMiddleIndex());
                    long l2 = timePeriod3.getStart().getTime();
                    long l3 = timePeriod3.getEnd().getTime();
                    TimePeriod timePeriod4 = timePeriodValues.getTimePeriod(timePeriodValues.getMaxMiddleIndex());
                    long l4 = timePeriod4.getStart().getTime();
                    long l5 = timePeriod4.getEnd().getTime();
                    range2 = new Range(l2 + (l3 - l2) / 2, l4 + (l5 - l4) / 2);
                } else if (this.xPosition == TimePeriodAnchor.END) {
                    timePeriod3 = timePeriodValues.getTimePeriod(timePeriodValues.getMinEndIndex());
                    range2 = new Range(timePeriod3.getEnd().getTime(), timePeriod2.getEnd().getTime());
                }
            } else {
                range2 = new Range(timePeriod.getStart().getTime(), timePeriod2.getEnd().getTime());
            }
            range = Range.combine(range, range2);
        }
        return range;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TimePeriodValuesCollection)) {
            return false;
        }
        TimePeriodValuesCollection timePeriodValuesCollection = (TimePeriodValuesCollection)object;
        if (this.domainIsPointsInTime != timePeriodValuesCollection.domainIsPointsInTime) {
            return false;
        }
        if (this.xPosition != timePeriodValuesCollection.xPosition) {
            return false;
        }
        if (ObjectUtilities.equal(this.data, timePeriodValuesCollection.data)) return true;
        return false;
    }
}

