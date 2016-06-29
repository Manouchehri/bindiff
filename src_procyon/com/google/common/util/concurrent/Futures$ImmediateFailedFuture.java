package com.google.common.util.concurrent;

import java.util.concurrent.*;

class Futures$ImmediateFailedFuture extends Futures$ImmediateFuture
{
    private final Throwable thrown;
    
    Futures$ImmediateFailedFuture(final Throwable thrown) {
        super(null);
        this.thrown = thrown;
    }
    
    @Override
    public Object get() {
        throw new ExecutionException(this.thrown);
    }
}
