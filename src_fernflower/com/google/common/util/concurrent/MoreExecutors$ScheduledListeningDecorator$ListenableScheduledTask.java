package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ForwardingListenableFuture$SimpleForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask extends ForwardingListenableFuture$SimpleForwardingListenableFuture implements ListenableScheduledFuture {
   private final ScheduledFuture scheduledDelegate;

   public MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(ListenableFuture var1, ScheduledFuture var2) {
      super(var1);
      this.scheduledDelegate = var2;
   }

   public boolean cancel(boolean var1) {
      boolean var2 = super.cancel(var1);
      if(var2) {
         this.scheduledDelegate.cancel(var1);
      }

      return var2;
   }

   public long getDelay(TimeUnit var1) {
      return this.scheduledDelegate.getDelay(var1);
   }

   public int compareTo(Delayed var1) {
      return this.scheduledDelegate.compareTo(var1);
   }
}
