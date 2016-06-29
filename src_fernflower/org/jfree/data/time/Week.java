package org.jfree.data.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriodFormatException;
import org.jfree.data.time.Year;

public class Week extends RegularTimePeriod implements Serializable {
   private static final long serialVersionUID = 1856387786939865061L;
   public static final int FIRST_WEEK_IN_YEAR = 1;
   public static final int LAST_WEEK_IN_YEAR = 53;
   private short year;
   private byte week;
   private long firstMillisecond;
   private long lastMillisecond;

   public Week() {
      this(new Date());
   }

   public Week(int var1, int var2) {
      if(var1 < 1 && var1 > 53) {
         throw new IllegalArgumentException("The \'week\' argument must be in the range 1 - 53.");
      } else {
         this.week = (byte)var1;
         this.year = (short)var2;
         this.peg(Calendar.getInstance());
      }
   }

   public Week(int var1, Year var2) {
      if(var1 < 1 && var1 > 53) {
         throw new IllegalArgumentException("The \'week\' argument must be in the range 1 - 53.");
      } else {
         this.week = (byte)var1;
         this.year = (short)var2.getYear();
         this.peg(Calendar.getInstance());
      }
   }

   public Week(Date var1) {
      this(var1, RegularTimePeriod.DEFAULT_TIME_ZONE);
   }

   public Week(Date var1, TimeZone var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'time\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'zone\' argument.");
      } else {
         Calendar var3 = Calendar.getInstance(var2);
         var3.setTime(var1);
         int var4 = var3.get(3);
         if(var4 == 1 && var3.get(2) == 11) {
            this.week = 1;
            this.year = (short)(var3.get(1) + 1);
         } else {
            this.week = (byte)Math.min(var4, 53);
            int var5 = var3.get(1);
            if(var3.get(2) == 0 && this.week >= 52) {
               --var5;
            }

            this.year = (short)var5;
         }

         this.peg(var3);
      }
   }

   public Year getYear() {
      return new Year(this.year);
   }

   public int getYearValue() {
      return this.year;
   }

   public int getWeek() {
      return this.week;
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
      Week var1;
      if(this.week != 1) {
         var1 = new Week(this.week - 1, this.year);
      } else if(this.year > 1900) {
         int var2 = this.year - 1;
         Calendar var3 = Calendar.getInstance();
         var3.set(var2, 11, 31);
         var1 = new Week(var3.getActualMaximum(3), var2);
      } else {
         var1 = null;
      }

      return var1;
   }

   public RegularTimePeriod next() {
      Week var1;
      if(this.week < 52) {
         var1 = new Week(this.week + 1, this.year);
      } else {
         Calendar var2 = Calendar.getInstance();
         var2.set(this.year, 11, 31);
         int var3 = var2.getActualMaximum(3);
         if(this.week < var3) {
            var1 = new Week(this.week + 1, this.year);
         } else if(this.year < 9999) {
            var1 = new Week(1, this.year + 1);
         } else {
            var1 = null;
         }
      }

      return var1;
   }

   public long getSerialIndex() {
      return (long)this.year * 53L + (long)this.week;
   }

   public long getFirstMillisecond(Calendar var1) {
      Calendar var2 = (Calendar)var1.clone();
      var2.clear();
      var2.set(1, this.year);
      var2.set(3, this.week);
      var2.set(7, var2.getFirstDayOfWeek());
      var2.set(10, 0);
      var2.set(12, 0);
      var2.set(13, 0);
      var2.set(14, 0);
      return var2.getTime().getTime();
   }

   public long getLastMillisecond(Calendar var1) {
      Calendar var2 = (Calendar)var1.clone();
      var2.clear();
      var2.set(1, this.year);
      var2.set(3, this.week + 1);
      var2.set(7, var2.getFirstDayOfWeek());
      var2.set(10, 0);
      var2.set(12, 0);
      var2.set(13, 0);
      var2.set(14, 0);
      return var2.getTime().getTime() - 1L;
   }

   public String toString() {
      return "Week " + this.week + ", " + this.year;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Week)) {
         return false;
      } else {
         Week var2 = (Week)var1;
         return this.week != var2.week?false:this.year == var2.year;
      }
   }

   public int hashCode() {
      byte var1 = 17;
      int var2 = 37 * var1 + this.week;
      var2 = 37 * var2 + this.year;
      return var2;
   }

   public int compareTo(Object var1) {
      int var2;
      if(var1 instanceof Week) {
         Week var3 = (Week)var1;
         var2 = this.year - var3.getYear().getYear();
         if(var2 == 0) {
            var2 = this.week - var3.getWeek();
         }
      } else if(var1 instanceof RegularTimePeriod) {
         var2 = 0;
      } else {
         var2 = 1;
      }

      return var2;
   }

   public static Week parseWeek(String var0) {
      Week var1 = null;
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
            var6 = stringToWeek(var4);
            if(var6 == -1) {
               throw new TimePeriodFormatException("Can\'t evaluate the week.");
            }

            var1 = new Week(var6, var5);
         } else {
            var5 = evaluateAsYear(var4);
            if(var5 == null) {
               throw new TimePeriodFormatException("Can\'t evaluate the year.");
            }

            var6 = stringToWeek(var3);
            if(var6 == -1) {
               throw new TimePeriodFormatException("Can\'t evaluate the week.");
            }

            var1 = new Week(var6, var5);
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

   private static int stringToWeek(String var0) {
      int var1 = -1;
      var0 = var0.replace('W', ' ');
      var0 = var0.trim();

      try {
         var1 = Integer.parseInt(var0);
         if(var1 < 1 || var1 > 53) {
            var1 = -1;
         }
      } catch (NumberFormatException var3) {
         ;
      }

      return var1;
   }
}
