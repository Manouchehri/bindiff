package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.concurrent.*;
import com.google.common.base.*;

@GwtCompatible(emulated = true)
public final class MapMaker extends GenericMapMaker
{
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    static final int UNSET_INT = -1;
    boolean useCustomMap;
    int initialCapacity;
    int concurrencyLevel;
    int maximumSize;
    MapMakerInternalMap$Strength keyStrength;
    MapMakerInternalMap$Strength valueStrength;
    long expireAfterWriteNanos;
    long expireAfterAccessNanos;
    MapMaker$RemovalCause nullRemovalCause;
    Equivalence keyEquivalence;
    Ticker ticker;
    
    public MapMaker() {
        this.initialCapacity = -1;
        this.concurrencyLevel = -1;
        this.maximumSize = -1;
        this.expireAfterWriteNanos = -1L;
        this.expireAfterAccessNanos = -1L;
    }
    
    @GwtIncompatible("To be supported")
    @Override
    MapMaker keyEquivalence(final Equivalence equivalence) {
        Preconditions.checkState(this.keyEquivalence == null, "key equivalence was already set to %s", this.keyEquivalence);
        this.keyEquivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
        this.useCustomMap = true;
        return this;
    }
    
    Equivalence getKeyEquivalence() {
        return (Equivalence)MoreObjects.firstNonNull(this.keyEquivalence, this.getKeyStrength().defaultEquivalence());
    }
    
    @Override
    public MapMaker initialCapacity(final int initialCapacity) {
        Preconditions.checkState(this.initialCapacity == -1, "initial capacity was already set to %s", this.initialCapacity);
        Preconditions.checkArgument(initialCapacity >= 0);
        this.initialCapacity = initialCapacity;
        return this;
    }
    
    int getInitialCapacity() {
        return (this.initialCapacity == -1) ? 16 : this.initialCapacity;
    }
    
    @Deprecated
    @Override
    public MapMaker maximumSize(final int maximumSize) {
        Preconditions.checkState(this.maximumSize == -1, "maximum size was already set to %s", this.maximumSize);
        Preconditions.checkArgument(maximumSize >= 0, (Object)"maximum size must not be negative");
        this.maximumSize = maximumSize;
        this.useCustomMap = true;
        if (this.maximumSize == 0) {
            this.nullRemovalCause = MapMaker$RemovalCause.SIZE;
        }
        return this;
    }
    
    @Override
    public MapMaker concurrencyLevel(final int concurrencyLevel) {
        Preconditions.checkState(this.concurrencyLevel == -1, "concurrency level was already set to %s", this.concurrencyLevel);
        Preconditions.checkArgument(concurrencyLevel > 0);
        this.concurrencyLevel = concurrencyLevel;
        return this;
    }
    
    int getConcurrencyLevel() {
        return (this.concurrencyLevel == -1) ? 4 : this.concurrencyLevel;
    }
    
    @GwtIncompatible("java.lang.ref.WeakReference")
    @Override
    public MapMaker weakKeys() {
        return this.setKeyStrength(MapMakerInternalMap$Strength.WEAK);
    }
    
    MapMaker setKeyStrength(final MapMakerInternalMap$Strength mapMakerInternalMap$Strength) {
        Preconditions.checkState(this.keyStrength == null, "Key strength was already set to %s", this.keyStrength);
        this.keyStrength = (MapMakerInternalMap$Strength)Preconditions.checkNotNull(mapMakerInternalMap$Strength);
        Preconditions.checkArgument(this.keyStrength != MapMakerInternalMap$Strength.SOFT, (Object)"Soft keys are not supported");
        if (mapMakerInternalMap$Strength != MapMakerInternalMap$Strength.STRONG) {
            this.useCustomMap = true;
        }
        return this;
    }
    
    MapMakerInternalMap$Strength getKeyStrength() {
        return (MapMakerInternalMap$Strength)MoreObjects.firstNonNull(this.keyStrength, MapMakerInternalMap$Strength.STRONG);
    }
    
    @GwtIncompatible("java.lang.ref.WeakReference")
    @Override
    public MapMaker weakValues() {
        return this.setValueStrength(MapMakerInternalMap$Strength.WEAK);
    }
    
    @Deprecated
    @GwtIncompatible("java.lang.ref.SoftReference")
    @Override
    public MapMaker softValues() {
        return this.setValueStrength(MapMakerInternalMap$Strength.SOFT);
    }
    
    MapMaker setValueStrength(final MapMakerInternalMap$Strength mapMakerInternalMap$Strength) {
        Preconditions.checkState(this.valueStrength == null, "Value strength was already set to %s", this.valueStrength);
        this.valueStrength = (MapMakerInternalMap$Strength)Preconditions.checkNotNull(mapMakerInternalMap$Strength);
        if (mapMakerInternalMap$Strength != MapMakerInternalMap$Strength.STRONG) {
            this.useCustomMap = true;
        }
        return this;
    }
    
    MapMakerInternalMap$Strength getValueStrength() {
        return (MapMakerInternalMap$Strength)MoreObjects.firstNonNull(this.valueStrength, MapMakerInternalMap$Strength.STRONG);
    }
    
    @Deprecated
    @Override
    public MapMaker expireAfterWrite(final long n, final TimeUnit timeUnit) {
        this.checkExpiration(n, timeUnit);
        this.expireAfterWriteNanos = timeUnit.toNanos(n);
        if (n == 0L && this.nullRemovalCause == null) {
            this.nullRemovalCause = MapMaker$RemovalCause.EXPIRED;
        }
        this.useCustomMap = true;
        return this;
    }
    
    private void checkExpiration(final long n, final TimeUnit timeUnit) {
        Preconditions.checkState(this.expireAfterWriteNanos == -1L, "expireAfterWrite was already set to %s ns", this.expireAfterWriteNanos);
        Preconditions.checkState(this.expireAfterAccessNanos == -1L, "expireAfterAccess was already set to %s ns", this.expireAfterAccessNanos);
        Preconditions.checkArgument(n >= 0L, "duration cannot be negative: %s %s", n, timeUnit);
    }
    
    long getExpireAfterWriteNanos() {
        return (this.expireAfterWriteNanos == -1L) ? 0L : this.expireAfterWriteNanos;
    }
    
    @Deprecated
    @GwtIncompatible("To be supported")
    @Override
    public MapMaker expireAfterAccess(final long n, final TimeUnit timeUnit) {
        this.checkExpiration(n, timeUnit);
        this.expireAfterAccessNanos = timeUnit.toNanos(n);
        if (n == 0L && this.nullRemovalCause == null) {
            this.nullRemovalCause = MapMaker$RemovalCause.EXPIRED;
        }
        this.useCustomMap = true;
        return this;
    }
    
    long getExpireAfterAccessNanos() {
        return (this.expireAfterAccessNanos == -1L) ? 0L : this.expireAfterAccessNanos;
    }
    
    @Deprecated
    @GoogleInternal
    @GwtIncompatible("To be supported")
    @Override
    public MapMaker ticker(final Ticker ticker) {
        Preconditions.checkState(this.ticker == null);
        this.ticker = (Ticker)Preconditions.checkNotNull(ticker);
        return this;
    }
    
    Ticker getTicker() {
        return (Ticker)MoreObjects.firstNonNull(this.ticker, Ticker.systemTicker());
    }
    
    @Deprecated
    @GwtIncompatible("To be supported")
    public GenericMapMaker removalListener(final MapMaker$RemovalListener mapMaker$RemovalListener) {
        Preconditions.checkState(this.removalListener == null);
        super.removalListener = (MapMaker$RemovalListener)Preconditions.checkNotNull(mapMaker$RemovalListener);
        this.useCustomMap = true;
        return this;
    }
    
    @Override
    public ConcurrentMap makeMap() {
        if (!this.useCustomMap) {
            return new ConcurrentHashMap(this.getInitialCapacity(), 0.75f, this.getConcurrencyLevel());
        }
        return (ConcurrentMap)((this.nullRemovalCause == null) ? new MapMakerInternalMap(this) : new MapMaker$NullConcurrentMap(this));
    }
    
    @GwtIncompatible("MapMakerInternalMap")
    @Override
    MapMakerInternalMap makeCustomMap() {
        return new MapMakerInternalMap(this);
    }
    
    @Deprecated
    @Override
    public ConcurrentMap makeComputingMap(final Function function) {
        return (ConcurrentMap)((this.nullRemovalCause == null) ? new MapMaker$ComputingMapAdapter(this, function) : new MapMaker$NullComputingConcurrentMap(this, function));
    }
    
    @Override
    public String toString() {
        final MoreObjects$ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        if (this.initialCapacity != -1) {
            stringHelper.add("initialCapacity", this.initialCapacity);
        }
        if (this.concurrencyLevel != -1) {
            stringHelper.add("concurrencyLevel", this.concurrencyLevel);
        }
        if (this.maximumSize != -1) {
            stringHelper.add("maximumSize", this.maximumSize);
        }
        if (this.expireAfterWriteNanos != -1L) {
            stringHelper.add("expireAfterWrite", new StringBuilder(22).append(this.expireAfterWriteNanos).append("ns").toString());
        }
        if (this.expireAfterAccessNanos != -1L) {
            stringHelper.add("expireAfterAccess", new StringBuilder(22).append(this.expireAfterAccessNanos).append("ns").toString());
        }
        if (this.keyStrength != null) {
            stringHelper.add("keyStrength", Ascii.toLowerCase(this.keyStrength.toString()));
        }
        if (this.valueStrength != null) {
            stringHelper.add("valueStrength", Ascii.toLowerCase(this.valueStrength.toString()));
        }
        if (this.keyEquivalence != null) {
            stringHelper.addValue("keyEquivalence");
        }
        if (this.removalListener != null) {
            stringHelper.addValue("removalListener");
        }
        return stringHelper.toString();
    }
}
