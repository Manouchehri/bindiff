package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$12 extends FluentIterable {
   // $FF: synthetic field
   final Iterable val$iterable;
   // $FF: synthetic field
   final int val$limitSize;

   Iterables$12(Iterable var1, int var2) {
      this.val$iterable = var1;
      this.val$limitSize = var2;
   }

   public Iterator iterator() {
      return Iterators.limit(this.val$iterable.iterator(), this.val$limitSize);
   }
}
