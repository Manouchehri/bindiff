package com.google.common.util.concurrent;

import com.google.common.collect.*;
import java.util.concurrent.*;
import java.util.*;

public abstract class ForwardingBlockingQueue extends ForwardingQueue implements BlockingQueue
{
    @Override
    protected abstract BlockingQueue delegate();
    
    @Override
    public int drainTo(final Collection collection, final int n) {
        return this.delegate().drainTo(collection, n);
    }
    
    @Override
    public int drainTo(final Collection collection) {
        return this.delegate().drainTo(collection);
    }
    
    @Override
    public boolean offer(final Object o, final long n, final TimeUnit timeUnit) {
        return this.delegate().offer(o, n, timeUnit);
    }
    
    @Override
    public Object poll(final long n, final TimeUnit timeUnit) {
        return this.delegate().poll(n, timeUnit);
    }
    
    @Override
    public void put(final Object o) {
        this.delegate().put(o);
    }
    
    @Override
    public int remainingCapacity() {
        return this.delegate().remainingCapacity();
    }
    
    @Override
    public Object take() {
        return this.delegate().take();
    }
}
