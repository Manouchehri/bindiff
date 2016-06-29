package com.google.common.collect;

import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.MapMakerInternalMap$ExpirationQueue;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;

class MapMakerInternalMap$ExpirationQueue$2 extends AbstractSequentialIterator {
   // $FF: synthetic field
   final MapMakerInternalMap$ExpirationQueue this$0;

   MapMakerInternalMap$ExpirationQueue$2(MapMakerInternalMap$ExpirationQueue var1, MapMakerInternalMap$ReferenceEntry var2) {
      super(var2);
      this.this$0 = var1;
   }

   protected MapMakerInternalMap$ReferenceEntry computeNext(MapMakerInternalMap$ReferenceEntry var1) {
      MapMakerInternalMap$ReferenceEntry var2 = var1.getNextExpirable();
      return var2 == this.this$0.head?null:var2;
   }
}
