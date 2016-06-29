package com.google.common.hash;

import java.math.*;
import com.google.common.math.*;
import com.google.common.primitives.*;
import com.google.common.base.*;
import java.util.*;

final class BloomFilterStrategies$BitArray
{
    final long[] data;
    long bitCount;
    
    BloomFilterStrategies$BitArray(final long n) {
        this(new long[Ints.checkedCast(LongMath.divide(n, 64L, RoundingMode.CEILING))]);
    }
    
    BloomFilterStrategies$BitArray(final long[] data) {
        Preconditions.checkArgument(data.length > 0, (Object)"data length is zero!");
        this.data = data;
        long bitCount = 0L;
        for (int length = data.length, i = 0; i < length; ++i) {
            bitCount += Long.bitCount(data[i]);
        }
        this.bitCount = bitCount;
    }
    
    boolean set(final long n) {
        if (!this.get(n)) {
            final long[] data = this.data;
            final int n2 = (int)(n >>> 6);
            data[n2] |= 1L << (int)n;
            ++this.bitCount;
            return true;
        }
        return false;
    }
    
    boolean get(final long n) {
        return (this.data[(int)(n >>> 6)] & 1L << (int)n) != 0x0L;
    }
    
    long bitSize() {
        return this.data.length * 64L;
    }
    
    long bitCount() {
        return this.bitCount;
    }
    
    BloomFilterStrategies$BitArray copy() {
        return new BloomFilterStrategies$BitArray(this.data.clone());
    }
    
    void putAll(final BloomFilterStrategies$BitArray bloomFilterStrategies$BitArray) {
        Preconditions.checkArgument(this.data.length == bloomFilterStrategies$BitArray.data.length, "BitArrays must be of equal length (%s != %s)", this.data.length, bloomFilterStrategies$BitArray.data.length);
        this.bitCount = 0L;
        for (int i = 0; i < this.data.length; ++i) {
            final long[] data = this.data;
            final int n = i;
            data[n] |= bloomFilterStrategies$BitArray.data[i];
            this.bitCount += Long.bitCount(this.data[i]);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof BloomFilterStrategies$BitArray && Arrays.equals(this.data, ((BloomFilterStrategies$BitArray)o).data);
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.data);
    }
}
