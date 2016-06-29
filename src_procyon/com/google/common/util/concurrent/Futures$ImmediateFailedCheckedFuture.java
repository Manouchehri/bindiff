package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.*;
import com.google.common.base.*;

@GwtIncompatible("TODO")
class Futures$ImmediateFailedCheckedFuture extends Futures$ImmediateFuture implements CheckedFuture
{
    private final Exception thrown;
    
    Futures$ImmediateFailedCheckedFuture(final Exception thrown) {
        super(null);
        this.thrown = thrown;
    }
    
    @Override
    public Object get() {
        throw new ExecutionException(this.thrown);
    }
    
    @Override
    public Object checkedGet() {
        throw this.thrown;
    }
    
    @Override
    public Object checkedGet(final long n, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit);
        throw this.thrown;
    }
}
