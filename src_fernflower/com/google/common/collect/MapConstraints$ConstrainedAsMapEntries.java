package com.google.common.collect;

import com.google.common.collect.ForwardingSet;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedAsMapEntries$1;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

class MapConstraints$ConstrainedAsMapEntries extends ForwardingSet {
   private final MapConstraint constraint;
   private final Set entries;

   MapConstraints$ConstrainedAsMapEntries(Set var1, MapConstraint var2) {
      this.entries = var1;
      this.constraint = var2;
   }

   protected Set delegate() {
      return this.entries;
   }

   public Iterator iterator() {
      return new MapConstraints$ConstrainedAsMapEntries$1(this, this.entries.iterator());
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

   public boolean equals(@Nullable Object var1) {
      return this.standardEquals(var1);
   }

   public int hashCode() {
      return this.standardHashCode();
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

   // $FF: synthetic method
   static MapConstraint access$600(MapConstraints$ConstrainedAsMapEntries var0) {
      return var0.constraint;
   }
}
