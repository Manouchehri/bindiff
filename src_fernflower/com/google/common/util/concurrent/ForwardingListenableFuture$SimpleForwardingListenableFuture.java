package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class ForwardingListenableFuture$SimpleForwardingListenableFuture extends ForwardingListenableFuture {
   private final ListenableFuture delegate;

   protected ForwardingListenableFuture$SimpleForwardingListenableFuture(ListenableFuture var1) {
      this.delegate = (ListenableFuture)Preconditions.checkNotNull(var1);
   }

   protected final ListenableFuture delegate() {
      return this.delegate;
   }
}
