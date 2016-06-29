package org.jfree.data.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriodFormatException;

public class Year extends RegularTimePeriod implements Serializable {
   private static final long serialVersionUID = -7659990929736074836L;
   private short year;
   private long firstMillisecond;
   private long lastMillisecond;

   public Year() {
      this(new Date());
   }

   public Year(int var1) {
      if(var1 >= 1900 && var1 <= 9999) {
         this.year = (short)var1;
         this.peg(Calendar.getInstance());
      } else {
         throw new IllegalArgumentException("Year constructor: year (" + var1 + ") outside valid range.");
      }
   }

   public Year(Date var1) {
      this(var1, RegularTimePeriod.DEFAULT_TIME_ZONE);
   }

   public Year(Date var1, TimeZone var2) {
      Calendar var3 = Calendar.getInstance(var2);
      var3.setTime(var1);
      this.year = (short)var3.get(1);
      this.peg(var3);
   }

   public int getYear() {
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
      return this.year > 1900?new Year(this.year - 1):null;
   }

   public RegularTimePeriod next() {
      return this.year < 9999?new Year(this.year + 1):null;
   }

   public long getSerialIndex() {
      return (long)this.year;
   }

   public long getFirstMillisecond(Calendar var1) {
      var1.set(this.year, 0, 1, 0, 0, 0);
      var1.set(14, 0);
      return var1.getTime().getTime();
   }

   public long getLastMillisecond(Calendar var1) {
      var1.set(this.year, 11, 31, 23, 59, 59);
      var1.set(14, 999);
      return var1.getTime().getTime();
   }

   public boolean equals(Object var1) {
      if(var1 != null) {
         if(var1 instanceof Year) {
            Year var2 = (Year)var1;
            return this.year == var2.getYear();
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      byte var1 = 17;
      short var2 = this.year;
      int var3 = 37 * var1 + var2;
      return var3;
   }

   public int compareTo(Object var1) {
      int var2;
      if(var1 instanceof Year) {
         Year var3 = (Year)var1;
         var2 = this.year - var3.getYear();
      } else if(var1 instanceof RegularTimePeriod) {
         var2 = 0;
      } else {
         var2 = 1;
      }

      return var2;
   }

   public String toString() {
      return Integer.toString(this.year);
   }

   public static Year parseYear(String var0) {
      int var1;
      try {
         var1 = Integer.parseInt(var0.trim());
      } catch (NumberFormatException var4) {
         throw new TimePeriodFormatException("Cannot parse string.");
      }

      try {
         return new Year(var1);
      } catch (IllegalArgumentException var3) {
         throw new TimePeriodFormatException("Year outside valid range.");
      }
   }
}
