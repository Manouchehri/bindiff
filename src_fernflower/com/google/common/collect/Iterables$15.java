package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Comparator;
import java.util.Iterator;

final class Iterables$15 extends FluentIterable {
   // $FF: synthetic field
   final Iterable val$iterables;
   // $FF: synthetic field
   final Comparator val$comparator;

   Iterables$15(Iterable var1, Comparator var2) {
      this.val$iterables = var1;
      this.val$comparator = var2;
   }

   public Iterator iterator() {
      return Iterators.mergeSorted(Iterables.transform(this.val$iterables, Iterables.access$200()), this.val$comparator);
   }
}
