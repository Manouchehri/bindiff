/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.date;

import org.jfree.date.AnnualDateRule;
import org.jfree.date.SerialDate;

public class DayAndMonthRule
extends AnnualDateRule {
    private int dayOfMonth;
    private int month;

    public DayAndMonthRule() {
        this(1, 1);
    }

    public DayAndMonthRule(int n2, int n3) {
        this.setMonth(n3);
        this.setDayOfMonth(n2);
    }

    public int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public void setDayOfMonth(int n2) {
        if (n2 < 1) throw new IllegalArgumentException("DayAndMonthRule(): dayOfMonth outside valid range.");
        if (n2 > SerialDate.LAST_DAY_OF_MONTH[this.month]) {
            throw new IllegalArgumentException("DayAndMonthRule(): dayOfMonth outside valid range.");
        }
        this.dayOfMonth = n2;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int n2) {
        if (!SerialDate.isValidMonthCode(n2)) {
            throw new IllegalArgumentException("DayAndMonthRule(): month code not valid.");
        }
        this.month = n2;
    }

    @Override
    public SerialDate getDate(int n2) {
        return SerialDate.createInstance(this.dayOfMonth, this.month, n2);
    }
}

