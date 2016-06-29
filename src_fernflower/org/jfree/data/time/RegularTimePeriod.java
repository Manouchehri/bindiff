package org.jfree.data.time;

import java.lang.reflect.Constructor;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.TimePeriod;
import org.jfree.date.MonthConstants;

public abstract class RegularTimePeriod implements Comparable, TimePeriod, MonthConstants {
   public static final TimeZone DEFAULT_TIME_ZONE = TimeZone.getDefault();
   public static final Calendar WORKING_CALENDAR;
   static Class class$java$util$Date;
   static Class class$java$util$TimeZone;
   static Class class$org$jfree$data$time$Year;
   static Class class$org$jfree$data$time$Quarter;
   static Class class$org$jfree$data$time$Month;
   static Class class$org$jfree$data$time$Day;
   static Class class$org$jfree$data$time$Hour;
   static Class class$org$jfree$data$time$Minute;
   static Class class$org$jfree$data$time$Second;
   static Class class$org$jfree$data$time$Millisecond;

   public static RegularTimePeriod createInstance(Class var0, Date var1, TimeZone var2) {
      RegularTimePeriod var3 = null;

      try {
         Constructor var4 = var0.getDeclaredConstructor(new Class[]{class$java$util$Date == null?(class$java$util$Date = class$("java.util.Date")):class$java$util$Date, class$java$util$TimeZone == null?(class$java$util$TimeZone = class$("java.util.TimeZone")):class$java$util$TimeZone});
         var3 = (RegularTimePeriod)var4.newInstance(new Object[]{var1, var2});
      } catch (Exception var5) {
         ;
      }

      return var3;
   }

   public static Class downsize(Class var0) {
      return var0.equals(class$org$jfree$data$time$Year == null?(class$org$jfree$data$time$Year = class$("org.jfree.data.time.Year")):class$org$jfree$data$time$Year)?(class$org$jfree$data$time$Quarter == null?(class$org$jfree$data$time$Quarter = class$("org.jfree.data.time.Quarter")):class$org$jfree$data$time$Quarter):(var0.equals(class$org$jfree$data$time$Quarter == null?(class$org$jfree$data$time$Quarter = class$("org.jfree.data.time.Quarter")):class$org$jfree$data$time$Quarter)?(class$org$jfree$data$time$Month == null?(class$org$jfree$data$time$Month = class$("org.jfree.data.time.Month")):class$org$jfree$data$time$Month):(var0.equals(class$org$jfree$data$time$Month == null?(class$org$jfree$data$time$Month = class$("org.jfree.data.time.Month")):class$org$jfree$data$time$Month)?(class$org$jfree$data$time$Day == null?(class$org$jfree$data$time$Day = class$("org.jfree.data.time.Day")):class$org$jfree$data$time$Day):(var0.equals(class$org$jfree$data$time$Day == null?(class$org$jfree$data$time$Day = class$("org.jfree.data.time.Day")):class$org$jfree$data$time$Day)?(class$org$jfree$data$time$Hour == null?(class$org$jfree$data$time$Hour = class$("org.jfree.data.time.Hour")):class$org$jfree$data$time$Hour):(var0.equals(class$org$jfree$data$time$Hour == null?(class$org$jfree$data$time$Hour = class$("org.jfree.data.time.Hour")):class$org$jfree$data$time$Hour)?(class$org$jfree$data$time$Minute == null?(class$org$jfree$data$time$Minute = class$("org.jfree.data.time.Minute")):class$org$jfree$data$time$Minute):(var0.equals(class$org$jfree$data$time$Minute == null?(class$org$jfree$data$time$Minute = class$("org.jfree.data.time.Minute")):class$org$jfree$data$time$Minute)?(class$org$jfree$data$time$Second == null?(class$org$jfree$data$time$Second = class$("org.jfree.data.time.Second")):class$org$jfree$data$time$Second):(var0.equals(class$org$jfree$data$time$Second == null?(class$org$jfree$data$time$Second = class$("org.jfree.data.time.Second")):class$org$jfree$data$time$Second)?(class$org$jfree$data$time$Millisecond == null?(class$org$jfree$data$time$Millisecond = class$("org.jfree.data.time.Millisecond")):class$org$jfree$data$time$Millisecond):(class$org$jfree$data$time$Millisecond == null?(class$org$jfree$data$time$Millisecond = class$("org.jfree.data.time.Millisecond")):class$org$jfree$data$time$Millisecond)))))));
   }

   public abstract RegularTimePeriod previous();

   public abstract RegularTimePeriod next();

   public abstract long getSerialIndex();

   public abstract void peg(Calendar var1);

   public Date getStart() {
      return new Date(this.getFirstMillisecond());
   }

   public Date getEnd() {
      return new Date(this.getLastMillisecond());
   }

   public abstract long getFirstMillisecond();

   public long getFirstMillisecond(TimeZone var1) {
      Calendar var2 = Calendar.getInstance(var1);
      return this.getFirstMillisecond(var2);
   }

   public abstract long getFirstMillisecond(Calendar var1);

   public abstract long getLastMillisecond();

   public long getLastMillisecond(TimeZone var1) {
      Calendar var2 = Calendar.getInstance(var1);
      return this.getLastMillisecond(var2);
   }

   public abstract long getLastMillisecond(Calendar var1);

   public long getMiddleMillisecond() {
      long var1 = this.getFirstMillisecond();
      long var3 = this.getLastMillisecond();
      return var1 + (var3 - var1) / 2L;
   }

   public long getMiddleMillisecond(TimeZone var1) {
      Calendar var2 = Calendar.getInstance(var1);
      long var3 = this.getFirstMillisecond(var2);
      long var5 = this.getLastMillisecond(var2);
      return var3 + (var5 - var3) / 2L;
   }

   public long getMiddleMillisecond(Calendar var1) {
      long var2 = this.getFirstMillisecond(var1);
      long var4 = this.getLastMillisecond(var1);
      return var2 + (var4 - var2) / 2L;
   }

   public String toString() {
      return String.valueOf(this.getStart());
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      WORKING_CALENDAR = Calendar.getInstance(DEFAULT_TIME_ZONE);
   }
}
