package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap$Builder;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSetMultimap$BuilderMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;

public final class ImmutableSetMultimap$Builder extends ImmutableMultimap$Builder {
   public ImmutableSetMultimap$Builder() {
      this.builderMultimap = new ImmutableSetMultimap$BuilderMultimap();
   }

   public ImmutableSetMultimap$Builder put(Object var1, Object var2) {
      this.builderMultimap.put(Preconditions.checkNotNull(var1), Preconditions.checkNotNull(var2));
      return this;
   }

   public ImmutableSetMultimap$Builder put(Entry var1) {
      this.builderMultimap.put(Preconditions.checkNotNull(var1.getKey()), Preconditions.checkNotNull(var1.getValue()));
      return this;
   }

   @Beta
   public ImmutableSetMultimap$Builder putAll(Iterable var1) {
      super.putAll(var1);
      return this;
   }

   public ImmutableSetMultimap$Builder putAll(Object var1, Iterable var2) {
      Collection var3 = this.builderMultimap.get(Preconditions.checkNotNull(var1));
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         var3.add(Preconditions.checkNotNull(var5));
      }

      return this;
   }

   public ImmutableSetMultimap$Builder putAll(Object var1, Object... var2) {
      return this.putAll(var1, (Iterable)Arrays.asList(var2));
   }

   public ImmutableSetMultimap$Builder putAll(Multimap var1) {
      Iterator var2 = var1.asMap().entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.putAll(var3.getKey(), (Iterable)var3.getValue());
      }

      return this;
   }

   public ImmutableSetMultimap$Builder orderKeysBy(Comparator var1) {
      this.keyComparator = (Comparator)Preconditions.checkNotNull(var1);
      return this;
   }

   public ImmutableSetMultimap$Builder orderValuesBy(Comparator var1) {
      super.orderValuesBy(var1);
      return this;
   }

   public ImmutableSetMultimap build() {
      if(this.keyComparator != null) {
         ImmutableSetMultimap$BuilderMultimap var1 = new ImmutableSetMultimap$BuilderMultimap();
         ImmutableList var2 = Ordering.from(this.keyComparator).onKeys().immutableSortedCopy(this.builderMultimap.asMap().entrySet());
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            var1.putAll(var4.getKey(), (Iterable)var4.getValue());
         }

         this.builderMultimap = var1;
      }

      return ImmutableSetMultimap.access$000(this.builderMultimap, this.valueComparator);
   }
}
