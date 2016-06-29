package org.jfree.data.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.RegularTimePeriod;

public class Minute extends RegularTimePeriod implements Serializable {
   private static final long serialVersionUID = 2144572840034842871L;
   public static final int FIRST_MINUTE_IN_HOUR = 0;
   public static final int LAST_MINUTE_IN_HOUR = 59;
   private Day day;
   private byte hour;
   private byte minute;
   private long firstMillisecond;
   private long lastMillisecond;

   public Minute() {
      this(new Date());
   }

   public Minute(int var1, Hour var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'hour\' argument.");
      } else {
         this.minute = (byte)var1;
         this.hour = (byte)var2.getHour();
         this.day = var2.getDay();
         this.peg(Calendar.getInstance());
      }
   }

   public Minute(Date var1) {
      this(var1, RegularTimePeriod.DEFAULT_TIME_ZONE);
   }

   public Minute(Date var1, TimeZone var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'time\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'zone\' argument.");
      } else {
         Calendar var3 = Calendar.getInstance(var2);
         var3.setTime(var1);
         int var4 = var3.get(12);
         this.minute = (byte)var4;
         this.hour = (byte)var3.get(11);
         this.day = new Day(var1, var2);
         this.peg(var3);
      }
   }

   public Minute(int var1, int var2, int var3, int var4, int var5) {
      this(var1, new Hour(var2, new Day(var3, var4, var5)));
   }

   public Day getDay() {
      return this.day;
   }

   public Hour getHour() {
      return new Hour(this.hour, this.day);
   }

   public int getHourValue() {
      return this.hour;
   }

   public int getMinute() {
      return this.minute;
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
      Minute var1;
      if(this.minute != 0) {
         var1 = new Minute(this.minute - 1, this.getHour());
      } else {
         Hour var2 = (Hour)this.getHour().previous();
         if(var2 != null) {
            var1 = new Minute(59, var2);
         } else {
            var1 = null;
         }
      }

      return var1;
   }

   public RegularTimePeriod next() {
      Minute var1;
      if(this.minute != 59) {
         var1 = new Minute(this.minute + 1, this.getHour());
      } else {
         Hour var2 = (Hour)this.getHour().next();
         if(var2 != null) {
            var1 = new Minute(0, var2);
         } else {
            var1 = null;
         }
      }

      return var1;
   }

   public long getSerialIndex() {
      long var1 = this.day.getSerialIndex() * 24L + (long)this.hour;
      return var1 * 60L + (long)this.minute;
   }

   public long getFirstMillisecond(Calendar var1) {
      int var2 = this.day.getYear();
      int var3 = this.day.getMonth() - 1;
      int var4 = this.day.getDayOfMonth();
      var1.clear();
      var1.set(var2, var3, var4, this.hour, this.minute, 0);
      var1.set(14, 0);
      return var1.getTime().getTime();
   }

   public long getLastMillisecond(Calendar var1) {
      int var2 = this.day.getYear();
      int var3 = this.day.getMonth() - 1;
      int var4 = this.day.getDayOfMonth();
      var1.clear();
      var1.set(var2, var3, var4, this.hour, this.minute, 59);
      var1.set(14, 999);
      return var1.getTime().getTime();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Minute)) {
         return false;
      } else {
         Minute var2 = (Minute)var1;
         return this.minute != var2.minute?false:this.hour == var2.hour;
      }
   }

   public int hashCode() {
      byte var1 = 17;
      int var2 = 37 * var1 + this.minute;
      var2 = 37 * var2 + this.hour;
      var2 = 37 * var2 + this.day.hashCode();
      return var2;
   }

   public int compareTo(Object var1) {
      int var2;
      if(var1 instanceof Minute) {
         Minute var3 = (Minute)var1;
         var2 = this.getHour().compareTo(var3.getHour());
         if(var2 == 0) {
            var2 = this.minute - var3.getMinute();
         }
      } else if(var1 instanceof RegularTimePeriod) {
         var2 = 0;
      } else {
         var2 = 1;
      }

      return var2;
   }

   public static Minute parseMinute(String var0) {
      Minute var1 = null;
      var0 = var0.trim();
      String var2 = var0.substring(0, Math.min(10, var0.length()));
      Day var3 = Day.parseDay(var2);
      if(var3 != null) {
         String var4 = var0.substring(Math.min(var2.length() + 1, var0.length()), var0.length());
         var4 = var4.trim();
         String var5 = var4.substring(0, Math.min(2, var4.length()));
         int var6 = Integer.parseInt(var5);
         if(var6 >= 0 && var6 <= 23) {
            String var7 = var4.substring(Math.min(var5.length() + 1, var4.length()), var4.length());
            int var8 = Integer.parseInt(var7);
            if(var8 >= 0 && var8 <= 59) {
               var1 = new Minute(var8, new Hour(var6, var3));
            }
         }
      }

      return var1;
   }
}
