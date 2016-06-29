package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractCheckedFuture;
import com.google.common.util.concurrent.ListenableFuture;

@GwtIncompatible("TODO")
class Futures$MappingCheckedFuture extends AbstractCheckedFuture {
   final Function mapper;

   Futures$MappingCheckedFuture(ListenableFuture var1, Function var2) {
      super(var1);
      this.mapper = (Function)Preconditions.checkNotNull(var2);
   }

   protected Exception mapException(Exception var1) {
      return (Exception)this.mapper.apply(var1);
   }
}
