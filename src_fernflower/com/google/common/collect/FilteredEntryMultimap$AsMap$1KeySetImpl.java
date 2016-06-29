package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.FilteredEntryMultimap$AsMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$KeySet;
import java.util.Collection;
import javax.annotation.Nullable;

class FilteredEntryMultimap$AsMap$1KeySetImpl extends Maps$KeySet {
   // $FF: synthetic field
   final FilteredEntryMultimap$AsMap this$1;

   FilteredEntryMultimap$AsMap$1KeySetImpl(FilteredEntryMultimap$AsMap var1) {
      super(var1);
      this.this$1 = var1;
   }

   public boolean removeAll(Collection var1) {
      return this.this$1.this$0.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.in(var1)));
   }

   public boolean retainAll(Collection var1) {
      return this.this$1.this$0.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(var1))));
   }

   public boolean remove(@Nullable Object var1) {
      return this.this$1.remove(var1) != null;
   }
}
