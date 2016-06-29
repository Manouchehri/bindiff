package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ValueIterator;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

final class LocalCache$Values extends AbstractCollection {
   private final ConcurrentMap map;
   // $FF: synthetic field
   final LocalCache this$0;

   LocalCache$Values(LocalCache var1, ConcurrentMap var2) {
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

   public Iterator iterator() {
      return new LocalCache$ValueIterator(this.this$0);
   }

   public boolean contains(Object var1) {
      return this.map.containsValue(var1);
   }
}
