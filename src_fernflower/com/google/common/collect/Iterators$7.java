package com.google.common.collect;

import com.google.common.base.Pair;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$7 implements Iterator {
   // $FF: synthetic field
   final Iterator val$first;
   // $FF: synthetic field
   final Iterator val$second;

   Iterators$7(Iterator var1, Iterator var2) {
      this.val$first = var1;
      this.val$second = var2;
   }

   public boolean hasNext() {
      return this.val$first.hasNext() && this.val$second.hasNext();
   }

   public Pair next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         return Pair.of(this.val$first.next(), this.val$second.next());
      }
   }

   public void remove() {
      throw new UnsupportedOperationException("remove() not yet implemented for paired lists.");
   }
}
