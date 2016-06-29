package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import com.google.common.util.concurrent.WrappingExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

final class MoreExecutors$3 extends WrappingExecutorService {
   // $FF: synthetic field
   final Supplier val$nameSupplier;

   MoreExecutors$3(ExecutorService var1, Supplier var2) {
      super(var1);
      this.val$nameSupplier = var2;
   }

   protected Callable wrapTask(Callable var1) {
      return Callables.threadRenaming(var1, this.val$nameSupplier);
   }

   protected Runnable wrapTask(Runnable var1) {
      return Callables.threadRenaming(var1, this.val$nameSupplier);
   }
}
