package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import java.util.Iterator;

final class FluentIterable$1 extends FluentIterable {
   // $FF: synthetic field
   final Iterable val$iterable;

   FluentIterable$1(Iterable var1, Iterable var2) {
      super(var1);
      this.val$iterable = var2;
   }

   public Iterator iterator() {
      return this.val$iterable.iterator();
   }
}
