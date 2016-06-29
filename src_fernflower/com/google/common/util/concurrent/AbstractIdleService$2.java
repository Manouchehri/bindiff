package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.AbstractIdleService$2$1;
import com.google.common.util.concurrent.AbstractIdleService$2$2;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.MoreExecutors;

class AbstractIdleService$2 extends AbstractService {
   // $FF: synthetic field
   final AbstractIdleService this$0;

   AbstractIdleService$2(AbstractIdleService var1) {
      this.this$0 = var1;
   }

   protected final void doStart() {
      MoreExecutors.renamingDecorator(this.this$0.executor(), AbstractIdleService.access$000(this.this$0)).execute(new AbstractIdleService$2$1(this));
   }

   protected final void doStop() {
      MoreExecutors.renamingDecorator(this.this$0.executor(), AbstractIdleService.access$000(this.this$0)).execute(new AbstractIdleService$2$2(this));
   }
}
