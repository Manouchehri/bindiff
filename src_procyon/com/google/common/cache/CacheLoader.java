package com.google.common.cache;

import com.google.common.util.concurrent.*;
import com.google.common.annotations.*;
import java.util.*;
import com.google.common.base.*;
import java.util.concurrent.*;

@GwtCompatible(emulated = true)
public abstract class CacheLoader
{
    public abstract Object load(final Object p0);
    
    @GwtIncompatible("Futures")
    public ListenableFuture reload(final Object o, final Object o2) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o2);
        return Futures.immediateFuture(this.load(o));
    }
    
    public Map loadAll(final Iterable iterable) {
        throw new CacheLoader$UnsupportedLoadingOperationException();
    }
    
    public static CacheLoader from(final Function function) {
        return new CacheLoader$FunctionToCacheLoader(function);
    }
    
    public static CacheLoader from(final Supplier supplier) {
        return new CacheLoader$SupplierToCacheLoader(supplier);
    }
    
    @GwtIncompatible("Executor + Futures")
    public static CacheLoader asyncReloading(final CacheLoader cacheLoader, final Executor executor) {
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(executor);
        return new CacheLoader$1(cacheLoader, executor);
    }
}
