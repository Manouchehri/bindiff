package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;
import com.google.common.util.concurrent.Service$State;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState;

class ServiceManager$ServiceManagerState$2 extends Monitor$Guard {
   // $FF: synthetic field
   final ServiceManager$ServiceManagerState this$0;

   ServiceManager$ServiceManagerState$2(ServiceManager$ServiceManagerState var1, Monitor var2) {
      super(var2);
      this.this$0 = var1;
   }

   public boolean isSatisfied() {
      return this.this$0.states.count(Service$State.TERMINATED) + this.this$0.states.count(Service$State.FAILED) == this.this$0.numberOfServices;
   }
}
