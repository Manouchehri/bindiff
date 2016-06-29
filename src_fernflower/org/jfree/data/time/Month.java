package org.jfree.data.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriodFormatException;
import org.jfree.data.time.Year;
import org.jfree.date.SerialDate;

public class Month extends RegularTimePeriod implements Serializable {
   private static final long serialVersionUID = -5090216912548722570L;
   private int month;
   private int year;
   private long firstMillisecond;
   private long lastMillisecond;

   public Month() {
      this(new Date());
   }

   public Month(int var1, int var2) {
      if(var1 >= 1 && var1 <= 12) {
         this.month = var1;
         this.year = var2;
         this.peg(Calendar.getInstance());
      } else {
         throw new IllegalArgumentException("Month outside valid range.");
      }
   }

   public Month(int var1, Year var2) {
      if(var1 >= 1 && var1 <= 12) {
         this.month = var1;
         this.year = var2.getYear();
         this.peg(Calendar.getInstance());
      } else {
         throw new IllegalArgumentException("Month outside valid range.");
      }
   }

   public Month(Date var1) {
      this(var1, RegularTimePeriod.DEFAULT_TIME_ZONE);
   }

   public Month(Date var1, TimeZone var2) {
      Calendar var3 = Calendar.getInstance(var2);
      var3.setTime(var1);
      this.month = var3.get(2) + 1;
      this.year = var3.get(1);
      this.peg(Calendar.getInstance());
   }

   public Year getYear() {
      return new Year(this.year);
   }

   public int getYearValue() {
      return this.year;
   }

   public int getMonth() {
      return this.month;
   }

   public long getFirstMillisecond() {
      return this.firstMillisecond;
   }

   public long getLastMillisecond() {
      return this.lastMillisecond;
   }

   public void peg(Calendar var1) {
      this.firstMillisecond = this.getFirstMillisecond(var1);
      this.lastMillisecond = this.getLastMillisecond(var1);
   }

   public RegularTimePeriod previous() {
      Month var1;
      if(this.month != 1) {
         var1 = new Month(this.month - 1, this.year);
      } else if(this.year > 1900) {
         var1 = new Month(12, this.year - 1);
      } else {
         var1 = null;
      }

      return var1;
   }

   public RegularTimePeriod next() {
      Month var1;
      if(this.month != 12) {
         var1 = new Month(this.month + 1, this.year);
      } else if(this.year < 9999) {
         var1 = new Month(1, this.year + 1);
      } else {
         var1 = null;
      }

      return var1;
   }

   public long getSerialIndex() {
      return (long)this.year * 12L + (long)this.month;
   }

   public String toString() {
      return SerialDate.monthCodeToString(this.month) + " " + this.year;
   }

   public boolean equals(Object var1) {
      if(var1 != null) {
         if(!(var1 instanceof Month)) {
            return false;
         } else {
            Month var2 = (Month)var1;
            return this.month == var2.getMonth() && this.year == var2.getYearValue();
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      byte var1 = 17;
      int var2 = 37 * var1 + this.month;
      var2 = 37 * var2 + this.year;
      return var2;
   }

   public int compareTo(Object var1) {
      int var2;
      if(var1 instanceof Month) {
         Month var3 = (Month)var1;
         var2 = this.year - var3.getYearValue();
         if(var2 == 0) {
            var2 = this.month - var3.getMonth();
         }
      } else if(var1 instanceof RegularTimePeriod) {
         var2 = 0;
      } else {
         var2 = 1;
      }

      return var2;
   }

   public long getFirstMillisecond(Calendar var1) {
      var1.set(this.year, this.month - 1, 1, 0, 0, 0);
      var1.set(14, 0);
      return var1.getTime().getTime();
   }

   public long getLastMillisecond(Calendar var1) {
      int var2 = SerialDate.lastDayOfMonth(this.month, this.year);
      var1.set(this.year, this.month - 1, var2, 23, 59, 59);
      var1.set(14, 999);
      return var1.getTime().getTime();
   }

   public static Month parseMonth(String var0) {
      Month var1 = null;
      if(var0 != null) {
         var0 = var0.trim();
         int var2 = findSeparator(var0);
         if(var2 == -1) {
            throw new TimePeriodFormatException("Could not find separator.");
         }

         String var3 = var0.substring(0, var2).trim();
         String var4 = var0.substring(var2 + 1, var0.length()).trim();
         Year var5 = evaluateAsYear(var3);
         int var6;
         if(var5 != null) {
            var6 = SerialDate.stringToMonthCode(var4);
            if(var6 == -1) {
               throw new TimePeriodFormatException("Can\'t evaluate the month.");
            }

            var1 = new Month(var6, var5);
         } else {
            var5 = evaluateAsYear(var4);
            if(var5 == null) {
               throw new TimePeriodFormatException("Can\'t evaluate the year.");
            }

            var6 = SerialDate.stringToMonthCode(var3);
            if(var6 == -1) {
               throw new TimePeriodFormatException("Can\'t evaluate the month.");
            }

            var1 = new Month(var6, var5);
         }
      }

      return var1;
   }

   private static int findSeparator(String var0) {
      int var1 = var0.indexOf(45);
      if(var1 == -1) {
         var1 = var0.indexOf(44);
      }

      if(var1 == -1) {
         var1 = var0.indexOf(32);
      }

      if(var1 == -1) {
         var1 = var0.indexOf(46);
      }

      return var1;
   }

   private static Year evaluateAsYear(String var0) {
      Year var1 = null;

      try {
         var1 = Year.parseYear(var0);
      } catch (TimePeriodFormatException var3) {
         ;
      }

      return var1;
   }
}
