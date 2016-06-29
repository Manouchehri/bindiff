package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.Futures$ImmediateFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@GwtIncompatible("TODO")
class Futures$ImmediateFailedCheckedFuture extends Futures$ImmediateFuture implements CheckedFuture {
   private final Exception thrown;

   Futures$ImmediateFailedCheckedFuture(Exception var1) {
      super((Futures$1)null);
      this.thrown = var1;
   }

   public Object get() {
      throw new ExecutionException(this.thrown);
   }

   public Object checkedGet() {
      throw this.thrown;
   }

   public Object checkedGet(long var1, TimeUnit var3) {
      Preconditions.checkNotNull(var3);
      throw this.thrown;
   }
}
