package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Ordering$ArbitraryOrdering;
import java.util.concurrent.atomic.AtomicInteger;

class Ordering$ArbitraryOrdering$1 implements Function {
   final AtomicInteger counter;
   // $FF: synthetic field
   final Ordering$ArbitraryOrdering this$0;

   Ordering$ArbitraryOrdering$1(Ordering$ArbitraryOrdering var1) {
      this.this$0 = var1;
      this.counter = new AtomicInteger(0);
   }

   public Integer apply(Object var1) {
      return Integer.valueOf(this.counter.getAndIncrement());
   }
}
