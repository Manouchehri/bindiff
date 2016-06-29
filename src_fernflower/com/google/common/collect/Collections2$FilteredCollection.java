package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

class Collections2$FilteredCollection extends AbstractCollection {
   final Collection unfiltered;
   final Predicate predicate;

   Collections2$FilteredCollection(Collection var1, Predicate var2) {
      this.unfiltered = var1;
      this.predicate = var2;
   }

   Collections2$FilteredCollection createCombined(Predicate var1) {
      return new Collections2$FilteredCollection(this.unfiltered, Predicates.and(this.predicate, var1));
   }

   public boolean add(Object var1) {
      Preconditions.checkArgument(this.predicate.apply(var1));
      return this.unfiltered.add(var1);
   }

   public boolean addAll(Collection var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         Preconditions.checkArgument(this.predicate.apply(var3));
      }

      return this.unfiltered.addAll(var1);
   }

   public void clear() {
      Iterables.removeIf(this.unfiltered, this.predicate);
   }

   public boolean contains(@Nullable Object var1) {
      return Collections2.safeContains(this.unfiltered, var1)?this.predicate.apply(var1):false;
   }

   public boolean containsAll(Collection var1) {
      return Collections2.containsAllImpl(this, var1);
   }

   public boolean isEmpty() {
      return !Iterables.any(this.unfiltered, this.predicate);
   }

   public Iterator iterator() {
      return Iterators.filter(this.unfiltered.iterator(), this.predicate);
   }

   public boolean remove(Object var1) {
      return this.contains(var1) && this.unfiltered.remove(var1);
   }

   public boolean removeAll(Collection var1) {
      return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.in(var1)));
   }

   public boolean retainAll(Collection var1) {
      return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.not(Predicates.in(var1))));
   }

   public int size() {
      return Iterators.size(this.iterator());
   }

   public Object[] toArray() {
      return Lists.newArrayList(this.iterator()).toArray();
   }

   public Object[] toArray(Object[] var1) {
      return Lists.newArrayList(this.iterator()).toArray(var1);
   }
}
