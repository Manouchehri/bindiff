/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;

final class ManualRateLimiter$1
extends RateLimiter$SleepingStopwatch {
    ManualRateLimiter$1() {
    }

    @Override
    void sleepMicrosUninterruptibly(long l2) {
        throw new AssertionError();
    }

    @Override
    long readMicros() {
        throw new UnsupportedOperationException();
    }
}

