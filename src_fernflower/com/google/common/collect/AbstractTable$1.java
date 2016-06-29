package com.google.common.collect;

import com.google.common.collect.AbstractTable;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;

class AbstractTable$1 extends TransformedIterator {
   // $FF: synthetic field
   final AbstractTable this$0;

   AbstractTable$1(AbstractTable var1, Iterator var2) {
      super(var2);
      this.this$0 = var1;
   }

   Object transform(Table$Cell var1) {
      return var1.getValue();
   }
}
