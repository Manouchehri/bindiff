package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$5 extends FluentIterable {
   // $FF: synthetic field
   final Iterable val$iterable;
   // $FF: synthetic field
   final int val$size;

   Iterables$5(Iterable var1, int var2) {
      this.val$iterable = var1;
      this.val$size = var2;
   }

   public Iterator iterator() {
      return Iterators.paddedPartition(this.val$iterable.iterator(), this.val$size);
   }
}
