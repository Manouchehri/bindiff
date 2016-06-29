/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.date;

import org.jfree.date.AnnualDateRule;
import org.jfree.date.SerialDate;

public class DayOfWeekInMonthRule
extends AnnualDateRule {
    private int count;
    private int dayOfWeek;
    private int month;

    public DayOfWeekInMonthRule() {
        this(1, 2, 1);
    }

    public DayOfWeekInMonthRule(int n2, int n3, int n4) {
        this.count = n2;
        this.dayOfWeek = n3;
        this.month = n4;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int n2) {
        this.count = n2;
    }

    public int getDayOfWeek() {
        return this.dayOfWeek;
    }

    public void setDayOfWeek(int n2) {
        this.dayOfWeek = n2;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int n2) {
        this.month = n2;
    }

    @Override
    public SerialDate getDate(int n2) {
        SerialDate serialDate;
        if (this.count != 0) {
            serialDate = SerialDate.createInstance(1, this.month, n2);
            do {
                if (serialDate.getDayOfWeek() == this.dayOfWeek) {
                    return SerialDate.addDays(7 * (this.count - 1), serialDate);
                }
                serialDate = SerialDate.addDays(1, serialDate);
            } while (true);
        }
        serialDate = SerialDate.createInstance(1, this.month, n2);
        serialDate = serialDate.getEndOfCurrentMonth(serialDate);
        while (serialDate.getDayOfWeek() != this.dayOfWeek) {
            serialDate = SerialDate.addDays(-1, serialDate);
        }
        return serialDate;
    }
}

