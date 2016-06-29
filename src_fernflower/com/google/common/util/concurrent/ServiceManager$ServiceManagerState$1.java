package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;
import com.google.common.util.concurrent.Service$State;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState;

class ServiceManager$ServiceManagerState$1 extends Monitor$Guard {
   // $FF: synthetic field
   final ServiceManager$ServiceManagerState this$0;

   ServiceManager$ServiceManagerState$1(ServiceManager$ServiceManagerState var1, Monitor var2) {
      super(var2);
      this.this$0 = var1;
   }

   public boolean isSatisfied() {
      return this.this$0.states.count(Service$State.RUNNING) == this.this$0.numberOfServices || this.this$0.states.contains(Service$State.STOPPING) || this.this$0.states.contains(Service$State.TERMINATED) || this.this$0.states.contains(Service$State.FAILED);
   }
}
