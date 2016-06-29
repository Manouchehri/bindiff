package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingSortedSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

@GwtIncompatible("NavigableSet")
final class Sets$UnmodifiableNavigableSet extends ForwardingSortedSet implements Serializable, NavigableSet {
   private final NavigableSet delegate;
   private transient Sets$UnmodifiableNavigableSet descendingSet;
   private static final long serialVersionUID = 0L;

   Sets$UnmodifiableNavigableSet(NavigableSet var1) {
      this.delegate = (NavigableSet)Preconditions.checkNotNull(var1);
   }

   protected SortedSet delegate() {
      return Collections.unmodifiableSortedSet(this.delegate);
   }

   public Object lower(Object var1) {
      return this.delegate.lower(var1);
   }

   public Object floor(Object var1) {
      return this.delegate.floor(var1);
   }

   public Object ceiling(Object var1) {
      return this.delegate.ceiling(var1);
   }

   public Object higher(Object var1) {
      return this.delegate.higher(var1);
   }

   public Object pollFirst() {
      throw new UnsupportedOperationException();
   }

   public Object pollLast() {
      throw new UnsupportedOperationException();
   }

   public NavigableSet descendingSet() {
      Sets$UnmodifiableNavigableSet var1 = this.descendingSet;
      if(var1 == null) {
         var1 = this.descendingSet = new Sets$UnmodifiableNavigableSet(this.delegate.descendingSet());
         var1.descendingSet = this;
      }

      return var1;
   }

   public Iterator descendingIterator() {
      return Iterators.unmodifiableIterator(this.delegate.descendingIterator());
   }

   public NavigableSet subSet(Object var1, boolean var2, Object var3, boolean var4) {
      return Sets.unmodifiableNavigableSet(this.delegate.subSet(var1, var2, var3, var4));
   }

   public NavigableSet headSet(Object var1, boolean var2) {
      return Sets.unmodifiableNavigableSet(this.delegate.headSet(var1, var2));
   }

   public NavigableSet tailSet(Object var1, boolean var2) {
      return Sets.unmodifiableNavigableSet(this.delegate.tailSet(var1, var2));
   }
}
