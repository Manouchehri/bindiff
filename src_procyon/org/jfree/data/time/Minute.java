package org.jfree.data.time;

import java.io.*;
import java.util.*;

public class Minute extends RegularTimePeriod implements Serializable
{
    private static final long serialVersionUID = 2144572840034842871L;
    public static final int FIRST_MINUTE_IN_HOUR = 0;
    public static final int LAST_MINUTE_IN_HOUR = 59;
    private Day day;
    private byte hour;
    private byte minute;
    private long firstMillisecond;
    private long lastMillisecond;
    
    public Minute() {
        this(new Date());
    }
    
    public Minute(final int n, final Hour hour) {
        if (hour == null) {
            throw new IllegalArgumentException("Null 'hour' argument.");
        }
        this.minute = (byte)n;
        this.hour = (byte)hour.getHour();
        this.day = hour.getDay();
        this.peg(Calendar.getInstance());
    }
    
    public Minute(final Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }
    
    public Minute(final Date time, final TimeZone timeZone) {
        if (time == null) {
            throw new IllegalArgumentException("Null 'time' argument.");
        }
        if (timeZone == null) {
            throw new IllegalArgumentException("Null 'zone' argument.");
        }
        final Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(time);
        this.minute = (byte)instance.get(12);
        this.hour = (byte)instance.get(11);
        this.day = new Day(time, timeZone);
        this.peg(instance);
    }
    
    public Minute(final int n, final int n2, final int n3, final int n4, final int n5) {
        this(n, new Hour(n2, new Day(n3, n4, n5)));
    }
    
    public Day getDay() {
        return this.day;
    }
    
    public Hour getHour() {
        return new Hour(this.hour, this.day);
    }
    
    public int getHourValue() {
        return this.hour;
    }
    
    public int getMinute() {
        return this.minute;
    }
    
    public long getFirstMillisecond() {
        return this.firstMillisecond;
    }
    
    public long getLastMillisecond() {
        return this.lastMillisecond;
    }
    
    public void peg(final Calendar calendar) {
        this.firstMillisecond = this.getFirstMillisecond(calendar);
        this.lastMillisecond = this.getLastMillisecond(calendar);
    }
    
    public RegularTimePeriod previous() {
        Minute minute;
        if (this.minute != 0) {
            minute = new Minute(this.minute - 1, this.getHour());
        }
        else {
            final Hour hour = (Hour)this.getHour().previous();
            if (hour != null) {
                minute = new Minute(59, hour);
            }
            else {
                minute = null;
            }
        }
        return minute;
    }
    
    public RegularTimePeriod next() {
        Minute minute;
        if (this.minute != 59) {
            minute = new Minute(this.minute + 1, this.getHour());
        }
        else {
            final Hour hour = (Hour)this.getHour().next();
            if (hour != null) {
                minute = new Minute(0, hour);
            }
            else {
                minute = null;
            }
        }
        return minute;
    }
    
    public long getSerialIndex() {
        return (this.day.getSerialIndex() * 24L + this.hour) * 60L + this.minute;
    }
    
    public long getFirstMillisecond(final Calendar calendar) {
        final int year = this.day.getYear();
        final int n = this.day.getMonth() - 1;
        final int dayOfMonth = this.day.getDayOfMonth();
        calendar.clear();
        calendar.set(year, n, dayOfMonth, this.hour, this.minute, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }
    
    public long getLastMillisecond(final Calendar calendar) {
        final int year = this.day.getYear();
        final int n = this.day.getMonth() - 1;
        final int dayOfMonth = this.day.getDayOfMonth();
        calendar.clear();
        calendar.set(year, n, dayOfMonth, this.hour, this.minute, 59);
        calendar.set(14, 999);
        return calendar.getTime().getTime();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Minute)) {
            return false;
        }
        final Minute minute = (Minute)o;
        return this.minute == minute.minute && this.hour == minute.hour;
    }
    
    public int hashCode() {
        return 37 * (37 * (37 * 17 + this.minute) + this.hour) + this.day.hashCode();
    }
    
    public int compareTo(final Object o) {
        int compareTo;
        if (o instanceof Minute) {
            final Minute minute = (Minute)o;
            compareTo = this.getHour().compareTo(minute.getHour());
            if (compareTo == 0) {
                compareTo = this.minute - minute.getMinute();
            }
        }
        else if (o instanceof RegularTimePeriod) {
            compareTo = 0;
        }
        else {
            compareTo = 1;
        }
        return compareTo;
    }
    
    public static Minute parseMinute(String trim) {
        Minute minute = null;
        trim = trim.trim();
        final String substring = trim.substring(0, Math.min(10, trim.length()));
        final Day day = Day.parseDay(substring);
        if (day != null) {
            final String trim2 = trim.substring(Math.min(substring.length() + 1, trim.length()), trim.length()).trim();
            final String substring2 = trim2.substring(0, Math.min(2, trim2.length()));
            final int int1 = Integer.parseInt(substring2);
            if (int1 >= 0 && int1 <= 23) {
                final int int2 = Integer.parseInt(trim2.substring(Math.min(substring2.length() + 1, trim2.length()), trim2.length()));
                if (int2 >= 0 && int2 <= 59) {
                    minute = new Minute(int2, new Hour(int1, day));
                }
            }
        }
        return minute;
    }
}
