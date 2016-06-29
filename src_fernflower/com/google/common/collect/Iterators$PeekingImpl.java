package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.PeekingIterator;
import java.util.Iterator;

class Iterators$PeekingImpl implements PeekingIterator {
   private final Iterator iterator;
   private boolean hasPeeked;
   private Object peekedElement;

   public Iterators$PeekingImpl(Iterator var1) {
      this.iterator = (Iterator)Preconditions.checkNotNull(var1);
   }

   public boolean hasNext() {
      return this.hasPeeked || this.iterator.hasNext();
   }

   public Object next() {
      if(!this.hasPeeked) {
         return this.iterator.next();
      } else {
         Object var1 = this.peekedElement;
         this.hasPeeked = false;
         this.peekedElement = null;
         return var1;
      }
   }

   public void remove() {
      Preconditions.checkState(!this.hasPeeked, "Can\'t remove after you\'ve peeked at next");
      this.iterator.remove();
   }

   public Object peek() {
      if(!this.hasPeeked) {
         this.peekedElement = this.iterator.next();
         this.hasPeeked = true;
      }

      return this.peekedElement;
   }
}
