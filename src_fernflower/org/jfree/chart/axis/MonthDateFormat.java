package org.jfree.chart.axis;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.jfree.data.time.Month;

public class MonthDateFormat extends DateFormat {
   private String[] months;
   private boolean[] showYear;
   private DateFormat yearFormatter;

   public MonthDateFormat() {
      this(TimeZone.getDefault());
   }

   public MonthDateFormat(TimeZone var1) {
      this(var1, Locale.getDefault(), 1, true, false);
   }

   public MonthDateFormat(Locale var1) {
      this(TimeZone.getDefault(), var1, 1, true, false);
   }

   public MonthDateFormat(TimeZone var1, int var2) {
      this(var1, Locale.getDefault(), var2, true, false);
   }

   public MonthDateFormat(Locale var1, int var2) {
      this(TimeZone.getDefault(), var1, var2, true, false);
   }

   public MonthDateFormat(TimeZone var1, Locale var2, int var3, boolean var4, boolean var5) {
      this(var1, var2, var3, new boolean[]{var4, false, false, false, false, false, false, false, false, false, false, false, var5}, new SimpleDateFormat("yy"));
   }

   public MonthDateFormat(TimeZone var1, Locale var2, int var3, boolean[] var4, DateFormat var5) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'locale\' argument.");
      } else {
         DateFormatSymbols var6 = new DateFormatSymbols(var2);
         String[] var7 = var6.getMonths();
         this.months = new String[12];

         for(int var8 = 0; var8 < 12; ++var8) {
            if(var3 > 0) {
               this.months[var8] = var7[var8].substring(0, Math.min(var3, var7[var8].length()));
            } else {
               this.months[var8] = var7[var8];
            }
         }

         this.calendar = new GregorianCalendar(var1);
         this.showYear = var4;
         this.yearFormatter = var5;
         this.numberFormat = NumberFormat.getNumberInstance();
      }
   }

   public StringBuffer format(Date var1, StringBuffer var2, FieldPosition var3) {
      this.calendar.setTime(var1);
      int var4 = this.calendar.get(2);
      var2.append(this.months[var4]);
      if(this.showYear[var4]) {
         var2.append(this.yearFormatter.format(var1));
      }

      return var2;
   }

   public Date parse(String var1, ParsePosition var2) {
      return null;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof MonthDateFormat)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         MonthDateFormat var2 = (MonthDateFormat)var1;
         return !Arrays.equals(this.months, var2.months)?false:(!Arrays.equals(this.showYear, var2.showYear)?false:this.yearFormatter.equals(var2.yearFormatter));
      }
   }

   public static void main(String[] var0) {
      MonthDateFormat var1 = new MonthDateFormat(Locale.UK, 2);
      System.out.println("UK:");
      System.out.println(var1.format((new Month(1, 2005)).getStart()));
      System.out.println(var1.format((new Month(2, 2005)).getStart()));
      System.out.println(var1.format((new Month(3, 2005)).getStart()));
      System.out.println(var1.format((new Month(4, 2005)).getStart()));
      System.out.println(var1.format((new Month(5, 2005)).getStart()));
      System.out.println(var1.format((new Month(6, 2005)).getStart()));
      System.out.println(var1.format((new Month(7, 2005)).getStart()));
      System.out.println(var1.format((new Month(8, 2005)).getStart()));
      System.out.println(var1.format((new Month(9, 2005)).getStart()));
      System.out.println(var1.format((new Month(10, 2005)).getStart()));
      System.out.println(var1.format((new Month(11, 2005)).getStart()));
      System.out.println(var1.format((new Month(12, 2005)).getStart()));
      System.out.println();
      var1 = new MonthDateFormat(Locale.GERMANY, 2);
      System.out.println("GERMANY:");
      System.out.println(var1.format((new Month(1, 2005)).getStart()));
      System.out.println(var1.format((new Month(2, 2005)).getStart()));
      System.out.println(var1.format((new Month(3, 2005)).getStart()));
      System.out.println(var1.format((new Month(4, 2005)).getStart()));
      System.out.println(var1.format((new Month(5, 2005)).getStart()));
      System.out.println(var1.format((new Month(6, 2005)).getStart()));
      System.out.println(var1.format((new Month(7, 2005)).getStart()));
      System.out.println(var1.format((new Month(8, 2005)).getStart()));
      System.out.println(var1.format((new Month(9, 2005)).getStart()));
      System.out.println(var1.format((new Month(10, 2005)).getStart()));
      System.out.println(var1.format((new Month(11, 2005)).getStart()));
      System.out.println(var1.format((new Month(12, 2005)).getStart()));
      System.out.println();
      var1 = new MonthDateFormat(Locale.FRANCE, 2);
      System.out.println("FRANCE:");
      System.out.println(var1.format((new Month(1, 2005)).getStart()));
      System.out.println(var1.format((new Month(2, 2005)).getStart()));
      System.out.println(var1.format((new Month(3, 2005)).getStart()));
      System.out.println(var1.format((new Month(4, 2005)).getStart()));
      System.out.println(var1.format((new Month(5, 2005)).getStart()));
      System.out.println(var1.format((new Month(6, 2005)).getStart()));
      System.out.println(var1.format((new Month(7, 2005)).getStart()));
      System.out.println(var1.format((new Month(8, 2005)).getStart()));
      System.out.println(var1.format((new Month(9, 2005)).getStart()));
      System.out.println(var1.format((new Month(10, 2005)).getStart()));
      System.out.println(var1.format((new Month(11, 2005)).getStart()));
      System.out.println(var1.format((new Month(12, 2005)).getStart()));
      System.out.println();
      SimpleDateFormat var2 = new SimpleDateFormat("yyyy");
      var2.setNumberFormat((NumberFormat)null);
      System.out.println(var2.equals("X"));
   }
}
