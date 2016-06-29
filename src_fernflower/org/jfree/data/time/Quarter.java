package org.jfree.data.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriodFormatException;
import org.jfree.data.time.Year;
import org.jfree.date.SerialDate;

public class Quarter extends RegularTimePeriod implements Serializable {
   private static final long serialVersionUID = 3810061714380888671L;
   public static final int FIRST_QUARTER = 1;
   public static final int LAST_QUARTER = 4;
   public static final int[] FIRST_MONTH_IN_QUARTER = new int[]{0, 1, 4, 7, 10};
   public static final int[] LAST_MONTH_IN_QUARTER = new int[]{0, 3, 6, 9, 12};
   private short year;
   private byte quarter;
   private long firstMillisecond;
   private long lastMillisecond;

   public Quarter() {
      this(new Date());
   }

   public Quarter(int var1, int var2) {
      if(var1 >= 1 && var1 <= 4) {
         this.year = (short)var2;
         this.quarter = (byte)var1;
         this.peg(Calendar.getInstance());
      } else {
         throw new IllegalArgumentException("Quarter outside valid range.");
      }
   }

   public Quarter(int var1, Year var2) {
      if(var1 >= 1 && var1 <= 4) {
         this.year = (short)var2.getYear();
         this.quarter = (byte)var1;
         this.peg(Calendar.getInstance());
      } else {
         throw new IllegalArgumentException("Quarter outside valid range.");
      }
   }

   public Quarter(Date var1) {
      this(var1, RegularTimePeriod.DEFAULT_TIME_ZONE);
   }

   public Quarter(Date var1, TimeZone var2) {
      Calendar var3 = Calendar.getInstance(var2);
      var3.setTime(var1);
      int var4 = var3.get(2) + 1;
      this.quarter = (byte)SerialDate.monthCodeToQuarter(var4);
      this.year = (short)var3.get(1);
      this.peg(var3);
   }

   public int getQuarter() {
      return this.quarter;
   }

   public Year getYear() {
      return new Year(this.year);
   }

   public int getYearValue() {
      return this.year;
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
      Quarter var1;
      if(this.quarter > 1) {
         var1 = new Quarter(this.quarter - 1, this.year);
      } else if(this.year > 1900) {
         var1 = new Quarter(4, this.year - 1);
      } else {
         var1 = null;
      }

      return var1;
   }

   public RegularTimePeriod next() {
      Quarter var1;
      if(this.quarter < 4) {
         var1 = new Quarter(this.quarter + 1, this.year);
      } else if(this.year < 9999) {
         var1 = new Quarter(1, this.year + 1);
      } else {
         var1 = null;
      }

      return var1;
   }

   public long getSerialIndex() {
      return (long)this.year * 4L + (long)this.quarter;
   }

   public boolean equals(Object var1) {
      if(var1 != null) {
         if(!(var1 instanceof Quarter)) {
            return false;
         } else {
            Quarter var2 = (Quarter)var1;
            return this.quarter == var2.getQuarter() && this.year == var2.getYearValue();
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      byte var1 = 17;
      int var2 = 37 * var1 + this.quarter;
      var2 = 37 * var2 + this.year;
      return var2;
   }

   public int compareTo(Object var1) {
      int var2;
      if(var1 instanceof Quarter) {
         Quarter var3 = (Quarter)var1;
         var2 = this.year - var3.getYearValue();
         if(var2 == 0) {
            var2 = this.quarter - var3.getQuarter();
         }
      } else if(var1 instanceof RegularTimePeriod) {
         var2 = 0;
      } else {
         var2 = 1;
      }

      return var2;
   }

   public String toString() {
      return "Q" + this.quarter + "/" + this.year;
   }

   public long getFirstMillisecond(Calendar var1) {
      int var2 = FIRST_MONTH_IN_QUARTER[this.quarter];
      var1.set(this.year, var2 - 1, 1, 0, 0, 0);
      var1.set(14, 0);
      return var1.getTime().getTime();
   }

   public long getLastMillisecond(Calendar var1) {
      int var2 = LAST_MONTH_IN_QUARTER[this.quarter];
      int var3 = SerialDate.lastDayOfMonth(var2, this.year);
      var1.set(this.year, var2 - 1, var3, 23, 59, 59);
      var1.set(14, 999);
      return var1.getTime().getTime();
   }

   public static Quarter parseQuarter(String var0) {
      int var1 = var0.indexOf("Q");
      if(var1 == -1) {
         throw new TimePeriodFormatException("Missing Q.");
      } else if(var1 == var0.length() - 1) {
         throw new TimePeriodFormatException("Q found at end of string.");
      } else {
         String var2 = var0.substring(var1 + 1, var1 + 2);
         int var3 = Integer.parseInt(var2);
         String var4 = var0.substring(0, var1) + var0.substring(var1 + 2, var0.length());
         var4 = var4.replace('/', ' ');
         var4 = var4.replace(',', ' ');
         var4 = var4.replace('-', ' ');
         Year var5 = Year.parseYear(var4.trim());
         Quarter var6 = new Quarter(var3, var5);
         return var6;
      }
   }
}
