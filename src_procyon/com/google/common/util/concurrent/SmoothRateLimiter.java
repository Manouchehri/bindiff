package com.google.common.util.concurrent;

import java.util.concurrent.*;
import com.google.common.math.*;

abstract class SmoothRateLimiter extends RateLimiter
{
    double storedPermits;
    double maxPermits;
    double stableIntervalMicros;
    private long nextFreeTicketMicros;
    
    private SmoothRateLimiter(final RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch) {
        super(rateLimiter$SleepingStopwatch);
        this.nextFreeTicketMicros = 0L;
    }
    
    @Override
    final void doSetRate(final double n, final long n2) {
        this.resync(n2);
        this.doSetRate(n, this.stableIntervalMicros = TimeUnit.SECONDS.toMicros(1L) / n);
    }
    
    abstract void doSetRate(final double p0, final double p1);
    
    @Override
    final double doGetRate() {
        return TimeUnit.SECONDS.toMicros(1L) / this.stableIntervalMicros;
    }
    
    @Override
    final long queryEarliestAvailable(final long n) {
        return this.nextFreeTicketMicros;
    }
    
    @Override
    final long reserveEarliestAvailable(final int n, final long n2) {
        this.resync(n2);
        final long nextFreeTicketMicros = this.nextFreeTicketMicros;
        final double min = Math.min(n, this.storedPermits);
        final long n3 = this.storedPermitsToWaitTime(this.storedPermits, min) + (long)((n - min) * this.stableIntervalMicros);
        try {
            this.nextFreeTicketMicros = LongMath.checkedAdd(this.nextFreeTicketMicros, n3);
        }
        catch (ArithmeticException ex) {
            this.nextFreeTicketMicros = Long.MAX_VALUE;
        }
        this.storedPermits -= min;
        return nextFreeTicketMicros;
    }
    
    abstract long storedPermitsToWaitTime(final double p0, final double p1);
    
    abstract double coolDownIntervalMicros();
    
    void resync(final long nextFreeTicketMicros) {
        if (nextFreeTicketMicros > this.nextFreeTicketMicros) {
            this.storedPermits = Math.min(this.maxPermits, this.storedPermits + (nextFreeTicketMicros - this.nextFreeTicketMicros) / this.coolDownIntervalMicros());
            this.nextFreeTicketMicros = nextFreeTicketMicros;
        }
    }
}
