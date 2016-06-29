/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.ThreadSafe
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.math.DoubleMath;
import com.google.common.util.concurrent.FixedDelayRateLimiter;
import com.google.common.util.concurrent.RateLimiter$1;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.RequestAlignedBucketsRateLimiter;
import com.google.common.util.concurrent.SecondGranularityHorizonRateLimiter;
import com.google.common.util.concurrent.SmoothRateLimiter$SmoothBursty;
import com.google.common.util.concurrent.SmoothRateLimiter$SmoothWarmingUp;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Beta
public abstract class RateLimiter {
    private final RateLimiter$SleepingStopwatch stopwatch;
    private volatile Object mutexDoNotUseDirectly;

    public static RateLimiter create(double d2) {
        return RateLimiter.create(RateLimiter$SleepingStopwatch.createFromSystemTimer(), d2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @GoogleInternal
    public final int latestPermitAgeSec() {
        Object object = this.mutex();
        synchronized (object) {
            return this.doLatestPermitAgeSec(this.stopwatch.readMicros());
        }
    }

    @GoogleInternal
    int doLatestPermitAgeSec(long l2) {
        throw new UnsupportedOperationException();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @GoogleInternal
    public final void setPermitsWithinHorizon(int n2) {
        Object object = this.mutex();
        synchronized (object) {
            this.doSetPermitsWithinHorizon(n2);
            return;
        }
    }

    @GoogleInternal
    void doSetPermitsWithinHorizon(int n2) {
        throw new UnsupportedOperationException();
    }

    @VisibleForTesting
    static RateLimiter create(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, double d2) {
        SmoothRateLimiter$SmoothBursty smoothRateLimiter$SmoothBursty = new SmoothRateLimiter$SmoothBursty(rateLimiter$SleepingStopwatch, 1.0);
        smoothRateLimiter$SmoothBursty.setRate(d2);
        return smoothRateLimiter$SmoothBursty;
    }

    public static RateLimiter create(double d2, long l2, TimeUnit timeUnit) {
        Preconditions.checkArgument(l2 >= 0, "warmupPeriod must not be negative: %s", l2);
        return RateLimiter.create(RateLimiter$SleepingStopwatch.createFromSystemTimer(), d2, l2, timeUnit, 3.0);
    }

    @GoogleInternal
    public static RateLimiter create(double d2, long l2, TimeUnit timeUnit, double d3) {
        Preconditions.checkArgument(l2 >= 0, "warmupPeriod must not be negative: %s", l2);
        Preconditions.checkArgument(d3 >= 1.0, "coldFactor must be >= 1.0: %s", d3);
        return RateLimiter.create(RateLimiter$SleepingStopwatch.createFromSystemTimer(), d2, l2, timeUnit, d3);
    }

    @VisibleForTesting
    static RateLimiter create(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, double d2, long l2, TimeUnit timeUnit, double d3) {
        SmoothRateLimiter$SmoothWarmingUp smoothRateLimiter$SmoothWarmingUp = new SmoothRateLimiter$SmoothWarmingUp(rateLimiter$SleepingStopwatch, l2, timeUnit, d3);
        smoothRateLimiter$SmoothWarmingUp.setRate(d2);
        return smoothRateLimiter$SmoothWarmingUp;
    }

    @GoogleInternal
    public static RateLimiter createWithCapacity(double d2, long l2, TimeUnit timeUnit) {
        return RateLimiter.createWithCapacity(RateLimiter$SleepingStopwatch.createFromSystemTimer(), d2, l2, timeUnit);
    }

    @GoogleInternal
    @VisibleForTesting
    static RateLimiter createWithCapacity(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, double d2, long l2, TimeUnit timeUnit) {
        Preconditions.checkArgument(l2 >= 0, "maxBurstBuildup must not be negative: %s", l2);
        double d3 = (double)timeUnit.toNanos(l2) / 1.0E9;
        SmoothRateLimiter$SmoothBursty smoothRateLimiter$SmoothBursty = new SmoothRateLimiter$SmoothBursty(rateLimiter$SleepingStopwatch, d3);
        smoothRateLimiter$SmoothBursty.setRate(d2);
        return smoothRateLimiter$SmoothBursty;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Object mutex() {
        Object object = this.mutexDoNotUseDirectly;
        if (object != null) return object;
        RateLimiter rateLimiter = this;
        synchronized (rateLimiter) {
            object = this.mutexDoNotUseDirectly;
            if (object != null) return object;
            this.mutexDoNotUseDirectly = object = new Object();
            return object;
        }
    }

    RateLimiter(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch) {
        this.stopwatch = (RateLimiter$SleepingStopwatch)Preconditions.checkNotNull(rateLimiter$SleepingStopwatch);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void setRate(double d2) {
        Preconditions.checkArgument(d2 > 0.0 && !Double.isNaN(d2), "rate must be positive");
        Object object = this.mutex();
        synchronized (object) {
            this.doSetRate(d2, this.stopwatch.readMicros());
            return;
        }
    }

    abstract void doSetRate(double var1, long var3);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final double getRate() {
        Object object = this.mutex();
        synchronized (object) {
            return this.doGetRate();
        }
    }

    abstract double doGetRate();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @GoogleInternal
    public int getAvailablePermits() {
        Object object = this.mutex();
        synchronized (object) {
            return this.doGetAvailablePermits(this.stopwatch.readMicros());
        }
    }

    @GoogleInternal
    int doGetAvailablePermits(long l2) {
        return 0;
    }

    public double acquire() {
        return this.acquire(1);
    }

    public double acquire(int n2) {
        long l2 = this.reserve(n2);
        this.stopwatch.sleepMicrosUninterruptibly(l2);
        return 1.0 * (double)l2 / (double)TimeUnit.SECONDS.toMicros(1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final long reserve(int n2) {
        RateLimiter.checkPermits(n2);
        Object object = this.mutex();
        synchronized (object) {
            return this.reserveAndGetWaitLength(n2, this.stopwatch.readMicros());
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

    public boolean tryAcquire(long l2, TimeUnit timeUnit) {
        return this.tryAcquire(1, l2, timeUnit);
    }

    public boolean tryAcquire(int n2) {
        return this.tryAcquire(n2, 0, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire() {
        return this.tryAcquire(1, 0, TimeUnit.MICROSECONDS);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean tryAcquire(int n2, long l2, TimeUnit timeUnit) {
        long l3;
        long l4 = Math.max(timeUnit.toMicros(l2), 0);
        RateLimiter.checkPermits(n2);
        Object object = this.mutex();
        synchronized (object) {
            long l5 = this.stopwatch.readMicros();
            if (!this.canAcquire(l5, l4)) {
                return false;
            }
            l3 = this.reserveAndGetWaitLength(n2, l5);
        }
        this.stopwatch.sleepMicrosUninterruptibly(l3);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @GoogleInternal
    public boolean couldAcquire() {
        Object object = this.mutex();
        synchronized (object) {
            long l2 = this.stopwatch.readMicros();
            return this.canAcquire(l2, 0);
        }
    }

    private boolean canAcquire(long l2, long l3) {
        if (this.queryEarliestAvailable(l2) - l3 > l2) return false;
        return true;
    }

    final long reserveAndGetWaitLength(int n2, long l2) {
        long l3 = this.reserveEarliestAvailable(n2, l2);
        return Math.max(l3 - l2, 0);
    }

    abstract long queryEarliestAvailable(long var1);

    abstract long reserveEarliestAvailable(int var1, long var2);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @GoogleInternal
    public void forceAcquire() {
        Object object = this.mutex();
        synchronized (object) {
            long l2 = this.stopwatch.readMicros();
            this.doForceAcquire(l2);
            return;
        }
    }

    @GoogleInternal
    void doForceAcquire(long l2) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", this.getRate());
    }

    private static int checkPermits(int n2) {
        Preconditions.checkArgument(n2 > 0, "Requested permits (%s) must be positive", n2);
        return n2;
    }

    @GoogleInternal
    public static RateLimiter createWithRequestAlignedBuckets(int n2, int n3) {
        return RateLimiter.createWithRequestAlignedBuckets(RateLimiter$SleepingStopwatch.createFromSystemTimer(), n2, n3);
    }

    @GoogleInternal
    @VisibleForTesting
    static RateLimiter createWithRequestAlignedBuckets(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, int n2, int n3) {
        Preconditions.checkArgument(n2 >= 0, "permitsPerBucket (%s) must be nonnegative", n2);
        Preconditions.checkArgument(n3 >= 0, "periodInMillis (%s) must be nonnegative", n3);
        if (n2 != 0) return new RequestAlignedBucketsRateLimiter(rateLimiter$SleepingStopwatch, n2, n3);
        return new FixedDelayRateLimiter(rateLimiter$SleepingStopwatch, n3);
    }

    @GoogleInternal
    public static RateLimiter createWithSecondGranularityHorizon(int n2, int n3) {
        return RateLimiter.createWithSecondGranularityHorizon(n2, n3, RateLimiter$SleepingStopwatch.createFromSystemTimer());
    }

    @GoogleInternal
    @VisibleForTesting
    public static RateLimiter createWithSecondGranularityHorizon(int n2, int n3, Ticker ticker) {
        return RateLimiter.createWithSecondGranularityHorizon(n2, n3, RateLimiter.createStopwatch(ticker));
    }

    @GoogleInternal
    @VisibleForTesting
    static RateLimiter createWithSecondGranularityHorizon(int n2, int n3, RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch) {
        return new SecondGranularityHorizonRateLimiter(rateLimiter$SleepingStopwatch, n2, n3);
    }

    @GoogleInternal
    private static RateLimiter$SleepingStopwatch createStopwatch(Ticker ticker) {
        Stopwatch stopwatch = Stopwatch.createStarted(ticker);
        return new RateLimiter$1(stopwatch);
    }

    @GoogleInternal
    static int microsToSec(long l2) {
        return (int)TimeUnit.MICROSECONDS.toSeconds(l2);
    }

    @GoogleInternal
    static int roundedPermitsPerTime(double d2, double d3) {
        int n2 = DoubleMath.roundToInt(d2 * d3, RoundingMode.HALF_UP);
        Preconditions.checkArgument(n2 > 0, "underflow changing to rate %s over time %s", d2, d3);
        return n2;
    }
}

