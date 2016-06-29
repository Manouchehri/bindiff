package com.google.common.hash;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.BloomFilter$1;
import com.google.common.hash.BloomFilter$Strategy;
import com.google.common.hash.BloomFilterStrategies$BitArray;
import com.google.common.hash.Funnel;
import java.io.Serializable;

class BloomFilter$SerialForm implements Serializable {
   final long[] data;
   final int numHashFunctions;
   final Funnel funnel;
   final BloomFilter$Strategy strategy;
   private static final long serialVersionUID = 1L;

   BloomFilter$SerialForm(BloomFilter var1) {
      this.data = BloomFilter.access$000(var1).data;
      this.numHashFunctions = BloomFilter.access$100(var1);
      this.funnel = BloomFilter.access$200(var1);
      this.strategy = BloomFilter.access$300(var1);
   }

   Object readResolve() {
      return new BloomFilter(new BloomFilterStrategies$BitArray(this.data), this.numHashFunctions, this.funnel, this.strategy, (BloomFilter$1)null);
   }
}
