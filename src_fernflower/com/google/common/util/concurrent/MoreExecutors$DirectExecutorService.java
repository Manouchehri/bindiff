package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.AbstractListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors$1;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

@GwtIncompatible("TODO")
class MoreExecutors$DirectExecutorService extends AbstractListeningExecutorService {
   private final Object lock;
   @GuardedBy("lock")
   private int runningTasks;
   @GuardedBy("lock")
   private boolean shutdown;

   private MoreExecutors$DirectExecutorService() {
      this.lock = new Object();
      this.runningTasks = 0;
      this.shutdown = false;
   }

   public void execute(Runnable var1) {
      this.startTask();

      try {
         var1.run();
      } finally {
         this.endTask();
      }

   }

   public boolean isShutdown() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         return this.shutdown;
      }
   }

   public void shutdown() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         this.shutdown = true;
         if(this.runningTasks == 0) {
            this.lock.notifyAll();
         }

      }
   }

   public List shutdownNow() {
      this.shutdown();
      return Collections.emptyList();
   }

   public boolean isTerminated() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         return this.shutdown && this.runningTasks == 0;
      }
   }

   public boolean awaitTermination(long var1, TimeUnit var3) {
      long var4 = var3.toNanos(var1);
      Object var6 = this.lock;
      synchronized(this.lock) {
         while(!this.shutdown || this.runningTasks != 0) {
            if(var4 <= 0L) {
               return false;
            }

            long var7 = System.nanoTime();
            TimeUnit.NANOSECONDS.timedWait(this.lock, var4);
            var4 -= System.nanoTime() - var7;
         }

         return true;
      }
   }

   private void startTask() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         if(this.shutdown) {
            throw new RejectedExecutionException("Executor already shutdown");
         } else {
            ++this.runningTasks;
         }
      }
   }

   private void endTask() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         int var2 = --this.runningTasks;
         if(var2 == 0) {
            this.lock.notifyAll();
         }

      }
   }

   // $FF: synthetic method
   MoreExecutors$DirectExecutorService(MoreExecutors$1 var1) {
      this();
   }
}
