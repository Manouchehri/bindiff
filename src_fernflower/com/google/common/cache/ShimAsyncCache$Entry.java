package com.google.common.cache;

import com.google.common.cache.AsyncCacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.ShimAsyncCache;
import com.google.common.cache.ShimAsyncCache$Entry$1;
import com.google.common.cache.ShimAsyncCache$Entry$EntryState;
import com.google.common.cache.ShimAsyncCache$Entry$Waiting;
import com.google.common.cache.ShimAsyncCache$LoadWhen;
import com.google.common.cache.ShimAsyncCache$PersistentQueue;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

class ShimAsyncCache$Entry {
   final ConcurrentMap cache;
   final AsyncCacheLoader loader;
   final ThreadLocal batch;
   final Object key;
   final AtomicReference state = new AtomicReference(new ShimAsyncCache$Entry$Waiting(this, ShimAsyncCache$PersistentQueue.empty(), SettableFuture.create()));

   ShimAsyncCache$Entry(LoadingCache var1, AsyncCacheLoader var2, ThreadLocal var3, Object var4) {
      this.cache = var1.asMap();
      this.loader = var2;
      this.batch = var3;
      this.key = var4;
   }

   @Nullable
   Object getIfPresent() {
      return ((ShimAsyncCache$Entry$EntryState)this.state.get()).getIfPresent();
   }

   ListenableFuture getOrLoadFuture() {
      return ((ShimAsyncCache$Entry$EntryState)this.state.get()).getOrLoadFuture();
   }

   void maybeLoad(ShimAsyncCache$LoadWhen var1) {
      ((ShimAsyncCache$Entry$EntryState)this.state.get()).maybeLoad(var1);
   }

   void addFuture(ListenableFuture var1) {
      this.refreshEntry();
      ((ShimAsyncCache$Entry$EntryState)this.state.get()).addFuture(var1);
      this.listen(var1);
   }

   void refreshEntry() {
      this.cache.replace(this.key, this, this);
   }

   void listen(ListenableFuture var1) {
      var1.addListener(new ShimAsyncCache$Entry$1(this, var1), MoreExecutors.directExecutor());
   }

   void loadOrBatch(SettableFuture var1) {
      this.refreshEntry();
      Map var2 = (Map)this.batch.get();
      if(var2 != null) {
         var2.put(this.key, var1);
      } else {
         var1.setFuture(ShimAsyncCache.access$000(this.loader, this.key));
      }

      this.listen(var1);
   }
}
