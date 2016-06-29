/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.date;

import java.text.DateFormatSymbols;
import org.jfree.date.SerialDate;

public class SerialDateUtilities {
    private DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
    private String[] weekdays = this.dateFormatSymbols.getWeekdays();
    private String[] months = this.dateFormatSymbols.getMonths();

    public String[] getWeekdays() {
        return this.weekdays;
    }

    public String[] getMonths() {
        return this.months;
    }

    public int stringToWeekday(String string) {
        if (string.equals(this.weekdays[7])) {
            return 7;
        }
        if (string.equals(this.weekdays[1])) {
            return 1;
        }
        if (string.equals(this.weekdays[2])) {
            return 2;
        }
        if (string.equals(this.weekdays[3])) {
            return 3;
        }
        if (string.equals(this.weekdays[4])) {
            return 4;
        }
        if (!string.equals(this.weekdays[5])) return 6;
        return 5;
    }

    public static int dayCountActual(SerialDate serialDate, SerialDate serialDate2) {
        return serialDate2.compare(serialDate);
    }

    public static int dayCount30(SerialDate serialDate, SerialDate serialDate2) {
        if (!serialDate.isBefore(serialDate2)) return - SerialDateUtilities.dayCount30(serialDate2, serialDate);
        int n2 = serialDate.getDayOfMonth();
        int n3 = serialDate.getMonth();
        int n4 = serialDate.getYYYY();
        int n5 = serialDate2.getDayOfMonth();
        int n6 = serialDate2.getMonth();
        int n7 = serialDate2.getYYYY();
        return 360 * (n7 - n4) + 30 * (n6 - n3) + (n5 - n2);
    }

    public static int dayCount30ISDA(SerialDate serialDate, SerialDate serialDate2) {
        if (!serialDate.isBefore(serialDate2)) {
            if (!serialDate.isAfter(serialDate2)) return 0;
            return - SerialDateUtilities.dayCount30ISDA(serialDate2, serialDate);
        }
        int n2 = serialDate.getDayOfMonth();
        int n3 = serialDate.getMonth();
        int n4 = serialDate.getYYYY();
        if (n2 == 31) {
            n2 = 30;
        }
        int n5 = serialDate2.getDayOfMonth();
        int n6 = serialDate2.getMonth();
        int n7 = serialDate2.getYYYY();
        if (n5 != 31) return 360 * (n7 - n4) + 30 * (n6 - n3) + (n5 - n2);
        if (n2 != 30) return 360 * (n7 - n4) + 30 * (n6 - n3) + (n5 - n2);
        n5 = 30;
        return 360 * (n7 - n4) + 30 * (n6 - n3) + (n5 - n2);
    }

    public static int dayCount30PSA(SerialDate serialDate, SerialDate serialDate2) {
        if (!serialDate.isOnOrBefore(serialDate2)) return - SerialDateUtilities.dayCount30PSA(serialDate2, serialDate);
        int n2 = serialDate.getDayOfMonth();
        int n3 = serialDate.getMonth();
        int n4 = serialDate.getYYYY();
        if (SerialDateUtilities.isLastDayOfFebruary(serialDate)) {
            n2 = 30;
        }
        if (n2 == 31 || SerialDateUtilities.isLastDayOfFebruary(serialDate)) {
            n2 = 30;
        }
        int n5 = serialDate2.getDayOfMonth();
        int n6 = serialDate2.getMonth();
        int n7 = serialDate2.getYYYY();
        if (n5 != 31) return 360 * (n7 - n4) + 30 * (n6 - n3) + (n5 - n2);
        if (n2 != 30) return 360 * (n7 - n4) + 30 * (n6 - n3) + (n5 - n2);
        n5 = 30;
        return 360 * (n7 - n4) + 30 * (n6 - n3) + (n5 - n2);
    }

    public static int dayCount30E(SerialDate serialDate, SerialDate serialDate2) {
        if (!serialDate.isBefore(serialDate2)) {
            if (!serialDate.isAfter(serialDate2)) return 0;
            return - SerialDateUtilities.dayCount30E(serialDate2, serialDate);
        }
        int n2 = serialDate.getDayOfMonth();
        int n3 = serialDate.getMonth();
        int n4 = serialDate.getYYYY();
        if (n2 == 31) {
            n2 = 30;
        }
        int n5 = serialDate2.getDayOfMonth();
        int n6 = serialDate2.getMonth();
        int n7 = serialDate2.getYYYY();
        if (n5 != 31) return 360 * (n7 - n4) + 30 * (n6 - n3) + (n5 - n2);
        n5 = 30;
        return 360 * (n7 - n4) + 30 * (n6 - n3) + (n5 - n2);
    }

    public static boolean isLastDayOfFebruary(SerialDate serialDate) {
        if (serialDate.getMonth() != 2) return false;
        int n2 = serialDate.getDayOfMonth();
        if (SerialDate.isLeapYear(serialDate.getYYYY())) {
            if (n2 != 29) return false;
            return true;
        }
        if (n2 != 28) return false;
        return true;
    }

    public static int countFeb29s(SerialDate serialDate, SerialDate serialDate2) {
        int n2 = 0;
        if (!serialDate.isBefore(serialDate2)) return SerialDateUtilities.countFeb29s(serialDate2, serialDate);
        int n3 = serialDate.getYYYY();
        int n4 = serialDate2.getYYYY();
        int n5 = n3;
        while (n5 == n4) {
            SerialDate serialDate3;
            if (SerialDate.isLeapYear(n5) && (serialDate3 = SerialDate.createInstance(29, 2, n5)).isInRange(serialDate, serialDate2, 2)) {
                ++n2;
            }
            ++n5;
        }
        return n2;
    }
}

