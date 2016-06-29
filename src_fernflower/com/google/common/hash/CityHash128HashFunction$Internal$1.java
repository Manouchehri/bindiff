package com.google.common.hash;

import com.google.common.hash.CityHash128HashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.LittleEndianByteArray;

enum CityHash128HashFunction$Internal$1 {
   protected HashCode fingerprint(byte[] var1, int var2, int var3, long var4, long var6) {
      if(var3 < 128) {
         return CityHash128HashFunction.access$100(var1, var2, var3, var4, var6);
      } else {
         byte[] var8 = new byte[16];
         long[] var9 = new long[2];
         long[] var10 = new long[2];
         long var11 = (long)var3 * -8261664234251669945L;
         var9[0] = Long.rotateRight(var6 ^ -8261664234251669945L, 49) * -8261664234251669945L + LittleEndianByteArray.load64(var1, var2);
         var9[1] = Long.rotateRight(var9[0], 42) * -8261664234251669945L + LittleEndianByteArray.load64(var1, var2 + 8);
         var10[0] = Long.rotateRight(var6 + var11, 35) * -8261664234251669945L + var4;
         var10[1] = Long.rotateRight(var4 + LittleEndianByteArray.load64(var1, var2 + 88), 53) * -8261664234251669945L;

         do {
            var4 = Long.rotateRight(var4 + var6 + var9[0] + LittleEndianByteArray.load64(var1, var2 + 16), 37) * -8261664234251669945L;
            var6 = Long.rotateRight(var6 + var9[1] + LittleEndianByteArray.load64(var1, var2 + 48), 42) * -8261664234251669945L;
            var4 ^= var10[1];
            var6 ^= var9[0];
            var11 = Long.rotateRight(var11 ^ var10[0], 33);
            this.weakHashLength32WithSeeds(var1, var2, var9[1] * -8261664234251669945L, var4 + var10[0], var9);
            this.weakHashLength32WithSeeds(var1, var2 + 32, var11 + var10[1], var6, var10);
            var11 = Long.rotateRight(var11 + var6 + var9[0] + LittleEndianByteArray.load64(var1, var2 + 80), 37) * -8261664234251669945L;
            var6 = Long.rotateRight(var6 + var9[1] + LittleEndianByteArray.load64(var1, var2 + 112), 42) * -8261664234251669945L;
            var11 ^= var10[1];
            var6 ^= var9[0];
            var4 = Long.rotateRight(var4 ^ var10[0], 33);
            this.weakHashLength32WithSeeds(var1, var2 + 64, var9[1] * -8261664234251669945L, var11 + var10[0], var9);
            this.weakHashLength32WithSeeds(var1, var2 + 96, var4 + var10[1], var6, var10);
            var2 += 128;
            var3 -= 128;
         } while(var3 >= 128);

         var6 += Long.rotateRight(var10[0], 37) * -6505348102511208375L + var11;
         var4 += Long.rotateRight(var9[0] + var11, 49) * -6505348102511208375L;

         for(var2 += var3 - 32; var3 > 0; var3 -= 32) {
            var6 = Long.rotateRight(var6 - var4, 42) * -6505348102511208375L + var9[1];
            var10[0] += LittleEndianByteArray.load64(var1, var2 + 16);
            var4 = Long.rotateRight(var4, 49) * -6505348102511208375L + var10[0];
            var10[0] += var9[0];
            this.weakHashLength32WithSeeds(var1, var2, var9[0], var9[1], var9);
            var2 -= 32;
         }

         var4 = CityHash128HashFunction.access$200(var4, var9[0]);
         var6 = CityHash128HashFunction.access$200(var6, var10[0]);
         LittleEndianByteArray.store64(var8, 0, CityHash128HashFunction.access$200(var4 + var10[1], var6 + var9[1]));
         LittleEndianByteArray.store64(var8, 8, CityHash128HashFunction.access$200(var4 + var9[1], var10[1]) + var6);
         return HashCode.fromBytesNoCopy(var8);
      }
   }

   private void weakHashLength32WithSeeds(byte[] var1, int var2, long var3, long var5, long[] var7) {
      long var8 = LittleEndianByteArray.load64(var1, var2);
      long var10 = LittleEndianByteArray.load64(var1, var2 + 8);
      long var12 = LittleEndianByteArray.load64(var1, var2 + 16);
      long var14 = LittleEndianByteArray.load64(var1, var2 + 24);
      var3 += var8;
      var5 = Long.rotateRight(var5 + var3 + var14, 51);
      long var16 = var3;
      var3 += var10;
      var3 += var12;
      var5 += Long.rotateRight(var3, 23);
      var7[0] = var3 + var14;
      var7[1] = var5 + var16;
   }
}
