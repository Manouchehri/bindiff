package org.jfree.date;

import java.text.*;

public class SerialDateUtilities
{
    private DateFormatSymbols dateFormatSymbols;
    private String[] weekdays;
    private String[] months;
    
    public SerialDateUtilities() {
        this.dateFormatSymbols = new DateFormatSymbols();
        this.weekdays = this.dateFormatSymbols.getWeekdays();
        this.months = this.dateFormatSymbols.getMonths();
    }
    
    public String[] getWeekdays() {
        return this.weekdays;
    }
    
    public String[] getMonths() {
        return this.months;
    }
    
    public int stringToWeekday(final String s) {
        if (s.equals(this.weekdays[7])) {
            return 7;
        }
        if (s.equals(this.weekdays[1])) {
            return 1;
        }
        if (s.equals(this.weekdays[2])) {
            return 2;
        }
        if (s.equals(this.weekdays[3])) {
            return 3;
        }
        if (s.equals(this.weekdays[4])) {
            return 4;
        }
        if (s.equals(this.weekdays[5])) {
            return 5;
        }
        return 6;
    }
    
    public static int dayCountActual(final SerialDate serialDate, final SerialDate serialDate2) {
        return serialDate2.compare(serialDate);
    }
    
    public static int dayCount30(final SerialDate serialDate, final SerialDate serialDate2) {
        if (serialDate.isBefore(serialDate2)) {
            return 360 * (serialDate2.getYYYY() - serialDate.getYYYY()) + 30 * (serialDate2.getMonth() - serialDate.getMonth()) + (serialDate2.getDayOfMonth() - serialDate.getDayOfMonth());
        }
        return -dayCount30(serialDate2, serialDate);
    }
    
    public static int dayCount30ISDA(final SerialDate serialDate, final SerialDate serialDate2) {
        if (serialDate.isBefore(serialDate2)) {
            int dayOfMonth = serialDate.getDayOfMonth();
            final int month = serialDate.getMonth();
            final int yyyy = serialDate.getYYYY();
            if (dayOfMonth == 31) {
                dayOfMonth = 30;
            }
            int dayOfMonth2 = serialDate2.getDayOfMonth();
            final int month2 = serialDate2.getMonth();
            final int yyyy2 = serialDate2.getYYYY();
            if (dayOfMonth2 == 31 && dayOfMonth == 30) {
                dayOfMonth2 = 30;
            }
            return 360 * (yyyy2 - yyyy) + 30 * (month2 - month) + (dayOfMonth2 - dayOfMonth);
        }
        if (serialDate.isAfter(serialDate2)) {
            return -dayCount30ISDA(serialDate2, serialDate);
        }
        return 0;
    }
    
    public static int dayCount30PSA(final SerialDate serialDate, final SerialDate serialDate2) {
        if (serialDate.isOnOrBefore(serialDate2)) {
            int dayOfMonth = serialDate.getDayOfMonth();
            final int month = serialDate.getMonth();
            final int yyyy = serialDate.getYYYY();
            if (isLastDayOfFebruary(serialDate)) {
                dayOfMonth = 30;
            }
            if (dayOfMonth == 31 || isLastDayOfFebruary(serialDate)) {
                dayOfMonth = 30;
            }
            int dayOfMonth2 = serialDate2.getDayOfMonth();
            final int month2 = serialDate2.getMonth();
            final int yyyy2 = serialDate2.getYYYY();
            if (dayOfMonth2 == 31 && dayOfMonth == 30) {
                dayOfMonth2 = 30;
            }
            return 360 * (yyyy2 - yyyy) + 30 * (month2 - month) + (dayOfMonth2 - dayOfMonth);
        }
        return -dayCount30PSA(serialDate2, serialDate);
    }
    
    public static int dayCount30E(final SerialDate serialDate, final SerialDate serialDate2) {
        if (serialDate.isBefore(serialDate2)) {
            int dayOfMonth = serialDate.getDayOfMonth();
            final int month = serialDate.getMonth();
            final int yyyy = serialDate.getYYYY();
            if (dayOfMonth == 31) {
                dayOfMonth = 30;
            }
            int dayOfMonth2 = serialDate2.getDayOfMonth();
            final int month2 = serialDate2.getMonth();
            final int yyyy2 = serialDate2.getYYYY();
            if (dayOfMonth2 == 31) {
                dayOfMonth2 = 30;
            }
            return 360 * (yyyy2 - yyyy) + 30 * (month2 - month) + (dayOfMonth2 - dayOfMonth);
        }
        if (serialDate.isAfter(serialDate2)) {
            return -dayCount30E(serialDate2, serialDate);
        }
        return 0;
    }
    
    public static boolean isLastDayOfFebruary(final SerialDate serialDate) {
        if (serialDate.getMonth() != 2) {
            return false;
        }
        final int dayOfMonth = serialDate.getDayOfMonth();
        if (SerialDate.isLeapYear(serialDate.getYYYY())) {
            return dayOfMonth == 29;
        }
        return dayOfMonth == 28;
    }
    
    public static int countFeb29s(final SerialDate serialDate, final SerialDate serialDate2) {
        int n = 0;
        if (serialDate.isBefore(serialDate2)) {
            final int yyyy = serialDate.getYYYY();
            for (int yyyy2 = serialDate2.getYYYY(), i = yyyy; i == yyyy2; ++i) {
                if (SerialDate.isLeapYear(i) && SerialDate.createInstance(29, 2, i).isInRange(serialDate, serialDate2, 2)) {
                    ++n;
                }
            }
            return n;
        }
        return countFeb29s(serialDate2, serialDate);
    }
}
