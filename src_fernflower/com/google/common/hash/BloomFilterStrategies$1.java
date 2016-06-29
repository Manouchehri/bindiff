package com.google.common.hash;

import com.google.common.hash.BloomFilterStrategies$BitArray;
import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;

enum BloomFilterStrategies$1 {
   public boolean put(Object var1, Funnel var2, int var3, BloomFilterStrategies$BitArray var4) {
      long var5 = var4.bitSize();
      long var7 = Hashing.murmur3_128().hashObject(var1, var2).asLong();
      int var9 = (int)var7;
      int var10 = (int)(var7 >>> 32);
      boolean var11 = false;

      for(int var12 = 1; var12 <= var3; ++var12) {
         int var13 = var9 + var12 * var10;
         if(var13 < 0) {
            var13 = ~var13;
         }

         var11 |= var4.set((long)var13 % var5);
      }

      return var11;
   }

   public boolean mightContain(Object var1, Funnel var2, int var3, BloomFilterStrategies$BitArray var4) {
      long var5 = var4.bitSize();
      long var7 = Hashing.murmur3_128().hashObject(var1, var2).asLong();
      int var9 = (int)var7;
      int var10 = (int)(var7 >>> 32);

      for(int var11 = 1; var11 <= var3; ++var11) {
         int var12 = var9 + var11 * var10;
         if(var12 < 0) {
            var12 = ~var12;
         }

         if(!var4.get((long)var12 % var5)) {
            return false;
         }
      }

      return true;
   }
}
