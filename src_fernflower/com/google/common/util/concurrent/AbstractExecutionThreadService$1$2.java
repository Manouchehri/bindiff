package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.AbstractExecutionThreadService$1;
import java.util.logging.Level;

class AbstractExecutionThreadService$1$2 implements Runnable {
   // $FF: synthetic field
   final AbstractExecutionThreadService$1 this$1;

   AbstractExecutionThreadService$1$2(AbstractExecutionThreadService$1 var1) {
      this.this$1 = var1;
   }

   public void run() {
      try {
         this.this$1.this$0.startUp();
         this.this$1.notifyStarted();
         if(this.this$1.isRunning()) {
            try {
               this.this$1.this$0.run();
            } catch (Throwable var4) {
               try {
                  this.this$1.this$0.shutDown();
               } catch (Exception var3) {
                  AbstractExecutionThreadService.access$000().log(Level.WARNING, "Error while attempting to shut down the service after failure.", var3);
               }

               this.this$1.notifyFailed(var4);
               return;
            }
         }

         this.this$1.this$0.shutDown();
         this.this$1.notifyStopped();
      } catch (Throwable var5) {
         this.this$1.notifyFailed(var5);
      }

   }
}
