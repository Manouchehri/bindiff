package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$7 extends FluentIterable {
   // $FF: synthetic field
   final Iterable val$unfiltered;
   // $FF: synthetic field
   final Predicate val$predicate;

   Iterables$7(Iterable var1, Predicate var2) {
      this.val$unfiltered = var1;
      this.val$predicate = var2;
   }

   public Iterator iterator() {
      return Iterators.filter(this.val$unfiltered.iterator(), this.val$predicate);
   }
}
