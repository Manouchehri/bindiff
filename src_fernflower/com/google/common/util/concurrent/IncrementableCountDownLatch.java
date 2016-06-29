package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.IncrementableCountDownLatch$Sync;
import java.util.concurrent.TimeUnit;

@GoogleInternal
public final class IncrementableCountDownLatch {
   private final IncrementableCountDownLatch$Sync sync;

   public IncrementableCountDownLatch(int var1) {
      Preconditions.checkArgument(var1 >= 0, "count (%s) must be >= 0", new Object[]{Integer.valueOf(var1)});
      this.sync = new IncrementableCountDownLatch$Sync(var1);
   }

   public void await() {
      this.sync.acquireSharedInterruptibly(1);
   }

   public boolean await(long var1, TimeUnit var3) {
      return this.sync.tryAcquireSharedNanos(1, var3.toNanos(var1));
   }

   public void countDown() {
      this.sync.releaseShared(1);
   }

   public void increment() {
      this.sync.increaseCount(1);
   }

   public void increment(int var1) {
      Preconditions.checkArgument(var1 >= 0, "delta (%s) must be >= 0", new Object[]{Integer.valueOf(var1)});
      this.sync.increaseCount(var1);
   }

   public long getCount() {
      return (long)this.sync.getCount();
   }

   public String toString() {
      String var1 = String.valueOf(super.toString());
      int var2 = this.sync.getCount();
      return (new StringBuilder(21 + String.valueOf(var1).length())).append(var1).append("[Count = ").append(var2).append("]").toString();
   }
}
