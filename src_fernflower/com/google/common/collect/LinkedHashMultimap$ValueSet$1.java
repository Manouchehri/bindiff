package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedHashMultimap$ValueEntry;
import com.google.common.collect.LinkedHashMultimap$ValueSet;
import com.google.common.collect.LinkedHashMultimap$ValueSetLink;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedHashMultimap$ValueSet$1 implements Iterator {
   LinkedHashMultimap$ValueSetLink nextEntry;
   LinkedHashMultimap$ValueEntry toRemove;
   int expectedModCount;
   // $FF: synthetic field
   final LinkedHashMultimap$ValueSet this$1;

   LinkedHashMultimap$ValueSet$1(LinkedHashMultimap$ValueSet var1) {
      this.this$1 = var1;
      this.nextEntry = LinkedHashMultimap$ValueSet.access$000(this.this$1);
      this.expectedModCount = LinkedHashMultimap$ValueSet.access$100(this.this$1);
   }

   private void checkForComodification() {
      if(LinkedHashMultimap$ValueSet.access$100(this.this$1) != this.expectedModCount) {
         throw new ConcurrentModificationException();
      }
   }

   public boolean hasNext() {
      this.checkForComodification();
      return this.nextEntry != this.this$1;
   }

   public Object next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         LinkedHashMultimap$ValueEntry var1 = (LinkedHashMultimap$ValueEntry)this.nextEntry;
         Object var2 = var1.getValue();
         this.toRemove = var1;
         this.nextEntry = var1.getSuccessorInValueSet();
         return var2;
      }
   }

   public void remove() {
      this.checkForComodification();
      CollectPreconditions.checkRemove(this.toRemove != null);
      this.this$1.remove(this.toRemove.getValue());
      this.expectedModCount = LinkedHashMultimap$ValueSet.access$100(this.this$1);
      this.toRemove = null;
   }
}
