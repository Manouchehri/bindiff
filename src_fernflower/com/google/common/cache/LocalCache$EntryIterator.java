package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$HashIterator;
import java.util.Map.Entry;

final class LocalCache$EntryIterator extends LocalCache$HashIterator {
   // $FF: synthetic field
   final LocalCache this$0;

   LocalCache$EntryIterator(LocalCache var1) {
      super(var1);
      this.this$0 = var1;
   }

   public Entry next() {
      return this.nextEntry();
   }
}
