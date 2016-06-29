package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.Futures$ImmediateFuture;
import java.util.concurrent.CancellationException;

@GwtIncompatible("TODO")
class Futures$ImmediateCancelledFuture extends Futures$ImmediateFuture {
   private final CancellationException thrown = new CancellationException("Immediate cancelled future.");

   Futures$ImmediateCancelledFuture() {
      super((Futures$1)null);
   }

   public boolean isCancelled() {
      return true;
   }

   public Object get() {
      throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", this.thrown);
   }
}
