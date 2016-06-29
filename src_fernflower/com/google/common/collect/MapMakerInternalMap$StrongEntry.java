package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import javax.annotation.Nullable;

class MapMakerInternalMap$StrongEntry implements MapMakerInternalMap$ReferenceEntry {
   final Object key;
   final int hash;
   final MapMakerInternalMap$ReferenceEntry next;
   volatile MapMakerInternalMap$ValueReference valueReference = MapMakerInternalMap.unset();

   MapMakerInternalMap$StrongEntry(Object var1, int var2, @Nullable MapMakerInternalMap$ReferenceEntry var3) {
      this.key = var1;
      this.hash = var2;
      this.next = var3;
   }

   public Object getKey() {
      return this.key;
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
