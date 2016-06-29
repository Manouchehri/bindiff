package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$1 extends FluentIterable {
   // $FF: synthetic field
   final Iterable val$iterable;

   Iterables$1(Iterable var1) {
      this.val$iterable = var1;
   }

   public Iterator iterator() {
      return Iterators.cycle(this.val$iterable);
   }

   public String toString() {
      return String.valueOf(this.val$iterable.toString()).concat(" (cycled)");
   }
}
