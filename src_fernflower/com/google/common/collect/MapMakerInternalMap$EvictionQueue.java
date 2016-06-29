package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$EvictionQueue$1;
import com.google.common.collect.MapMakerInternalMap$EvictionQueue$2;
import com.google.common.collect.MapMakerInternalMap$NullEntry;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import java.util.AbstractQueue;
import java.util.Iterator;

final class MapMakerInternalMap$EvictionQueue extends AbstractQueue {
   final MapMakerInternalMap$ReferenceEntry head = new MapMakerInternalMap$EvictionQueue$1(this);

   public boolean offer(MapMakerInternalMap$ReferenceEntry var1) {
      MapMakerInternalMap.connectEvictables(var1.getPreviousEvictable(), var1.getNextEvictable());
      MapMakerInternalMap.connectEvictables(this.head.getPreviousEvictable(), var1);
      MapMakerInternalMap.connectEvictables(var1, this.head);
      return true;
   }

   public MapMakerInternalMap$ReferenceEntry peek() {
      MapMakerInternalMap$ReferenceEntry var1 = this.head.getNextEvictable();
      return var1 == this.head?null:var1;
   }

   public MapMakerInternalMap$ReferenceEntry poll() {
      MapMakerInternalMap$ReferenceEntry var1 = this.head.getNextEvictable();
      if(var1 == this.head) {
         return null;
      } else {
         this.remove(var1);
         return var1;
      }
   }

   public boolean remove(Object var1) {
      MapMakerInternalMap$ReferenceEntry var2 = (MapMakerInternalMap$ReferenceEntry)var1;
      MapMakerInternalMap$ReferenceEntry var3 = var2.getPreviousEvictable();
      MapMakerInternalMap$ReferenceEntry var4 = var2.getNextEvictable();
      MapMakerInternalMap.connectEvictables(var3, var4);
      MapMakerInternalMap.nullifyEvictable(var2);
      return var4 != MapMakerInternalMap$NullEntry.INSTANCE;
   }

   public boolean contains(Object var1) {
      MapMakerInternalMap$ReferenceEntry var2 = (MapMakerInternalMap$ReferenceEntry)var1;
      return var2.getNextEvictable() != MapMakerInternalMap$NullEntry.INSTANCE;
   }

   public boolean isEmpty() {
      return this.head.getNextEvictable() == this.head;
   }

   public int size() {
      int var1 = 0;

      for(MapMakerInternalMap$ReferenceEntry var2 = this.head.getNextEvictable(); var2 != this.head; var2 = var2.getNextEvictable()) {
         ++var1;
      }

      return var1;
   }

   public void clear() {
      MapMakerInternalMap$ReferenceEntry var2;
      for(MapMakerInternalMap$ReferenceEntry var1 = this.head.getNextEvictable(); var1 != this.head; var1 = var2) {
         var2 = var1.getNextEvictable();
         MapMakerInternalMap.nullifyEvictable(var1);
      }

      this.head.setNextEvictable(this.head);
      this.head.setPreviousEvictable(this.head);
   }

   public Iterator iterator() {
      return new MapMakerInternalMap$EvictionQueue$2(this, this.peek());
   }
}
