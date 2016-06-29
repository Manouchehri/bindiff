package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SerializingExecutor;
import com.google.common.util.concurrent.SerializingExecutor$1;
import java.util.logging.Level;
import java.util.logging.Logger;

class SerializingExecutor$QueueWorker implements Runnable {
   // $FF: synthetic field
   final SerializingExecutor this$0;

   private SerializingExecutor$QueueWorker(SerializingExecutor var1) {
      this.this$0 = var1;
   }

   public void run() {
      try {
         this.workOnQueue();
      } catch (Error var5) {
         synchronized(SerializingExecutor.access$100(this.this$0)) {
            SerializingExecutor.access$202(this.this$0, false);
         }

         throw var5;
      }
   }

   private void workOnQueue() {
      while(true) {
         Runnable var1 = null;
         synchronized(SerializingExecutor.access$100(this.this$0)) {
            if(SerializingExecutor.access$300(this.this$0) == 0) {
               var1 = (Runnable)SerializingExecutor.access$400(this.this$0).poll();
            }

            if(var1 == null) {
               SerializingExecutor.access$202(this.this$0, false);
               return;
            }
         }

         try {
            var1.run();
         } catch (RuntimeException var4) {
            Logger var10000 = SerializingExecutor.access$500();
            Level var10001 = Level.SEVERE;
            String var3 = String.valueOf(var1);
            var10000.log(var10001, (new StringBuilder(35 + String.valueOf(var3).length())).append("Exception while executing runnable ").append(var3).toString(), var4);
         }
      }
   }

   // $FF: synthetic method
   SerializingExecutor$QueueWorker(SerializingExecutor var1, SerializingExecutor$1 var2) {
      this(var1);
   }
}
