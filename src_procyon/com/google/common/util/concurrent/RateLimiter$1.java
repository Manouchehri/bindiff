package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.*;

final class RateLimiter$1 extends RateLimiter$SleepingStopwatch
{
    final /* synthetic */ Stopwatch val$stopwatch;
    
    RateLimiter$1(final Stopwatch val$stopwatch) {
        this.val$stopwatch = val$stopwatch;
    }
    
    @Override
    void sleepMicrosUninterruptibly(final long n) {
        Preconditions.checkArgument(n <= 0L, "request to sleep (%s micros) unexpected for Throttle", n);
    }
    
    @Override
    long readMicros() {
        return this.val$stopwatch.elapsed(TimeUnit.MICROSECONDS);
    }
}
