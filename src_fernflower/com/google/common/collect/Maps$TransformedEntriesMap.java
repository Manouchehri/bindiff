package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import com.google.common.collect.Maps$Values;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Maps$TransformedEntriesMap extends Maps$IteratorBasedAbstractMap {
   final Map fromMap;
   final Maps$EntryTransformer transformer;

   Maps$TransformedEntriesMap(Map var1, Maps$EntryTransformer var2) {
      this.fromMap = (Map)Preconditions.checkNotNull(var1);
      this.transformer = (Maps$EntryTransformer)Preconditions.checkNotNull(var2);
   }

   public int size() {
      return this.fromMap.size();
   }

   public boolean containsKey(Object var1) {
      return this.fromMap.containsKey(var1);
   }

   public Object get(Object var1) {
      Object var2 = this.fromMap.get(var1);
      return var2 == null && !this.fromMap.containsKey(var1)?null:this.transformer.transformEntry(var1, var2);
   }

   public Object remove(Object var1) {
      return this.fromMap.containsKey(var1)?this.transformer.transformEntry(var1, this.fromMap.remove(var1)):null;
   }

   public void clear() {
      this.fromMap.clear();
   }

   public Set keySet() {
      return this.fromMap.keySet();
   }

   Iterator entryIterator() {
      return Iterators.transform(this.fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(this.transformer));
   }

   public Collection values() {
      return new Maps$Values(this);
   }
}
