package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.CompactLinkedHashMap;
import com.google.common.collect.CompactLinkedHashMap$1;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class CompactLinkedHashMap$Itr implements Iterator {
   private int next;
   private int toRemove;
   private int expectedModCount;
   // $FF: synthetic field
   final CompactLinkedHashMap this$0;

   private CompactLinkedHashMap$Itr(CompactLinkedHashMap var1) {
      this.this$0 = var1;
      this.next = CompactLinkedHashMap.access$000(this.this$0);
      this.toRemove = -1;
      this.expectedModCount = this.this$0.modCount;
   }

   private void checkForConcurrentModification() {
      if(this.this$0.modCount != this.expectedModCount) {
         throw new ConcurrentModificationException();
      }
   }

   public boolean hasNext() {
      return this.next != -2;
   }

   abstract Object getOutput(int var1);

   public Object next() {
      this.checkForConcurrentModification();
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         Object var1 = this.getOutput(this.next);
         this.toRemove = this.next;
         this.next = CompactLinkedHashMap.access$100(this.this$0, this.next);
         return var1;
      }
   }

   public void remove() {
      this.checkForConcurrentModification();
      CollectPreconditions.checkRemove(this.toRemove != -1);
      this.this$0.remove(this.this$0.keys[this.toRemove]);
      if(this.next >= this.this$0.size()) {
         this.next = this.toRemove;
      }

      this.expectedModCount = this.this$0.modCount;
      this.toRemove = -1;
   }

   // $FF: synthetic method
   CompactLinkedHashMap$Itr(CompactLinkedHashMap var1, CompactLinkedHashMap$1 var2) {
      this(var1);
   }
}
