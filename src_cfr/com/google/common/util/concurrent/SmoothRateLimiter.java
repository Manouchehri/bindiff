/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter$1;
import java.util.concurrent.TimeUnit;

abstract class SmoothRateLimiter
extends RateLimiter {
    double storedPermits;
    double maxPermits;
    double stableIntervalMicros;
    private long nextFreeTicketMicros = 0;

    private SmoothRateLimiter(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch) {
        super(rateLimiter$SleepingStopwatch);
    }

    @Override
    final void doSetRate(double d2, long l2) {
        double d3;
        this.resync(l2);
        this.stableIntervalMicros = d3 = (double)TimeUnit.SECONDS.toMicros(1) / d2;
        this.doSetRate(d2, d3);
    }

    abstract void doSetRate(double var1, double var3);

    @Override
    final double doGetRate() {
        return (double)TimeUnit.SECONDS.toMicros(1) / this.stableIntervalMicros;
    }

    @Override
    final long queryEarliestAvailable(long l2) {
        return this.nextFreeTicketMicros;
    }

    @Override
    final long reserveEarliestAvailable(int n2, long l2) {
        this.resync(l2);
        long l3 = this.nextFreeTicketMicros;
        double d2 = Math.min((double)n2, this.storedPermits);
        double d3 = (double)n2 - d2;
        long l4 = this.storedPermitsToWaitTime(this.storedPermits, d2) + (long)(d3 * this.stableIntervalMicros);
        try {
            this.nextFreeTicketMicros = LongMath.checkedAdd(this.nextFreeTicketMicros, l4);
        }
        catch (ArithmeticException var12_7) {
            this.nextFreeTicketMicros = Long.MAX_VALUE;
        }
        this.storedPermits -= d2;
        return l3;
    }

    abstract long storedPermitsToWaitTime(double var1, double var3);

    abstract double coolDownIntervalMicros();

    void resync(long l2) {
        if (l2 <= this.nextFreeTicketMicros) return;
        this.storedPermits = Math.min(this.maxPermits, this.storedPermits + (double)(l2 - this.nextFreeTicketMicros) / this.coolDownIntervalMicros());
        this.nextFreeTicketMicros = l2;
    }

    /* synthetic */ SmoothRateLimiter(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, SmoothRateLimiter$1 smoothRateLimiter$1) {
        this(rateLimiter$SleepingStopwatch);
    }
}

