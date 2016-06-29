package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import java.util.concurrent.TimeUnit;

@Beta
public abstract class ForwardingCheckedFuture extends ForwardingListenableFuture implements CheckedFuture {
   public Object checkedGet() {
      return this.delegate().checkedGet();
   }

   public Object checkedGet(long var1, TimeUnit var3) {
      return this.delegate().checkedGet(var1, var3);
   }

   protected abstract CheckedFuture delegate();
}
