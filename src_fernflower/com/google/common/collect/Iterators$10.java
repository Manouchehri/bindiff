package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$10 implements Iterator {
   private int count;
   // $FF: synthetic field
   final int val$limitSize;
   // $FF: synthetic field
   final Iterator val$iterator;

   Iterators$10(int var1, Iterator var2) {
      this.val$limitSize = var1;
      this.val$iterator = var2;
   }

   public boolean hasNext() {
      return this.count < this.val$limitSize && this.val$iterator.hasNext();
   }

   public Object next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         ++this.count;
         return this.val$iterator.next();
      }
   }

   public void remove() {
      this.val$iterator.remove();
   }
}
