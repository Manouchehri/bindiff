package com.google.common.cache;

import com.google.common.base.*;
import java.util.concurrent.*;
import java.io.*;

class LocalCache$ManualSerializationProxy extends ForwardingCache implements Serializable
{
    private static final long serialVersionUID = 1L;
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
    
    LocalCache$ManualSerializationProxy(final LocalCache localCache) {
        this(localCache.keyStrength, localCache.valueStrength, localCache.keyEquivalence, localCache.valueEquivalence, localCache.expireAfterWriteNanos, localCache.expireAfterAccessNanos, localCache.maxWeight, localCache.weigher, localCache.concurrencyLevel, localCache.removalListener, localCache.ticker, localCache.defaultLoader);
    }
    
    private LocalCache$ManualSerializationProxy(final LocalCache$Strength keyStrength, final LocalCache$Strength valueStrength, final Equivalence keyEquivalence, final Equivalence valueEquivalence, final long expireAfterWriteNanos, final long expireAfterAccessNanos, final long maxWeight, final Weigher weigher, final int concurrencyLevel, final RemovalListener removalListener, final Ticker ticker, final CacheLoader loader) {
        this.keyStrength = keyStrength;
        this.valueStrength = valueStrength;
        this.keyEquivalence = keyEquivalence;
        this.valueEquivalence = valueEquivalence;
        this.expireAfterWriteNanos = expireAfterWriteNanos;
        this.expireAfterAccessNanos = expireAfterAccessNanos;
        this.maxWeight = maxWeight;
        this.weigher = weigher;
        this.concurrencyLevel = concurrencyLevel;
        this.removalListener = removalListener;
        this.ticker = ((ticker == Ticker.systemTicker() || ticker == CacheBuilder.NULL_TICKER) ? null : ticker);
        this.loader = loader;
    }
    
    CacheBuilder recreateCacheBuilder() {
        final CacheBuilder removalListener = CacheBuilder.newBuilder().setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).valueEquivalence(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel).removalListener(this.removalListener);
        removalListener.strictParsing = false;
        if (this.expireAfterWriteNanos > 0L) {
            removalListener.expireAfterWrite(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
        }
        if (this.expireAfterAccessNanos > 0L) {
            removalListener.expireAfterAccess(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
        }
        if (this.weigher != CacheBuilder$OneWeigher.INSTANCE) {
            removalListener.weigher(this.weigher);
            if (this.maxWeight != -1L) {
                removalListener.maximumWeight(this.maxWeight);
            }
        }
        else if (this.maxWeight != -1L) {
            removalListener.maximumSize(this.maxWeight);
        }
        if (this.ticker != null) {
            removalListener.ticker(this.ticker);
        }
        return removalListener;
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.delegate = this.recreateCacheBuilder().build();
    }
    
    private Object readResolve() {
        return this.delegate;
    }
    
    @Override
    protected Cache delegate() {
        return this.delegate;
    }
}
