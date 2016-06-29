/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter;
import com.google.common.util.concurrent.SmoothRateLimiter$1;

final class SmoothRateLimiter$SmoothBursty
extends SmoothRateLimiter {
    final double maxBurstSeconds;

    SmoothRateLimiter$SmoothBursty(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, double d2) {
        super(rateLimiter$SleepingStopwatch, null);
        this.maxBurstSeconds = d2;
    }

    @Override
    void doSetRate(double d2, double d3) {
        double d4 = this.maxPermits;
        this.maxPermits = this.maxBurstSeconds * d2;
        if (d4 == Double.POSITIVE_INFINITY) {
            this.storedPermits = this.maxPermits;
            return;
        }
        this.storedPermits = d4 == 0.0 ? 0.0 : this.storedPermits * this.maxPermits / d4;
    }

    @Override
    long storedPermitsToWaitTime(double d2, double d3) {
        return 0;
    }

    @Override
    double coolDownIntervalMicros() {
        return this.stableIntervalMicros;
    }

    @GoogleInternal
    @Override
    int doGetAvailablePermits(long l2) {
        this.resync(l2);
        return (int)this.storedPermits;
    }
}

