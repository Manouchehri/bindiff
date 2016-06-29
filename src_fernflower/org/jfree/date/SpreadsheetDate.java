package org.jfree.date;

import java.util.Calendar;
import java.util.Date;
import org.jfree.date.SerialDate;

public class SpreadsheetDate extends SerialDate {
   private static final long serialVersionUID = -2039586705374454461L;
   private final int serial;
   private final int day;
   private final int month;
   private final int year;

   public SpreadsheetDate(int var1, int var2, int var3) {
      if(var3 >= 1900 && var3 <= 9999) {
         this.year = var3;
         if(var2 >= 1 && var2 <= 12) {
            this.month = var2;
            if(var1 >= 1 && var1 <= SerialDate.lastDayOfMonth(var2, var3)) {
               this.day = var1;
               this.serial = this.calcSerial(var1, var2, var3);
            } else {
               throw new IllegalArgumentException("Invalid \'day\' argument.");
            }
         } else {
            throw new IllegalArgumentException("The \'month\' argument must be in the range 1 to 12.");
         }
      } else {
         throw new IllegalArgumentException("The \'year\' argument must be in range 1900 to 9999.");
      }
   }

   public SpreadsheetDate(int var1) {
      if(var1 >= 2 && var1 <= 2958465) {
         this.serial = var1;
         int var2 = this.serial - 2;
         int var3 = 1900 + var2 / 365;
         int var4 = SerialDate.leapYearCount(var3);
         int var5 = var2 - var4;
         int var6 = 1900 + var5 / 365;
         int var7;
         if(var6 == var3) {
            this.year = var6;
         } else {
            for(var7 = this.calcSerial(1, 1, var6); var7 <= this.serial; var7 = this.calcSerial(1, 1, var6)) {
               ++var6;
            }

            this.year = var6 - 1;
         }

         var7 = this.calcSerial(1, 1, this.year);
         int[] var8 = AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH;
         if(isLeapYear(this.year)) {
            var8 = LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH;
         }

         int var9 = 1;

         for(int var10 = var7 + var8[var9] - 1; var10 < this.serial; var10 = var7 + var8[var9] - 1) {
            ++var9;
         }

         this.month = var9 - 1;
         this.day = this.serial - var7 - var8[this.month] + 1;
      } else {
         throw new IllegalArgumentException("SpreadsheetDate: Serial must be in range 2 to 2958465.");
      }
   }

   public int toSerial() {
      return this.serial;
   }

   public Date toDate() {
      Calendar var1 = Calendar.getInstance();
      var1.set(this.getYYYY(), this.getMonth() - 1, this.getDayOfMonth(), 0, 0, 0);
      return var1.getTime();
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

   public boolean equals(Object var1) {
      if(var1 instanceof SerialDate) {
         SerialDate var2 = (SerialDate)var1;
         return var2.toSerial() == this.toSerial();
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.toSerial();
   }

   public int compare(SerialDate var1) {
      return this.serial - var1.toSerial();
   }

   public int compareTo(Object var1) {
      return this.compare((SerialDate)var1);
   }

   public boolean isOn(SerialDate var1) {
      return this.serial == var1.toSerial();
   }

   public boolean isBefore(SerialDate var1) {
      return this.serial < var1.toSerial();
   }

   public boolean isOnOrBefore(SerialDate var1) {
      return this.serial <= var1.toSerial();
   }

   public boolean isAfter(SerialDate var1) {
      return this.serial > var1.toSerial();
   }

   public boolean isOnOrAfter(SerialDate var1) {
      return this.serial >= var1.toSerial();
   }

   public boolean isInRange(SerialDate var1, SerialDate var2) {
      return this.isInRange(var1, var2, 3);
   }

   public boolean isInRange(SerialDate var1, SerialDate var2, int var3) {
      int var4 = var1.toSerial();
      int var5 = var2.toSerial();
      int var6 = Math.min(var4, var5);
      int var7 = Math.max(var4, var5);
      int var8 = this.toSerial();
      return var3 == 3?var8 >= var6 && var8 <= var7:(var3 == 1?var8 >= var6 && var8 < var7:(var3 == 2?var8 > var6 && var8 <= var7:var8 > var6 && var8 < var7));
   }

   private int calcSerial(int var1, int var2, int var3) {
      int var4 = (var3 - 1900) * 365 + SerialDate.leapYearCount(var3 - 1);
      int var5 = SerialDate.AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH[var2];
      if(var2 > 2 && SerialDate.isLeapYear(var3)) {
         ++var5;
      }

      return var4 + var5 + var1 + 1;
   }
}
