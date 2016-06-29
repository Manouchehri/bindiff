package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.CompactHashSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class CompactHashSet$1 implements Iterator {
   int expectedModCount;
   boolean nextCalled;
   int index;
   // $FF: synthetic field
   final CompactHashSet this$0;

   CompactHashSet$1(CompactHashSet var1) {
      this.this$0 = var1;
      this.expectedModCount = this.this$0.modCount;
      this.nextCalled = false;
      this.index = 0;
   }

   public boolean hasNext() {
      return this.index < CompactHashSet.access$000(this.this$0);
   }

   public Object next() {
      this.checkForConcurrentModification();
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         this.nextCalled = true;
         return this.this$0.elements[this.index++];
      }
   }

   public void remove() {
      this.checkForConcurrentModification();
      CollectPreconditions.checkRemove(this.nextCalled);
      ++this.expectedModCount;
      --this.index;
      CompactHashSet.access$300(this.this$0, this.this$0.elements[this.index], CompactHashSet.access$200(CompactHashSet.access$100(this.this$0)[this.index]));
      this.nextCalled = false;
   }

   private void checkForConcurrentModification() {
      if(this.this$0.modCount != this.expectedModCount) {
         throw new ConcurrentModificationException();
      }
   }
}
