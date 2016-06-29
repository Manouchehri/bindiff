package org.jfree.date;

import org.jfree.date.AnnualDateRule;
import org.jfree.date.SerialDate;

public class DayOfWeekInMonthRule extends AnnualDateRule {
   private int count;
   private int dayOfWeek;
   private int month;

   public DayOfWeekInMonthRule() {
      this(1, 2, 1);
   }

   public DayOfWeekInMonthRule(int var1, int var2, int var3) {
      this.count = var1;
      this.dayOfWeek = var2;
      this.month = var3;
   }

   public int getCount() {
      return this.count;
   }

   public void setCount(int var1) {
      this.count = var1;
   }

   public int getDayOfWeek() {
      return this.dayOfWeek;
   }

   public void setDayOfWeek(int var1) {
      this.dayOfWeek = var1;
   }

   public int getMonth() {
      return this.month;
   }

   public void setMonth(int var1) {
      this.month = var1;
   }

   public SerialDate getDate(int var1) {
      SerialDate var2;
      if(this.count != 0) {
         for(var2 = SerialDate.createInstance(1, this.month, var1); var2.getDayOfWeek() != this.dayOfWeek; var2 = SerialDate.addDays(1, var2)) {
            ;
         }

         var2 = SerialDate.addDays(7 * (this.count - 1), var2);
      } else {
         var2 = SerialDate.createInstance(1, this.month, var1);

         for(var2 = var2.getEndOfCurrentMonth(var2); var2.getDayOfWeek() != this.dayOfWeek; var2 = SerialDate.addDays(-1, var2)) {
            ;
         }
      }

      return var2;
   }
}
