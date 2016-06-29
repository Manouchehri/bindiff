package com.google.common.util.concurrent;

import java.util.concurrent.*;

final class SmoothRateLimiter$SmoothWarmingUp extends SmoothRateLimiter
{
    private final long warmupPeriodMicros;
    private double slope;
    private double thresholdPermits;
    private double coldFactor;
    
    SmoothRateLimiter$SmoothWarmingUp(final RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, final long n, final TimeUnit timeUnit, final double coldFactor) {
        super(rateLimiter$SleepingStopwatch, null);
        this.warmupPeriodMicros = timeUnit.toMicros(n);
        this.coldFactor = coldFactor;
    }
    
    @Override
    void doSetRate(final double n, final double n2) {
        final double maxPermits = this.maxPermits;
        final double n3 = n2 * this.coldFactor;
        this.thresholdPermits = 0.5 * this.warmupPeriodMicros / n2;
        this.maxPermits = this.thresholdPermits + 2.0 * this.warmupPeriodMicros / (n2 + n3);
        this.slope = (n3 - n2) / (this.maxPermits - this.thresholdPermits);
        if (maxPermits == Double.POSITIVE_INFINITY) {
            this.storedPermits = 0.0;
        }
        else {
            this.storedPermits = ((maxPermits == 0.0) ? this.maxPermits : (this.storedPermits * this.maxPermits / maxPermits));
        }
    }
    
    @Override
    long storedPermitsToWaitTime(final double n, double n2) {
        final double n3 = n - this.thresholdPermits;
        long n4 = 0L;
        if (n3 > 0.0) {
            final double min = Math.min(n3, n2);
            n4 = (long)(min * (this.permitsToTime(n3) + this.permitsToTime(n3 - min)) / 2.0);
            n2 -= min;
        }
        return (long)(n4 + this.stableIntervalMicros * n2);
    }
    
    private double permitsToTime(final double n) {
        return this.stableIntervalMicros + n * this.slope;
    }
    
    @Override
    double coolDownIntervalMicros() {
        return this.warmupPeriodMicros / this.maxPermits;
    }
}
