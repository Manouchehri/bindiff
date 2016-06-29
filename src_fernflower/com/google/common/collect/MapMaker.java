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

@GwtCompatible(
   emulated = true
)
public final class MapMaker extends GenericMapMaker {
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
   long expireAfterWriteNanos = -1L;
   long expireAfterAccessNanos = -1L;
   MapMaker$RemovalCause nullRemovalCause;
   Equivalence keyEquivalence;
   Ticker ticker;

   @GwtIncompatible("To be supported")
   MapMaker keyEquivalence(Equivalence var1) {
      Preconditions.checkState(this.keyEquivalence == null, "key equivalence was already set to %s", new Object[]{this.keyEquivalence});
      this.keyEquivalence = (Equivalence)Preconditions.checkNotNull(var1);
      this.useCustomMap = true;
      return this;
   }

   Equivalence getKeyEquivalence() {
      return (Equivalence)MoreObjects.firstNonNull(this.keyEquivalence, this.getKeyStrength().defaultEquivalence());
   }

   public MapMaker initialCapacity(int var1) {
      Preconditions.checkState(this.initialCapacity == -1, "initial capacity was already set to %s", new Object[]{Integer.valueOf(this.initialCapacity)});
      Preconditions.checkArgument(var1 >= 0);
      this.initialCapacity = var1;
      return this;
   }

   int getInitialCapacity() {
      return this.initialCapacity == -1?16:this.initialCapacity;
   }

   @Deprecated
   public MapMaker maximumSize(int var1) {
      Preconditions.checkState(this.maximumSize == -1, "maximum size was already set to %s", new Object[]{Integer.valueOf(this.maximumSize)});
      Preconditions.checkArgument(var1 >= 0, "maximum size must not be negative");
      this.maximumSize = var1;
      this.useCustomMap = true;
      if(this.maximumSize == 0) {
         this.nullRemovalCause = MapMaker$RemovalCause.SIZE;
      }

      return this;
   }

   public MapMaker concurrencyLevel(int var1) {
      Preconditions.checkState(this.concurrencyLevel == -1, "concurrency level was already set to %s", new Object[]{Integer.valueOf(this.concurrencyLevel)});
      Preconditions.checkArgument(var1 > 0);
      this.concurrencyLevel = var1;
      return this;
   }

   int getConcurrencyLevel() {
      return this.concurrencyLevel == -1?4:this.concurrencyLevel;
   }

   @GwtIncompatible("java.lang.ref.WeakReference")
   public MapMaker weakKeys() {
      return this.setKeyStrength(MapMakerInternalMap$Strength.WEAK);
   }

   MapMaker setKeyStrength(MapMakerInternalMap$Strength var1) {
      Preconditions.checkState(this.keyStrength == null, "Key strength was already set to %s", new Object[]{this.keyStrength});
      this.keyStrength = (MapMakerInternalMap$Strength)Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(this.keyStrength != MapMakerInternalMap$Strength.SOFT, "Soft keys are not supported");
      if(var1 != MapMakerInternalMap$Strength.STRONG) {
         this.useCustomMap = true;
      }

      return this;
   }

   MapMakerInternalMap$Strength getKeyStrength() {
      return (MapMakerInternalMap$Strength)MoreObjects.firstNonNull(this.keyStrength, MapMakerInternalMap$Strength.STRONG);
   }

   @GwtIncompatible("java.lang.ref.WeakReference")
   public MapMaker weakValues() {
      return this.setValueStrength(MapMakerInternalMap$Strength.WEAK);
   }

   @Deprecated
   @GwtIncompatible("java.lang.ref.SoftReference")
   public MapMaker softValues() {
      return this.setValueStrength(MapMakerInternalMap$Strength.SOFT);
   }

   MapMaker setValueStrength(MapMakerInternalMap$Strength var1) {
      Preconditions.checkState(this.valueStrength == null, "Value strength was already set to %s", new Object[]{this.valueStrength});
      this.valueStrength = (MapMakerInternalMap$Strength)Preconditions.checkNotNull(var1);
      if(var1 != MapMakerInternalMap$Strength.STRONG) {
         this.useCustomMap = true;
      }

      return this;
   }

   MapMakerInternalMap$Strength getValueStrength() {
      return (MapMakerInternalMap$Strength)MoreObjects.firstNonNull(this.valueStrength, MapMakerInternalMap$Strength.STRONG);
   }

   @Deprecated
   public MapMaker expireAfterWrite(long var1, TimeUnit var3) {
      this.checkExpiration(var1, var3);
      this.expireAfterWriteNanos = var3.toNanos(var1);
      if(var1 == 0L && this.nullRemovalCause == null) {
         this.nullRemovalCause = MapMaker$RemovalCause.EXPIRED;
      }

      this.useCustomMap = true;
      return this;
   }

   private void checkExpiration(long var1, TimeUnit var3) {
      Preconditions.checkState(this.expireAfterWriteNanos == -1L, "expireAfterWrite was already set to %s ns", new Object[]{Long.valueOf(this.expireAfterWriteNanos)});
      Preconditions.checkState(this.expireAfterAccessNanos == -1L, "expireAfterAccess was already set to %s ns", new Object[]{Long.valueOf(this.expireAfterAccessNanos)});
      Preconditions.checkArgument(var1 >= 0L, "duration cannot be negative: %s %s", new Object[]{Long.valueOf(var1), var3});
   }

   long getExpireAfterWriteNanos() {
      return this.expireAfterWriteNanos == -1L?0L:this.expireAfterWriteNanos;
   }

   @Deprecated
   @GwtIncompatible("To be supported")
   public MapMaker expireAfterAccess(long var1, TimeUnit var3) {
      this.checkExpiration(var1, var3);
      this.expireAfterAccessNanos = var3.toNanos(var1);
      if(var1 == 0L && this.nullRemovalCause == null) {
         this.nullRemovalCause = MapMaker$RemovalCause.EXPIRED;
      }

      this.useCustomMap = true;
      return this;
   }

   long getExpireAfterAccessNanos() {
      return this.expireAfterAccessNanos == -1L?0L:this.expireAfterAccessNanos;
   }

   @Deprecated
   @GoogleInternal
   @GwtIncompatible("To be supported")
   public MapMaker ticker(Ticker var1) {
      Preconditions.checkState(this.ticker == null);
      this.ticker = (Ticker)Preconditions.checkNotNull(var1);
      return this;
   }

   Ticker getTicker() {
      return (Ticker)MoreObjects.firstNonNull(this.ticker, Ticker.systemTicker());
   }

   @Deprecated
   @GwtIncompatible("To be supported")
   public GenericMapMaker removalListener(MapMaker$RemovalListener var1) {
      Preconditions.checkState(this.removalListener == null);
      super.removalListener = (MapMaker$RemovalListener)Preconditions.checkNotNull(var1);
      this.useCustomMap = true;
      return this;
   }

   public ConcurrentMap makeMap() {
      return (ConcurrentMap)(!this.useCustomMap?new ConcurrentHashMap(this.getInitialCapacity(), 0.75F, this.getConcurrencyLevel()):(this.nullRemovalCause == null?new MapMakerInternalMap(this):new MapMaker$NullConcurrentMap(this)));
   }

   @GwtIncompatible("MapMakerInternalMap")
   MapMakerInternalMap makeCustomMap() {
      return new MapMakerInternalMap(this);
   }

   @Deprecated
   public ConcurrentMap makeComputingMap(Function var1) {
      return (ConcurrentMap)(this.nullRemovalCause == null?new MapMaker$ComputingMapAdapter(this, var1):new MapMaker$NullComputingConcurrentMap(this, var1));
   }

   public String toString() {
      MoreObjects$ToStringHelper var1 = MoreObjects.toStringHelper((Object)this);
      if(this.initialCapacity != -1) {
         var1.add("initialCapacity", this.initialCapacity);
      }

      if(this.concurrencyLevel != -1) {
         var1.add("concurrencyLevel", this.concurrencyLevel);
      }

      if(this.maximumSize != -1) {
         var1.add("maximumSize", this.maximumSize);
      }

      long var2;
      if(this.expireAfterWriteNanos != -1L) {
         var2 = this.expireAfterWriteNanos;
         var1.add("expireAfterWrite", (new StringBuilder(22)).append(var2).append("ns").toString());
      }

      if(this.expireAfterAccessNanos != -1L) {
         var2 = this.expireAfterAccessNanos;
         var1.add("expireAfterAccess", (new StringBuilder(22)).append(var2).append("ns").toString());
      }

      if(this.keyStrength != null) {
         var1.add("keyStrength", Ascii.toLowerCase(this.keyStrength.toString()));
      }

      if(this.valueStrength != null) {
         var1.add("valueStrength", Ascii.toLowerCase(this.valueStrength.toString()));
      }

      if(this.keyEquivalence != null) {
         var1.addValue("keyEquivalence");
      }

      if(this.removalListener != null) {
         var1.addValue("removalListener");
      }

      return var1.toString();
   }
}
