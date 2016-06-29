package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;

final class Iterators$13 extends UnmodifiableIterator {
   boolean done;
   // $FF: synthetic field
   final Object val$value;

   Iterators$13(Object var1) {
      this.val$value = var1;
   }

   public boolean hasNext() {
      return !this.done;
   }

   public Object next() {
      if(this.done) {
         throw new NoSuchElementException();
      } else {
         this.done = true;
         return this.val$value;
      }
   }
}
