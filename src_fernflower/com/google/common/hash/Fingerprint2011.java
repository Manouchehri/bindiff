package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.hash.AbstractNonStreamingHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.LittleEndianByteArray;
import java.nio.charset.Charset;

@GoogleInternal
final class Fingerprint2011 extends AbstractNonStreamingHashFunction {
   private static final long K0 = -6505348102511208375L;
   private static final long K1 = -8261664234251669945L;
   private static final long K2 = -4288712594273399085L;
   private static final long K3 = -4132994306676758123L;

   public HashCode hashBytes(byte[] var1) {
      return HashCode.fromLong(fingerprint(var1, 0, var1.length));
   }

   public HashCode hashBytes(byte[] var1, int var2, int var3) {
      if(var3 >= 0 && var2 >= 0 && var2 + var3 <= var1.length) {
         return HashCode.fromLong(fingerprint(var1, var2, var3));
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public HashCode hashString(CharSequence var1, Charset var2) {
      return this.hashBytes(var1.toString().getBytes(var2));
   }

   public HashCode hashLong(long var1) {
      return this.newHasher(8).putLong(var1).hash();
   }

   public HashCode hashInt(int var1) {
      return this.newHasher(4).putInt(var1).hash();
   }

   public int bits() {
      return 64;
   }

   public String toString() {
      return "Hashing.fingerprint2011()";
   }

   @VisibleForTesting
   static long fingerprint(byte[] var0, int var1, int var2) {
      long var3;
      if(var2 <= 32) {
         var3 = murmurHash64WithSeed(var0, var1, var2, -1397348546323613475L);
      } else if(var2 <= 64) {
         var3 = hashLength33To64(var0, var1, var2);
      } else {
         var3 = fullFingerprint(var0, var1, var2);
      }

      long var5 = var2 >= 8?LittleEndianByteArray.load64(var0, var1):-6505348102511208375L;
      long var7 = var2 >= 9?LittleEndianByteArray.load64(var0, var1 + var2 - 8):-6505348102511208375L;
      var3 = hash128to64(var3 + var7, var5);
      return var3 != 0L && var3 != 1L?var3:var3 + -2L;
   }

   private static long shiftMix(long var0) {
      return var0 ^ var0 >>> 47;
   }

   @VisibleForTesting
   static long hash128to64(long var0, long var2) {
      long var4 = (var2 ^ var0) * -4132994306676758123L;
      var4 ^= var4 >>> 47;
      long var6 = (var0 ^ var4) * -4132994306676758123L;
      var6 ^= var6 >>> 47;
      var6 *= -4132994306676758123L;
      return var6;
   }

   private static void weakHashLength32WithSeeds(byte[] var0, int var1, long var2, long var4, long[] var6) {
      long var7 = LittleEndianByteArray.load64(var0, var1);
      long var9 = LittleEndianByteArray.load64(var0, var1 + 8);
      long var11 = LittleEndianByteArray.load64(var0, var1 + 16);
      long var13 = LittleEndianByteArray.load64(var0, var1 + 24);
      var2 += var7;
      var4 = Long.rotateRight(var4 + var2 + var13, 51);
      long var15 = var2;
      var2 += var9;
      var2 += var11;
      var4 += Long.rotateRight(var2, 23);
      var6[0] = var2 + var13;
      var6[1] = var4 + var15;
   }

   private static long fullFingerprint(byte[] var0, int var1, int var2) {
      long var3 = LittleEndianByteArray.load64(var0, var1);
      long var5 = LittleEndianByteArray.load64(var0, var1 + var2 - 16) ^ -8261664234251669945L;
      long var7 = LittleEndianByteArray.load64(var0, var1 + var2 - 56) ^ -6505348102511208375L;
      long[] var9 = new long[2];
      long[] var10 = new long[2];
      weakHashLength32WithSeeds(var0, var1 + var2 - 64, (long)var2, var5, var9);
      weakHashLength32WithSeeds(var0, var1 + var2 - 32, (long)var2 * -8261664234251669945L, -6505348102511208375L, var10);
      var7 += shiftMix(var9[1]) * -8261664234251669945L;
      var3 = Long.rotateRight(var7 + var3, 39) * -8261664234251669945L;
      var5 = Long.rotateRight(var5, 33) * -8261664234251669945L;
      var2 = var2 - 1 & -64;

      long var11;
      do {
         var3 = Long.rotateRight(var3 + var5 + var9[0] + LittleEndianByteArray.load64(var0, var1 + 16), 37) * -8261664234251669945L;
         var5 = Long.rotateRight(var5 + var9[1] + LittleEndianByteArray.load64(var0, var1 + 48), 42) * -8261664234251669945L;
         var3 ^= var10[1];
         var5 ^= var9[0];
         var7 = Long.rotateRight(var7 ^ var10[0], 33);
         weakHashLength32WithSeeds(var0, var1, var9[1] * -8261664234251669945L, var3 + var10[0], var9);
         weakHashLength32WithSeeds(var0, var1 + 32, var7 + var10[1], var5, var10);
         var11 = var7;
         var7 = var3;
         var3 = var11;
         var1 += 64;
         var2 -= 64;
      } while(var2 != 0);

      return hash128to64(hash128to64(var9[0], var10[0]) + shiftMix(var5) * -8261664234251669945L + var7, hash128to64(var9[1], var10[1]) + var11);
   }

   private static long hashLength33To64(byte[] var0, int var1, int var2) {
      long var3 = LittleEndianByteArray.load64(var0, var1 + 24);
      long var5 = LittleEndianByteArray.load64(var0, var1) + ((long)var2 + LittleEndianByteArray.load64(var0, var1 + var2 - 16)) * -6505348102511208375L;
      long var7 = Long.rotateRight(var5 + var3, 52);
      long var9 = Long.rotateRight(var5, 37);
      var5 += LittleEndianByteArray.load64(var0, var1 + 8);
      var9 += Long.rotateRight(var5, 7);
      var5 += LittleEndianByteArray.load64(var0, var1 + 16);
      long var11 = var5 + var3;
      long var13 = var7 + Long.rotateRight(var5, 31) + var9;
      var5 = LittleEndianByteArray.load64(var0, var1 + 16) + LittleEndianByteArray.load64(var0, var1 + var2 - 32);
      var3 = LittleEndianByteArray.load64(var0, var1 + var2 - 8);
      var7 = Long.rotateRight(var5 + var3, 52);
      var9 = Long.rotateRight(var5, 37);
      var5 += LittleEndianByteArray.load64(var0, var1 + var2 - 24);
      var9 += Long.rotateRight(var5, 7);
      var5 += LittleEndianByteArray.load64(var0, var1 + var2 - 16);
      long var15 = var5 + var3;
      long var17 = var7 + Long.rotateRight(var5, 31) + var9;
      long var19 = shiftMix((var11 + var17) * -4288712594273399085L + (var15 + var13) * -6505348102511208375L);
      return shiftMix(var19 * -6505348102511208375L + var13) * -4288712594273399085L;
   }

   @VisibleForTesting
   static long murmurHash64WithSeed(byte[] var0, int var1, int var2, long var3) {
      int var8 = var2 & -8;
      int var9 = var2 & 7;
      long var10 = var3 ^ (long)var2 * -4132994306676758123L;

      for(int var12 = 0; var12 < var8; var12 += 8) {
         long var13 = LittleEndianByteArray.load64(var0, var1 + var12);
         long var15 = shiftMix(var13 * -4132994306676758123L) * -4132994306676758123L;
         var10 ^= var15;
         var10 *= -4132994306676758123L;
      }

      if(var9 != 0) {
         long var17 = LittleEndianByteArray.load64Safely(var0, var1 + var8, var9);
         var10 ^= var17;
         var10 *= -4132994306676758123L;
      }

      var10 = shiftMix(var10) * -4132994306676758123L;
      var10 = shiftMix(var10);
      return var10;
   }
}
