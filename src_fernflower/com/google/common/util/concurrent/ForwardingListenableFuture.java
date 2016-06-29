package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ForwardingFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public abstract class ForwardingListenableFuture extends ForwardingFuture implements ListenableFuture {
   protected abstract ListenableFuture delegate();

   public void addListener(Runnable var1, Executor var2) {
      this.delegate().addListener(var1, var2);
   }
}
