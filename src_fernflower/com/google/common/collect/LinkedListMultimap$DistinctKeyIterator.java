package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$1;
import com.google.common.collect.LinkedListMultimap$Node;
import com.google.common.collect.Sets;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

class LinkedListMultimap$DistinctKeyIterator implements Iterator {
   final Set seenKeys;
   LinkedListMultimap$Node next;
   LinkedListMultimap$Node current;
   int expectedModCount;
   // $FF: synthetic field
   final LinkedListMultimap this$0;

   private LinkedListMultimap$DistinctKeyIterator(LinkedListMultimap var1) {
      this.this$0 = var1;
      this.seenKeys = Sets.newHashSetWithExpectedSize(this.this$0.keySet().size());
      this.next = LinkedListMultimap.access$200(this.this$0);
      this.expectedModCount = LinkedListMultimap.access$000(this.this$0);
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

   public Object next() {
      this.checkForConcurrentModification();
      LinkedListMultimap.access$300(this.next);
      this.current = this.next;
      this.seenKeys.add(this.current.key);

      do {
         this.next = this.next.next;
      } while(this.next != null && !this.seenKeys.add(this.next.key));

      return this.current.key;
   }

   public void remove() {
      this.checkForConcurrentModification();
      CollectPreconditions.checkRemove(this.current != null);
      LinkedListMultimap.access$500(this.this$0, this.current.key);
      this.current = null;
      this.expectedModCount = LinkedListMultimap.access$000(this.this$0);
   }

   // $FF: synthetic method
   LinkedListMultimap$DistinctKeyIterator(LinkedListMultimap var1, LinkedListMultimap$1 var2) {
      this(var1);
   }
}
