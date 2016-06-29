package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multimaps$UnmodifiableMultimap$1;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

class Multimaps$UnmodifiableMultimap extends ForwardingMultimap implements Serializable {
   final Multimap delegate;
   transient Collection entries;
   transient Multiset keys;
   transient Set keySet;
   transient Collection values;
   transient Map map;
   private static final long serialVersionUID = 0L;

   Multimaps$UnmodifiableMultimap(Multimap var1) {
      this.delegate = (Multimap)Preconditions.checkNotNull(var1);
   }

   protected Multimap delegate() {
      return this.delegate;
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public Map asMap() {
      Map var1 = this.map;
      if(var1 == null) {
         var1 = this.map = Collections.unmodifiableMap(Maps.transformValues((Map)this.delegate.asMap(), new Multimaps$UnmodifiableMultimap$1(this)));
      }

      return var1;
   }

   public Collection entries() {
      Collection var1 = this.entries;
      if(var1 == null) {
         this.entries = var1 = Multimaps.access$100(this.delegate.entries());
      }

      return var1;
   }

   public Collection get(Object var1) {
      return Multimaps.access$000(this.delegate.get(var1));
   }

   public Multiset keys() {
      Multiset var1 = this.keys;
      if(var1 == null) {
         this.keys = var1 = Multisets.unmodifiableMultiset(this.delegate.keys());
      }

      return var1;
   }

   public Set keySet() {
      Set var1 = this.keySet;
      if(var1 == null) {
         this.keySet = var1 = Collections.unmodifiableSet(this.delegate.keySet());
      }

      return var1;
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
      throw new UnsupportedOperationException();
   }

   public Collection removeAll(Object var1) {
      throw new UnsupportedOperationException();
   }

   public Collection replaceValues(Object var1, Iterable var2) {
      throw new UnsupportedOperationException();
   }

   public Collection values() {
      Collection var1 = this.values;
      if(var1 == null) {
         this.values = var1 = Collections.unmodifiableCollection(this.delegate.values());
      }

      return var1;
   }
}
