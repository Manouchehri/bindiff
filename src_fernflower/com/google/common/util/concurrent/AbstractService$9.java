package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;

class AbstractService$9 extends ListenerCallQueue$Callback {
   // $FF: synthetic field
   final Service$State val$from;
   // $FF: synthetic field
   final Throwable val$cause;
   // $FF: synthetic field
   final AbstractService this$0;

   AbstractService$9(AbstractService var1, String var2, Service$State var3, Throwable var4) {
      super(var2);
      this.this$0 = var1;
      this.val$from = var3;
      this.val$cause = var4;
   }

   void call(Service$Listener var1) {
      var1.failed(this.val$from, this.val$cause);
   }
}
