package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.AbstractExecutionThreadService$1$1;
import com.google.common.util.concurrent.AbstractExecutionThreadService$1$2;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

class AbstractExecutionThreadService$1 extends AbstractService {
   // $FF: synthetic field
   final AbstractExecutionThreadService this$0;

   AbstractExecutionThreadService$1(AbstractExecutionThreadService var1) {
      this.this$0 = var1;
   }

   protected final void doStart() {
      Executor var1 = MoreExecutors.renamingDecorator((Executor)this.this$0.executor(), new AbstractExecutionThreadService$1$1(this));
      var1.execute(new AbstractExecutionThreadService$1$2(this));
   }

   protected void doStop() {
      this.this$0.triggerShutdown();
   }
}
