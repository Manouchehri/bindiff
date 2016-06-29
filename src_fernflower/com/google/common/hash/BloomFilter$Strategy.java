package com.google.common.hash;

import com.google.common.hash.BloomFilterStrategies$BitArray;
import com.google.common.hash.Funnel;
import java.io.Serializable;

interface BloomFilter$Strategy extends Serializable {
   boolean put(Object var1, Funnel var2, int var3, BloomFilterStrategies$BitArray var4);

   boolean mightContain(Object var1, Funnel var2, int var3, BloomFilterStrategies$BitArray var4);

   int ordinal();
}
