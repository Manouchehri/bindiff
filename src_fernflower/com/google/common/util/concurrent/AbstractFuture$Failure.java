package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture$Failure$1;

final class AbstractFuture$Failure {
   static final AbstractFuture$Failure FALLBACK_INSTANCE = new AbstractFuture$Failure(new AbstractFuture$Failure$1("Failure occurred while trying to finish a future."));
   final Throwable exception;

   AbstractFuture$Failure(Throwable var1) {
      this.exception = (Throwable)Preconditions.checkNotNull(var1);
   }
}
