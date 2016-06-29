package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableSortedMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class ImmutableSortedMap$Builder extends ImmutableMap$Builder {
   private final Comparator comparator;

   public ImmutableSortedMap$Builder(Comparator var1) {
      this.comparator = (Comparator)Preconditions.checkNotNull(var1);
   }

   public ImmutableSortedMap$Builder put(Object var1, Object var2) {
      super.put(var1, var2);
      return this;
   }

   public ImmutableSortedMap$Builder put(Entry var1) {
      super.put(var1);
      return this;
   }

   public ImmutableSortedMap$Builder putAll(Map var1) {
      super.putAll(var1);
      return this;
   }

   @Beta
   public ImmutableSortedMap$Builder putAll(Iterable var1) {
      super.putAll(var1);
      return this;
   }

   @Deprecated
   @Beta
   public ImmutableSortedMap$Builder orderEntriesByValue(Comparator var1) {
      throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
   }

   public ImmutableSortedMap build() {
      switch(this.size) {
      case 0:
         return ImmutableSortedMap.emptyMap(this.comparator);
      case 1:
         return ImmutableSortedMap.access$000(this.comparator, this.entries[0].getKey(), this.entries[0].getValue());
      default:
         return ImmutableSortedMap.access$100(this.comparator, false, this.entries, this.size);
      }
   }
}
