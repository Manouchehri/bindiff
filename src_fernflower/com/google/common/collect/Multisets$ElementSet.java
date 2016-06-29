package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$ElementSet$1;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import java.util.Collection;
import java.util.Iterator;

abstract class Multisets$ElementSet extends Sets$ImprovedAbstractSet {
   abstract Multiset multiset();

   public void clear() {
      this.multiset().clear();
   }

   public boolean contains(Object var1) {
      return this.multiset().contains(var1);
   }

   public boolean containsAll(Collection var1) {
      return this.multiset().containsAll(var1);
   }

   public boolean isEmpty() {
      return this.multiset().isEmpty();
   }

   public Iterator iterator() {
      return new Multisets$ElementSet$1(this, this.multiset().entrySet().iterator());
   }

   public boolean remove(Object var1) {
      return this.multiset().remove(var1, Integer.MAX_VALUE) > 0;
   }

   public int size() {
      return this.multiset().entrySet().size();
   }
}
