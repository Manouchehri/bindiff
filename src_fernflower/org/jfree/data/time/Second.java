package org.jfree.data.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;

public class Second extends RegularTimePeriod implements Serializable {
   private static final long serialVersionUID = -6536564190712383466L;
   public static final int FIRST_SECOND_IN_MINUTE = 0;
   public static final int LAST_SECOND_IN_MINUTE = 59;
   private Day day;
   private byte hour;
   private byte minute;
   private byte second;
   private long firstMillisecond;

   public Second() {
      this(new Date());
   }

   public Second(int var1, Minute var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'minute\' argument.");
      } else {
         this.day = var2.getDay();
         this.hour = (byte)var2.getHourValue();
         this.minute = (byte)var2.getMinute();
         this.second = (byte)var1;
         this.peg(Calendar.getInstance());
      }
   }

   public Second(int var1, int var2, int var3, int var4, int var5, int var6) {
      this(var1, new Minute(var2, var3, var4, var5, var6));
   }

   public Second(Date var1) {
      this(var1, RegularTimePeriod.DEFAULT_TIME_ZONE);
   }

   public Second(Date var1, TimeZone var2) {
      Calendar var3 = Calendar.getInstance(var2);
      var3.setTime(var1);
      this.second = (byte)var3.get(13);
      this.minute = (byte)var3.get(12);
      this.hour = (byte)var3.get(11);
      this.day = new Day(var1, var2);
      this.peg(var3);
   }

   public int getSecond() {
      return this.second;
   }

   public Minute getMinute() {
      return new Minute(this.minute, new Hour(this.hour, this.day));
   }

   public long getFirstMillisecond() {
      return this.firstMillisecond;
   }

   public long getLastMillisecond() {
      return this.firstMillisecond + 999L;
   }

   public void peg(Calendar var1) {
      this.firstMillisecond = this.getFirstMillisecond(var1);
   }

   public RegularTimePeriod previous() {
      Second var1 = null;
      if(this.second != 0) {
         var1 = new Second(this.second - 1, this.getMinute());
      } else {
         Minute var2 = (Minute)this.getMinute().previous();
         if(var2 != null) {
            var1 = new Second(59, var2);
         }
      }

      return var1;
   }

   public RegularTimePeriod next() {
      Second var1 = null;
      if(this.second != 59) {
         var1 = new Second(this.second + 1, this.getMinute());
      } else {
         Minute var2 = (Minute)this.getMinute().next();
         if(var2 != null) {
            var1 = new Second(0, var2);
         }
      }

      return var1;
   }

   public long getSerialIndex() {
      long var1 = this.day.getSerialIndex() * 24L + (long)this.hour;
      long var3 = var1 * 60L + (long)this.minute;
      return var3 * 60L + (long)this.second;
   }

   public long getFirstMillisecond(Calendar var1) {
      int var2 = this.day.getYear();
      int var3 = this.day.getMonth() - 1;
      int var4 = this.day.getDayOfMonth();
      var1.clear();
      var1.set(var2, var3, var4, this.hour, this.minute, this.second);
      var1.set(14, 0);
      return var1.getTime().getTime();
   }

   public long getLastMillisecond(Calendar var1) {
      return this.getFirstMillisecond(var1) + 999L;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Second)) {
         return false;
      } else {
         Second var2 = (Second)var1;
         return this.second != var2.second?false:(this.minute != var2.minute?false:(this.hour != var2.hour?false:this.day.equals(var2.day)));
      }
   }

   public int hashCode() {
      byte var1 = 17;
      int var2 = 37 * var1 + this.second;
      var2 = 37 * var2 + this.minute;
      var2 = 37 * var2 + this.hour;
      var2 = 37 * var2 + this.day.hashCode();
      return var2;
   }

   public int compareTo(Object var1) {
      if(var1 instanceof Second) {
         Second var3 = (Second)var1;
         return this.firstMillisecond < var3.firstMillisecond?-1:(this.firstMillisecond > var3.firstMillisecond?1:0);
      } else {
         byte var2;
         if(var1 instanceof RegularTimePeriod) {
            var2 = 0;
         } else {
            var2 = 1;
         }

         return var2;
      }
   }

   public static Second parseSecond(String var0) {
      Second var1 = null;
      var0 = var0.trim();
      String var2 = var0.substring(0, Math.min(10, var0.length()));
      Day var3 = Day.parseDay(var2);
      if(var3 != null) {
         String var4 = var0.substring(Math.min(var2.length() + 1, var0.length()), var0.length());
         var4 = var4.trim();
         int var5 = var4.length();
         String var6 = var4.substring(0, Math.min(2, var5));
         String var7 = var4.substring(Math.min(3, var5), Math.min(5, var5));
         String var8 = var4.substring(Math.min(6, var5), Math.min(8, var5));
         int var9 = Integer.parseInt(var6);
         if(var9 >= 0 && var9 <= 23) {
            int var10 = Integer.parseInt(var7);
            if(var10 >= 0 && var10 <= 59) {
               Minute var11 = new Minute(var10, new Hour(var9, var3));
               int var12 = Integer.parseInt(var8);
               if(var12 >= 0 && var12 <= 59) {
                  var1 = new Second(var12, var11);
               }
            }
         }
      }

      return var1;
   }
}
