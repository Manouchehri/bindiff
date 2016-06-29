/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheLoader$1$1;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.Map;
import java.util.concurrent.Executor;

final class CacheLoader$1
extends CacheLoader {
    final /* synthetic */ CacheLoader val$loader;
    final /* synthetic */ Executor val$executor;

    CacheLoader$1(CacheLoader cacheLoader, Executor executor) {
        this.val$loader = cacheLoader;
        this.val$executor = executor;
    }

    @Override
    public Object load(Object object) {
        return this.val$loader.load(object);
    }

    @Override
    public ListenableFuture reload(Object object, Object object2) {
        ListenableFutureTask listenableFutureTask = ListenableFutureTask.create(new CacheLoader$1$1(this, object, object2));
        this.val$executor.execute(listenableFutureTask);
        return listenableFutureTask;
    }

    @Override
    public Map loadAll(Iterable iterable) {
        return this.val$loader.loadAll(iterable);
    }
}

