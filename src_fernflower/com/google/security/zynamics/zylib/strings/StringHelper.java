package com.google.security.zynamics.zylib.strings;

public class StringHelper {
   public static int count(String var0, char var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < var0.length(); ++var3) {
         if(var0.charAt(var3) == var1) {
            ++var2;
         }
      }

      return var2;
   }

   public static String replaceAll(String var0, String var1, String var2) {
      int var3 = var0.indexOf(var1);

      String var4;
      for(var4 = var0; var3 != -1; var3 = var4.indexOf(var1)) {
         String var5 = String.valueOf(var4.substring(0, var3));
         String var6 = String.valueOf(var4.substring(var3 + var1.length()));
         var4 = (new StringBuilder(0 + String.valueOf(var5).length() + String.valueOf(var2).length() + String.valueOf(var6).length())).append(var5).append(var2).append(var6).toString();
      }

      return var4;
   }
}
