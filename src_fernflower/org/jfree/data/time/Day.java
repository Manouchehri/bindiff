package org.jfree.data.time;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.date.SerialDate;

public class Day extends RegularTimePeriod implements Serializable {
   private static final long serialVersionUID = -7082667380758962755L;
   protected static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
   protected static final DateFormat DATE_FORMAT_SHORT = DateFormat.getDateInstance(3);
   protected static final DateFormat DATE_FORMAT_MEDIUM = DateFormat.getDateInstance(2);
   protected static final DateFormat DATE_FORMAT_LONG = DateFormat.getDateInstance(1);
   private SerialDate serialDate;
   private long firstMillisecond;
   private long lastMillisecond;

   public Day() {
      this(new Date());
   }

   public Day(int var1, int var2, int var3) {
      this.serialDate = SerialDate.createInstance(var1, var2, var3);
      this.peg(Calendar.getInstance());
   }

   public Day(SerialDate var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'serialDate\' argument.");
      } else {
         this.serialDate = var1;
         this.peg(Calendar.getInstance());
      }
   }

   public Day(Date var1) {
      this(var1, RegularTimePeriod.DEFAULT_TIME_ZONE);
   }

   public Day(Date var1, TimeZone var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'time\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'zone\' argument.");
      } else {
         Calendar var3 = Calendar.getInstance(var2);
         var3.setTime(var1);
         int var4 = var3.get(5);
         int var5 = var3.get(2) + 1;
         int var6 = var3.get(1);
         this.serialDate = SerialDate.createInstance(var4, var5, var6);
         this.peg(var3);
      }
   }

   public SerialDate getSerialDate() {
      return this.serialDate;
   }

   public int getYear() {
      return this.serialDate.getYYYY();
   }

   public int getMonth() {
      return this.serialDate.getMonth();
   }

   public int getDayOfMonth() {
      return this.serialDate.getDayOfMonth();
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
      int var2 = this.serialDate.toSerial();
      if(var2 > 2) {
         SerialDate var3 = SerialDate.createInstance(var2 - 1);
         return new Day(var3);
      } else {
         Object var1 = null;
         return (RegularTimePeriod)var1;
      }
   }

   public RegularTimePeriod next() {
      int var2 = this.serialDate.toSerial();
      if(var2 < 2958465) {
         SerialDate var3 = SerialDate.createInstance(var2 + 1);
         return new Day(var3);
      } else {
         Object var1 = null;
         return (RegularTimePeriod)var1;
      }
   }

   public long getSerialIndex() {
      return (long)this.serialDate.toSerial();
   }

   public long getFirstMillisecond(Calendar var1) {
      int var2 = this.serialDate.getYYYY();
      int var3 = this.serialDate.getMonth();
      int var4 = this.serialDate.getDayOfMonth();
      var1.clear();
      var1.set(var2, var3 - 1, var4, 0, 0, 0);
      var1.set(14, 0);
      return var1.getTime().getTime();
   }

   public long getLastMillisecond(Calendar var1) {
      int var2 = this.serialDate.getYYYY();
      int var3 = this.serialDate.getMonth();
      int var4 = this.serialDate.getDayOfMonth();
      var1.clear();
      var1.set(var2, var3 - 1, var4, 23, 59, 59);
      var1.set(14, 999);
      return var1.getTime().getTime();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Day)) {
         return false;
      } else {
         Day var2 = (Day)var1;
         return this.serialDate.equals(var2.getSerialDate());
      }
   }

   public int hashCode() {
      return this.serialDate.hashCode();
   }

   public int compareTo(Object var1) {
      int var2;
      if(var1 instanceof Day) {
         Day var3 = (Day)var1;
         var2 = -var3.getSerialDate().compare(this.serialDate);
      } else if(var1 instanceof RegularTimePeriod) {
         var2 = 0;
      } else {
         var2 = 1;
      }

      return var2;
   }

   public String toString() {
      return this.serialDate.toString();
   }

   public static Day parseDay(String var0) {
      try {
         return new Day(DATE_FORMAT.parse(var0));
      } catch (ParseException var4) {
         try {
            return new Day(DATE_FORMAT_SHORT.parse(var0));
         } catch (ParseException var3) {
            return null;
         }
      }
   }
}
