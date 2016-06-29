package org.jfree.data.time;

import java.io.*;
import java.util.*;
import org.jfree.date.*;

public class Quarter extends RegularTimePeriod implements Serializable
{
    private static final long serialVersionUID = 3810061714380888671L;
    public static final int FIRST_QUARTER = 1;
    public static final int LAST_QUARTER = 4;
    public static final int[] FIRST_MONTH_IN_QUARTER;
    public static final int[] LAST_MONTH_IN_QUARTER;
    private short year;
    private byte quarter;
    private long firstMillisecond;
    private long lastMillisecond;
    
    public Quarter() {
        this(new Date());
    }
    
    public Quarter(final int n, final int n2) {
        if (n < 1 || n > 4) {
            throw new IllegalArgumentException("Quarter outside valid range.");
        }
        this.year = (short)n2;
        this.quarter = (byte)n;
        this.peg(Calendar.getInstance());
    }
    
    public Quarter(final int n, final Year year) {
        if (n < 1 || n > 4) {
            throw new IllegalArgumentException("Quarter outside valid range.");
        }
        this.year = (short)year.getYear();
        this.quarter = (byte)n;
        this.peg(Calendar.getInstance());
    }
    
    public Quarter(final Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }
    
    public Quarter(final Date time, final TimeZone timeZone) {
        final Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(time);
        this.quarter = (byte)SerialDate.monthCodeToQuarter(instance.get(2) + 1);
        this.year = (short)instance.get(1);
        this.peg(instance);
    }
    
    public int getQuarter() {
        return this.quarter;
    }
    
    public Year getYear() {
        return new Year(this.year);
    }
    
    public int getYearValue() {
        return this.year;
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
        Quarter quarter;
        if (this.quarter > 1) {
            quarter = new Quarter(this.quarter - 1, this.year);
        }
        else if (this.year > 1900) {
            quarter = new Quarter(4, this.year - 1);
        }
        else {
            quarter = null;
        }
        return quarter;
    }
    
    public RegularTimePeriod next() {
        Quarter quarter;
        if (this.quarter < 4) {
            quarter = new Quarter(this.quarter + 1, this.year);
        }
        else if (this.year < 9999) {
            quarter = new Quarter(1, this.year + 1);
        }
        else {
            quarter = null;
        }
        return quarter;
    }
    
    public long getSerialIndex() {
        return this.year * 4L + this.quarter;
    }
    
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Quarter) {
            final Quarter quarter = (Quarter)o;
            return this.quarter == quarter.getQuarter() && this.year == quarter.getYearValue();
        }
        return false;
    }
    
    public int hashCode() {
        return 37 * (37 * 17 + this.quarter) + this.year;
    }
    
    public int compareTo(final Object o) {
        int n;
        if (o instanceof Quarter) {
            final Quarter quarter = (Quarter)o;
            n = this.year - quarter.getYearValue();
            if (n == 0) {
                n = this.quarter - quarter.getQuarter();
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
    
    public String toString() {
        return "Q" + this.quarter + "/" + this.year;
    }
    
    public long getFirstMillisecond(final Calendar calendar) {
        calendar.set(this.year, Quarter.FIRST_MONTH_IN_QUARTER[this.quarter] - 1, 1, 0, 0, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }
    
    public long getLastMillisecond(final Calendar calendar) {
        final int n = Quarter.LAST_MONTH_IN_QUARTER[this.quarter];
        calendar.set(this.year, n - 1, SerialDate.lastDayOfMonth(n, this.year), 23, 59, 59);
        calendar.set(14, 999);
        return calendar.getTime().getTime();
    }
    
    public static Quarter parseQuarter(final String s) {
        final int index = s.indexOf("Q");
        if (index == -1) {
            throw new TimePeriodFormatException("Missing Q.");
        }
        if (index == s.length() - 1) {
            throw new TimePeriodFormatException("Q found at end of string.");
        }
        return new Quarter(Integer.parseInt(s.substring(index + 1, index + 2)), Year.parseYear((s.substring(0, index) + s.substring(index + 2, s.length())).replace('/', ' ').replace(',', ' ').replace('-', ' ').trim()));
    }
    
    static {
        FIRST_MONTH_IN_QUARTER = new int[] { 0, 1, 4, 7, 10 };
        LAST_MONTH_IN_QUARTER = new int[] { 0, 3, 6, 9, 12 };
    }
}
