package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;

final class AbstractService$4 extends ListenerCallQueue$Callback {
   // $FF: synthetic field
   final Service$State val$from;

   AbstractService$4(String var1, Service$State var2) {
      super(var1);
      this.val$from = var2;
   }

   void call(Service$Listener var1) {
      var1.stopping(this.val$from);
   }
}
