package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$6 extends FluentIterable {
   // $FF: synthetic field
   final Iterable val$first;
   // $FF: synthetic field
   final Iterable val$second;

   Iterables$6(Iterable var1, Iterable var2) {
      this.val$first = var1;
      this.val$second = var2;
   }

   public Iterator iterator() {
      return Iterators.pairUp(this.val$first.iterator(), this.val$second.iterator());
   }
}
