package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AbstractCacheSet;
import com.google.common.cache.LocalCache$KeyIterator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

final class LocalCache$KeySet extends LocalCache$AbstractCacheSet {
   // $FF: synthetic field
   final LocalCache this$0;

   LocalCache$KeySet(LocalCache var1, ConcurrentMap var2) {
      super(var1, var2);
      this.this$0 = var1;
   }

   public Iterator iterator() {
      return new LocalCache$KeyIterator(this.this$0);
   }

   public boolean contains(Object var1) {
      return this.map.containsKey(var1);
   }

   public boolean remove(Object var1) {
      return this.map.remove(var1) != null;
   }
}
