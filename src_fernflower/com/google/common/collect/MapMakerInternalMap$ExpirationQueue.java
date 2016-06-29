package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ExpirationQueue$1;
import com.google.common.collect.MapMakerInternalMap$ExpirationQueue$2;
import com.google.common.collect.MapMakerInternalMap$NullEntry;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import java.util.AbstractQueue;
import java.util.Iterator;

final class MapMakerInternalMap$ExpirationQueue extends AbstractQueue {
   final MapMakerInternalMap$ReferenceEntry head = new MapMakerInternalMap$ExpirationQueue$1(this);

   public boolean offer(MapMakerInternalMap$ReferenceEntry var1) {
      MapMakerInternalMap.connectExpirables(var1.getPreviousExpirable(), var1.getNextExpirable());
      MapMakerInternalMap.connectExpirables(this.head.getPreviousExpirable(), var1);
      MapMakerInternalMap.connectExpirables(var1, this.head);
      return true;
   }

   public MapMakerInternalMap$ReferenceEntry peek() {
      MapMakerInternalMap$ReferenceEntry var1 = this.head.getNextExpirable();
      return var1 == this.head?null:var1;
   }

   public MapMakerInternalMap$ReferenceEntry poll() {
      MapMakerInternalMap$ReferenceEntry var1 = this.head.getNextExpirable();
      if(var1 == this.head) {
         return null;
      } else {
         this.remove(var1);
         return var1;
      }
   }

   public boolean remove(Object var1) {
      MapMakerInternalMap$ReferenceEntry var2 = (MapMakerInternalMap$ReferenceEntry)var1;
      MapMakerInternalMap$ReferenceEntry var3 = var2.getPreviousExpirable();
      MapMakerInternalMap$ReferenceEntry var4 = var2.getNextExpirable();
      MapMakerInternalMap.connectExpirables(var3, var4);
      MapMakerInternalMap.nullifyExpirable(var2);
      return var4 != MapMakerInternalMap$NullEntry.INSTANCE;
   }

   public boolean contains(Object var1) {
      MapMakerInternalMap$ReferenceEntry var2 = (MapMakerInternalMap$ReferenceEntry)var1;
      return var2.getNextExpirable() != MapMakerInternalMap$NullEntry.INSTANCE;
   }

   public boolean isEmpty() {
      return this.head.getNextExpirable() == this.head;
   }

   public int size() {
      int var1 = 0;

      for(MapMakerInternalMap$ReferenceEntry var2 = this.head.getNextExpirable(); var2 != this.head; var2 = var2.getNextExpirable()) {
         ++var1;
      }

      return var1;
   }

   public void clear() {
      MapMakerInternalMap$ReferenceEntry var2;
      for(MapMakerInternalMap$ReferenceEntry var1 = this.head.getNextExpirable(); var1 != this.head; var1 = var2) {
         var2 = var1.getNextExpirable();
         MapMakerInternalMap.nullifyExpirable(var1);
      }

      this.head.setNextExpirable(this.head);
      this.head.setPreviousExpirable(this.head);
   }

   public Iterator iterator() {
      return new MapMakerInternalMap$ExpirationQueue$2(this, this.peek());
   }
}
