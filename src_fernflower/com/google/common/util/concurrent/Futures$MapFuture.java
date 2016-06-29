package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.CollectionFuture;
import com.google.common.util.concurrent.Futures$MapFuture$MapFutureRunningState;

@GoogleInternal
@GwtIncompatible("TODO")
final class Futures$MapFuture extends CollectionFuture {
   Futures$MapFuture(ImmutableMap var1, boolean var2) {
      this.init(new Futures$MapFuture$MapFutureRunningState(this, var1, var2));
   }
}
