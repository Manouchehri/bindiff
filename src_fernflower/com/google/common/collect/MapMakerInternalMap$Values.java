package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ValueIterator;
import java.util.AbstractCollection;
import java.util.Iterator;

final class MapMakerInternalMap$Values extends AbstractCollection {
   // $FF: synthetic field
   final MapMakerInternalMap this$0;

   MapMakerInternalMap$Values(MapMakerInternalMap var1) {
      this.this$0 = var1;
   }

   public Iterator iterator() {
      return new MapMakerInternalMap$ValueIterator(this.this$0);
   }

   public int size() {
      return this.this$0.size();
   }

   public boolean isEmpty() {
      return this.this$0.isEmpty();
   }

   public boolean contains(Object var1) {
      return this.this$0.containsValue(var1);
   }

   public void clear() {
      this.this$0.clear();
   }
}
