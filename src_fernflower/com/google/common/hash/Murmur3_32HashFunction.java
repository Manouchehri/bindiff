package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Murmur3_32HashFunction$Murmur3_32Hasher;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Murmur3_32HashFunction extends AbstractStreamingHashFunction implements Serializable {
   private static final int C1 = -862048943;
   private static final int C2 = 461845907;
   private final int seed;
   private static final long serialVersionUID = 0L;

   Murmur3_32HashFunction(int var1) {
      this.seed = var1;
   }

   public int bits() {
      return 32;
   }

   public Hasher newHasher() {
      return new Murmur3_32HashFunction$Murmur3_32Hasher(this.seed);
   }

   public String toString() {
      int var1 = this.seed;
      return (new StringBuilder(31)).append("Hashing.murmur3_32(").append(var1).append(")").toString();
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Murmur3_32HashFunction) {
         Murmur3_32HashFunction var2 = (Murmur3_32HashFunction)var1;
         return this.seed == var2.seed;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.getClass().hashCode() ^ this.seed;
   }

   public HashCode hashInt(int var1) {
      int var2 = mixK1(var1);
      int var3 = mixH1(this.seed, var2);
      return fmix(var3, 4);
   }

   public HashCode hashLong(long var1) {
      int var3 = (int)var1;
      int var4 = (int)(var1 >>> 32);
      int var5 = mixK1(var3);
      int var6 = mixH1(this.seed, var5);
      var5 = mixK1(var4);
      var6 = mixH1(var6, var5);
      return fmix(var6, 8);
   }

   public HashCode hashString(CharSequence var1) {
      return this.hashUnencodedChars(var1);
   }

   public HashCode hashUnencodedChars(CharSequence var1) {
      int var2 = this.seed;

      int var3;
      for(var3 = 1; var3 < var1.length(); var3 += 2) {
         int var4 = var1.charAt(var3 - 1) | var1.charAt(var3) << 16;
         var4 = mixK1(var4);
         var2 = mixH1(var2, var4);
      }

      if((var1.length() & 1) == 1) {
         char var5 = var1.charAt(var1.length() - 1);
         var3 = mixK1(var5);
         var2 ^= var3;
      }

      return fmix(var2, 2 * var1.length());
   }

   private static int mixK1(int var0) {
      var0 *= -862048943;
      var0 = Integer.rotateLeft(var0, 15);
      var0 *= 461845907;
      return var0;
   }

   private static int mixH1(int var0, int var1) {
      var0 ^= var1;
      var0 = Integer.rotateLeft(var0, 13);
      var0 = var0 * 5 + -430675100;
      return var0;
   }

   private static HashCode fmix(int var0, int var1) {
      var0 ^= var1;
      var0 ^= var0 >>> 16;
      var0 *= -2048144789;
      var0 ^= var0 >>> 13;
      var0 *= -1028477387;
      var0 ^= var0 >>> 16;
      return HashCode.fromInt(var0);
   }

   // $FF: synthetic method
   static int access$000(int var0) {
      return mixK1(var0);
   }

   // $FF: synthetic method
   static int access$100(int var0, int var1) {
      return mixH1(var0, var1);
   }

   // $FF: synthetic method
   static HashCode access$200(int var0, int var1) {
      return fmix(var0, var1);
   }
}
