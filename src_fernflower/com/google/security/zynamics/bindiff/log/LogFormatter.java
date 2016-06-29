package com.google.security.zynamics.bindiff.log;

import java.util.GregorianCalendar;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class LogFormatter extends SimpleFormatter {
   private static boolean verboseLogging = false;

   public static void setVerboseLogging(boolean var0) {
      verboseLogging = var0;
   }

   public String format(LogRecord var1) {
      String var2 = "";
      if(verboseLogging) {
         GregorianCalendar var3 = new GregorianCalendar();
         var3.setTimeInMillis(var1.getMillis());
         String var4 = String.format("%4d.%02d.%02d %02d:%02d:%02d.%03d %s", new Object[]{Integer.valueOf(var3.get(1)), Integer.valueOf(var3.get(2)), Integer.valueOf(var3.get(5)), Integer.valueOf(var3.get(10)), Integer.valueOf(var3.get(12)), Integer.valueOf(var3.get(13)), Integer.valueOf(var3.get(14)), var3.get(9) == 0?"am":"pm"});
         var2 = String.format("<%s> %s (Thread ID %d) \n", new Object[]{var4, var1.getLevel().toString(), Integer.valueOf(var1.getThreadID())});
      }

      return String.format("%s%s\n", new Object[]{var2, var1.getMessage()});
   }
}
