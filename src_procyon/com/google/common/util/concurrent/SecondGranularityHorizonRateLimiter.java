package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import it.unimi.dsi.fastutil.ints.*;
import com.google.common.base.*;
import java.util.concurrent.*;
import com.google.common.collect.*;
import java.util.*;

@GoogleInternal
final class SecondGranularityHorizonRateLimiter extends RateLimiter
{
    private int permitsWithinHorizon;
    private final int horizonSec;
    private final IntArrayList permitGrantsSec;
    private Integer latestPermitGrantSec;
    
    SecondGranularityHorizonRateLimiter(final RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, final int n, final int horizonSec) {
        super(rateLimiter$SleepingStopwatch);
        this.permitGrantsSec = new IntArrayList();
        this.doSetPermitsWithinHorizon(n);
        Preconditions.checkArgument(horizonSec > 0, "horizonSec (%s) must be positive", horizonSec);
        this.horizonSec = horizonSec;
    }
    
    @Override
    void doSetRate(final double n, final long n2) {
        this.permitsWithinHorizon = RateLimiter.roundedPermitsPerTime(n, this.horizonSec);
    }
    
    @Override
    double doGetRate() {
        return this.permitsWithinHorizon / this.horizonSec;
    }
    
    @Override
    long queryEarliestAvailable(final long n) {
        return TimeUnit.SECONDS.toMicros(this.nextAvailableTimeSec(RateLimiter.microsToSec(n)));
    }
    
    @Override
    long reserveEarliestAvailable(final int n, final long n2) {
        final int nextAvailableTimeSec = this.nextAvailableTimeSec(RateLimiter.microsToSec(n2));
        this.recordGrants(n, nextAvailableTimeSec);
        return TimeUnit.SECONDS.toMicros(nextAvailableTimeSec);
    }
    
    private int nextAvailableTimeSec(final int n) {
        this.pruneEvents(n);
        return (this.permitGrantsSec.size() < this.permitsWithinHorizon) ? n : (this.permitGrantsSec.getInt(this.permitGrantsSec.size() - this.permitsWithinHorizon) + this.horizonSec);
    }
    
    private void pruneEvents(final int n) {
        this.permitGrantsSec.removeElements(0, SortedLists.binarySearch((List)this.permitGrantsSec, n - this.horizonSec, SortedLists$KeyPresentBehavior.FIRST_AFTER, SortedLists$KeyAbsentBehavior.NEXT_HIGHER));
    }
    
    @Override
    int doLatestPermitAgeSec(final long n) {
        Preconditions.checkState(this.latestPermitGrantSec != null, (Object)"No permits have been granted yet");
        return RateLimiter.microsToSec(n) - this.latestPermitGrantSec;
    }
    
    @Override
    void doForceAcquire(final long n) {
        this.recordGrants(1, RateLimiter.microsToSec(n));
    }
    
    private void recordGrants(final int n, final int n2) {
        for (int i = 0; i < n; ++i) {
            this.permitGrantsSec.add(n2);
        }
        this.latestPermitGrantSec = n2;
    }
    
    @Override
    void doSetPermitsWithinHorizon(final int permitsWithinHorizon) {
        Preconditions.checkArgument(permitsWithinHorizon > 0, "permitsWithinHorizon (%s) must be positive", permitsWithinHorizon);
        this.permitsWithinHorizon = permitsWithinHorizon;
    }
}
