/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.IncrementableCountDownLatch$Sync;
import java.util.concurrent.TimeUnit;

@GoogleInternal
public final class IncrementableCountDownLatch {
    private final IncrementableCountDownLatch$Sync sync;

    public IncrementableCountDownLatch(int n2) {
        Preconditions.checkArgument(n2 >= 0, "count (%s) must be >= 0", n2);
        this.sync = new IncrementableCountDownLatch$Sync(n2);
    }

    public void await() {
        this.sync.acquireSharedInterruptibly(1);
    }

    public boolean await(long l2, TimeUnit timeUnit) {
        return this.sync.tryAcquireSharedNanos(1, timeUnit.toNanos(l2));
    }

    public void countDown() {
        this.sync.releaseShared(1);
    }

    public void increment() {
        this.sync.increaseCount(1);
    }

    public void increment(int n2) {
        Preconditions.checkArgument(n2 >= 0, "delta (%s) must be >= 0", n2);
        this.sync.increaseCount(n2);
    }

    public long getCount() {
        return this.sync.getCount();
    }

    public String toString() {
        String string = String.valueOf(super.toString());
        int n2 = this.sync.getCount();
        return new StringBuilder(21 + String.valueOf(string).length()).append(string).append("[Count = ").append(n2).append("]").toString();
    }
}

