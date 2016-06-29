package com.google.common.cache;

import com.google.common.cache.LocalCache;
import java.util.AbstractSet;
import java.util.concurrent.ConcurrentMap;

abstract class LocalCache$AbstractCacheSet extends AbstractSet {
   final ConcurrentMap map;
   // $FF: synthetic field
   final LocalCache this$0;

   LocalCache$AbstractCacheSet(LocalCache var1, ConcurrentMap var2) {
      this.this$0 = var1;
      this.map = var2;
   }

   public int size() {
      return this.map.size();
   }

   public boolean isEmpty() {
      return this.map.isEmpty();
   }

   public void clear() {
      this.map.clear();
   }
}
