package org.jfree.data.time;

import java.io.*;
import java.util.*;

public class Second extends RegularTimePeriod implements Serializable
{
    private static final long serialVersionUID = -6536564190712383466L;
    public static final int FIRST_SECOND_IN_MINUTE = 0;
    public static final int LAST_SECOND_IN_MINUTE = 59;
    private Day day;
    private byte hour;
    private byte minute;
    private byte second;
    private long firstMillisecond;
    
    public Second() {
        this(new Date());
    }
    
    public Second(final int n, final Minute minute) {
        if (minute == null) {
            throw new IllegalArgumentException("Null 'minute' argument.");
        }
        this.day = minute.getDay();
        this.hour = (byte)minute.getHourValue();
        this.minute = (byte)minute.getMinute();
        this.second = (byte)n;
        this.peg(Calendar.getInstance());
    }
    
    public Second(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        this(n, new Minute(n2, n3, n4, n5, n6));
    }
    
    public Second(final Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }
    
    public Second(final Date time, final TimeZone timeZone) {
        final Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(time);
        this.second = (byte)instance.get(13);
        this.minute = (byte)instance.get(12);
        this.hour = (byte)instance.get(11);
        this.day = new Day(time, timeZone);
        this.peg(instance);
    }
    
    public int getSecond() {
        return this.second;
    }
    
    public Minute getMinute() {
        return new Minute(this.minute, new Hour(this.hour, this.day));
    }
    
    public long getFirstMillisecond() {
        return this.firstMillisecond;
    }
    
    public long getLastMillisecond() {
        return this.firstMillisecond + 999L;
    }
    
    public void peg(final Calendar calendar) {
        this.firstMillisecond = this.getFirstMillisecond(calendar);
    }
    
    public RegularTimePeriod previous() {
        RegularTimePeriod regularTimePeriod = null;
        if (this.second != 0) {
            regularTimePeriod = new Second(this.second - 1, this.getMinute());
        }
        else {
            final Minute minute = (Minute)this.getMinute().previous();
            if (minute != null) {
                regularTimePeriod = new Second(59, minute);
            }
        }
        return regularTimePeriod;
    }
    
    public RegularTimePeriod next() {
        RegularTimePeriod regularTimePeriod = null;
        if (this.second != 59) {
            regularTimePeriod = new Second(this.second + 1, this.getMinute());
        }
        else {
            final Minute minute = (Minute)this.getMinute().next();
            if (minute != null) {
                regularTimePeriod = new Second(0, minute);
            }
        }
        return regularTimePeriod;
    }
    
    public long getSerialIndex() {
        return ((this.day.getSerialIndex() * 24L + this.hour) * 60L + this.minute) * 60L + this.second;
    }
    
    public long getFirstMillisecond(final Calendar calendar) {
        final int year = this.day.getYear();
        final int n = this.day.getMonth() - 1;
        final int dayOfMonth = this.day.getDayOfMonth();
        calendar.clear();
        calendar.set(year, n, dayOfMonth, this.hour, this.minute, this.second);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }
    
    public long getLastMillisecond(final Calendar calendar) {
        return this.getFirstMillisecond(calendar) + 999L;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Second)) {
            return false;
        }
        final Second second = (Second)o;
        return this.second == second.second && this.minute == second.minute && this.hour == second.hour && this.day.equals(second.day);
    }
    
    public int hashCode() {
        return 37 * (37 * (37 * (37 * 17 + this.second) + this.minute) + this.hour) + this.day.hashCode();
    }
    
    public int compareTo(final Object o) {
        if (!(o instanceof Second)) {
            return (o instanceof RegularTimePeriod) ? 0 : 1;
        }
        final Second second = (Second)o;
        if (this.firstMillisecond < second.firstMillisecond) {
            return -1;
        }
        if (this.firstMillisecond > second.firstMillisecond) {
            return 1;
        }
        return 0;
    }
    
    public static Second parseSecond(String trim) {
        Second second = null;
        trim = trim.trim();
        final String substring = trim.substring(0, Math.min(10, trim.length()));
        final Day day = Day.parseDay(substring);
        if (day != null) {
            final String trim2 = trim.substring(Math.min(substring.length() + 1, trim.length()), trim.length()).trim();
            final int length = trim2.length();
            final String substring2 = trim2.substring(0, Math.min(2, length));
            final String substring3 = trim2.substring(Math.min(3, length), Math.min(5, length));
            final String substring4 = trim2.substring(Math.min(6, length), Math.min(8, length));
            final int int1 = Integer.parseInt(substring2);
            if (int1 >= 0 && int1 <= 23) {
                final int int2 = Integer.parseInt(substring3);
                if (int2 >= 0 && int2 <= 59) {
                    final Minute minute = new Minute(int2, new Hour(int1, day));
                    final int int3 = Integer.parseInt(substring4);
                    if (int3 >= 0 && int3 <= 59) {
                        second = new Second(int3, minute);
                    }
                }
            }
        }
        return second;
    }
}
