/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.date;

import org.jfree.date.AnnualDateRule;
import org.jfree.date.DayAndMonthRule;
import org.jfree.date.SerialDate;

public class RelativeDayOfWeekRule
extends AnnualDateRule {
    private AnnualDateRule subrule;
    private int dayOfWeek;
    private int relative;

    public RelativeDayOfWeekRule() {
        this(new DayAndMonthRule(), 2, 1);
    }

    public RelativeDayOfWeekRule(AnnualDateRule annualDateRule, int n2, int n3) {
        this.subrule = annualDateRule;
        this.dayOfWeek = n2;
        this.relative = n3;
    }

    public AnnualDateRule getSubrule() {
        return this.subrule;
    }

    public void setSubrule(AnnualDateRule annualDateRule) {
        this.subrule = annualDateRule;
    }

    public int getDayOfWeek() {
        return this.dayOfWeek;
    }

    public void setDayOfWeek(int n2) {
        this.dayOfWeek = n2;
    }

    public int getRelative() {
        return this.relative;
    }

    public void setRelative(int n2) {
        this.relative = n2;
    }

    @Override
    public Object clone() {
        RelativeDayOfWeekRule relativeDayOfWeekRule = (RelativeDayOfWeekRule)super.clone();
        relativeDayOfWeekRule.subrule = (AnnualDateRule)relativeDayOfWeekRule.getSubrule().clone();
        return relativeDayOfWeekRule;
    }

    @Override
    public SerialDate getDate(int n2) {
        if (n2 < 1900) throw new IllegalArgumentException("RelativeDayOfWeekRule.getDate(): year outside valid range.");
        if (n2 > 9999) {
            throw new IllegalArgumentException("RelativeDayOfWeekRule.getDate(): year outside valid range.");
        }
        SerialDate serialDate = null;
        SerialDate serialDate2 = this.subrule.getDate(n2);
        if (serialDate2 == null) return serialDate;
        switch (this.relative) {
            case -1: {
                return SerialDate.getPreviousDayOfWeek(this.dayOfWeek, serialDate2);
            }
            case 0: {
                return SerialDate.getNearestDayOfWeek(this.dayOfWeek, serialDate2);
            }
            case 1: {
                serialDate = SerialDate.getFollowingDayOfWeek(this.dayOfWeek, serialDate2);
                break;
            }
        }
        return serialDate;
    }
}

