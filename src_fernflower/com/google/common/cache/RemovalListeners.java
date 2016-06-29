package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners$1;
import java.util.concurrent.Executor;

public final class RemovalListeners {
   public static RemovalListener asynchronous(RemovalListener var0, Executor var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new RemovalListeners$1(var1, var0);
   }
}
