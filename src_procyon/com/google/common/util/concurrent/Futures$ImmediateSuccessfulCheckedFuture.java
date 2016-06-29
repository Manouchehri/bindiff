package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.concurrent.*;
import com.google.common.base.*;

@GwtIncompatible("TODO")
class Futures$ImmediateSuccessfulCheckedFuture extends Futures$ImmediateFuture implements CheckedFuture
{
    @Nullable
    private final Object value;
    
    Futures$ImmediateSuccessfulCheckedFuture(@Nullable final Object value) {
        super(null);
        this.value = value;
    }
    
    @Override
    public Object get() {
        return this.value;
    }
    
    @Override
    public Object checkedGet() {
        return this.value;
    }
    
    @Override
    public Object checkedGet(final long n, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit);
        return this.value;
    }
}
