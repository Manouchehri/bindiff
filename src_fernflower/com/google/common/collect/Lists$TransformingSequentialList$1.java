package com.google.common.collect;

import com.google.common.collect.Lists$TransformingSequentialList;
import com.google.common.collect.TransformedListIterator;
import java.util.ListIterator;

class Lists$TransformingSequentialList$1 extends TransformedListIterator {
   // $FF: synthetic field
   final Lists$TransformingSequentialList this$0;

   Lists$TransformingSequentialList$1(Lists$TransformingSequentialList var1, ListIterator var2) {
      super(var2);
      this.this$0 = var1;
   }

   Object transform(Object var1) {
      return this.this$0.function.apply(var1);
   }
}
