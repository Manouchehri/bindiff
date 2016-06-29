/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.jfree.data.time.Month;

public class MonthDateFormat
extends DateFormat {
    private String[] months;
    private boolean[] showYear;
    private DateFormat yearFormatter;

    public MonthDateFormat() {
        this(TimeZone.getDefault());
    }

    public MonthDateFormat(TimeZone timeZone) {
        this(timeZone, Locale.getDefault(), 1, true, false);
    }

    public MonthDateFormat(Locale locale) {
        this(TimeZone.getDefault(), locale, 1, true, false);
    }

    public MonthDateFormat(TimeZone timeZone, int n2) {
        this(timeZone, Locale.getDefault(), n2, true, false);
    }

    public MonthDateFormat(Locale locale, int n2) {
        this(TimeZone.getDefault(), locale, n2, true, false);
    }

    public MonthDateFormat(TimeZone timeZone, Locale locale, int n2, boolean bl2, boolean bl3) {
        this(timeZone, locale, n2, new boolean[]{bl2, false, false, false, false, false, false, false, false, false, false, false, bl3}, new SimpleDateFormat("yy"));
    }

    public MonthDateFormat(TimeZone timeZone, Locale locale, int n2, boolean[] arrbl, DateFormat dateFormat) {
        if (locale == null) {
            throw new IllegalArgumentException("Null 'locale' argument.");
        }
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        String[] arrstring = dateFormatSymbols.getMonths();
        this.months = new String[12];
        int n3 = 0;
        do {
            if (n3 >= 12) {
                this.calendar = new GregorianCalendar(timeZone);
                this.showYear = arrbl;
                this.yearFormatter = dateFormat;
                this.numberFormat = NumberFormat.getNumberInstance();
                return;
            }
            this.months[n3] = n2 > 0 ? arrstring[n3].substring(0, Math.min(n2, arrstring[n3].length())) : arrstring[n3];
            ++n3;
        } while (true);
    }

    @Override
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        this.calendar.setTime(date);
        int n2 = this.calendar.get(2);
        stringBuffer.append(this.months[n2]);
        if (!this.showYear[n2]) return stringBuffer;
        stringBuffer.append(this.yearFormatter.format(date));
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
        if (!(object instanceof MonthDateFormat)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        MonthDateFormat monthDateFormat = (MonthDateFormat)object;
        if (!Arrays.equals(this.months, monthDateFormat.months)) {
            return false;
        }
        if (!Arrays.equals(this.showYear, monthDateFormat.showYear)) {
            return false;
        }
        if (this.yearFormatter.equals(monthDateFormat.yearFormatter)) return true;
        return false;
    }

    public static void main(String[] arrstring) {
        MonthDateFormat monthDateFormat = new MonthDateFormat(Locale.UK, 2);
        System.out.println("UK:");
        System.out.println(monthDateFormat.format(new Month(1, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(2, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(3, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(4, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(5, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(6, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(7, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(8, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(9, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(10, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(11, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(12, 2005).getStart()));
        System.out.println();
        monthDateFormat = new MonthDateFormat(Locale.GERMANY, 2);
        System.out.println("GERMANY:");
        System.out.println(monthDateFormat.format(new Month(1, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(2, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(3, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(4, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(5, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(6, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(7, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(8, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(9, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(10, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(11, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(12, 2005).getStart()));
        System.out.println();
        monthDateFormat = new MonthDateFormat(Locale.FRANCE, 2);
        System.out.println("FRANCE:");
        System.out.println(monthDateFormat.format(new Month(1, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(2, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(3, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(4, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(5, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(6, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(7, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(8, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(9, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(10, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(11, 2005).getStart()));
        System.out.println(monthDateFormat.format(new Month(12, 2005).getStart()));
        System.out.println();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        simpleDateFormat.setNumberFormat(null);
        System.out.println(simpleDateFormat.equals("X"));
    }
}

