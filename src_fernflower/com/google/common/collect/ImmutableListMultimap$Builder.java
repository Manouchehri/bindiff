package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap$Builder;
import com.google.common.collect.Multimap;
import java.util.Comparator;
import java.util.Map.Entry;

public final class ImmutableListMultimap$Builder extends ImmutableMultimap$Builder {
   public ImmutableListMultimap$Builder put(Object var1, Object var2) {
      super.put(var1, var2);
      return this;
   }

   public ImmutableListMultimap$Builder put(Entry var1) {
      super.put(var1);
      return this;
   }

   @Beta
   public ImmutableListMultimap$Builder putAll(Iterable var1) {
      super.putAll(var1);
      return this;
   }

   public ImmutableListMultimap$Builder putAll(Object var1, Iterable var2) {
      super.putAll(var1, var2);
      return this;
   }

   public ImmutableListMultimap$Builder putAll(Object var1, Object... var2) {
      super.putAll(var1, var2);
      return this;
   }

   public ImmutableListMultimap$Builder putAll(Multimap var1) {
      super.putAll(var1);
      return this;
   }

   public ImmutableListMultimap$Builder orderKeysBy(Comparator var1) {
      super.orderKeysBy(var1);
      return this;
   }

   public ImmutableListMultimap$Builder orderValuesBy(Comparator var1) {
      super.orderValuesBy(var1);
      return this;
   }

   public ImmutableListMultimap build() {
      return (ImmutableListMultimap)super.build();
   }
}
