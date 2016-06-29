package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$2 extends FluentIterable {
   // $FF: synthetic field
   final Iterable val$inputs;

   Iterables$2(Iterable var1) {
      this.val$inputs = var1;
   }

   public Iterator iterator() {
      return Iterators.concat(Iterables.access$100(this.val$inputs));
   }
}
