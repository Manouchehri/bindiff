package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.Futures$ImmediateFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GwtIncompatible("TODO")
class Futures$ImmediateSuccessfulCheckedFuture extends Futures$ImmediateFuture implements CheckedFuture {
   @Nullable
   private final Object value;

   Futures$ImmediateSuccessfulCheckedFuture(@Nullable Object var1) {
      super((Futures$1)null);
      this.value = var1;
   }

   public Object get() {
      return this.value;
   }

   public Object checkedGet() {
      return this.value;
   }

   public Object checkedGet(long var1, TimeUnit var3) {
      Preconditions.checkNotNull(var3);
      return this.value;
   }
}
