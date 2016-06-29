/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.primitives.UnsignedLong;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GoogleInternal
public final class WeightedConsistentHash {
    private final HashFunction hashFunction;
    private final Funnel bucketFunnel;
    private final Funnel inputFunnel;
    private final Map bucketWeights = new HashMap();

    private WeightedConsistentHash(HashFunction hashFunction, Funnel funnel, Funnel funnel2) {
        this.hashFunction = (HashFunction)Preconditions.checkNotNull(hashFunction);
        this.bucketFunnel = (Funnel)Preconditions.checkNotNull(funnel);
        this.inputFunnel = (Funnel)Preconditions.checkNotNull(funnel2);
    }

    public static WeightedConsistentHash create(Funnel funnel, Funnel funnel2) {
        return new WeightedConsistentHash(Hashing.fingerprint2011(), funnel, funnel2);
    }

    public void setBucketWeight(Object object, double d2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkArgument(d2 >= 0.0, "Weight (%s) must be non-negative.", d2);
        if (d2 == 0.0) {
            this.bucketWeights.remove(object);
            return;
        }
        this.bucketWeights.put(object, d2);
    }

    public Object hash(Object object) {
        Preconditions.checkNotNull(object);
        Preconditions.checkState(!this.bucketWeights.isEmpty(), "No positive weight.");
        Object var2_2 = null;
        double d2 = Double.NEGATIVE_INFINITY;
        Iterator iterator = this.bucketWeights.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            double d3 = Math.log(this.affinity(object, entry.getKey())) / (Double)entry.getValue();
            if (d3 <= d2) continue;
            d2 = d3;
            var2_2 = entry.getKey();
        }
        return var2_2;
    }

    @VisibleForTesting
    double affinity(Object object, Object object2) {
        long l2 = this.hashFunction.newHasher().putObject(object, this.inputFunnel).putObject(object2, this.bucketFunnel).hash().asLong();
        return UnsignedLong.fromLongBits(l2).doubleValue() / UnsignedLong.MAX_VALUE.doubleValue();
    }
}

