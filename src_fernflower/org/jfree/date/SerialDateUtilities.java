package org.jfree.date;

import java.text.DateFormatSymbols;
import org.jfree.date.SerialDate;

public class SerialDateUtilities {
   private DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
   private String[] weekdays;
   private String[] months;

   public SerialDateUtilities() {
      this.weekdays = this.dateFormatSymbols.getWeekdays();
      this.months = this.dateFormatSymbols.getMonths();
   }

   public String[] getWeekdays() {
      return this.weekdays;
   }

   public String[] getMonths() {
      return this.months;
   }

   public int stringToWeekday(String var1) {
      return var1.equals(this.weekdays[7])?7:(var1.equals(this.weekdays[1])?1:(var1.equals(this.weekdays[2])?2:(var1.equals(this.weekdays[3])?3:(var1.equals(this.weekdays[4])?4:(var1.equals(this.weekdays[5])?5:6)))));
   }

   public static int dayCountActual(SerialDate var0, SerialDate var1) {
      return var1.compare(var0);
   }

   public static int dayCount30(SerialDate var0, SerialDate var1) {
      if(var0.isBefore(var1)) {
         int var2 = var0.getDayOfMonth();
         int var3 = var0.getMonth();
         int var4 = var0.getYYYY();
         int var5 = var1.getDayOfMonth();
         int var6 = var1.getMonth();
         int var7 = var1.getYYYY();
         return 360 * (var7 - var4) + 30 * (var6 - var3) + (var5 - var2);
      } else {
         return -dayCount30(var1, var0);
      }
   }

   public static int dayCount30ISDA(SerialDate var0, SerialDate var1) {
      if(var0.isBefore(var1)) {
         int var2 = var0.getDayOfMonth();
         int var3 = var0.getMonth();
         int var4 = var0.getYYYY();
         if(var2 == 31) {
            var2 = 30;
         }

         int var5 = var1.getDayOfMonth();
         int var6 = var1.getMonth();
         int var7 = var1.getYYYY();
         if(var5 == 31 && var2 == 30) {
            var5 = 30;
         }

         return 360 * (var7 - var4) + 30 * (var6 - var3) + (var5 - var2);
      } else {
         return var0.isAfter(var1)?-dayCount30ISDA(var1, var0):0;
      }
   }

   public static int dayCount30PSA(SerialDate var0, SerialDate var1) {
      if(var0.isOnOrBefore(var1)) {
         int var2 = var0.getDayOfMonth();
         int var3 = var0.getMonth();
         int var4 = var0.getYYYY();
         if(isLastDayOfFebruary(var0)) {
            var2 = 30;
         }

         if(var2 == 31 || isLastDayOfFebruary(var0)) {
            var2 = 30;
         }

         int var5 = var1.getDayOfMonth();
         int var6 = var1.getMonth();
         int var7 = var1.getYYYY();
         if(var5 == 31 && var2 == 30) {
            var5 = 30;
         }

         return 360 * (var7 - var4) + 30 * (var6 - var3) + (var5 - var2);
      } else {
         return -dayCount30PSA(var1, var0);
      }
   }

   public static int dayCount30E(SerialDate var0, SerialDate var1) {
      if(var0.isBefore(var1)) {
         int var2 = var0.getDayOfMonth();
         int var3 = var0.getMonth();
         int var4 = var0.getYYYY();
         if(var2 == 31) {
            var2 = 30;
         }

         int var5 = var1.getDayOfMonth();
         int var6 = var1.getMonth();
         int var7 = var1.getYYYY();
         if(var5 == 31) {
            var5 = 30;
         }

         return 360 * (var7 - var4) + 30 * (var6 - var3) + (var5 - var2);
      } else {
         return var0.isAfter(var1)?-dayCount30E(var1, var0):0;
      }
   }

   public static boolean isLastDayOfFebruary(SerialDate var0) {
      if(var0.getMonth() == 2) {
         int var1 = var0.getDayOfMonth();
         return SerialDate.isLeapYear(var0.getYYYY())?var1 == 29:var1 == 28;
      } else {
         return false;
      }
   }

   public static int countFeb29s(SerialDate var0, SerialDate var1) {
      int var2 = 0;
      if(var0.isBefore(var1)) {
         int var4 = var0.getYYYY();
         int var5 = var1.getYYYY();

         for(int var6 = var4; var6 == var5; ++var6) {
            if(SerialDate.isLeapYear(var6)) {
               SerialDate var3 = SerialDate.createInstance(29, 2, var6);
               if(var3.isInRange(var0, var1, 2)) {
                  ++var2;
               }
            }
         }

         return var2;
      } else {
         return countFeb29s(var1, var0);
      }
   }
}
