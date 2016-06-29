package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ImmutableMap$Builder {
   Comparator valueComparator;
   ImmutableMapEntry[] entries;
   int size;
   boolean entriesUsed;

   public ImmutableMap$Builder() {
      this(4);
   }

   ImmutableMap$Builder(int var1) {
      this.entries = new ImmutableMapEntry[var1];
      this.size = 0;
      this.entriesUsed = false;
   }

   private void ensureCapacity(int var1) {
      if(var1 > this.entries.length) {
         this.entries = (ImmutableMapEntry[])ObjectArrays.arraysCopyOf(this.entries, ImmutableCollection$Builder.expandedCapacity(this.entries.length, var1));
         this.entriesUsed = false;
      }

   }

   public ImmutableMap$Builder put(Object var1, Object var2) {
      this.ensureCapacity(this.size + 1);
      ImmutableMapEntry var3 = ImmutableMap.entryOf(var1, var2);
      this.entries[this.size++] = var3;
      return this;
   }

   public ImmutableMap$Builder put(Entry var1) {
      return this.put(var1.getKey(), var1.getValue());
   }

   public ImmutableMap$Builder putAll(Map var1) {
      this.ensureCapacity(this.size + var1.size());
      return this.putAll((Iterable)var1.entrySet());
   }

   @Beta
   public ImmutableMap$Builder putAll(Iterable var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.put(var3);
      }

      return this;
   }

   @Beta
   public ImmutableMap$Builder orderEntriesByValue(Comparator var1) {
      Preconditions.checkState(this.valueComparator == null, "valueComparator was already set");
      this.valueComparator = (Comparator)Preconditions.checkNotNull(var1, "valueComparator");
      return this;
   }

   public ImmutableMap build() {
      switch(this.size) {
      case 0:
         return ImmutableMap.of();
      case 1:
         return ImmutableMap.of(this.entries[0].getKey(), this.entries[0].getValue());
      default:
         if(this.valueComparator != null) {
            if(this.entriesUsed) {
               this.entries = (ImmutableMapEntry[])ObjectArrays.arraysCopyOf(this.entries, this.size);
            }

            Arrays.sort(this.entries, 0, this.size, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
         }

         this.entriesUsed = this.size == this.entries.length;
         return RegularImmutableMap.fromEntryArray(this.size, this.entries);
      }
   }
}
