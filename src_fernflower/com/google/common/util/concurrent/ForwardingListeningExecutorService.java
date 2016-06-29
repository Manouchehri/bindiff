package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ForwardingExecutorService;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;

public abstract class ForwardingListeningExecutorService extends ForwardingExecutorService implements ListeningExecutorService {
   protected abstract ListeningExecutorService delegate();

   public ListenableFuture submit(Callable var1) {
      return this.delegate().submit(var1);
   }

   public ListenableFuture submit(Runnable var1) {
      return this.delegate().submit(var1);
   }

   public ListenableFuture submit(Runnable var1, Object var2) {
      return this.delegate().submit(var1, var2);
   }
}
