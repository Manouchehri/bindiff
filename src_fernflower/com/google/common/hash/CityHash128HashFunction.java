package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractNonStreamingHashFunction;
import com.google.common.hash.CityHash128HashFunction$Internal;
import com.google.common.hash.CityHash128HashFunction$InternalImplementation;
import com.google.common.hash.HashCode;
import com.google.common.hash.LittleEndianByteArray;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import javax.annotation.Nullable;

@GoogleInternal
final class CityHash128HashFunction extends AbstractNonStreamingHashFunction {
   private static final long K0 = -6505348102511208375L;
   private static final long K1 = -8261664234251669945L;
   private static final long K2 = -4288712594273399085L;
   private static final long K3 = -4102945252841444853L;
   private static final long K4 = -4132994306676758123L;
   private final long[] seed;
   private static final CityHash128HashFunction$InternalImplementation impl;

   CityHash128HashFunction(long var1, long var3) {
      this.seed = new long[2];
      this.seed[0] = var1;
      this.seed[1] = var3;
   }

   CityHash128HashFunction() {
      this.seed = null;
   }

   public HashCode hashBytes(byte[] var1) {
      return this.hashBytes(var1, 0, var1.length);
   }

   public HashCode hashBytes(byte[] var1, int var2, int var3) {
      Preconditions.checkArgument(var2 >= 0, "offset (%s) cannot be negative", new Object[]{Integer.valueOf(var2)});
      Preconditions.checkArgument(var3 >= 0, "length (%s) cannot be negative", new Object[]{Integer.valueOf(var3)});
      Preconditions.checkArgument(var2 + var3 <= var1.length, "offset (%s) + length (%s) cannot be greater than the byte array length (%s)", new Object[]{Integer.valueOf(var2), Integer.valueOf(var3), Integer.valueOf(var1.length)});
      return impl.fingerprint(var1, var2, var3, this.seed);
   }

   public String toString() {
      String var10000;
      if(this.seed == null) {
         var10000 = "Hashing.cityHash128()";
      } else {
         long var1 = this.seed[0];
         long var3 = this.seed[1];
         var10000 = (new StringBuilder(63)).append("Hashing.cityHash128(").append(var1).append(", ").append(var3).append(")").toString();
      }

      return var10000;
   }

   public int bits() {
      return 128;
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof CityHash128HashFunction) {
         CityHash128HashFunction var2 = (CityHash128HashFunction)var1;
         return Arrays.equals(this.seed, var2.seed);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.seed == null?this.getClass().hashCode():(int)((long)this.getClass().hashCode() ^ this.seed[0] ^ this.seed[1]);
   }

   @VisibleForTesting
   static HashCode hashBytesUsingUnsafe(byte[] var0) {
      return CityHash128HashFunction$Internal.UsingUnsafe.fingerprint(var0, 0, var0.length, (long[])null);
   }

   @VisibleForTesting
   static HashCode hashBytesUsingByteBuffer(byte[] var0) {
      return CityHash128HashFunction$Internal.UsingByteBuffer.fingerprint(var0, 0, var0.length, (long[])null);
   }

   private static HashCode cityMurmur(byte[] var0, int var1, int var2, long var3, long var5) {
      long var7;
      long var9;
      if(var2 <= 16) {
         var7 = var5 * -8261664234251669945L + hashLength0To16(var0, var1, var2);
         var9 = Long.rotateRight(var3 + (var2 >= 8?LittleEndianByteArray.load64(var0, var1):var7), 32);
      } else {
         var7 = hashLength16(LittleEndianByteArray.load64(var0, var1 + var2 - 8) + -8261664234251669945L, var3);
         var9 = hashLength16(var5 + (long)var2, var7 + LittleEndianByteArray.load64(var0, var1 + var2 - 16));
         var3 += var9;
         ByteBuffer var11 = ByteBuffer.allocateDirect(var2);
         var11.order(ByteOrder.LITTLE_ENDIAN);
         var11.put(var0, var1, var2);
         var11.position(0);
         var2 -= 16;

         do {
            var3 ^= shiftMix(var11.getLong() * -8261664234251669945L) * -8261664234251669945L;
            var3 *= -8261664234251669945L;
            var5 ^= var3;
            var7 ^= shiftMix(var11.getLong() * -8261664234251669945L) * -8261664234251669945L;
            var7 *= -8261664234251669945L;
            var9 ^= var7;
            var2 -= 16;
         } while(var2 > 0);
      }

      var3 = hashLength16(var3, var7);
      var5 = hashLength16(var9, var5);
      byte[] var12 = new byte[16];
      LittleEndianByteArray.store64(var12, 0, hashLength16(var5, var3));
      LittleEndianByteArray.store64(var12, 8, var3 ^ var5);
      return HashCode.fromBytesNoCopy(var12);
   }

   private static long hashLength16(long var0, long var2) {
      long var4 = (var2 ^ var0) * -4132994306676758123L;
      var4 ^= var4 >>> 47;
      long var6 = (var0 ^ var4) * -4132994306676758123L;
      var6 ^= var6 >>> 47;
      var6 *= -4132994306676758123L;
      return var6;
   }

   private static long hashLength0To16(byte[] var0, int var1, int var2) {
      long var9;
      if(var2 > 8) {
         var9 = LittleEndianByteArray.load64(var0, var1);
         long var10 = LittleEndianByteArray.load64(var0, var1 + var2 - 8);
         long var11 = hashLength16(var9, Long.rotateRight(var10 + (long)var2, var2)) ^ var10;
         return var11;
      } else if(var2 >= 4) {
         var9 = (long)LittleEndianByteArray.load32(var0, var1) & 4294967295L;
         return hashLength16((long)var2 + (var9 << 3), (long)LittleEndianByteArray.load32(var0, var1 + var2 - 4) & 4294967295L);
      } else if(var2 > 0) {
         byte var3 = var0[var1];
         byte var4 = var0[var2 >> 1];
         byte var5 = var0[var2 - 1];
         int var6 = (var3 & 255) + ((var4 & 255) << 8);
         int var7 = var2 + ((var5 & 255) << 2);
         return shiftMix((long)var6 * -4288712594273399085L ^ (long)var7 * -4102945252841444853L) * -4288712594273399085L;
      } else {
         return -4288712594273399085L;
      }
   }

   private static long shiftMix(long var0) {
      return var0 ^ var0 >>> 47;
   }

   // $FF: synthetic method
   static HashCode access$100(byte[] var0, int var1, int var2, long var3, long var5) {
      return cityMurmur(var0, var1, var2, var3, var5);
   }

   // $FF: synthetic method
   static long access$200(long var0, long var2) {
      return hashLength16(var0, var2);
   }

   static {
      impl = LittleEndianByteArray.usingUnsafe()?CityHash128HashFunction$Internal.UsingUnsafe:CityHash128HashFunction$Internal.UsingByteBuffer;
   }
}
