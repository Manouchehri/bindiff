package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.atomic.*;
import java.util.*;
import com.google.common.collect.*;

@GwtCompatible(emulated = true)
abstract class AggregateFutureState
{
    private static final AtomicReferenceFieldUpdater SEEN_EXCEPTIONS_UDPATER;
    private static final AtomicIntegerFieldUpdater REMAINING_COUNT_UPDATER;
    private volatile Set seenExceptions;
    private volatile int remaining;
    
    AggregateFutureState(final int remaining) {
        this.seenExceptions = null;
        this.remaining = remaining;
    }
    
    final Set getOrInitSeenExceptions() {
        Set set = this.seenExceptions;
        if (set == null) {
            final Set concurrentHashSet = Sets.newConcurrentHashSet();
            this.addInitialException(concurrentHashSet);
            AggregateFutureState.SEEN_EXCEPTIONS_UDPATER.compareAndSet(this, null, concurrentHashSet);
            set = this.seenExceptions;
        }
        return set;
    }
    
    abstract void addInitialException(final Set p0);
    
    final int decrementRemainingAndGet() {
        return AggregateFutureState.REMAINING_COUNT_UPDATER.decrementAndGet(this);
    }
    
    static {
        SEEN_EXCEPTIONS_UDPATER = AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions");
        REMAINING_COUNT_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining");
    }
}
