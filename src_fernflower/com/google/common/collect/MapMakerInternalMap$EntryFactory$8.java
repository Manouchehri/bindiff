package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$WeakExpirableEvictableEntry;
import javax.annotation.Nullable;

enum MapMakerInternalMap$EntryFactory$8 {
   MapMakerInternalMap$ReferenceEntry newEntry(MapMakerInternalMap$Segment var1, Object var2, int var3, @Nullable MapMakerInternalMap$ReferenceEntry var4) {
      return new MapMakerInternalMap$WeakExpirableEvictableEntry(var1.keyReferenceQueue, var2, var3, var4);
   }

   MapMakerInternalMap$ReferenceEntry copyEntry(MapMakerInternalMap$Segment var1, MapMakerInternalMap$ReferenceEntry var2, MapMakerInternalMap$ReferenceEntry var3) {
      MapMakerInternalMap$ReferenceEntry var4 = super.copyEntry(var1, var2, var3);
      this.copyExpirableEntry(var2, var4);
      this.copyEvictableEntry(var2, var4);
      return var4;
   }
}
