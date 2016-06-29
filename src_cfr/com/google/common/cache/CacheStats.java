/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@GwtCompatible
public final class CacheStats {
    private final long hitCount;
    private final long missCount;
    private final long loadSuccessCount;
    private final long loadExceptionCount;
    private final long totalLoadTime;
    private final long evictionCount;

    public CacheStats(long l2, long l3, long l4, long l5, long l6, long l7) {
        Preconditions.checkArgument(l2 >= 0);
        Preconditions.checkArgument(l3 >= 0);
        Preconditions.checkArgument(l4 >= 0);
        Preconditions.checkArgument(l5 >= 0);
        Preconditions.checkArgument(l6 >= 0);
        Preconditions.checkArgument(l7 >= 0);
        this.hitCount = l2;
        this.missCount = l3;
        this.loadSuccessCount = l4;
        this.loadExceptionCount = l5;
        this.totalLoadTime = l6;
        this.evictionCount = l7;
    }

    public long requestCount() {
        return this.hitCount + this.missCount;
    }

    public long hitCount() {
        return this.hitCount;
    }

    public double hitRate() {
        long l2 = this.requestCount();
        if (l2 == 0) {
            return 1.0;
        }
        double d2 = (double)this.hitCount / (double)l2;
        return d2;
    }

    public long missCount() {
        return this.missCount;
    }

    public double missRate() {
        long l2 = this.requestCount();
        if (l2 == 0) {
            return 0.0;
        }
        double d2 = (double)this.missCount / (double)l2;
        return d2;
    }

    public long loadCount() {
        return this.loadSuccessCount + this.loadExceptionCount;
    }

    public long loadSuccessCount() {
        return this.loadSuccessCount;
    }

    public long loadExceptionCount() {
        return this.loadExceptionCount;
    }

    public double loadExceptionRate() {
        long l2 = this.loadSuccessCount + this.loadExceptionCount;
        if (l2 == 0) {
            return 0.0;
        }
        double d2 = (double)this.loadExceptionCount / (double)l2;
        return d2;
    }

    public long totalLoadTime() {
        return this.totalLoadTime;
    }

    public double averageLoadPenalty() {
        long l2 = this.loadSuccessCount + this.loadExceptionCount;
        if (l2 == 0) {
            return 0.0;
        }
        double d2 = (double)this.totalLoadTime / (double)l2;
        return d2;
    }

    public long evictionCount() {
        return this.evictionCount;
    }

    public CacheStats minus(CacheStats cacheStats) {
        return new CacheStats(Math.max(0, this.hitCount - cacheStats.hitCount), Math.max(0, this.missCount - cacheStats.missCount), Math.max(0, this.loadSuccessCount - cacheStats.loadSuccessCount), Math.max(0, this.loadExceptionCount - cacheStats.loadExceptionCount), Math.max(0, this.totalLoadTime - cacheStats.totalLoadTime), Math.max(0, this.evictionCount - cacheStats.evictionCount));
    }

    public CacheStats plus(CacheStats cacheStats) {
        return new CacheStats(this.hitCount + cacheStats.hitCount, this.missCount + cacheStats.missCount, this.loadSuccessCount + cacheStats.loadSuccessCount, this.loadExceptionCount + cacheStats.loadExceptionCount, this.totalLoadTime + cacheStats.totalLoadTime, this.evictionCount + cacheStats.evictionCount);
    }

    public int hashCode() {
        return Objects.hashCode(this.hitCount, this.missCount, this.loadSuccessCount, this.loadExceptionCount, this.totalLoadTime, this.evictionCount);
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof CacheStats)) return false;
        CacheStats cacheStats = (CacheStats)object;
        if (this.hitCount != cacheStats.hitCount) return false;
        if (this.missCount != cacheStats.missCount) return false;
        if (this.loadSuccessCount != cacheStats.loadSuccessCount) return false;
        if (this.loadExceptionCount != cacheStats.loadExceptionCount) return false;
        if (this.totalLoadTime != cacheStats.totalLoadTime) return false;
        if (this.evictionCount != cacheStats.evictionCount) return false;
        return true;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("hitCount", this.hitCount).add("missCount", this.missCount).add("loadSuccessCount", this.loadSuccessCount).add("loadExceptionCount", this.loadExceptionCount).add("totalLoadTime", this.totalLoadTime).add("evictionCount", this.evictionCount).toString();
    }
}

