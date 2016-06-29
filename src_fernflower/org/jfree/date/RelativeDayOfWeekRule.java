package org.jfree.date;

import org.jfree.date.AnnualDateRule;
import org.jfree.date.DayAndMonthRule;
import org.jfree.date.SerialDate;

public class RelativeDayOfWeekRule extends AnnualDateRule {
   private AnnualDateRule subrule;
   private int dayOfWeek;
   private int relative;

   public RelativeDayOfWeekRule() {
      this(new DayAndMonthRule(), 2, 1);
   }

   public RelativeDayOfWeekRule(AnnualDateRule var1, int var2, int var3) {
      this.subrule = var1;
      this.dayOfWeek = var2;
      this.relative = var3;
   }

   public AnnualDateRule getSubrule() {
      return this.subrule;
   }

   public void setSubrule(AnnualDateRule var1) {
      this.subrule = var1;
   }

   public int getDayOfWeek() {
      return this.dayOfWeek;
   }

   public void setDayOfWeek(int var1) {
      this.dayOfWeek = var1;
   }

   public int getRelative() {
      return this.relative;
   }

   public void setRelative(int var1) {
      this.relative = var1;
   }

   public Object clone() {
      RelativeDayOfWeekRule var1 = (RelativeDayOfWeekRule)super.clone();
      var1.subrule = (AnnualDateRule)var1.getSubrule().clone();
      return var1;
   }

   public SerialDate getDate(int var1) {
      if(var1 >= 1900 && var1 <= 9999) {
         SerialDate var2 = null;
         SerialDate var3 = this.subrule.getDate(var1);
         if(var3 != null) {
            switch(this.relative) {
            case -1:
               var2 = SerialDate.getPreviousDayOfWeek(this.dayOfWeek, var3);
               break;
            case 0:
               var2 = SerialDate.getNearestDayOfWeek(this.dayOfWeek, var3);
               break;
            case 1:
               var2 = SerialDate.getFollowingDayOfWeek(this.dayOfWeek, var3);
            }
         }

         return var2;
      } else {
         throw new IllegalArgumentException("RelativeDayOfWeekRule.getDate(): year outside valid range.");
      }
   }
}
