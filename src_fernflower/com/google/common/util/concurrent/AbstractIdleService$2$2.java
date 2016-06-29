package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService$2;

class AbstractIdleService$2$2 implements Runnable {
   // $FF: synthetic field
   final AbstractIdleService$2 this$1;

   AbstractIdleService$2$2(AbstractIdleService$2 var1) {
      this.this$1 = var1;
   }

   public void run() {
      try {
         this.this$1.this$0.shutDown();
         this.this$1.notifyStopped();
      } catch (Throwable var2) {
         this.this$1.notifyFailed(var2);
      }

   }
}
