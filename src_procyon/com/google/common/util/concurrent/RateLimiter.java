package com.google.common.util.concurrent;

import javax.annotation.concurrent.*;
import com.google.common.annotations.*;
import java.util.concurrent.*;
import java.util.*;
import com.google.common.base.*;
import java.math.*;
import com.google.common.math.*;

@ThreadSafe
@Beta
public abstract class RateLimiter
{
    private final RateLimiter$SleepingStopwatch stopwatch;
    private volatile Object mutexDoNotUseDirectly;
    
    public static RateLimiter create(final double n) {
        return create(RateLimiter$SleepingStopwatch.createFromSystemTimer(), n);
    }
    
    @GoogleInternal
    public final int latestPermitAgeSec() {
        synchronized (this.mutex()) {
            return this.doLatestPermitAgeSec(this.stopwatch.readMicros());
        }
    }
    
    @GoogleInternal
    int doLatestPermitAgeSec(final long n) {
        throw new UnsupportedOperationException();
    }
    
    @GoogleInternal
    public final void setPermitsWithinHorizon(final int n) {
        synchronized (this.mutex()) {
            this.doSetPermitsWithinHorizon(n);
        }
    }
    
    @GoogleInternal
    void doSetPermitsWithinHorizon(final int n) {
        throw new UnsupportedOperationException();
    }
    
    @VisibleForTesting
    static RateLimiter create(final RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, final double rate) {
        final SmoothRateLimiter$SmoothBursty smoothRateLimiter$SmoothBursty = new SmoothRateLimiter$SmoothBursty(rateLimiter$SleepingStopwatch, 1.0);
        smoothRateLimiter$SmoothBursty.setRate(rate);
        return smoothRateLimiter$SmoothBursty;
    }
    
    public static RateLimiter create(final double n, final long n2, final TimeUnit timeUnit) {
        Preconditions.checkArgument(n2 >= 0L, "warmupPeriod must not be negative: %s", n2);
        return create(RateLimiter$SleepingStopwatch.createFromSystemTimer(), n, n2, timeUnit, 3.0);
    }
    
    @GoogleInternal
    public static RateLimiter create(final double n, final long n2, final TimeUnit timeUnit, final double n3) {
        Preconditions.checkArgument(n2 >= 0L, "warmupPeriod must not be negative: %s", n2);
        Preconditions.checkArgument(n3 >= 1.0, "coldFactor must be >= 1.0: %s", n3);
        return create(RateLimiter$SleepingStopwatch.createFromSystemTimer(), n, n2, timeUnit, n3);
    }
    
    @VisibleForTesting
    static RateLimiter create(final RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, final double rate, final long n, final TimeUnit timeUnit, final double n2) {
        final SmoothRateLimiter$SmoothWarmingUp smoothRateLimiter$SmoothWarmingUp = new SmoothRateLimiter$SmoothWarmingUp(rateLimiter$SleepingStopwatch, n, timeUnit, n2);
        smoothRateLimiter$SmoothWarmingUp.setRate(rate);
        return smoothRateLimiter$SmoothWarmingUp;
    }
    
    @GoogleInternal
    public static RateLimiter createWithCapacity(final double n, final long n2, final TimeUnit timeUnit) {
        return createWithCapacity(RateLimiter$SleepingStopwatch.createFromSystemTimer(), n, n2, timeUnit);
    }
    
    @GoogleInternal
    @VisibleForTesting
    static RateLimiter createWithCapacity(final RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, final double rate, final long n, final TimeUnit timeUnit) {
        Preconditions.checkArgument(n >= 0L, "maxBurstBuildup must not be negative: %s", n);
        final SmoothRateLimiter$SmoothBursty smoothRateLimiter$SmoothBursty = new SmoothRateLimiter$SmoothBursty(rateLimiter$SleepingStopwatch, timeUnit.toNanos(n) / 1.0E9);
        smoothRateLimiter$SmoothBursty.setRate(rate);
        return smoothRateLimiter$SmoothBursty;
    }
    
    private Object mutex() {
        Object o = this.mutexDoNotUseDirectly;
        if (o == null) {
            synchronized (this) {
                o = this.mutexDoNotUseDirectly;
                if (o == null) {
                    o = (this.mutexDoNotUseDirectly = new Object());
                }
            }
        }
        return o;
    }
    
    RateLimiter(final RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch) {
        this.stopwatch = (RateLimiter$SleepingStopwatch)Preconditions.checkNotNull(rateLimiter$SleepingStopwatch);
    }
    
    public final void setRate(final double n) {
        Preconditions.checkArgument(n > 0.0 && !Double.isNaN(n), (Object)"rate must be positive");
        synchronized (this.mutex()) {
            this.doSetRate(n, this.stopwatch.readMicros());
        }
    }
    
    abstract void doSetRate(final double p0, final long p1);
    
    public final double getRate() {
        synchronized (this.mutex()) {
            return this.doGetRate();
        }
    }
    
    abstract double doGetRate();
    
    @GoogleInternal
    public int getAvailablePermits() {
        synchronized (this.mutex()) {
            return this.doGetAvailablePermits(this.stopwatch.readMicros());
        }
    }
    
    @GoogleInternal
    int doGetAvailablePermits(final long n) {
        return 0;
    }
    
    public double acquire() {
        return this.acquire(1);
    }
    
    public double acquire(final int n) {
        final long reserve = this.reserve(n);
        this.stopwatch.sleepMicrosUninterruptibly(reserve);
        return 1.0 * reserve / TimeUnit.SECONDS.toMicros(1L);
    }
    
    final long reserve(final int n) {
        checkPermits(n);
        synchronized (this.mutex()) {
            return this.reserveAndGetWaitLength(n, this.stopwatch.readMicros());
        }
    }
    
    @GoogleInternal
    final RateLimiter checkSupportsAsync() {
        Preconditions.checkArgument(this.supportsAsync(), "%s does not support asynchronous use", this);
        return this;
    }
    
    @GoogleInternal
    boolean supportsAsync() {
        return true;
    }
    
    public boolean tryAcquire(final long n, final TimeUnit timeUnit) {
        return this.tryAcquire(1, n, timeUnit);
    }
    
    public boolean tryAcquire(final int n) {
        return this.tryAcquire(n, 0L, TimeUnit.MICROSECONDS);
    }
    
    public boolean tryAcquire() {
        return this.tryAcquire(1, 0L, TimeUnit.MICROSECONDS);
    }
    
    public boolean tryAcquire(final int n, final long n2, final TimeUnit timeUnit) {
        final long max = Math.max(timeUnit.toMicros(n2), 0L);
        checkPermits(n);
        final long reserveAndGetWaitLength;
        synchronized (this.mutex()) {
            final long micros = this.stopwatch.readMicros();
            if (!this.canAcquire(micros, max)) {
                return false;
            }
            reserveAndGetWaitLength = this.reserveAndGetWaitLength(n, micros);
        }
        this.stopwatch.sleepMicrosUninterruptibly(reserveAndGetWaitLength);
        return true;
    }
    
    @GoogleInternal
    public boolean couldAcquire() {
        synchronized (this.mutex()) {
            return this.canAcquire(this.stopwatch.readMicros(), 0L);
        }
    }
    
    private boolean canAcquire(final long n, final long n2) {
        return this.queryEarliestAvailable(n) - n2 <= n;
    }
    
    final long reserveAndGetWaitLength(final int n, final long n2) {
        return Math.max(this.reserveEarliestAvailable(n, n2) - n2, 0L);
    }
    
    abstract long queryEarliestAvailable(final long p0);
    
    abstract long reserveEarliestAvailable(final int p0, final long p1);
    
    @GoogleInternal
    public void forceAcquire() {
        synchronized (this.mutex()) {
            this.doForceAcquire(this.stopwatch.readMicros());
        }
    }
    
    @GoogleInternal
    void doForceAcquire(final long n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", this.getRate());
    }
    
    private static int checkPermits(final int n) {
        Preconditions.checkArgument(n > 0, "Requested permits (%s) must be positive", n);
        return n;
    }
    
    @GoogleInternal
    public static RateLimiter createWithRequestAlignedBuckets(final int n, final int n2) {
        return createWithRequestAlignedBuckets(RateLimiter$SleepingStopwatch.createFromSystemTimer(), n, n2);
    }
    
    @GoogleInternal
    @VisibleForTesting
    static RateLimiter createWithRequestAlignedBuckets(final RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, final int n, final int n2) {
        Preconditions.checkArgument(n >= 0, "permitsPerBucket (%s) must be nonnegative", n);
        Preconditions.checkArgument(n2 >= 0, "periodInMillis (%s) must be nonnegative", n2);
        if (n == 0) {
            return new FixedDelayRateLimiter(rateLimiter$SleepingStopwatch, n2);
        }
        return new RequestAlignedBucketsRateLimiter(rateLimiter$SleepingStopwatch, n, n2);
    }
    
    @GoogleInternal
    public static RateLimiter createWithSecondGranularityHorizon(final int n, final int n2) {
        return createWithSecondGranularityHorizon(n, n2, RateLimiter$SleepingStopwatch.createFromSystemTimer());
    }
    
    @GoogleInternal
    @VisibleForTesting
    public static RateLimiter createWithSecondGranularityHorizon(final int n, final int n2, final Ticker ticker) {
        return createWithSecondGranularityHorizon(n, n2, createStopwatch(ticker));
    }
    
    @GoogleInternal
    @VisibleForTesting
    static RateLimiter createWithSecondGranularityHorizon(final int n, final int n2, final RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch) {
        return new SecondGranularityHorizonRateLimiter(rateLimiter$SleepingStopwatch, n, n2);
    }
    
    @GoogleInternal
    private static RateLimiter$SleepingStopwatch createStopwatch(final Ticker ticker) {
        return new RateLimiter$1(Stopwatch.createStarted(ticker));
    }
    
    @GoogleInternal
    static int microsToSec(final long n) {
        return (int)TimeUnit.MICROSECONDS.toSeconds(n);
    }
    
    @GoogleInternal
    static int roundedPermitsPerTime(final double n, final double n2) {
        final int roundToInt = DoubleMath.roundToInt(n * n2, RoundingMode.HALF_UP);
        Preconditions.checkArgument(roundToInt > 0, "underflow changing to rate %s over time %s", n, n2);
        return roundToInt;
    }
}
