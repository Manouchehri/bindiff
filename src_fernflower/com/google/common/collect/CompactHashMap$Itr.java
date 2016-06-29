package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$1;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class CompactHashMap$Itr implements Iterator {
   int expectedModCount;
   boolean nextCalled;
   int index;
   // $FF: synthetic field
   final CompactHashMap this$0;

   private CompactHashMap$Itr(CompactHashMap var1) {
      this.this$0 = var1;
      this.expectedModCount = this.this$0.modCount;
      this.nextCalled = false;
      this.index = 0;
   }

   public boolean hasNext() {
      return this.index < CompactHashMap.access$000(this.this$0);
   }

   abstract Object getOutput(int var1);

   public Object next() {
      this.checkForConcurrentModification();
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         this.nextCalled = true;
         return this.getOutput(this.index++);
      }
   }

   public void remove() {
      this.checkForConcurrentModification();
      CollectPreconditions.checkRemove(this.nextCalled);
      ++this.expectedModCount;
      --this.index;
      CompactHashMap.access$100(this.this$0, this.index);
      this.nextCalled = false;
   }

   private void checkForConcurrentModification() {
      if(this.this$0.modCount != this.expectedModCount) {
         throw new ConcurrentModificationException();
      }
   }

   // $FF: synthetic method
   CompactHashMap$Itr(CompactHashMap var1, CompactHashMap$1 var2) {
      this(var1);
   }
}
