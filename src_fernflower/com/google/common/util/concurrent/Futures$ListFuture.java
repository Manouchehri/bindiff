package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.CollectionFuture;
import com.google.common.util.concurrent.Futures$ListFuture$ListFutureRunningState;

final class Futures$ListFuture extends CollectionFuture {
   Futures$ListFuture(ImmutableCollection var1, boolean var2) {
      this.init(new Futures$ListFuture$ListFutureRunningState(this, var1, var2));
   }
}
