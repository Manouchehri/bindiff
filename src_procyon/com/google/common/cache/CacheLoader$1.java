package com.google.common.cache;

import com.google.common.util.concurrent.*;
import java.util.concurrent.*;
import java.util.*;

final class CacheLoader$1 extends CacheLoader
{
    final /* synthetic */ CacheLoader val$loader;
    final /* synthetic */ Executor val$executor;
    
    CacheLoader$1(final CacheLoader val$loader, final Executor val$executor) {
        this.val$loader = val$loader;
        this.val$executor = val$executor;
    }
    
    @Override
    public Object load(final Object o) {
        return this.val$loader.load(o);
    }
    
    @Override
    public ListenableFuture reload(final Object o, final Object o2) {
        final ListenableFutureTask create = ListenableFutureTask.create(new CacheLoader$1$1(this, o, o2));
        this.val$executor.execute(create);
        return create;
    }
    
    @Override
    public Map loadAll(final Iterable iterable) {
        return this.val$loader.loadAll(iterable);
    }
}
