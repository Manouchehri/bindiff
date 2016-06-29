package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AccessQueue$1;
import com.google.common.cache.LocalCache$AccessQueue$2;
import com.google.common.cache.LocalCache$NullEntry;
import com.google.common.cache.LocalCache$ReferenceEntry;
import java.util.AbstractQueue;
import java.util.Iterator;

final class LocalCache$AccessQueue extends AbstractQueue {
   final LocalCache$ReferenceEntry head = new LocalCache$AccessQueue$1(this);

   public boolean offer(LocalCache$ReferenceEntry var1) {
      LocalCache.connectAccessOrder(var1.getPreviousInAccessQueue(), var1.getNextInAccessQueue());
      LocalCache.connectAccessOrder(this.head.getPreviousInAccessQueue(), var1);
      LocalCache.connectAccessOrder(var1, this.head);
      return true;
   }

   public LocalCache$ReferenceEntry peek() {
      LocalCache$ReferenceEntry var1 = this.head.getNextInAccessQueue();
      return var1 == this.head?null:var1;
   }

   public LocalCache$ReferenceEntry poll() {
      LocalCache$ReferenceEntry var1 = this.head.getNextInAccessQueue();
      if(var1 == this.head) {
         return null;
      } else {
         this.remove(var1);
         return var1;
      }
   }

   public boolean remove(Object var1) {
      LocalCache$ReferenceEntry var2 = (LocalCache$ReferenceEntry)var1;
      LocalCache$ReferenceEntry var3 = var2.getPreviousInAccessQueue();
      LocalCache$ReferenceEntry var4 = var2.getNextInAccessQueue();
      LocalCache.connectAccessOrder(var3, var4);
      LocalCache.nullifyAccessOrder(var2);
      return var4 != LocalCache$NullEntry.INSTANCE;
   }

   public boolean contains(Object var1) {
      LocalCache$ReferenceEntry var2 = (LocalCache$ReferenceEntry)var1;
      return var2.getNextInAccessQueue() != LocalCache$NullEntry.INSTANCE;
   }

   public boolean isEmpty() {
      return this.head.getNextInAccessQueue() == this.head;
   }

   public int size() {
      int var1 = 0;

      for(LocalCache$ReferenceEntry var2 = this.head.getNextInAccessQueue(); var2 != this.head; var2 = var2.getNextInAccessQueue()) {
         ++var1;
      }

      return var1;
   }

   public void clear() {
      LocalCache$ReferenceEntry var2;
      for(LocalCache$ReferenceEntry var1 = this.head.getNextInAccessQueue(); var1 != this.head; var1 = var2) {
         var2 = var1.getNextInAccessQueue();
         LocalCache.nullifyAccessOrder(var1);
      }

      this.head.setNextInAccessQueue(this.head);
      this.head.setPreviousInAccessQueue(this.head);
   }

   public Iterator iterator() {
      return new LocalCache$AccessQueue$2(this, this.peek());
   }
}
