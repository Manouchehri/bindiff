package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.ExecutionException;

final class Futures$6 implements Runnable {
   // $FF: synthetic field
   final ListenableFuture val$future;
   // $FF: synthetic field
   final FutureCallback val$callback;

   Futures$6(ListenableFuture var1, FutureCallback var2) {
      this.val$future = var1;
      this.val$callback = var2;
   }

   public void run() {
      Object var1;
      try {
         var1 = Uninterruptibles.getUninterruptibly(this.val$future);
      } catch (ExecutionException var3) {
         this.val$callback.onFailure(var3.getCause());
         return;
      } catch (RuntimeException var4) {
         this.val$callback.onFailure(var4);
         return;
      } catch (Error var5) {
         this.val$callback.onFailure(var5);
         return;
      }

      this.val$callback.onSuccess(var1);
   }
}
