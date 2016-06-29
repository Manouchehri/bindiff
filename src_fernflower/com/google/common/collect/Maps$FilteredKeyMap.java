package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps$AbstractFilteredMap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

class Maps$FilteredKeyMap extends Maps$AbstractFilteredMap {
   Predicate keyPredicate;

   Maps$FilteredKeyMap(Map var1, Predicate var2, Predicate var3) {
      super(var1, var3);
      this.keyPredicate = var2;
   }

   protected Set createEntrySet() {
      return Sets.filter(this.unfiltered.entrySet(), this.predicate);
   }

   Set createKeySet() {
      return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
   }

   public boolean containsKey(Object var1) {
      return this.unfiltered.containsKey(var1) && this.keyPredicate.apply(var1);
   }
}
