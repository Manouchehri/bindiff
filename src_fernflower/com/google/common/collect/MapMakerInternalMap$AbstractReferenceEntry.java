package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;

abstract class MapMakerInternalMap$AbstractReferenceEntry implements MapMakerInternalMap$ReferenceEntry {
   public MapMakerInternalMap$ValueReference getValueReference() {
      throw new UnsupportedOperationException();
   }

   public void setValueReference(MapMakerInternalMap$ValueReference var1) {
      throw new UnsupportedOperationException();
   }

   public MapMakerInternalMap$ReferenceEntry getNext() {
      throw new UnsupportedOperationException();
   }

   public int getHash() {
      throw new UnsupportedOperationException();
   }

   public Object getKey() {
      throw new UnsupportedOperationException();
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
}
