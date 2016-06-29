package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractScheduledService$1;

class AbstractScheduledService$1$1 implements Supplier {
   // $FF: synthetic field
   final AbstractScheduledService$1 this$1;

   AbstractScheduledService$1$1(AbstractScheduledService$1 var1) {
      this.this$1 = var1;
   }

   public String get() {
      String var1 = this.this$1.this$0.serviceName();
      String var2 = String.valueOf(this.this$1.state());
      return (new StringBuilder(1 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(" ").append(var2).toString();
   }
}
