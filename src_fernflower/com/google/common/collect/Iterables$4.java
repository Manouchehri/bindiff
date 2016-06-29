package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$4 extends FluentIterable {
   // $FF: synthetic field
   final Iterable val$iterable;
   // $FF: synthetic field
   final int val$size;

   Iterables$4(Iterable var1, int var2) {
      this.val$iterable = var1;
      this.val$size = var2;
   }

   public Iterator iterator() {
      return Iterators.partition(this.val$iterable.iterator(), this.val$size);
   }
}
