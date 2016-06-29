package org.jfree.date;

import java.util.Calendar;
import java.util.Date;

public class DateUtilities {
   private static final Calendar CALENDAR = Calendar.getInstance();

   public static synchronized Date createDate(int var0, int var1, int var2) {
      CALENDAR.clear();
      CALENDAR.set(var0, var1 - 1, var2);
      return CALENDAR.getTime();
   }

   public static synchronized Date createDate(int var0, int var1, int var2, int var3, int var4) {
      CALENDAR.clear();
      CALENDAR.set(var0, var1 - 1, var2, var3, var4);
      return CALENDAR.getTime();
   }
}
