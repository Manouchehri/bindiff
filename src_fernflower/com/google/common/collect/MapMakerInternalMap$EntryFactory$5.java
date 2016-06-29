package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$WeakEntry;
import javax.annotation.Nullable;

enum MapMakerInternalMap$EntryFactory$5 {
   MapMakerInternalMap$ReferenceEntry newEntry(MapMakerInternalMap$Segment var1, Object var2, int var3, @Nullable MapMakerInternalMap$ReferenceEntry var4) {
      return new MapMakerInternalMap$WeakEntry(var1.keyReferenceQueue, var2, var3, var4);
   }
}
