package com.google.common.math;

import com.google.common.primitives.UnsignedLongs;

enum LongMath$MillerRabinTester$2 {
   private long plusMod(long var1, long var3, long var5) {
      return var1 >= var5 - var3?var1 + var3 - var5:var1 + var3;
   }

   private long times2ToThe32Mod(long var1, long var3) {
      int var5 = 32;

      do {
         int var6 = Math.min(var5, Long.numberOfLeadingZeros(var1));
         var1 = UnsignedLongs.remainder(var1 << var6, var3);
         var5 -= var6;
      } while(var5 > 0);

      return var1;
   }

   long mulMod(long var1, long var3, long var5) {
      long var7 = var1 >>> 32;
      long var9 = var3 >>> 32;
      long var11 = var1 & 4294967295L;
      long var13 = var3 & 4294967295L;
      long var15 = this.times2ToThe32Mod(var7 * var9, var5);
      var15 += var7 * var13;
      if(var15 < 0L) {
         var15 = UnsignedLongs.remainder(var15, var5);
      }

      var15 += var11 * var9;
      var15 = this.times2ToThe32Mod(var15, var5);
      return this.plusMod(var15, UnsignedLongs.remainder(var11 * var13, var5), var5);
   }

   long squareMod(long var1, long var3) {
      long var5 = var1 >>> 32;
      long var7 = var1 & 4294967295L;
      long var9 = this.times2ToThe32Mod(var5 * var5, var3);
      long var11 = var5 * var7 * 2L;
      if(var11 < 0L) {
         var11 = UnsignedLongs.remainder(var11, var3);
      }

      var9 += var11;
      var9 = this.times2ToThe32Mod(var9, var3);
      return this.plusMod(var9, UnsignedLongs.remainder(var7 * var7, var3), var3);
   }
}
