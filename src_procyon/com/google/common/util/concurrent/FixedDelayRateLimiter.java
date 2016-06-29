package com.google.common.util.concurrent;

import com.google.common.annotations.*;

@GoogleInternal
final class FixedDelayRateLimiter extends RateLimiter
{
    private final long fixedDelay;
    
    FixedDelayRateLimiter(final RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, final long fixedDelay) {
        super(rateLimiter$SleepingStopwatch);
        this.fixedDelay = fixedDelay;
    }
    
    @Override
    void doSetRate(final double n, final long n2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    double doGetRate() {
        return 0.0;
    }
    
    @Override
    long queryEarliestAvailable(final long n) {
        return n + this.fixedDelay;
    }
    
    @Override
    long reserveEarliestAvailable(final int n, final long n2) {
        return n2 + this.fixedDelay;
    }
}
