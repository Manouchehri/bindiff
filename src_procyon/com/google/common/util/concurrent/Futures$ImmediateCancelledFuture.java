package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.*;

@GwtIncompatible("TODO")
class Futures$ImmediateCancelledFuture extends Futures$ImmediateFuture
{
    private final CancellationException thrown;
    
    Futures$ImmediateCancelledFuture() {
        super(null);
        this.thrown = new CancellationException("Immediate cancelled future.");
    }
    
    @Override
    public boolean isCancelled() {
        return true;
    }
    
    @Override
    public Object get() {
        throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", this.thrown);
    }
}
