/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ManualRateLimiter$1;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@GoogleInternal
public final class ManualRateLimiter
extends RateLimiter {
    private static final RateLimiter$SleepingStopwatch THROWING_STOPWATCH = new ManualRateLimiter$1();
    private final Semaphore callsToProceed = new Semaphore(0, true);

    public ManualRateLimiter() {
        super(THROWING_STOPWATCH);
    }

    public void release(int n2) {
        this.callsToProceed.release(n2);
    }

    @Override
    public double acquire(int n2) {
        this.callsToProceed.acquireUninterruptibly(n2);
        return 1.0;
    }

    @Override
    public boolean couldAcquire() {
        if (this.callsToProceed.availablePermits() <= 0) return false;
        return true;
    }

    @Override
    public boolean tryAcquire(int n2, long l2, TimeUnit timeUnit) {
        Preconditions.checkArgument(l2 <= 0, "ManualRateLimiter does not support blocking tryAcquire(); see class-level Javadoc");
        Preconditions.checkNotNull((Object)timeUnit);
        return Uninterruptibles.tryAcquireUninterruptibly(this.callsToProceed, n2, 0, TimeUnit.SECONDS);
    }

    @Override
    public boolean tryAcquire(long l2, TimeUnit timeUnit) {
        return super.tryAcquire(l2, timeUnit);
    }

    @Override
    void doSetRate(double d2, long l2) {
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
    long queryEarliestAvailable(long l2) {
        throw new AssertionError();
    }

    @Override
    long reserveEarliestAvailable(int n2, long l2) {
        throw new AssertionError();
    }
}

