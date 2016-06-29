/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.Serializable;
import java.util.Date;
import org.jfree.data.time.TimePeriod;

public class SimpleTimePeriod
implements Serializable,
Comparable,
TimePeriod {
    private static final long serialVersionUID = 8684672361131829554L;
    private Date start;
    private Date end;

    public SimpleTimePeriod(long l2, long l3) {
        this(new Date(l2), new Date(l3));
    }

    public SimpleTimePeriod(Date date, Date date2) {
        if (date.getTime() > date2.getTime()) {
            throw new IllegalArgumentException("Requires end >= start.");
        }
        this.start = date;
        this.end = date2;
    }

    @Override
    public Date getStart() {
        return this.start;
    }

    @Override
    public Date getEnd() {
        return this.end;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TimePeriod)) {
            return false;
        }
        TimePeriod timePeriod = (TimePeriod)object;
        if (!this.start.equals(timePeriod.getStart())) {
            return false;
        }
        if (this.end.equals(timePeriod.getEnd())) return true;
        return false;
    }

    public int compareTo(Object object) {
        long l2;
        long l3;
        long l4;
        long l5;
        TimePeriod timePeriod = (TimePeriod)object;
        long l6 = this.getStart().getTime();
        long l7 = l6 + ((l4 = this.getEnd().getTime()) - l6) / 2;
        if (l7 < (l2 = (l3 = timePeriod.getStart().getTime()) + ((l5 = timePeriod.getEnd().getTime()) - l3) / 2)) {
            return -1;
        }
        if (l7 > l2) {
            return 1;
        }
        if (l6 < l3) {
            return -1;
        }
        if (l6 > l3) {
            return 1;
        }
        if (l4 < l5) {
            return -1;
        }
        if (l4 <= l5) return 0;
        return 1;
    }

    public int hashCode() {
        int n2 = 17;
        n2 = 37 * n2 + this.start.hashCode();
        return 37 * n2 + this.end.hashCode();
    }
}

