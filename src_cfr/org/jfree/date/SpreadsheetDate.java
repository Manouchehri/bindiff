/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.date;

import java.util.Calendar;
import java.util.Date;
import org.jfree.date.SerialDate;

public class SpreadsheetDate
extends SerialDate {
    private static final long serialVersionUID = -2039586705374454461L;
    private final int serial;
    private final int day;
    private final int month;
    private final int year;

    public SpreadsheetDate(int n2, int n3, int n4) {
        if (n4 < 1900) throw new IllegalArgumentException("The 'year' argument must be in range 1900 to 9999.");
        if (n4 > 9999) throw new IllegalArgumentException("The 'year' argument must be in range 1900 to 9999.");
        this.year = n4;
        if (n3 < 1) throw new IllegalArgumentException("The 'month' argument must be in the range 1 to 12.");
        if (n3 > 12) throw new IllegalArgumentException("The 'month' argument must be in the range 1 to 12.");
        this.month = n3;
        if (n2 < 1) throw new IllegalArgumentException("Invalid 'day' argument.");
        if (n2 > SerialDate.lastDayOfMonth(n3, n4)) throw new IllegalArgumentException("Invalid 'day' argument.");
        this.day = n2;
        this.serial = this.calcSerial(n2, n3, n4);
    }

    public SpreadsheetDate(int n2) {
        int n3;
        if (n2 < 2) throw new IllegalArgumentException("SpreadsheetDate: Serial must be in range 2 to 2958465.");
        if (n2 > 2958465) throw new IllegalArgumentException("SpreadsheetDate: Serial must be in range 2 to 2958465.");
        this.serial = n2;
        int n4 = this.serial - 2;
        int n5 = 1900 + n4 / 365;
        int n6 = SerialDate.leapYearCount(n5);
        int n7 = n4 - n6;
        int n8 = 1900 + n7 / 365;
        if (n8 == n5) {
            this.year = n8;
        } else {
            n3 = this.calcSerial(1, 1, n8);
            while (n3 <= this.serial) {
                n3 = this.calcSerial(1, 1, ++n8);
            }
            this.year = n8 - 1;
        }
        n3 = this.calcSerial(1, 1, this.year);
        int[] arrn = AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH;
        if (SpreadsheetDate.isLeapYear(this.year)) {
            arrn = LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH;
        }
        int n9 = 1;
        int n10 = n3 + arrn[n9] - 1;
        do {
            if (n10 >= this.serial) {
                this.month = n9 - 1;
                this.day = this.serial - n3 - arrn[this.month] + 1;
                return;
            }
            n10 = n3 + arrn[++n9] - 1;
        } while (true);
    }

    @Override
    public int toSerial() {
        return this.serial;
    }

    @Override
    public Date toDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.getYYYY(), this.getMonth() - 1, this.getDayOfMonth(), 0, 0, 0);
        return calendar.getTime();
    }

    @Override
    public int getYYYY() {
        return this.year;
    }

    @Override
    public int getMonth() {
        return this.month;
    }

    @Override
    public int getDayOfMonth() {
        return this.day;
    }

    @Override
    public int getDayOfWeek() {
        return (this.serial + 6) % 7 + 1;
    }

    public boolean equals(Object object) {
        if (!(object instanceof SerialDate)) return false;
        SerialDate serialDate = (SerialDate)object;
        if (serialDate.toSerial() != this.toSerial()) return false;
        return true;
    }

    public int hashCode() {
        return this.toSerial();
    }

    @Override
    public int compare(SerialDate serialDate) {
        return this.serial - serialDate.toSerial();
    }

    public int compareTo(Object object) {
        return this.compare((SerialDate)object);
    }

    @Override
    public boolean isOn(SerialDate serialDate) {
        if (this.serial != serialDate.toSerial()) return false;
        return true;
    }

    @Override
    public boolean isBefore(SerialDate serialDate) {
        if (this.serial >= serialDate.toSerial()) return false;
        return true;
    }

    @Override
    public boolean isOnOrBefore(SerialDate serialDate) {
        if (this.serial > serialDate.toSerial()) return false;
        return true;
    }

    @Override
    public boolean isAfter(SerialDate serialDate) {
        if (this.serial <= serialDate.toSerial()) return false;
        return true;
    }

    @Override
    public boolean isOnOrAfter(SerialDate serialDate) {
        if (this.serial < serialDate.toSerial()) return false;
        return true;
    }

    @Override
    public boolean isInRange(SerialDate serialDate, SerialDate serialDate2) {
        return this.isInRange(serialDate, serialDate2, 3);
    }

    @Override
    public boolean isInRange(SerialDate serialDate, SerialDate serialDate2, int n2) {
        int n3 = serialDate.toSerial();
        int n4 = serialDate2.toSerial();
        int n5 = Math.min(n3, n4);
        int n6 = Math.max(n3, n4);
        int n7 = this.toSerial();
        if (n2 == 3) {
            if (n7 < n5) return false;
            if (n7 > n6) return false;
            return true;
        }
        if (n2 == 1) {
            if (n7 < n5) return false;
            if (n7 >= n6) return false;
            return true;
        }
        if (n2 == 2) {
            if (n7 <= n5) return false;
            if (n7 > n6) return false;
            return true;
        }
        if (n7 <= n5) return false;
        if (n7 >= n6) return false;
        return true;
    }

    private int calcSerial(int n2, int n3, int n4) {
        int n5 = (n4 - 1900) * 365 + SerialDate.leapYearCount(n4 - 1);
        int n6 = SerialDate.AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH[n3];
        if (n3 > 2 && SerialDate.isLeapYear(n4)) {
            ++n6;
        }
        int n7 = n2;
        return n5 + n6 + n7 + 1;
    }
}

