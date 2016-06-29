/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import java.util.concurrent.TimeUnit;

final class RateLimiter$1
extends RateLimiter$SleepingStopwatch {
    final /* synthetic */ Stopwatch val$stopwatch;

    RateLimiter$1(Stopwatch stopwatch) {
        this.val$stopwatch = stopwatch;
    }

    @Override
    void sleepMicrosUninterruptibly(long l2) {
        Preconditions.checkArgument(l2 <= 0, "request to sleep (%s micros) unexpected for Throttle", l2);
    }

    @Override
    long readMicros() {
        return this.val$stopwatch.elapsed(TimeUnit.MICROSECONDS);
    }
}

