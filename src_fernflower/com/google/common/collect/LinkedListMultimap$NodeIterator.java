package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$Node;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.Map.Entry;

class LinkedListMultimap$NodeIterator implements ListIterator {
   int nextIndex;
   LinkedListMultimap$Node next;
   LinkedListMultimap$Node current;
   LinkedListMultimap$Node previous;
   int expectedModCount;
   // $FF: synthetic field
   final LinkedListMultimap this$0;

   LinkedListMultimap$NodeIterator(LinkedListMultimap var1, int var2) {
      this.this$0 = var1;
      this.expectedModCount = LinkedListMultimap.access$000(this.this$0);
      int var3 = var1.size();
      Preconditions.checkPositionIndex(var2, var3);
      if(var2 >= var3 / 2) {
         this.previous = LinkedListMultimap.access$100(var1);
         this.nextIndex = var3;

         while(var2++ < var3) {
            this.previous();
         }
      } else {
         this.next = LinkedListMultimap.access$200(var1);

         while(var2-- > 0) {
            this.next();
         }
      }

      this.current = null;
   }

   private void checkForConcurrentModification() {
      if(LinkedListMultimap.access$000(this.this$0) != this.expectedModCount) {
         throw new ConcurrentModificationException();
      }
   }

   public boolean hasNext() {
      this.checkForConcurrentModification();
      return this.next != null;
   }

   public LinkedListMultimap$Node next() {
      this.checkForConcurrentModification();
      LinkedListMultimap.access$300(this.next);
      this.previous = this.current = this.next;
      this.next = this.next.next;
      ++this.nextIndex;
      return this.current;
   }

   public void remove() {
      this.checkForConcurrentModification();
      CollectPreconditions.checkRemove(this.current != null);
      if(this.current != this.next) {
         this.previous = this.current.previous;
         --this.nextIndex;
      } else {
         this.next = this.current.next;
      }

      LinkedListMultimap.access$400(this.this$0, this.current);
      this.current = null;
      this.expectedModCount = LinkedListMultimap.access$000(this.this$0);
   }

   public boolean hasPrevious() {
      this.checkForConcurrentModification();
      return this.previous != null;
   }

   public LinkedListMultimap$Node previous() {
      this.checkForConcurrentModification();
      LinkedListMultimap.access$300(this.previous);
      this.next = this.current = this.previous;
      this.previous = this.previous.previous;
      --this.nextIndex;
      return this.current;
   }

   public int nextIndex() {
      return this.nextIndex;
   }

   public int previousIndex() {
      return this.nextIndex - 1;
   }

   public void set(Entry var1) {
      throw new UnsupportedOperationException();
   }

   public void add(Entry var1) {
      throw new UnsupportedOperationException();
   }

   void setValue(Object var1) {
      Preconditions.checkState(this.current != null);
      this.current.value = var1;
   }
}
