package com.google.common.collect;

import com.google.common.collect.ConsumingQueueIterator;
import com.google.common.collect.FluentIterable;
import java.util.Iterator;
import java.util.Queue;

final class Iterables$13 extends FluentIterable {
   // $FF: synthetic field
   final Iterable val$iterable;

   Iterables$13(Iterable var1) {
      this.val$iterable = var1;
   }

   public Iterator iterator() {
      return new ConsumingQueueIterator((Queue)this.val$iterable);
   }

   public String toString() {
      return "Iterables.consumingIterable(...)";
   }
}
