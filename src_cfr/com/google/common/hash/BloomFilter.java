/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilter$1;
import com.google.common.hash.BloomFilter$SerialForm;
import com.google.common.hash.BloomFilter$Strategy;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.hash.BloomFilterStrategies$BitArray;
import com.google.common.hash.Funnel;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Beta
public final class BloomFilter
implements Predicate,
Serializable {
    private final BloomFilterStrategies$BitArray bits;
    private final int numHashFunctions;
    private final Funnel funnel;
    private final BloomFilter$Strategy strategy;

    private BloomFilter(BloomFilterStrategies$BitArray bloomFilterStrategies$BitArray, int n2, Funnel funnel, BloomFilter$Strategy bloomFilter$Strategy) {
        Preconditions.checkArgument(n2 > 0, "numHashFunctions (%s) must be > 0", n2);
        Preconditions.checkArgument(n2 <= 255, "numHashFunctions (%s) must be <= 255", n2);
        this.bits = (BloomFilterStrategies$BitArray)Preconditions.checkNotNull(bloomFilterStrategies$BitArray);
        this.numHashFunctions = n2;
        this.funnel = (Funnel)Preconditions.checkNotNull(funnel);
        this.strategy = (BloomFilter$Strategy)Preconditions.checkNotNull(bloomFilter$Strategy);
    }

    @CheckReturnValue
    public BloomFilter copy() {
        return new BloomFilter(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @CheckReturnValue
    public boolean mightContain(Object object) {
        return this.strategy.mightContain(object, this.funnel, this.numHashFunctions, this.bits);
    }

    @Deprecated
    @CheckReturnValue
    @Override
    public boolean apply(Object object) {
        return this.mightContain(object);
    }

    public boolean put(Object object) {
        return this.strategy.put(object, this.funnel, this.numHashFunctions, this.bits);
    }

    @CheckReturnValue
    public double expectedFpp() {
        return Math.pow((double)this.bits.bitCount() / (double)this.bitSize(), this.numHashFunctions);
    }

    @VisibleForTesting
    long bitSize() {
        return this.bits.bitSize();
    }

    @CheckReturnValue
    public boolean isCompatible(BloomFilter bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        if (this == bloomFilter) return false;
        if (this.numHashFunctions != bloomFilter.numHashFunctions) return false;
        if (this.bitSize() != bloomFilter.bitSize()) return false;
        if (!this.strategy.equals(bloomFilter.strategy)) return false;
        if (!this.funnel.equals(bloomFilter.funnel)) return false;
        return true;
    }

    public void putAll(BloomFilter bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        Preconditions.checkArgument(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        Preconditions.checkArgument(this.numHashFunctions == bloomFilter.numHashFunctions, "BloomFilters must have the same number of hash functions (%s != %s)", this.numHashFunctions, bloomFilter.numHashFunctions);
        Preconditions.checkArgument(this.bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", this.bitSize(), bloomFilter.bitSize());
        Preconditions.checkArgument(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        Preconditions.checkArgument(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.putAll(bloomFilter.bits);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BloomFilter)) return false;
        BloomFilter bloomFilter = (BloomFilter)object;
        if (this.numHashFunctions != bloomFilter.numHashFunctions) return false;
        if (!this.funnel.equals(bloomFilter.funnel)) return false;
        if (!this.bits.equals(bloomFilter.bits)) return false;
        if (!this.strategy.equals(bloomFilter.strategy)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.numHashFunctions, this.funnel, this.strategy, this.bits);
    }

    @CheckReturnValue
    public static BloomFilter create(Funnel funnel, int n2, double d2) {
        return BloomFilter.create(funnel, (long)n2, d2);
    }

    @CheckReturnValue
    public static BloomFilter create(Funnel funnel, long l2, double d2) {
        return BloomFilter.create(funnel, l2, d2, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    @VisibleForTesting
    static BloomFilter create(Funnel funnel, long l2, double d2, BloomFilter$Strategy bloomFilter$Strategy) {
        Preconditions.checkNotNull(funnel);
        Preconditions.checkArgument(l2 >= 0, "Expected insertions (%s) must be >= 0", l2);
        Preconditions.checkArgument(d2 > 0.0, "False positive probability (%s) must be > 0.0", d2);
        Preconditions.checkArgument(d2 < 1.0, "False positive probability (%s) must be < 1.0", d2);
        Preconditions.checkNotNull(bloomFilter$Strategy);
        if (l2 == 0) {
            l2 = 1;
        }
        long l3 = BloomFilter.optimalNumOfBits(l2, d2);
        int n2 = BloomFilter.optimalNumOfHashFunctions(l2, l3);
        try {
            return new BloomFilter(new BloomFilterStrategies$BitArray(l3), n2, funnel, bloomFilter$Strategy);
        }
        catch (IllegalArgumentException var9_6) {
            throw new IllegalArgumentException(new StringBuilder(57).append("Could not create BloomFilter of ").append(l3).append(" bits").toString(), var9_6);
        }
    }

    @CheckReturnValue
    public static BloomFilter create(Funnel funnel, int n2) {
        return BloomFilter.create(funnel, (long)n2);
    }

    @CheckReturnValue
    public static BloomFilter create(Funnel funnel, long l2) {
        return BloomFilter.create(funnel, l2, 0.03);
    }

    @VisibleForTesting
    static int optimalNumOfHashFunctions(long l2, long l3) {
        return Math.max(1, (int)Math.round((double)l3 / (double)l2 * Math.log(2.0)));
    }

    @VisibleForTesting
    static long optimalNumOfBits(long l2, double d2) {
        if (d2 != 0.0) return (long)((double)(- l2) * Math.log(d2) / (Math.log(2.0) * Math.log(2.0)));
        d2 = Double.MIN_VALUE;
        return (long)((double)(- l2) * Math.log(d2) / (Math.log(2.0) * Math.log(2.0)));
    }

    private Object writeReplace() {
        return new BloomFilter$SerialForm(this);
    }

    public void writeTo(OutputStream outputStream) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.data.length);
        long[] arrl = this.bits.data;
        int n2 = arrl.length;
        int n3 = 0;
        while (n3 < n2) {
            long l2 = arrl[n3];
            dataOutputStream.writeLong(l2);
            ++n3;
        }
    }

    @CheckReturnValue
    public static BloomFilter readFrom(InputStream inputStream, Funnel funnel) {
        Preconditions.checkNotNull(inputStream, "InputStream");
        Preconditions.checkNotNull(funnel, "Funnel");
        int n2 = -1;
        int n3 = -1;
        int n4 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            n2 = dataInputStream.readByte();
            n3 = UnsignedBytes.toInt(dataInputStream.readByte());
            n4 = dataInputStream.readInt();
            BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[n2];
            long[] arrl = new long[n4];
            int n5 = 0;
            while (n5 < arrl.length) {
                arrl[n5] = dataInputStream.readLong();
                ++n5;
            }
            return new BloomFilter(new BloomFilterStrategies$BitArray(arrl), n3, funnel, bloomFilterStrategies);
        }
        catch (RuntimeException var5_6) {
            String string = String.valueOf("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
            int n6 = n2;
            int n7 = n3;
            int n8 = n4;
            IOException iOException = new IOException(new StringBuilder(65 + String.valueOf(string).length()).append(string).append(n6).append(" numHashFunctions: ").append(n7).append(" dataLength: ").append(n8).toString());
            iOException.initCause(var5_6);
            throw iOException;
        }
    }

    static /* synthetic */ BloomFilterStrategies$BitArray access$000(BloomFilter bloomFilter) {
        return bloomFilter.bits;
    }

    static /* synthetic */ int access$100(BloomFilter bloomFilter) {
        return bloomFilter.numHashFunctions;
    }

    static /* synthetic */ Funnel access$200(BloomFilter bloomFilter) {
        return bloomFilter.funnel;
    }

    static /* synthetic */ BloomFilter$Strategy access$300(BloomFilter bloomFilter) {
        return bloomFilter.strategy;
    }

    /* synthetic */ BloomFilter(BloomFilterStrategies$BitArray bloomFilterStrategies$BitArray, int n2, Funnel funnel, BloomFilter$Strategy bloomFilter$Strategy, BloomFilter$1 bloomFilter$1) {
        this(bloomFilterStrategies$BitArray, n2, funnel, bloomFilter$Strategy);
    }
}

