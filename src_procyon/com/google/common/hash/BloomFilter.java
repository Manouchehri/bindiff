package com.google.common.hash;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.primitives.*;
import java.io.*;

@Beta
public final class BloomFilter implements Predicate, Serializable
{
    private final BloomFilterStrategies$BitArray bits;
    private final int numHashFunctions;
    private final Funnel funnel;
    private final BloomFilter$Strategy strategy;
    
    private BloomFilter(final BloomFilterStrategies$BitArray bloomFilterStrategies$BitArray, final int numHashFunctions, final Funnel funnel, final BloomFilter$Strategy bloomFilter$Strategy) {
        Preconditions.checkArgument(numHashFunctions > 0, "numHashFunctions (%s) must be > 0", numHashFunctions);
        Preconditions.checkArgument(numHashFunctions <= 255, "numHashFunctions (%s) must be <= 255", numHashFunctions);
        this.bits = (BloomFilterStrategies$BitArray)Preconditions.checkNotNull(bloomFilterStrategies$BitArray);
        this.numHashFunctions = numHashFunctions;
        this.funnel = (Funnel)Preconditions.checkNotNull(funnel);
        this.strategy = (BloomFilter$Strategy)Preconditions.checkNotNull(bloomFilter$Strategy);
    }
    
    @CheckReturnValue
    public BloomFilter copy() {
        return new BloomFilter(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }
    
    @CheckReturnValue
    public boolean mightContain(final Object o) {
        return this.strategy.mightContain(o, this.funnel, this.numHashFunctions, this.bits);
    }
    
    @Deprecated
    @CheckReturnValue
    @Override
    public boolean apply(final Object o) {
        return this.mightContain(o);
    }
    
    public boolean put(final Object o) {
        return this.strategy.put(o, this.funnel, this.numHashFunctions, this.bits);
    }
    
    @CheckReturnValue
    public double expectedFpp() {
        return Math.pow(this.bits.bitCount() / this.bitSize(), this.numHashFunctions);
    }
    
    @VisibleForTesting
    long bitSize() {
        return this.bits.bitSize();
    }
    
    @CheckReturnValue
    public boolean isCompatible(final BloomFilter bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && this.bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }
    
    public void putAll(final BloomFilter bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        Preconditions.checkArgument(this != bloomFilter, (Object)"Cannot combine a BloomFilter with itself.");
        Preconditions.checkArgument(this.numHashFunctions == bloomFilter.numHashFunctions, "BloomFilters must have the same number of hash functions (%s != %s)", this.numHashFunctions, bloomFilter.numHashFunctions);
        Preconditions.checkArgument(this.bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", this.bitSize(), bloomFilter.bitSize());
        Preconditions.checkArgument(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        Preconditions.checkArgument(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.putAll(bloomFilter.bits);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof BloomFilter) {
            final BloomFilter bloomFilter = (BloomFilter)o;
            return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.numHashFunctions, this.funnel, this.strategy, this.bits);
    }
    
    @CheckReturnValue
    public static BloomFilter create(final Funnel funnel, final int n, final double n2) {
        return create(funnel, (long)n, n2);
    }
    
    @CheckReturnValue
    public static BloomFilter create(final Funnel funnel, final long n, final double n2) {
        return create(funnel, n, n2, BloomFilterStrategies.MURMUR128_MITZ_64);
    }
    
    @VisibleForTesting
    static BloomFilter create(final Funnel funnel, long n, final double n2, final BloomFilter$Strategy bloomFilter$Strategy) {
        Preconditions.checkNotNull(funnel);
        Preconditions.checkArgument(n >= 0L, "Expected insertions (%s) must be >= 0", n);
        Preconditions.checkArgument(n2 > 0.0, "False positive probability (%s) must be > 0.0", n2);
        Preconditions.checkArgument(n2 < 1.0, "False positive probability (%s) must be < 1.0", n2);
        Preconditions.checkNotNull(bloomFilter$Strategy);
        if (n == 0L) {
            n = 1L;
        }
        final long optimalNumOfBits = optimalNumOfBits(n, n2);
        final int optimalNumOfHashFunctions = optimalNumOfHashFunctions(n, optimalNumOfBits);
        try {
            return new BloomFilter(new BloomFilterStrategies$BitArray(optimalNumOfBits), optimalNumOfHashFunctions, funnel, bloomFilter$Strategy);
        }
        catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(new StringBuilder(57).append("Could not create BloomFilter of ").append(optimalNumOfBits).append(" bits").toString(), ex);
        }
    }
    
    @CheckReturnValue
    public static BloomFilter create(final Funnel funnel, final int n) {
        return create(funnel, (long)n);
    }
    
    @CheckReturnValue
    public static BloomFilter create(final Funnel funnel, final long n) {
        return create(funnel, n, 0.03);
    }
    
    @VisibleForTesting
    static int optimalNumOfHashFunctions(final long n, final long n2) {
        return Math.max(1, (int)Math.round(n2 / n * Math.log(2.0)));
    }
    
    @VisibleForTesting
    static long optimalNumOfBits(final long n, double n2) {
        if (n2 == 0.0) {
            n2 = Double.MIN_VALUE;
        }
        return (long)(-n * Math.log(n2) / (Math.log(2.0) * Math.log(2.0)));
    }
    
    private Object writeReplace() {
        return new BloomFilter$SerialForm(this);
    }
    
    public void writeTo(final OutputStream outputStream) {
        final DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.data.length);
        final long[] data = this.bits.data;
        for (int length = data.length, i = 0; i < length; ++i) {
            dataOutputStream.writeLong(data[i]);
        }
    }
    
    @CheckReturnValue
    public static BloomFilter readFrom(final InputStream inputStream, final Funnel funnel) {
        Preconditions.checkNotNull(inputStream, (Object)"InputStream");
        Preconditions.checkNotNull(funnel, (Object)"Funnel");
        int byte1 = -1;
        int int1 = -1;
        int int2 = -1;
        try {
            final DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte1 = dataInputStream.readByte();
            int1 = UnsignedBytes.toInt(dataInputStream.readByte());
            int2 = dataInputStream.readInt();
            final BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[byte1];
            final long[] array = new long[int2];
            for (int i = 0; i < array.length; ++i) {
                array[i] = dataInputStream.readLong();
            }
            return new BloomFilter(new BloomFilterStrategies$BitArray(array), int1, funnel, bloomFilterStrategies);
        }
        catch (RuntimeException ex2) {
            final String value = String.valueOf("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
            final IOException ex = new IOException(new StringBuilder(65 + String.valueOf(value).length()).append(value).append(byte1).append(" numHashFunctions: ").append(int1).append(" dataLength: ").append(int2).toString());
            ex.initCause(ex2);
            throw ex;
        }
    }
}
