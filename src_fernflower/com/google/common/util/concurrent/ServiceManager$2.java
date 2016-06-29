package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import com.google.common.util.concurrent.ServiceManager$Listener;

final class ServiceManager$2 extends ListenerCallQueue$Callback {
   ServiceManager$2(String var1) {
      super(var1);
   }

   void call(ServiceManager$Listener var1) {
      var1.stopped();
   }
}
