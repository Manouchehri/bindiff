/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.TimeUnit;

final class RateLimiter$SleepingStopwatch$1
extends RateLimiter$SleepingStopwatch {
    final Stopwatch stopwatch = Stopwatch.createStarted();

    RateLimiter$SleepingStopwatch$1() {
    }

    @Override
    long readMicros() {
        return this.stopwatch.elapsed(TimeUnit.MICROSECONDS);
    }

    @Override
    void sleepMicrosUninterruptibly(long l2) {
        if (l2 <= 0) return;
        Uninterruptibles.sleepUninterruptibly(l2, TimeUnit.MICROSECONDS);
    }
}

