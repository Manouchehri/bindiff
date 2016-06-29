package org.jfree.data.time;

import java.io.*;
import java.util.*;

public class Year extends RegularTimePeriod implements Serializable
{
    private static final long serialVersionUID = -7659990929736074836L;
    private short year;
    private long firstMillisecond;
    private long lastMillisecond;
    
    public Year() {
        this(new Date());
    }
    
    public Year(final int n) {
        if (n < 1900 || n > 9999) {
            throw new IllegalArgumentException("Year constructor: year (" + n + ") outside valid range.");
        }
        this.year = (short)n;
        this.peg(Calendar.getInstance());
    }
    
    public Year(final Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }
    
    public Year(final Date time, final TimeZone timeZone) {
        final Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(time);
        this.year = (short)instance.get(1);
        this.peg(instance);
    }
    
    public int getYear() {
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
        if (this.year > 1900) {
            return new Year(this.year - 1);
        }
        return null;
    }
    
    public RegularTimePeriod next() {
        if (this.year < 9999) {
            return new Year(this.year + 1);
        }
        return null;
    }
    
    public long getSerialIndex() {
        return this.year;
    }
    
    public long getFirstMillisecond(final Calendar calendar) {
        calendar.set(this.year, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }
    
    public long getLastMillisecond(final Calendar calendar) {
        calendar.set(this.year, 11, 31, 23, 59, 59);
        calendar.set(14, 999);
        return calendar.getTime().getTime();
    }
    
    public boolean equals(final Object o) {
        return o != null && o instanceof Year && this.year == ((Year)o).getYear();
    }
    
    public int hashCode() {
        return 37 * 17 + this.year;
    }
    
    public int compareTo(final Object o) {
        int n;
        if (o instanceof Year) {
            n = this.year - ((Year)o).getYear();
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
        return Integer.toString(this.year);
    }
    
    public static Year parseYear(final String s) {
        int int1;
        try {
            int1 = Integer.parseInt(s.trim());
        }
        catch (NumberFormatException ex) {
            throw new TimePeriodFormatException("Cannot parse string.");
        }
        try {
            return new Year(int1);
        }
        catch (IllegalArgumentException ex2) {
            throw new TimePeriodFormatException("Year outside valid range.");
        }
    }
}
