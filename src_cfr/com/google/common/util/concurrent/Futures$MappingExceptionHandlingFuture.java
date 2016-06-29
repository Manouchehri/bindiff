/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@GoogleInternal
@GwtIncompatible(value="TODO")
class Futures$MappingExceptionHandlingFuture
extends ForwardingListenableFuture {
    private final ListenableFuture delegate;
    private final Function mapper;

    Futures$MappingExceptionHandlingFuture(ListenableFuture listenableFuture, Function function) {
        this.delegate = (ListenableFuture)Preconditions.checkNotNull(listenableFuture, "delegate");
        this.mapper = (Function)Preconditions.checkNotNull(function, "mapper");
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
        catch (ExecutionException var1_1) {
            throw new ExecutionException((Throwable)this.mapper.apply(var1_1.getCause()));
        }
    }

    @Override
    public Object get(long l2, TimeUnit timeUnit) {
        try {
            return this.delegate.get(l2, timeUnit);
        }
        catch (ExecutionException var4_3) {
            throw new ExecutionException((Throwable)this.mapper.apply(var4_3.getCause()));
        }
    }
}

