package com.google.common.hash;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.primitives.*;
import java.io.*;

class BloomFilter$SerialForm implements Serializable
{
    final long[] data;
    final int numHashFunctions;
    final Funnel funnel;
    final BloomFilter$Strategy strategy;
    private static final long serialVersionUID = 1L;
    
    BloomFilter$SerialForm(final BloomFilter bloomFilter) {
        this.data = bloomFilter.bits.data;
        this.numHashFunctions = bloomFilter.numHashFunctions;
        this.funnel = bloomFilter.funnel;
        this.strategy = bloomFilter.strategy;
    }
    
    Object readResolve() {
        return new BloomFilter(new BloomFilterStrategies$BitArray(this.data), this.numHashFunctions, this.funnel, this.strategy, null);
    }
}
