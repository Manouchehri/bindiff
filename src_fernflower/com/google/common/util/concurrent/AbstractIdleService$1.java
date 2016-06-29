package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractIdleService;

class AbstractIdleService$1 implements Supplier {
   // $FF: synthetic field
   final AbstractIdleService this$0;

   AbstractIdleService$1(AbstractIdleService var1) {
      this.this$0 = var1;
   }

   public String get() {
      String var1 = this.this$0.serviceName();
      String var2 = String.valueOf(this.this$0.state());
      return (new StringBuilder(1 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(" ").append(var2).toString();
   }
}
