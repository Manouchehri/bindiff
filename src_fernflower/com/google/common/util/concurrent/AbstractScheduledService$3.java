package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.ScheduledExecutorService;

class AbstractScheduledService$3 extends Service$Listener {
   // $FF: synthetic field
   final ScheduledExecutorService val$executor;
   // $FF: synthetic field
   final AbstractScheduledService this$0;

   AbstractScheduledService$3(AbstractScheduledService var1, ScheduledExecutorService var2) {
      this.this$0 = var1;
      this.val$executor = var2;
   }

   public void terminated(Service$State var1) {
      this.val$executor.shutdown();
   }

   public void failed(Service$State var1, Throwable var2) {
      this.val$executor.shutdown();
   }
}
