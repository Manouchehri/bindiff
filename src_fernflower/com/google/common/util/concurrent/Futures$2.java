package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.Futures$2$1;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

final class Futures$2 implements Executor {
   volatile boolean thrownFromDelegate;
   // $FF: synthetic field
   final Executor val$delegate;
   // $FF: synthetic field
   final AbstractFuture val$future;

   Futures$2(Executor var1, AbstractFuture var2) {
      this.val$delegate = var1;
      this.val$future = var2;
      this.thrownFromDelegate = true;
   }

   public void execute(Runnable var1) {
      try {
         this.val$delegate.execute(new Futures$2$1(this, var1));
      } catch (RejectedExecutionException var3) {
         if(this.thrownFromDelegate) {
            this.val$future.setException(var3);
         }
      }

   }
}
