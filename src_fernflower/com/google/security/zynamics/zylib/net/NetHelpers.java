package com.google.security.zynamics.zylib.net;

public class NetHelpers {
   private static final int MAX_PORT = 65535;

   public static boolean isValidPort(int var0) {
      return var0 >= 0 && var0 <= '\uffff';
   }

   public static boolean isValidPort(String var0) {
      try {
         Integer.parseInt(var0);
         return true;
      } catch (NumberFormatException var2) {
         return false;
      }
   }
}
