/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriodFormatException;
import org.jfree.data.time.Year;

public class Week
extends RegularTimePeriod
implements Serializable {
    private static final long serialVersionUID = 1856387786939865061L;
    public static final int FIRST_WEEK_IN_YEAR = 1;
    public static final int LAST_WEEK_IN_YEAR = 53;
    private short year;
    private byte week;
    private long firstMillisecond;
    private long lastMillisecond;

    public Week() {
        this(new Date());
    }

    public Week(int n2, int n3) {
        if (n2 < 1 && n2 > 53) {
            throw new IllegalArgumentException("The 'week' argument must be in the range 1 - 53.");
        }
        this.week = (byte)n2;
        this.year = (short)n3;
        this.peg(Calendar.getInstance());
    }

    public Week(int n2, Year year) {
        if (n2 < 1 && n2 > 53) {
            throw new IllegalArgumentException("The 'week' argument must be in the range 1 - 53.");
        }
        this.week = (byte)n2;
        this.year = (short)year.getYear();
        this.peg(Calendar.getInstance());
    }

    public Week(Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }

    public Week(Date date, TimeZone timeZone) {
        if (date == null) {
            throw new IllegalArgumentException("Null 'time' argument.");
        }
        if (timeZone == null) {
            throw new IllegalArgumentException("Null 'zone' argument.");
        }
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        int n2 = calendar.get(3);
        if (n2 == 1 && calendar.get(2) == 11) {
            this.week = 1;
            this.year = (short)(calendar.get(1) + 1);
        } else {
            this.week = (byte)Math.min(n2, 53);
            int n3 = calendar.get(1);
            if (calendar.get(2) == 0 && this.week >= 52) {
                --n3;
            }
            this.year = (short)n3;
        }
        this.peg(calendar);
    }

    public Year getYear() {
        return new Year(this.year);
    }

    public int getYearValue() {
        return this.year;
    }

    public int getWeek() {
        return this.week;
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
        if (this.week != 1) {
            return new Week(this.week - 1, this.year);
        }
        if (this.year <= 1900) return null;
        int n2 = this.year - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(n2, 11, 31);
        return new Week(calendar.getActualMaximum(3), n2);
    }

    @Override
    public RegularTimePeriod next() {
        if (this.week < 52) {
            return new Week(this.week + 1, this.year);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.year, 11, 31);
        int n2 = calendar.getActualMaximum(3);
        if (this.week < n2) {
            return new Week(this.week + 1, this.year);
        }
        if (this.year >= 9999) return null;
        return new Week(1, this.year + 1);
    }

    @Override
    public long getSerialIndex() {
        return (long)this.year * 53 + (long)this.week;
    }

    @Override
    public long getFirstMillisecond(Calendar calendar) {
        Calendar calendar2 = (Calendar)calendar.clone();
        calendar2.clear();
        calendar2.set(1, this.year);
        calendar2.set(3, this.week);
        calendar2.set(7, calendar2.getFirstDayOfWeek());
        calendar2.set(10, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        return calendar2.getTime().getTime();
    }

    @Override
    public long getLastMillisecond(Calendar calendar) {
        Calendar calendar2 = (Calendar)calendar.clone();
        calendar2.clear();
        calendar2.set(1, this.year);
        calendar2.set(3, this.week + 1);
        calendar2.set(7, calendar2.getFirstDayOfWeek());
        calendar2.set(10, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        return calendar2.getTime().getTime() - 1;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("Week ").append(this.week).append(", ").append(this.year).toString();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Week)) {
            return false;
        }
        Week week = (Week)object;
        if (this.week != week.week) {
            return false;
        }
        if (this.year == week.year) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 17;
        n2 = 37 * n2 + this.week;
        return 37 * n2 + this.year;
    }

    public int compareTo(Object object) {
        if (object instanceof Week) {
            Week week = (Week)object;
            int n2 = this.year - week.getYear().getYear();
            if (n2 != 0) return n2;
            return this.week - week.getWeek();
        }
        if (!(object instanceof RegularTimePeriod)) return 1;
        return 0;
    }

    public static Week parseWeek(String string) {
        Week week = null;
        if (string == null) return week;
        int n2 = Week.findSeparator(string = string.trim());
        if (n2 == -1) throw new TimePeriodFormatException("Could not find separator.");
        String string2 = string.substring(0, n2).trim();
        String string3 = string.substring(n2 + 1, string.length()).trim();
        Year year = Week.evaluateAsYear(string2);
        if (year != null) {
            int n3 = Week.stringToWeek(string3);
            if (n3 != -1) return new Week(n3, year);
            throw new TimePeriodFormatException("Can't evaluate the week.");
        }
        year = Week.evaluateAsYear(string3);
        if (year == null) throw new TimePeriodFormatException("Can't evaluate the year.");
        int n4 = Week.stringToWeek(string2);
        if (n4 != -1) return new Week(n4, year);
        throw new TimePeriodFormatException("Can't evaluate the week.");
    }

    private static int findSeparator(String string) {
        int n2 = string.indexOf(45);
        if (n2 == -1) {
            n2 = string.indexOf(44);
        }
        if (n2 == -1) {
            n2 = string.indexOf(32);
        }
        if (n2 != -1) return n2;
        return string.indexOf(46);
    }

    private static Year evaluateAsYear(String string) {
        Year year = null;
        try {
            return Year.parseYear(string);
        }
        catch (TimePeriodFormatException var2_2) {
            // empty catch block
        }
        return year;
    }

    private static int stringToWeek(String string) {
        int n2 = -1;
        string = string.replace('W', ' ');
        string = string.trim();
        try {
            n2 = Integer.parseInt(string);
            if (n2 < 1) return -1;
            if (n2 <= 53) return n2;
            return -1;
        }
        catch (NumberFormatException var2_2) {
            // empty catch block
        }
        return n2;
    }
}

