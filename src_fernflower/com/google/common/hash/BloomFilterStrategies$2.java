package com.google.common.hash;

import com.google.common.hash.BloomFilterStrategies$BitArray;
import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Longs;

enum BloomFilterStrategies$2 {
   public boolean put(Object var1, Funnel var2, int var3, BloomFilterStrategies$BitArray var4) {
      long var5 = var4.bitSize();
      byte[] var7 = Hashing.murmur3_128().hashObject(var1, var2).getBytesInternal();
      long var8 = this.lowerEight(var7);
      long var10 = this.upperEight(var7);
      boolean var12 = false;
      long var13 = var8;

      for(int var15 = 0; var15 < var3; ++var15) {
         var12 |= var4.set((var13 & Long.MAX_VALUE) % var5);
         var13 += var10;
      }

      return var12;
   }

   public boolean mightContain(Object var1, Funnel var2, int var3, BloomFilterStrategies$BitArray var4) {
      long var5 = var4.bitSize();
      byte[] var7 = Hashing.murmur3_128().hashObject(var1, var2).getBytesInternal();
      long var8 = this.lowerEight(var7);
      long var10 = this.upperEight(var7);
      long var12 = var8;

      for(int var14 = 0; var14 < var3; ++var14) {
         if(!var4.get((var12 & Long.MAX_VALUE) % var5)) {
            return false;
         }

         var12 += var10;
      }

      return true;
   }

   private long lowerEight(byte[] var1) {
      return Longs.fromBytes(var1[7], var1[6], var1[5], var1[4], var1[3], var1[2], var1[1], var1[0]);
   }

   private long upperEight(byte[] var1) {
      return Longs.fromBytes(var1[15], var1[14], var1[13], var1[12], var1[11], var1[10], var1[9], var1[8]);
   }
}
