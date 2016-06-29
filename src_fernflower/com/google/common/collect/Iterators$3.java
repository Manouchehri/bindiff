package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

final class Iterators$3 extends UnmodifiableIterator {
   // $FF: synthetic field
   final Iterator val$iterator;

   Iterators$3(Iterator var1) {
      this.val$iterator = var1;
   }

   public boolean hasNext() {
      return this.val$iterator.hasNext();
   }

   public Object next() {
      return this.val$iterator.next();
   }
}
