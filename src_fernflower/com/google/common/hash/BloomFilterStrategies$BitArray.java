package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;

final class BloomFilterStrategies$BitArray {
   final long[] data;
   long bitCount;

   BloomFilterStrategies$BitArray(long var1) {
      this(new long[Ints.checkedCast(LongMath.divide(var1, 64L, RoundingMode.CEILING))]);
   }

   BloomFilterStrategies$BitArray(long[] var1) {
      Preconditions.checkArgument(var1.length > 0, "data length is zero!");
      this.data = var1;
      long var2 = 0L;
      long[] var4 = var1;
      int var5 = var1.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         long var7 = var4[var6];
         var2 += (long)Long.bitCount(var7);
      }

      this.bitCount = var2;
   }

   boolean set(long var1) {
      if(!this.get(var1)) {
         this.data[(int)(var1 >>> 6)] |= 1L << (int)var1;
         ++this.bitCount;
         return true;
      } else {
         return false;
      }
   }

   boolean get(long var1) {
      return (this.data[(int)(var1 >>> 6)] & 1L << (int)var1) != 0L;
   }

   long bitSize() {
      return (long)this.data.length * 64L;
   }

   long bitCount() {
      return this.bitCount;
   }

   BloomFilterStrategies$BitArray copy() {
      return new BloomFilterStrategies$BitArray((long[])this.data.clone());
   }

   void putAll(BloomFilterStrategies$BitArray var1) {
      Preconditions.checkArgument(this.data.length == var1.data.length, "BitArrays must be of equal length (%s != %s)", new Object[]{Integer.valueOf(this.data.length), Integer.valueOf(var1.data.length)});
      this.bitCount = 0L;

      for(int var2 = 0; var2 < this.data.length; ++var2) {
         this.data[var2] |= var1.data[var2];
         this.bitCount += (long)Long.bitCount(this.data[var2]);
      }

   }

   public boolean equals(Object var1) {
      if(var1 instanceof BloomFilterStrategies$BitArray) {
         BloomFilterStrategies$BitArray var2 = (BloomFilterStrategies$BitArray)var1;
         return Arrays.equals(this.data, var2.data);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Arrays.hashCode(this.data);
   }
}
