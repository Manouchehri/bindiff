package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.FilteredEntryMultimap$Keys$1;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Map.Entry;

class FilteredEntryMultimap$Keys$1$1 implements Predicate {
   // $FF: synthetic field
   final Predicate val$predicate;
   // $FF: synthetic field
   final FilteredEntryMultimap$Keys$1 this$2;

   FilteredEntryMultimap$Keys$1$1(FilteredEntryMultimap$Keys$1 var1, Predicate var2) {
      this.this$2 = var1;
      this.val$predicate = var2;
   }

   public boolean apply(Entry var1) {
      return this.val$predicate.apply(Multisets.immutableEntry(var1.getKey(), ((Collection)var1.getValue()).size()));
   }
}
