package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.CompactLinkedHashSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class CompactLinkedHashSet$1 implements Iterator {
   int next;
   int toRemove;
   int expectedModCount;
   // $FF: synthetic field
   final CompactLinkedHashSet this$0;

   CompactLinkedHashSet$1(CompactLinkedHashSet var1) {
      this.this$0 = var1;
      this.next = CompactLinkedHashSet.access$000(this.this$0);
      this.toRemove = -1;
      this.expectedModCount = this.this$0.modCount;
   }

   private void checkForConcurrentModification() {
      if(this.this$0.modCount != this.expectedModCount) {
         throw new ConcurrentModificationException();
      }
   }

   public boolean hasNext() {
      this.checkForConcurrentModification();
      return this.next != -2;
   }

   public Object next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         Object var1 = this.this$0.elements[this.next];
         this.toRemove = this.next;
         this.next = CompactLinkedHashSet.access$100(this.this$0)[this.next];
         return var1;
      }
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.toRemove != -1);
      this.this$0.remove(this.this$0.elements[this.toRemove]);
      if(this.next == this.this$0.size()) {
         this.next = this.toRemove;
      }

      this.toRemove = -1;
      this.expectedModCount = this.this$0.modCount;
   }
}
