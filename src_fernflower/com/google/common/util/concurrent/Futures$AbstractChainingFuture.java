package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.errorprone.annotations.ForOverride;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

abstract class Futures$AbstractChainingFuture extends AbstractFuture$TrustedFuture implements Runnable {
   @Nullable
   ListenableFuture inputFuture;
   @Nullable
   Object function;

   Futures$AbstractChainingFuture(ListenableFuture var1, Object var2) {
      this.inputFuture = (ListenableFuture)Preconditions.checkNotNull(var1);
      this.function = Preconditions.checkNotNull(var2);
   }

   public final void run() {
      try {
         ListenableFuture var1 = this.inputFuture;
         Object var2 = this.function;
         if(this.isCancelled() | var1 == null | var2 == null) {
            return;
         }

         this.inputFuture = null;
         this.function = null;

         Object var3;
         try {
            var3 = Uninterruptibles.getUninterruptibly(var1);
         } catch (CancellationException var5) {
            this.cancel(false);
            return;
         } catch (ExecutionException var6) {
            this.setException(var6.getCause());
            return;
         }

         this.doTransform(var2, var3);
      } catch (UndeclaredThrowableException var7) {
         this.setException(var7.getCause());
      } catch (Throwable var8) {
         this.setException(var8);
      }

   }

   @ForOverride
   abstract void doTransform(Object var1, Object var2);

   final void done() {
      this.maybePropagateCancellation(this.inputFuture);
      this.inputFuture = null;
      this.function = null;
   }
}
