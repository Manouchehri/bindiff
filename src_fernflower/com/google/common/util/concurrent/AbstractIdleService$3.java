package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

class AbstractIdleService$3 implements Executor {
   // $FF: synthetic field
   final AbstractIdleService this$0;

   AbstractIdleService$3(AbstractIdleService var1) {
      this.this$0 = var1;
   }

   public void execute(Runnable var1) {
      MoreExecutors.newThread((String)AbstractIdleService.access$000(this.this$0).get(), var1).start();
   }
}
