package com.google.common.cache;

import com.google.common.annotations.*;
import com.google.common.util.concurrent.*;
import com.google.common.collect.*;
import javax.annotation.*;

@GoogleInternal
@GwtIncompatible("Futures")
public interface AsyncLoadingCache
{
    ListenableFuture get(final Object p0);
    
    ImmutableMap getAll(final Iterable p0);
    
    @Nullable
    Object getIfPresent(final Object p0);
    
    void invalidateAll();
    
    void invalidate(final Object p0);
    
    void put(final Object p0, final Object p1);
}
