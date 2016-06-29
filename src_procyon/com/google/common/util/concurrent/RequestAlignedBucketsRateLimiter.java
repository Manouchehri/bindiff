package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.*;
import java.math.*;
import com.google.common.math.*;

@GoogleInternal
final class RequestAlignedBucketsRateLimiter extends RateLimiter
{
    private static final int NO_BUCKETS_CREATED_YET = -1;
    private long potentiallyAvailableBucketStartMicros;
    private int permitsAcquiredInBucket;
    private int permitsPerBucket;
    private long periodInMicros;
    
    RequestAlignedBucketsRateLimiter(final RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, final int permitsPerBucket, final int n) {
        super(rateLimiter$SleepingStopwatch);
        this.permitsAcquiredInBucket = -1;
        this.permitsPerBucket = permitsPerBucket;
        this.periodInMicros = TimeUnit.MILLISECONDS.toMicros(n);
    }
    
    @Override
    void doSetRate(final double n, final long n2) {
        this.permitsPerBucket = RateLimiter.roundedPermitsPerTime(n, this.periodInMicros / 1000000.0);
    }
    
    @Override
    double doGetRate() {
        return this.permitsPerBucket / (this.periodInMicros / 1000000.0);
    }
    
    @Override
    long queryEarliestAvailable(final long n) {
        return this.actuallyAvailableBucketStartMicros(n);
    }
    
    @Override
    long reserveEarliestAvailable(final int n, final long n2) {
        try {
            this.updatePotentialBucketToActual(n2);
            return this.potentiallyAvailableBucketStartMicros;
        }
        finally {
            this.consumePermitsAndBuckets(n);
        }
    }
    
    private void updatePotentialBucketToActual(final long n) {
        final long actuallyAvailableBucketStartMicros = this.actuallyAvailableBucketStartMicros(n);
        if (actuallyAvailableBucketStartMicros != this.potentiallyAvailableBucketStartMicros || this.permitsAcquiredInBucket == -1) {
            this.potentiallyAvailableBucketStartMicros = actuallyAvailableBucketStartMicros;
            this.permitsAcquiredInBucket = 0;
        }
    }
    
    private long actuallyAvailableBucketStartMicros(final long n) {
        if (n - this.potentiallyAvailableBucketStartMicros > this.periodInMicros || this.permitsAcquiredInBucket == -1) {
            return n;
        }
        if (this.permitsAcquiredInBucket + 1 > this.permitsPerBucket) {
            return this.potentiallyAvailableBucketStartMicros + this.periodInMicros;
        }
        return this.potentiallyAvailableBucketStartMicros;
    }
    
    private void consumePermitsAndBuckets(final int n) {
        this.permitsAcquiredInBucket += n;
        final long n2 = LongMath.divide(this.permitsAcquiredInBucket, this.permitsPerBucket, RoundingMode.CEILING) - 1L;
        this.potentiallyAvailableBucketStartMicros += n2 * this.periodInMicros;
        this.permitsAcquiredInBucket -= (int)(n2 * this.permitsPerBucket);
    }
}
