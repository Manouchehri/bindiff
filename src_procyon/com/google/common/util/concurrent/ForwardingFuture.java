package com.google.common.util.concurrent;

import com.google.common.collect.*;
import java.util.concurrent.*;

public abstract class ForwardingFuture extends ForwardingObject implements Future
{
    @Override
    protected abstract Future delegate();
    
    @Override
    public boolean cancel(final boolean b) {
        return this.delegate().cancel(b);
    }
    
    @Override
    public boolean isCancelled() {
        return this.delegate().isCancelled();
    }
    
    @Override
    public boolean isDone() {
        return this.delegate().isDone();
    }
    
    @Override
    public Object get() {
        return this.delegate().get();
    }
    
    @Override
    public Object get(final long n, final TimeUnit timeUnit) {
        return this.delegate().get(n, timeUnit);
    }
}
