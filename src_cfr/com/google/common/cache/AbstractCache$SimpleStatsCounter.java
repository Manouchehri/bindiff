/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.AbstractCache$StatsCounter;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LongAddable;
import com.google.common.cache.LongAddables;

public final class AbstractCache$SimpleStatsCounter
implements AbstractCache$StatsCounter {
    private final LongAddable hitCount = LongAddables.create();
    private final LongAddable missCount = LongAddables.create();
    private final LongAddable loadSuccessCount = LongAddables.create();
    private final LongAddable loadExceptionCount = LongAddables.create();
    private final LongAddable totalLoadTime = LongAddables.create();
    private final LongAddable evictionCount = LongAddables.create();

    @Override
    public void recordHits(int n2) {
        this.hitCount.add(n2);
    }

    @Override
    public void recordMisses(int n2) {
        this.missCount.add(n2);
    }

    @Override
    public void recordLoadSuccess(long l2) {
        this.loadSuccessCount.increment();
        this.totalLoadTime.add(l2);
    }

    @Override
    public void recordLoadException(long l2) {
        this.loadExceptionCount.increment();
        this.totalLoadTime.add(l2);
    }

    @Override
    public void recordEviction() {
        this.evictionCount.increment();
    }

    @Override
    public CacheStats snapshot() {
        return new CacheStats(this.hitCount.sum(), this.missCount.sum(), this.loadSuccessCount.sum(), this.loadExceptionCount.sum(), this.totalLoadTime.sum(), this.evictionCount.sum());
    }

    public void incrementBy(AbstractCache$StatsCounter abstractCache$StatsCounter) {
        CacheStats cacheStats = abstractCache$StatsCounter.snapshot();
        this.hitCount.add(cacheStats.hitCount());
        this.missCount.add(cacheStats.missCount());
        this.loadSuccessCount.add(cacheStats.loadSuccessCount());
        this.loadExceptionCount.add(cacheStats.loadExceptionCount());
        this.totalLoadTime.add(cacheStats.totalLoadTime());
        this.evictionCount.add(cacheStats.evictionCount());
    }
}

