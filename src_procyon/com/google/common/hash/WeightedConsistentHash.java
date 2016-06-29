package com.google.common.hash;

import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.primitives.*;
import com.google.common.annotations.*;

@CheckReturnValue
@GoogleInternal
public final class WeightedConsistentHash
{
    private final HashFunction hashFunction;
    private final Funnel bucketFunnel;
    private final Funnel inputFunnel;
    private final Map bucketWeights;
    
    private WeightedConsistentHash(final HashFunction hashFunction, final Funnel funnel, final Funnel funnel2) {
        this.bucketWeights = new HashMap();
        this.hashFunction = (HashFunction)Preconditions.checkNotNull(hashFunction);
        this.bucketFunnel = (Funnel)Preconditions.checkNotNull(funnel);
        this.inputFunnel = (Funnel)Preconditions.checkNotNull(funnel2);
    }
    
    public static WeightedConsistentHash create(final Funnel funnel, final Funnel funnel2) {
        return new WeightedConsistentHash(Hashing.fingerprint2011(), funnel, funnel2);
    }
    
    public void setBucketWeight(final Object o, final double n) {
        Preconditions.checkNotNull(o);
        Preconditions.checkArgument(n >= 0.0, "Weight (%s) must be non-negative.", n);
        if (n == 0.0) {
            this.bucketWeights.remove(o);
        }
        else {
            this.bucketWeights.put(o, n);
        }
    }
    
    public Object hash(final Object o) {
        Preconditions.checkNotNull(o);
        Preconditions.checkState(!this.bucketWeights.isEmpty(), (Object)"No positive weight.");
        Object key = null;
        double n = Double.NEGATIVE_INFINITY;
        for (final Map.Entry<Object, V> entry : this.bucketWeights.entrySet()) {
            final double n2 = Math.log(this.affinity(o, entry.getKey())) / (double)entry.getValue();
            if (n2 > n) {
                n = n2;
                key = entry.getKey();
            }
        }
        return key;
    }
    
    @VisibleForTesting
    double affinity(final Object o, final Object o2) {
        return UnsignedLong.fromLongBits(this.hashFunction.newHasher().putObject(o, this.inputFunnel).putObject(o2, this.bucketFunnel).hash().asLong()).doubleValue() / UnsignedLong.MAX_VALUE.doubleValue();
    }
}
