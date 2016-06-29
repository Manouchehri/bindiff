package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

abstract class AbstractFuture$TrustedFuture extends AbstractFuture {
   public final Object get() {
      return super.get();
   }

   public final Object get(long var1, TimeUnit var3) {
      return super.get(var1, var3);
   }

   public final boolean isDone() {
      return super.isDone();
   }

   public final boolean isCancelled() {
      return super.isCancelled();
   }

   public final void addListener(Runnable var1, Executor var2) {
      super.addListener(var1, var2);
   }
}
