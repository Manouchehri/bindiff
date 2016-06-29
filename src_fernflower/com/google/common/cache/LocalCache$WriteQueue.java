package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$NullEntry;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$WriteQueue$1;
import com.google.common.cache.LocalCache$WriteQueue$2;
import java.util.AbstractQueue;
import java.util.Iterator;

final class LocalCache$WriteQueue extends AbstractQueue {
   final LocalCache$ReferenceEntry head = new LocalCache$WriteQueue$1(this);

   public boolean offer(LocalCache$ReferenceEntry var1) {
      LocalCache.connectWriteOrder(var1.getPreviousInWriteQueue(), var1.getNextInWriteQueue());
      LocalCache.connectWriteOrder(this.head.getPreviousInWriteQueue(), var1);
      LocalCache.connectWriteOrder(var1, this.head);
      return true;
   }

   public LocalCache$ReferenceEntry peek() {
      LocalCache$ReferenceEntry var1 = this.head.getNextInWriteQueue();
      return var1 == this.head?null:var1;
   }

   public LocalCache$ReferenceEntry poll() {
      LocalCache$ReferenceEntry var1 = this.head.getNextInWriteQueue();
      if(var1 == this.head) {
         return null;
      } else {
         this.remove(var1);
         return var1;
      }
   }

   public boolean remove(Object var1) {
      LocalCache$ReferenceEntry var2 = (LocalCache$ReferenceEntry)var1;
      LocalCache$ReferenceEntry var3 = var2.getPreviousInWriteQueue();
      LocalCache$ReferenceEntry var4 = var2.getNextInWriteQueue();
      LocalCache.connectWriteOrder(var3, var4);
      LocalCache.nullifyWriteOrder(var2);
      return var4 != LocalCache$NullEntry.INSTANCE;
   }

   public boolean contains(Object var1) {
      LocalCache$ReferenceEntry var2 = (LocalCache$ReferenceEntry)var1;
      return var2.getNextInWriteQueue() != LocalCache$NullEntry.INSTANCE;
   }

   public boolean isEmpty() {
      return this.head.getNextInWriteQueue() == this.head;
   }

   public int size() {
      int var1 = 0;

      for(LocalCache$ReferenceEntry var2 = this.head.getNextInWriteQueue(); var2 != this.head; var2 = var2.getNextInWriteQueue()) {
         ++var1;
      }

      return var1;
   }

   public void clear() {
      LocalCache$ReferenceEntry var2;
      for(LocalCache$ReferenceEntry var1 = this.head.getNextInWriteQueue(); var1 != this.head; var1 = var2) {
         var2 = var1.getNextInWriteQueue();
         LocalCache.nullifyWriteOrder(var1);
      }

      this.head.setNextInWriteQueue(this.head);
      this.head.setPreviousInWriteQueue(this.head);
   }

   public Iterator iterator() {
      return new LocalCache$WriteQueue$2(this, this.peek());
   }
}
