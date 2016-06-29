package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraints;
import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints;
import com.google.common.collect.MapConstraints$ConstrainedMultimap$1;
import com.google.common.collect.MapConstraints$ConstrainedMultimap$1AsMap;
import com.google.common.collect.Multimap;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class MapConstraints$ConstrainedMultimap extends ForwardingMultimap implements Serializable {
   final MapConstraint constraint;
   final Multimap delegate;
   @LazyInit
   transient Collection entries;
   @LazyInit
   transient Map asMap;

   public MapConstraints$ConstrainedMultimap(Multimap var1, MapConstraint var2) {
      this.delegate = (Multimap)Preconditions.checkNotNull(var1);
      this.constraint = (MapConstraint)Preconditions.checkNotNull(var2);
   }

   protected Multimap delegate() {
      return this.delegate;
   }

   public Map asMap() {
      Object var1 = this.asMap;
      if(var1 == null) {
         Map var2 = this.delegate.asMap();
         this.asMap = (Map)(var1 = new MapConstraints$ConstrainedMultimap$1AsMap(this, var2));
      }

      return (Map)var1;
   }

   public Collection entries() {
      Collection var1 = this.entries;
      if(var1 == null) {
         this.entries = var1 = MapConstraints.access$300(this.delegate.entries(), this.constraint);
      }

      return var1;
   }

   public Collection get(Object var1) {
      return Constraints.constrainedTypePreservingCollection(this.delegate.get(var1), new MapConstraints$ConstrainedMultimap$1(this, var1));
   }

   public boolean put(Object var1, Object var2) {
      this.constraint.checkKeyValue(var1, var2);
      return this.delegate.put(var1, var2);
   }

   public boolean putAll(Object var1, Iterable var2) {
      return this.delegate.putAll(var1, MapConstraints.access$400(var1, var2, this.constraint));
   }

   public boolean putAll(Multimap var1) {
      boolean var2 = false;

      Entry var4;
      for(Iterator var3 = var1.entries().iterator(); var3.hasNext(); var2 |= this.put(var4.getKey(), var4.getValue())) {
         var4 = (Entry)var3.next();
      }

      return var2;
   }

   public Collection replaceValues(Object var1, Iterable var2) {
      return this.delegate.replaceValues(var1, MapConstraints.access$400(var1, var2, this.constraint));
   }
}
