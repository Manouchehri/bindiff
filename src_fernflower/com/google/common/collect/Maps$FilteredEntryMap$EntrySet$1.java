package com.google.common.collect;

import com.google.common.collect.Maps$FilteredEntryMap$EntrySet;
import com.google.common.collect.Maps$FilteredEntryMap$EntrySet$1$1;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map.Entry;

class Maps$FilteredEntryMap$EntrySet$1 extends TransformedIterator {
   // $FF: synthetic field
   final Maps$FilteredEntryMap$EntrySet this$1;

   Maps$FilteredEntryMap$EntrySet$1(Maps$FilteredEntryMap$EntrySet var1, Iterator var2) {
      super(var2);
      this.this$1 = var1;
   }

   Entry transform(Entry var1) {
      return new Maps$FilteredEntryMap$EntrySet$1$1(this, var1);
   }
}
