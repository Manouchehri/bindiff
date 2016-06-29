package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.SerializingExecutor$1;
import com.google.common.util.concurrent.SerializingExecutor$QueueWorker;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

public final class SerializingExecutor implements Executor {
   private static final Logger log = Logger.getLogger(SerializingExecutor.class.getName());
   private final Executor executor;
   @GuardedBy("internalLock")
   private final Deque queue = new ArrayDeque();
   @GuardedBy("internalLock")
   private boolean isWorkerRunning = false;
   @GuardedBy("internalLock")
   private int suspensions = 0;
   private final Object internalLock = new Object();

   public SerializingExecutor(Executor var1) {
      this.executor = (Executor)Preconditions.checkNotNull(var1);
   }

   public void execute(Runnable var1) {
      Object var2 = this.internalLock;
      synchronized(this.internalLock) {
         this.queue.add(var1);
      }

      this.startQueueWorker();
   }

   public void executeFirst(Runnable var1) {
      Object var2 = this.internalLock;
      synchronized(this.internalLock) {
         this.queue.addFirst(var1);
      }

      this.startQueueWorker();
   }

   public void suspend() {
      Object var1 = this.internalLock;
      synchronized(this.internalLock) {
         ++this.suspensions;
      }
   }

   public void resume() {
      Object var1 = this.internalLock;
      synchronized(this.internalLock) {
         Preconditions.checkState(this.suspensions > 0);
         --this.suspensions;
      }

      this.startQueueWorker();
   }

   private void startQueueWorker() {
      Object var1 = this.internalLock;
      synchronized(this.internalLock) {
         if(this.queue.peek() == null) {
            return;
         }

         if(this.suspensions > 0) {
            return;
         }

         if(this.isWorkerRunning) {
            return;
         }

         this.isWorkerRunning = true;
      }

      boolean var16 = true;
      boolean var11 = false;

      try {
         var11 = true;
         this.executor.execute(new SerializingExecutor$QueueWorker(this, (SerializingExecutor$1)null));
         var16 = false;
         var11 = false;
      } finally {
         if(var11) {
            if(var16) {
               Object var5 = this.internalLock;
               synchronized(this.internalLock) {
                  this.isWorkerRunning = false;
               }
            }

         }
      }

      if(var16) {
         Object var2 = this.internalLock;
         synchronized(this.internalLock) {
            this.isWorkerRunning = false;
         }
      }

   }

   // $FF: synthetic method
   static Object access$100(SerializingExecutor var0) {
      return var0.internalLock;
   }

   // $FF: synthetic method
   static boolean access$202(SerializingExecutor var0, boolean var1) {
      return var0.isWorkerRunning = var1;
   }

   // $FF: synthetic method
   static int access$300(SerializingExecutor var0) {
      return var0.suspensions;
   }

   // $FF: synthetic method
   static Deque access$400(SerializingExecutor var0) {
      return var0.queue;
   }

   // $FF: synthetic method
   static Logger access$500() {
      return log;
   }
}
