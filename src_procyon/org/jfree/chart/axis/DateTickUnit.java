package org.jfree.chart.axis;

import java.io.*;
import java.text.*;
import java.util.*;
import org.jfree.util.*;

public class DateTickUnit extends TickUnit implements Serializable
{
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
    private static final String[] units;
    
    public DateTickUnit(final int n, final int n2) {
        this(n, n2, null);
    }
    
    public DateTickUnit(final int n, final int n2, final DateFormat dateFormat) {
        this(n, n2, n, n2, dateFormat);
    }
    
    public DateTickUnit(final int unit, final int count, final int rollUnit, final int rollCount, final DateFormat formatter) {
        super(getMillisecondCount(unit, count));
        this.unit = unit;
        this.count = count;
        this.rollUnit = rollUnit;
        this.rollCount = rollCount;
        this.formatter = formatter;
        if (formatter == null) {
            this.formatter = DateFormat.getDateInstance(3);
        }
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
    
    public String valueToString(final double n) {
        return this.formatter.format(new Date((long)n));
    }
    
    public String dateToString(final Date date) {
        return this.formatter.format(date);
    }
    
    public Date addToDate(final Date time) {
        final Calendar instance = Calendar.getInstance();
        instance.setTime(time);
        instance.add(this.getCalendarField(this.unit), this.count);
        return instance.getTime();
    }
    
    public Date rollDate(final Date time) {
        final Calendar instance = Calendar.getInstance();
        instance.setTime(time);
        instance.add(this.getCalendarField(this.rollUnit), this.rollCount);
        return instance.getTime();
    }
    
    public int getCalendarField() {
        return this.getCalendarField(this.unit);
    }
    
    private int getCalendarField(final int n) {
        switch (n) {
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
            default: {
                return 14;
            }
        }
    }
    
    private static long getMillisecondCount(final int n, final int n2) {
        switch (n) {
            case 0: {
                return 31536000000L * n2;
            }
            case 1: {
                return 2678400000L * n2;
            }
            case 2: {
                return 86400000L * n2;
            }
            case 3: {
                return 3600000L * n2;
            }
            case 4: {
                return 60000L * n2;
            }
            case 5: {
                return 1000L * n2;
            }
            case 6: {
                return n2;
            }
            default: {
                throw new IllegalArgumentException("DateTickUnit.getMillisecondCount() : unit must be one of the constants YEAR, MONTH, DAY, HOUR, MINUTE, SECOND or MILLISECOND defined in the DateTickUnit class. Do *not* use the constants defined in java.util.Calendar.");
            }
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DateTickUnit)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final DateTickUnit dateTickUnit = (DateTickUnit)o;
        return this.unit == dateTickUnit.unit && this.count == dateTickUnit.count && ObjectUtilities.equal(this.formatter, dateTickUnit.formatter);
    }
    
    public int hashCode() {
        return 37 * (37 * (37 * 19 + this.unit) + this.count) + this.formatter.hashCode();
    }
    
    public String toString() {
        return "DateTickUnit[" + DateTickUnit.units[this.unit] + ", " + this.count + "]";
    }
    
    static {
        units = new String[] { "YEAR", "MONTH", "DAY", "HOUR", "MINUTE", "SECOND", "MILLISECOND" };
    }
}
