package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.date.DateHelpers;
import com.google.security.zynamics.zylib.gui.license.CLicenseFile;
import java.util.Calendar;
import java.util.Date;

public class CLicenseFileHelpers {
   static int calculateRemainingDays(CLicenseFile var0) {
      String var1 = var0.getValue("SupportExpiryDate");
      long var2 = Calendar.getInstance().getTimeInMillis();
      long var4 = DateHelpers.getDate(var1, "YYYY-MM-DD").getTime();
      return (int)Math.max(Math.ceil((double)((var4 - var2) / 86400000L)), 0.0D);
   }

   public static boolean isExpired(CLicenseFile var0) {
      String var1 = var0.getValue("SupportExpiryDate");
      Date var2 = DateHelpers.getCurrentDate();
      Date var3 = DateHelpers.getDate(var1, "YYYY-MM-DD");
      return var2.getTime() > var3.getTime();
   }

   public static boolean isExpiring(CLicenseFile var0, int var1) {
      return !isExpired(var0) && calculateRemainingDays(var0) <= var1;
   }
}
