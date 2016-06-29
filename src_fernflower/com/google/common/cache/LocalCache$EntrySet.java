package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AbstractCacheSet;
import com.google.common.cache.LocalCache$EntryIterator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;

final class LocalCache$EntrySet extends LocalCache$AbstractCacheSet {
   // $FF: synthetic field
   final LocalCache this$0;

   LocalCache$EntrySet(LocalCache var1, ConcurrentMap var2) {
      super(var1, var2);
      this.this$0 = var1;
   }

   public Iterator iterator() {
      return new LocalCache$EntryIterator(this.this$0);
   }

   public boolean contains(Object var1) {
      if(!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         Object var3 = var2.getKey();
         if(var3 == null) {
            return false;
         } else {
            Object var4 = this.this$0.get(var3);
            return var4 != null && this.this$0.valueEquivalence.equivalent(var2.getValue(), var4);
         }
      }
   }

   public boolean remove(Object var1) {
      if(!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         Object var3 = var2.getKey();
         return var3 != null && this.this$0.remove(var3, var2.getValue());
      }
   }
}
