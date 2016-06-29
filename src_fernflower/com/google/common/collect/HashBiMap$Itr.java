package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$BiEntry;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class HashBiMap$Itr implements Iterator {
   HashBiMap$BiEntry next;
   HashBiMap$BiEntry toRemove;
   int expectedModCount;
   // $FF: synthetic field
   final HashBiMap this$0;

   HashBiMap$Itr(HashBiMap var1) {
      this.this$0 = var1;
      this.next = HashBiMap.access$000(this.this$0);
      this.toRemove = null;
      this.expectedModCount = HashBiMap.access$100(this.this$0);
   }

   public boolean hasNext() {
      if(HashBiMap.access$100(this.this$0) != this.expectedModCount) {
         throw new ConcurrentModificationException();
      } else {
         return this.next != null;
      }
   }

   public Object next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         HashBiMap$BiEntry var1 = this.next;
         this.next = var1.nextInKeyInsertionOrder;
         this.toRemove = var1;
         return this.output(var1);
      }
   }

   public void remove() {
      if(HashBiMap.access$100(this.this$0) != this.expectedModCount) {
         throw new ConcurrentModificationException();
      } else {
         CollectPreconditions.checkRemove(this.toRemove != null);
         HashBiMap.access$200(this.this$0, this.toRemove);
         this.expectedModCount = HashBiMap.access$100(this.this$0);
         this.toRemove = null;
      }
   }

   abstract Object output(HashBiMap$BiEntry var1);
}
