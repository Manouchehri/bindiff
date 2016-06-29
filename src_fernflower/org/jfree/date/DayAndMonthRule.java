package org.jfree.date;

import org.jfree.date.AnnualDateRule;
import org.jfree.date.SerialDate;

public class DayAndMonthRule extends AnnualDateRule {
   private int dayOfMonth;
   private int month;

   public DayAndMonthRule() {
      this(1, 1);
   }

   public DayAndMonthRule(int var1, int var2) {
      this.setMonth(var2);
      this.setDayOfMonth(var1);
   }

   public int getDayOfMonth() {
      return this.dayOfMonth;
   }

   public void setDayOfMonth(int var1) {
      if(var1 >= 1 && var1 <= SerialDate.LAST_DAY_OF_MONTH[this.month]) {
         this.dayOfMonth = var1;
      } else {
         throw new IllegalArgumentException("DayAndMonthRule(): dayOfMonth outside valid range.");
      }
   }

   public int getMonth() {
      return this.month;
   }

   public void setMonth(int var1) {
      if(!SerialDate.isValidMonthCode(var1)) {
         throw new IllegalArgumentException("DayAndMonthRule(): month code not valid.");
      } else {
         this.month = var1;
      }
   }

   public SerialDate getDate(int var1) {
      return SerialDate.createInstance(this.dayOfMonth, this.month, var1);
   }
}
