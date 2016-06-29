package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ExecutionList;
import com.google.common.util.concurrent.ForwardingFuture;
import com.google.common.util.concurrent.JdkFutureAdapters$ListenableFutureAdapter$1;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

class JdkFutureAdapters$ListenableFutureAdapter extends ForwardingFuture implements ListenableFuture {
   private static final ThreadFactory threadFactory = (new ThreadFactoryBuilder()).setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
   private static final Executor defaultAdapterExecutor;
   private final Executor adapterExecutor;
   private final ExecutionList executionList;
   private final AtomicBoolean hasListeners;
   private final Future delegate;

   JdkFutureAdapters$ListenableFutureAdapter(Future var1) {
      this(var1, defaultAdapterExecutor);
   }

   JdkFutureAdapters$ListenableFutureAdapter(Future var1, Executor var2) {
      this.executionList = new ExecutionList();
      this.hasListeners = new AtomicBoolean(false);
      this.delegate = (Future)Preconditions.checkNotNull(var1);
      this.adapterExecutor = (Executor)Preconditions.checkNotNull(var2);
   }

   protected Future delegate() {
      return this.delegate;
   }

   public void addListener(Runnable var1, Executor var2) {
      this.executionList.add(var1, var2);
      if(this.hasListeners.compareAndSet(false, true)) {
         if(this.delegate.isDone()) {
            this.executionList.execute();
            return;
         }

         this.adapterExecutor.execute(new JdkFutureAdapters$ListenableFutureAdapter$1(this));
      }

   }

   // $FF: synthetic method
   static Future access$000(JdkFutureAdapters$ListenableFutureAdapter var0) {
      return var0.delegate;
   }

   // $FF: synthetic method
   static ExecutionList access$100(JdkFutureAdapters$ListenableFutureAdapter var0) {
      return var0.executionList;
   }

   static {
      defaultAdapterExecutor = Executors.newCachedThreadPool(threadFactory);
   }
}
