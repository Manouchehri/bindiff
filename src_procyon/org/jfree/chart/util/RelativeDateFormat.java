package org.jfree.chart.util;

import java.util.*;
import java.text.*;

public class RelativeDateFormat extends DateFormat
{
    private long baseMillis;
    private boolean showZeroDays;
    private NumberFormat dayFormatter;
    private String daySuffix;
    private String hourSuffix;
    private String minuteSuffix;
    private NumberFormat secondFormatter;
    private String secondSuffix;
    private static long MILLISECONDS_IN_ONE_HOUR;
    private static long MILLISECONDS_IN_ONE_DAY;
    
    public RelativeDateFormat() {
        this(0L);
    }
    
    public RelativeDateFormat(final Date date) {
        this(date.getTime());
    }
    
    public RelativeDateFormat(final long baseMillis) {
        this.baseMillis = baseMillis;
        this.showZeroDays = false;
        this.dayFormatter = NumberFormat.getInstance();
        this.daySuffix = "d";
        this.hourSuffix = "h";
        this.minuteSuffix = "m";
        (this.secondFormatter = NumberFormat.getNumberInstance()).setMaximumFractionDigits(3);
        this.secondFormatter.setMinimumFractionDigits(3);
        this.secondSuffix = "s";
        this.calendar = new GregorianCalendar();
        this.numberFormat = new DecimalFormat("0");
    }
    
    public long getBaseMillis() {
        return this.baseMillis;
    }
    
    public void setBaseMillis(final long baseMillis) {
        this.baseMillis = baseMillis;
    }
    
    public boolean getShowZeroDays() {
        return this.showZeroDays;
    }
    
    public void setShowZeroDays(final boolean showZeroDays) {
        this.showZeroDays = showZeroDays;
    }
    
    public String getDaySuffix() {
        return this.daySuffix;
    }
    
    public void setDaySuffix(final String daySuffix) {
        if (daySuffix == null) {
            throw new IllegalArgumentException("Null 'suffix' argument.");
        }
        this.daySuffix = daySuffix;
    }
    
    public String getHourSuffix() {
        return this.hourSuffix;
    }
    
    public void setHourSuffix(final String hourSuffix) {
        if (hourSuffix == null) {
            throw new IllegalArgumentException("Null 'suffix' argument.");
        }
        this.hourSuffix = hourSuffix;
    }
    
    public String getMinuteSuffix() {
        return this.minuteSuffix;
    }
    
    public void setMinuteSuffix(final String minuteSuffix) {
        if (minuteSuffix == null) {
            throw new IllegalArgumentException("Null 'suffix' argument.");
        }
        this.minuteSuffix = minuteSuffix;
    }
    
    public String getSecondSuffix() {
        return this.secondSuffix;
    }
    
    public void setSecondSuffix(final String secondSuffix) {
        if (secondSuffix == null) {
            throw new IllegalArgumentException("Null 'suffix' argument.");
        }
        this.secondSuffix = secondSuffix;
    }
    
    public void setSecondFormatter(final NumberFormat secondFormatter) {
        if (secondFormatter == null) {
            throw new IllegalArgumentException("Null 'formatter' argument.");
        }
        this.secondFormatter = secondFormatter;
    }
    
    public StringBuffer format(final Date date, final StringBuffer sb, final FieldPosition fieldPosition) {
        final long n = date.getTime() - this.baseMillis;
        final long n2 = n / RelativeDateFormat.MILLISECONDS_IN_ONE_DAY;
        final long n3 = n - n2 * RelativeDateFormat.MILLISECONDS_IN_ONE_DAY;
        final long n4 = n3 / RelativeDateFormat.MILLISECONDS_IN_ONE_HOUR;
        final long n5 = n3 - n4 * RelativeDateFormat.MILLISECONDS_IN_ONE_HOUR;
        final long n6 = n5 / 60000L;
        final double n7 = (n5 - n6 * 60000L) / 1000.0;
        if (n2 != 0L || this.showZeroDays) {
            sb.append(this.dayFormatter.format(n2) + this.getDaySuffix());
        }
        sb.append(String.valueOf(n4) + this.getHourSuffix());
        sb.append(String.valueOf(n6) + this.getMinuteSuffix());
        sb.append(this.secondFormatter.format(n7) + this.getSecondSuffix());
        return sb;
    }
    
    public Date parse(final String s, final ParsePosition parsePosition) {
        return null;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RelativeDateFormat)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final RelativeDateFormat relativeDateFormat = (RelativeDateFormat)o;
        return this.baseMillis == relativeDateFormat.baseMillis && this.showZeroDays == relativeDateFormat.showZeroDays && this.daySuffix.equals(relativeDateFormat.daySuffix) && this.hourSuffix.equals(relativeDateFormat.hourSuffix) && this.minuteSuffix.equals(relativeDateFormat.minuteSuffix) && this.secondSuffix.equals(relativeDateFormat.secondSuffix) && this.secondFormatter.equals(relativeDateFormat.secondFormatter);
    }
    
    public int hashCode() {
        return 37 * (37 * (37 * (37 * (37 * (37 * 193 + (int)(this.baseMillis ^ this.baseMillis >>> 32)) + this.daySuffix.hashCode()) + this.hourSuffix.hashCode()) + this.minuteSuffix.hashCode()) + this.secondSuffix.hashCode()) + this.secondFormatter.hashCode();
    }
    
    public Object clone() {
        final RelativeDateFormat relativeDateFormat = (RelativeDateFormat)super.clone();
        relativeDateFormat.dayFormatter = (NumberFormat)this.dayFormatter.clone();
        relativeDateFormat.secondFormatter = (NumberFormat)this.secondFormatter.clone();
        return relativeDateFormat;
    }
    
    public static void main(final String[] array) {
        final GregorianCalendar gregorianCalendar = new GregorianCalendar(2006, 10, 1, 0, 0, 0);
        final GregorianCalendar gregorianCalendar2 = new GregorianCalendar(2006, 10, 1, 11, 37, 43);
        gregorianCalendar2.set(14, 123);
        System.out.println("Default: ");
        final RelativeDateFormat relativeDateFormat = new RelativeDateFormat(gregorianCalendar.getTimeInMillis());
        System.out.println(relativeDateFormat.format(gregorianCalendar2.getTime()));
        System.out.println();
        System.out.println("Hide milliseconds: ");
        relativeDateFormat.setSecondFormatter(new DecimalFormat("0"));
        System.out.println(relativeDateFormat.format(gregorianCalendar2.getTime()));
        System.out.println();
        System.out.println("Show zero day output: ");
        relativeDateFormat.setShowZeroDays(true);
        System.out.println(relativeDateFormat.format(gregorianCalendar2.getTime()));
        System.out.println();
        System.out.println("Alternative suffixes: ");
        relativeDateFormat.setShowZeroDays(false);
        relativeDateFormat.setDaySuffix(":");
        relativeDateFormat.setHourSuffix(":");
        relativeDateFormat.setMinuteSuffix(":");
        relativeDateFormat.setSecondSuffix("");
        System.out.println(relativeDateFormat.format(gregorianCalendar2.getTime()));
        System.out.println();
    }
    
    static {
        RelativeDateFormat.MILLISECONDS_IN_ONE_HOUR = 3600000L;
        RelativeDateFormat.MILLISECONDS_IN_ONE_DAY = 24L * RelativeDateFormat.MILLISECONDS_IN_ONE_HOUR;
    }
}
