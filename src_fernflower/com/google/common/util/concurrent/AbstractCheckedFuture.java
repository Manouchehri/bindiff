package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture$SimpleForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Beta
public abstract class AbstractCheckedFuture extends ForwardingListenableFuture$SimpleForwardingListenableFuture implements CheckedFuture {
   protected AbstractCheckedFuture(ListenableFuture var1) {
      super(var1);
   }

   protected abstract Exception mapException(Exception var1);

   public Object checkedGet() {
      try {
         return this.get();
      } catch (InterruptedException var2) {
         Thread.currentThread().interrupt();
         throw this.mapException(var2);
      } catch (CancellationException var3) {
         throw this.mapException(var3);
      } catch (ExecutionException var4) {
         throw this.mapException(var4);
      }
   }

   public Object checkedGet(long var1, TimeUnit var3) {
      try {
         return this.get(var1, var3);
      } catch (InterruptedException var5) {
         Thread.currentThread().interrupt();
         throw this.mapException(var5);
      } catch (CancellationException var6) {
         throw this.mapException(var6);
      } catch (ExecutionException var7) {
         throw this.mapException(var7);
      }
   }
}
