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

public class Quarter
extends RegularTimePeriod
implements Serializable {
    private static final long serialVersionUID = 3810061714380888671L;
    public static final int FIRST_QUARTER = 1;
    public static final int LAST_QUARTER = 4;
    public static final int[] FIRST_MONTH_IN_QUARTER = new int[]{0, 1, 4, 7, 10};
    public static final int[] LAST_MONTH_IN_QUARTER = new int[]{0, 3, 6, 9, 12};
    private short year;
    private byte quarter;
    private long firstMillisecond;
    private long lastMillisecond;

    public Quarter() {
        this(new Date());
    }

    public Quarter(int n2, int n3) {
        if (n2 < 1) throw new IllegalArgumentException("Quarter outside valid range.");
        if (n2 > 4) {
            throw new IllegalArgumentException("Quarter outside valid range.");
        }
        this.year = (short)n3;
        this.quarter = (byte)n2;
        this.peg(Calendar.getInstance());
    }

    public Quarter(int n2, Year year) {
        if (n2 < 1) throw new IllegalArgumentException("Quarter outside valid range.");
        if (n2 > 4) {
            throw new IllegalArgumentException("Quarter outside valid range.");
        }
        this.year = (short)year.getYear();
        this.quarter = (byte)n2;
        this.peg(Calendar.getInstance());
    }

    public Quarter(Date date) {
        this(date, RegularTimePeriod.DEFAULT_TIME_ZONE);
    }

    public Quarter(Date date, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        int n2 = calendar.get(2) + 1;
        this.quarter = (byte)SerialDate.monthCodeToQuarter(n2);
        this.year = (short)calendar.get(1);
        this.peg(calendar);
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
        if (this.quarter > 1) {
            return new Quarter(this.quarter - 1, this.year);
        }
        if (this.year <= 1900) return null;
        return new Quarter(4, this.year - 1);
    }

    @Override
    public RegularTimePeriod next() {
        if (this.quarter < 4) {
            return new Quarter(this.quarter + 1, this.year);
        }
        if (this.year >= 9999) return null;
        return new Quarter(1, this.year + 1);
    }

    @Override
    public long getSerialIndex() {
        return (long)this.year * 4 + (long)this.quarter;
    }

    public boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof Quarter)) return false;
        Quarter quarter = (Quarter)object;
        if (this.quarter != quarter.getQuarter()) return false;
        if (this.year != quarter.getYearValue()) return false;
        return true;
    }

    public int hashCode() {
        int n2 = 17;
        n2 = 37 * n2 + this.quarter;
        return 37 * n2 + this.year;
    }

    public int compareTo(Object object) {
        if (object instanceof Quarter) {
            Quarter quarter = (Quarter)object;
            int n2 = this.year - quarter.getYearValue();
            if (n2 != 0) return n2;
            return this.quarter - quarter.getQuarter();
        }
        if (!(object instanceof RegularTimePeriod)) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("Q").append(this.quarter).append("/").append(this.year).toString();
    }

    @Override
    public long getFirstMillisecond(Calendar calendar) {
        int n2 = FIRST_MONTH_IN_QUARTER[this.quarter];
        calendar.set(this.year, n2 - 1, 1, 0, 0, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    @Override
    public long getLastMillisecond(Calendar calendar) {
        int n2 = LAST_MONTH_IN_QUARTER[this.quarter];
        int n3 = SerialDate.lastDayOfMonth(n2, this.year);
        calendar.set(this.year, n2 - 1, n3, 23, 59, 59);
        calendar.set(14, 999);
        return calendar.getTime().getTime();
    }

    public static Quarter parseQuarter(String string) {
        int n2 = string.indexOf("Q");
        if (n2 == -1) {
            throw new TimePeriodFormatException("Missing Q.");
        }
        if (n2 == string.length() - 1) {
            throw new TimePeriodFormatException("Q found at end of string.");
        }
        String string2 = string.substring(n2 + 1, n2 + 2);
        int n3 = Integer.parseInt(string2);
        String string3 = new StringBuffer().append(string.substring(0, n2)).append(string.substring(n2 + 2, string.length())).toString();
        string3 = string3.replace('/', ' ');
        string3 = string3.replace(',', ' ');
        string3 = string3.replace('-', ' ');
        Year year = Year.parseYear(string3.trim());
        return new Quarter(n3, year);
    }
}

