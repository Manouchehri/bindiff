package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

final class ListenerCallQueue implements Runnable {
   private static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
   private final Object listener;
   private final Executor executor;
   @GuardedBy("this")
   private final Queue waitQueue = Queues.newArrayDeque();
   @GuardedBy("this")
   private boolean isThreadScheduled;

   ListenerCallQueue(Object var1, Executor var2) {
      this.listener = Preconditions.checkNotNull(var1);
      this.executor = (Executor)Preconditions.checkNotNull(var2);
   }

   synchronized void add(ListenerCallQueue$Callback var1) {
      this.waitQueue.add(var1);
   }

   void execute() {
      boolean var1 = false;
      synchronized(this) {
         if(!this.isThreadScheduled) {
            this.isThreadScheduled = true;
            var1 = true;
         }
      }

      if(var1) {
         try {
            this.executor.execute(this);
         } catch (RuntimeException var6) {
            synchronized(this) {
               this.isThreadScheduled = false;
            }

            Logger var10000 = logger;
            Level var10001 = Level.SEVERE;
            String var3 = String.valueOf(this.listener);
            String var4 = String.valueOf(this.executor);
            var10000.log(var10001, (new StringBuilder(42 + String.valueOf(var3).length() + String.valueOf(var4).length())).append("Exception while running callbacks for ").append(var3).append(" on ").append(var4).toString(), var6);
            throw var6;
         }
      }

   }

   public void run() {
      boolean var1 = true;

      while(true) {
         boolean var15 = false;

         try {
            var15 = true;
            ListenerCallQueue$Callback var2;
            synchronized(this) {
               Preconditions.checkState(this.isThreadScheduled);
               var2 = (ListenerCallQueue$Callback)this.waitQueue.poll();
               if(var2 == null) {
                  this.isThreadScheduled = false;
                  var1 = false;
                  var15 = false;
                  break;
               }
            }

            try {
               var2.call(this.listener);
            } catch (RuntimeException var18) {
               Logger var10000 = logger;
               Level var10001 = Level.SEVERE;
               String var4 = String.valueOf(this.listener);
               String var5 = ListenerCallQueue$Callback.access$000(var2);
               var10000.log(var10001, (new StringBuilder(37 + String.valueOf(var4).length() + String.valueOf(var5).length())).append("Exception while executing callback: ").append(var4).append(".").append(var5).toString(), var18);
            }
         } finally {
            if(var15) {
               if(var1) {
                  synchronized(this) {
                     this.isThreadScheduled = false;
                  }
               }

            }
         }
      }

      if(var1) {
         synchronized(this) {
            this.isThreadScheduled = false;
         }
      }

   }
}
