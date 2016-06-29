package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class Multisets$MultisetIteratorImpl implements Iterator {
   private final Multiset multiset;
   private final Iterator entryIterator;
   private Multiset$Entry currentEntry;
   private int laterCount;
   private int totalCount;
   private boolean canRemove;

   Multisets$MultisetIteratorImpl(Multiset var1, Iterator var2) {
      this.multiset = var1;
      this.entryIterator = var2;
   }

   public boolean hasNext() {
      return this.laterCount > 0 || this.entryIterator.hasNext();
   }

   public Object next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         if(this.laterCount == 0) {
            this.currentEntry = (Multiset$Entry)this.entryIterator.next();
            this.totalCount = this.laterCount = this.currentEntry.getCount();
         }

         --this.laterCount;
         this.canRemove = true;
         return this.currentEntry.getElement();
      }
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.canRemove);
      if(this.totalCount == 1) {
         this.entryIterator.remove();
      } else {
         this.multiset.remove(this.currentEntry.getElement());
      }

      --this.totalCount;
      this.canRemove = false;
   }
}
