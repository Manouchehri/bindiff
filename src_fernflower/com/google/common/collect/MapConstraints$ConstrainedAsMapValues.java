package com.google.common.collect;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.MapConstraints$ConstrainedAsMapValues$1;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class MapConstraints$ConstrainedAsMapValues extends ForwardingCollection {
   final Collection delegate;
   final Set entrySet;

   MapConstraints$ConstrainedAsMapValues(Collection var1, Set var2) {
      this.delegate = var1;
      this.entrySet = var2;
   }

   protected Collection delegate() {
      return this.delegate;
   }

   public Iterator iterator() {
      Iterator var1 = this.entrySet.iterator();
      return new MapConstraints$ConstrainedAsMapValues$1(this, var1);
   }

   public Object[] toArray() {
      return this.standardToArray();
   }

   public Object[] toArray(Object[] var1) {
      return this.standardToArray(var1);
   }

   public boolean contains(Object var1) {
      return this.standardContains(var1);
   }

   public boolean containsAll(Collection var1) {
      return this.standardContainsAll(var1);
   }

   public boolean remove(Object var1) {
      return this.standardRemove(var1);
   }

   public boolean removeAll(Collection var1) {
      return this.standardRemoveAll(var1);
   }

   public boolean retainAll(Collection var1) {
      return this.standardRetainAll(var1);
   }
}
