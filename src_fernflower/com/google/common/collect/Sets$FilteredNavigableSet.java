package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets$FilteredSortedSet;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableSet")
class Sets$FilteredNavigableSet extends Sets$FilteredSortedSet implements NavigableSet {
   Sets$FilteredNavigableSet(NavigableSet var1, Predicate var2) {
      super(var1, var2);
   }

   NavigableSet unfiltered() {
      return (NavigableSet)this.unfiltered;
   }

   @Nullable
   public Object lower(Object var1) {
      return Iterators.getNext(this.headSet(var1, false).descendingIterator(), (Object)null);
   }

   @Nullable
   public Object floor(Object var1) {
      return Iterators.getNext(this.headSet(var1, true).descendingIterator(), (Object)null);
   }

   public Object ceiling(Object var1) {
      return Iterables.getFirst(this.tailSet(var1, true), (Object)null);
   }

   public Object higher(Object var1) {
      return Iterables.getFirst(this.tailSet(var1, false), (Object)null);
   }

   public Object pollFirst() {
      return Iterables.removeFirstMatching(this.unfiltered(), this.predicate);
   }

   public Object pollLast() {
      return Iterables.removeFirstMatching(this.unfiltered().descendingSet(), this.predicate);
   }

   public NavigableSet descendingSet() {
      return Sets.filter(this.unfiltered().descendingSet(), this.predicate);
   }

   public Iterator descendingIterator() {
      return Iterators.filter(this.unfiltered().descendingIterator(), this.predicate);
   }

   public Object last() {
      return this.descendingIterator().next();
   }

   public NavigableSet subSet(Object var1, boolean var2, Object var3, boolean var4) {
      return Sets.filter(this.unfiltered().subSet(var1, var2, var3, var4), this.predicate);
   }

   public NavigableSet headSet(Object var1, boolean var2) {
      return Sets.filter(this.unfiltered().headSet(var1, var2), this.predicate);
   }

   public NavigableSet tailSet(Object var1, boolean var2) {
      return Sets.filter(this.unfiltered().tailSet(var1, var2), this.predicate);
   }
}
