package com.google.security.zynamics.zylib.system;

import com.google.security.zynamics.zylib.io.FileUtils;
import java.io.File;

public final class SystemHelpers {
   public static String getAllUsersApplicationDataDirectory() {
      // $FF: Couldn't be decompiled
   }

   public static String getAllUsersApplicationDataDirectory(String var0) {
      String var1 = getAllUsersApplicationDataDirectory();
      String var2 = String.valueOf(File.separator);
      String var3 = String.valueOf(File.separator);
      return (new StringBuilder(8 + String.valueOf(var1).length() + String.valueOf(var2).length() + String.valueOf(var0).length() + String.valueOf(var3).length())).append(var1).append("zynamics").append(var2).append(var0).append(var3).toString();
   }

   public static String getApplicationDataDirectory() {
      return FileUtils.ensureTrailingSlash(isRunningWindows()?System.getenv("APPDATA"):System.getProperty("user.home"));
   }

   public static String getApplicationDataDirectory(String var0) {
      String var1 = getApplicationDataDirectory();
      String var2 = isRunningWindows()?"":".";
      String var3 = String.valueOf(File.separator);
      String var4 = String.valueOf(File.separator);
      return (new StringBuilder(8 + String.valueOf(var1).length() + String.valueOf(var2).length() + String.valueOf(var3).length() + String.valueOf(var0).length() + String.valueOf(var4).length())).append(var1).append(var2).append("zynamics").append(var3).append(var0).append(var4).toString();
   }

   public static String getTempDirectory() {
      return FileUtils.ensureTrailingSlash(System.getProperty("java.io.tmpdir"));
   }

   public static String getTempDirectory(String var0) {
      String var1 = getTempDirectory();
      String var2 = String.valueOf(File.separator);
      String var3 = String.valueOf(File.separator);
      return (new StringBuilder(8 + String.valueOf(var1).length() + String.valueOf(var2).length() + String.valueOf(var0).length() + String.valueOf(var3).length())).append(var1).append("zynamics").append(var2).append(var0).append(var3).toString();
   }

   public static String getUserDirectory() {
      return FileUtils.ensureTrailingSlash(System.getProperty("user.home"));
   }

   public static boolean isRunningLinux() {
      return System.getProperty("os.name").startsWith("Linux");
   }

   public static boolean isRunningMacOSX() {
      return System.getProperty("os.name").startsWith("Mac");
   }

   public static boolean isRunningWindows() {
      return System.getProperty("os.name").startsWith("Windows");
   }

   public static boolean is64BitArchitecture() {
      if(!isRunningWindows()) {
         throw new RuntimeException("Not implemented");
      } else {
         return "AMD64".equals(System.getenv("PROCESSOR_ARCHITECTURE")) || "AMD64".equals(System.getenv("PROCESSOR_ARCHITEW6432"));
      }
   }
}
