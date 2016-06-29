package com.google.common.collect;

import com.google.common.collect.Multimaps$Keys;
import com.google.common.collect.Multimaps$Keys$1$1;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map.Entry;

class Multimaps$Keys$1 extends TransformedIterator {
   // $FF: synthetic field
   final Multimaps$Keys this$0;

   Multimaps$Keys$1(Multimaps$Keys var1, Iterator var2) {
      super(var2);
      this.this$0 = var1;
   }

   Multiset$Entry transform(Entry var1) {
      return new Multimaps$Keys$1$1(this, var1);
   }
}
