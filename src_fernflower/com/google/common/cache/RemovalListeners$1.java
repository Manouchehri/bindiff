package com.google.common.cache;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners$1$1;
import com.google.common.cache.RemovalNotification;
import java.util.concurrent.Executor;

final class RemovalListeners$1 implements RemovalListener {
   // $FF: synthetic field
   final Executor val$executor;
   // $FF: synthetic field
   final RemovalListener val$listener;

   RemovalListeners$1(Executor var1, RemovalListener var2) {
      this.val$executor = var1;
      this.val$listener = var2;
   }

   public void onRemoval(RemovalNotification var1) {
      this.val$executor.execute(new RemovalListeners$1$1(this, var1));
   }
}
