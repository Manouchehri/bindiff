package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import javax.annotation.Nullable;

class MapMakerInternalMap$SoftEntry extends SoftReference implements MapMakerInternalMap$ReferenceEntry {
   final int hash;
   final MapMakerInternalMap$ReferenceEntry next;
   volatile MapMakerInternalMap$ValueReference valueReference = MapMakerInternalMap.unset();

   MapMakerInternalMap$SoftEntry(ReferenceQueue var1, Object var2, int var3, @Nullable MapMakerInternalMap$ReferenceEntry var4) {
      super(var2, var1);
      this.hash = var3;
      this.next = var4;
   }

   public Object getKey() {
      return this.get();
   }

   public long getExpirationTime() {
      throw new UnsupportedOperationException();
   }

   public void setExpirationTime(long var1) {
      throw new UnsupportedOperationException();
   }

   public MapMakerInternalMap$ReferenceEntry getNextExpirable() {
      throw new UnsupportedOperationException();
   }

   public void setNextExpirable(MapMakerInternalMap$ReferenceEntry var1) {
      throw new UnsupportedOperationException();
   }

   public MapMakerInternalMap$ReferenceEntry getPreviousExpirable() {
      throw new UnsupportedOperationException();
   }

   public void setPreviousExpirable(MapMakerInternalMap$ReferenceEntry var1) {
      throw new UnsupportedOperationException();
   }

   public MapMakerInternalMap$ReferenceEntry getNextEvictable() {
      throw new UnsupportedOperationException();
   }

   public void setNextEvictable(MapMakerInternalMap$ReferenceEntry var1) {
      throw new UnsupportedOperationException();
   }

   public MapMakerInternalMap$ReferenceEntry getPreviousEvictable() {
      throw new UnsupportedOperationException();
   }

   public void setPreviousEvictable(MapMakerInternalMap$ReferenceEntry var1) {
      throw new UnsupportedOperationException();
   }

   public MapMakerInternalMap$ValueReference getValueReference() {
      return this.valueReference;
   }

   public void setValueReference(MapMakerInternalMap$ValueReference var1) {
      MapMakerInternalMap$ValueReference var2 = this.valueReference;
      this.valueReference = var1;
      var2.clear(var1);
   }

   public int getHash() {
      return this.hash;
   }

   public MapMakerInternalMap$ReferenceEntry getNext() {
      return this.next;
   }
}
