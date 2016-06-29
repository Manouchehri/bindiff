package org.jfree.data.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Second;

public class Millisecond extends RegularTimePeriod implements Serializable {
   static final long serialVersionUID = -5316836467277638485L;
   public static final int FIRST_MILLISECOND_IN_SECOND = 0;
   public static final int LAST_MILLISECOND_IN_SECOND = 999;
   private Day day;
   private byte hour;
   private byte minute;
   private byte second;
   private int millisecond;
   private long firstMillisecond;

   public Millisecond() {
      this(new Date());
   }

   public Millisecond(int var1, Second var2) {
      this.millisecond = var1;
      this.second = (byte)var2.getSecond();
      this.minute = (byte)var2.getMinute().getMinute();
      this.hour = (byte)var2.getMinute().getHourValue();
      this.day = var2.getMinute().getDay();
      this.peg(Calendar.getInstance());
   }

   public Millisecond(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this(var1, new Second(var2, var3, var4, var5, var6, var7));
   }

   public Millisecond(Date var1) {
      this(var1, RegularTimePeriod.DEFAULT_TIME_ZONE);
   }

   public Millisecond(Date var1, TimeZone var2) {
      Calendar var3 = Calendar.getInstance(var2);
      var3.setTime(var1);
      this.millisecond = var3.get(14);
      this.second = (byte)var3.get(13);
      this.minute = (byte)var3.get(12);
      this.hour = (byte)var3.get(11);
      this.day = new Day(var1, var2);
      this.peg(Calendar.getInstance());
   }

   public Second getSecond() {
      return new Second(this.second, this.minute, this.hour, this.day.getDayOfMonth(), this.day.getMonth(), this.day.getYear());
   }

   public long getMillisecond() {
      return (long)this.millisecond;
   }

   public long getFirstMillisecond() {
      return this.firstMillisecond;
   }

   public long getLastMillisecond() {
      return this.firstMillisecond;
   }

   public void peg(Calendar var1) {
      this.firstMillisecond = this.getFirstMillisecond(var1);
   }

   public RegularTimePeriod previous() {
      Millisecond var1 = null;
      if(this.millisecond != 0) {
         var1 = new Millisecond(this.millisecond - 1, this.getSecond());
      } else {
         Second var2 = (Second)this.getSecond().previous();
         if(var2 != null) {
            var1 = new Millisecond(999, var2);
         }
      }

      return var1;
   }

   public RegularTimePeriod next() {
      Millisecond var1 = null;
      if(this.millisecond != 999) {
         var1 = new Millisecond(this.millisecond + 1, this.getSecond());
      } else {
         Second var2 = (Second)this.getSecond().next();
         if(var2 != null) {
            var1 = new Millisecond(0, var2);
         }
      }

      return var1;
   }

   public long getSerialIndex() {
      long var1 = this.day.getSerialIndex() * 24L + (long)this.hour;
      long var3 = var1 * 60L + (long)this.minute;
      long var5 = var3 * 60L + (long)this.second;
      return var5 * 1000L + (long)this.millisecond;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Millisecond)) {
         return false;
      } else {
         Millisecond var2 = (Millisecond)var1;
         return this.millisecond != var2.millisecond?false:(this.second != var2.second?false:(this.minute != var2.minute?false:(this.hour != var2.hour?false:this.day.equals(var2.day))));
      }
   }

   public int hashCode() {
      byte var1 = 17;
      int var2 = 37 * var1 + this.millisecond;
      var2 = 37 * var2 + this.getSecond().hashCode();
      return var2;
   }

   public int compareTo(Object var1) {
      byte var2;
      if(var1 instanceof Millisecond) {
         Millisecond var5 = (Millisecond)var1;
         long var3 = this.getFirstMillisecond() - var5.getFirstMillisecond();
         if(var3 > 0L) {
            var2 = 1;
         } else if(var3 < 0L) {
            var2 = -1;
         } else {
            var2 = 0;
         }
      } else if(var1 instanceof RegularTimePeriod) {
         var2 = 0;
      } else {
         var2 = 1;
      }

      return var2;
   }

   public long getFirstMillisecond(Calendar var1) {
      int var2 = this.day.getYear();
      int var3 = this.day.getMonth() - 1;
      int var4 = this.day.getDayOfMonth();
      var1.clear();
      var1.set(var2, var3, var4, this.hour, this.minute, this.second);
      var1.set(14, this.millisecond);
      return var1.getTime().getTime();
   }

   public long getLastMillisecond(Calendar var1) {
      return this.getFirstMillisecond(var1);
   }
}
