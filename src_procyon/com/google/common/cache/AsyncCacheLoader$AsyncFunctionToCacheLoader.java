package com.google.common.cache;

import com.google.common.base.*;
import com.google.common.util.concurrent.*;

final class AsyncCacheLoader$AsyncFunctionToCacheLoader extends AsyncCacheLoader
{
    final AsyncFunction computingFunction;
    
    AsyncCacheLoader$AsyncFunctionToCacheLoader(final AsyncFunction asyncFunction) {
        this.computingFunction = (AsyncFunction)Preconditions.checkNotNull(asyncFunction);
    }
    
    @Override
    protected ListenableFuture load(final Object o) {
        Preconditions.checkNotNull(o);
        try {
            return this.computingFunction.apply(o);
        }
        catch (Exception ex) {
            return Futures.immediateFailedFuture(ex);
        }
    }
}
