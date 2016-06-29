package com.google.security.zynamics.zylib.io;

public class ProcessHelpers {
   public static void runBatchFile(String var0) {
      Process var1 = Runtime.getRuntime().exec(new String[]{"cmd", "/c", var0});
      var1.waitFor();
   }
}
