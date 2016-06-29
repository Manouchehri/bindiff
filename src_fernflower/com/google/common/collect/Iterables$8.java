package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$8 extends FluentIterable {
   // $FF: synthetic field
   final Iterable val$unfiltered;
   // $FF: synthetic field
   final Class val$type;

   Iterables$8(Iterable var1, Class var2) {
      this.val$unfiltered = var1;
      this.val$type = var2;
   }

   public Iterator iterator() {
      return Iterators.filter(this.val$unfiltered.iterator(), this.val$type);
   }
}
