package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public final class ImmutableBiMap$Builder extends ImmutableMap$Builder {
   public ImmutableBiMap$Builder() {
   }

   ImmutableBiMap$Builder(int var1) {
      super(var1);
   }

   public ImmutableBiMap$Builder put(Object var1, Object var2) {
      super.put(var1, var2);
      return this;
   }

   public ImmutableBiMap$Builder put(Entry var1) {
      super.put(var1);
      return this;
   }

   public ImmutableBiMap$Builder putAll(Map var1) {
      super.putAll(var1);
      return this;
   }

   @Beta
   public ImmutableBiMap$Builder putAll(Iterable var1) {
      super.putAll(var1);
      return this;
   }

   @Beta
   public ImmutableBiMap$Builder orderEntriesByValue(Comparator var1) {
      super.orderEntriesByValue(var1);
      return this;
   }

   public ImmutableBiMap build() {
      switch(this.size) {
      case 0:
         return ImmutableBiMap.of();
      case 1:
         return ImmutableBiMap.of(this.entries[0].getKey(), this.entries[0].getValue());
      default:
         if(this.valueComparator != null) {
            if(this.entriesUsed) {
               this.entries = (ImmutableMapEntry[])ObjectArrays.arraysCopyOf(this.entries, this.size);
            }

            Arrays.sort(this.entries, 0, this.size, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
         }

         this.entriesUsed = this.size == this.entries.length;
         return RegularImmutableBiMap.fromEntryArray(this.size, this.entries);
      }
   }
}
