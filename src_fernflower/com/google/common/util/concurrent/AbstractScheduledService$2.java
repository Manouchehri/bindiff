package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ThreadFactory;

class AbstractScheduledService$2 implements ThreadFactory {
   // $FF: synthetic field
   final AbstractScheduledService this$0;

   AbstractScheduledService$2(AbstractScheduledService var1) {
      this.this$0 = var1;
   }

   public Thread newThread(Runnable var1) {
      return MoreExecutors.newThread(this.this$0.serviceName(), var1);
   }
}
