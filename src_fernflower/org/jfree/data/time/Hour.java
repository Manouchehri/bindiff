package org.jfree.data.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;

public class Hour extends RegularTimePeriod implements Serializable {
   private static final long serialVersionUID = -835471579831937652L;
   public static final int FIRST_HOUR_IN_DAY = 0;
   public static final int LAST_HOUR_IN_DAY = 23;
   private Day day;
   private byte hour;
   private long firstMillisecond;
   private long lastMillisecond;

   public Hour() {
      this(new Date());
   }

   public Hour(int var1, Day var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'day\' argument.");
      } else {
         this.hour = (byte)var1;
         this.day = var2;
         this.peg(Calendar.getInstance());
      }
   }

   public Hour(int var1, int var2, int var3, int var4) {
      this(var1, new Day(var2, var3, var4));
   }

   public Hour(Date var1) {
      this(var1, RegularTimePeriod.DEFAULT_TIME_ZONE);
   }

   public Hour(Date var1, TimeZone var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'time\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'zone\' argument.");
      } else {
         Calendar var3 = Calendar.getInstance(var2);
         var3.setTime(var1);
         this.hour = (byte)var3.get(11);
         this.day = new Day(var1, var2);
         this.peg(Calendar.getInstance());
      }
   }

   public int getHour() {
      return this.hour;
   }

   public Day getDay() {
      return this.day;
   }

   public int getYear() {
      return this.day.getYear();
   }

   public int getMonth() {
      return this.day.getMonth();
   }

   public int getDayOfMonth() {
      return this.day.getDayOfMonth();
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
      Hour var1;
      if(this.hour != 0) {
         var1 = new Hour(this.hour - 1, this.day);
      } else {
         Day var2 = (Day)this.day.previous();
         if(var2 != null) {
            var1 = new Hour(23, var2);
         } else {
            var1 = null;
         }
      }

      return var1;
   }

   public RegularTimePeriod next() {
      Hour var1;
      if(this.hour != 23) {
         var1 = new Hour(this.hour + 1, this.day);
      } else {
         Day var2 = (Day)this.day.next();
         if(var2 != null) {
            var1 = new Hour(0, var2);
         } else {
            var1 = null;
         }
      }

      return var1;
   }

   public long getSerialIndex() {
      return this.day.getSerialIndex() * 24L + (long)this.hour;
   }

   public long getFirstMillisecond(Calendar var1) {
      int var2 = this.day.getYear();
      int var3 = this.day.getMonth() - 1;
      int var4 = this.day.getDayOfMonth();
      var1.set(var2, var3, var4, this.hour, 0, 0);
      var1.set(14, 0);
      return var1.getTime().getTime();
   }

   public long getLastMillisecond(Calendar var1) {
      int var2 = this.day.getYear();
      int var3 = this.day.getMonth() - 1;
      int var4 = this.day.getDayOfMonth();
      var1.set(var2, var3, var4, this.hour, 59, 59);
      var1.set(14, 999);
      return var1.getTime().getTime();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Hour)) {
         return false;
      } else {
         Hour var2 = (Hour)var1;
         return this.hour != var2.hour?false:this.day.equals(var2.day);
      }
   }

   public int hashCode() {
      byte var1 = 17;
      int var2 = 37 * var1 + this.hour;
      var2 = 37 * var2 + this.day.hashCode();
      return var2;
   }

   public int compareTo(Object var1) {
      int var2;
      if(var1 instanceof Hour) {
         Hour var3 = (Hour)var1;
         var2 = this.getDay().compareTo(var3.getDay());
         if(var2 == 0) {
            var2 = this.hour - var3.getHour();
         }
      } else if(var1 instanceof RegularTimePeriod) {
         var2 = 0;
      } else {
         var2 = 1;
      }

      return var2;
   }

   public static Hour parseHour(String var0) {
      Hour var1 = null;
      var0 = var0.trim();
      String var2 = var0.substring(0, Math.min(10, var0.length()));
      Day var3 = Day.parseDay(var2);
      if(var3 != null) {
         String var4 = var0.substring(Math.min(var2.length() + 1, var0.length()), var0.length());
         var4 = var4.trim();
         int var5 = Integer.parseInt(var4);
         if(var5 >= 0 && var5 <= 23) {
            var1 = new Hour(var5, var3);
         }
      }

      return var1;
   }
}
