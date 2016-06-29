/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Ticker;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheBuilder$OneWeigher;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.ForwardingCache;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.Weigher;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

class LocalCache$ManualSerializationProxy
extends ForwardingCache
implements Serializable {
    private static final long serialVersionUID = 1;
    final LocalCache$Strength keyStrength;
    final LocalCache$Strength valueStrength;
    final Equivalence keyEquivalence;
    final Equivalence valueEquivalence;
    final long expireAfterWriteNanos;
    final long expireAfterAccessNanos;
    final long maxWeight;
    final Weigher weigher;
    final int concurrencyLevel;
    final RemovalListener removalListener;
    final Ticker ticker;
    final CacheLoader loader;
    transient Cache delegate;

    LocalCache$ManualSerializationProxy(LocalCache localCache) {
        this(localCache.keyStrength, localCache.valueStrength, localCache.keyEquivalence, localCache.valueEquivalence, localCache.expireAfterWriteNanos, localCache.expireAfterAccessNanos, localCache.maxWeight, localCache.weigher, localCache.concurrencyLevel, localCache.removalListener, localCache.ticker, localCache.defaultLoader);
    }

    private LocalCache$ManualSerializationProxy(LocalCache$Strength localCache$Strength, LocalCache$Strength localCache$Strength2, Equivalence equivalence, Equivalence equivalence2, long l2, long l3, long l4, Weigher weigher, int n2, RemovalListener removalListener, Ticker ticker, CacheLoader cacheLoader) {
        this.keyStrength = localCache$Strength;
        this.valueStrength = localCache$Strength2;
        this.keyEquivalence = equivalence;
        this.valueEquivalence = equivalence2;
        this.expireAfterWriteNanos = l2;
        this.expireAfterAccessNanos = l3;
        this.maxWeight = l4;
        this.weigher = weigher;
        this.concurrencyLevel = n2;
        this.removalListener = removalListener;
        this.ticker = ticker == Ticker.systemTicker() || ticker == CacheBuilder.NULL_TICKER ? null : ticker;
        this.loader = cacheLoader;
    }

    CacheBuilder recreateCacheBuilder() {
        CacheBuilder cacheBuilder = CacheBuilder.newBuilder().setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).valueEquivalence(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel).removalListener(this.removalListener);
        cacheBuilder.strictParsing = false;
        if (this.expireAfterWriteNanos > 0) {
            cacheBuilder.expireAfterWrite(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
        }
        if (this.expireAfterAccessNanos > 0) {
            cacheBuilder.expireAfterAccess(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
        }
        if (this.weigher != CacheBuilder$OneWeigher.INSTANCE) {
            cacheBuilder.weigher(this.weigher);
            if (this.maxWeight != -1) {
                cacheBuilder.maximumWeight(this.maxWeight);
            }
        } else if (this.maxWeight != -1) {
            cacheBuilder.maximumSize(this.maxWeight);
        }
        if (this.ticker == null) return cacheBuilder;
        cacheBuilder.ticker(this.ticker);
        return cacheBuilder;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        CacheBuilder cacheBuilder = this.recreateCacheBuilder();
        this.delegate = cacheBuilder.build();
    }

    private Object readResolve() {
        return this.delegate;
    }

    @Override
    protected Cache delegate() {
        return this.delegate;
    }
}

