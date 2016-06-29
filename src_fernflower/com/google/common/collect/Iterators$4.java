package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$4 implements Iterator {
   Iterator iterator;
   Iterator removeFrom;
   // $FF: synthetic field
   final Iterable val$iterable;

   Iterators$4(Iterable var1) {
      this.val$iterable = var1;
      this.iterator = Iterators.emptyIterator();
   }

   public boolean hasNext() {
      if(!this.iterator.hasNext()) {
         this.iterator = this.val$iterable.iterator();
      }

      return this.iterator.hasNext();
   }

   public Object next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         this.removeFrom = this.iterator;
         return this.iterator.next();
      }
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.removeFrom != null);
      this.removeFrom.remove();
      this.removeFrom = null;
   }
}
