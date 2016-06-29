package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.Futures$NonCancellationPropagatingFuture$1;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

@GwtIncompatible("TODO")
final class Futures$NonCancellationPropagatingFuture extends AbstractFuture$TrustedFuture {
   Futures$NonCancellationPropagatingFuture(ListenableFuture var1) {
      var1.addListener(new Futures$NonCancellationPropagatingFuture$1(this, var1), MoreExecutors.directExecutor());
   }
}
