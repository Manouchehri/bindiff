package com.google.common.collect;

import com.google.common.collect.StandardTable$Row;
import com.google.common.collect.StandardTable$Row$1$1;
import java.util.Iterator;
import java.util.Map.Entry;

class StandardTable$Row$1 implements Iterator {
   // $FF: synthetic field
   final Iterator val$iterator;
   // $FF: synthetic field
   final StandardTable$Row this$1;

   StandardTable$Row$1(StandardTable$Row var1, Iterator var2) {
      this.this$1 = var1;
      this.val$iterator = var2;
   }

   public boolean hasNext() {
      return this.val$iterator.hasNext();
   }

   public Entry next() {
      Entry var1 = (Entry)this.val$iterator.next();
      return new StandardTable$Row$1$1(this, var1);
   }

   public void remove() {
      this.val$iterator.remove();
      this.this$1.maintainEmptyInvariant();
   }
}
