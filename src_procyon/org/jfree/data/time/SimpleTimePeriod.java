package org.jfree.data.time;

import java.io.*;
import java.util.*;

public class SimpleTimePeriod implements Serializable, Comparable, TimePeriod
{
    private static final long serialVersionUID = 8684672361131829554L;
    private Date start;
    private Date end;
    
    public SimpleTimePeriod(final long n, final long n2) {
        this(new Date(n), new Date(n2));
    }
    
    public SimpleTimePeriod(final Date start, final Date end) {
        if (start.getTime() > end.getTime()) {
            throw new IllegalArgumentException("Requires end >= start.");
        }
        this.start = start;
        this.end = end;
    }
    
    public Date getStart() {
        return this.start;
    }
    
    public Date getEnd() {
        return this.end;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TimePeriod)) {
            return false;
        }
        final TimePeriod timePeriod = (TimePeriod)o;
        return this.start.equals(timePeriod.getStart()) && this.end.equals(timePeriod.getEnd());
    }
    
    public int compareTo(final Object o) {
        final TimePeriod timePeriod = (TimePeriod)o;
        final long time = this.getStart().getTime();
        final long time2 = this.getEnd().getTime();
        final long n = time + (time2 - time) / 2L;
        final long time3 = timePeriod.getStart().getTime();
        final long time4 = timePeriod.getEnd().getTime();
        final long n2 = time3 + (time4 - time3) / 2L;
        if (n < n2) {
            return -1;
        }
        if (n > n2) {
            return 1;
        }
        if (time < time3) {
            return -1;
        }
        if (time > time3) {
            return 1;
        }
        if (time2 < time4) {
            return -1;
        }
        if (time2 > time4) {
            return 1;
        }
        return 0;
    }
    
    public int hashCode() {
        return 37 * (37 * 17 + this.start.hashCode()) + this.end.hashCode();
    }
}
