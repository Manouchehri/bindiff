package org.jfree.util;

public class StringUtils {
   public static boolean startsWithIgnoreCase(String var0, String var1) {
      return var0.length() < var1.length()?false:var0.regionMatches(true, 0, var1, 0, var1.length());
   }

   public static boolean endsWithIgnoreCase(String var0, String var1) {
      return var0.length() < var1.length()?false:var0.regionMatches(true, var0.length() - var1.length(), var1, 0, var1.length());
   }

   public static String getLineSeparator() {
      try {
         return System.getProperty("line.separator", "\n");
      } catch (Exception var1) {
         return "\n";
      }
   }
}
