package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

final class Futures$TimeoutFuture extends AbstractFuture$TrustedFuture {
   @Nullable
   ListenableFuture delegateRef;
   @Nullable
   Future timer;

   Futures$TimeoutFuture(ListenableFuture var1) {
      this.delegateRef = (ListenableFuture)Preconditions.checkNotNull(var1);
   }

   void done() {
      this.maybePropagateCancellation(this.delegateRef);
      Future var1 = this.timer;
      if(var1 != null) {
         var1.cancel(false);
      }

      this.delegateRef = null;
      this.timer = null;
   }
}
