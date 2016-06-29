package com.google.common.collect;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedEntries$1;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;

class MapConstraints$ConstrainedEntries extends ForwardingCollection {
   final MapConstraint constraint;
   final Collection entries;

   MapConstraints$ConstrainedEntries(Collection var1, MapConstraint var2) {
      this.entries = var1;
      this.constraint = var2;
   }

   protected Collection delegate() {
      return this.entries;
   }

   public Iterator iterator() {
      return new MapConstraints$ConstrainedEntries$1(this, this.entries.iterator());
   }

   public Object[] toArray() {
      return this.standardToArray();
   }

   public Object[] toArray(Object[] var1) {
      return this.standardToArray(var1);
   }

   public boolean contains(Object var1) {
      return Maps.containsEntryImpl(this.delegate(), var1);
   }

   public boolean containsAll(Collection var1) {
      return this.standardContainsAll(var1);
   }

   public boolean remove(Object var1) {
      return Maps.removeEntryImpl(this.delegate(), var1);
   }

   public boolean removeAll(Collection var1) {
      return this.standardRemoveAll(var1);
   }

   public boolean retainAll(Collection var1) {
      return this.standardRetainAll(var1);
   }
}
