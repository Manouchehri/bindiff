package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.AbstractSortedMultiset$1DescendingMultisetImpl;
import com.google.common.collect.BoundType;
import com.google.common.collect.GwtTransient;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.SortedMultisets$NavigableElementSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
abstract class AbstractSortedMultiset extends AbstractMultiset implements SortedMultiset {
   @GwtTransient
   final Comparator comparator;
   private transient SortedMultiset descendingMultiset;

   AbstractSortedMultiset() {
      this(Ordering.natural());
   }

   AbstractSortedMultiset(Comparator var1) {
      this.comparator = (Comparator)Preconditions.checkNotNull(var1);
   }

   public NavigableSet elementSet() {
      return (NavigableSet)super.elementSet();
   }

   NavigableSet createElementSet() {
      return new SortedMultisets$NavigableElementSet(this);
   }

   public Comparator comparator() {
      return this.comparator;
   }

   public Multiset$Entry firstEntry() {
      Iterator var1 = this.entryIterator();
      return var1.hasNext()?(Multiset$Entry)var1.next():null;
   }

   public Multiset$Entry lastEntry() {
      Iterator var1 = this.descendingEntryIterator();
      return var1.hasNext()?(Multiset$Entry)var1.next():null;
   }

   public Multiset$Entry pollFirstEntry() {
      Iterator var1 = this.entryIterator();
      if(var1.hasNext()) {
         Multiset$Entry var2 = (Multiset$Entry)var1.next();
         var2 = Multisets.immutableEntry(var2.getElement(), var2.getCount());
         var1.remove();
         return var2;
      } else {
         return null;
      }
   }

   public Multiset$Entry pollLastEntry() {
      Iterator var1 = this.descendingEntryIterator();
      if(var1.hasNext()) {
         Multiset$Entry var2 = (Multiset$Entry)var1.next();
         var2 = Multisets.immutableEntry(var2.getElement(), var2.getCount());
         var1.remove();
         return var2;
      } else {
         return null;
      }
   }

   public SortedMultiset subMultiset(@Nullable Object var1, BoundType var2, @Nullable Object var3, BoundType var4) {
      Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var4);
      return this.tailMultiset(var1, var2).headMultiset(var3, var4);
   }

   abstract Iterator descendingEntryIterator();

   Iterator descendingIterator() {
      return Multisets.iteratorImpl(this.descendingMultiset());
   }

   public SortedMultiset descendingMultiset() {
      SortedMultiset var1 = this.descendingMultiset;
      return var1 == null?(this.descendingMultiset = this.createDescendingMultiset()):var1;
   }

   SortedMultiset createDescendingMultiset() {
      return new AbstractSortedMultiset$1DescendingMultisetImpl(this);
   }
}
