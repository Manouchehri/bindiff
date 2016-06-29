package com.google.common.cache;

import com.google.common.cache.ShimAsyncCache$LoadWhen;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

interface ShimAsyncCache$Entry$EntryState {
   @Nullable
   Object getIfPresent();

   ListenableFuture getOrLoadFuture();

   void maybeLoad(ShimAsyncCache$LoadWhen var1);

   void addFuture(ListenableFuture var1);

   void handleCompletion(ListenableFuture var1);
}
