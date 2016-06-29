/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.Serializable;
import org.jfree.data.time.TimePeriod;

public class TimePeriodValue
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 3390443360845711275L;
    private TimePeriod period;
    private Number value;

    public TimePeriodValue(TimePeriod timePeriod, Number number) {
        if (timePeriod == null) {
            throw new IllegalArgumentException("Null 'period' argument.");
        }
        this.period = timePeriod;
        this.value = number;
    }

    public TimePeriodValue(TimePeriod timePeriod, double d2) {
        this(timePeriod, new Double(d2));
    }

    public TimePeriod getPeriod() {
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
        if (!(object instanceof TimePeriodValue)) {
            return false;
        }
        TimePeriodValue timePeriodValue = (TimePeriodValue)object;
        if (this.period != null ? !this.period.equals(timePeriodValue.period) : timePeriodValue.period != null) {
            return false;
        }
        if (this.value != null) {
            if (this.value.equals(timePeriodValue.value)) return true;
            return false;
        }
        if (timePeriodValue.value == null) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.period != null ? this.period.hashCode() : 0;
        return 29 * n2 + (this.value != null ? this.value.hashCode() : 0);
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

