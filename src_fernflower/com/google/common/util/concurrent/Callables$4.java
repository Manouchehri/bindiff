package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;

final class Callables$4 implements Runnable {
   // $FF: synthetic field
   final Supplier val$nameSupplier;
   // $FF: synthetic field
   final Runnable val$task;

   Callables$4(Supplier var1, Runnable var2) {
      this.val$nameSupplier = var1;
      this.val$task = var2;
   }

   public void run() {
      Thread var1 = Thread.currentThread();
      String var2 = var1.getName();
      boolean var3 = Callables.access$000((String)this.val$nameSupplier.get(), var1);

      try {
         this.val$task.run();
      } finally {
         if(var3) {
            Callables.access$000(var2, var1);
         }

      }

   }
}
