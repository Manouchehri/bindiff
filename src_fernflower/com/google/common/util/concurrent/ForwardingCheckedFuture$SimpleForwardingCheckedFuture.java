package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.ForwardingCheckedFuture;

@Beta
public abstract class ForwardingCheckedFuture$SimpleForwardingCheckedFuture extends ForwardingCheckedFuture {
   private final CheckedFuture delegate;

   protected ForwardingCheckedFuture$SimpleForwardingCheckedFuture(CheckedFuture var1) {
      this.delegate = (CheckedFuture)Preconditions.checkNotNull(var1);
   }

   protected final CheckedFuture delegate() {
      return this.delegate;
   }
}
