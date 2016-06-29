package org.jfree.chart.axis;

import java.io.*;
import java.text.*;
import java.util.*;

public class QuarterDateFormat extends DateFormat implements Serializable, Cloneable
{
    private static final long serialVersionUID = -6738465248529797176L;
    public static final String[] REGULAR_QUARTERS;
    public static final String[] ROMAN_QUARTERS;
    private String[] quarters;
    
    public QuarterDateFormat() {
        this(TimeZone.getDefault());
    }
    
    public QuarterDateFormat(final TimeZone timeZone) {
        this(timeZone, QuarterDateFormat.REGULAR_QUARTERS);
    }
    
    public QuarterDateFormat(final TimeZone timeZone, final String[] quarters) {
        this.quarters = QuarterDateFormat.REGULAR_QUARTERS;
        if (timeZone == null) {
            throw new IllegalArgumentException("Null 'zone' argument.");
        }
        this.calendar = new GregorianCalendar(timeZone);
        this.quarters = quarters;
        this.numberFormat = NumberFormat.getNumberInstance();
    }
    
    public StringBuffer format(final Date time, final StringBuffer sb, final FieldPosition fieldPosition) {
        this.calendar.setTime(time);
        final int value = this.calendar.get(1);
        final int value2 = this.calendar.get(2);
        sb.append(value);
        sb.append(" ");
        sb.append(this.quarters[value2 / 3]);
        return sb;
    }
    
    public Date parse(final String s, final ParsePosition parsePosition) {
        return null;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof QuarterDateFormat && super.equals(o) && Arrays.equals(this.quarters, ((QuarterDateFormat)o).quarters));
    }
    
    static {
        REGULAR_QUARTERS = new String[] { "1", "2", "3", "4" };
        ROMAN_QUARTERS = new String[] { "I", "II", "III", "IV" };
    }
}
