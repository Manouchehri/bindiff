package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;

enum MapMakerInternalMap$NullEntry implements MapMakerInternalMap$ReferenceEntry {
   INSTANCE;

   public MapMakerInternalMap$ValueReference getValueReference() {
      return null;
   }

   public void setValueReference(MapMakerInternalMap$ValueReference var1) {
   }

   public MapMakerInternalMap$ReferenceEntry getNext() {
      return null;
   }

   public int getHash() {
      return 0;
   }

   public Object getKey() {
      return null;
   }

   public long getExpirationTime() {
      return 0L;
   }

   public void setExpirationTime(long var1) {
   }

   public MapMakerInternalMap$ReferenceEntry getNextExpirable() {
      return this;
   }

   public void setNextExpirable(MapMakerInternalMap$ReferenceEntry var1) {
   }

   public MapMakerInternalMap$ReferenceEntry getPreviousExpirable() {
      return this;
   }

   public void setPreviousExpirable(MapMakerInternalMap$ReferenceEntry var1) {
   }

   public MapMakerInternalMap$ReferenceEntry getNextEvictable() {
      return this;
   }

   public void setNextEvictable(MapMakerInternalMap$ReferenceEntry var1) {
   }

   public MapMakerInternalMap$ReferenceEntry getPreviousEvictable() {
      return this;
   }

   public void setPreviousEvictable(MapMakerInternalMap$ReferenceEntry var1) {
   }
}
