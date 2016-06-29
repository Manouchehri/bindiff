package org.jfree.data.time;

import java.io.*;
import java.util.*;

public class Hour extends RegularTimePeriod implements Serializable
{
    private static final long serialVersionUID = -835471579831937652L;
    public static final int FIRST_HOUR_IN_DAY = 0;
    public static final int LAST_HOUR_IN_DAY = 23;
    private Day day;
    private byte hour;
    private long firstMillisecond;
    private long lastMillisecond;
    
    public Hour() {
        this(new Date());
    }
    
    public Hour(final int n, final Day day) {
        if (day == null) {
            throw new IllegalArgumentException("Null 'day' argument.");
        }
        this.hour = (byte)n;
        this.day = day;
        this.peg(Calendar.getInstance());
    }
    
    public Hour(final int n, final int n2, final int n3, final int n4) {
        this(n, new Day(n2, n3, n4));
    }
    
    public Hour(final Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }
    
    public Hour(final Date time, final TimeZone timeZone) {
        if (time == null) {
            throw new IllegalArgumentException("Null 'time' argument.");
        }
        if (timeZone == null) {
            throw new IllegalArgumentException("Null 'zone' argument.");
        }
        final Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(time);
        this.hour = (byte)instance.get(11);
        this.day = new Day(time, timeZone);
        this.peg(Calendar.getInstance());
    }
    
    public int getHour() {
        return this.hour;
    }
    
    public Day getDay() {
        return this.day;
    }
    
    public int getYear() {
        return this.day.getYear();
    }
    
    public int getMonth() {
        return this.day.getMonth();
    }
    
    public int getDayOfMonth() {
        return this.day.getDayOfMonth();
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
        Hour hour;
        if (this.hour != 0) {
            hour = new Hour(this.hour - 1, this.day);
        }
        else {
            final Day day = (Day)this.day.previous();
            if (day != null) {
                hour = new Hour(23, day);
            }
            else {
                hour = null;
            }
        }
        return hour;
    }
    
    public RegularTimePeriod next() {
        Hour hour;
        if (this.hour != 23) {
            hour = new Hour(this.hour + 1, this.day);
        }
        else {
            final Day day = (Day)this.day.next();
            if (day != null) {
                hour = new Hour(0, day);
            }
            else {
                hour = null;
            }
        }
        return hour;
    }
    
    public long getSerialIndex() {
        return this.day.getSerialIndex() * 24L + this.hour;
    }
    
    public long getFirstMillisecond(final Calendar calendar) {
        calendar.set(this.day.getYear(), this.day.getMonth() - 1, this.day.getDayOfMonth(), this.hour, 0, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }
    
    public long getLastMillisecond(final Calendar calendar) {
        calendar.set(this.day.getYear(), this.day.getMonth() - 1, this.day.getDayOfMonth(), this.hour, 59, 59);
        calendar.set(14, 999);
        return calendar.getTime().getTime();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Hour)) {
            return false;
        }
        final Hour hour = (Hour)o;
        return this.hour == hour.hour && this.day.equals(hour.day);
    }
    
    public int hashCode() {
        return 37 * (37 * 17 + this.hour) + this.day.hashCode();
    }
    
    public int compareTo(final Object o) {
        int compareTo;
        if (o instanceof Hour) {
            final Hour hour = (Hour)o;
            compareTo = this.getDay().compareTo(hour.getDay());
            if (compareTo == 0) {
                compareTo = this.hour - hour.getHour();
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
    
    public static Hour parseHour(String trim) {
        Hour hour = null;
        trim = trim.trim();
        final String substring = trim.substring(0, Math.min(10, trim.length()));
        final Day day = Day.parseDay(substring);
        if (day != null) {
            final int int1 = Integer.parseInt(trim.substring(Math.min(substring.length() + 1, trim.length()), trim.length()).trim());
            if (int1 >= 0 && int1 <= 23) {
                hour = new Hour(int1, day);
            }
        }
        return hour;
    }
}
