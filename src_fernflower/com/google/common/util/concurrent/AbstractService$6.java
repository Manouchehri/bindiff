package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;
import com.google.common.util.concurrent.Service$State;

class AbstractService$6 extends Monitor$Guard {
   // $FF: synthetic field
   final AbstractService this$0;

   AbstractService$6(AbstractService var1, Monitor var2) {
      super(var2);
      this.this$0 = var1;
   }

   public boolean isSatisfied() {
      return this.this$0.state().compareTo(Service$State.RUNNING) <= 0;
   }
}
