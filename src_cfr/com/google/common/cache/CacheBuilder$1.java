/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.AbstractCache$StatsCounter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheStats;

final class CacheBuilder$1
implements AbstractCache$StatsCounter {
    CacheBuilder$1() {
    }

    @Override
    public void recordHits(int n2) {
    }

    @Override
    public void recordMisses(int n2) {
    }

    @Override
    public void recordLoadSuccess(long l2) {
    }

    @Override
    public void recordLoadException(long l2) {
    }

    @Override
    public void recordEviction() {
    }

    @Override
    public CacheStats snapshot() {
        return CacheBuilder.EMPTY_STATS;
    }
}

