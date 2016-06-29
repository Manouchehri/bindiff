package com.google.security.zynamics.zylib.date;

import com.google.common.base.Preconditions;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateHelpers {
   public static String formatDate(Date var0) {
      Preconditions.checkNotNull(var0, "Error: Date argument can\'t be null.");
      return DateFormat.getDateInstance().format(var0);
   }

   public static String formatDate(Date var0, int var1, Locale var2) {
      Preconditions.checkNotNull(var0, "Error: Date argument can\'t be null.");
      Preconditions.checkNotNull(var2, "Error: Locale argument can\'t be null.");
      String var3 = String.format("%s %s", new Object[]{DateFormat.getDateInstance(var1, var2).format(var0), DateFormat.getTimeInstance(var1, var2).format(var0)});
      return var3;
   }

   public static String formatDateTime(Date var0) {
      Preconditions.checkNotNull(var0, "Error: Date argument can\'t be null.");
      return DateFormat.getDateTimeInstance().format(var0);
   }

   public static String formatTime(Date var0) {
      Preconditions.checkNotNull(var0, "Error: Date argument can\'t be null.");
      return DateFormat.getTimeInstance().format(var0);
   }

   public static Date getCurrentDate() {
      return Calendar.getInstance().getTime();
   }

   public static String getCurrentDateString() {
      return formatDateTime(Calendar.getInstance().getTime());
   }

   public static Date getDate(String var0, String var1) {
      Preconditions.checkArgument(var0.length() == var1.length(), "Date string format exception. Format string must have the same length as the date string.");
      String var2 = "";
      String var3 = "";
      String var4 = "";

      int var5;
      for(var5 = 0; var5 < var1.length(); ++var5) {
         char var6 = var1.charAt(var5);
         String var7;
         char var8;
         if(var6 == 68) {
            var7 = String.valueOf(var2);
            var8 = var0.charAt(var5);
            var2 = (new StringBuilder(1 + String.valueOf(var7).length())).append(var7).append(var8).toString();
         } else if(var6 == 77) {
            var7 = String.valueOf(var3);
            var8 = var0.charAt(var5);
            var3 = (new StringBuilder(1 + String.valueOf(var7).length())).append(var7).append(var8).toString();
         } else if(var6 == 89) {
            var7 = String.valueOf(var4);
            var8 = var0.charAt(var5);
            var4 = (new StringBuilder(1 + String.valueOf(var7).length())).append(var7).append(var8).toString();
         }
      }

      Preconditions.checkArgument(var2.length() == 2, "Date string format exception. Date string\'s day field must have two chars.");
      Preconditions.checkArgument(var3.length() == 2, "Date string format exception. Date string\'s month field must have two chars.");
      Preconditions.checkArgument(var4.length() == 4, "Date string format exception. Date string\'s years field must have four chars.");
      var5 = Integer.parseInt(var2);
      int var9 = Integer.parseInt(var3) - 1;
      int var10 = Integer.parseInt(var4);
      GregorianCalendar var11 = new GregorianCalendar(var10, var9, var5);
      return var11.getTime();
   }
}
