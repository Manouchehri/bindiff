package org.jfree.chart.axis;

import java.text.*;
import java.util.*;
import org.jfree.data.time.*;

public class MonthDateFormat extends DateFormat
{
    private String[] months;
    private boolean[] showYear;
    private DateFormat yearFormatter;
    
    public MonthDateFormat() {
        this(TimeZone.getDefault());
    }
    
    public MonthDateFormat(final TimeZone timeZone) {
        this(timeZone, Locale.getDefault(), 1, true, false);
    }
    
    public MonthDateFormat(final Locale locale) {
        this(TimeZone.getDefault(), locale, 1, true, false);
    }
    
    public MonthDateFormat(final TimeZone timeZone, final int n) {
        this(timeZone, Locale.getDefault(), n, true, false);
    }
    
    public MonthDateFormat(final Locale locale, final int n) {
        this(TimeZone.getDefault(), locale, n, true, false);
    }
    
    public MonthDateFormat(final TimeZone timeZone, final Locale locale, final int n, final boolean b, final boolean b2) {
        this(timeZone, locale, n, new boolean[] { b, false, false, false, false, false, false, false, false, false, false, false, b2 }, new SimpleDateFormat("yy"));
    }
    
    public MonthDateFormat(final TimeZone timeZone, final Locale locale, final int n, final boolean[] showYear, final DateFormat yearFormatter) {
        if (locale == null) {
            throw new IllegalArgumentException("Null 'locale' argument.");
        }
        final String[] months = new DateFormatSymbols(locale).getMonths();
        this.months = new String[12];
        for (int i = 0; i < 12; ++i) {
            if (n > 0) {
                this.months[i] = months[i].substring(0, Math.min(n, months[i].length()));
            }
            else {
                this.months[i] = months[i];
            }
        }
        this.calendar = new GregorianCalendar(timeZone);
        this.showYear = showYear;
        this.yearFormatter = yearFormatter;
        this.numberFormat = NumberFormat.getNumberInstance();
    }
    
    public StringBuffer format(final Date time, final StringBuffer sb, final FieldPosition fieldPosition) {
        this.calendar.setTime(time);
        final int value = this.calendar.get(2);
        sb.append(this.months[value]);
        if (this.showYear[value]) {
            sb.append(this.yearFormatter.format(time));
        }
        return sb;
    }
    
    public Date parse(final String s, final ParsePosition parsePosition) {
        return null;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MonthDateFormat)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final MonthDateFormat monthDateFormat = (MonthDateFormat)o;
        return Arrays.equals(this.months, monthDateFormat.months) && Arrays.equals(this.showYear, monthDateFormat.showYear) && this.yearFormatter.equals(monthDateFormat.yearFormatter);
    }
    
    public static void main(final String[] array) {
        final MonthDateFormat monthDateFormat = new MonthDateFormat(Locale.UK, 2);
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
        final MonthDateFormat monthDateFormat2 = new MonthDateFormat(Locale.GERMANY, 2);
        System.out.println("GERMANY:");
        System.out.println(monthDateFormat2.format(new Month(1, 2005).getStart()));
        System.out.println(monthDateFormat2.format(new Month(2, 2005).getStart()));
        System.out.println(monthDateFormat2.format(new Month(3, 2005).getStart()));
        System.out.println(monthDateFormat2.format(new Month(4, 2005).getStart()));
        System.out.println(monthDateFormat2.format(new Month(5, 2005).getStart()));
        System.out.println(monthDateFormat2.format(new Month(6, 2005).getStart()));
        System.out.println(monthDateFormat2.format(new Month(7, 2005).getStart()));
        System.out.println(monthDateFormat2.format(new Month(8, 2005).getStart()));
        System.out.println(monthDateFormat2.format(new Month(9, 2005).getStart()));
        System.out.println(monthDateFormat2.format(new Month(10, 2005).getStart()));
        System.out.println(monthDateFormat2.format(new Month(11, 2005).getStart()));
        System.out.println(monthDateFormat2.format(new Month(12, 2005).getStart()));
        System.out.println();
        final MonthDateFormat monthDateFormat3 = new MonthDateFormat(Locale.FRANCE, 2);
        System.out.println("FRANCE:");
        System.out.println(monthDateFormat3.format(new Month(1, 2005).getStart()));
        System.out.println(monthDateFormat3.format(new Month(2, 2005).getStart()));
        System.out.println(monthDateFormat3.format(new Month(3, 2005).getStart()));
        System.out.println(monthDateFormat3.format(new Month(4, 2005).getStart()));
        System.out.println(monthDateFormat3.format(new Month(5, 2005).getStart()));
        System.out.println(monthDateFormat3.format(new Month(6, 2005).getStart()));
        System.out.println(monthDateFormat3.format(new Month(7, 2005).getStart()));
        System.out.println(monthDateFormat3.format(new Month(8, 2005).getStart()));
        System.out.println(monthDateFormat3.format(new Month(9, 2005).getStart()));
        System.out.println(monthDateFormat3.format(new Month(10, 2005).getStart()));
        System.out.println(monthDateFormat3.format(new Month(11, 2005).getStart()));
        System.out.println(monthDateFormat3.format(new Month(12, 2005).getStart()));
        System.out.println();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        simpleDateFormat.setNumberFormat(null);
        System.out.println(simpleDateFormat.equals("X"));
    }
}
