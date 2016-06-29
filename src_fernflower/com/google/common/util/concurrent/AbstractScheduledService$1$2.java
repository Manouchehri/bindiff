package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.AbstractScheduledService$1;

class AbstractScheduledService$1$2 implements Runnable {
   // $FF: synthetic field
   final AbstractScheduledService$1 this$1;

   AbstractScheduledService$1$2(AbstractScheduledService$1 var1) {
      this.this$1 = var1;
   }

   public void run() {
      AbstractScheduledService$1.access$100(this.this$1).lock();

      try {
         this.this$1.this$0.startUp();
         AbstractScheduledService$1.access$202(this.this$1, this.this$1.this$0.scheduler().schedule(AbstractScheduledService.access$400(this.this$1.this$0), AbstractScheduledService$1.access$500(this.this$1), AbstractScheduledService$1.access$600(this.this$1)));
         this.this$1.notifyStarted();
      } catch (Throwable var5) {
         this.this$1.notifyFailed(var5);
         if(AbstractScheduledService$1.access$200(this.this$1) != null) {
            AbstractScheduledService$1.access$200(this.this$1).cancel(false);
         }
      } finally {
         AbstractScheduledService$1.access$100(this.this$1).unlock();
      }

   }
}
