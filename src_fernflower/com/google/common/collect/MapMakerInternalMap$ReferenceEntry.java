package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ValueReference;

interface MapMakerInternalMap$ReferenceEntry {
   MapMakerInternalMap$ValueReference getValueReference();

   void setValueReference(MapMakerInternalMap$ValueReference var1);

   MapMakerInternalMap$ReferenceEntry getNext();

   int getHash();

   Object getKey();

   long getExpirationTime();

   void setExpirationTime(long var1);

   MapMakerInternalMap$ReferenceEntry getNextExpirable();

   void setNextExpirable(MapMakerInternalMap$ReferenceEntry var1);

   MapMakerInternalMap$ReferenceEntry getPreviousExpirable();

   void setPreviousExpirable(MapMakerInternalMap$ReferenceEntry var1);

   MapMakerInternalMap$ReferenceEntry getNextEvictable();

   void setNextEvictable(MapMakerInternalMap$ReferenceEntry var1);

   MapMakerInternalMap$ReferenceEntry getPreviousEvictable();

   void setPreviousEvictable(MapMakerInternalMap$ReferenceEntry var1);
}
