/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;

final class BloomFilterStrategies$BitArray {
    final long[] data;
    long bitCount;

    BloomFilterStrategies$BitArray(long l2) {
        this(new long[Ints.checkedCast(LongMath.divide(l2, 64, RoundingMode.CEILING))]);
    }

    BloomFilterStrategies$BitArray(long[] arrl) {
        Preconditions.checkArgument(arrl.length > 0, "data length is zero!");
        this.data = arrl;
        long l2 = 0;
        long[] arrl2 = arrl;
        int n2 = arrl2.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.bitCount = l2;
                return;
            }
            long l3 = arrl2[n3];
            l2 += (long)Long.bitCount(l3);
            ++n3;
        } while (true);
    }

    boolean set(long l2) {
        if (this.get(l2)) return false;
        long[] arrl = this.data;
        int n2 = (int)(l2 >>> 6);
        arrl[n2] = arrl[n2] | 1 << (int)l2;
        ++this.bitCount;
        return true;
    }

    boolean get(long l2) {
        if ((this.data[(int)(l2 >>> 6)] & 1 << (int)l2) == 0) return false;
        return true;
    }

    long bitSize() {
        return (long)this.data.length * 64;
    }

    long bitCount() {
        return this.bitCount;
    }

    BloomFilterStrategies$BitArray copy() {
        return new BloomFilterStrategies$BitArray((long[])this.data.clone());
    }

    void putAll(BloomFilterStrategies$BitArray bloomFilterStrategies$BitArray) {
        Preconditions.checkArgument(this.data.length == bloomFilterStrategies$BitArray.data.length, "BitArrays must be of equal length (%s != %s)", this.data.length, bloomFilterStrategies$BitArray.data.length);
        this.bitCount = 0;
        int n2 = 0;
        while (n2 < this.data.length) {
            long[] arrl = this.data;
            int n3 = n2;
            arrl[n3] = arrl[n3] | bloomFilterStrategies$BitArray.data[n2];
            this.bitCount += (long)Long.bitCount(this.data[n2]);
            ++n2;
        }
    }

    public boolean equals(Object object) {
        if (!(object instanceof BloomFilterStrategies$BitArray)) return false;
        BloomFilterStrategies$BitArray bloomFilterStrategies$BitArray = (BloomFilterStrategies$BitArray)object;
        return Arrays.equals(this.data, bloomFilterStrategies$BitArray.data);
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }
}

