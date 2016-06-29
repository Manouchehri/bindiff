/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.util;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RelativeDateFormat
extends DateFormat {
    private long baseMillis;
    private boolean showZeroDays;
    private NumberFormat dayFormatter;
    private String daySuffix;
    private String hourSuffix;
    private String minuteSuffix;
    private NumberFormat secondFormatter;
    private String secondSuffix;
    private static long MILLISECONDS_IN_ONE_HOUR = 3600000;
    private static long MILLISECONDS_IN_ONE_DAY = 24 * MILLISECONDS_IN_ONE_HOUR;

    public RelativeDateFormat() {
        this(0);
    }

    public RelativeDateFormat(Date date) {
        this(date.getTime());
    }

    public RelativeDateFormat(long l2) {
        this.baseMillis = l2;
        this.showZeroDays = false;
        this.dayFormatter = NumberFormat.getInstance();
        this.daySuffix = "d";
        this.hourSuffix = "h";
        this.minuteSuffix = "m";
        this.secondFormatter = NumberFormat.getNumberInstance();
        this.secondFormatter.setMaximumFractionDigits(3);
        this.secondFormatter.setMinimumFractionDigits(3);
        this.secondSuffix = "s";
        this.calendar = new GregorianCalendar();
        this.numberFormat = new DecimalFormat("0");
    }

    public long getBaseMillis() {
        return this.baseMillis;
    }

    public void setBaseMillis(long l2) {
        this.baseMillis = l2;
    }

    public boolean getShowZeroDays() {
        return this.showZeroDays;
    }

    public void setShowZeroDays(boolean bl2) {
        this.showZeroDays = bl2;
    }

    public String getDaySuffix() {
        return this.daySuffix;
    }

    public void setDaySuffix(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'suffix' argument.");
        }
        this.daySuffix = string;
    }

    public String getHourSuffix() {
        return this.hourSuffix;
    }

    public void setHourSuffix(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'suffix' argument.");
        }
        this.hourSuffix = string;
    }

    public String getMinuteSuffix() {
        return this.minuteSuffix;
    }

    public void setMinuteSuffix(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'suffix' argument.");
        }
        this.minuteSuffix = string;
    }

    public String getSecondSuffix() {
        return this.secondSuffix;
    }

    public void setSecondSuffix(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'suffix' argument.");
        }
        this.secondSuffix = string;
    }

    public void setSecondFormatter(NumberFormat numberFormat) {
        if (numberFormat == null) {
            throw new IllegalArgumentException("Null 'formatter' argument.");
        }
        this.secondFormatter = numberFormat;
    }

    @Override
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        long l2 = date.getTime();
        long l3 = l2 - this.baseMillis;
        long l4 = l3 / MILLISECONDS_IN_ONE_DAY;
        long l5 = (l3 -= l4 * MILLISECONDS_IN_ONE_DAY) / MILLISECONDS_IN_ONE_HOUR;
        long l6 = (l3 -= l5 * MILLISECONDS_IN_ONE_HOUR) / 60000;
        double d2 = (double)(l3 -= l6 * 60000) / 1000.0;
        if (l4 != 0 || this.showZeroDays) {
            stringBuffer.append(new StringBuffer().append(this.dayFormatter.format(l4)).append(this.getDaySuffix()).toString());
        }
        stringBuffer.append(new StringBuffer().append(String.valueOf(l5)).append(this.getHourSuffix()).toString());
        stringBuffer.append(new StringBuffer().append(String.valueOf(l6)).append(this.getMinuteSuffix()).toString());
        stringBuffer.append(new StringBuffer().append(this.secondFormatter.format(d2)).append(this.getSecondSuffix()).toString());
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
        if (!(object instanceof RelativeDateFormat)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        RelativeDateFormat relativeDateFormat = (RelativeDateFormat)object;
        if (this.baseMillis != relativeDateFormat.baseMillis) {
            return false;
        }
        if (this.showZeroDays != relativeDateFormat.showZeroDays) {
            return false;
        }
        if (!this.daySuffix.equals(relativeDateFormat.daySuffix)) {
            return false;
        }
        if (!this.hourSuffix.equals(relativeDateFormat.hourSuffix)) {
            return false;
        }
        if (!this.minuteSuffix.equals(relativeDateFormat.minuteSuffix)) {
            return false;
        }
        if (!this.secondSuffix.equals(relativeDateFormat.secondSuffix)) {
            return false;
        }
        if (this.secondFormatter.equals(relativeDateFormat.secondFormatter)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int n2 = 193;
        n2 = 37 * n2 + (int)(this.baseMillis ^ this.baseMillis >>> 32);
        n2 = 37 * n2 + this.daySuffix.hashCode();
        n2 = 37 * n2 + this.hourSuffix.hashCode();
        n2 = 37 * n2 + this.minuteSuffix.hashCode();
        n2 = 37 * n2 + this.secondSuffix.hashCode();
        return 37 * n2 + this.secondFormatter.hashCode();
    }

    @Override
    public Object clone() {
        RelativeDateFormat relativeDateFormat = (RelativeDateFormat)super.clone();
        relativeDateFormat.dayFormatter = (NumberFormat)this.dayFormatter.clone();
        relativeDateFormat.secondFormatter = (NumberFormat)this.secondFormatter.clone();
        return relativeDateFormat;
    }

    public static void main(String[] arrstring) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2006, 10, 1, 0, 0, 0);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(2006, 10, 1, 11, 37, 43);
        gregorianCalendar2.set(14, 123);
        System.out.println("Default: ");
        RelativeDateFormat relativeDateFormat = new RelativeDateFormat(gregorianCalendar.getTimeInMillis());
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
}

