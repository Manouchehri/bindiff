package com.google.security.zynamics.bindiff.utils;

import java.awt.Color;

public class HtmlUtils {
   public static String escapeHtml(String var0) {
      StringBuffer var1 = new StringBuffer();
      int var2 = var0 == null?0:var0.length();

      for(int var3 = 0; var3 < var2; ++var3) {
         char var4 = var0.charAt(var3);
         if(Character.isLetterOrDigit(var4)) {
            var1.append(var4);
         } else {
            var1.append((new StringBuilder(14)).append("&#").append(var4).append(";").toString());
         }
      }

      return var1.toString();
   }

   public static String getHexColorValue(Color var0) {
      return Integer.toHexString(var0.getRGB()).substring(2);
   }

   public static String insertOptionalWordBreaks(String var0, int var1, int var2, boolean var3) {
      // $FF: Couldn't be decompiled
   }
}
