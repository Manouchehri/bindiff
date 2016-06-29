package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

final class Iterators$11 extends UnmodifiableIterator {
   // $FF: synthetic field
   final Iterator val$iterator;

   Iterators$11(Iterator var1) {
      this.val$iterator = var1;
   }

   public boolean hasNext() {
      return this.val$iterator.hasNext();
   }

   public Object next() {
      Object var1 = this.val$iterator.next();
      this.val$iterator.remove();
      return var1;
   }

   public String toString() {
      return "Iterators.consumingIterator(...)";
   }
}
