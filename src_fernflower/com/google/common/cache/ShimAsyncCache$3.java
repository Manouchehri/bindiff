package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

final class ShimAsyncCache$3 implements Function {
   public Object apply(Object var1) {
      return Preconditions.checkNotNull(var1, "AsyncLoadingCache is null-hostile.");
   }
}
