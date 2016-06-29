package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.Sets$PowerSet;
import com.google.common.collect.Sets$SubSet;
import java.util.Set;

class Sets$PowerSet$1 extends AbstractIndexedListIterator {
   // $FF: synthetic field
   final Sets$PowerSet this$0;

   Sets$PowerSet$1(Sets$PowerSet var1, int var2) {
      super(var2);
      this.this$0 = var1;
   }

   protected Set get(int var1) {
      return new Sets$SubSet(this.this$0.inputSet, var1);
   }
}
