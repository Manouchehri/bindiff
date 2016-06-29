package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$14 extends FluentIterable {
   // $FF: synthetic field
   final Iterable val$iterable;

   Iterables$14(Iterable var1) {
      this.val$iterable = var1;
   }

   public Iterator iterator() {
      return Iterators.consumingIterator(this.val$iterable.iterator());
   }

   public String toString() {
      return "Iterables.consumingIterable(...)";
   }
}
