package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multisets$UnmodifiableMultiset;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedMultiset;
import java.util.Comparator;
import java.util.NavigableSet;

@GwtCompatible(
   emulated = true
)
final class UnmodifiableSortedMultiset extends Multisets$UnmodifiableMultiset implements SortedMultiset {
   private transient UnmodifiableSortedMultiset descendingMultiset;
   private static final long serialVersionUID = 0L;

   UnmodifiableSortedMultiset(SortedMultiset var1) {
      super(var1);
   }

   protected SortedMultiset delegate() {
      return (SortedMultiset)super.delegate();
   }

   public Comparator comparator() {
      return this.delegate().comparator();
   }

   NavigableSet createElementSet() {
      return Sets.unmodifiableNavigableSet(this.delegate().elementSet());
   }

   public NavigableSet elementSet() {
      return (NavigableSet)super.elementSet();
   }

   public SortedMultiset descendingMultiset() {
      UnmodifiableSortedMultiset var1 = this.descendingMultiset;
      if(var1 == null) {
         var1 = new UnmodifiableSortedMultiset(this.delegate().descendingMultiset());
         var1.descendingMultiset = this;
         return this.descendingMultiset = var1;
      } else {
         return var1;
      }
   }

   public Multiset$Entry firstEntry() {
      return this.delegate().firstEntry();
   }

   public Multiset$Entry lastEntry() {
      return this.delegate().lastEntry();
   }

   public Multiset$Entry pollFirstEntry() {
      throw new UnsupportedOperationException();
   }

   public Multiset$Entry pollLastEntry() {
      throw new UnsupportedOperationException();
   }

   public SortedMultiset headMultiset(Object var1, BoundType var2) {
      return Multisets.unmodifiableSortedMultiset(this.delegate().headMultiset(var1, var2));
   }

   public SortedMultiset subMultiset(Object var1, BoundType var2, Object var3, BoundType var4) {
      return Multisets.unmodifiableSortedMultiset(this.delegate().subMultiset(var1, var2, var3, var4));
   }

   public SortedMultiset tailMultiset(Object var1, BoundType var2) {
      return Multisets.unmodifiableSortedMultiset(this.delegate().tailMultiset(var1, var2));
   }
}
