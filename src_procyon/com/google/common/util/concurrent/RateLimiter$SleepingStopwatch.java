package com.google.common.util.concurrent;

import com.google.common.annotations.*;

@VisibleForTesting
abstract class RateLimiter$SleepingStopwatch
{
    abstract long readMicros();
    
    abstract void sleepMicrosUninterruptibly(final long p0);
    
    static final RateLimiter$SleepingStopwatch createFromSystemTimer() {
        return new RateLimiter$SleepingStopwatch$1();
    }
}
