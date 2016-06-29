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

public class Year
extends RegularTimePeriod
implements Serializable {
    private static final long serialVersionUID = -7659990929736074836L;
    private short year;
    private long firstMillisecond;
    private long lastMillisecond;

    public Year() {
        this(new Date());
    }

    public Year(int n2) {
        if (n2 < 1900) throw new IllegalArgumentException(new StringBuffer().append("Year constructor: year (").append(n2).append(") outside valid range.").toString());
        if (n2 > 9999) {
            throw new IllegalArgumentException(new StringBuffer().append("Year constructor: year (").append(n2).append(") outside valid range.").toString());
        }
        this.year = (short)n2;
        this.peg(Calendar.getInstance());
    }

    public Year(Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }

    public Year(Date date, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        this.year = (short)calendar.get(1);
        this.peg(calendar);
    }

    public int getYear() {
        return this.year;
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
        if (this.year <= 1900) return null;
        return new Year(this.year - 1);
    }

    @Override
    public RegularTimePeriod next() {
        if (this.year >= 9999) return null;
        return new Year(this.year + 1);
    }

    @Override
    public long getSerialIndex() {
        return this.year;
    }

    @Override
    public long getFirstMillisecond(Calendar calendar) {
        calendar.set(this.year, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    @Override
    public long getLastMillisecond(Calendar calendar) {
        calendar.set(this.year, 11, 31, 23, 59, 59);
        calendar.set(14, 999);
        return calendar.getTime().getTime();
    }

    public boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof Year)) return false;
        Year year = (Year)object;
        if (this.year != year.getYear()) return false;
        return true;
    }

    public int hashCode() {
        int n2 = 17;
        short s2 = this.year;
        return 37 * n2 + s2;
    }

    public int compareTo(Object object) {
        if (object instanceof Year) {
            Year year = (Year)object;
            return this.year - year.getYear();
        }
        if (!(object instanceof RegularTimePeriod)) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return Integer.toString(this.year);
    }

    public static Year parseYear(String string) {
        int n2;
        try {
            n2 = Integer.parseInt(string.trim());
        }
        catch (NumberFormatException var2_2) {
            throw new TimePeriodFormatException("Cannot parse string.");
        }
        try {
            return new Year(n2);
        }
        catch (IllegalArgumentException var2_3) {
            throw new TimePeriodFormatException("Year outside valid range.");
        }
    }
}

