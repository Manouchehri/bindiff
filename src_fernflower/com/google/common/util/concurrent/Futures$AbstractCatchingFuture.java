package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Platform;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

abstract class Futures$AbstractCatchingFuture extends AbstractFuture$TrustedFuture implements Runnable {
   @Nullable
   ListenableFuture inputFuture;
   @Nullable
   Class exceptionType;
   @Nullable
   Object fallback;

   Futures$AbstractCatchingFuture(ListenableFuture var1, Class var2, Object var3) {
      this.inputFuture = (ListenableFuture)Preconditions.checkNotNull(var1);
      this.exceptionType = (Class)Preconditions.checkNotNull(var2);
      this.fallback = Preconditions.checkNotNull(var3);
   }

   public final void run() {
      ListenableFuture var1 = this.inputFuture;
      Class var2 = this.exceptionType;
      Object var3 = this.fallback;
      if(!(var1 == null | var2 == null | var3 == null | this.isCancelled())) {
         this.inputFuture = null;
         this.exceptionType = null;
         this.fallback = null;

         Throwable var4;
         try {
            this.set(Uninterruptibles.getUninterruptibly(var1));
            return;
         } catch (ExecutionException var7) {
            var4 = var7.getCause();
         } catch (Throwable var8) {
            var4 = var8;
         }

         try {
            if(Platform.isInstanceOfThrowableClass(var4, var2)) {
               this.doFallback(var3, var4);
            } else {
               this.setException(var4);
            }
         } catch (Throwable var6) {
            this.setException(var6);
         }

      }
   }

   @ForOverride
   abstract void doFallback(Object var1, Throwable var2);

   final void done() {
      this.maybePropagateCancellation(this.inputFuture);
      this.inputFuture = null;
      this.exceptionType = null;
      this.fallback = null;
   }
}
