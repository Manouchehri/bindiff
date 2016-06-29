package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.concurrent.*;

@GoogleInternal
@GwtIncompatible("TODO")
class Futures$MappingExceptionHandlingFuture extends ForwardingListenableFuture
{
    private final ListenableFuture delegate;
    private final Function mapper;
    
    Futures$MappingExceptionHandlingFuture(final ListenableFuture listenableFuture, final Function function) {
        this.delegate = (ListenableFuture)Preconditions.checkNotNull(listenableFuture, (Object)"delegate");
        this.mapper = (Function)Preconditions.checkNotNull(function, (Object)"mapper");
    }
    
    @Override
    protected ListenableFuture delegate() {
        return this.delegate;
    }
    
    @Override
    public Object get() {
        try {
            return this.delegate.get();
        }
        catch (ExecutionException ex) {
            throw new ExecutionException((Throwable)this.mapper.apply(ex.getCause()));
        }
    }
    
    @Override
    public Object get(final long n, final TimeUnit timeUnit) {
        try {
            return this.delegate.get(n, timeUnit);
        }
        catch (ExecutionException ex) {
            throw new ExecutionException((Throwable)this.mapper.apply(ex.getCause()));
        }
    }
}
