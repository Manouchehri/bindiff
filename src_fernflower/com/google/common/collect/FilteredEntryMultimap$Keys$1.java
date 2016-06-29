package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FilteredEntryMultimap$Keys;
import com.google.common.collect.FilteredEntryMultimap$Keys$1$1;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$EntrySet;
import java.util.Collection;
import java.util.Iterator;

class FilteredEntryMultimap$Keys$1 extends Multisets$EntrySet {
   // $FF: synthetic field
   final FilteredEntryMultimap$Keys this$1;

   FilteredEntryMultimap$Keys$1(FilteredEntryMultimap$Keys var1) {
      this.this$1 = var1;
   }

   Multiset multiset() {
      return this.this$1;
   }

   public Iterator iterator() {
      return this.this$1.entryIterator();
   }

   public int size() {
      return this.this$1.this$0.keySet().size();
   }

   private boolean removeEntriesIf(Predicate var1) {
      return this.this$1.this$0.removeEntriesIf(new FilteredEntryMultimap$Keys$1$1(this, var1));
   }

   public boolean removeAll(Collection var1) {
      return this.removeEntriesIf(Predicates.in(var1));
   }

   public boolean retainAll(Collection var1) {
      return this.removeEntriesIf(Predicates.not(Predicates.in(var1)));
   }
}
