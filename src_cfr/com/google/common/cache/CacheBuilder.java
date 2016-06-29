/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.cache;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AsyncCacheLoader;
import com.google.common.cache.AsyncLoadingCache;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder$1;
import com.google.common.cache.CacheBuilder$2;
import com.google.common.cache.CacheBuilder$3;
import com.google.common.cache.CacheBuilder$NullListener;
import com.google.common.cache.CacheBuilder$OneWeigher;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.LocalCache$LocalLoadingCache;
import com.google.common.cache.LocalCache$LocalManualCache;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.ShimAsyncCache;
import com.google.common.cache.Weigher;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;

@GwtCompatible(emulated=1)
public final class CacheBuilder {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_REFRESH_NANOS = 0;
    static final Supplier NULL_STATS_COUNTER = Suppliers.ofInstance(new CacheBuilder$1());
    static final CacheStats EMPTY_STATS = new CacheStats(0, 0, 0, 0, 0, 0);
    static final Supplier CACHE_STATS_COUNTER = new CacheBuilder$2();
    static final Ticker NULL_TICKER = new CacheBuilder$3();
    private static final Logger logger = Logger.getLogger(CacheBuilder.class.getName());
    static final int UNSET_INT = -1;
    boolean strictParsing = true;
    int initialCapacity = -1;
    int concurrencyLevel = -1;
    long maximumSize = -1;
    long maximumWeight = -1;
    Weigher weigher;
    LocalCache$Strength keyStrength;
    LocalCache$Strength valueStrength;
    long expireAfterWriteNanos = -1;
    long expireAfterAccessNanos = -1;
    long refreshNanos = -1;
    Equivalence keyEquivalence;
    Equivalence valueEquivalence;
    RemovalListener removalListener;
    Ticker ticker;
    Supplier statsCounterSupplier = NULL_STATS_COUNTER;

    CacheBuilder() {
    }

    public static CacheBuilder newBuilder() {
        return new CacheBuilder();
    }

    @GwtIncompatible(value="To be supported")
    public static CacheBuilder from(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.toCacheBuilder().lenientParsing();
    }

    @GwtIncompatible(value="To be supported")
    public static CacheBuilder from(String string) {
        return CacheBuilder.from(CacheBuilderSpec.parse(string));
    }

    @GwtIncompatible(value="To be supported")
    CacheBuilder lenientParsing() {
        this.strictParsing = false;
        return this;
    }

    @GwtIncompatible(value="To be supported")
    CacheBuilder keyEquivalence(Equivalence equivalence) {
        Preconditions.checkState(this.keyEquivalence == null, "key equivalence was already set to %s", this.keyEquivalence);
        this.keyEquivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
        return this;
    }

    Equivalence getKeyEquivalence() {
        return (Equivalence)MoreObjects.firstNonNull(this.keyEquivalence, this.getKeyStrength().defaultEquivalence());
    }

    @GwtIncompatible(value="To be supported")
    CacheBuilder valueEquivalence(Equivalence equivalence) {
        Preconditions.checkState(this.valueEquivalence == null, "value equivalence was already set to %s", this.valueEquivalence);
        this.valueEquivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
        return this;
    }

    Equivalence getValueEquivalence() {
        return (Equivalence)MoreObjects.firstNonNull(this.valueEquivalence, this.getValueStrength().defaultEquivalence());
    }

    public CacheBuilder initialCapacity(int n2) {
        Preconditions.checkState(this.initialCapacity == -1, "initial capacity was already set to %s", this.initialCapacity);
        Preconditions.checkArgument(n2 >= 0);
        this.initialCapacity = n2;
        return this;
    }

    int getInitialCapacity() {
        if (this.initialCapacity == -1) {
            return 16;
        }
        int n2 = this.initialCapacity;
        return n2;
    }

    public CacheBuilder concurrencyLevel(int n2) {
        Preconditions.checkState(this.concurrencyLevel == -1, "concurrency level was already set to %s", this.concurrencyLevel);
        Preconditions.checkArgument(n2 > 0);
        this.concurrencyLevel = n2;
        return this;
    }

    int getConcurrencyLevel() {
        if (this.concurrencyLevel == -1) {
            return 4;
        }
        int n2 = this.concurrencyLevel;
        return n2;
    }

    public CacheBuilder maximumSize(long l2) {
        Preconditions.checkState(this.maximumSize == -1, "maximum size was already set to %s", this.maximumSize);
        Preconditions.checkState(this.maximumWeight == -1, "maximum weight was already set to %s", this.maximumWeight);
        Preconditions.checkState(this.weigher == null, "maximum size can not be combined with weigher");
        Preconditions.checkArgument(l2 >= 0, "maximum size must not be negative");
        this.maximumSize = l2;
        return this;
    }

    @GwtIncompatible(value="To be supported")
    public CacheBuilder maximumWeight(long l2) {
        Preconditions.checkState(this.maximumWeight == -1, "maximum weight was already set to %s", this.maximumWeight);
        Preconditions.checkState(this.maximumSize == -1, "maximum size was already set to %s", this.maximumSize);
        this.maximumWeight = l2;
        Preconditions.checkArgument(l2 >= 0, "maximum weight must not be negative");
        return this;
    }

    @GwtIncompatible(value="To be supported")
    public CacheBuilder weigher(Weigher weigher) {
        Preconditions.checkState(this.weigher == null);
        if (this.strictParsing) {
            Preconditions.checkState(this.maximumSize == -1, "weigher can not be combined with maximum size", this.maximumSize);
        }
        CacheBuilder cacheBuilder = this;
        cacheBuilder.weigher = (Weigher)Preconditions.checkNotNull(weigher);
        return cacheBuilder;
    }

    long getMaximumWeight() {
        long l2;
        if (this.expireAfterWriteNanos == 0) return 0;
        if (this.expireAfterAccessNanos == 0) {
            return 0;
        }
        if (this.weigher == null) {
            l2 = this.maximumSize;
            return l2;
        }
        l2 = this.maximumWeight;
        return l2;
    }

    Weigher getWeigher() {
        return (Weigher)MoreObjects.firstNonNull(this.weigher, CacheBuilder$OneWeigher.INSTANCE);
    }

    @GwtIncompatible(value="java.lang.ref.WeakReference")
    public CacheBuilder weakKeys() {
        return this.setKeyStrength(LocalCache$Strength.WEAK);
    }

    CacheBuilder setKeyStrength(LocalCache$Strength localCache$Strength) {
        Preconditions.checkState(this.keyStrength == null, "Key strength was already set to %s", new Object[]{this.keyStrength});
        this.keyStrength = (LocalCache$Strength)((Object)Preconditions.checkNotNull((Object)localCache$Strength));
        return this;
    }

    LocalCache$Strength getKeyStrength() {
        return (LocalCache$Strength)((Object)MoreObjects.firstNonNull((Object)this.keyStrength, (Object)LocalCache$Strength.STRONG));
    }

    @GwtIncompatible(value="java.lang.ref.WeakReference")
    public CacheBuilder weakValues() {
        return this.setValueStrength(LocalCache$Strength.WEAK);
    }

    @GwtIncompatible(value="java.lang.ref.SoftReference")
    public CacheBuilder softValues() {
        return this.setValueStrength(LocalCache$Strength.SOFT);
    }

    CacheBuilder setValueStrength(LocalCache$Strength localCache$Strength) {
        Preconditions.checkState(this.valueStrength == null, "Value strength was already set to %s", new Object[]{this.valueStrength});
        this.valueStrength = (LocalCache$Strength)((Object)Preconditions.checkNotNull((Object)localCache$Strength));
        return this;
    }

    LocalCache$Strength getValueStrength() {
        return (LocalCache$Strength)((Object)MoreObjects.firstNonNull((Object)this.valueStrength, (Object)LocalCache$Strength.STRONG));
    }

    public CacheBuilder expireAfterWrite(long l2, TimeUnit timeUnit) {
        Preconditions.checkState(this.expireAfterWriteNanos == -1, "expireAfterWrite was already set to %s ns", this.expireAfterWriteNanos);
        Preconditions.checkArgument(l2 >= 0, "duration cannot be negative: %s %s", new Object[]{l2, timeUnit});
        this.expireAfterWriteNanos = timeUnit.toNanos(l2);
        return this;
    }

    long getExpireAfterWriteNanos() {
        if (this.expireAfterWriteNanos == -1) {
            return 0;
        }
        long l2 = this.expireAfterWriteNanos;
        return l2;
    }

    public CacheBuilder expireAfterAccess(long l2, TimeUnit timeUnit) {
        Preconditions.checkState(this.expireAfterAccessNanos == -1, "expireAfterAccess was already set to %s ns", this.expireAfterAccessNanos);
        Preconditions.checkArgument(l2 >= 0, "duration cannot be negative: %s %s", new Object[]{l2, timeUnit});
        this.expireAfterAccessNanos = timeUnit.toNanos(l2);
        return this;
    }

    long getExpireAfterAccessNanos() {
        if (this.expireAfterAccessNanos == -1) {
            return 0;
        }
        long l2 = this.expireAfterAccessNanos;
        return l2;
    }

    @GwtIncompatible(value="To be supported (synchronously).")
    public CacheBuilder refreshAfterWrite(long l2, TimeUnit timeUnit) {
        Preconditions.checkNotNull((Object)timeUnit);
        Preconditions.checkState(this.refreshNanos == -1, "refresh was already set to %s ns", this.refreshNanos);
        Preconditions.checkArgument(l2 > 0, "duration must be positive: %s %s", new Object[]{l2, timeUnit});
        this.refreshNanos = timeUnit.toNanos(l2);
        return this;
    }

    long getRefreshNanos() {
        if (this.refreshNanos == -1) {
            return 0;
        }
        long l2 = this.refreshNanos;
        return l2;
    }

    public CacheBuilder ticker(Ticker ticker) {
        Preconditions.checkState(this.ticker == null);
        this.ticker = (Ticker)Preconditions.checkNotNull(ticker);
        return this;
    }

    Ticker getTicker(boolean bl2) {
        Ticker ticker;
        if (this.ticker != null) {
            return this.ticker;
        }
        if (bl2) {
            ticker = Ticker.systemTicker();
            return ticker;
        }
        ticker = NULL_TICKER;
        return ticker;
    }

    @CheckReturnValue
    public CacheBuilder removalListener(RemovalListener removalListener) {
        Preconditions.checkState(this.removalListener == null);
        CacheBuilder cacheBuilder = this;
        cacheBuilder.removalListener = (RemovalListener)Preconditions.checkNotNull(removalListener);
        return cacheBuilder;
    }

    RemovalListener getRemovalListener() {
        return (RemovalListener)MoreObjects.firstNonNull(this.removalListener, CacheBuilder$NullListener.INSTANCE);
    }

    public CacheBuilder recordStats() {
        this.statsCounterSupplier = CACHE_STATS_COUNTER;
        return this;
    }

    boolean isRecordingStats() {
        if (this.statsCounterSupplier != CACHE_STATS_COUNTER) return false;
        return true;
    }

    Supplier getStatsCounterSupplier() {
        return this.statsCounterSupplier;
    }

    @GoogleInternal
    @GwtIncompatible(value="Futures")
    public AsyncLoadingCache build(AsyncCacheLoader asyncCacheLoader) {
        Preconditions.checkState(this.weigher == null, "AsyncLoadingCache does not support weigher");
        Preconditions.checkState(this.maximumWeight == -1, "AsyncLoadingCache does not support maximumWeight");
        Preconditions.checkState(this.removalListener == null, "AsyncLoadingCache does not support removalListener");
        Preconditions.checkState(this.keyStrength == null || this.keyStrength == LocalCache$Strength.STRONG, "AsyncLoadingCache does not support soft or weak keys");
        Preconditions.checkState(this.valueStrength == null || this.valueStrength == LocalCache$Strength.STRONG, "AsyncLoadingCache does not support soft or weak values");
        CacheBuilder cacheBuilder = this;
        AsyncCacheLoader asyncCacheLoader2 = asyncCacheLoader;
        return ShimAsyncCache.from(cacheBuilder, asyncCacheLoader2);
    }

    public LoadingCache build(CacheLoader cacheLoader) {
        this.checkWeightWithWeigher();
        return new LocalCache$LocalLoadingCache(this, cacheLoader);
    }

    public Cache build() {
        this.checkWeightWithWeigher();
        this.checkNonLoadingCache();
        return new LocalCache$LocalManualCache(this);
    }

    private void checkNonLoadingCache() {
        Preconditions.checkState(this.refreshNanos == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void checkWeightWithWeigher() {
        if (this.weigher == null) {
            Preconditions.checkState(this.maximumWeight == -1, "maximumWeight requires weigher");
            return;
        }
        if (!this.strictParsing) {
            if (this.maximumWeight != -1) return;
            logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
            return;
        }
        Preconditions.checkState(this.maximumWeight != -1, "weigher requires maximumWeight");
    }

    public String toString() {
        long l2;
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = MoreObjects.toStringHelper(this);
        if (this.initialCapacity != -1) {
            moreObjects$ToStringHelper.add("initialCapacity", this.initialCapacity);
        }
        if (this.concurrencyLevel != -1) {
            moreObjects$ToStringHelper.add("concurrencyLevel", this.concurrencyLevel);
        }
        if (this.maximumSize != -1) {
            moreObjects$ToStringHelper.add("maximumSize", this.maximumSize);
        }
        if (this.maximumWeight != -1) {
            moreObjects$ToStringHelper.add("maximumWeight", this.maximumWeight);
        }
        if (this.expireAfterWriteNanos != -1) {
            l2 = this.expireAfterWriteNanos;
            moreObjects$ToStringHelper.add("expireAfterWrite", new StringBuilder(22).append(l2).append("ns").toString());
        }
        if (this.expireAfterAccessNanos != -1) {
            l2 = this.expireAfterAccessNanos;
            moreObjects$ToStringHelper.add("expireAfterAccess", new StringBuilder(22).append(l2).append("ns").toString());
        }
        if (this.keyStrength != null) {
            moreObjects$ToStringHelper.add("keyStrength", Ascii.toLowerCase(this.keyStrength.toString()));
        }
        if (this.valueStrength != null) {
            moreObjects$ToStringHelper.add("valueStrength", Ascii.toLowerCase(this.valueStrength.toString()));
        }
        if (this.keyEquivalence != null) {
            moreObjects$ToStringHelper.addValue("keyEquivalence");
        }
        if (this.valueEquivalence != null) {
            moreObjects$ToStringHelper.addValue("valueEquivalence");
        }
        if (this.removalListener == null) return moreObjects$ToStringHelper.toString();
        moreObjects$ToStringHelper.addValue("removalListener");
        return moreObjects$ToStringHelper.toString();
    }
}

