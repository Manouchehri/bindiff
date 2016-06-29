package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.FilteredKeySetMultimap$EntrySet;
import com.google.common.collect.FilteredSetMultimap;
import com.google.common.collect.SetMultimap;
import java.util.Set;

@GwtCompatible
final class FilteredKeySetMultimap extends FilteredKeyMultimap implements FilteredSetMultimap {
   FilteredKeySetMultimap(SetMultimap var1, Predicate var2) {
      super(var1, var2);
   }

   public SetMultimap unfiltered() {
      return (SetMultimap)this.unfiltered;
   }

   public Set get(Object var1) {
      return (Set)super.get(var1);
   }

   public Set removeAll(Object var1) {
      return (Set)super.removeAll(var1);
   }

   public Set replaceValues(Object var1, Iterable var2) {
      return (Set)super.replaceValues(var1, var2);
   }

   public Set entries() {
      return (Set)super.entries();
   }

   Set createEntries() {
      return new FilteredKeySetMultimap$EntrySet(this);
   }
}
