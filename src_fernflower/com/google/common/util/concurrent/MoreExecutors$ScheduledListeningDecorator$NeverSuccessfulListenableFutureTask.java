package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractFuture;

@GwtIncompatible("TODO")
final class MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask extends AbstractFuture implements Runnable {
   private final Runnable delegate;

   public MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask(Runnable var1) {
      this.delegate = (Runnable)Preconditions.checkNotNull(var1);
   }

   public void run() {
      try {
         this.delegate.run();
      } catch (Throwable var2) {
         this.setException(var2);
         throw Throwables.propagate(var2);
      }
   }
}
