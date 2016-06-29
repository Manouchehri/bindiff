package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$Values;
import java.util.Collection;
import java.util.Map;

final class Maps$FilteredMapValues extends Maps$Values {
   Map unfiltered;
   Predicate predicate;

   Maps$FilteredMapValues(Map var1, Map var2, Predicate var3) {
      super(var1);
      this.unfiltered = var2;
      this.predicate = var3;
   }

   public boolean remove(Object var1) {
      return Iterables.removeFirstMatching(this.unfiltered.entrySet(), Predicates.and(this.predicate, Maps.valuePredicateOnEntries(Predicates.equalTo(var1)))) != null;
   }

   private boolean removeIf(Predicate var1) {
      return Iterables.removeIf(this.unfiltered.entrySet(), Predicates.and(this.predicate, Maps.valuePredicateOnEntries(var1)));
   }

   public boolean removeAll(Collection var1) {
      return this.removeIf(Predicates.in(var1));
   }

   public boolean retainAll(Collection var1) {
      return this.removeIf(Predicates.not(Predicates.in(var1)));
   }

   public Object[] toArray() {
      return Lists.newArrayList(this.iterator()).toArray();
   }

   public Object[] toArray(Object[] var1) {
      return Lists.newArrayList(this.iterator()).toArray(var1);
   }
}
