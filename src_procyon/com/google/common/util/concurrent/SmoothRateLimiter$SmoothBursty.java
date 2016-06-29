package com.google.common.util.concurrent;

import com.google.common.annotations.*;

final class SmoothRateLimiter$SmoothBursty extends SmoothRateLimiter
{
    final double maxBurstSeconds;
    
    SmoothRateLimiter$SmoothBursty(final RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, final double maxBurstSeconds) {
        super(rateLimiter$SleepingStopwatch, null);
        this.maxBurstSeconds = maxBurstSeconds;
    }
    
    @Override
    void doSetRate(final double n, final double n2) {
        final double maxPermits = this.maxPermits;
        this.maxPermits = this.maxBurstSeconds * n;
        if (maxPermits == Double.POSITIVE_INFINITY) {
            this.storedPermits = this.maxPermits;
        }
        else {
            this.storedPermits = ((maxPermits == 0.0) ? 0.0 : (this.storedPermits * this.maxPermits / maxPermits));
        }
    }
    
    @Override
    long storedPermitsToWaitTime(final double n, final double n2) {
        return 0L;
    }
    
    @Override
    double coolDownIntervalMicros() {
        return this.stableIntervalMicros;
    }
    
    @GoogleInternal
    @Override
    int doGetAvailablePermits(final long n) {
        this.resync(n);
        return (int)this.storedPermits;
    }
}
