/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.collect.GenericMapMaker;
import com.google.common.collect.MapMaker$ComputingMapAdapter;
import com.google.common.collect.MapMaker$NullComputingConcurrentMap;
import com.google.common.collect.MapMaker$NullConcurrentMap;
import com.google.common.collect.MapMaker$RemovalCause;
import com.google.common.collect.MapMaker$RemovalListener;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$Strength;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated=1)
public final class MapMaker
extends GenericMapMaker {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    static final int UNSET_INT = -1;
    boolean useCustomMap;
    int initialCapacity = -1;
    int concurrencyLevel = -1;
    int maximumSize = -1;
    MapMakerInternalMap$Strength keyStrength;
    MapMakerInternalMap$Strength valueStrength;
    long expireAfterWriteNanos = -1;
    long expireAfterAccessNanos = -1;
    MapMaker$RemovalCause nullRemovalCause;
    Equivalence keyEquivalence;
    Ticker ticker;

    @GwtIncompatible(value="To be supported")
    @Override
    MapMaker keyEquivalence(Equivalence equivalence) {
        Preconditions.checkState(this.keyEquivalence == null, "key equivalence was already set to %s", this.keyEquivalence);
        this.keyEquivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
        this.useCustomMap = true;
        return this;
    }

    Equivalence getKeyEquivalence() {
        return (Equivalence)MoreObjects.firstNonNull(this.keyEquivalence, this.getKeyStrength().defaultEquivalence());
    }

    @Override
    public MapMaker initialCapacity(int n2) {
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

    @Deprecated
    @Override
    public MapMaker maximumSize(int n2) {
        Preconditions.checkState(this.maximumSize == -1, "maximum size was already set to %s", this.maximumSize);
        Preconditions.checkArgument(n2 >= 0, "maximum size must not be negative");
        this.maximumSize = n2;
        this.useCustomMap = true;
        if (this.maximumSize != 0) return this;
        this.nullRemovalCause = MapMaker$RemovalCause.SIZE;
        return this;
    }

    @Override
    public MapMaker concurrencyLevel(int n2) {
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

    @GwtIncompatible(value="java.lang.ref.WeakReference")
    @Override
    public MapMaker weakKeys() {
        return this.setKeyStrength(MapMakerInternalMap$Strength.WEAK);
    }

    MapMaker setKeyStrength(MapMakerInternalMap$Strength mapMakerInternalMap$Strength) {
        Preconditions.checkState(this.keyStrength == null, "Key strength was already set to %s", new Object[]{this.keyStrength});
        this.keyStrength = (MapMakerInternalMap$Strength)((Object)Preconditions.checkNotNull((Object)mapMakerInternalMap$Strength));
        Preconditions.checkArgument(this.keyStrength != MapMakerInternalMap$Strength.SOFT, "Soft keys are not supported");
        if (mapMakerInternalMap$Strength == MapMakerInternalMap$Strength.STRONG) return this;
        this.useCustomMap = true;
        return this;
    }

    MapMakerInternalMap$Strength getKeyStrength() {
        return (MapMakerInternalMap$Strength)((Object)MoreObjects.firstNonNull((Object)this.keyStrength, (Object)MapMakerInternalMap$Strength.STRONG));
    }

    @GwtIncompatible(value="java.lang.ref.WeakReference")
    @Override
    public MapMaker weakValues() {
        return this.setValueStrength(MapMakerInternalMap$Strength.WEAK);
    }

    @Deprecated
    @GwtIncompatible(value="java.lang.ref.SoftReference")
    @Override
    public MapMaker softValues() {
        return this.setValueStrength(MapMakerInternalMap$Strength.SOFT);
    }

    MapMaker setValueStrength(MapMakerInternalMap$Strength mapMakerInternalMap$Strength) {
        Preconditions.checkState(this.valueStrength == null, "Value strength was already set to %s", new Object[]{this.valueStrength});
        this.valueStrength = (MapMakerInternalMap$Strength)((Object)Preconditions.checkNotNull((Object)mapMakerInternalMap$Strength));
        if (mapMakerInternalMap$Strength == MapMakerInternalMap$Strength.STRONG) return this;
        this.useCustomMap = true;
        return this;
    }

    MapMakerInternalMap$Strength getValueStrength() {
        return (MapMakerInternalMap$Strength)((Object)MoreObjects.firstNonNull((Object)this.valueStrength, (Object)MapMakerInternalMap$Strength.STRONG));
    }

    @Deprecated
    @Override
    public MapMaker expireAfterWrite(long l2, TimeUnit timeUnit) {
        this.checkExpiration(l2, timeUnit);
        this.expireAfterWriteNanos = timeUnit.toNanos(l2);
        if (l2 == 0 && this.nullRemovalCause == null) {
            this.nullRemovalCause = MapMaker$RemovalCause.EXPIRED;
        }
        this.useCustomMap = true;
        return this;
    }

    private void checkExpiration(long l2, TimeUnit timeUnit) {
        Preconditions.checkState(this.expireAfterWriteNanos == -1, "expireAfterWrite was already set to %s ns", this.expireAfterWriteNanos);
        Preconditions.checkState(this.expireAfterAccessNanos == -1, "expireAfterAccess was already set to %s ns", this.expireAfterAccessNanos);
        Preconditions.checkArgument(l2 >= 0, "duration cannot be negative: %s %s", new Object[]{l2, timeUnit});
    }

    long getExpireAfterWriteNanos() {
        if (this.expireAfterWriteNanos == -1) {
            return 0;
        }
        long l2 = this.expireAfterWriteNanos;
        return l2;
    }

    @Deprecated
    @GwtIncompatible(value="To be supported")
    @Override
    public MapMaker expireAfterAccess(long l2, TimeUnit timeUnit) {
        this.checkExpiration(l2, timeUnit);
        this.expireAfterAccessNanos = timeUnit.toNanos(l2);
        if (l2 == 0 && this.nullRemovalCause == null) {
            this.nullRemovalCause = MapMaker$RemovalCause.EXPIRED;
        }
        this.useCustomMap = true;
        return this;
    }

    long getExpireAfterAccessNanos() {
        if (this.expireAfterAccessNanos == -1) {
            return 0;
        }
        long l2 = this.expireAfterAccessNanos;
        return l2;
    }

    @Deprecated
    @GoogleInternal
    @GwtIncompatible(value="To be supported")
    @Override
    public MapMaker ticker(Ticker ticker) {
        Preconditions.checkState(this.ticker == null);
        this.ticker = (Ticker)Preconditions.checkNotNull(ticker);
        return this;
    }

    Ticker getTicker() {
        return (Ticker)MoreObjects.firstNonNull(this.ticker, Ticker.systemTicker());
    }

    @Deprecated
    @GwtIncompatible(value="To be supported")
    public GenericMapMaker removalListener(MapMaker$RemovalListener mapMaker$RemovalListener) {
        Preconditions.checkState(this.removalListener == null);
        MapMaker mapMaker = this;
        mapMaker.removalListener = (MapMaker$RemovalListener)Preconditions.checkNotNull(mapMaker$RemovalListener);
        this.useCustomMap = true;
        return mapMaker;
    }

    @Override
    public ConcurrentMap makeMap() {
        MapMakerInternalMap mapMakerInternalMap /* !! */ ;
        if (!this.useCustomMap) {
            return new ConcurrentHashMap(this.getInitialCapacity(), 0.75f, this.getConcurrencyLevel());
        }
        if (this.nullRemovalCause == null) {
            mapMakerInternalMap /* !! */  = new MapMakerInternalMap(this);
            return mapMakerInternalMap /* !! */ ;
        }
        mapMakerInternalMap /* !! */  = new MapMaker$NullConcurrentMap(this);
        return mapMakerInternalMap /* !! */ ;
    }

    @GwtIncompatible(value="MapMakerInternalMap")
    @Override
    MapMakerInternalMap makeCustomMap() {
        return new MapMakerInternalMap(this);
    }

    @Deprecated
    @Override
    public ConcurrentMap makeComputingMap(Function function) {
        MapMaker$ComputingMapAdapter mapMaker$ComputingMapAdapter /* !! */ ;
        if (this.nullRemovalCause == null) {
            mapMaker$ComputingMapAdapter /* !! */  = new MapMaker$ComputingMapAdapter(this, function);
            return mapMaker$ComputingMapAdapter /* !! */ ;
        }
        mapMaker$ComputingMapAdapter /* !! */  = new MapMaker$NullComputingConcurrentMap(this, function);
        return mapMaker$ComputingMapAdapter /* !! */ ;
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
        if (this.removalListener == null) return moreObjects$ToStringHelper.toString();
        moreObjects$ToStringHelper.addValue("removalListener");
        return moreObjects$ToStringHelper.toString();
    }
}

