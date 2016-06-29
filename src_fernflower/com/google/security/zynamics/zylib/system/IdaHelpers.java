package com.google.security.zynamics.zylib.system;

import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.io.File;

public final class IdaHelpers {
   public static final String IDA32_EXECUTABLE;
   public static final String IDA64_EXECUTABLE;

   public static Process createIdaProcess(String var0, File var1, String var2, String var3) {
      // $FF: Couldn't be decompiled
   }

   public static String getSArgument(String var0, boolean var1) {
      return var1?(new StringBuilder(6 + String.valueOf(var0).length())).append("-S\\\"").append(var0).append("\\\"").toString():(new StringBuilder(4 + String.valueOf(var0).length())).append("-S\"").append(var0).append("\"").toString();
   }

   static {
      if(SystemHelpers.isRunningWindows()) {
         IDA32_EXECUTABLE = "idaq.exe";
         IDA64_EXECUTABLE = "idaq64.exe";
      } else {
         IDA32_EXECUTABLE = "idaq";
         IDA64_EXECUTABLE = "idaq64";
      }

   }
}
