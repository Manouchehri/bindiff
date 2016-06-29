package org.jfree.data.time;

import java.io.*;
import org.jfree.data.xy.*;
import org.jfree.data.general.*;
import org.jfree.data.*;
import java.util.*;
import org.jfree.util.*;

public class TimePeriodValuesCollection extends AbstractIntervalXYDataset implements Serializable, DomainInfo, IntervalXYDataset
{
    private static final long serialVersionUID = -3077934065236454199L;
    private List data;
    private TimePeriodAnchor xPosition;
    private boolean domainIsPointsInTime;
    
    public TimePeriodValuesCollection() {
        this(null);
    }
    
    public TimePeriodValuesCollection(final TimePeriodValues timePeriodValues) {
        this.data = new ArrayList();
        this.xPosition = TimePeriodAnchor.MIDDLE;
        this.domainIsPointsInTime = true;
        if (timePeriodValues != null) {
            this.data.add(timePeriodValues);
            timePeriodValues.addChangeListener(this);
        }
    }
    
    public TimePeriodAnchor getXPosition() {
        return this.xPosition;
    }
    
    public void setXPosition(final TimePeriodAnchor xPosition) {
        if (xPosition == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        this.xPosition = xPosition;
    }
    
    public boolean getDomainIsPointsInTime() {
        return this.domainIsPointsInTime;
    }
    
    public void setDomainIsPointsInTime(final boolean domainIsPointsInTime) {
        this.domainIsPointsInTime = domainIsPointsInTime;
    }
    
    public int getSeriesCount() {
        return this.data.size();
    }
    
    public TimePeriodValues getSeries(final int n) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("Index 'series' out of range.");
        }
        return this.data.get(n);
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.getSeries(n).getKey();
    }
    
    public void addSeries(final TimePeriodValues timePeriodValues) {
        if (timePeriodValues == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(timePeriodValues);
        timePeriodValues.addChangeListener(this);
        this.fireDatasetChanged();
    }
    
    public void removeSeries(final TimePeriodValues timePeriodValues) {
        if (timePeriodValues == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.remove(timePeriodValues);
        timePeriodValues.removeChangeListener(this);
        this.fireDatasetChanged();
    }
    
    public void removeSeries(final int n) {
        final TimePeriodValues series = this.getSeries(n);
        if (series != null) {
            this.removeSeries(series);
        }
    }
    
    public int getItemCount(final int n) {
        return this.getSeries(n).getItemCount();
    }
    
    public Number getX(final int n, final int n2) {
        return new Long(this.getX(this.data.get(n).getDataItem(n2).getPeriod()));
    }
    
    private long getX(final TimePeriod timePeriod) {
        if (this.xPosition == TimePeriodAnchor.START) {
            return timePeriod.getStart().getTime();
        }
        if (this.xPosition == TimePeriodAnchor.MIDDLE) {
            return timePeriod.getStart().getTime() / 2L + timePeriod.getEnd().getTime() / 2L;
        }
        if (this.xPosition == TimePeriodAnchor.END) {
            return timePeriod.getEnd().getTime();
        }
        throw new IllegalStateException("TimePeriodAnchor unknown.");
    }
    
    public Number getStartX(final int n, final int n2) {
        return new Long(this.data.get(n).getDataItem(n2).getPeriod().getStart().getTime());
    }
    
    public Number getEndX(final int n, final int n2) {
        return new Long(this.data.get(n).getDataItem(n2).getPeriod().getEnd().getTime());
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
        Range range = null;
        for (final TimePeriodValues timePeriodValues : this.data) {
            if (timePeriodValues.getItemCount() > 0) {
                final TimePeriod timePeriod = timePeriodValues.getTimePeriod(timePeriodValues.getMinStartIndex());
                final TimePeriod timePeriod2 = timePeriodValues.getTimePeriod(timePeriodValues.getMaxEndIndex());
                if (this.domainIsPointsInTime) {
                    if (this.xPosition == TimePeriodAnchor.START) {
                        range = new Range(timePeriod.getStart().getTime(), timePeriodValues.getTimePeriod(timePeriodValues.getMaxStartIndex()).getStart().getTime());
                    }
                    else if (this.xPosition == TimePeriodAnchor.MIDDLE) {
                        final TimePeriod timePeriod3 = timePeriodValues.getTimePeriod(timePeriodValues.getMinMiddleIndex());
                        final long time = timePeriod3.getStart().getTime();
                        final long time2 = timePeriod3.getEnd().getTime();
                        final TimePeriod timePeriod4 = timePeriodValues.getTimePeriod(timePeriodValues.getMaxMiddleIndex());
                        final long time3 = timePeriod4.getStart().getTime();
                        range = new Range(time + (time2 - time) / 2L, time3 + (timePeriod4.getEnd().getTime() - time3) / 2L);
                    }
                    else if (this.xPosition == TimePeriodAnchor.END) {
                        range = new Range(timePeriodValues.getTimePeriod(timePeriodValues.getMinEndIndex()).getEnd().getTime(), timePeriod2.getEnd().getTime());
                    }
                }
                else {
                    range = new Range(timePeriod.getStart().getTime(), timePeriod2.getEnd().getTime());
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
        if (!(o instanceof TimePeriodValuesCollection)) {
            return false;
        }
        final TimePeriodValuesCollection collection = (TimePeriodValuesCollection)o;
        return this.domainIsPointsInTime == collection.domainIsPointsInTime && this.xPosition == collection.xPosition && ObjectUtilities.equal(this.data, collection.data);
    }
}
