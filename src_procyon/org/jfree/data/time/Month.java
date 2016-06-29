package org.jfree.data.time;

import java.io.*;
import java.util.*;
import org.jfree.date.*;

public class Month extends RegularTimePeriod implements Serializable
{
    private static final long serialVersionUID = -5090216912548722570L;
    private int month;
    private int year;
    private long firstMillisecond;
    private long lastMillisecond;
    
    public Month() {
        this(new Date());
    }
    
    public Month(final int month, final int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month outside valid range.");
        }
        this.month = month;
        this.year = year;
        this.peg(Calendar.getInstance());
    }
    
    public Month(final int month, final Year year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month outside valid range.");
        }
        this.month = month;
        this.year = year.getYear();
        this.peg(Calendar.getInstance());
    }
    
    public Month(final Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }
    
    public Month(final Date time, final TimeZone timeZone) {
        final Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(time);
        this.month = instance.get(2) + 1;
        this.year = instance.get(1);
        this.peg(Calendar.getInstance());
    }
    
    public Year getYear() {
        return new Year(this.year);
    }
    
    public int getYearValue() {
        return this.year;
    }
    
    public int getMonth() {
        return this.month;
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
        Month month;
        if (this.month != 1) {
            month = new Month(this.month - 1, this.year);
        }
        else if (this.year > 1900) {
            month = new Month(12, this.year - 1);
        }
        else {
            month = null;
        }
        return month;
    }
    
    public RegularTimePeriod next() {
        Month month;
        if (this.month != 12) {
            month = new Month(this.month + 1, this.year);
        }
        else if (this.year < 9999) {
            month = new Month(1, this.year + 1);
        }
        else {
            month = null;
        }
        return month;
    }
    
    public long getSerialIndex() {
        return this.year * 12L + this.month;
    }
    
    public String toString() {
        return SerialDate.monthCodeToString(this.month) + " " + this.year;
    }
    
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Month) {
            final Month month = (Month)o;
            return this.month == month.getMonth() && this.year == month.getYearValue();
        }
        return false;
    }
    
    public int hashCode() {
        return 37 * (37 * 17 + this.month) + this.year;
    }
    
    public int compareTo(final Object o) {
        int n;
        if (o instanceof Month) {
            final Month month = (Month)o;
            n = this.year - month.getYearValue();
            if (n == 0) {
                n = this.month - month.getMonth();
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
    
    public long getFirstMillisecond(final Calendar calendar) {
        calendar.set(this.year, this.month - 1, 1, 0, 0, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }
    
    public long getLastMillisecond(final Calendar calendar) {
        calendar.set(this.year, this.month - 1, SerialDate.lastDayOfMonth(this.month, this.year), 23, 59, 59);
        calendar.set(14, 999);
        return calendar.getTime().getTime();
    }
    
    public static Month parseMonth(String trim) {
        Month month = null;
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
                final int stringToMonthCode = SerialDate.stringToMonthCode(trim3);
                if (stringToMonthCode == -1) {
                    throw new TimePeriodFormatException("Can't evaluate the month.");
                }
                month = new Month(stringToMonthCode, evaluateAsYear);
            }
            else {
                final Year evaluateAsYear2 = evaluateAsYear(trim3);
                if (evaluateAsYear2 == null) {
                    throw new TimePeriodFormatException("Can't evaluate the year.");
                }
                final int stringToMonthCode2 = SerialDate.stringToMonthCode(trim2);
                if (stringToMonthCode2 == -1) {
                    throw new TimePeriodFormatException("Can't evaluate the month.");
                }
                month = new Month(stringToMonthCode2, evaluateAsYear2);
            }
        }
        return month;
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
}
