package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.*;

final class RateLimiter$SleepingStopwatch$1 extends RateLimiter$SleepingStopwatch
{
    final Stopwatch stopwatch;
    
    RateLimiter$SleepingStopwatch$1() {
        this.stopwatch = Stopwatch.createStarted();
    }
    
    @Override
    long readMicros() {
        return this.stopwatch.elapsed(TimeUnit.MICROSECONDS);
    }
    
    @Override
    void sleepMicrosUninterruptibly(final long n) {
        if (n > 0L) {
            Uninterruptibles.sleepUninterruptibly(n, TimeUnit.MICROSECONDS);
        }
    }
}
