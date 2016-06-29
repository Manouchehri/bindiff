package com.google.common.hash;

import com.google.common.primitives.*;

enum BloomFilterStrategies$2
{
    BloomFilterStrategies$2(final String s, final int n) {
    }
    
    @Override
    public boolean put(final Object o, final Funnel funnel, final int n, final BloomFilterStrategies$BitArray bloomFilterStrategies$BitArray) {
        final long bitSize = bloomFilterStrategies$BitArray.bitSize();
        final byte[] bytesInternal = Hashing.murmur3_128().hashObject(o, funnel).getBytesInternal();
        final long lowerEight = this.lowerEight(bytesInternal);
        final long upperEight = this.upperEight(bytesInternal);
        boolean b = false;
        long n2 = lowerEight;
        for (int i = 0; i < n; ++i) {
            b |= bloomFilterStrategies$BitArray.set((n2 & Long.MAX_VALUE) % bitSize);
            n2 += upperEight;
        }
        return b;
    }
    
    @Override
    public boolean mightContain(final Object o, final Funnel funnel, final int n, final BloomFilterStrategies$BitArray bloomFilterStrategies$BitArray) {
        final long bitSize = bloomFilterStrategies$BitArray.bitSize();
        final byte[] bytesInternal = Hashing.murmur3_128().hashObject(o, funnel).getBytesInternal();
        final long lowerEight = this.lowerEight(bytesInternal);
        final long upperEight = this.upperEight(bytesInternal);
        long n2 = lowerEight;
        for (int i = 0; i < n; ++i) {
            if (!bloomFilterStrategies$BitArray.get((n2 & Long.MAX_VALUE) % bitSize)) {
                return false;
            }
            n2 += upperEight;
        }
        return true;
    }
    
    private long lowerEight(final byte[] array) {
        return Longs.fromBytes(array[7], array[6], array[5], array[4], array[3], array[2], array[1], array[0]);
    }
    
    private long upperEight(final byte[] array) {
        return Longs.fromBytes(array[15], array[14], array[13], array[12], array[11], array[10], array[9], array[8]);
    }
}
