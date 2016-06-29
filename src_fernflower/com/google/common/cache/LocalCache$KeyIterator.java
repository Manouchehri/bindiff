package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$HashIterator;

final class LocalCache$KeyIterator extends LocalCache$HashIterator {
   // $FF: synthetic field
   final LocalCache this$0;

   LocalCache$KeyIterator(LocalCache var1) {
      super(var1);
      this.this$0 = var1;
   }

   public Object next() {
      return this.nextEntry().getKey();
   }
}
