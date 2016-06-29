package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService$CustomScheduler;
import com.google.common.util.concurrent.AbstractScheduledService$CustomScheduler$Schedule;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.ForwardingFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

class AbstractScheduledService$CustomScheduler$ReschedulableCallable extends ForwardingFuture implements Callable {
   private final Runnable wrappedRunnable;
   private final ScheduledExecutorService executor;
   private final AbstractService service;
   private final ReentrantLock lock;
   @GuardedBy("lock")
   private Future currentFuture;
   // $FF: synthetic field
   final AbstractScheduledService$CustomScheduler this$0;

   AbstractScheduledService$CustomScheduler$ReschedulableCallable(AbstractScheduledService$CustomScheduler var1, AbstractService var2, ScheduledExecutorService var3, Runnable var4) {
      this.this$0 = var1;
      this.lock = new ReentrantLock();
      this.wrappedRunnable = var4;
      this.executor = var3;
      this.service = var2;
   }

   public Void call() {
      this.wrappedRunnable.run();
      this.reschedule();
      return null;
   }

   public void reschedule() {
      AbstractScheduledService$CustomScheduler$Schedule var1;
      try {
         var1 = this.this$0.getNextSchedule();
      } catch (Throwable var8) {
         this.service.notifyFailed(var8);
         return;
      }

      Throwable var2 = null;
      this.lock.lock();

      try {
         if(this.currentFuture == null || !this.currentFuture.isCancelled()) {
            this.currentFuture = this.executor.schedule(this, AbstractScheduledService$CustomScheduler$Schedule.access$700(var1), AbstractScheduledService$CustomScheduler$Schedule.access$800(var1));
         }
      } catch (Throwable var9) {
         var2 = var9;
      } finally {
         this.lock.unlock();
      }

      if(var2 != null) {
         this.service.notifyFailed(var2);
      }

   }

   public boolean cancel(boolean var1) {
      this.lock.lock();

      boolean var2;
      try {
         var2 = this.currentFuture.cancel(var1);
      } finally {
         this.lock.unlock();
      }

      return var2;
   }

   public boolean isCancelled() {
      this.lock.lock();

      boolean var1;
      try {
         var1 = this.currentFuture.isCancelled();
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   protected Future delegate() {
      throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
   }
}
