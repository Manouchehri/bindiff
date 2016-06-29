/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.date;

import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import org.jfree.date.MonthConstants;
import org.jfree.date.SpreadsheetDate;

public abstract class SerialDate
implements Serializable,
Comparable,
MonthConstants {
    private static final long serialVersionUID = -293716040467423637L;
    public static final DateFormatSymbols DATE_FORMAT_SYMBOLS = new SimpleDateFormat().getDateFormatSymbols();
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
    static final int[] LAST_DAY_OF_MONTH = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static final int[] AGGREGATE_DAYS_TO_END_OF_MONTH = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    static final int[] AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH = new int[]{0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    static final int[] LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_MONTH = new int[]{0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366};
    static final int[] LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH = new int[]{0, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366};
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

    protected SerialDate() {
    }

    public static boolean isValidWeekdayCode(int n2) {
        switch (n2) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                return true;
            }
        }
        return false;
    }

    public static int stringToWeekdayCode(String string) {
        String[] arrstring = DATE_FORMAT_SYMBOLS.getShortWeekdays();
        String[] arrstring2 = DATE_FORMAT_SYMBOLS.getWeekdays();
        int n2 = -1;
        string = string.trim();
        int n3 = 0;
        while (n3 < arrstring2.length) {
            if (string.equals(arrstring[n3])) {
                return n3;
            }
            if (string.equals(arrstring2[n3])) {
                return n3;
            }
            ++n3;
        }
        return n2;
    }

    public static String weekdayCodeToString(int n2) {
        String[] arrstring = DATE_FORMAT_SYMBOLS.getWeekdays();
        return arrstring[n2];
    }

    public static String[] getMonths() {
        return SerialDate.getMonths(false);
    }

    public static String[] getMonths(boolean bl2) {
        if (!bl2) return DATE_FORMAT_SYMBOLS.getMonths();
        return DATE_FORMAT_SYMBOLS.getShortMonths();
    }

    public static boolean isValidMonthCode(int n2) {
        switch (n2) {
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
        }
        return false;
    }

    public static int monthCodeToQuarter(int n2) {
        switch (n2) {
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
        }
        throw new IllegalArgumentException("SerialDate.monthCodeToQuarter: invalid month code.");
    }

    public static String monthCodeToString(int n2) {
        return SerialDate.monthCodeToString(n2, false);
    }

    public static String monthCodeToString(int n2, boolean bl2) {
        String[] arrstring;
        if (!SerialDate.isValidMonthCode(n2)) {
            throw new IllegalArgumentException("SerialDate.monthCodeToString: month outside valid range.");
        }
        if (bl2) {
            arrstring = DATE_FORMAT_SYMBOLS.getShortMonths();
            return arrstring[n2 - 1];
        }
        arrstring = DATE_FORMAT_SYMBOLS.getMonths();
        return arrstring[n2 - 1];
    }

    public static int stringToMonthCode(String string) {
        String[] arrstring = DATE_FORMAT_SYMBOLS.getShortMonths();
        String[] arrstring2 = DATE_FORMAT_SYMBOLS.getMonths();
        int n2 = -1;
        string = string.trim();
        try {
            n2 = Integer.parseInt(string);
        }
        catch (NumberFormatException var4_4) {
            // empty catch block
        }
        if (n2 >= 1) {
            if (n2 <= 12) return n2;
        }
        int n3 = 0;
        while (n3 < arrstring2.length) {
            if (string.equals(arrstring[n3])) {
                return n3 + 1;
            }
            if (string.equals(arrstring2[n3])) {
                return n3 + 1;
            }
            ++n3;
        }
        return n2;
    }

    public static boolean isValidWeekInMonthCode(int n2) {
        switch (n2) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return true;
            }
        }
        return false;
    }

    public static boolean isLeapYear(int n2) {
        if (n2 % 4 != 0) {
            return false;
        }
        if (n2 % 400 == 0) {
            return true;
        }
        if (n2 % 100 != 0) return true;
        return false;
    }

    public static int leapYearCount(int n2) {
        int n3 = (n2 - 1896) / 4;
        int n4 = (n2 - 1800) / 100;
        int n5 = (n2 - 1600) / 400;
        return n3 - n4 + n5;
    }

    public static int lastDayOfMonth(int n2, int n3) {
        int n4 = LAST_DAY_OF_MONTH[n2];
        if (n2 != 2) {
            return n4;
        }
        if (!SerialDate.isLeapYear(n3)) return n4;
        return n4 + 1;
    }

    public static SerialDate addDays(int n2, SerialDate serialDate) {
        int n3 = serialDate.toSerial() + n2;
        return SerialDate.createInstance(n3);
    }

    public static SerialDate addMonths(int n2, SerialDate serialDate) {
        int n3 = (12 * serialDate.getYYYY() + serialDate.getMonth() + n2 - 1) / 12;
        int n4 = (12 * serialDate.getYYYY() + serialDate.getMonth() + n2 - 1) % 12 + 1;
        int n5 = Math.min(serialDate.getDayOfMonth(), SerialDate.lastDayOfMonth(n4, n3));
        return SerialDate.createInstance(n5, n4, n3);
    }

    public static SerialDate addYears(int n2, SerialDate serialDate) {
        int n3 = serialDate.getYYYY();
        int n4 = serialDate.getMonth();
        int n5 = serialDate.getDayOfMonth();
        int n6 = n3 + n2;
        int n7 = Math.min(n5, SerialDate.lastDayOfMonth(n4, n6));
        return SerialDate.createInstance(n7, n4, n6);
    }

    public static SerialDate getPreviousDayOfWeek(int n2, SerialDate serialDate) {
        int n3;
        if (!SerialDate.isValidWeekdayCode(n2)) {
            throw new IllegalArgumentException("Invalid day-of-the-week code.");
        }
        int n4 = serialDate.getDayOfWeek();
        if (n4 > n2) {
            n3 = Math.min(0, n2 - n4);
            return SerialDate.addDays(n3, serialDate);
        }
        n3 = -7 + Math.max(0, n2 - n4);
        return SerialDate.addDays(n3, serialDate);
    }

    public static SerialDate getFollowingDayOfWeek(int n2, SerialDate serialDate) {
        int n3;
        if (!SerialDate.isValidWeekdayCode(n2)) {
            throw new IllegalArgumentException("Invalid day-of-the-week code.");
        }
        int n4 = serialDate.getDayOfWeek();
        if (n4 > n2) {
            n3 = 7 + Math.min(0, n2 - n4);
            return SerialDate.addDays(n3, serialDate);
        }
        n3 = Math.max(0, n2 - n4);
        return SerialDate.addDays(n3, serialDate);
    }

    public static SerialDate getNearestDayOfWeek(int n2, SerialDate serialDate) {
        if (!SerialDate.isValidWeekdayCode(n2)) {
            throw new IllegalArgumentException("Invalid day-of-the-week code.");
        }
        int n3 = serialDate.getDayOfWeek();
        int n4 = - Math.abs(n2 - n3);
        if (n4 >= 4) {
            n4 = 7 - n4;
        }
        if (n4 > -4) return SerialDate.addDays(n4, serialDate);
        n4 = 7 + n4;
        return SerialDate.addDays(n4, serialDate);
    }

    public SerialDate getEndOfCurrentMonth(SerialDate serialDate) {
        int n2 = SerialDate.lastDayOfMonth(serialDate.getMonth(), serialDate.getYYYY());
        return SerialDate.createInstance(n2, serialDate.getMonth(), serialDate.getYYYY());
    }

    public static String weekInMonthToString(int n2) {
        switch (n2) {
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
        }
        return "SerialDate.weekInMonthToString(): invalid code.";
    }

    public static String relativeToString(int n2) {
        switch (n2) {
            case -1: {
                return "Preceding";
            }
            case 0: {
                return "Nearest";
            }
            case 1: {
                return "Following";
            }
        }
        return "ERROR : Relative To String";
    }

    public static SerialDate createInstance(int n2, int n3, int n4) {
        return new SpreadsheetDate(n2, n3, n4);
    }

    public static SerialDate createInstance(int n2) {
        return new SpreadsheetDate(n2);
    }

    public static SerialDate createInstance(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return new SpreadsheetDate(gregorianCalendar.get(5), gregorianCalendar.get(2) + 1, gregorianCalendar.get(1));
    }

    public abstract int toSerial();

    public abstract Date toDate();

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public String toString() {
        return new StringBuffer().append(this.getDayOfMonth()).append("-").append(SerialDate.monthCodeToString(this.getMonth())).append("-").append(this.getYYYY()).toString();
    }

    public abstract int getYYYY();

    public abstract int getMonth();

    public abstract int getDayOfMonth();

    public abstract int getDayOfWeek();

    public abstract int compare(SerialDate var1);

    public abstract boolean isOn(SerialDate var1);

    public abstract boolean isBefore(SerialDate var1);

    public abstract boolean isOnOrBefore(SerialDate var1);

    public abstract boolean isAfter(SerialDate var1);

    public abstract boolean isOnOrAfter(SerialDate var1);

    public abstract boolean isInRange(SerialDate var1, SerialDate var2);

    public abstract boolean isInRange(SerialDate var1, SerialDate var2, int var3);

    public SerialDate getPreviousDayOfWeek(int n2) {
        return SerialDate.getPreviousDayOfWeek(n2, this);
    }

    public SerialDate getFollowingDayOfWeek(int n2) {
        return SerialDate.getFollowingDayOfWeek(n2, this);
    }

    public SerialDate getNearestDayOfWeek(int n2) {
        return SerialDate.getNearestDayOfWeek(n2, this);
    }
}

