package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.concurrent.*;

@GoogleInternal
public final class IncrementableCountDownLatch
{
    private final IncrementableCountDownLatch$Sync sync;
    
    public IncrementableCountDownLatch(final int n) {
        Preconditions.checkArgument(n >= 0, "count (%s) must be >= 0", n);
        this.sync = new IncrementableCountDownLatch$Sync(n);
    }
    
    public void await() {
        this.sync.acquireSharedInterruptibly(1);
    }
    
    public boolean await(final long n, final TimeUnit timeUnit) {
        return this.sync.tryAcquireSharedNanos(1, timeUnit.toNanos(n));
    }
    
    public void countDown() {
        this.sync.releaseShared(1);
    }
    
    public void increment() {
        this.sync.increaseCount(1);
    }
    
    public void increment(final int n) {
        Preconditions.checkArgument(n >= 0, "delta (%s) must be >= 0", n);
        this.sync.increaseCount(n);
    }
    
    public long getCount() {
        return this.sync.getCount();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(super.toString());
        return new StringBuilder(21 + String.valueOf(value).length()).append(value).append("[Count = ").append(this.sync.getCount()).append("]").toString();
    }
}
