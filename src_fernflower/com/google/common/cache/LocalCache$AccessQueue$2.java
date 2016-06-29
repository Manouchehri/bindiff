package com.google.common.cache;

import com.google.common.cache.LocalCache$AccessQueue;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.collect.AbstractSequentialIterator;

class LocalCache$AccessQueue$2 extends AbstractSequentialIterator {
   // $FF: synthetic field
   final LocalCache$AccessQueue this$0;

   LocalCache$AccessQueue$2(LocalCache$AccessQueue var1, LocalCache$ReferenceEntry var2) {
      super(var2);
      this.this$0 = var1;
   }

   protected LocalCache$ReferenceEntry computeNext(LocalCache$ReferenceEntry var1) {
      LocalCache$ReferenceEntry var2 = var1.getNextInAccessQueue();
      return var2 == this.this$0.head?null:var2;
   }
}
