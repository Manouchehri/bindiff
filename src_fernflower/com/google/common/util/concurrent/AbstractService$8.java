package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;

class AbstractService$8 extends Monitor$Guard {
   // $FF: synthetic field
   final AbstractService this$0;

   AbstractService$8(AbstractService var1, Monitor var2) {
      super(var2);
      this.this$0 = var1;
   }

   public boolean isSatisfied() {
      return this.this$0.state().isTerminal();
   }
}
