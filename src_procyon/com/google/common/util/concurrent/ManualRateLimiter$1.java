package com.google.common.util.concurrent;

final class ManualRateLimiter$1 extends RateLimiter$SleepingStopwatch
{
    @Override
    void sleepMicrosUninterruptibly(final long n) {
        throw new AssertionError();
    }
    
    @Override
    long readMicros() {
        throw new UnsupportedOperationException();
    }
}
