package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingObject;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class ForwardingExecutorService extends ForwardingObject implements ExecutorService {
   protected abstract ExecutorService delegate();

   public boolean awaitTermination(long var1, TimeUnit var3) {
      return this.delegate().awaitTermination(var1, var3);
   }

   public List invokeAll(Collection var1) {
      return this.delegate().invokeAll(var1);
   }

   public List invokeAll(Collection var1, long var2, TimeUnit var4) {
      return this.delegate().invokeAll(var1, var2, var4);
   }

   public Object invokeAny(Collection var1) {
      return this.delegate().invokeAny(var1);
   }

   public Object invokeAny(Collection var1, long var2, TimeUnit var4) {
      return this.delegate().invokeAny(var1, var2, var4);
   }

   public boolean isShutdown() {
      return this.delegate().isShutdown();
   }

   public boolean isTerminated() {
      return this.delegate().isTerminated();
   }

   public void shutdown() {
      this.delegate().shutdown();
   }

   public List shutdownNow() {
      return this.delegate().shutdownNow();
   }

   public void execute(Runnable var1) {
      this.delegate().execute(var1);
   }

   public Future submit(Callable var1) {
      return this.delegate().submit(var1);
   }

   public Future submit(Runnable var1) {
      return this.delegate().submit(var1);
   }

   public Future submit(Runnable var1, Object var2) {
      return this.delegate().submit(var1, var2);
   }
}
