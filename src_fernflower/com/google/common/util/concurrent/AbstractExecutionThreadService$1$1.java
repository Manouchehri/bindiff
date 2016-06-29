package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractExecutionThreadService$1;

class AbstractExecutionThreadService$1$1 implements Supplier {
   // $FF: synthetic field
   final AbstractExecutionThreadService$1 this$1;

   AbstractExecutionThreadService$1$1(AbstractExecutionThreadService$1 var1) {
      this.this$1 = var1;
   }

   public String get() {
      return this.this$1.this$0.serviceName();
   }
}
