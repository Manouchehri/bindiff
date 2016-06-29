package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import com.google.common.util.concurrent.ServiceManager$Listener;

final class ServiceManager$1 extends ListenerCallQueue$Callback {
   ServiceManager$1(String var1) {
      super(var1);
   }

   void call(ServiceManager$Listener var1) {
      var1.healthy();
   }
}
