/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.RegularTimePeriod;

public class Minute
extends RegularTimePeriod
implements Serializable {
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

    public Minute(int n2, Hour hour) {
        if (hour == null) {
            throw new IllegalArgumentException("Null 'hour' argument.");
        }
        this.minute = (byte)n2;
        this.hour = (byte)hour.getHour();
        this.day = hour.getDay();
        this.peg(Calendar.getInstance());
    }

    public Minute(Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }

    public Minute(Date date, TimeZone timeZone) {
        if (date == null) {
            throw new IllegalArgumentException("Null 'time' argument.");
        }
        if (timeZone == null) {
            throw new IllegalArgumentException("Null 'zone' argument.");
        }
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        int n2 = calendar.get(12);
        this.minute = (byte)n2;
        this.hour = (byte)calendar.get(11);
        this.day = new Day(date, timeZone);
        this.peg(calendar);
    }

    public Minute(int n2, int n3, int n4, int n5, int n6) {
        this(n2, new Hour(n3, new Day(n4, n5, n6)));
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

    @Override
    public long getFirstMillisecond() {
        return this.firstMillisecond;
    }

    @Override
    public long getLastMillisecond() {
        return this.lastMillisecond;
    }

    @Override
    public void peg(Calendar calendar) {
        this.firstMillisecond = this.getFirstMillisecond(calendar);
        this.lastMillisecond = this.getLastMillisecond(calendar);
    }

    @Override
    public RegularTimePeriod previous() {
        if (this.minute != 0) {
            return new Minute(this.minute - 1, this.getHour());
        }
        Hour hour = (Hour)this.getHour().previous();
        if (hour == null) return null;
        return new Minute(59, hour);
    }

    @Override
    public RegularTimePeriod next() {
        if (this.minute != 59) {
            return new Minute(this.minute + 1, this.getHour());
        }
        Hour hour = (Hour)this.getHour().next();
        if (hour == null) return null;
        return new Minute(0, hour);
    }

    @Override
    public long getSerialIndex() {
        long l2 = this.day.getSerialIndex() * 24 + (long)this.hour;
        return l2 * 60 + (long)this.minute;
    }

    @Override
    public long getFirstMillisecond(Calendar calendar) {
        int n2 = this.day.getYear();
        int n3 = this.day.getMonth() - 1;
        int n4 = this.day.getDayOfMonth();
        calendar.clear();
        calendar.set(n2, n3, n4, this.hour, this.minute, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    @Override
    public long getLastMillisecond(Calendar calendar) {
        int n2 = this.day.getYear();
        int n3 = this.day.getMonth() - 1;
        int n4 = this.day.getDayOfMonth();
        calendar.clear();
        calendar.set(n2, n3, n4, this.hour, this.minute, 59);
        calendar.set(14, 999);
        return calendar.getTime().getTime();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Minute)) {
            return false;
        }
        Minute minute = (Minute)object;
        if (this.minute != minute.minute) {
            return false;
        }
        if (this.hour == minute.hour) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 17;
        n2 = 37 * n2 + this.minute;
        n2 = 37 * n2 + this.hour;
        return 37 * n2 + this.day.hashCode();
    }

    public int compareTo(Object object) {
        if (object instanceof Minute) {
            Minute minute = (Minute)object;
            int n2 = this.getHour().compareTo(minute.getHour());
            if (n2 != 0) return n2;
            return this.minute - minute.getMinute();
        }
        if (!(object instanceof RegularTimePeriod)) return 1;
        return 0;
    }

    public static Minute parseMinute(String string) {
        Minute minute = null;
        String string2 = (string = string.trim()).substring(0, Math.min(10, string.length()));
        Day day = Day.parseDay(string2);
        if (day == null) return minute;
        String string3 = string.substring(Math.min(string2.length() + 1, string.length()), string.length());
        String string4 = (string3 = string3.trim()).substring(0, Math.min(2, string3.length()));
        int n2 = Integer.parseInt(string4);
        if (n2 < 0) return minute;
        if (n2 > 23) return minute;
        String string5 = string3.substring(Math.min(string4.length() + 1, string3.length()), string3.length());
        int n3 = Integer.parseInt(string5);
        if (n3 < 0) return minute;
        if (n3 > 59) return minute;
        return new Minute(n3, new Hour(n2, day));
    }
}

