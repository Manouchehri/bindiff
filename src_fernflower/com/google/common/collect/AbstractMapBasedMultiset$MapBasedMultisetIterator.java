package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Count;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractMapBasedMultiset$MapBasedMultisetIterator implements Iterator {
   final Iterator entryIterator;
   Entry currentEntry;
   int occurrencesLeft;
   boolean canRemove;
   // $FF: synthetic field
   final AbstractMapBasedMultiset this$0;

   AbstractMapBasedMultiset$MapBasedMultisetIterator(AbstractMapBasedMultiset var1) {
      this.this$0 = var1;
      this.entryIterator = AbstractMapBasedMultiset.access$000(var1).entrySet().iterator();
   }

   public boolean hasNext() {
      return this.occurrencesLeft > 0 || this.entryIterator.hasNext();
   }

   public Object next() {
      if(this.occurrencesLeft == 0) {
         this.currentEntry = (Entry)this.entryIterator.next();
         this.occurrencesLeft = ((Count)this.currentEntry.getValue()).get();
      }

      --this.occurrencesLeft;
      this.canRemove = true;
      return this.currentEntry.getKey();
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.canRemove);
      int var1 = ((Count)this.currentEntry.getValue()).get();
      if(var1 <= 0) {
         throw new ConcurrentModificationException();
      } else {
         if(((Count)this.currentEntry.getValue()).addAndGet(-1) == 0) {
            this.entryIterator.remove();
         }

         AbstractMapBasedMultiset.access$110(this.this$0);
         this.canRemove = false;
      }
   }
}
