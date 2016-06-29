package org.jfree.data.time;

import java.io.*;
import org.jfree.date.*;
import java.util.*;
import java.text.*;

public class Day extends RegularTimePeriod implements Serializable
{
    private static final long serialVersionUID = -7082667380758962755L;
    protected static final DateFormat DATE_FORMAT;
    protected static final DateFormat DATE_FORMAT_SHORT;
    protected static final DateFormat DATE_FORMAT_MEDIUM;
    protected static final DateFormat DATE_FORMAT_LONG;
    private SerialDate serialDate;
    private long firstMillisecond;
    private long lastMillisecond;
    
    public Day() {
        this(new Date());
    }
    
    public Day(final int n, final int n2, final int n3) {
        this.serialDate = SerialDate.createInstance(n, n2, n3);
        this.peg(Calendar.getInstance());
    }
    
    public Day(final SerialDate serialDate) {
        if (serialDate == null) {
            throw new IllegalArgumentException("Null 'serialDate' argument.");
        }
        this.serialDate = serialDate;
        this.peg(Calendar.getInstance());
    }
    
    public Day(final Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }
    
    public Day(final Date time, final TimeZone timeZone) {
        if (time == null) {
            throw new IllegalArgumentException("Null 'time' argument.");
        }
        if (timeZone == null) {
            throw new IllegalArgumentException("Null 'zone' argument.");
        }
        final Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(time);
        this.serialDate = SerialDate.createInstance(instance.get(5), instance.get(2) + 1, instance.get(1));
        this.peg(instance);
    }
    
    public SerialDate getSerialDate() {
        return this.serialDate;
    }
    
    public int getYear() {
        return this.serialDate.getYYYY();
    }
    
    public int getMonth() {
        return this.serialDate.getMonth();
    }
    
    public int getDayOfMonth() {
        return this.serialDate.getDayOfMonth();
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
        final int serial = this.serialDate.toSerial();
        if (serial > 2) {
            return new Day(SerialDate.createInstance(serial - 1));
        }
        return null;
    }
    
    public RegularTimePeriod next() {
        final int serial = this.serialDate.toSerial();
        if (serial < 2958465) {
            return new Day(SerialDate.createInstance(serial + 1));
        }
        return null;
    }
    
    public long getSerialIndex() {
        return this.serialDate.toSerial();
    }
    
    public long getFirstMillisecond(final Calendar calendar) {
        final int yyyy = this.serialDate.getYYYY();
        final int month = this.serialDate.getMonth();
        final int dayOfMonth = this.serialDate.getDayOfMonth();
        calendar.clear();
        calendar.set(yyyy, month - 1, dayOfMonth, 0, 0, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }
    
    public long getLastMillisecond(final Calendar calendar) {
        final int yyyy = this.serialDate.getYYYY();
        final int month = this.serialDate.getMonth();
        final int dayOfMonth = this.serialDate.getDayOfMonth();
        calendar.clear();
        calendar.set(yyyy, month - 1, dayOfMonth, 23, 59, 59);
        calendar.set(14, 999);
        return calendar.getTime().getTime();
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof Day && this.serialDate.equals(((Day)o).getSerialDate()));
    }
    
    public int hashCode() {
        return this.serialDate.hashCode();
    }
    
    public int compareTo(final Object o) {
        int n;
        if (o instanceof Day) {
            n = -((Day)o).getSerialDate().compare(this.serialDate);
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
        return this.serialDate.toString();
    }
    
    public static Day parseDay(final String s) {
        try {
            return new Day(Day.DATE_FORMAT.parse(s));
        }
        catch (ParseException ex) {
            try {
                return new Day(Day.DATE_FORMAT_SHORT.parse(s));
            }
            catch (ParseException ex2) {
                return null;
            }
        }
    }
    
    static {
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        DATE_FORMAT_SHORT = DateFormat.getDateInstance(3);
        DATE_FORMAT_MEDIUM = DateFormat.getDateInstance(2);
        DATE_FORMAT_LONG = DateFormat.getDateInstance(1);
    }
}
