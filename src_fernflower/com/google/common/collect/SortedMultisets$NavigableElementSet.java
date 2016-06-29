package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.SortedMultisets;
import com.google.common.collect.SortedMultisets$ElementSet;
import java.util.Iterator;
import java.util.NavigableSet;

@GwtIncompatible("Navigable")
class SortedMultisets$NavigableElementSet extends SortedMultisets$ElementSet implements NavigableSet {
   SortedMultisets$NavigableElementSet(SortedMultiset var1) {
      super(var1);
   }

   public Object lower(Object var1) {
      return SortedMultisets.access$100(this.multiset().headMultiset(var1, BoundType.OPEN).lastEntry());
   }

   public Object floor(Object var1) {
      return SortedMultisets.access$100(this.multiset().headMultiset(var1, BoundType.CLOSED).lastEntry());
   }

   public Object ceiling(Object var1) {
      return SortedMultisets.access$100(this.multiset().tailMultiset(var1, BoundType.CLOSED).firstEntry());
   }

   public Object higher(Object var1) {
      return SortedMultisets.access$100(this.multiset().tailMultiset(var1, BoundType.OPEN).firstEntry());
   }

   public NavigableSet descendingSet() {
      return new SortedMultisets$NavigableElementSet(this.multiset().descendingMultiset());
   }

   public Iterator descendingIterator() {
      return this.descendingSet().iterator();
   }

   public Object pollFirst() {
      return SortedMultisets.access$100(this.multiset().pollFirstEntry());
   }

   public Object pollLast() {
      return SortedMultisets.access$100(this.multiset().pollLastEntry());
   }

   public NavigableSet subSet(Object var1, boolean var2, Object var3, boolean var4) {
      return new SortedMultisets$NavigableElementSet(this.multiset().subMultiset(var1, BoundType.forBoolean(var2), var3, BoundType.forBoolean(var4)));
   }

   public NavigableSet headSet(Object var1, boolean var2) {
      return new SortedMultisets$NavigableElementSet(this.multiset().headMultiset(var1, BoundType.forBoolean(var2)));
   }

   public NavigableSet tailSet(Object var1, boolean var2) {
      return new SortedMultisets$NavigableElementSet(this.multiset().tailMultiset(var1, BoundType.forBoolean(var2)));
   }
}
