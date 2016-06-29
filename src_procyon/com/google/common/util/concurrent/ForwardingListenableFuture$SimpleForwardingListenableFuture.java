package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.*;

public abstract class ForwardingListenableFuture$SimpleForwardingListenableFuture extends ForwardingListenableFuture
{
    private final ListenableFuture delegate;
    
    protected ForwardingListenableFuture$SimpleForwardingListenableFuture(final ListenableFuture listenableFuture) {
        this.delegate = (ListenableFuture)Preconditions.checkNotNull(listenableFuture);
    }
    
    @Override
    protected final ListenableFuture delegate() {
        return this.delegate;
    }
}
