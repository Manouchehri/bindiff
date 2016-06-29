package org.jfree.chart.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;

public class RelativeDateFormat extends DateFormat {
   private long baseMillis;
   private boolean showZeroDays;
   private NumberFormat dayFormatter;
   private String daySuffix;
   private String hourSuffix;
   private String minuteSuffix;
   private NumberFormat secondFormatter;
   private String secondSuffix;
   private static long MILLISECONDS_IN_ONE_HOUR = 3600000L;
   private static long MILLISECONDS_IN_ONE_DAY;

   public RelativeDateFormat() {
      this(0L);
   }

   public RelativeDateFormat(Date var1) {
      this(var1.getTime());
   }

   public RelativeDateFormat(long var1) {
      this.baseMillis = var1;
      this.showZeroDays = false;
      this.dayFormatter = NumberFormat.getInstance();
      this.daySuffix = "d";
      this.hourSuffix = "h";
      this.minuteSuffix = "m";
      this.secondFormatter = NumberFormat.getNumberInstance();
      this.secondFormatter.setMaximumFractionDigits(3);
      this.secondFormatter.setMinimumFractionDigits(3);
      this.secondSuffix = "s";
      this.calendar = new GregorianCalendar();
      this.numberFormat = new DecimalFormat("0");
   }

   public long getBaseMillis() {
      return this.baseMillis;
   }

   public void setBaseMillis(long var1) {
      this.baseMillis = var1;
   }

   public boolean getShowZeroDays() {
      return this.showZeroDays;
   }

   public void setShowZeroDays(boolean var1) {
      this.showZeroDays = var1;
   }

   public String getDaySuffix() {
      return this.daySuffix;
   }

   public void setDaySuffix(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'suffix\' argument.");
      } else {
         this.daySuffix = var1;
      }
   }

   public String getHourSuffix() {
      return this.hourSuffix;
   }

   public void setHourSuffix(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'suffix\' argument.");
      } else {
         this.hourSuffix = var1;
      }
   }

   public String getMinuteSuffix() {
      return this.minuteSuffix;
   }

   public void setMinuteSuffix(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'suffix\' argument.");
      } else {
         this.minuteSuffix = var1;
      }
   }

   public String getSecondSuffix() {
      return this.secondSuffix;
   }

   public void setSecondSuffix(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'suffix\' argument.");
      } else {
         this.secondSuffix = var1;
      }
   }

   public void setSecondFormatter(NumberFormat var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'formatter\' argument.");
      } else {
         this.secondFormatter = var1;
      }
   }

   public StringBuffer format(Date var1, StringBuffer var2, FieldPosition var3) {
      long var4 = var1.getTime();
      long var6 = var4 - this.baseMillis;
      long var8 = var6 / MILLISECONDS_IN_ONE_DAY;
      var6 -= var8 * MILLISECONDS_IN_ONE_DAY;
      long var10 = var6 / MILLISECONDS_IN_ONE_HOUR;
      var6 -= var10 * MILLISECONDS_IN_ONE_HOUR;
      long var12 = var6 / 60000L;
      var6 -= var12 * 60000L;
      double var14 = (double)var6 / 1000.0D;
      if(var8 != 0L || this.showZeroDays) {
         var2.append(this.dayFormatter.format(var8) + this.getDaySuffix());
      }

      var2.append(var10 + this.getHourSuffix());
      var2.append(var12 + this.getMinuteSuffix());
      var2.append(this.secondFormatter.format(var14) + this.getSecondSuffix());
      return var2;
   }

   public Date parse(String var1, ParsePosition var2) {
      return null;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof RelativeDateFormat)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         RelativeDateFormat var2 = (RelativeDateFormat)var1;
         return this.baseMillis != var2.baseMillis?false:(this.showZeroDays != var2.showZeroDays?false:(!this.daySuffix.equals(var2.daySuffix)?false:(!this.hourSuffix.equals(var2.hourSuffix)?false:(!this.minuteSuffix.equals(var2.minuteSuffix)?false:(!this.secondSuffix.equals(var2.secondSuffix)?false:this.secondFormatter.equals(var2.secondFormatter))))));
      }
   }

   public int hashCode() {
      short var1 = 193;
      int var2 = 37 * var1 + (int)(this.baseMillis ^ this.baseMillis >>> 32);
      var2 = 37 * var2 + this.daySuffix.hashCode();
      var2 = 37 * var2 + this.hourSuffix.hashCode();
      var2 = 37 * var2 + this.minuteSuffix.hashCode();
      var2 = 37 * var2 + this.secondSuffix.hashCode();
      var2 = 37 * var2 + this.secondFormatter.hashCode();
      return var2;
   }

   public Object clone() {
      RelativeDateFormat var1 = (RelativeDateFormat)super.clone();
      var1.dayFormatter = (NumberFormat)this.dayFormatter.clone();
      var1.secondFormatter = (NumberFormat)this.secondFormatter.clone();
      return var1;
   }

   public static void main(String[] var0) {
      GregorianCalendar var1 = new GregorianCalendar(2006, 10, 1, 0, 0, 0);
      GregorianCalendar var2 = new GregorianCalendar(2006, 10, 1, 11, 37, 43);
      var2.set(14, 123);
      System.out.println("Default: ");
      RelativeDateFormat var3 = new RelativeDateFormat(var1.getTimeInMillis());
      System.out.println(var3.format(var2.getTime()));
      System.out.println();
      System.out.println("Hide milliseconds: ");
      var3.setSecondFormatter(new DecimalFormat("0"));
      System.out.println(var3.format(var2.getTime()));
      System.out.println();
      System.out.println("Show zero day output: ");
      var3.setShowZeroDays(true);
      System.out.println(var3.format(var2.getTime()));
      System.out.println();
      System.out.println("Alternative suffixes: ");
      var3.setShowZeroDays(false);
      var3.setDaySuffix(":");
      var3.setHourSuffix(":");
      var3.setMinuteSuffix(":");
      var3.setSecondSuffix("");
      System.out.println(var3.format(var2.getTime()));
      System.out.println();
   }

   static {
      MILLISECONDS_IN_ONE_DAY = 24L * MILLISECONDS_IN_ONE_HOUR;
   }
}
