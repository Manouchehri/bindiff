/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

@GoogleInternal
final class RequestAlignedBucketsRateLimiter
extends RateLimiter {
    private static final int NO_BUCKETS_CREATED_YET = -1;
    private long potentiallyAvailableBucketStartMicros;
    private int permitsAcquiredInBucket = -1;
    private int permitsPerBucket;
    private long periodInMicros;

    RequestAlignedBucketsRateLimiter(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, int n2, int n3) {
        super(rateLimiter$SleepingStopwatch);
        this.permitsPerBucket = n2;
        this.periodInMicros = TimeUnit.MILLISECONDS.toMicros(n3);
    }

    @Override
    void doSetRate(double d2, long l2) {
        double d3 = (double)this.periodInMicros / 1000000.0;
        this.permitsPerBucket = RequestAlignedBucketsRateLimiter.roundedPermitsPerTime(d2, d3);
    }

    @Override
    double doGetRate() {
        double d2 = (double)this.periodInMicros / 1000000.0;
        return (double)this.permitsPerBucket / d2;
    }

    @Override
    long queryEarliestAvailable(long l2) {
        return this.actuallyAvailableBucketStartMicros(l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    long reserveEarliestAvailable(int n2, long l2) {
        try {
            this.updatePotentialBucketToActual(l2);
            long l3 = this.potentiallyAvailableBucketStartMicros;
            return l3;
        }
        finally {
            this.consumePermitsAndBuckets(n2);
        }
    }

    private void updatePotentialBucketToActual(long l2) {
        long l3 = this.actuallyAvailableBucketStartMicros(l2);
        if (l3 == this.potentiallyAvailableBucketStartMicros) {
            if (this.permitsAcquiredInBucket != -1) return;
        }
        this.potentiallyAvailableBucketStartMicros = l3;
        this.permitsAcquiredInBucket = 0;
    }

    private long actuallyAvailableBucketStartMicros(long l2) {
        if (l2 - this.potentiallyAvailableBucketStartMicros > this.periodInMicros) return l2;
        if (this.permitsAcquiredInBucket == -1) {
            return l2;
        }
        if (this.permitsAcquiredInBucket + 1 <= this.permitsPerBucket) return this.potentiallyAvailableBucketStartMicros;
        return this.potentiallyAvailableBucketStartMicros + this.periodInMicros;
    }

    private void consumePermitsAndBuckets(int n2) {
        this.permitsAcquiredInBucket += n2;
        long l2 = LongMath.divide(this.permitsAcquiredInBucket, this.permitsPerBucket, RoundingMode.CEILING) - 1;
        this.potentiallyAvailableBucketStartMicros += l2 * this.periodInMicros;
        this.permitsAcquiredInBucket = (int)((long)this.permitsAcquiredInBucket - l2 * (long)this.permitsPerBucket);
    }
}

