package org.jfree.data.time;

import java.io.*;

public class TimeSeriesDataItem implements Serializable, Cloneable, Comparable
{
    private static final long serialVersionUID = -2235346966016401302L;
    private RegularTimePeriod period;
    private Number value;
    
    public TimeSeriesDataItem(final RegularTimePeriod period, final Number value) {
        if (period == null) {
            throw new IllegalArgumentException("Null 'period' argument.");
        }
        this.period = period;
        this.value = value;
    }
    
    public TimeSeriesDataItem(final RegularTimePeriod regularTimePeriod, final double n) {
        this(regularTimePeriod, new Double(n));
    }
    
    public RegularTimePeriod getPeriod() {
        return this.period;
    }
    
    public Number getValue() {
        return this.value;
    }
    
    public void setValue(final Number value) {
        this.value = value;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TimeSeriesDataItem)) {
            return false;
        }
        final TimeSeriesDataItem timeSeriesDataItem = (TimeSeriesDataItem)o;
        if (this.period != null) {
            if (!this.period.equals(timeSeriesDataItem.period)) {
                return false;
            }
        }
        else if (timeSeriesDataItem.period != null) {
            return false;
        }
        if (this.value != null) {
            if (!this.value.equals(timeSeriesDataItem.value)) {
                return false;
            }
        }
        else if (timeSeriesDataItem.value != null) {
            return false;
        }
        return true;
    }
    
    public int hashCode() {
        return 29 * ((this.period != null) ? this.period.hashCode() : 0) + ((this.value != null) ? this.value.hashCode() : 0);
    }
    
    public int compareTo(final Object o) {
        int compareTo;
        if (o instanceof TimeSeriesDataItem) {
            compareTo = this.getPeriod().compareTo(((TimeSeriesDataItem)o).getPeriod());
        }
        else {
            compareTo = 1;
        }
        return compareTo;
    }
    
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        }
        catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return clone;
    }
}
