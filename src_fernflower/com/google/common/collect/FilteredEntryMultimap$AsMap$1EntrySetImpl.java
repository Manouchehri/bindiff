package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.FilteredEntryMultimap$AsMap;
import com.google.common.collect.FilteredEntryMultimap$AsMap$1EntrySetImpl$1;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps$EntrySet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class FilteredEntryMultimap$AsMap$1EntrySetImpl extends Maps$EntrySet {
   // $FF: synthetic field
   final FilteredEntryMultimap$AsMap this$1;

   FilteredEntryMultimap$AsMap$1EntrySetImpl(FilteredEntryMultimap$AsMap var1) {
      this.this$1 = var1;
   }

   Map map() {
      return this.this$1;
   }

   public Iterator iterator() {
      return new FilteredEntryMultimap$AsMap$1EntrySetImpl$1(this);
   }

   public boolean removeAll(Collection var1) {
      return this.this$1.this$0.removeEntriesIf(Predicates.in(var1));
   }

   public boolean retainAll(Collection var1) {
      return this.this$1.this$0.removeEntriesIf(Predicates.not(Predicates.in(var1)));
   }

   public int size() {
      return Iterators.size(this.iterator());
   }
}
