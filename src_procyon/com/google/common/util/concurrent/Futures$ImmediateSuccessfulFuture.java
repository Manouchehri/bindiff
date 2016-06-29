package com.google.common.util.concurrent;

import javax.annotation.*;

class Futures$ImmediateSuccessfulFuture extends Futures$ImmediateFuture
{
    static final Futures$ImmediateSuccessfulFuture NULL;
    @Nullable
    private final Object value;
    
    Futures$ImmediateSuccessfulFuture(@Nullable final Object value) {
        super(null);
        this.value = value;
    }
    
    @Override
    public Object get() {
        return this.value;
    }
    
    static {
        NULL = new Futures$ImmediateSuccessfulFuture((Object)null);
    }
}
