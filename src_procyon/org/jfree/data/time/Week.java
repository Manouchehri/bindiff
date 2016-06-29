package org.jfree.data.time;

import java.io.*;
import java.util.*;

public class Week extends RegularTimePeriod implements Serializable
{
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
    
    public Week(final int n, final int n2) {
        if (n < 1 && n > 53) {
            throw new IllegalArgumentException("The 'week' argument must be in the range 1 - 53.");
        }
        this.week = (byte)n;
        this.year = (short)n2;
        this.peg(Calendar.getInstance());
    }
    
    public Week(final int n, final Year year) {
        if (n < 1 && n > 53) {
            throw new IllegalArgumentException("The 'week' argument must be in the range 1 - 53.");
        }
        this.week = (byte)n;
        this.year = (short)year.getYear();
        this.peg(Calendar.getInstance());
    }
    
    public Week(final Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }
    
    public Week(final Date time, final TimeZone timeZone) {
        if (time == null) {
            throw new IllegalArgumentException("Null 'time' argument.");
        }
        if (timeZone == null) {
            throw new IllegalArgumentException("Null 'zone' argument.");
        }
        final Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(time);
        final int value = instance.get(3);
        if (value == 1 && instance.get(2) == 11) {
            this.week = 1;
            this.year = (short)(instance.get(1) + 1);
        }
        else {
            this.week = (byte)Math.min(value, 53);
            int value2 = instance.get(1);
            if (instance.get(2) == 0 && this.week >= 52) {
                --value2;
            }
            this.year = (short)value2;
        }
        this.peg(instance);
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
        Week week;
        if (this.week != 1) {
            week = new Week(this.week - 1, this.year);
        }
        else if (this.year > 1900) {
            final short n = (short)(this.year - 1);
            final Calendar instance = Calendar.getInstance();
            instance.set(n, 11, 31);
            week = new Week(instance.getActualMaximum(3), n);
        }
        else {
            week = null;
        }
        return week;
    }
    
    public RegularTimePeriod next() {
        Week week;
        if (this.week < 52) {
            week = new Week(this.week + 1, this.year);
        }
        else {
            final Calendar instance = Calendar.getInstance();
            instance.set(this.year, 11, 31);
            if (this.week < instance.getActualMaximum(3)) {
                week = new Week(this.week + 1, this.year);
            }
            else if (this.year < 9999) {
                week = new Week(1, this.year + 1);
            }
            else {
                week = null;
            }
        }
        return week;
    }
    
    public long getSerialIndex() {
        return this.year * 53L + this.week;
    }
    
    public long getFirstMillisecond(final Calendar calendar) {
        final Calendar calendar2 = (Calendar)calendar.clone();
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
    
    public long getLastMillisecond(final Calendar calendar) {
        final Calendar calendar2 = (Calendar)calendar.clone();
        calendar2.clear();
        calendar2.set(1, this.year);
        calendar2.set(3, this.week + 1);
        calendar2.set(7, calendar2.getFirstDayOfWeek());
        calendar2.set(10, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        return calendar2.getTime().getTime() - 1L;
    }
    
    public String toString() {
        return "Week " + this.week + ", " + this.year;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Week)) {
            return false;
        }
        final Week week = (Week)o;
        return this.week == week.week && this.year == week.year;
    }
    
    public int hashCode() {
        return 37 * (37 * 17 + this.week) + this.year;
    }
    
    public int compareTo(final Object o) {
        int n;
        if (o instanceof Week) {
            final Week week = (Week)o;
            n = this.year - week.getYear().getYear();
            if (n == 0) {
                n = this.week - week.getWeek();
            }
        }
        else if (o instanceof RegularTimePeriod) {
            n = 0;
        }
        else {
            n = 1;
        }
        return n;
    }
    
    public static Week parseWeek(String trim) {
        Week week = null;
        if (trim != null) {
            trim = trim.trim();
            final int separator = findSeparator(trim);
            if (separator == -1) {
                throw new TimePeriodFormatException("Could not find separator.");
            }
            final String trim2 = trim.substring(0, separator).trim();
            final String trim3 = trim.substring(separator + 1, trim.length()).trim();
            final Year evaluateAsYear = evaluateAsYear(trim2);
            if (evaluateAsYear != null) {
                final int stringToWeek = stringToWeek(trim3);
                if (stringToWeek == -1) {
                    throw new TimePeriodFormatException("Can't evaluate the week.");
                }
                week = new Week(stringToWeek, evaluateAsYear);
            }
            else {
                final Year evaluateAsYear2 = evaluateAsYear(trim3);
                if (evaluateAsYear2 == null) {
                    throw new TimePeriodFormatException("Can't evaluate the year.");
                }
                final int stringToWeek2 = stringToWeek(trim2);
                if (stringToWeek2 == -1) {
                    throw new TimePeriodFormatException("Can't evaluate the week.");
                }
                week = new Week(stringToWeek2, evaluateAsYear2);
            }
        }
        return week;
    }
    
    private static int findSeparator(final String s) {
        int n = s.indexOf(45);
        if (n == -1) {
            n = s.indexOf(44);
        }
        if (n == -1) {
            n = s.indexOf(32);
        }
        if (n == -1) {
            n = s.indexOf(46);
        }
        return n;
    }
    
    private static Year evaluateAsYear(final String s) {
        Year year = null;
        try {
            year = Year.parseYear(s);
        }
        catch (TimePeriodFormatException ex) {}
        return year;
    }
    
    private static int stringToWeek(String s) {
        int int1 = -1;
        s = s.replace('W', ' ');
        s = s.trim();
        try {
            int1 = Integer.parseInt(s);
            if (int1 < 1 || int1 > 53) {
                int1 = -1;
            }
        }
        catch (NumberFormatException ex) {}
        return int1;
    }
}
