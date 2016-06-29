package com.google.common.collect;

import com.google.common.collect.TransformedIterator;
import com.google.common.collect.WellBehavedMap$EntrySet;
import com.google.common.collect.WellBehavedMap$EntrySet$1$1;
import java.util.Iterator;
import java.util.Map.Entry;

class WellBehavedMap$EntrySet$1 extends TransformedIterator {
   // $FF: synthetic field
   final WellBehavedMap$EntrySet this$1;

   WellBehavedMap$EntrySet$1(WellBehavedMap$EntrySet var1, Iterator var2) {
      super(var2);
      this.this$1 = var1;
   }

   Entry transform(Object var1) {
      return new WellBehavedMap$EntrySet$1$1(this, var1);
   }
}
