package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.GoogleLegacy32HashFunction$1;
import com.google.common.hash.GoogleLegacy32HashFunction$FingerprintStrategy;
import com.google.common.hash.GoogleLegacy32HashFunction$GoogleLegacy32Hasher;
import com.google.common.hash.GoogleLegacy32HashFunction$GoogleLegacy32Mixer;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

@GoogleInternal
final class GoogleLegacy32HashFunction extends AbstractStreamingHashFunction {
   private final int seed;
   private final GoogleLegacy32HashFunction$FingerprintStrategy fingerprintStrategy;

   GoogleLegacy32HashFunction(int var1, GoogleLegacy32HashFunction$FingerprintStrategy var2) {
      this.seed = var1;
      this.fingerprintStrategy = (GoogleLegacy32HashFunction$FingerprintStrategy)Preconditions.checkNotNull(var2);
   }

   public int bits() {
      return 32;
   }

   public Hasher newHasher() {
      return new GoogleLegacy32HashFunction$GoogleLegacy32Hasher(new GoogleLegacy32HashFunction$GoogleLegacy32Mixer(this.seed), this.fingerprintStrategy, (GoogleLegacy32HashFunction$1)null);
   }

   public String toString() {
      int var1 = this.seed;
      return (new StringBuilder(39)).append("LegacyHashing.googleHash32(").append(var1).append(")").toString();
   }

   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof GoogleLegacy32HashFunction)) {
         return false;
      } else {
         GoogleLegacy32HashFunction var2 = (GoogleLegacy32HashFunction)var1;
         return this.seed == var2.seed && this.fingerprintStrategy == var2.fingerprintStrategy;
      }
   }

   public int hashCode() {
      return this.seed ^ this.fingerprintStrategy.hashCode() ^ this.getClass().hashCode();
   }

   public HashCode hashLong(long var1) {
      int var3 = -1640531527 + (byte)((int)var1) + ((byte)((int)(var1 >> 8)) << 8) + ((byte)((int)(var1 >> 16)) << 16) + ((byte)((int)(var1 >> 24)) << 24);
      int var4 = -1640531527 + (byte)((int)(var1 >> 32)) + ((byte)((int)(var1 >> 40)) << 8) + ((byte)((int)(var1 >> 48)) << 16) + ((byte)((int)(var1 >> 56)) << 24);
      return HashCode.fromInt(mix32(var3, var4, this.seed + 8));
   }

   public HashCode hashInt(int var1) {
      int var2 = -1640531527 + (byte)var1 + ((byte)(var1 >> 8) << 8) + ((byte)(var1 >> 16) << 16) + ((byte)(var1 >> 24) << 24);
      return HashCode.fromInt(mix32(var2, -1640531527, this.seed + 4));
   }

   public HashCode hashString(CharSequence var1, Charset var2) {
      return this.hashBytes(var1.toString().getBytes(var2));
   }

   public HashCode hashBytes(byte[] var1) {
      return this.hashBytes(var1, 0, var1.length);
   }

   public HashCode hashBytes(byte[] var1, int var2, int var3) {
      Preconditions.checkPositionIndexes(var2, var2 + var3, var1.length);
      int var4 = -1640531527;
      int var5 = -1640531527;
      int var6 = this.seed;

      int var7;
      for(var7 = var3; var7 >= 12; var2 += 12) {
         var4 += this.fingerprintStrategy.word32At(var1, var2);
         var5 += this.fingerprintStrategy.word32At(var1, var2 + 4);
         var6 += this.fingerprintStrategy.word32At(var1, var2 + 8);
         var4 -= var5;
         var4 -= var6;
         var4 ^= var6 >>> 13;
         var5 -= var6;
         var5 -= var4;
         var5 ^= var4 << 8;
         var6 -= var4;
         var6 -= var5;
         var6 ^= var5 >>> 13;
         var4 -= var5;
         var4 -= var6;
         var4 ^= var6 >>> 12;
         var5 -= var6;
         var5 -= var4;
         var5 ^= var4 << 16;
         var6 -= var4;
         var6 -= var5;
         var6 ^= var5 >>> 5;
         var4 -= var5;
         var4 -= var6;
         var4 ^= var6 >>> 3;
         var5 -= var6;
         var5 -= var4;
         var5 ^= var4 << 10;
         var6 -= var4;
         var6 -= var5;
         var6 ^= var5 >>> 15;
         var7 -= 12;
      }

      var6 += var3;
      switch(var7) {
      case 0:
         break;
      case 3:
         var4 += (var1[var2 + 2] & 255) << 16;
      case 2:
         var4 += (var1[var2 + 1] & 255) << 8;
      case 1:
         var4 += var1[var2 + 0] & 255;
         break;
      case 7:
         var5 += (var1[var2 + 6] & 255) << 16;
      case 6:
         var5 += (var1[var2 + 5] & 255) << 8;
      case 5:
         var5 += var1[var2 + 4] & 255;
      case 4:
         var4 += this.fingerprintStrategy.word32At(var1, var2);
         break;
      case 11:
         var6 += var1[var2 + 10] << 24;
      case 10:
         var6 += (var1[var2 + 9] & 255) << 16;
      case 9:
         var6 += (var1[var2 + 8] & 255) << 8;
      case 8:
         var5 += this.fingerprintStrategy.word32At(var1, var2 + 4);
         var4 += this.fingerprintStrategy.word32At(var1, var2);
         break;
      default:
         throw new AssertionError();
      }

      return HashCode.fromInt(mix32(var4, var5, var6));
   }

   static int mix32(int var0, int var1, int var2) {
      var0 -= var1;
      var0 -= var2;
      var0 ^= var2 >>> 13;
      var1 -= var2;
      var1 -= var0;
      var1 ^= var0 << 8;
      var2 -= var0;
      var2 -= var1;
      var2 ^= var1 >>> 13;
      var0 -= var1;
      var0 -= var2;
      var0 ^= var2 >>> 12;
      var1 -= var2;
      var1 -= var0;
      var1 ^= var0 << 16;
      var2 -= var0;
      var2 -= var1;
      var2 ^= var1 >>> 5;
      var0 -= var1;
      var0 -= var2;
      var0 ^= var2 >>> 3;
      var1 -= var2;
      var1 -= var0;
      var1 ^= var0 << 10;
      var2 -= var0;
      var2 -= var1;
      var2 ^= var1 >>> 15;
      return var2;
   }
}
