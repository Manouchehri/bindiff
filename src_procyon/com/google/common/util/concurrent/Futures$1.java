package com.google.common.util.concurrent;

import com.google.common.base.*;

final class Futures$1 implements AsyncFunction
{
    final /* synthetic */ FutureFallback val$fallback;
    
    Futures$1(final FutureFallback val$fallback) {
        this.val$fallback = val$fallback;
    }
    
    public ListenableFuture apply(final Throwable t) {
        return (ListenableFuture)Preconditions.checkNotNull(this.val$fallback.create(t), (Object)"FutureFallback.create returned null instead of a Future. Did you mean to return immediateFuture(null)?");
    }
}
