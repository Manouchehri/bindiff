package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$TransformedEntriesMultimap$1;
import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Multimaps$TransformedEntriesMultimap extends AbstractMultimap {
   final Multimap fromMultimap;
   final Maps$EntryTransformer transformer;

   Multimaps$TransformedEntriesMultimap(Multimap var1, Maps$EntryTransformer var2) {
      this.fromMultimap = (Multimap)Preconditions.checkNotNull(var1);
      this.transformer = (Maps$EntryTransformer)Preconditions.checkNotNull(var2);
   }

   Collection transform(Object var1, Collection var2) {
      Function var3 = Maps.asValueToValueFunction(this.transformer, var1);
      return (Collection)(var2 instanceof List?Lists.transform((List)var2, var3):Collections2.transform(var2, var3));
   }

   Map createAsMap() {
      return Maps.transformEntries((Map)this.fromMultimap.asMap(), new Multimaps$TransformedEntriesMultimap$1(this));
   }

   public void clear() {
      this.fromMultimap.clear();
   }

   public boolean containsKey(Object var1) {
      return this.fromMultimap.containsKey(var1);
   }

   Iterator entryIterator() {
      return Iterators.transform(this.fromMultimap.entries().iterator(), Maps.asEntryToEntryFunction(this.transformer));
   }

   public Collection get(Object var1) {
      return this.transform(var1, this.fromMultimap.get(var1));
   }

   public boolean isEmpty() {
      return this.fromMultimap.isEmpty();
   }

   public Set keySet() {
      return this.fromMultimap.keySet();
   }

   public Multiset keys() {
      return this.fromMultimap.keys();
   }

   public boolean put(Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   public boolean putAll(Object var1, Iterable var2) {
      throw new UnsupportedOperationException();
   }

   public boolean putAll(Multimap var1) {
      throw new UnsupportedOperationException();
   }

   public boolean remove(Object var1, Object var2) {
      return this.get(var1).remove(var2);
   }

   public Collection removeAll(Object var1) {
      return this.transform(var1, this.fromMultimap.removeAll(var1));
   }

   public Collection replaceValues(Object var1, Iterable var2) {
      throw new UnsupportedOperationException();
   }

   public int size() {
      return this.fromMultimap.size();
   }

   Collection createValues() {
      return Collections2.transform(this.fromMultimap.entries(), Maps.asEntryToValueFunction(this.transformer));
   }
}
