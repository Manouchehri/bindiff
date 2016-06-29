package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$KeyList;
import com.google.common.collect.LinkedListMultimap$Node;
import java.util.ListIterator;
import javax.annotation.Nullable;

class LinkedListMultimap$ValueForKeyIterator implements ListIterator {
   final Object key;
   int nextIndex;
   LinkedListMultimap$Node next;
   LinkedListMultimap$Node current;
   LinkedListMultimap$Node previous;
   // $FF: synthetic field
   final LinkedListMultimap this$0;

   LinkedListMultimap$ValueForKeyIterator(LinkedListMultimap var1, @Nullable Object var2) {
      this.this$0 = var1;
      this.key = var2;
      LinkedListMultimap$KeyList var3 = (LinkedListMultimap$KeyList)LinkedListMultimap.access$600(var1).get(var2);
      this.next = var3 == null?null:var3.head;
   }

   public LinkedListMultimap$ValueForKeyIterator(LinkedListMultimap var1, @Nullable Object var2, int var3) {
      this.this$0 = var1;
      LinkedListMultimap$KeyList var4 = (LinkedListMultimap$KeyList)LinkedListMultimap.access$600(var1).get(var2);
      int var5 = var4 == null?0:var4.count;
      Preconditions.checkPositionIndex(var3, var5);
      if(var3 >= var5 / 2) {
         this.previous = var4 == null?null:var4.tail;
         this.nextIndex = var5;

         while(var3++ < var5) {
            this.previous();
         }
      } else {
         this.next = var4 == null?null:var4.head;

         while(var3-- > 0) {
            this.next();
         }
      }

      this.key = var2;
      this.current = null;
   }

   public boolean hasNext() {
      return this.next != null;
   }

   public Object next() {
      LinkedListMultimap.access$300(this.next);
      this.previous = this.current = this.next;
      this.next = this.next.nextSibling;
      ++this.nextIndex;
      return this.current.value;
   }

   public boolean hasPrevious() {
      return this.previous != null;
   }

   public Object previous() {
      LinkedListMultimap.access$300(this.previous);
      this.next = this.current = this.previous;
      this.previous = this.previous.previousSibling;
      --this.nextIndex;
      return this.current.value;
   }

   public int nextIndex() {
      return this.nextIndex;
   }

   public int previousIndex() {
      return this.nextIndex - 1;
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.current != null);
      if(this.current != this.next) {
         this.previous = this.current.previousSibling;
         --this.nextIndex;
      } else {
         this.next = this.current.nextSibling;
      }

      LinkedListMultimap.access$400(this.this$0, this.current);
      this.current = null;
   }

   public void set(Object var1) {
      Preconditions.checkState(this.current != null);
      this.current.value = var1;
   }

   public void add(Object var1) {
      this.previous = LinkedListMultimap.access$700(this.this$0, this.key, var1, this.next);
      ++this.nextIndex;
      this.current = null;
   }
}
