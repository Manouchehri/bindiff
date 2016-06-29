/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;

@GoogleInternal
final class FixedDelayRateLimiter
extends RateLimiter {
    private final long fixedDelay;

    FixedDelayRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch, long l2) {
        super(sleepingStopwatch);
        this.fixedDelay = l2;
    }

    @Override
    void doSetRate(double d2, long l2) {
        throw new UnsupportedOperationException();
    }

    @Override
    double doGetRate() {
        return 0.0;
    }

    @Override
    long queryEarliestAvailable(long l2) {
        return l2 + this.fixedDelay;
    }

    @Override
    long reserveEarliestAvailable(int n2, long l2) {
        return l2 + this.fixedDelay;
    }
}

