package com.google.common.cache;

import com.google.common.annotations.*;
import java.util.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import com.google.common.util.concurrent.*;

@GoogleInternal
@GwtIncompatible("Futures")
public abstract class AsyncCacheLoader
{
    protected abstract ListenableFuture load(final Object p0);
    
    protected Map loadAll(final Set set) {
        Preconditions.checkNotNull(set);
        return ImmutableMap.of();
    }
    
    public static AsyncCacheLoader from(final AsyncFunction asyncFunction) {
        return new AsyncCacheLoader$AsyncFunctionToCacheLoader(asyncFunction);
    }
}
