package com.google.common.collect;

import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.MapMakerInternalMap$EvictionQueue;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;

class MapMakerInternalMap$EvictionQueue$2 extends AbstractSequentialIterator {
   // $FF: synthetic field
   final MapMakerInternalMap$EvictionQueue this$0;

   MapMakerInternalMap$EvictionQueue$2(MapMakerInternalMap$EvictionQueue var1, MapMakerInternalMap$ReferenceEntry var2) {
      super(var2);
      this.this$0 = var1;
   }

   protected MapMakerInternalMap$ReferenceEntry computeNext(MapMakerInternalMap$ReferenceEntry var1) {
      MapMakerInternalMap$ReferenceEntry var2 = var1.getNextEvictable();
      return var2 == this.this$0.head?null:var2;
   }
}
