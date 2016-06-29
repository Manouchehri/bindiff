package com.google.common.cache;

import com.google.common.cache.ShimAsyncCache$Entry;
import com.google.common.cache.ShimAsyncCache$Entry$EntryState;
import com.google.common.cache.ShimAsyncCache$LoadWhen;
import com.google.common.cache.ShimAsyncCache$PersistentQueue;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

class ShimAsyncCache$Entry$Value implements ShimAsyncCache$Entry$EntryState {
   final Object value;
   final ShimAsyncCache$PersistentQueue futures;
   // $FF: synthetic field
   final ShimAsyncCache$Entry this$0;

   ShimAsyncCache$Entry$Value(ShimAsyncCache$Entry var1, Object var2, ShimAsyncCache$PersistentQueue var3) {
      this.this$0 = var1;
      this.value = var2;
      this.futures = var3;
   }

   public ListenableFuture getOrLoadFuture() {
      return Futures.immediateFuture(this.value);
   }

   @Nullable
   public Object getIfPresent() {
      return this.value;
   }

   public void maybeLoad(ShimAsyncCache$LoadWhen var1) {
      if(var1 == ShimAsyncCache$LoadWhen.ALWAYS) {
         SettableFuture var2 = SettableFuture.create();
         if(this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Value(this.this$0, this.value, this.futures.add(var2)))) {
            this.this$0.loadOrBatch(var2);
         } else {
            ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).maybeLoad(var1);
         }
      }

   }

   public void addFuture(ListenableFuture var1) {
      if(!this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Value(this.this$0, this.value, this.futures.add(var1)))) {
         ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).addFuture(var1);
      }

   }

   public void handleCompletion(ListenableFuture var1) {
      Object var2 = this.value;
      boolean var3 = false;

      ShimAsyncCache$PersistentQueue var4;
      try {
         var2 = Uninterruptibles.getUninterruptibly(var1);
         var3 = true;
         var4 = this.futures.retainNewer(var1);
      } catch (ExecutionException var6) {
         var4 = this.futures.remove(var1);
      } catch (RuntimeException var7) {
         var4 = this.futures.remove(var1);
      }

      if(var4.size() != this.futures.size()) {
         if(this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Value(this.this$0, var2, var4))) {
            if(var3) {
               this.this$0.refreshEntry();
            }
         } else {
            ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).handleCompletion(var1);
         }

      }
   }
}
