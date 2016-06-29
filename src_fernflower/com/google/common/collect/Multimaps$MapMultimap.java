package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$AsMap;
import com.google.common.collect.Multimaps$MapMultimap$1;
import com.google.common.collect.SetMultimap;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Multimaps$MapMultimap extends AbstractMultimap implements SetMultimap, Serializable {
   final Map map;
   private static final long serialVersionUID = 7845222491160860175L;

   Multimaps$MapMultimap(Map var1) {
      this.map = (Map)Preconditions.checkNotNull(var1);
   }

   public int size() {
      return this.map.size();
   }

   public boolean containsKey(Object var1) {
      return this.map.containsKey(var1);
   }

   public boolean containsValue(Object var1) {
      return this.map.containsValue(var1);
   }

   public boolean containsEntry(Object var1, Object var2) {
      return this.map.entrySet().contains(Maps.immutableEntry(var1, var2));
   }

   public Set get(Object var1) {
      return new Multimaps$MapMultimap$1(this, var1);
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

   public Set replaceValues(Object var1, Iterable var2) {
      throw new UnsupportedOperationException();
   }

   public boolean remove(Object var1, Object var2) {
      return this.map.entrySet().remove(Maps.immutableEntry(var1, var2));
   }

   public Set removeAll(Object var1) {
      HashSet var2 = new HashSet(2);
      if(!this.map.containsKey(var1)) {
         return var2;
      } else {
         var2.add(this.map.remove(var1));
         return var2;
      }
   }

   public void clear() {
      this.map.clear();
   }

   public Set keySet() {
      return this.map.keySet();
   }

   public Collection values() {
      return this.map.values();
   }

   public Set entries() {
      return this.map.entrySet();
   }

   Iterator entryIterator() {
      return this.map.entrySet().iterator();
   }

   Map createAsMap() {
      return new Multimaps$AsMap(this);
   }

   public int hashCode() {
      return this.map.hashCode();
   }
}
