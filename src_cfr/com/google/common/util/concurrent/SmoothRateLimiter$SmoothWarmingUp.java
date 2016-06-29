/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter;
import com.google.common.util.concurrent.SmoothRateLimiter$1;
import java.util.concurrent.TimeUnit;

final class SmoothRateLimiter$SmoothWarmingUp
extends SmoothRateLimiter {
    private final long warmupPeriodMicros;
    private double slope;
    private double thresholdPermits;
    private double coldFactor;

    SmoothRateLimiter$SmoothWarmingUp(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, long l2, TimeUnit timeUnit, double d2) {
        super(rateLimiter$SleepingStopwatch, null);
        this.warmupPeriodMicros = timeUnit.toMicros(l2);
        this.coldFactor = d2;
    }

    @Override
    void doSetRate(double d2, double d3) {
        double d4 = this.maxPermits;
        double d5 = d3 * this.coldFactor;
        this.thresholdPermits = 0.5 * (double)this.warmupPeriodMicros / d3;
        this.maxPermits = this.thresholdPermits + 2.0 * (double)this.warmupPeriodMicros / (d3 + d5);
        this.slope = (d5 - d3) / (this.maxPermits - this.thresholdPermits);
        if (d4 == Double.POSITIVE_INFINITY) {
            this.storedPermits = 0.0;
            return;
        }
        this.storedPermits = d4 == 0.0 ? this.maxPermits : this.storedPermits * this.maxPermits / d4;
    }

    @Override
    long storedPermitsToWaitTime(double d2, double d3) {
        double d4 = d2 - this.thresholdPermits;
        long l2 = 0;
        if (d4 <= 0.0) return (long)((double)l2 + this.stableIntervalMicros * d3);
        double d5 = Math.min(d4, d3);
        l2 = (long)(d5 * (this.permitsToTime(d4) + this.permitsToTime(d4 - d5)) / 2.0);
        d3 -= d5;
        return (long)((double)l2 + this.stableIntervalMicros * d3);
    }

    private double permitsToTime(double d2) {
        return this.stableIntervalMicros + d2 * this.slope;
    }

    @Override
    double coolDownIntervalMicros() {
        return (double)this.warmupPeriodMicros / this.maxPermits;
    }
}

