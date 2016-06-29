package org.jfree.date;

import java.util.*;

public class SpreadsheetDate extends SerialDate
{
    private static final long serialVersionUID = -2039586705374454461L;
    private final int serial;
    private final int day;
    private final int month;
    private final int year;
    
    public SpreadsheetDate(final int day, final int month, final int year) {
        if (year < 1900 || year > 9999) {
            throw new IllegalArgumentException("The 'year' argument must be in range 1900 to 9999.");
        }
        this.year = year;
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("The 'month' argument must be in the range 1 to 12.");
        }
        this.month = month;
        if (day >= 1 && day <= SerialDate.lastDayOfMonth(month, year)) {
            this.day = day;
            this.serial = this.calcSerial(day, month, year);
            return;
        }
        throw new IllegalArgumentException("Invalid 'day' argument.");
    }
    
    public SpreadsheetDate(final int serial) {
        if (serial >= 2 && serial <= 2958465) {
            this.serial = serial;
            final int n = this.serial - 2;
            final int n2 = 1900 + n / 365;
            int year = 1900 + (n - SerialDate.leapYearCount(n2)) / 365;
            if (year == n2) {
                this.year = year;
            }
            else {
                for (int i = this.calcSerial(1, 1, year); i <= this.serial; i = this.calcSerial(1, 1, year)) {
                    ++year;
                }
                this.year = year - 1;
            }
            final int calcSerial = this.calcSerial(1, 1, this.year);
            int[] array = SpreadsheetDate.AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH;
            if (SerialDate.isLeapYear(this.year)) {
                array = SpreadsheetDate.LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH;
            }
            int n3 = 1;
            for (int j = calcSerial + array[n3] - 1; j < this.serial; j = calcSerial + array[n3] - 1) {
                ++n3;
            }
            this.month = n3 - 1;
            this.day = this.serial - calcSerial - array[this.month] + 1;
            return;
        }
        throw new IllegalArgumentException("SpreadsheetDate: Serial must be in range 2 to 2958465.");
    }
    
    public int toSerial() {
        return this.serial;
    }
    
    public Date toDate() {
        final Calendar instance = Calendar.getInstance();
        instance.set(this.getYYYY(), this.getMonth() - 1, this.getDayOfMonth(), 0, 0, 0);
        return instance.getTime();
    }
    
    public int getYYYY() {
        return this.year;
    }
    
    public int getMonth() {
        return this.month;
    }
    
    public int getDayOfMonth() {
        return this.day;
    }
    
    public int getDayOfWeek() {
        return (this.serial + 6) % 7 + 1;
    }
    
    public boolean equals(final Object o) {
        return o instanceof SerialDate && ((SerialDate)o).toSerial() == this.toSerial();
    }
    
    public int hashCode() {
        return this.toSerial();
    }
    
    public int compare(final SerialDate serialDate) {
        return this.serial - serialDate.toSerial();
    }
    
    public int compareTo(final Object o) {
        return this.compare((SerialDate)o);
    }
    
    public boolean isOn(final SerialDate serialDate) {
        return this.serial == serialDate.toSerial();
    }
    
    public boolean isBefore(final SerialDate serialDate) {
        return this.serial < serialDate.toSerial();
    }
    
    public boolean isOnOrBefore(final SerialDate serialDate) {
        return this.serial <= serialDate.toSerial();
    }
    
    public boolean isAfter(final SerialDate serialDate) {
        return this.serial > serialDate.toSerial();
    }
    
    public boolean isOnOrAfter(final SerialDate serialDate) {
        return this.serial >= serialDate.toSerial();
    }
    
    public boolean isInRange(final SerialDate serialDate, final SerialDate serialDate2) {
        return this.isInRange(serialDate, serialDate2, 3);
    }
    
    public boolean isInRange(final SerialDate serialDate, final SerialDate serialDate2, final int n) {
        final int serial = serialDate.toSerial();
        final int serial2 = serialDate2.toSerial();
        final int min = Math.min(serial, serial2);
        final int max = Math.max(serial, serial2);
        final int serial3 = this.toSerial();
        if (n == 3) {
            return serial3 >= min && serial3 <= max;
        }
        if (n == 1) {
            return serial3 >= min && serial3 < max;
        }
        if (n == 2) {
            return serial3 > min && serial3 <= max;
        }
        return serial3 > min && serial3 < max;
    }
    
    private int calcSerial(final int n, final int n2, final int n3) {
        final int n4 = (n3 - 1900) * 365 + SerialDate.leapYearCount(n3 - 1);
        int n5 = SerialDate.AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH[n2];
        if (n2 > 2 && SerialDate.isLeapYear(n3)) {
            ++n5;
        }
        return n4 + n5 + n + 1;
    }
}
