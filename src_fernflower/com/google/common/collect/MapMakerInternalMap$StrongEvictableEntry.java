package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$StrongEntry;
import javax.annotation.Nullable;

final class MapMakerInternalMap$StrongEvictableEntry extends MapMakerInternalMap$StrongEntry implements MapMakerInternalMap$ReferenceEntry {
   MapMakerInternalMap$ReferenceEntry nextEvictable = MapMakerInternalMap.nullEntry();
   MapMakerInternalMap$ReferenceEntry previousEvictable = MapMakerInternalMap.nullEntry();

   MapMakerInternalMap$StrongEvictableEntry(Object var1, int var2, @Nullable MapMakerInternalMap$ReferenceEntry var3) {
      super(var1, var2, var3);
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
