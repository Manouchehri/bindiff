package com.google.security.zynamics.bindiff.utils;

public class FlagUtils {
   public static boolean parseFlag(byte var0, byte var1) {
      if(var1 >= 0 && var1 <= 7) {
         int var2 = var0 >>> var1;
         return 0 != (var2 & 1);
      } else {
         throw new IllegalArgumentException("Flag has only 8 bits.");
      }
   }

   public static boolean parseFlag(int var0, byte var1) {
      if(var1 >= 0 && var1 <= 31) {
         int var2 = var0 >>> var1;
         return 0 != (var2 & 1);
      } else {
         throw new IllegalArgumentException("Flag has only 32 bits.");
      }
   }

   public static byte setFlag(byte var0, byte var1) {
      if(var1 >= 0 && var1 <= 7) {
         byte var2 = (byte)(var0 | 1 << var1);
         return var2;
      } else {
         throw new IllegalArgumentException("Flag has only 8 bits.");
      }
   }

   public static int setFlag(int var0, byte var1) {
      if(var1 >= 0 && var1 <= 31) {
         int var2 = var0 | 1 << var1;
         return var2;
      } else {
         throw new IllegalArgumentException("Flag has only 32 bits.");
      }
   }
}
