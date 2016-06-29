package com.google.common.cache;

import com.google.common.base.*;
import com.google.common.util.concurrent.*;

final class ShimAsyncCache$2 implements Function
{
    final /* synthetic */ RuntimeException val$e;
    
    ShimAsyncCache$2(final RuntimeException val$e) {
        this.val$e = val$e;
    }
    
    @Override
    public ListenableFuture apply(final Object o) {
        return Futures.immediateFailedFuture(this.val$e);
    }
}
