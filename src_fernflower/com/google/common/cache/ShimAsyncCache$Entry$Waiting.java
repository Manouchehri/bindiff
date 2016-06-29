package com.google.common.cache;

import com.google.common.cache.ShimAsyncCache$Entry;
import com.google.common.cache.ShimAsyncCache$Entry$EntryState;
import com.google.common.cache.ShimAsyncCache$Entry$Value;
import com.google.common.cache.ShimAsyncCache$LoadWhen;
import com.google.common.cache.ShimAsyncCache$PersistentQueue;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

class ShimAsyncCache$Entry$Waiting implements ShimAsyncCache$Entry$EntryState {
   final ShimAsyncCache$PersistentQueue futures;
   final SettableFuture result;
   // $FF: synthetic field
   final ShimAsyncCache$Entry this$0;

   ShimAsyncCache$Entry$Waiting(ShimAsyncCache$Entry var1, ShimAsyncCache$PersistentQueue var2, SettableFuture var3) {
      this.this$0 = var1;
      this.futures = var2;
      this.result = var3;
   }

   public ListenableFuture getOrLoadFuture() {
      this.maybeLoad(ShimAsyncCache$LoadWhen.NOT_PENDING_OR_AVAILABLE);
      return Futures.nonCancellationPropagating(this.result);
   }

   @Nullable
   public Object getIfPresent() {
      return null;
   }

   public void maybeLoad(ShimAsyncCache$LoadWhen var1) {
      if(var1 == ShimAsyncCache$LoadWhen.ALWAYS || this.futures.size() == 0) {
         SettableFuture var2 = SettableFuture.create();
         if(this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Waiting(this.this$0, this.futures.add(var2), this.result))) {
            this.this$0.loadOrBatch(var2);
         } else {
            ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).maybeLoad(var1);
         }
      }

   }

   public void addFuture(ListenableFuture var1) {
      if(!this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Waiting(this.this$0, this.futures.add(var1), this.result))) {
         ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).addFuture(var1);
      }

   }

   public void handleCompletion(ListenableFuture var1) {
      try {
         Object var2 = Uninterruptibles.getUninterruptibly(var1);
         if(this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Value(this.this$0, var2, this.futures.retainNewer(var1)))) {
            this.this$0.refreshEntry();
            this.result.set(var2);
         } else {
            ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).handleCompletion(var1);
         }
      } catch (ExecutionException var3) {
         this.handleFailure(var1, var3.getCause());
      } catch (RuntimeException var4) {
         this.handleFailure(var1, var4);
      }

   }

   private void handleFailure(ListenableFuture var1, Throwable var2) {
      SettableFuture var3 = SettableFuture.create();
      if(this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Waiting(this.this$0, this.futures.remove(var1), var3))) {
         this.result.setException(var2);
      } else {
         ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).handleCompletion(var1);
      }

   }
}
