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
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;

public class Second
extends RegularTimePeriod
implements Serializable {
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

    public Second(int n2, Minute minute) {
        if (minute == null) {
            throw new IllegalArgumentException("Null 'minute' argument.");
        }
        this.day = minute.getDay();
        this.hour = (byte)minute.getHourValue();
        this.minute = (byte)minute.getMinute();
        this.second = (byte)n2;
        this.peg(Calendar.getInstance());
    }

    public Second(int n2, int n3, int n4, int n5, int n6, int n7) {
        this(n2, new Minute(n3, n4, n5, n6, n7));
    }

    public Second(Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }

    public Second(Date date, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        this.second = (byte)calendar.get(13);
        this.minute = (byte)calendar.get(12);
        this.hour = (byte)calendar.get(11);
        this.day = new Day(date, timeZone);
        this.peg(calendar);
    }

    public int getSecond() {
        return this.second;
    }

    public Minute getMinute() {
        return new Minute(this.minute, new Hour(this.hour, this.day));
    }

    @Override
    public long getFirstMillisecond() {
        return this.firstMillisecond;
    }

    @Override
    public long getLastMillisecond() {
        return this.firstMillisecond + 999;
    }

    @Override
    public void peg(Calendar calendar) {
        this.firstMillisecond = this.getFirstMillisecond(calendar);
    }

    @Override
    public RegularTimePeriod previous() {
        Second second = null;
        if (this.second != 0) {
            return new Second(this.second - 1, this.getMinute());
        }
        Minute minute = (Minute)this.getMinute().previous();
        if (minute == null) return second;
        return new Second(59, minute);
    }

    @Override
    public RegularTimePeriod next() {
        Second second = null;
        if (this.second != 59) {
            return new Second(this.second + 1, this.getMinute());
        }
        Minute minute = (Minute)this.getMinute().next();
        if (minute == null) return second;
        return new Second(0, minute);
    }

    @Override
    public long getSerialIndex() {
        long l2 = this.day.getSerialIndex() * 24 + (long)this.hour;
        long l3 = l2 * 60 + (long)this.minute;
        return l3 * 60 + (long)this.second;
    }

    @Override
    public long getFirstMillisecond(Calendar calendar) {
        int n2 = this.day.getYear();
        int n3 = this.day.getMonth() - 1;
        int n4 = this.day.getDayOfMonth();
        calendar.clear();
        calendar.set(n2, n3, n4, this.hour, this.minute, this.second);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    @Override
    public long getLastMillisecond(Calendar calendar) {
        return this.getFirstMillisecond(calendar) + 999;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Second)) {
            return false;
        }
        Second second = (Second)object;
        if (this.second != second.second) {
            return false;
        }
        if (this.minute != second.minute) {
            return false;
        }
        if (this.hour != second.hour) {
            return false;
        }
        if (this.day.equals(second.day)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 17;
        n2 = 37 * n2 + this.second;
        n2 = 37 * n2 + this.minute;
        n2 = 37 * n2 + this.hour;
        return 37 * n2 + this.day.hashCode();
    }

    public int compareTo(Object object) {
        if (object instanceof Second) {
            Second second = (Second)object;
            if (this.firstMillisecond < second.firstMillisecond) {
                return -1;
            }
            if (this.firstMillisecond <= second.firstMillisecond) return 0;
            return 1;
        }
        if (!(object instanceof RegularTimePeriod)) return 1;
        return 0;
    }

    public static Second parseSecond(String string) {
        Second second = null;
        String string2 = (string = string.trim()).substring(0, Math.min(10, string.length()));
        Day day = Day.parseDay(string2);
        if (day == null) return second;
        String string3 = string.substring(Math.min(string2.length() + 1, string.length()), string.length());
        string3 = string3.trim();
        int n2 = string3.length();
        String string4 = string3.substring(0, Math.min(2, n2));
        String string5 = string3.substring(Math.min(3, n2), Math.min(5, n2));
        String string6 = string3.substring(Math.min(6, n2), Math.min(8, n2));
        int n3 = Integer.parseInt(string4);
        if (n3 < 0) return second;
        if (n3 > 23) return second;
        int n4 = Integer.parseInt(string5);
        if (n4 < 0) return second;
        if (n4 > 59) return second;
        Minute minute = new Minute(n4, new Hour(n3, day));
        int n5 = Integer.parseInt(string6);
        if (n5 < 0) return second;
        if (n5 > 59) return second;
        return new Second(n5, minute);
    }
}

