/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.CacheStats;

public interface AbstractCache$StatsCounter {
    public void recordHits(int var1);

    public void recordMisses(int var1);

    public void recordLoadSuccess(long var1);

    public void recordLoadException(long var1);

    public void recordEviction();

    public CacheStats snapshot();
}

