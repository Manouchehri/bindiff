package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Ticker;
import com.google.common.collect.GenericMapMaker$NullListener;
import com.google.common.collect.MapMaker$RemovalListener;
import com.google.common.collect.MapMakerInternalMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

@Deprecated
@Beta
@GwtCompatible(
   emulated = true
)
public abstract class GenericMapMaker {
   @GwtIncompatible("To be supported")
   MapMaker$RemovalListener removalListener;

   @GwtIncompatible("To be supported")
   abstract GenericMapMaker keyEquivalence(Equivalence var1);

   public abstract GenericMapMaker initialCapacity(int var1);

   public abstract GenericMapMaker maximumSize(int var1);

   public abstract GenericMapMaker concurrencyLevel(int var1);

   @GwtIncompatible("java.lang.ref.WeakReference")
   public abstract GenericMapMaker weakKeys();

   @GwtIncompatible("java.lang.ref.WeakReference")
   public abstract GenericMapMaker weakValues();

   @Deprecated
   @GwtIncompatible("java.lang.ref.SoftReference")
   public abstract GenericMapMaker softValues();

   public abstract GenericMapMaker expireAfterWrite(long var1, TimeUnit var3);

   @GwtIncompatible("To be supported")
   public abstract GenericMapMaker expireAfterAccess(long var1, TimeUnit var3);

   @GoogleInternal
   @GwtIncompatible("To be supported")
   public abstract GenericMapMaker ticker(Ticker var1);

   @GwtIncompatible("To be supported")
   MapMaker$RemovalListener getRemovalListener() {
      return (MapMaker$RemovalListener)MoreObjects.firstNonNull(this.removalListener, GenericMapMaker$NullListener.INSTANCE);
   }

   public abstract ConcurrentMap makeMap();

   @GwtIncompatible("MapMakerInternalMap")
   abstract MapMakerInternalMap makeCustomMap();

   @Deprecated
   public abstract ConcurrentMap makeComputingMap(Function var1);
}
