package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps$1;
import com.google.common.collect.Maps$AbstractFilteredMap;
import com.google.common.collect.Maps$FilteredEntryMap$EntrySet;
import com.google.common.collect.Maps$FilteredEntryMap$KeySet;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

class Maps$FilteredEntryMap extends Maps$AbstractFilteredMap {
   final Set filteredEntrySet;

   Maps$FilteredEntryMap(Map var1, Predicate var2) {
      super(var1, var2);
      this.filteredEntrySet = Sets.filter(var1.entrySet(), this.predicate);
   }

   protected Set createEntrySet() {
      return new Maps$FilteredEntryMap$EntrySet(this, (Maps$1)null);
   }

   Set createKeySet() {
      return new Maps$FilteredEntryMap$KeySet(this);
   }
}
