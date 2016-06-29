package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.Multisets$ElementSet;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.SortedMultisets;
import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.SortedSet;

class SortedMultisets$ElementSet extends Multisets$ElementSet implements SortedSet {
   @Weak
   private final SortedMultiset multiset;

   SortedMultisets$ElementSet(SortedMultiset var1) {
      this.multiset = var1;
   }

   final SortedMultiset multiset() {
      return this.multiset;
   }

   public Comparator comparator() {
      return this.multiset().comparator();
   }

   public SortedSet subSet(Object var1, Object var2) {
      return this.multiset().subMultiset(var1, BoundType.CLOSED, var2, BoundType.OPEN).elementSet();
   }

   public SortedSet headSet(Object var1) {
      return this.multiset().headMultiset(var1, BoundType.OPEN).elementSet();
   }

   public SortedSet tailSet(Object var1) {
      return this.multiset().tailMultiset(var1, BoundType.CLOSED).elementSet();
   }

   public Object first() {
      return SortedMultisets.access$000(this.multiset().firstEntry());
   }

   public Object last() {
      return SortedMultisets.access$000(this.multiset().lastEntry());
   }
}
