package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.TrustedListenableFutureTask;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

@Beta
public abstract class AbstractListeningExecutorService extends AbstractExecutorService implements ListeningExecutorService {
   protected final RunnableFuture newTaskFor(Runnable var1, Object var2) {
      return TrustedListenableFutureTask.create(var1, var2);
   }

   protected final RunnableFuture newTaskFor(Callable var1) {
      return TrustedListenableFutureTask.create(var1);
   }

   public ListenableFuture submit(Runnable var1) {
      return (ListenableFuture)super.submit(var1);
   }

   public ListenableFuture submit(Runnable var1, @Nullable Object var2) {
      return (ListenableFuture)super.submit(var1, var2);
   }

   public ListenableFuture submit(Callable var1) {
      return (ListenableFuture)super.submit(var1);
   }
}
