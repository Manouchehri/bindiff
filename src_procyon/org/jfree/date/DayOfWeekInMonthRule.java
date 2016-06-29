package org.jfree.date;

public class DayOfWeekInMonthRule extends AnnualDateRule
{
    private int count;
    private int dayOfWeek;
    private int month;
    
    public DayOfWeekInMonthRule() {
        this(1, 2, 1);
    }
    
    public DayOfWeekInMonthRule(final int count, final int dayOfWeek, final int month) {
        this.count = count;
        this.dayOfWeek = dayOfWeek;
        this.month = month;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public void setCount(final int count) {
        this.count = count;
    }
    
    public int getDayOfWeek() {
        return this.dayOfWeek;
    }
    
    public void setDayOfWeek(final int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    
    public int getMonth() {
        return this.month;
    }
    
    public void setMonth(final int month) {
        this.month = month;
    }
    
    public SerialDate getDate(final int n) {
        SerialDate serialDate2;
        if (this.count != 0) {
            SerialDate serialDate;
            for (serialDate = SerialDate.createInstance(1, this.month, n); serialDate.getDayOfWeek() != this.dayOfWeek; serialDate = SerialDate.addDays(1, serialDate)) {}
            serialDate2 = SerialDate.addDays(7 * (this.count - 1), serialDate);
        }
        else {
            final SerialDate instance = SerialDate.createInstance(1, this.month, n);
            for (serialDate2 = instance.getEndOfCurrentMonth(instance); serialDate2.getDayOfWeek() != this.dayOfWeek; serialDate2 = SerialDate.addDays(-1, serialDate2)) {}
        }
        return serialDate2;
    }
}
