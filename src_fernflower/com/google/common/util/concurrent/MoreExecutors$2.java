package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import java.util.concurrent.Executor;

final class MoreExecutors$2 implements Executor {
   // $FF: synthetic field
   final Executor val$executor;
   // $FF: synthetic field
   final Supplier val$nameSupplier;

   MoreExecutors$2(Executor var1, Supplier var2) {
      this.val$executor = var1;
      this.val$nameSupplier = var2;
   }

   public void execute(Runnable var1) {
      this.val$executor.execute(Callables.threadRenaming(var1, this.val$nameSupplier));
   }
}
