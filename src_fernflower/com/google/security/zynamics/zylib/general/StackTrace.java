package com.google.security.zynamics.zylib.general;

import com.google.common.base.Preconditions;

public class StackTrace {
   public static String toString(StackTraceElement[] var0) {
      Preconditions.checkNotNull(var0, "Invalid stack trace");
      StringBuilder var1 = new StringBuilder();
      StackTraceElement[] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         StackTraceElement var5 = var2[var4];
         var1.append(var5.toString());
         var1.append(System.getProperty("line.separator"));
      }

      return var1.toString();
   }
}
