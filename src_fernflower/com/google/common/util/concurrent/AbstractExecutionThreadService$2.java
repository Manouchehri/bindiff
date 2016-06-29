package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

class AbstractExecutionThreadService$2 implements Executor {
   // $FF: synthetic field
   final AbstractExecutionThreadService this$0;

   AbstractExecutionThreadService$2(AbstractExecutionThreadService var1) {
      this.this$0 = var1;
   }

   public void execute(Runnable var1) {
      MoreExecutors.newThread(this.this$0.serviceName(), var1).start();
   }
}
