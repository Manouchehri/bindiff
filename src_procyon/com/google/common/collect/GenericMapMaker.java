package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.concurrent.*;
import com.google.common.base.*;

@Deprecated
@Beta
@GwtCompatible(emulated = true)
public abstract class GenericMapMaker
{
    @GwtIncompatible("To be supported")
    MapMaker$RemovalListener removalListener;
    
    @GwtIncompatible("To be supported")
    abstract GenericMapMaker keyEquivalence(final Equivalence p0);
    
    public abstract GenericMapMaker initialCapacity(final int p0);
    
    public abstract GenericMapMaker maximumSize(final int p0);
    
    public abstract GenericMapMaker concurrencyLevel(final int p0);
    
    @GwtIncompatible("java.lang.ref.WeakReference")
    public abstract GenericMapMaker weakKeys();
    
    @GwtIncompatible("java.lang.ref.WeakReference")
    public abstract GenericMapMaker weakValues();
    
    @Deprecated
    @GwtIncompatible("java.lang.ref.SoftReference")
    public abstract GenericMapMaker softValues();
    
    public abstract GenericMapMaker expireAfterWrite(final long p0, final TimeUnit p1);
    
    @GwtIncompatible("To be supported")
    public abstract GenericMapMaker expireAfterAccess(final long p0, final TimeUnit p1);
    
    @GoogleInternal
    @GwtIncompatible("To be supported")
    public abstract GenericMapMaker ticker(final Ticker p0);
    
    @GwtIncompatible("To be supported")
    MapMaker$RemovalListener getRemovalListener() {
        return (MapMaker$RemovalListener)MoreObjects.firstNonNull(this.removalListener, GenericMapMaker$NullListener.INSTANCE);
    }
    
    public abstract ConcurrentMap makeMap();
    
    @GwtIncompatible("MapMakerInternalMap")
    abstract MapMakerInternalMap makeCustomMap();
    
    @Deprecated
    public abstract ConcurrentMap makeComputingMap(final Function p0);
}
