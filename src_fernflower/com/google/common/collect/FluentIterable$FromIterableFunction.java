package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.FluentIterable$1;

class FluentIterable$FromIterableFunction implements Function {
   private FluentIterable$FromIterableFunction() {
   }

   public FluentIterable apply(Iterable var1) {
      return FluentIterable.from(var1);
   }

   // $FF: synthetic method
   FluentIterable$FromIterableFunction(FluentIterable$1 var1) {
      this();
   }
}
