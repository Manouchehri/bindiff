package com.google.common.util.concurrent;

import com.google.common.base.Throwables;
import com.google.common.util.concurrent.WrappingExecutorService;
import java.util.concurrent.Callable;

class WrappingExecutorService$1 implements Runnable {
   // $FF: synthetic field
   final Callable val$wrapped;
   // $FF: synthetic field
   final WrappingExecutorService this$0;

   WrappingExecutorService$1(WrappingExecutorService var1, Callable var2) {
      this.this$0 = var1;
      this.val$wrapped = var2;
   }

   public void run() {
      try {
         this.val$wrapped.call();
      } catch (Exception var2) {
         Throwables.propagate(var2);
      }

   }
}
