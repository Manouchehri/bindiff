package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager$Listener;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState;

class ServiceManager$ServiceManagerState$4 extends ListenerCallQueue$Callback {
   // $FF: synthetic field
   final Service val$service;
   // $FF: synthetic field
   final ServiceManager$ServiceManagerState this$0;

   ServiceManager$ServiceManagerState$4(ServiceManager$ServiceManagerState var1, String var2, Service var3) {
      super(var2);
      this.this$0 = var1;
      this.val$service = var3;
   }

   void call(ServiceManager$Listener var1) {
      var1.failure(this.val$service);
   }
}
