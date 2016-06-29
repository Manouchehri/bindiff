package com.google.security.zynamics.zylib.general;

@Deprecated
public class MathUtils {
   public static long pow(long var0, long var2) {
      if(var2 == 0L) {
         return 1L;
      } else {
         long var4 = var0;

         for(int var6 = 1; (long)var6 < var2; ++var6) {
            var4 *= var0;
         }

         return var4;
      }
   }
}
