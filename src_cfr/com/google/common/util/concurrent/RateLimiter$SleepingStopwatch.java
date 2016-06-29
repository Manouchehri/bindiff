/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch$1;

@VisibleForTesting
abstract class RateLimiter$SleepingStopwatch {
    RateLimiter$SleepingStopwatch() {
    }

    abstract long readMicros();

    abstract void sleepMicrosUninterruptibly(long var1);

    static final RateLimiter$SleepingStopwatch createFromSystemTimer() {
        return new RateLimiter$SleepingStopwatch$1();
    }
}

