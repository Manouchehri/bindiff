package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$LoadingValueReference;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.logging.Level;

class LocalCache$Segment$1 implements Runnable {
   // $FF: synthetic field
   final Object val$key;
   // $FF: synthetic field
   final int val$hash;
   // $FF: synthetic field
   final LocalCache$LoadingValueReference val$loadingValueReference;
   // $FF: synthetic field
   final ListenableFuture val$loadingFuture;
   // $FF: synthetic field
   final LocalCache$Segment this$0;

   LocalCache$Segment$1(LocalCache$Segment var1, Object var2, int var3, LocalCache$LoadingValueReference var4, ListenableFuture var5) {
      this.this$0 = var1;
      this.val$key = var2;
      this.val$hash = var3;
      this.val$loadingValueReference = var4;
      this.val$loadingFuture = var5;
   }

   public void run() {
      try {
         Object var1 = this.this$0.getAndRecordStats(this.val$key, this.val$hash, this.val$loadingValueReference, this.val$loadingFuture);
      } catch (Throwable var2) {
         LocalCache.logger.log(Level.WARNING, "Exception thrown during refresh", var2);
         this.val$loadingValueReference.setException(var2);
      }

   }
}
