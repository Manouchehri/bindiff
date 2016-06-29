/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.BloomFilter$1;
import com.google.common.hash.BloomFilter$Strategy;
import com.google.common.hash.BloomFilterStrategies$BitArray;
import com.google.common.hash.Funnel;
import java.io.Serializable;

class BloomFilter$SerialForm
implements Serializable {
    final long[] data;
    final int numHashFunctions;
    final Funnel funnel;
    final BloomFilter.Strategy strategy;
    private static final long serialVersionUID = 1;

    BloomFilter$SerialForm(BloomFilter bloomFilter) {
        this.data = BloomFilter.access$000((BloomFilter)bloomFilter).data;
        this.numHashFunctions = BloomFilter.access$100(bloomFilter);
        this.funnel = BloomFilter.access$200(bloomFilter);
        this.strategy = BloomFilter.access$300(bloomFilter);
    }

    Object readResolve() {
        return new BloomFilter(new BloomFilterStrategies$BitArray(this.data), this.numHashFunctions, this.funnel, this.strategy, null);
    }
}

