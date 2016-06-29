package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$FilteredEntryNavigableMap;
import com.google.common.collect.Maps$NavigableKeySet;
import java.util.Collection;
import java.util.NavigableMap;

class Maps$FilteredEntryNavigableMap$1 extends Maps$NavigableKeySet {
   // $FF: synthetic field
   final Maps$FilteredEntryNavigableMap this$0;

   Maps$FilteredEntryNavigableMap$1(Maps$FilteredEntryNavigableMap var1, NavigableMap var2) {
      super(var2);
      this.this$0 = var1;
   }

   public boolean removeAll(Collection var1) {
      return Iterators.removeIf(Maps$FilteredEntryNavigableMap.access$700(this.this$0).entrySet().iterator(), Predicates.and(Maps$FilteredEntryNavigableMap.access$600(this.this$0), Maps.keyPredicateOnEntries(Predicates.in(var1))));
   }

   public boolean retainAll(Collection var1) {
      return Iterators.removeIf(Maps$FilteredEntryNavigableMap.access$700(this.this$0).entrySet().iterator(), Predicates.and(Maps$FilteredEntryNavigableMap.access$600(this.this$0), Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(var1)))));
   }
}
