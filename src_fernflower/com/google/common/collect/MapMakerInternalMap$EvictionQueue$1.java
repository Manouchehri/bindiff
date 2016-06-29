package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$AbstractReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$EvictionQueue;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;

class MapMakerInternalMap$EvictionQueue$1 extends MapMakerInternalMap$AbstractReferenceEntry {
   MapMakerInternalMap$ReferenceEntry nextEvictable;
   MapMakerInternalMap$ReferenceEntry previousEvictable;
   // $FF: synthetic field
   final MapMakerInternalMap$EvictionQueue this$0;

   MapMakerInternalMap$EvictionQueue$1(MapMakerInternalMap$EvictionQueue var1) {
      this.this$0 = var1;
      this.nextEvictable = this;
      this.previousEvictable = this;
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
