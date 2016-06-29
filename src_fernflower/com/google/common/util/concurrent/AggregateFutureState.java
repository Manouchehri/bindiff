package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@GwtCompatible(
   emulated = true
)
abstract class AggregateFutureState {
   private static final AtomicReferenceFieldUpdater SEEN_EXCEPTIONS_UDPATER = AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions");
   private static final AtomicIntegerFieldUpdater REMAINING_COUNT_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining");
   private volatile Set seenExceptions = null;
   private volatile int remaining;

   AggregateFutureState(int var1) {
      this.remaining = var1;
   }

   final Set getOrInitSeenExceptions() {
      Set var1 = this.seenExceptions;
      if(var1 == null) {
         var1 = Sets.newConcurrentHashSet();
         this.addInitialException(var1);
         SEEN_EXCEPTIONS_UDPATER.compareAndSet(this, (Object)null, var1);
         var1 = this.seenExceptions;
      }

      return var1;
   }

   abstract void addInitialException(Set var1);

   final int decrementRemainingAndGet() {
      return REMAINING_COUNT_UPDATER.decrementAndGet(this);
   }
}
