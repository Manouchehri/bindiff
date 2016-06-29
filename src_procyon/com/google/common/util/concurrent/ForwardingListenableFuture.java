package com.google.common.util.concurrent;

import java.util.concurrent.*;

public abstract class ForwardingListenableFuture extends ForwardingFuture implements ListenableFuture
{
    @Override
    protected abstract ListenableFuture delegate();
    
    @Override
    public void addListener(final Runnable runnable, final Executor executor) {
        this.delegate().addListener(runnable, executor);
    }
}
