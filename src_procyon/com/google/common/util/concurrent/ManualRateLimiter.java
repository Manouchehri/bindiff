package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.*;
import com.google.common.base.*;

@GoogleInternal
public final class ManualRateLimiter extends RateLimiter
{
    private static final RateLimiter$SleepingStopwatch THROWING_STOPWATCH;
    private final Semaphore callsToProceed;
    
    public ManualRateLimiter() {
        super(ManualRateLimiter.THROWING_STOPWATCH);
        this.callsToProceed = new Semaphore(0, true);
    }
    
    public void release(final int n) {
        this.callsToProceed.release(n);
    }
    
    @Override
    public double acquire(final int n) {
        this.callsToProceed.acquireUninterruptibly(n);
        return 1.0;
    }
    
    @Override
    public boolean couldAcquire() {
        return this.callsToProceed.availablePermits() > 0;
    }
    
    @Override
    public boolean tryAcquire(final int n, final long n2, final TimeUnit timeUnit) {
        Preconditions.checkArgument(n2 <= 0L, (Object)"ManualRateLimiter does not support blocking tryAcquire(); see class-level Javadoc");
        Preconditions.checkNotNull(timeUnit);
        return Uninterruptibles.tryAcquireUninterruptibly(this.callsToProceed, n, 0L, TimeUnit.SECONDS);
    }
    
    @Override
    public boolean tryAcquire(final long n, final TimeUnit timeUnit) {
        return super.tryAcquire(n, timeUnit);
    }
    
    @Override
    void doSetRate(final double n, final long n2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    double doGetRate() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    boolean supportsAsync() {
        return false;
    }
    
    @Override
    long queryEarliestAvailable(final long n) {
        throw new AssertionError();
    }
    
    @Override
    long reserveEarliestAvailable(final int n, final long n2) {
        throw new AssertionError();
    }
    
    static {
        THROWING_STOPWATCH = new ManualRateLimiter$1();
    }
}
