package com.google.common.cache;

import com.google.common.cache.RemovalListeners$1;
import com.google.common.cache.RemovalNotification;

class RemovalListeners$1$1 implements Runnable {
   // $FF: synthetic field
   final RemovalNotification val$notification;
   // $FF: synthetic field
   final RemovalListeners$1 this$0;

   RemovalListeners$1$1(RemovalListeners$1 var1, RemovalNotification var2) {
      this.this$0 = var1;
      this.val$notification = var2;
   }

   public void run() {
      this.this$0.val$listener.onRemoval(this.val$notification);
   }
}
