package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.AbstractScheduledService$1$1;
import com.google.common.util.concurrent.AbstractScheduledService$1$2;
import com.google.common.util.concurrent.AbstractScheduledService$1$3;
import com.google.common.util.concurrent.AbstractScheduledService$1$Task;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;

class AbstractScheduledService$1 extends AbstractService {
   private volatile Future runningTask;
   private volatile ScheduledExecutorService executorService;
   private final ReentrantLock lock;
   private final Runnable task;
   // $FF: synthetic field
   final AbstractScheduledService this$0;

   AbstractScheduledService$1(AbstractScheduledService var1) {
      this.this$0 = var1;
      this.lock = new ReentrantLock();
      this.task = new AbstractScheduledService$1$Task(this);
   }

   protected final void doStart() {
      this.executorService = MoreExecutors.renamingDecorator((ScheduledExecutorService)this.this$0.executor(), new AbstractScheduledService$1$1(this));
      this.executorService.execute(new AbstractScheduledService$1$2(this));
   }

   protected final void doStop() {
      this.runningTask.cancel(false);
      this.executorService.execute(new AbstractScheduledService$1$3(this));
   }

   // $FF: synthetic method
   static ReentrantLock access$100(AbstractScheduledService$1 var0) {
      return var0.lock;
   }

   // $FF: synthetic method
   static Future access$200(AbstractScheduledService$1 var0) {
      return var0.runningTask;
   }

   // $FF: synthetic method
   static Future access$202(AbstractScheduledService$1 var0, Future var1) {
      return var0.runningTask = var1;
   }

   // $FF: synthetic method
   static ScheduledExecutorService access$500(AbstractScheduledService$1 var0) {
      return var0.executorService;
   }

   // $FF: synthetic method
   static Runnable access$600(AbstractScheduledService$1 var0) {
      return var0.task;
   }
}
