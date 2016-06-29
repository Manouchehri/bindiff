package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.Futures$ImmediateFuture;
import java.util.concurrent.ExecutionException;

class Futures$ImmediateFailedFuture extends Futures$ImmediateFuture {
   private final Throwable thrown;

   Futures$ImmediateFailedFuture(Throwable var1) {
      super((Futures$1)null);
      this.thrown = var1;
   }

   public Object get() {
      throw new ExecutionException(this.thrown);
   }
}
