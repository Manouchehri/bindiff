/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.jfree.data.time.RegularTimePeriod;

public class FixedMillisecond
extends RegularTimePeriod
implements Serializable {
    private static final long serialVersionUID = 7867521484545646931L;
    private Date time;

    public FixedMillisecond() {
        this(new Date());
    }

    public FixedMillisecond(long l2) {
        this(new Date(l2));
    }

    public FixedMillisecond(Date date) {
        this.time = date;
    }

    public Date getTime() {
        return this.time;
    }

    @Override
    public void peg(Calendar calendar) {
    }

    @Override
    public RegularTimePeriod previous() {
        FixedMillisecond fixedMillisecond = null;
        long l2 = this.time.getTime();
        if (l2 == Long.MIN_VALUE) return fixedMillisecond;
        return new FixedMillisecond(l2 - 1);
    }

    @Override
    public RegularTimePeriod next() {
        FixedMillisecond fixedMillisecond = null;
        long l2 = this.time.getTime();
        if (l2 == Long.MAX_VALUE) return fixedMillisecond;
        return new FixedMillisecond(l2 + 1);
    }

    public boolean equals(Object object) {
        if (!(object instanceof FixedMillisecond)) return false;
        FixedMillisecond fixedMillisecond = (FixedMillisecond)object;
        return this.time.equals(fixedMillisecond.getTime());
    }

    public int hashCode() {
        return this.time.hashCode();
    }

    public int compareTo(Object object) {
        if (object instanceof FixedMillisecond) {
            FixedMillisecond fixedMillisecond = (FixedMillisecond)object;
            long l2 = this.time.getTime() - fixedMillisecond.time.getTime();
            if (l2 > 0) {
                return 1;
            }
            if (l2 >= 0) return 0;
            return -1;
        }
        if (!(object instanceof RegularTimePeriod)) return 1;
        return 0;
    }

    @Override
    public long getFirstMillisecond() {
        return this.time.getTime();
    }

    @Override
    public long getFirstMillisecond(Calendar calendar) {
        return this.time.getTime();
    }

    @Override
    public long getLastMillisecond() {
        return this.time.getTime();
    }

    @Override
    public long getLastMillisecond(Calendar calendar) {
        return this.time.getTime();
    }

    @Override
    public long getMiddleMillisecond() {
        return this.time.getTime();
    }

    @Override
    public long getMiddleMillisecond(Calendar calendar) {
        return this.time.getTime();
    }

    @Override
    public long getSerialIndex() {
        return this.time.getTime();
    }
}

