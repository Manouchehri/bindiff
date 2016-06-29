package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;

final class AbstractFuture$Cancellation {
   final boolean wasInterrupted;
   final Throwable cause;

   AbstractFuture$Cancellation(boolean var1, Throwable var2) {
      this.wasInterrupted = var1;
      this.cause = (Throwable)Preconditions.checkNotNull(var2);
   }
}
