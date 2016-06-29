package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$BuilderMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class ImmutableMultimap$Builder {
   Multimap builderMultimap = new ImmutableMultimap$BuilderMultimap();
   Comparator keyComparator;
   Comparator valueComparator;

   public ImmutableMultimap$Builder put(Object var1, Object var2) {
      CollectPreconditions.checkEntryNotNull(var1, var2);
      this.builderMultimap.put(var1, var2);
      return this;
   }

   public ImmutableMultimap$Builder put(Entry var1) {
      return this.put(var1.getKey(), var1.getValue());
   }

   @Beta
   public ImmutableMultimap$Builder putAll(Iterable var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.put(var3);
      }

      return this;
   }

   public ImmutableMultimap$Builder putAll(Object var1, Iterable var2) {
      // $FF: Couldn't be decompiled
   }

   public ImmutableMultimap$Builder putAll(Object var1, Object... var2) {
      return this.putAll(var1, (Iterable)Arrays.asList(var2));
   }

   public ImmutableMultimap$Builder putAll(Multimap var1) {
      Iterator var2 = var1.asMap().entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.putAll(var3.getKey(), (Iterable)var3.getValue());
      }

      return this;
   }

   public ImmutableMultimap$Builder orderKeysBy(Comparator var1) {
      this.keyComparator = (Comparator)Preconditions.checkNotNull(var1);
      return this;
   }

   public ImmutableMultimap$Builder orderValuesBy(Comparator var1) {
      this.valueComparator = (Comparator)Preconditions.checkNotNull(var1);
      return this;
   }

   public ImmutableMultimap build() {
      if(this.valueComparator != null) {
         Iterator var1 = this.builderMultimap.asMap().values().iterator();

         while(var1.hasNext()) {
            Collection var2 = (Collection)var1.next();
            List var3 = (List)var2;
            Collections.sort(var3, this.valueComparator);
         }
      }

      if(this.keyComparator != null) {
         ImmutableMultimap$BuilderMultimap var5 = new ImmutableMultimap$BuilderMultimap();
         ImmutableList var6 = Ordering.from(this.keyComparator).onKeys().immutableSortedCopy(this.builderMultimap.asMap().entrySet());
         Iterator var7 = var6.iterator();

         while(var7.hasNext()) {
            Entry var4 = (Entry)var7.next();
            var5.putAll(var4.getKey(), (Iterable)var4.getValue());
         }

         this.builderMultimap = var5;
      }

      return ImmutableMultimap.copyOf(this.builderMultimap);
   }
}
