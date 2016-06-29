package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Lists$ReverseList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class Lists$ReverseList$1 implements ListIterator {
   boolean canRemoveOrSet;
   // $FF: synthetic field
   final ListIterator val$forwardIterator;
   // $FF: synthetic field
   final Lists$ReverseList this$0;

   Lists$ReverseList$1(Lists$ReverseList var1, ListIterator var2) {
      this.this$0 = var1;
      this.val$forwardIterator = var2;
   }

   public void add(Object var1) {
      this.val$forwardIterator.add(var1);
      this.val$forwardIterator.previous();
      this.canRemoveOrSet = false;
   }

   public boolean hasNext() {
      return this.val$forwardIterator.hasPrevious();
   }

   public boolean hasPrevious() {
      return this.val$forwardIterator.hasNext();
   }

   public Object next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         this.canRemoveOrSet = true;
         return this.val$forwardIterator.previous();
      }
   }

   public int nextIndex() {
      return Lists$ReverseList.access$000(this.this$0, this.val$forwardIterator.nextIndex());
   }

   public Object previous() {
      if(!this.hasPrevious()) {
         throw new NoSuchElementException();
      } else {
         this.canRemoveOrSet = true;
         return this.val$forwardIterator.next();
      }
   }

   public int previousIndex() {
      return this.nextIndex() - 1;
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.canRemoveOrSet);
      this.val$forwardIterator.remove();
      this.canRemoveOrSet = false;
   }

   public void set(Object var1) {
      Preconditions.checkState(this.canRemoveOrSet);
      this.val$forwardIterator.set(var1);
   }
}
