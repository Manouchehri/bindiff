package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$HashIterator;
import java.util.Map.Entry;

final class MapMakerInternalMap$EntryIterator extends MapMakerInternalMap$HashIterator {
   // $FF: synthetic field
   final MapMakerInternalMap this$0;

   MapMakerInternalMap$EntryIterator(MapMakerInternalMap var1) {
      super(var1);
      this.this$0 = var1;
   }

   public Entry next() {
      return this.nextEntry();
   }
}
