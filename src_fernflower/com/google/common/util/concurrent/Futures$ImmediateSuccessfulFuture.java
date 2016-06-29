package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.Futures$ImmediateFuture;
import javax.annotation.Nullable;

class Futures$ImmediateSuccessfulFuture extends Futures$ImmediateFuture {
   static final Futures$ImmediateSuccessfulFuture NULL = new Futures$ImmediateSuccessfulFuture((Object)null);
   @Nullable
   private final Object value;

   Futures$ImmediateSuccessfulFuture(@Nullable Object var1) {
      super((Futures$1)null);
      this.value = var1;
   }

   public Object get() {
      return this.value;
   }
}
