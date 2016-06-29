/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;

public class Hour
extends RegularTimePeriod
implements Serializable {
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

    public Hour(int n2, Day day) {
        if (day == null) {
            throw new IllegalArgumentException("Null 'day' argument.");
        }
        this.hour = (byte)n2;
        this.day = day;
        this.peg(Calendar.getInstance());
    }

    public Hour(int n2, int n3, int n4, int n5) {
        this(n2, new Day(n3, n4, n5));
    }

    public Hour(Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }

    public Hour(Date date, TimeZone timeZone) {
        if (date == null) {
            throw new IllegalArgumentException("Null 'time' argument.");
        }
        if (timeZone == null) {
            throw new IllegalArgumentException("Null 'zone' argument.");
        }
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        this.hour = (byte)calendar.get(11);
        this.day = new Day(date, timeZone);
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
        if (this.hour != 0) {
            return new Hour(this.hour - 1, this.day);
        }
        Day day = (Day)this.day.previous();
        if (day == null) return null;
        return new Hour(23, day);
    }

    @Override
    public RegularTimePeriod next() {
        if (this.hour != 23) {
            return new Hour(this.hour + 1, this.day);
        }
        Day day = (Day)this.day.next();
        if (day == null) return null;
        return new Hour(0, day);
    }

    @Override
    public long getSerialIndex() {
        return this.day.getSerialIndex() * 24 + (long)this.hour;
    }

    @Override
    public long getFirstMillisecond(Calendar calendar) {
        int n2 = this.day.getYear();
        int n3 = this.day.getMonth() - 1;
        int n4 = this.day.getDayOfMonth();
        calendar.set(n2, n3, n4, this.hour, 0, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    @Override
    public long getLastMillisecond(Calendar calendar) {
        int n2 = this.day.getYear();
        int n3 = this.day.getMonth() - 1;
        int n4 = this.day.getDayOfMonth();
        calendar.set(n2, n3, n4, this.hour, 59, 59);
        calendar.set(14, 999);
        return calendar.getTime().getTime();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Hour)) {
            return false;
        }
        Hour hour = (Hour)object;
        if (this.hour != hour.hour) {
            return false;
        }
        if (this.day.equals(hour.day)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 17;
        n2 = 37 * n2 + this.hour;
        return 37 * n2 + this.day.hashCode();
    }

    public int compareTo(Object object) {
        if (object instanceof Hour) {
            Hour hour = (Hour)object;
            int n2 = this.getDay().compareTo(hour.getDay());
            if (n2 != 0) return n2;
            return this.hour - hour.getHour();
        }
        if (!(object instanceof RegularTimePeriod)) return 1;
        return 0;
    }

    public static Hour parseHour(String string) {
        Hour hour = null;
        String string2 = (string = string.trim()).substring(0, Math.min(10, string.length()));
        Day day = Day.parseDay(string2);
        if (day == null) return hour;
        String string3 = string.substring(Math.min(string2.length() + 1, string.length()), string.length());
        int n2 = Integer.parseInt(string3 = string3.trim());
        if (n2 < 0) return hour;
        if (n2 > 23) return hour;
        return new Hour(n2, day);
    }
}

