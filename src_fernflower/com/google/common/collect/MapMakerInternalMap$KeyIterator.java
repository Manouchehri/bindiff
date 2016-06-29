package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$HashIterator;

final class MapMakerInternalMap$KeyIterator extends MapMakerInternalMap$HashIterator {
   // $FF: synthetic field
   final MapMakerInternalMap this$0;

   MapMakerInternalMap$KeyIterator(MapMakerInternalMap var1) {
      super(var1);
      this.this$0 = var1;
   }

   public Object next() {
      return this.nextEntry().getKey();
   }
}
