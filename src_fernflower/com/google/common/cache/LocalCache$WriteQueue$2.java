package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$WriteQueue;
import com.google.common.collect.AbstractSequentialIterator;

class LocalCache$WriteQueue$2 extends AbstractSequentialIterator {
   // $FF: synthetic field
   final LocalCache$WriteQueue this$0;

   LocalCache$WriteQueue$2(LocalCache$WriteQueue var1, LocalCache$ReferenceEntry var2) {
      super(var2);
      this.this$0 = var1;
   }

   protected LocalCache$ReferenceEntry computeNext(LocalCache$ReferenceEntry var1) {
      LocalCache$ReferenceEntry var2 = var1.getNextInWriteQueue();
      return var2 == this.this$0.head?null:var2;
   }
}
