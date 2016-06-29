package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.DescendingMultiset$1EntrySetImpl;
import com.google.common.collect.ForwardingMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.SortedMultisets$NavigableElementSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

@GwtCompatible(
   emulated = true
)
abstract class DescendingMultiset extends ForwardingMultiset implements SortedMultiset {
   private transient Comparator comparator;
   private transient NavigableSet elementSet;
   private transient Set entrySet;

   abstract SortedMultiset forwardMultiset();

   public Comparator comparator() {
      Comparator var1 = this.comparator;
      return var1 == null?(this.comparator = Ordering.from(this.forwardMultiset().comparator()).reverse()):var1;
   }

   public NavigableSet elementSet() {
      NavigableSet var1 = this.elementSet;
      return var1 == null?(this.elementSet = new SortedMultisets$NavigableElementSet(this)):var1;
   }

   public Multiset$Entry pollFirstEntry() {
      return this.forwardMultiset().pollLastEntry();
   }

   public Multiset$Entry pollLastEntry() {
      return this.forwardMultiset().pollFirstEntry();
   }

   public SortedMultiset headMultiset(Object var1, BoundType var2) {
      return this.forwardMultiset().tailMultiset(var1, var2).descendingMultiset();
   }

   public SortedMultiset subMultiset(Object var1, BoundType var2, Object var3, BoundType var4) {
      return this.forwardMultiset().subMultiset(var3, var4, var1, var2).descendingMultiset();
   }

   public SortedMultiset tailMultiset(Object var1, BoundType var2) {
      return this.forwardMultiset().headMultiset(var1, var2).descendingMultiset();
   }

   protected Multiset delegate() {
      return this.forwardMultiset();
   }

   public SortedMultiset descendingMultiset() {
      return this.forwardMultiset();
   }

   public Multiset$Entry firstEntry() {
      return this.forwardMultiset().lastEntry();
   }

   public Multiset$Entry lastEntry() {
      return this.forwardMultiset().firstEntry();
   }

   abstract Iterator entryIterator();

   public Set entrySet() {
      Set var1 = this.entrySet;
      return var1 == null?(this.entrySet = this.createEntrySet()):var1;
   }

   Set createEntrySet() {
      return new DescendingMultiset$1EntrySetImpl(this);
   }

   public Iterator iterator() {
      return Multisets.iteratorImpl(this);
   }

   public Object[] toArray() {
      return this.standardToArray();
   }

   public Object[] toArray(Object[] var1) {
      return this.standardToArray(var1);
   }

   public String toString() {
      return this.entrySet().toString();
   }
}
