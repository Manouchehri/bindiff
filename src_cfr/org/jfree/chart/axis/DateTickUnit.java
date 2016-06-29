/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import org.jfree.chart.axis.TickUnit;
import org.jfree.util.ObjectUtilities;

public class DateTickUnit
extends TickUnit
implements Serializable {
    private static final long serialVersionUID = -7289292157229621901L;
    public static final int YEAR = 0;
    public static final int MONTH = 1;
    public static final int DAY = 2;
    public static final int HOUR = 3;
    public static final int MINUTE = 4;
    public static final int SECOND = 5;
    public static final int MILLISECOND = 6;
    private int unit;
    private int count;
    private int rollUnit;
    private int rollCount;
    private DateFormat formatter;
    private static final String[] units = new String[]{"YEAR", "MONTH", "DAY", "HOUR", "MINUTE", "SECOND", "MILLISECOND"};

    public DateTickUnit(int n2, int n3) {
        this(n2, n3, null);
    }

    public DateTickUnit(int n2, int n3, DateFormat dateFormat) {
        this(n2, n3, n2, n3, dateFormat);
    }

    public DateTickUnit(int n2, int n3, int n4, int n5, DateFormat dateFormat) {
        super(DateTickUnit.getMillisecondCount(n2, n3));
        this.unit = n2;
        this.count = n3;
        this.rollUnit = n4;
        this.rollCount = n5;
        this.formatter = dateFormat;
        if (dateFormat != null) return;
        this.formatter = DateFormat.getDateInstance(3);
    }

    public int getUnit() {
        return this.unit;
    }

    public int getCount() {
        return this.count;
    }

    public int getRollUnit() {
        return this.rollUnit;
    }

    public int getRollCount() {
        return this.rollCount;
    }

    @Override
    public String valueToString(double d2) {
        return this.formatter.format(new Date((long)d2));
    }

    public String dateToString(Date date) {
        return this.formatter.format(date);
    }

    public Date addToDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(this.getCalendarField(this.unit), this.count);
        return calendar.getTime();
    }

    public Date rollDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(this.getCalendarField(this.rollUnit), this.rollCount);
        return calendar.getTime();
    }

    public int getCalendarField() {
        return this.getCalendarField(this.unit);
    }

    private int getCalendarField(int n2) {
        switch (n2) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 5;
            }
            case 3: {
                return 11;
            }
            case 4: {
                return 12;
            }
            case 5: {
                return 13;
            }
            case 6: {
                return 14;
            }
        }
        return 14;
    }

    private static long getMillisecondCount(int n2, int n3) {
        switch (n2) {
            case 0: {
                return 31536000000L * (long)n3;
            }
            case 1: {
                return 2678400000L * (long)n3;
            }
            case 2: {
                return 86400000 * (long)n3;
            }
            case 3: {
                return 3600000 * (long)n3;
            }
            case 4: {
                return 60000 * (long)n3;
            }
            case 5: {
                return 1000 * (long)n3;
            }
            case 6: {
                return n3;
            }
        }
        throw new IllegalArgumentException("DateTickUnit.getMillisecondCount() : unit must be one of the constants YEAR, MONTH, DAY, HOUR, MINUTE, SECOND or MILLISECOND defined in the DateTickUnit class. Do *not* use the constants defined in java.util.Calendar.");
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof DateTickUnit)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        DateTickUnit dateTickUnit = (DateTickUnit)object;
        if (this.unit != dateTickUnit.unit) {
            return false;
        }
        if (this.count != dateTickUnit.count) {
            return false;
        }
        if (ObjectUtilities.equal(this.formatter, dateTickUnit.formatter)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int n2 = 19;
        n2 = 37 * n2 + this.unit;
        n2 = 37 * n2 + this.count;
        return 37 * n2 + this.formatter.hashCode();
    }

    public String toString() {
        return new StringBuffer().append("DateTickUnit[").append(units[this.unit]).append(", ").append(this.count).append("]").toString();
    }
}

