package org.jfree.date;

public class RelativeDayOfWeekRule extends AnnualDateRule
{
    private AnnualDateRule subrule;
    private int dayOfWeek;
    private int relative;
    
    public RelativeDayOfWeekRule() {
        this(new DayAndMonthRule(), 2, 1);
    }
    
    public RelativeDayOfWeekRule(final AnnualDateRule subrule, final int dayOfWeek, final int relative) {
        this.subrule = subrule;
        this.dayOfWeek = dayOfWeek;
        this.relative = relative;
    }
    
    public AnnualDateRule getSubrule() {
        return this.subrule;
    }
    
    public void setSubrule(final AnnualDateRule subrule) {
        this.subrule = subrule;
    }
    
    public int getDayOfWeek() {
        return this.dayOfWeek;
    }
    
    public void setDayOfWeek(final int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    
    public int getRelative() {
        return this.relative;
    }
    
    public void setRelative(final int relative) {
        this.relative = relative;
    }
    
    public Object clone() {
        final RelativeDayOfWeekRule relativeDayOfWeekRule = (RelativeDayOfWeekRule)super.clone();
        relativeDayOfWeekRule.subrule = (AnnualDateRule)relativeDayOfWeekRule.getSubrule().clone();
        return relativeDayOfWeekRule;
    }
    
    public SerialDate getDate(final int n) {
        if (n < 1900 || n > 9999) {
            throw new IllegalArgumentException("RelativeDayOfWeekRule.getDate(): year outside valid range.");
        }
        SerialDate serialDate = null;
        final SerialDate date = this.subrule.getDate(n);
        if (date != null) {
            switch (this.relative) {
                case -1: {
                    serialDate = SerialDate.getPreviousDayOfWeek(this.dayOfWeek, date);
                    break;
                }
                case 0: {
                    serialDate = SerialDate.getNearestDayOfWeek(this.dayOfWeek, date);
                    break;
                }
                case 1: {
                    serialDate = SerialDate.getFollowingDayOfWeek(this.dayOfWeek, date);
                    break;
                }
            }
        }
        return serialDate;
    }
}
