/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.cache.CacheLoader$1;
import com.google.common.cache.CacheLoader$FunctionToCacheLoader;
import com.google.common.cache.CacheLoader$SupplierToCacheLoader;
import com.google.common.cache.CacheLoader$UnsupportedLoadingOperationException;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;

@GwtCompatible(emulated=1)
public abstract class CacheLoader {
    protected CacheLoader() {
    }

    public abstract Object load(Object var1);

    @GwtIncompatible(value="Futures")
    public ListenableFuture reload(Object object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        return Futures.immediateFuture(this.load(object));
    }

    public Map loadAll(Iterable iterable) {
        throw new CacheLoader$UnsupportedLoadingOperationException();
    }

    public static CacheLoader from(Function function) {
        return new CacheLoader$FunctionToCacheLoader(function);
    }

    public static CacheLoader from(Supplier supplier) {
        return new CacheLoader$SupplierToCacheLoader(supplier);
    }

    @GwtIncompatible(value="Executor + Futures")
    public static CacheLoader asyncReloading(CacheLoader cacheLoader, Executor executor) {
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(executor);
        return new CacheLoader$1(cacheLoader, executor);
    }
}

