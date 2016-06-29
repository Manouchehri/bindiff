/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.IntArrayList
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.collect.SortedLists;
import com.google.common.collect.SortedLists$KeyAbsentBehavior;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@GoogleInternal
final class SecondGranularityHorizonRateLimiter
extends RateLimiter {
    private int permitsWithinHorizon;
    private final int horizonSec;
    private final IntArrayList permitGrantsSec = new IntArrayList();
    private Integer latestPermitGrantSec;

    SecondGranularityHorizonRateLimiter(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, int n2, int n3) {
        super(rateLimiter$SleepingStopwatch);
        this.doSetPermitsWithinHorizon(n2);
        Preconditions.checkArgument(n3 > 0, "horizonSec (%s) must be positive", n3);
        this.horizonSec = n3;
    }

    @Override
    void doSetRate(double d2, long l2) {
        this.permitsWithinHorizon = SecondGranularityHorizonRateLimiter.roundedPermitsPerTime(d2, this.horizonSec);
    }

    @Override
    double doGetRate() {
        return (double)this.permitsWithinHorizon / (double)this.horizonSec;
    }

    @Override
    long queryEarliestAvailable(long l2) {
        int n2 = SecondGranularityHorizonRateLimiter.microsToSec(l2);
        int n3 = this.nextAvailableTimeSec(n2);
        return TimeUnit.SECONDS.toMicros(n3);
    }

    @Override
    long reserveEarliestAvailable(int n2, long l2) {
        int n3 = SecondGranularityHorizonRateLimiter.microsToSec(l2);
        int n4 = this.nextAvailableTimeSec(n3);
        this.recordGrants(n2, n4);
        return TimeUnit.SECONDS.toMicros(n4);
    }

    private int nextAvailableTimeSec(int n2) {
        int n3;
        this.pruneEvents(n2);
        if (this.permitGrantsSec.size() < this.permitsWithinHorizon) {
            n3 = n2;
            return n3;
        }
        n3 = this.permitGrantsSec.getInt(this.permitGrantsSec.size() - this.permitsWithinHorizon) + this.horizonSec;
        return n3;
    }

    private void pruneEvents(int n2) {
        int n3 = n2 - this.horizonSec;
        int n4 = SortedLists.binarySearch((List)this.permitGrantsSec, Integer.valueOf(n3), SortedLists$KeyPresentBehavior.FIRST_AFTER, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
        this.permitGrantsSec.removeElements(0, n4);
    }

    @Override
    int doLatestPermitAgeSec(long l2) {
        Preconditions.checkState(this.latestPermitGrantSec != null, "No permits have been granted yet");
        int n2 = SecondGranularityHorizonRateLimiter.microsToSec(l2);
        return n2 - this.latestPermitGrantSec;
    }

    @Override
    void doForceAcquire(long l2) {
        int n2 = SecondGranularityHorizonRateLimiter.microsToSec(l2);
        this.recordGrants(1, n2);
    }

    private void recordGrants(int n2, int n3) {
        int n4 = 0;
        do {
            if (n4 >= n2) {
                this.latestPermitGrantSec = n3;
                return;
            }
            this.permitGrantsSec.add(n3);
            ++n4;
        } while (true);
    }

    @Override
    void doSetPermitsWithinHorizon(int n2) {
        Preconditions.checkArgument(n2 > 0, "permitsWithinHorizon (%s) must be positive", n2);
        this.permitsWithinHorizon = n2;
    }
}

