package com.google.common.cache;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheLoader$1$1;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.Map;
import java.util.concurrent.Executor;

final class CacheLoader$1 extends CacheLoader {
   // $FF: synthetic field
   final CacheLoader val$loader;
   // $FF: synthetic field
   final Executor val$executor;

   CacheLoader$1(CacheLoader var1, Executor var2) {
      this.val$loader = var1;
      this.val$executor = var2;
   }

   public Object load(Object var1) {
      return this.val$loader.load(var1);
   }

   public ListenableFuture reload(Object var1, Object var2) {
      ListenableFutureTask var3 = ListenableFutureTask.create(new CacheLoader$1$1(this, var1, var2));
      this.val$executor.execute(var3);
      return var3;
   }

   public Map loadAll(Iterable var1) {
      return this.val$loader.loadAll(var1);
   }
}
