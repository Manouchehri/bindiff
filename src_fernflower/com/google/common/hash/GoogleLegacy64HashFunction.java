package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.GoogleLegacy64HashFunction$1;
import com.google.common.hash.GoogleLegacy64HashFunction$GoogleLegacy64Hasher;
import com.google.common.hash.GoogleLegacy64HashFunction$GoogleLegacy64Mixer;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

@GoogleInternal
final class GoogleLegacy64HashFunction extends AbstractStreamingHashFunction {
   private final long seed;

   GoogleLegacy64HashFunction(long var1) {
      this.seed = var1;
   }

   public int bits() {
      return 64;
   }

   public Hasher newHasher() {
      return new GoogleLegacy64HashFunction$GoogleLegacy64Hasher(new GoogleLegacy64HashFunction$GoogleLegacy64Mixer(this.seed), (GoogleLegacy64HashFunction$1)null);
   }

   public String toString() {
      long var1 = this.seed;
      return (new StringBuilder(48)).append("LegacyHashing.googleHash64(").append(var1).append(")").toString();
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof GoogleLegacy64HashFunction) {
         GoogleLegacy64HashFunction var2 = (GoogleLegacy64HashFunction)var1;
         return this.seed == var2.seed;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return (int)(this.seed ^ (long)this.getClass().hashCode());
   }

   public HashCode hashLong(long var1) {
      long var3 = -2266404186210603134L + (var1 & 255L) + (var1 & 65280L) + (var1 & 16711680L) + (var1 & 4278190080L) + (var1 & 1095216660480L) + (var1 & 280375465082880L) + (var1 & 71776119061217280L) + (var1 & -72057594037927936L);
      return HashCode.fromLong(mix64(var3, -2266404186210603134L, this.seed + 8L));
   }

   public HashCode hashInt(int var1) {
      long var2 = -2266404186210603134L + ((long)var1 & 255L) + ((long)var1 & 65280L) + ((long)var1 & 16711680L) + ((long)var1 & 4278190080L);
      return HashCode.fromLong(mix64(var2, -2266404186210603134L, this.seed + 4L));
   }

   public HashCode hashString(CharSequence var1, Charset var2) {
      return this.hashBytes(var1.toString().getBytes(var2));
   }

   public HashCode hashBytes(byte[] var1) {
      return this.hashBytes(var1, 0, var1.length);
   }

   public HashCode hashBytes(byte[] var1, int var2, int var3) {
      Preconditions.checkPositionIndexes(var2, var2 + var3, var1.length);
      long var4 = -2266404186210603134L;
      long var6 = -2266404186210603134L;
      long var8 = this.seed;

      int var10;
      for(var10 = var3; var10 >= 24; var2 += 24) {
         var4 += word64At(var1, var2);
         var6 += word64At(var1, var2 + 8);
         var8 += word64At(var1, var2 + 16);
         var4 -= var6;
         var4 -= var8;
         var4 ^= var8 >>> 43;
         var6 -= var8;
         var6 -= var4;
         var6 ^= var4 << 9;
         var8 -= var4;
         var8 -= var6;
         var8 ^= var6 >>> 8;
         var4 -= var6;
         var4 -= var8;
         var4 ^= var8 >>> 38;
         var6 -= var8;
         var6 -= var4;
         var6 ^= var4 << 23;
         var8 -= var4;
         var8 -= var6;
         var8 ^= var6 >>> 5;
         var4 -= var6;
         var4 -= var8;
         var4 ^= var8 >>> 35;
         var6 -= var8;
         var6 -= var4;
         var6 ^= var4 << 49;
         var8 -= var4;
         var8 -= var6;
         var8 ^= var6 >>> 11;
         var4 -= var6;
         var4 -= var8;
         var4 ^= var8 >>> 12;
         var6 -= var8;
         var6 -= var4;
         var6 ^= var4 << 18;
         var8 -= var4;
         var8 -= var6;
         var8 ^= var6 >>> 22;
         var10 -= 24;
      }

      var8 += (long)var3;
      switch(var10) {
      case 0:
         break;
      case 7:
         var4 += ((long)var1[var2 + 6] & 255L) << 48;
      case 6:
         var4 += ((long)var1[var2 + 5] & 255L) << 40;
      case 5:
         var4 += ((long)var1[var2 + 4] & 255L) << 32;
      case 4:
         var4 += ((long)var1[var2 + 3] & 255L) << 24;
      case 3:
         var4 += ((long)var1[var2 + 2] & 255L) << 16;
      case 2:
         var4 += ((long)var1[var2 + 1] & 255L) << 8;
      case 1:
         var4 += (long)var1[var2 + 0] & 255L;
         break;
      case 15:
         var6 += ((long)var1[var2 + 14] & 255L) << 48;
      case 14:
         var6 += ((long)var1[var2 + 13] & 255L) << 40;
      case 13:
         var6 += ((long)var1[var2 + 12] & 255L) << 32;
      case 12:
         var6 += ((long)var1[var2 + 11] & 255L) << 24;
      case 11:
         var6 += ((long)var1[var2 + 10] & 255L) << 16;
      case 10:
         var6 += ((long)var1[var2 + 9] & 255L) << 8;
      case 9:
         var6 += (long)var1[var2 + 8] & 255L;
      case 8:
         var4 += word64At(var1, var2);
         break;
      case 23:
         var8 += (long)var1[var2 + 22] << 56;
      case 22:
         var8 += ((long)var1[var2 + 21] & 255L) << 48;
      case 21:
         var8 += ((long)var1[var2 + 20] & 255L) << 40;
      case 20:
         var8 += ((long)var1[var2 + 19] & 255L) << 32;
      case 19:
         var8 += ((long)var1[var2 + 18] & 255L) << 24;
      case 18:
         var8 += ((long)var1[var2 + 17] & 255L) << 16;
      case 17:
         var8 += ((long)var1[var2 + 16] & 255L) << 8;
      case 16:
         var6 += word64At(var1, var2 + 8);
         var4 += word64At(var1, var2);
         break;
      default:
         throw new AssertionError();
      }

      return HashCode.fromLong(mix64(var4, var6, var8));
   }

   static long mix64(long var0, long var2, long var4) {
      var0 -= var2;
      var0 -= var4;
      var0 ^= var4 >>> 43;
      var2 -= var4;
      var2 -= var0;
      var2 ^= var0 << 9;
      var4 -= var0;
      var4 -= var2;
      var4 ^= var2 >>> 8;
      var0 -= var2;
      var0 -= var4;
      var0 ^= var4 >>> 38;
      var2 -= var4;
      var2 -= var0;
      var2 ^= var0 << 23;
      var4 -= var0;
      var4 -= var2;
      var4 ^= var2 >>> 5;
      var0 -= var2;
      var0 -= var4;
      var0 ^= var4 >>> 35;
      var2 -= var4;
      var2 -= var0;
      var2 ^= var0 << 49;
      var4 -= var0;
      var4 -= var2;
      var4 ^= var2 >>> 11;
      var0 -= var2;
      var0 -= var4;
      var0 ^= var4 >>> 12;
      var2 -= var4;
      var2 -= var0;
      var2 ^= var0 << 18;
      var4 -= var0;
      var4 -= var2;
      var4 ^= var2 >>> 22;
      return var4;
   }

   private static long word64At(byte[] var0, int var1) {
      return ((long)var0[var1 + 0] & 255L) + (((long)var0[var1 + 1] & 255L) << 8) + (((long)var0[var1 + 2] & 255L) << 16) + (((long)var0[var1 + 3] & 255L) << 24) + (((long)var0[var1 + 4] & 255L) << 32) + (((long)var0[var1 + 5] & 255L) << 40) + (((long)var0[var1 + 6] & 255L) << 48) + (((long)var0[var1 + 7] & 255L) << 56);
   }
}
