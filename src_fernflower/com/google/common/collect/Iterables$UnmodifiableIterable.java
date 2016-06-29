package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables$1;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$UnmodifiableIterable extends FluentIterable {
   private final Iterable iterable;

   private Iterables$UnmodifiableIterable(Iterable var1) {
      this.iterable = var1;
   }

   public Iterator iterator() {
      return Iterators.unmodifiableIterator(this.iterable.iterator());
   }

   public String toString() {
      return this.iterable.toString();
   }

   // $FF: synthetic method
   Iterables$UnmodifiableIterable(Iterable var1, Iterables$1 var2) {
      this(var1);
   }
}
