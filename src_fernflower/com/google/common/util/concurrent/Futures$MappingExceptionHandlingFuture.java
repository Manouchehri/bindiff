package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@GoogleInternal
@GwtIncompatible("TODO")
class Futures$MappingExceptionHandlingFuture extends ForwardingListenableFuture {
   private final ListenableFuture delegate;
   private final Function mapper;

   Futures$MappingExceptionHandlingFuture(ListenableFuture var1, Function var2) {
      this.delegate = (ListenableFuture)Preconditions.checkNotNull(var1, "delegate");
      this.mapper = (Function)Preconditions.checkNotNull(var2, "mapper");
   }

   protected ListenableFuture delegate() {
      return this.delegate;
   }

   public Object get() {
      try {
         return this.delegate.get();
      } catch (ExecutionException var2) {
         throw new ExecutionException((Throwable)this.mapper.apply(var2.getCause()));
      }
   }

   public Object get(long var1, TimeUnit var3) {
      try {
         return this.delegate.get(var1, var3);
      } catch (ExecutionException var5) {
         throw new ExecutionException((Throwable)this.mapper.apply(var5.getCause()));
      }
   }
}
