package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import java.util.Map.Entry;

final class Maps$FilteredEntryBiMap$1 implements Predicate {
   // $FF: synthetic field
   final Predicate val$forwardPredicate;

   Maps$FilteredEntryBiMap$1(Predicate var1) {
      this.val$forwardPredicate = var1;
   }

   public boolean apply(Entry var1) {
      return this.val$forwardPredicate.apply(Maps.immutableEntry(var1.getValue(), var1.getKey()));
   }
}
