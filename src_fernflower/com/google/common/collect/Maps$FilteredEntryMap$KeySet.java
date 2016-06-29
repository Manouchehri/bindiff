package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$KeySet;
import java.util.Collection;

class Maps$FilteredEntryMap$KeySet extends Maps$KeySet {
   // $FF: synthetic field
   final Maps$FilteredEntryMap this$0;

   Maps$FilteredEntryMap$KeySet(Maps$FilteredEntryMap var1) {
      super(var1);
      this.this$0 = var1;
   }

   public boolean remove(Object var1) {
      if(this.this$0.containsKey(var1)) {
         this.this$0.unfiltered.remove(var1);
         return true;
      } else {
         return false;
      }
   }

   private boolean removeIf(Predicate var1) {
      return Iterables.removeIf(this.this$0.unfiltered.entrySet(), Predicates.and(this.this$0.predicate, Maps.keyPredicateOnEntries(var1)));
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
