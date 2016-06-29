package org.jfree.data.time;

import java.io.*;

public class TimePeriodValue implements Serializable, Cloneable
{
    private static final long serialVersionUID = 3390443360845711275L;
    private TimePeriod period;
    private Number value;
    
    public TimePeriodValue(final TimePeriod period, final Number value) {
        if (period == null) {
            throw new IllegalArgumentException("Null 'period' argument.");
        }
        this.period = period;
        this.value = value;
    }
    
    public TimePeriodValue(final TimePeriod timePeriod, final double n) {
        this(timePeriod, new Double(n));
    }
    
    public TimePeriod getPeriod() {
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
        if (!(o instanceof TimePeriodValue)) {
            return false;
        }
        final TimePeriodValue timePeriodValue = (TimePeriodValue)o;
        Label_0054: {
            if (this.period != null) {
                if (this.period.equals(timePeriodValue.period)) {
                    break Label_0054;
                }
            }
            else if (timePeriodValue.period == null) {
                break Label_0054;
            }
            return false;
        }
        if (this.value != null) {
            if (this.value.equals(timePeriodValue.value)) {
                return true;
            }
        }
        else if (timePeriodValue.value == null) {
            return true;
        }
        return false;
    }
    
    public int hashCode() {
        return 29 * ((this.period != null) ? this.period.hashCode() : 0) + ((this.value != null) ? this.value.hashCode() : 0);
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
