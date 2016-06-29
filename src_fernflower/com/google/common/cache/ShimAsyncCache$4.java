package com.google.common.cache;

import com.google.common.cache.AsyncCacheLoader;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.ShimAsyncCache$CacheHolder;
import com.google.common.cache.ShimAsyncCache$Entry;
import com.google.common.cache.ShimAsyncCache$LoadWhen;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

final class ShimAsyncCache$4 extends CacheLoader {
   // $FF: synthetic field
   final ShimAsyncCache$CacheHolder val$holder;
   // $FF: synthetic field
   final AsyncCacheLoader val$loader;
   // $FF: synthetic field
   final ThreadLocal val$batch;

   ShimAsyncCache$4(ShimAsyncCache$CacheHolder var1, AsyncCacheLoader var2, ThreadLocal var3) {
      this.val$holder = var1;
      this.val$loader = var2;
      this.val$batch = var3;
   }

   public ShimAsyncCache$Entry load(Object var1) {
      return new ShimAsyncCache$Entry(this.val$holder.cache, this.val$loader, this.val$batch, var1);
   }

   public ListenableFuture reload(Object var1, ShimAsyncCache$Entry var2) {
      var2.maybeLoad(ShimAsyncCache$LoadWhen.ALWAYS);
      return Futures.immediateFuture(var2);
   }
}
