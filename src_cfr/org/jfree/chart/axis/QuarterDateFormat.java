/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class QuarterDateFormat
extends DateFormat
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -6738465248529797176L;
    public static final String[] REGULAR_QUARTERS = new String[]{"1", "2", "3", "4"};
    public static final String[] ROMAN_QUARTERS = new String[]{"I", "II", "III", "IV"};
    private String[] quarters = REGULAR_QUARTERS;

    public QuarterDateFormat() {
        this(TimeZone.getDefault());
    }

    public QuarterDateFormat(TimeZone timeZone) {
        this(timeZone, REGULAR_QUARTERS);
    }

    public QuarterDateFormat(TimeZone timeZone, String[] arrstring) {
        if (timeZone == null) {
            throw new IllegalArgumentException("Null 'zone' argument.");
        }
        this.calendar = new GregorianCalendar(timeZone);
        this.quarters = arrstring;
        this.numberFormat = NumberFormat.getNumberInstance();
    }

    @Override
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        this.calendar.setTime(date);
        int n2 = this.calendar.get(1);
        int n3 = this.calendar.get(2);
        stringBuffer.append(n2);
        stringBuffer.append(" ");
        int n4 = n3 / 3;
        stringBuffer.append(this.quarters[n4]);
        return stringBuffer;
    }

    @Override
    public Date parse(String string, ParsePosition parsePosition) {
        return null;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof QuarterDateFormat)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        QuarterDateFormat quarterDateFormat = (QuarterDateFormat)object;
        if (Arrays.equals(this.quarters, quarterDateFormat.quarters)) return true;
        return false;
    }
}

