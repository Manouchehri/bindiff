package com.google.common.cache;

import com.google.common.util.concurrent.*;

final class ShimAsyncCache$4 extends CacheLoader
{
    final /* synthetic */ ShimAsyncCache$CacheHolder val$holder;
    final /* synthetic */ AsyncCacheLoader val$loader;
    final /* synthetic */ ThreadLocal val$batch;
    
    ShimAsyncCache$4(final ShimAsyncCache$CacheHolder val$holder, final AsyncCacheLoader val$loader, final ThreadLocal val$batch) {
        this.val$holder = val$holder;
        this.val$loader = val$loader;
        this.val$batch = val$batch;
    }
    
    @Override
    public ShimAsyncCache$Entry load(final Object o) {
        return new ShimAsyncCache$Entry(this.val$holder.cache, this.val$loader, this.val$batch, o);
    }
    
    public ListenableFuture reload(final Object o, final ShimAsyncCache$Entry shimAsyncCache$Entry) {
        shimAsyncCache$Entry.maybeLoad(ShimAsyncCache$LoadWhen.ALWAYS);
        return Futures.immediateFuture(shimAsyncCache$Entry);
    }
}
