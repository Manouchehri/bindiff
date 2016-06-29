package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import java.util.concurrent.Callable;

final class Callables$3 implements Callable {
   // $FF: synthetic field
   final Supplier val$nameSupplier;
   // $FF: synthetic field
   final Callable val$callable;

   Callables$3(Supplier var1, Callable var2) {
      this.val$nameSupplier = var1;
      this.val$callable = var2;
   }

   public Object call() {
      Thread var1 = Thread.currentThread();
      String var2 = var1.getName();
      boolean var3 = Callables.access$000((String)this.val$nameSupplier.get(), var1);

      Object var4;
      try {
         var4 = this.val$callable.call();
      } finally {
         if(var3) {
            Callables.access$000(var2, var1);
         }

      }

      return var4;
   }
}
