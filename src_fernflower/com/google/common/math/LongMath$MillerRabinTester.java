package com.google.common.math;

import com.google.common.math.LongMath$1;

enum LongMath$MillerRabinTester {
   SMALL,
   LARGE;

   private LongMath$MillerRabinTester() {
   }

   static boolean test(long var0, long var2) {
      return (var2 <= 3037000499L?SMALL:LARGE).testWitness(var0, var2);
   }

   abstract long mulMod(long var1, long var3, long var5);

   abstract long squareMod(long var1, long var3);

   private long powMod(long var1, long var3, long var5) {
      long var7;
      for(var7 = 1L; var3 != 0L; var3 >>= 1) {
         if((var3 & 1L) != 0L) {
            var7 = this.mulMod(var7, var1, var5);
         }

         var1 = this.squareMod(var1, var5);
      }

      return var7;
   }

   private boolean testWitness(long var1, long var3) {
      int var5 = Long.numberOfTrailingZeros(var3 - 1L);
      long var6 = var3 - 1L >> var5;
      var1 %= var3;
      if(var1 == 0L) {
         return true;
      } else {
         long var8 = this.powMod(var1, var6, var3);
         if(var8 == 1L) {
            return true;
         } else {
            for(int var10 = 0; var8 != var3 - 1L; var8 = this.squareMod(var8, var3)) {
               ++var10;
               if(var10 == var5) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   // $FF: synthetic method
   LongMath$MillerRabinTester(LongMath$1 var3) {
      this();
   }
}
