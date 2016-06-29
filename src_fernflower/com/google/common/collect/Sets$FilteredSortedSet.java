package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets$FilteredSet;
import java.util.Comparator;
import java.util.SortedSet;

class Sets$FilteredSortedSet extends Sets$FilteredSet implements SortedSet {
   Sets$FilteredSortedSet(SortedSet var1, Predicate var2) {
      super(var1, var2);
   }

   public Comparator comparator() {
      return ((SortedSet)this.unfiltered).comparator();
   }

   public SortedSet subSet(Object var1, Object var2) {
      return new Sets$FilteredSortedSet(((SortedSet)this.unfiltered).subSet(var1, var2), this.predicate);
   }

   public SortedSet headSet(Object var1) {
      return new Sets$FilteredSortedSet(((SortedSet)this.unfiltered).headSet(var1), this.predicate);
   }

   public SortedSet tailSet(Object var1) {
      return new Sets$FilteredSortedSet(((SortedSet)this.unfiltered).tailSet(var1), this.predicate);
   }

   public Object first() {
      return this.iterator().next();
   }

   public Object last() {
      SortedSet var1 = (SortedSet)this.unfiltered;

      while(true) {
         Object var2 = var1.last();
         if(this.predicate.apply(var2)) {
            return var2;
         }

         var1 = var1.headSet(var2);
      }
   }
}
