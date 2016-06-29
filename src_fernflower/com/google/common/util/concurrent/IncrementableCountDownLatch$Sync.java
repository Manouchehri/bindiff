package com.google.common.util.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

final class IncrementableCountDownLatch$Sync extends AbstractQueuedSynchronizer {
   private static final long serialVersionUID = 0L;

   IncrementableCountDownLatch$Sync(int var1) {
      this.setState(var1);
   }

   int getCount() {
      return this.getState();
   }

   public int tryAcquireShared(int var1) {
      return this.getState() == 0?1:-1;
   }

   public boolean tryReleaseShared(int var1) {
      int var2;
      int var3;
      do {
         var2 = this.getState();
         if(var2 == 0) {
            return false;
         }

         if(var1 > var2) {
            return false;
         }

         var3 = var2 - var1;
      } while(!this.compareAndSetState(var2, var3));

      return var3 == 0;
   }

   void increaseCount(int var1) {
      int var2;
      int var3;
      do {
         var2 = this.getState();
         var3 = var2 + var1;
         if(var2 == 0) {
            throw new IllegalStateException("already counted down to zero");
         }

         if(var3 < var2) {
            throw new IllegalArgumentException("count overflow");
         }
      } while(!this.compareAndSetState(var2, var3));

   }
}
