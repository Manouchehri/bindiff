package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.base.Stopwatch;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$LoadingValueReference$1;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

class LocalCache$LoadingValueReference implements LocalCache$ValueReference {
   volatile LocalCache$ValueReference oldValue;
   final SettableFuture futureValue;
   final Stopwatch stopwatch;

   public LocalCache$LoadingValueReference() {
      this(LocalCache.unset());
   }

   public LocalCache$LoadingValueReference(LocalCache$ValueReference var1) {
      this.futureValue = SettableFuture.create();
      this.stopwatch = Stopwatch.createUnstarted();
      this.oldValue = var1;
   }

   public boolean isLoading() {
      return true;
   }

   public boolean isActive() {
      return this.oldValue.isActive();
   }

   public int getWeight() {
      return this.oldValue.getWeight();
   }

   public boolean set(@Nullable Object var1) {
      return this.futureValue.set(var1);
   }

   public boolean setException(Throwable var1) {
      return this.futureValue.setException(var1);
   }

   private ListenableFuture fullyFailedFuture(Throwable var1) {
      return Futures.immediateFailedFuture(var1);
   }

   public void notifyNewValue(@Nullable Object var1) {
      if(var1 != null) {
         this.set(var1);
      } else {
         this.oldValue = LocalCache.unset();
      }

   }

   public ListenableFuture loadFuture(Object var1, CacheLoader var2) {
      Object var4;
      try {
         this.stopwatch.start();
         Object var3 = this.oldValue.get();
         if(var3 == null) {
            var4 = var2.load(var1);
            return (ListenableFuture)(this.set(var4)?this.futureValue:Futures.immediateFuture(var4));
         } else {
            ListenableFuture var6 = var2.reload(var1, var3);
            return var6 == null?Futures.immediateFuture((Object)null):Futures.transform(var6, (Function)(new LocalCache$LoadingValueReference$1(this)));
         }
      } catch (Throwable var5) {
         var4 = this.setException(var5)?this.futureValue:this.fullyFailedFuture(var5);
         if(var5 instanceof InterruptedException) {
            Thread.currentThread().interrupt();
         }

         return (ListenableFuture)var4;
      }
   }

   public long elapsedNanos() {
      return this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
   }

   public Object waitForValue() {
      return Uninterruptibles.getUninterruptibly(this.futureValue);
   }

   public Object get() {
      return this.oldValue.get();
   }

   public LocalCache$ValueReference getOldValue() {
      return this.oldValue;
   }

   public LocalCache$ReferenceEntry getEntry() {
      return null;
   }

   public LocalCache$ValueReference copyFor(ReferenceQueue var1, @Nullable Object var2, LocalCache$ReferenceEntry var3) {
      return this;
   }
}
