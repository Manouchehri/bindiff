package org.jfree.date;

import java.io.*;
import java.util.*;
import java.text.*;

public abstract class SerialDate implements Serializable, Comparable, MonthConstants
{
    private static final long serialVersionUID = -293716040467423637L;
    public static final DateFormatSymbols DATE_FORMAT_SYMBOLS;
    public static final int SERIAL_LOWER_BOUND = 2;
    public static final int SERIAL_UPPER_BOUND = 2958465;
    public static final int MINIMUM_YEAR_SUPPORTED = 1900;
    public static final int MAXIMUM_YEAR_SUPPORTED = 9999;
    public static final int MONDAY = 2;
    public static final int TUESDAY = 3;
    public static final int WEDNESDAY = 4;
    public static final int THURSDAY = 5;
    public static final int FRIDAY = 6;
    public static final int SATURDAY = 7;
    public static final int SUNDAY = 1;
    static final int[] LAST_DAY_OF_MONTH;
    static final int[] AGGREGATE_DAYS_TO_END_OF_MONTH;
    static final int[] AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH;
    static final int[] LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_MONTH;
    static final int[] LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH;
    public static final int FIRST_WEEK_IN_MONTH = 1;
    public static final int SECOND_WEEK_IN_MONTH = 2;
    public static final int THIRD_WEEK_IN_MONTH = 3;
    public static final int FOURTH_WEEK_IN_MONTH = 4;
    public static final int LAST_WEEK_IN_MONTH = 0;
    public static final int INCLUDE_NONE = 0;
    public static final int INCLUDE_FIRST = 1;
    public static final int INCLUDE_SECOND = 2;
    public static final int INCLUDE_BOTH = 3;
    public static final int PRECEDING = -1;
    public static final int NEAREST = 0;
    public static final int FOLLOWING = 1;
    private String description;
    
    public static boolean isValidWeekdayCode(final int n) {
        switch (n) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public static int stringToWeekdayCode(String trim) {
        final String[] shortWeekdays = SerialDate.DATE_FORMAT_SYMBOLS.getShortWeekdays();
        final String[] weekdays = SerialDate.DATE_FORMAT_SYMBOLS.getWeekdays();
        int n = -1;
        trim = trim.trim();
        for (int i = 0; i < weekdays.length; ++i) {
            if (trim.equals(shortWeekdays[i])) {
                n = i;
                break;
            }
            if (trim.equals(weekdays[i])) {
                n = i;
                break;
            }
        }
        return n;
    }
    
    public static String weekdayCodeToString(final int n) {
        return SerialDate.DATE_FORMAT_SYMBOLS.getWeekdays()[n];
    }
    
    public static String[] getMonths() {
        return getMonths(false);
    }
    
    public static String[] getMonths(final boolean b) {
        if (b) {
            return SerialDate.DATE_FORMAT_SYMBOLS.getShortMonths();
        }
        return SerialDate.DATE_FORMAT_SYMBOLS.getMonths();
    }
    
    public static boolean isValidMonthCode(final int n) {
        switch (n) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public static int monthCodeToQuarter(final int n) {
        switch (n) {
            case 1:
            case 2:
            case 3: {
                return 1;
            }
            case 4:
            case 5:
            case 6: {
                return 2;
            }
            case 7:
            case 8:
            case 9: {
                return 3;
            }
            case 10:
            case 11:
            case 12: {
                return 4;
            }
            default: {
                throw new IllegalArgumentException("SerialDate.monthCodeToQuarter: invalid month code.");
            }
        }
    }
    
    public static String monthCodeToString(final int n) {
        return monthCodeToString(n, false);
    }
    
    public static String monthCodeToString(final int n, final boolean b) {
        if (!isValidMonthCode(n)) {
            throw new IllegalArgumentException("SerialDate.monthCodeToString: month outside valid range.");
        }
        String[] array;
        if (b) {
            array = SerialDate.DATE_FORMAT_SYMBOLS.getShortMonths();
        }
        else {
            array = SerialDate.DATE_FORMAT_SYMBOLS.getMonths();
        }
        return array[n - 1];
    }
    
    public static int stringToMonthCode(String trim) {
        final String[] shortMonths = SerialDate.DATE_FORMAT_SYMBOLS.getShortMonths();
        final String[] months = SerialDate.DATE_FORMAT_SYMBOLS.getMonths();
        int int1 = -1;
        trim = trim.trim();
        try {
            int1 = Integer.parseInt(trim);
        }
        catch (NumberFormatException ex) {}
        if (int1 < 1 || int1 > 12) {
            for (int i = 0; i < months.length; ++i) {
                if (trim.equals(shortMonths[i])) {
                    int1 = i + 1;
                    break;
                }
                if (trim.equals(months[i])) {
                    int1 = i + 1;
                    break;
                }
            }
        }
        return int1;
    }
    
    public static boolean isValidWeekInMonthCode(final int n) {
        switch (n) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public static boolean isLeapYear(final int n) {
        return n % 4 == 0 && (n % 400 == 0 || n % 100 != 0);
    }
    
    public static int leapYearCount(final int n) {
        return (n - 1896) / 4 - (n - 1800) / 100 + (n - 1600) / 400;
    }
    
    public static int lastDayOfMonth(final int n, final int n2) {
        final int n3 = SerialDate.LAST_DAY_OF_MONTH[n];
        if (n != 2) {
            return n3;
        }
        if (isLeapYear(n2)) {
            return n3 + 1;
        }
        return n3;
    }
    
    public static SerialDate addDays(final int n, final SerialDate serialDate) {
        return createInstance(serialDate.toSerial() + n);
    }
    
    public static SerialDate addMonths(final int n, final SerialDate serialDate) {
        final int n2 = (12 * serialDate.getYYYY() + serialDate.getMonth() + n - 1) / 12;
        final int n3 = (12 * serialDate.getYYYY() + serialDate.getMonth() + n - 1) % 12 + 1;
        return createInstance(Math.min(serialDate.getDayOfMonth(), lastDayOfMonth(n3, n2)), n3, n2);
    }
    
    public static SerialDate addYears(final int n, final SerialDate serialDate) {
        final int yyyy = serialDate.getYYYY();
        final int month = serialDate.getMonth();
        final int dayOfMonth = serialDate.getDayOfMonth();
        final int n2 = yyyy + n;
        return createInstance(Math.min(dayOfMonth, lastDayOfMonth(month, n2)), month, n2);
    }
    
    public static SerialDate getPreviousDayOfWeek(final int n, final SerialDate serialDate) {
        if (!isValidWeekdayCode(n)) {
            throw new IllegalArgumentException("Invalid day-of-the-week code.");
        }
        final int dayOfWeek = serialDate.getDayOfWeek();
        int min;
        if (dayOfWeek > n) {
            min = Math.min(0, n - dayOfWeek);
        }
        else {
            min = -7 + Math.max(0, n - dayOfWeek);
        }
        return addDays(min, serialDate);
    }
    
    public static SerialDate getFollowingDayOfWeek(final int n, final SerialDate serialDate) {
        if (!isValidWeekdayCode(n)) {
            throw new IllegalArgumentException("Invalid day-of-the-week code.");
        }
        final int dayOfWeek = serialDate.getDayOfWeek();
        int max;
        if (dayOfWeek > n) {
            max = 7 + Math.min(0, n - dayOfWeek);
        }
        else {
            max = Math.max(0, n - dayOfWeek);
        }
        return addDays(max, serialDate);
    }
    
    public static SerialDate getNearestDayOfWeek(final int n, final SerialDate serialDate) {
        if (!isValidWeekdayCode(n)) {
            throw new IllegalArgumentException("Invalid day-of-the-week code.");
        }
        int n2 = -Math.abs(n - serialDate.getDayOfWeek());
        if (n2 >= 4) {
            n2 = 7 - n2;
        }
        if (n2 <= -4) {
            n2 += 7;
        }
        return addDays(n2, serialDate);
    }
    
    public SerialDate getEndOfCurrentMonth(final SerialDate serialDate) {
        return createInstance(lastDayOfMonth(serialDate.getMonth(), serialDate.getYYYY()), serialDate.getMonth(), serialDate.getYYYY());
    }
    
    public static String weekInMonthToString(final int n) {
        switch (n) {
            case 1: {
                return "First";
            }
            case 2: {
                return "Second";
            }
            case 3: {
                return "Third";
            }
            case 4: {
                return "Fourth";
            }
            case 0: {
                return "Last";
            }
            default: {
                return "SerialDate.weekInMonthToString(): invalid code.";
            }
        }
    }
    
    public static String relativeToString(final int n) {
        switch (n) {
            case -1: {
                return "Preceding";
            }
            case 0: {
                return "Nearest";
            }
            case 1: {
                return "Following";
            }
            default: {
                return "ERROR : Relative To String";
            }
        }
    }
    
    public static SerialDate createInstance(final int n, final int n2, final int n3) {
        return new SpreadsheetDate(n, n2, n3);
    }
    
    public static SerialDate createInstance(final int n) {
        return new SpreadsheetDate(n);
    }
    
    public static SerialDate createInstance(final Date time) {
        final GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(time);
        return new SpreadsheetDate(gregorianCalendar.get(5), gregorianCalendar.get(2) + 1, gregorianCalendar.get(1));
    }
    
    public abstract int toSerial();
    
    public abstract Date toDate();
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    public String toString() {
        return this.getDayOfMonth() + "-" + monthCodeToString(this.getMonth()) + "-" + this.getYYYY();
    }
    
    public abstract int getYYYY();
    
    public abstract int getMonth();
    
    public abstract int getDayOfMonth();
    
    public abstract int getDayOfWeek();
    
    public abstract int compare(final SerialDate p0);
    
    public abstract boolean isOn(final SerialDate p0);
    
    public abstract boolean isBefore(final SerialDate p0);
    
    public abstract boolean isOnOrBefore(final SerialDate p0);
    
    public abstract boolean isAfter(final SerialDate p0);
    
    public abstract boolean isOnOrAfter(final SerialDate p0);
    
    public abstract boolean isInRange(final SerialDate p0, final SerialDate p1);
    
    public abstract boolean isInRange(final SerialDate p0, final SerialDate p1, final int p2);
    
    public SerialDate getPreviousDayOfWeek(final int n) {
        return getPreviousDayOfWeek(n, this);
    }
    
    public SerialDate getFollowingDayOfWeek(final int n) {
        return getFollowingDayOfWeek(n, this);
    }
    
    public SerialDate getNearestDayOfWeek(final int n) {
        return getNearestDayOfWeek(n, this);
    }
    
    static {
        DATE_FORMAT_SYMBOLS = new SimpleDateFormat().getDateFormatSymbols();
        LAST_DAY_OF_MONTH = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        AGGREGATE_DAYS_TO_END_OF_MONTH = new int[] { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };
        AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH = new int[] { 0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };
        LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_MONTH = new int[] { 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366 };
        LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH = new int[] { 0, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366 };
    }
}
