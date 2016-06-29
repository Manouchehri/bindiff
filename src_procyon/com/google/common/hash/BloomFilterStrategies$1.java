package com.google.common.hash;

enum BloomFilterStrategies$1
{
    BloomFilterStrategies$1(final String s, final int n) {
    }
    
    @Override
    public boolean put(final Object o, final Funnel funnel, final int n, final BloomFilterStrategies$BitArray bloomFilterStrategies$BitArray) {
        final long bitSize = bloomFilterStrategies$BitArray.bitSize();
        final long long1 = Hashing.murmur3_128().hashObject(o, funnel).asLong();
        final int n2 = (int)long1;
        final int n3 = (int)(long1 >>> 32);
        boolean b = false;
        for (int i = 1; i <= n; ++i) {
            int n4 = n2 + i * n3;
            if (n4 < 0) {
                n4 ^= -1;
            }
            b |= bloomFilterStrategies$BitArray.set(n4 % bitSize);
        }
        return b;
    }
    
    @Override
    public boolean mightContain(final Object o, final Funnel funnel, final int n, final BloomFilterStrategies$BitArray bloomFilterStrategies$BitArray) {
        final long bitSize = bloomFilterStrategies$BitArray.bitSize();
        final long long1 = Hashing.murmur3_128().hashObject(o, funnel).asLong();
        final int n2 = (int)long1;
        final int n3 = (int)(long1 >>> 32);
        for (int i = 1; i <= n; ++i) {
            int n4 = n2 + i * n3;
            if (n4 < 0) {
                n4 ^= -1;
            }
            if (!bloomFilterStrategies$BitArray.get(n4 % bitSize)) {
                return false;
            }
        }
        return true;
    }
}
