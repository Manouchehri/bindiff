package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.FilteredKeyMultimap$AddRejectingList;
import com.google.common.collect.FilteredKeyMultimap$AddRejectingSet;
import com.google.common.collect.FilteredKeyMultimap$Entries;
import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.FilteredMultimapValues;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class FilteredKeyMultimap extends AbstractMultimap implements FilteredMultimap {
   final Multimap unfiltered;
   final Predicate keyPredicate;

   FilteredKeyMultimap(Multimap var1, Predicate var2) {
      this.unfiltered = (Multimap)Preconditions.checkNotNull(var1);
      this.keyPredicate = (Predicate)Preconditions.checkNotNull(var2);
   }

   public Multimap unfiltered() {
      return this.unfiltered;
   }

   public Predicate entryPredicate() {
      return Maps.keyPredicateOnEntries(this.keyPredicate);
   }

   public int size() {
      int var1 = 0;

      Collection var3;
      for(Iterator var2 = this.asMap().values().iterator(); var2.hasNext(); var1 += var3.size()) {
         var3 = (Collection)var2.next();
      }

      return var1;
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.unfiltered.containsKey(var1)?this.keyPredicate.apply(var1):false;
   }

   public Collection removeAll(Object var1) {
      return this.containsKey(var1)?this.unfiltered.removeAll(var1):this.unmodifiableEmptyCollection();
   }

   Collection unmodifiableEmptyCollection() {
      return (Collection)(this.unfiltered instanceof SetMultimap?ImmutableSet.of():ImmutableList.of());
   }

   public void clear() {
      this.keySet().clear();
   }

   Set createKeySet() {
      return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
   }

   public Collection get(Object var1) {
      return (Collection)(this.keyPredicate.apply(var1)?this.unfiltered.get(var1):(this.unfiltered instanceof SetMultimap?new FilteredKeyMultimap$AddRejectingSet(var1):new FilteredKeyMultimap$AddRejectingList(var1)));
   }

   Iterator entryIterator() {
      throw new AssertionError("should never be called");
   }

   Collection createEntries() {
      return new FilteredKeyMultimap$Entries(this);
   }

   Collection createValues() {
      return new FilteredMultimapValues(this);
   }

   Map createAsMap() {
      return Maps.filterKeys(this.unfiltered.asMap(), this.keyPredicate);
   }

   Multiset createKeys() {
      return Multisets.filter(this.unfiltered.keys(), this.keyPredicate);
   }
}
