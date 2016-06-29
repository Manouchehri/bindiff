package com.google.common.collect;

import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets$ElementSet;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;

class Multisets$ElementSet$1 extends TransformedIterator {
   // $FF: synthetic field
   final Multisets$ElementSet this$0;

   Multisets$ElementSet$1(Multisets$ElementSet var1, Iterator var2) {
      super(var2);
      this.this$0 = var1;
   }

   Object transform(Multiset$Entry var1) {
      return var1.getElement();
   }
}
