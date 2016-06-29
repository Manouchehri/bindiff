/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.BloomFilterStrategies;
import com.google.common.hash.BloomFilterStrategies$BitArray;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

final class BloomFilterStrategies$1
extends BloomFilterStrategies {
    BloomFilterStrategies$1(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    public boolean put(Object object, Funnel funnel, int n2, BloomFilterStrategies$BitArray bloomFilterStrategies$BitArray) {
        long l2 = bloomFilterStrategies$BitArray.bitSize();
        long l3 = Hashing.murmur3_128().hashObject(object, funnel).asLong();
        int n3 = (int)l3;
        int n4 = (int)(l3 >>> 32);
        boolean bl2 = false;
        int n5 = 1;
        while (n5 <= n2) {
            int n6 = n3 + n5 * n4;
            if (n6 < 0) {
                n6 ^= -1;
            }
            bl2 |= bloomFilterStrategies$BitArray.set((long)n6 % l2);
            ++n5;
        }
        return bl2;
    }

    @Override
    public boolean mightContain(Object object, Funnel funnel, int n2, BloomFilterStrategies$BitArray bloomFilterStrategies$BitArray) {
        long l2 = bloomFilterStrategies$BitArray.bitSize();
        long l3 = Hashing.murmur3_128().hashObject(object, funnel).asLong();
        int n3 = (int)l3;
        int n4 = (int)(l3 >>> 32);
        int n5 = 1;
        while (n5 <= n2) {
            int n6 = n3 + n5 * n4;
            if (n6 < 0) {
                n6 ^= -1;
            }
            if (!bloomFilterStrategies$BitArray.get((long)n6 % l2)) {
                return false;
            }
            ++n5;
        }
        return true;
    }
}

