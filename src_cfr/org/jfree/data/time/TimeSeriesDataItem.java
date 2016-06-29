/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.Serializable;
import org.jfree.data.time.RegularTimePeriod;

public class TimeSeriesDataItem
implements Serializable,
Cloneable,
Comparable {
    private static final long serialVersionUID = -2235346966016401302L;
    private RegularTimePeriod period;
    private Number value;

    public TimeSeriesDataItem(RegularTimePeriod regularTimePeriod, Number number) {
        if (regularTimePeriod == null) {
            throw new IllegalArgumentException("Null 'period' argument.");
        }
        this.period = regularTimePeriod;
        this.value = number;
    }

    public TimeSeriesDataItem(RegularTimePeriod regularTimePeriod, double d2) {
        this(regularTimePeriod, new Double(d2));
    }

    public RegularTimePeriod getPeriod() {
        return this.period;
    }

    public Number getValue() {
        return this.value;
    }

    public void setValue(Number number) {
        this.value = number;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof TimeSeriesDataItem)) {
            return false;
        }
        TimeSeriesDataItem timeSeriesDataItem = (TimeSeriesDataItem)object;
        if (this.period != null ? !this.period.equals(timeSeriesDataItem.period) : timeSeriesDataItem.period != null) {
            return false;
        }
        if (this.value != null) {
            if (this.value.equals(timeSeriesDataItem.value)) return true;
            return false;
        }
        if (timeSeriesDataItem.value == null) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.period != null ? this.period.hashCode() : 0;
        return 29 * n2 + (this.value != null ? this.value.hashCode() : 0);
    }

    public int compareTo(Object object) {
        if (!(object instanceof TimeSeriesDataItem)) return 1;
        TimeSeriesDataItem timeSeriesDataItem = (TimeSeriesDataItem)object;
        return this.getPeriod().compareTo(timeSeriesDataItem.getPeriod());
    }

    public Object clone() {
        Object object = null;
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException var2_2) {
            var2_2.printStackTrace();
        }
        return object;
    }
}

