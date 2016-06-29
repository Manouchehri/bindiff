package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService$2;

class AbstractIdleService$2$1 implements Runnable {
   // $FF: synthetic field
   final AbstractIdleService$2 this$1;

   AbstractIdleService$2$1(AbstractIdleService$2 var1) {
      this.this$1 = var1;
   }

   public void run() {
      try {
         this.this$1.this$0.startUp();
         this.this$1.notifyStarted();
      } catch (Throwable var2) {
         this.this$1.notifyFailed(var2);
      }

   }
}
