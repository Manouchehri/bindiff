package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Futures$TimeoutFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

final class Futures$TimeoutFuture$Fire implements Runnable {
   @Nullable
   Futures$TimeoutFuture timeoutFutureRef;

   Futures$TimeoutFuture$Fire(Futures$TimeoutFuture var1) {
      this.timeoutFutureRef = var1;
   }

   public void run() {
      Futures$TimeoutFuture var1 = this.timeoutFutureRef;
      if(var1 != null) {
         ListenableFuture var2 = var1.delegateRef;
         if(var2 != null) {
            this.timeoutFutureRef = null;
            if(var2.isDone()) {
               var1.setFuture(var2);
            } else {
               try {
                  String var3 = String.valueOf(var2);
                  var1.setException(new TimeoutException((new StringBuilder(18 + String.valueOf(var3).length())).append("Future timed out: ").append(var3).toString()));
               } finally {
                  var2.cancel(true);
               }
            }

         }
      }
   }
}
