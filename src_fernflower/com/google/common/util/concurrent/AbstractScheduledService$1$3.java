package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService$1;
import com.google.common.util.concurrent.Service$State;

class AbstractScheduledService$1$3 implements Runnable {
   // $FF: synthetic field
   final AbstractScheduledService$1 this$1;

   AbstractScheduledService$1$3(AbstractScheduledService$1 var1) {
      this.this$1 = var1;
   }

   public void run() {
      try {
         AbstractScheduledService$1.access$100(this.this$1).lock();

         label49: {
            try {
               if(this.this$1.state() == Service$State.STOPPING) {
                  this.this$1.this$0.shutDown();
                  break label49;
               }
            } finally {
               AbstractScheduledService$1.access$100(this.this$1).unlock();
            }

            return;
         }

         this.this$1.notifyStopped();
      } catch (Throwable var5) {
         this.this$1.notifyFailed(var5);
      }

   }
}
