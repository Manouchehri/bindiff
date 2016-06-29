package com.google.common.hash;

import com.google.common.hash.CityHash128HashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.LittleEndianByteArray;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

enum CityHash128HashFunction$Internal$2 {
   protected HashCode fingerprint(byte[] var1, int var2, int var3, long var4, long var6) {
      if(var3 < 128) {
         return CityHash128HashFunction.access$100(var1, var2, var3, var4, var6);
      } else {
         long[] var8 = new long[2];
         long[] var9 = new long[2];
         long var10 = (long)var3 * -8261664234251669945L;
         var8[0] = Long.rotateRight(var6 ^ -8261664234251669945L, 49) * -8261664234251669945L + LittleEndianByteArray.load64(var1, var2);
         var8[1] = Long.rotateRight(var8[0], 42) * -8261664234251669945L + LittleEndianByteArray.load64(var1, var2 + 8);
         var9[0] = Long.rotateRight(var6 + var10, 35) * -8261664234251669945L + var4;
         var9[1] = Long.rotateRight(var4 + LittleEndianByteArray.load64(var1, var2 + 88), 53) * -8261664234251669945L;
         ByteBuffer var12 = ByteBuffer.allocateDirect(128);
         var12.order(ByteOrder.LITTLE_ENDIAN);

         do {
            var12.position(0);
            var12.put(var1, var2, 128);
            var4 = Long.rotateRight(var4 + var6 + var8[0] + var12.getLong(16), 37) * -8261664234251669945L;
            var6 = Long.rotateRight(var6 + var8[1] + var12.getLong(48), 42) * -8261664234251669945L;
            var4 ^= var9[1];
            var6 ^= var8[0];
            var10 = Long.rotateRight(var10 ^ var9[0], 33);
            var12.position(0);
            this.weakHashLength32WithSeeds(var12, var8[1] * -8261664234251669945L, var4 + var9[0], var8);
            this.weakHashLength32WithSeeds(var12, var10 + var9[1], var6, var9);
            var10 = Long.rotateRight(var10 + var6 + var8[0] + LittleEndianByteArray.load64(var1, var2 + 80), 37) * -8261664234251669945L;
            var6 = Long.rotateRight(var6 + var8[1] + LittleEndianByteArray.load64(var1, var2 + 112), 42) * -8261664234251669945L;
            var10 ^= var9[1];
            var6 ^= var8[0];
            var4 = Long.rotateRight(var4 ^ var9[0], 33);
            this.weakHashLength32WithSeeds(var12, var8[1] * -8261664234251669945L, var10 + var9[0], var8);
            this.weakHashLength32WithSeeds(var12, var4 + var9[1], var6, var9);
            var2 += 128;
            var3 -= 128;
         } while(var3 >= 128);

         var6 += Long.rotateRight(var9[0], 37) * -6505348102511208375L + var10;
         var4 += Long.rotateRight(var8[0] + var10, 49) * -6505348102511208375L;
         var12.position(0);
         int var13 = var3 & 31;
         int var14 = var3 ^ var13;
         int var15 = 32 - var13;
         var12.put(var1, var2 - var15, var3 + var15);

         while(var3 > 0) {
            var6 = Long.rotateRight(var6 - var4, 42) * -6505348102511208375L + var8[1];
            var9[0] += var12.getLong(var3 + var15 - 16);
            var4 = Long.rotateRight(var4, 49) * -6505348102511208375L + var9[0];
            var9[0] += var8[0];
            var12.position(var14);
            this.weakHashLength32WithSeeds(var12, var8[0], var8[1], var8);
            var14 -= 32;
            var3 -= 32;
         }

         var4 = CityHash128HashFunction.access$200(var4, var8[0]);
         var6 = CityHash128HashFunction.access$200(var6, var9[0]);
         var12.position(0);
         var12.putLong(CityHash128HashFunction.access$200(var4 + var9[1], var6 + var8[1])).putLong(CityHash128HashFunction.access$200(var4 + var8[1], var9[1]) + var6);
         byte[] var16 = new byte[16];
         var12.position(0);
         var12.get(var16, 0, 16);
         return HashCode.fromBytesNoCopy(var16);
      }
   }

   private void weakHashLength32WithSeeds(ByteBuffer var1, long var2, long var4, long[] var6) {
      long var7 = var1.getLong();
      long var9 = var1.getLong();
      long var11 = var1.getLong();
      long var13 = var1.getLong();
      var2 += var7;
      var4 = Long.rotateRight(var4 + var2 + var13, 51);
      long var15 = var2;
      var2 += var9;
      var2 += var11;
      var4 += Long.rotateRight(var2, 23);
      var6[0] = var2 + var13;
      var6[1] = var4 + var15;
   }
}
