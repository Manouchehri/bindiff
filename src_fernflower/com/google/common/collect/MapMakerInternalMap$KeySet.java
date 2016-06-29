package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$KeyIterator;
import java.util.AbstractSet;
import java.util.Iterator;

final class MapMakerInternalMap$KeySet extends AbstractSet {
   // $FF: synthetic field
   final MapMakerInternalMap this$0;

   MapMakerInternalMap$KeySet(MapMakerInternalMap var1) {
      this.this$0 = var1;
   }

   public Iterator iterator() {
      return new MapMakerInternalMap$KeyIterator(this.this$0);
   }

   public int size() {
      return this.this$0.size();
   }

   public boolean isEmpty() {
      return this.this$0.isEmpty();
   }

   public boolean contains(Object var1) {
      return this.this$0.containsKey(var1);
   }

   public boolean remove(Object var1) {
      return this.this$0.remove(var1) != null;
   }

   public void clear() {
      this.this$0.clear();
   }
}
