/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@GwtCompatible(emulated=1)
abstract class AggregateFutureState {
    private static final AtomicReferenceFieldUpdater SEEN_EXCEPTIONS_UDPATER = AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions");
    private static final AtomicIntegerFieldUpdater REMAINING_COUNT_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining");
    private volatile Set seenExceptions = null;
    private volatile int remaining;

    AggregateFutureState(int n2) {
        this.remaining = n2;
    }

    final Set getOrInitSeenExceptions() {
        Set set = this.seenExceptions;
        if (set != null) return set;
        set = Sets.newConcurrentHashSet();
        this.addInitialException(set);
        SEEN_EXCEPTIONS_UDPATER.compareAndSet(this, null, set);
        return this.seenExceptions;
    }

    abstract void addInitialException(Set var1);

    final int decrementRemainingAndGet() {
        return REMAINING_COUNT_UPDATER.decrementAndGet(this);
    }
}

