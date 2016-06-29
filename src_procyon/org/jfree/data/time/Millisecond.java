package org.jfree.data.time;

import java.io.*;
import java.util.*;

public class Millisecond extends RegularTimePeriod implements Serializable
{
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
    
    public Millisecond(final int millisecond, final Second second) {
        this.millisecond = millisecond;
        this.second = (byte)second.getSecond();
        this.minute = (byte)second.getMinute().getMinute();
        this.hour = (byte)second.getMinute().getHourValue();
        this.day = second.getMinute().getDay();
        this.peg(Calendar.getInstance());
    }
    
    public Millisecond(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        this(n, new Second(n2, n3, n4, n5, n6, n7));
    }
    
    public Millisecond(final Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }
    
    public Millisecond(final Date time, final TimeZone timeZone) {
        final Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(time);
        this.millisecond = instance.get(14);
        this.second = (byte)instance.get(13);
        this.minute = (byte)instance.get(12);
        this.hour = (byte)instance.get(11);
        this.day = new Day(time, timeZone);
        this.peg(Calendar.getInstance());
    }
    
    public Second getSecond() {
        return new Second(this.second, this.minute, this.hour, this.day.getDayOfMonth(), this.day.getMonth(), this.day.getYear());
    }
    
    public long getMillisecond() {
        return this.millisecond;
    }
    
    public long getFirstMillisecond() {
        return this.firstMillisecond;
    }
    
    public long getLastMillisecond() {
        return this.firstMillisecond;
    }
    
    public void peg(final Calendar calendar) {
        this.firstMillisecond = this.getFirstMillisecond(calendar);
    }
    
    public RegularTimePeriod previous() {
        RegularTimePeriod regularTimePeriod = null;
        if (this.millisecond != 0) {
            regularTimePeriod = new Millisecond(this.millisecond - 1, this.getSecond());
        }
        else {
            final Second second = (Second)this.getSecond().previous();
            if (second != null) {
                regularTimePeriod = new Millisecond(999, second);
            }
        }
        return regularTimePeriod;
    }
    
    public RegularTimePeriod next() {
        RegularTimePeriod regularTimePeriod = null;
        if (this.millisecond != 999) {
            regularTimePeriod = new Millisecond(this.millisecond + 1, this.getSecond());
        }
        else {
            final Second second = (Second)this.getSecond().next();
            if (second != null) {
                regularTimePeriod = new Millisecond(0, second);
            }
        }
        return regularTimePeriod;
    }
    
    public long getSerialIndex() {
        return (((this.day.getSerialIndex() * 24L + this.hour) * 60L + this.minute) * 60L + this.second) * 1000L + this.millisecond;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Millisecond)) {
            return false;
        }
        final Millisecond millisecond = (Millisecond)o;
        return this.millisecond == millisecond.millisecond && this.second == millisecond.second && this.minute == millisecond.minute && this.hour == millisecond.hour && this.day.equals(millisecond.day);
    }
    
    public int hashCode() {
        return 37 * (37 * 17 + this.millisecond) + this.getSecond().hashCode();
    }
    
    public int compareTo(final Object o) {
        int n2;
        if (o instanceof Millisecond) {
            final long n = this.getFirstMillisecond() - ((Millisecond)o).getFirstMillisecond();
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
    
    public long getFirstMillisecond(final Calendar calendar) {
        final int year = this.day.getYear();
        final int n = this.day.getMonth() - 1;
        final int dayOfMonth = this.day.getDayOfMonth();
        calendar.clear();
        calendar.set(year, n, dayOfMonth, this.hour, this.minute, this.second);
        calendar.set(14, this.millisecond);
        return calendar.getTime().getTime();
    }
    
    public long getLastMillisecond(final Calendar calendar) {
        return this.getFirstMillisecond(calendar);
    }
}
