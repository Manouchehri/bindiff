/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.BloomFilterStrategies;
import com.google.common.hash.BloomFilterStrategies$1;
import com.google.common.hash.BloomFilterStrategies$BitArray;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Longs;

final class BloomFilterStrategies$2
extends BloomFilterStrategies {
    BloomFilterStrategies$2(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    public boolean put(Object object, Funnel funnel, int n2, BloomFilterStrategies$BitArray bloomFilterStrategies$BitArray) {
        long l2 = bloomFilterStrategies$BitArray.bitSize();
        byte[] arrby = Hashing.murmur3_128().hashObject(object, funnel).getBytesInternal();
        long l3 = this.lowerEight(arrby);
        long l4 = this.upperEight(arrby);
        boolean bl2 = false;
        long l5 = l3;
        int n3 = 0;
        while (n3 < n2) {
            bl2 |= bloomFilterStrategies$BitArray.set((l5 & Long.MAX_VALUE) % l2);
            l5 += l4;
            ++n3;
        }
        return bl2;
    }

    @Override
    public boolean mightContain(Object object, Funnel funnel, int n2, BloomFilterStrategies$BitArray bloomFilterStrategies$BitArray) {
        long l2 = bloomFilterStrategies$BitArray.bitSize();
        byte[] arrby = Hashing.murmur3_128().hashObject(object, funnel).getBytesInternal();
        long l3 = this.lowerEight(arrby);
        long l4 = this.upperEight(arrby);
        long l5 = l3;
        int n3 = 0;
        while (n3 < n2) {
            if (!bloomFilterStrategies$BitArray.get((l5 & Long.MAX_VALUE) % l2)) {
                return false;
            }
            l5 += l4;
            ++n3;
        }
        return true;
    }

    private long lowerEight(byte[] arrby) {
        return Longs.fromBytes(arrby[7], arrby[6], arrby[5], arrby[4], arrby[3], arrby[2], arrby[1], arrby[0]);
    }

    private long upperEight(byte[] arrby) {
        return Longs.fromBytes(arrby[15], arrby[14], arrby[13], arrby[12], arrby[11], arrby[10], arrby[9], arrby[8]);
    }
}

