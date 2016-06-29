package com.google.common.collect;

import com.google.common.collect.Lists$TransformingRandomAccessList;
import com.google.common.collect.TransformedListIterator;
import java.util.ListIterator;

class Lists$TransformingRandomAccessList$1 extends TransformedListIterator {
   // $FF: synthetic field
   final Lists$TransformingRandomAccessList this$0;

   Lists$TransformingRandomAccessList$1(Lists$TransformingRandomAccessList var1, ListIterator var2) {
      super(var2);
      this.this$0 = var1;
   }

   Object transform(Object var1) {
      return this.this$0.function.apply(var1);
   }
}
