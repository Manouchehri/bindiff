package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.*;

@Beta
public abstract class ForwardingCheckedFuture extends ForwardingListenableFuture implements CheckedFuture
{
    @Override
    public Object checkedGet() {
        return this.delegate().checkedGet();
    }
    
    @Override
    public Object checkedGet(final long n, final TimeUnit timeUnit) {
        return this.delegate().checkedGet(n, timeUnit);
    }
    
    @Override
    protected abstract CheckedFuture delegate();
}
