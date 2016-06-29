/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.Day;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Second;

public class Millisecond
extends RegularTimePeriod
implements Serializable {
    static final long serialVersionUID = -5316836467277638485L;
    public static final int FIRST_MILLISECOND_IN_SECOND = 0;
    public static final int LAST_MILLISECOND_IN_SECOND = 999;
    private Day day;
    private byte hour;
    private byte minute;
    private byte second;
    private int millisecond;
    private long firstMillisecond;

    public Millisecond() {
        this(new Date());
    }

    public Millisecond(int n2, Second second) {
        this.millisecond = n2;
        this.second = (byte)second.getSecond();
        this.minute = (byte)second.getMinute().getMinute();
        this.hour = (byte)second.getMinute().getHourValue();
        this.day = second.getMinute().getDay();
        this.peg(Calendar.getInstance());
    }

    public Millisecond(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this(n2, new Second(n3, n4, n5, n6, n7, n8));
    }

    public Millisecond(Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }

    public Millisecond(Date date, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        this.millisecond = calendar.get(14);
        this.second = (byte)calendar.get(13);
        this.minute = (byte)calendar.get(12);
        this.hour = (byte)calendar.get(11);
        this.day = new Day(date, timeZone);
        this.peg(Calendar.getInstance());
    }

    public Second getSecond() {
        return new Second(this.second, this.minute, this.hour, this.day.getDayOfMonth(), this.day.getMonth(), this.day.getYear());
    }

    public long getMillisecond() {
        return this.millisecond;
    }

    @Override
    public long getFirstMillisecond() {
        return this.firstMillisecond;
    }

    @Override
    public long getLastMillisecond() {
        return this.firstMillisecond;
    }

    @Override
    public void peg(Calendar calendar) {
        this.firstMillisecond = this.getFirstMillisecond(calendar);
    }

    @Override
    public RegularTimePeriod previous() {
        Millisecond millisecond = null;
        if (this.millisecond != 0) {
            return new Millisecond(this.millisecond - 1, this.getSecond());
        }
        Second second = (Second)this.getSecond().previous();
        if (second == null) return millisecond;
        return new Millisecond(999, second);
    }

    @Override
    public RegularTimePeriod next() {
        Millisecond millisecond = null;
        if (this.millisecond != 999) {
            return new Millisecond(this.millisecond + 1, this.getSecond());
        }
        Second second = (Second)this.getSecond().next();
        if (second == null) return millisecond;
        return new Millisecond(0, second);
    }

    @Override
    public long getSerialIndex() {
        long l2 = this.day.getSerialIndex() * 24 + (long)this.hour;
        long l3 = l2 * 60 + (long)this.minute;
        long l4 = l3 * 60 + (long)this.second;
        return l4 * 1000 + (long)this.millisecond;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Millisecond)) {
            return false;
        }
        Millisecond millisecond = (Millisecond)object;
        if (this.millisecond != millisecond.millisecond) {
            return false;
        }
        if (this.second != millisecond.second) {
            return false;
        }
        if (this.minute != millisecond.minute) {
            return false;
        }
        if (this.hour != millisecond.hour) {
            return false;
        }
        if (this.day.equals(millisecond.day)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 17;
        n2 = 37 * n2 + this.millisecond;
        return 37 * n2 + this.getSecond().hashCode();
    }

    public int compareTo(Object object) {
        if (object instanceof Millisecond) {
            Millisecond millisecond = (Millisecond)object;
            long l2 = this.getFirstMillisecond() - millisecond.getFirstMillisecond();
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
    public long getFirstMillisecond(Calendar calendar) {
        int n2 = this.day.getYear();
        int n3 = this.day.getMonth() - 1;
        int n4 = this.day.getDayOfMonth();
        calendar.clear();
        calendar.set(n2, n3, n4, this.hour, this.minute, this.second);
        calendar.set(14, this.millisecond);
        return calendar.getTime().getTime();
    }

    @Override
    public long getLastMillisecond(Calendar calendar) {
        return this.getFirstMillisecond(calendar);
    }
}

