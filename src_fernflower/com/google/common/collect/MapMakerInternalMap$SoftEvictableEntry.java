package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$SoftEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class MapMakerInternalMap$SoftEvictableEntry extends MapMakerInternalMap$SoftEntry implements MapMakerInternalMap$ReferenceEntry {
   MapMakerInternalMap$ReferenceEntry nextEvictable = MapMakerInternalMap.nullEntry();
   MapMakerInternalMap$ReferenceEntry previousEvictable = MapMakerInternalMap.nullEntry();

   MapMakerInternalMap$SoftEvictableEntry(ReferenceQueue var1, Object var2, int var3, @Nullable MapMakerInternalMap$ReferenceEntry var4) {
      super(var1, var2, var3, var4);
   }

   public MapMakerInternalMap$ReferenceEntry getNextEvictable() {
      return this.nextEvictable;
   }

   public void setNextEvictable(MapMakerInternalMap$ReferenceEntry var1) {
      this.nextEvictable = var1;
   }

   public MapMakerInternalMap$ReferenceEntry getPreviousEvictable() {
      return this.previousEvictable;
   }

   public void setPreviousEvictable(MapMakerInternalMap$ReferenceEntry var1) {
      this.previousEvictable = var1;
   }
}
