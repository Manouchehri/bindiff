/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.date.SerialDate;

public class Day
extends RegularTimePeriod
implements Serializable {
    private static final long serialVersionUID = -7082667380758962755L;
    protected static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    protected static final DateFormat DATE_FORMAT_SHORT = DateFormat.getDateInstance(3);
    protected static final DateFormat DATE_FORMAT_MEDIUM = DateFormat.getDateInstance(2);
    protected static final DateFormat DATE_FORMAT_LONG = DateFormat.getDateInstance(1);
    private SerialDate serialDate;
    private long firstMillisecond;
    private long lastMillisecond;

    public Day() {
        this(new Date());
    }

    public Day(int n2, int n3, int n4) {
        this.serialDate = SerialDate.createInstance(n2, n3, n4);
        this.peg(Calendar.getInstance());
    }

    public Day(SerialDate serialDate) {
        if (serialDate == null) {
            throw new IllegalArgumentException("Null 'serialDate' argument.");
        }
        this.serialDate = serialDate;
        this.peg(Calendar.getInstance());
    }

    public Day(Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }

    public Day(Date date, TimeZone timeZone) {
        if (date == null) {
            throw new IllegalArgumentException("Null 'time' argument.");
        }
        if (timeZone == null) {
            throw new IllegalArgumentException("Null 'zone' argument.");
        }
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        int n2 = calendar.get(5);
        int n3 = calendar.get(2) + 1;
        int n4 = calendar.get(1);
        this.serialDate = SerialDate.createInstance(n2, n3, n4);
        this.peg(calendar);
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
        int n2 = this.serialDate.toSerial();
        if (n2 <= 2) return null;
        SerialDate serialDate = SerialDate.createInstance(n2 - 1);
        return new Day(serialDate);
    }

    @Override
    public RegularTimePeriod next() {
        int n2 = this.serialDate.toSerial();
        if (n2 >= 2958465) return null;
        SerialDate serialDate = SerialDate.createInstance(n2 + 1);
        return new Day(serialDate);
    }

    @Override
    public long getSerialIndex() {
        return this.serialDate.toSerial();
    }

    @Override
    public long getFirstMillisecond(Calendar calendar) {
        int n2 = this.serialDate.getYYYY();
        int n3 = this.serialDate.getMonth();
        int n4 = this.serialDate.getDayOfMonth();
        calendar.clear();
        calendar.set(n2, n3 - 1, n4, 0, 0, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    @Override
    public long getLastMillisecond(Calendar calendar) {
        int n2 = this.serialDate.getYYYY();
        int n3 = this.serialDate.getMonth();
        int n4 = this.serialDate.getDayOfMonth();
        calendar.clear();
        calendar.set(n2, n3 - 1, n4, 23, 59, 59);
        calendar.set(14, 999);
        return calendar.getTime().getTime();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Day)) {
            return false;
        }
        Day day = (Day)object;
        if (this.serialDate.equals(day.getSerialDate())) return true;
        return false;
    }

    public int hashCode() {
        return this.serialDate.hashCode();
    }

    public int compareTo(Object object) {
        if (object instanceof Day) {
            Day day = (Day)object;
            return - day.getSerialDate().compare(this.serialDate);
        }
        if (!(object instanceof RegularTimePeriod)) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return this.serialDate.toString();
    }

    public static Day parseDay(String string) {
        try {
            return new Day(DATE_FORMAT.parse(string));
        }
        catch (ParseException var1_1) {
            try {
                return new Day(DATE_FORMAT_SHORT.parse(string));
            }
            catch (ParseException var2_2) {
                return null;
            }
        }
    }
}

