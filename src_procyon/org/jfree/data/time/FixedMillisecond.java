package org.jfree.data.time;

import java.io.*;
import java.util.*;

public class FixedMillisecond extends RegularTimePeriod implements Serializable
{
    private static final long serialVersionUID = 7867521484545646931L;
    private Date time;
    
    public FixedMillisecond() {
        this(new Date());
    }
    
    public FixedMillisecond(final long n) {
        this(new Date(n));
    }
    
    public FixedMillisecond(final Date time) {
        this.time = time;
    }
    
    public Date getTime() {
        return this.time;
    }
    
    public void peg(final Calendar calendar) {
    }
    
    public RegularTimePeriod previous() {
        RegularTimePeriod regularTimePeriod = null;
        final long time = this.time.getTime();
        if (time != Long.MIN_VALUE) {
            regularTimePeriod = new FixedMillisecond(time - 1L);
        }
        return regularTimePeriod;
    }
    
    public RegularTimePeriod next() {
        RegularTimePeriod regularTimePeriod = null;
        final long time = this.time.getTime();
        if (time != Long.MAX_VALUE) {
            regularTimePeriod = new FixedMillisecond(time + 1L);
        }
        return regularTimePeriod;
    }
    
    public boolean equals(final Object o) {
        return o instanceof FixedMillisecond && this.time.equals(((FixedMillisecond)o).getTime());
    }
    
    public int hashCode() {
        return this.time.hashCode();
    }
    
    public int compareTo(final Object o) {
        int n2;
        if (o instanceof FixedMillisecond) {
            final long n = this.time.getTime() - ((FixedMillisecond)o).time.getTime();
            if (n > 0L) {
                n2 = 1;
            }
            else if (n < 0L) {
                n2 = -1;
            }
            else {
                n2 = 0;
            }
        }
        else if (o instanceof RegularTimePeriod) {
            n2 = 0;
        }
        else {
            n2 = 1;
        }
        return n2;
    }
    
    public long getFirstMillisecond() {
        return this.time.getTime();
    }
    
    public long getFirstMillisecond(final Calendar calendar) {
        return this.time.getTime();
    }
    
    public long getLastMillisecond() {
        return this.time.getTime();
    }
    
    public long getLastMillisecond(final Calendar calendar) {
        return this.time.getTime();
    }
    
    public long getMiddleMillisecond() {
        return this.time.getTime();
    }
    
    public long getMiddleMillisecond(final Calendar calendar) {
        return this.time.getTime();
    }
    
    public long getSerialIndex() {
        return this.time.getTime();
    }
}
