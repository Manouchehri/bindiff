package com.google.common.hash;

import com.google.common.hash.BloomFilter$Strategy;
import com.google.common.hash.BloomFilterStrategies$1;

enum BloomFilterStrategies implements BloomFilter$Strategy {
   MURMUR128_MITZ_32,
   MURMUR128_MITZ_64;

   private BloomFilterStrategies() {
   }

   // $FF: synthetic method
   BloomFilterStrategies(BloomFilterStrategies$1 var3) {
      this();
   }
}
