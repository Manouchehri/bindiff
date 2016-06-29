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
import org.jfree.date.SerialDate;

public class Month
extends RegularTimePeriod
implements Serializable {
    private static final long serialVersionUID = -5090216912548722570L;
    private int month;
    private int year;
    private long firstMillisecond;
    private long lastMillisecond;

    public Month() {
        this(new Date());
    }

    public Month(int n2, int n3) {
        if (n2 < 1) throw new IllegalArgumentException("Month outside valid range.");
        if (n2 > 12) {
            throw new IllegalArgumentException("Month outside valid range.");
        }
        this.month = n2;
        this.year = n3;
        this.peg(Calendar.getInstance());
    }

    public Month(int n2, Year year) {
        if (n2 < 1) throw new IllegalArgumentException("Month outside valid range.");
        if (n2 > 12) {
            throw new IllegalArgumentException("Month outside valid range.");
        }
        this.month = n2;
        this.year = year.getYear();
        this.peg(Calendar.getInstance());
    }

    public Month(Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }

    public Month(Date date, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        this.month = calendar.get(2) + 1;
        this.year = calendar.get(1);
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
        if (this.month != 1) {
            return new Month(this.month - 1, this.year);
        }
        if (this.year <= 1900) return null;
        return new Month(12, this.year - 1);
    }

    @Override
    public RegularTimePeriod next() {
        if (this.month != 12) {
            return new Month(this.month + 1, this.year);
        }
        if (this.year >= 9999) return null;
        return new Month(1, this.year + 1);
    }

    @Override
    public long getSerialIndex() {
        return (long)this.year * 12 + (long)this.month;
    }

    @Override
    public String toString() {
        return new StringBuffer().append(SerialDate.monthCodeToString(this.month)).append(" ").append(this.year).toString();
    }

    public boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof Month)) return false;
        Month month = (Month)object;
        if (this.month != month.getMonth()) return false;
        if (this.year != month.getYearValue()) return false;
        return true;
    }

    public int hashCode() {
        int n2 = 17;
        n2 = 37 * n2 + this.month;
        return 37 * n2 + this.year;
    }

    public int compareTo(Object object) {
        if (object instanceof Month) {
            Month month = (Month)object;
            int n2 = this.year - month.getYearValue();
            if (n2 != 0) return n2;
            return this.month - month.getMonth();
        }
        if (!(object instanceof RegularTimePeriod)) return 1;
        return 0;
    }

    @Override
    public long getFirstMillisecond(Calendar calendar) {
        calendar.set(this.year, this.month - 1, 1, 0, 0, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    @Override
    public long getLastMillisecond(Calendar calendar) {
        int n2 = SerialDate.lastDayOfMonth(this.month, this.year);
        calendar.set(this.year, this.month - 1, n2, 23, 59, 59);
        calendar.set(14, 999);
        return calendar.getTime().getTime();
    }

    public static Month parseMonth(String string) {
        Month month = null;
        if (string == null) return month;
        int n2 = Month.findSeparator(string = string.trim());
        if (n2 == -1) throw new TimePeriodFormatException("Could not find separator.");
        String string2 = string.substring(0, n2).trim();
        String string3 = string.substring(n2 + 1, string.length()).trim();
        Year year = Month.evaluateAsYear(string2);
        if (year != null) {
            int n3 = SerialDate.stringToMonthCode(string3);
            if (n3 != -1) return new Month(n3, year);
            throw new TimePeriodFormatException("Can't evaluate the month.");
        }
        year = Month.evaluateAsYear(string3);
        if (year == null) throw new TimePeriodFormatException("Can't evaluate the year.");
        int n4 = SerialDate.stringToMonthCode(string2);
        if (n4 != -1) return new Month(n4, year);
        throw new TimePeriodFormatException("Can't evaluate the month.");
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
}

